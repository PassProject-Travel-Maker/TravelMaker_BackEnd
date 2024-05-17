package com.ssafy.backend.domain.map.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.backend.domain.map.dto.AttractionDto.AttractionDescriptionDto;
import com.ssafy.backend.domain.map.dto.AttractionDto.AttractioninfoDto;
import com.ssafy.backend.domain.map.dto.GugunDto.GugunInfoDto;
import com.ssafy.backend.domain.map.dto.SidoDto.SidoInfoDto;
import com.ssafy.backend.domain.map.mapper.MapMapper;

@Service
public class MapServiceImpl implements MapService{
	private MapMapper mapMapper;

	public MapServiceImpl(MapMapper mapMapper) {
		this.mapMapper = mapMapper;
	}

	@Override
	public List<SidoInfoDto> sido() throws Exception {
		return mapMapper.sido();
	}

	@Override
	public List<AttractioninfoDto> attractionInfo(String areaCode, String gugunCode, String contentTypeId, String keyword) throws Exception {
		return mapMapper.attractionInfo(areaCode, gugunCode, contentTypeId, keyword);
	}

	@Override
	public AttractionDescriptionDto attractionDescription(String attractionId) throws Exception {
		return mapMapper.attractionDescription(attractionId);
	}

	@Override
	public List<GugunInfoDto> gugun(String sidoCode) throws Exception {
		return mapMapper.gugun(sidoCode);
	}
}
