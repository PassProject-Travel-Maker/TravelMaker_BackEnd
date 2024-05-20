package com.ssafy.backend.domain.attraction.model;

public enum AttrType {
    PUBLIC("PUBLIC"),
    KAKAO("KAKAO");

    private final String type;

    AttrType(final String type) {
        this.type = type;
    }
}
