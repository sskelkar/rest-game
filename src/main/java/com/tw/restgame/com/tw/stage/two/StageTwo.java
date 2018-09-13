package com.tw.restgame.com.tw.stage.two;

import com.tw.restgame.HttpCaller;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StageTwo {
    private HttpCaller caller;

    public StageTwo(HttpCaller caller) {
        this.caller = caller;
    }

    public void findTools() {
        Input input = caller.getInput(Input.class);

        List<String> toolsFound = input.getTools().stream().filter(tool -> toolFound(input.getHiddenTools(), tool)).collect(toList());

        caller.sendOutput(new Output(toolsFound));
    }

    private boolean toolFound(String hiddenTools, String tool) {
        int toolIndex = 0;
        int hiddenToolsIndex = 0;

        while(toolIndex < tool.length() && hiddenToolsIndex < hiddenTools.length()) {
            if(hiddenTools.charAt(hiddenToolsIndex) == tool.charAt(toolIndex)) {
                hiddenToolsIndex++;
                toolIndex++;
            } else {
                hiddenToolsIndex++;
            }
        }

        return toolIndex == tool.length();
    }
}
