package com.tw.restgame.com.tw.stage.two;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tw.restgame.HttpCaller;
import com.tw.restgame.TestHelper;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static java.util.Arrays.asList;

public class StageTwoTest extends TestHelper {

    @Test
    public void shouldFindTools() throws JsonProcessingException {
        //given
        Input input = new Input("opekandifehgujnsr", asList("knife", "guns", "rope"));
        stubInput(input);

        Output expectedOutput = new Output(asList("knife", "guns"));
        stubOutput(expectedOutput);

        //when
        StageTwo stageTwo = new StageTwo(new HttpCaller("http://localhost:" + PORT, restTemplate));
        stageTwo.findTools();

        //then
        wireMockRule.verify(1, getRequestedFor(urlEqualTo("/challenge/input")));
        wireMockRule.verify(1, postRequestedFor(urlEqualTo("/challenge/output")));
    }
}