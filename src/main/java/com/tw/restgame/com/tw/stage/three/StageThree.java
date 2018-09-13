package com.tw.restgame.com.tw.stage.three;

import com.tw.restgame.HttpCaller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import static java.util.stream.Collectors.toCollection;

public class StageThree {
    private HttpCaller caller;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern ("yyyy-MM-dd HH:mm:ss");

    public StageThree(HttpCaller caller) {
        this.caller = caller;
    }

    public void sortToolUsage() {
        Input input = caller.getInput(Input.class);

        Map<String, Integer> toolUsage = getToolUsageMap(input);

        TreeSet<OutputUsage> outputUsages = toolUsage.entrySet().stream()
                .map(entry -> new OutputUsage(entry.getKey(), entry.getValue()))
                .collect(toCollection(TreeSet::new));

        caller.sendOutput(new Output(new ArrayList<>(outputUsages.descendingSet())));
    }

    private Map<String, Integer> getToolUsageMap(Input input) {
        Map<String, Integer> toolUsage = new HashMap<>();
        input.getToolUsage().forEach(usage -> {

            LocalDateTime start = LocalDateTime.parse(usage.getUseStartTime(), formatter);
            LocalDateTime end = LocalDateTime.parse(usage.getUseEndTime(), formatter);
            Long timeDiff = Duration.between(start, end).toMinutes();

            String toolName = usage.getName();
            if(toolUsage.get(toolName) == null) {
                toolUsage.put(toolName, timeDiff.intValue());
            } else {
                int prevDiff = toolUsage.get(toolName);
                toolUsage.put(toolName, prevDiff + timeDiff.intValue());
            }
        });
        return toolUsage;
    }
}
