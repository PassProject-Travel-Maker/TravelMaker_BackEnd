package com.ssafy.backend.domain.map.dto;

import com.ssafy.backend.domain.plan.model.Attraction;
import com.ssafy.backend.domain.plan.model.Category;
import com.ssafy.backend.domain.plan.model.Gugun;
import com.ssafy.backend.domain.plan.model.Sido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

public class AttractionDto {

	@Data
	public static class AttractioninfoDto {
		private Long attractionId;
		private int categoryCode;
		private int gugunCode;
		private int sidoCode;
		private String title;
		private String addr;
		private String img;
		private int hit;
		private int recommend;
		private double latitude;
		private double longitude;
		private String attrType;
		
		
		
	}

	@Data
	public static class AttractionDescriptionDto {
		private Long Id;
		private int categoryCode;
		private String title;
		private String addr;
		private String img;

	}
	
}
