package com.silent.detector.domain.enumeration;

import lombok.Getter;

@Getter
public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    INCONCLUSIVE("Inconclusive");

    private String name;

    Gender(String name){
        this.name = name;
    }
}
