package com.tw.restgame.com.tw.stage.four;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import static java.util.Collections.emptyList;

@JsonIgnoreProperties(ignoreUnknown = true)
class Input {
    private List<Tool> tools;
    private Integer maximumWeight;

    public Input() {
        //jackson
    }

    public Input(List<Tool> tools, Integer maximumWeight) {
        this.tools = tools;
        this.maximumWeight = maximumWeight;
    }

    public List<Tool> getTools() {
        return tools == null ? emptyList() : tools;
    }

    public Integer getMaximumWeight() {
        return maximumWeight;
    }
}
