package com.tw.restgame.com.tw.stage.four;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class Tool {
    private String name;
    private Integer weight;
    private Integer value;

    public Tool() {
        //jackson
    }

    public Tool(String name, Integer weight, Integer value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getValue() {
        return value;
    }
}
