package com.ssafy.backend.domain.map.service;

import java.util.List;

import com.ssafy.backend.domain.map.dto.AttractionDto.AttractionDescriptionDto;
import com.ssafy.backend.domain.map.dto.AttractionDto.AttractioninfoDto;
import com.ssafy.backend.domain.map.dto.GugunDto.GugunInfoDto;
import com.ssafy.backend.domain.map.dto.SidoDto.SidoInfoDto;

public interface MapService {
	List<SidoInfoDto> sido() throws Exception;
	List<GugunInfoDto> gugun(String sidoCode) throws Exception;
	List<AttractioninfoDto> attractionInfo(String areaCode, String gugunCode, String attarctionId, String keyword) throws Exception;
	AttractionDescriptionDto attractionDescription(String attractionId) throws Exception;
}
