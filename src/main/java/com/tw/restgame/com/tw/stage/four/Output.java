package com.tw.restgame.com.tw.stage.four;

import java.util.List;

import static java.util.Collections.emptyList;

class Output {
    private List<String> toolsToTakeSorted;

    public Output() {
        //jackson
    }

    public Output(List<String> toolsToTakeSorted) {
        this.toolsToTakeSorted = toolsToTakeSorted;
    }

    public List<String> getToolsToTakeSorted() {
        return toolsToTakeSorted == null ? emptyList() : toolsToTakeSorted;
    }
}
