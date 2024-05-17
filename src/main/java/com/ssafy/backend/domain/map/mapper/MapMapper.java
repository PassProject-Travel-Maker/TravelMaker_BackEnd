package com.ssafy.backend.domain.map.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.backend.domain.map.dto.AttractionDto.AttractionDescriptionDto;
import com.ssafy.backend.domain.map.dto.AttractionDto.AttractioninfoDto;
import com.ssafy.backend.domain.map.dto.GugunDto.GugunInfoDto;
import com.ssafy.backend.domain.map.dto.SidoDto.SidoInfoDto;

@Mapper
public interface MapMapper {
	List<SidoInfoDto> sido() throws Exception;
	List<GugunInfoDto> gugun(String sidoCode) throws Exception;
	List<AttractioninfoDto> attractionInfo(String areaCode, String gugunCode, String contentTypeId, String keyword) throws Exception;
	AttractionDescriptionDto attractionDescription(String contentId) throws Exception;
}
