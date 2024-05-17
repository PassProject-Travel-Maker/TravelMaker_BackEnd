package com.ssafy.backend.domain.map.dto;

import lombok.Data;

public class CategoryDto {
    @Data
    public static class CategoryInfoDto{
    	 private int categoryCode;
    	 private String categoryName;
    }
}
