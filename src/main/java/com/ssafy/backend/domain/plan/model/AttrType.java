package com.ssafy.backend.domain.plan.model;

public enum AttrType {
    PUBLIC("PUBLIC"),
    KAKAO("KAKAO");

    private final String type;

    AttrType(final String type) {
        this.type = type;
    }
}
