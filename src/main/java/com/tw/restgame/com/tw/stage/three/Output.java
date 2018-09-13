package com.tw.restgame.com.tw.stage.three;

import java.util.List;

import static java.util.Collections.emptyList;

class Output {
    private List<OutputUsage> toolsSortedOnUsage;

    public Output() {
        //jackson
    }

    public Output(List<OutputUsage> toolsSortedOnUsage) {
        this.toolsSortedOnUsage = toolsSortedOnUsage;
    }

    public List<OutputUsage> getToolsSortedOnUsage() {
        return toolsSortedOnUsage == null ? emptyList() : toolsSortedOnUsage;
    }
}
