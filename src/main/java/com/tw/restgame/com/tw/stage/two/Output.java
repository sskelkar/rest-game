package com.tw.restgame.com.tw.stage.two;

import java.util.List;

import static java.util.Collections.emptyList;

class Output {
    private List<String> toolsFound;

    public Output() {
        //jackson
    }

    public Output(List<String> toolsFound) {
        this.toolsFound = toolsFound;
    }

    public List<String> getToolsFound() {
        return toolsFound == null ? emptyList() : toolsFound;
    }
}
