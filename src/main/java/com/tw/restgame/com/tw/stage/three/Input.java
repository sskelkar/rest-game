package com.tw.restgame.com.tw.stage.three;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import static java.util.Collections.emptyList;

@JsonIgnoreProperties(ignoreUnknown = true)
class Input {
    private List<InputUsage> toolUsage;

    public Input() {
        //jackson
    }

    public Input(List<InputUsage> toolUsage) {
        this.toolUsage = toolUsage;
    }

    public List<InputUsage> getToolUsage() {
        return toolUsage == null ? emptyList() : toolUsage;
    }
}
