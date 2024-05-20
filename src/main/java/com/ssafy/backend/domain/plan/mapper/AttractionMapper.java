package com.ssafy.backend.domain.plan.mapper;

import com.ssafy.backend.domain.plan.dto.Attraction2Dto.*;

import java.util.List;

public interface AttractionMapper {
    AttractionInfoDto findById(Long id);

    void insertKakaoAttr(Long attractionId);

    List<AttractionIdDto> findByScheduleId(Long scheduleId);
}
