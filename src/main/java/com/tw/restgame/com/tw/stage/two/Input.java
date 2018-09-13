package com.tw.restgame.com.tw.stage.two;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import static java.util.Collections.emptyList;

@JsonIgnoreProperties(ignoreUnknown = true)
class Input {
    private String hiddenTools;
    private List<String> tools;

    public Input() {
        //jackson
    }

    public Input(String hiddenTools, List<String> tools) {
        this.hiddenTools = hiddenTools;
        this.tools = tools;
    }

    public String getHiddenTools() {
        return hiddenTools;
    }

    public List<String> getTools() {
        return tools == null ? emptyList() : tools;
    }
}
