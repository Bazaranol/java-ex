package com.example.demo.specifications.period;

import lombok.Getter;

@Getter
public class Sort {
    private final String field;
    private final String direction;

    public Sort(String field, String direction) {
        this.field = field;
        this.direction = direction;
    }
}
