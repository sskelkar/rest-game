package com.tw.restgame.com.tw.stage.four;

import com.tw.restgame.HttpCaller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StageFour {
    private HttpCaller caller;

    public StageFour(HttpCaller caller) {
        this.caller = caller;
    }

    public void findToolsToCarry() {
        Input input = caller.getInput(Input.class);
        List<Tool> tools = input.getTools();
        int items = tools.size();
        int capacity = input.getMaximumWeight();

        int[][] matrix = new int[items + 1][capacity + 1];

        for(int i=0; i<=capacity; i++)
            matrix[0][i] = 0;

        for(int i=1; i<=items;i++) {
            for(int j=0; j<=capacity; j++) {
                if(tools.get(i-1).getWeight() > j) {
                    matrix[i][j] = matrix[i - 1][j];
                }
                else {
                    matrix[i][j] = Math.max(matrix[i-1][j],
                            matrix[i-1][j- tools.get(i-1).getWeight()] + tools.get(i-1).getValue());
                }
            }
        }

        int value = matrix[items][capacity];
        int weight = capacity;
        TreeSet<Tool> result = new TreeSet<>((a,b) -> a.getValue() - b.getValue());

        for(int i=items; i>0 && value>0; i--) {
            if(value != matrix[i-1][weight]) {
                result.add(tools.get(i-1));
                value -= tools.get(i-1).getValue();
                weight -= tools.get(i-1).getWeight();
            }
        }

        List<String> sortedTools = result.descendingSet().stream().map(Tool::getName).collect(Collectors.toList());
        caller.sendOutput(new Output(sortedTools));
    }
}
