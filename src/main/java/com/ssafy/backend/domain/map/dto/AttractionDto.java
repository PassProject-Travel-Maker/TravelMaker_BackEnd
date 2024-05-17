package com.ssafy.backend.domain.map.dto;

import lombok.Data;

public class AttractionDto {

	@Data
	public static class AttractioninfoDto {
		private Long Id;
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
