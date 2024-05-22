package com.ssafy.backend.domain.attraction.mapper;

import com.ssafy.backend.domain.attraction.dto.Attraction2Dto.*;

import java.util.List;

public interface AttractionMapper {
    AttractionInfoDto findById(Long id);
    AttractionInfoDto2 findById2(Long id);

    void insertKakaoAttr(KakaoDto kakaoDto);

    List<AttractionIdDto> findByScheduleId(Long scheduleId);
}
