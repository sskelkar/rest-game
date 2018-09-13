package com.tw.restgame.com.tw.stage.three;

class OutputUsage implements Comparable<OutputUsage> {
    private String name;
    private Integer timeUsedInMinutes;

    public OutputUsage() {
        //jackson
    }

    public OutputUsage(String name, Integer timeUsedInMinutes) {
        this.name = name;
        this.timeUsedInMinutes = timeUsedInMinutes;
    }

    public String getName() {
        return name;
    }

    public Integer getTimeUsedInMinutes() {
        return timeUsedInMinutes;
    }


    @Override
    public int compareTo(OutputUsage that) {
        return this.timeUsedInMinutes - that.timeUsedInMinutes;
    }
}
