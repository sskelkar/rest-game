package com.tw.restgame.com.tw.stage.three;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class InputUsage {
    private String name;
    private String useStartTime;
    private String useEndTime;

    public InputUsage() {
        //jackson
    }

    public InputUsage(String name, String useStartTime, String useEndTime) {
        this.name = name;
        this.useStartTime = useStartTime;
        this.useEndTime = useEndTime;
    }

    public String getName() {
        return name;
    }

    public String getUseStartTime() {
        return useStartTime;
    }

    public String getUseEndTime() {
        return useEndTime;
    }
}
