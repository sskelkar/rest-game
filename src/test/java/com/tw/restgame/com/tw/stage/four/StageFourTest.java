package com.tw.restgame.com.tw.stage.four;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tw.restgame.HttpCaller;
import com.tw.restgame.TestHelper;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static java.util.Arrays.asList;

public class StageFourTest extends TestHelper {

    @Test
    public void shouldFindToolsToCarry() throws JsonProcessingException {
        //given
        Input input = new Input(asList(
                new Tool("knife", 1, 80),
                new Tool("guns", 5, 90),
                new Tool("rope", 10, 60),
                new Tool("water", 8, 40)
        ), 15);
        stubInput(input);

        Output expectedOutput = new Output(asList("guns", "knife", "water"));
        stubOutput(expectedOutput);

        //when
        StageFour stageFour = new StageFour(new HttpCaller("http://localhost:" + PORT, restTemplate));
        stageFour.findToolsToCarry();

        //then
        wireMockRule.verify(1, getRequestedFor(urlEqualTo("/challenge/input")));
        wireMockRule.verify(1, postRequestedFor(urlEqualTo("/challenge/output")));
    }
}