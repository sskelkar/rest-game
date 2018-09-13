package com.tw.restgame.com.tw.stage.three;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tw.restgame.HttpCaller;
import com.tw.restgame.TestHelper;
import com.tw.restgame.com.tw.stage.one.StageOne;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static java.util.Arrays.asList;

public class StageThreeTest extends TestHelper {
    @Test
    public void shouldSortToolUsage() throws JsonProcessingException {
        //given
        Input input = new Input(asList(
            new InputUsage("knife", "2017-01-30 10:00:00", "2017-01-30 10:10:00"),
            new InputUsage("guns", "2017-01-30 10:15:00", "2017-01-30 10:20:00"),
            new InputUsage("guns", "2017-01-30 11:00:00", "2017-01-30 11:10:00"),
            new InputUsage("knife", "2017-01-30 11:10:00", "2017-01-30 11:20:00"),
            new InputUsage("rope", "2017-01-30 13:00:00", "2017-01-30 14:00:00")
        ));
        stubInput(input);

        Output expectedOutput = new Output(asList(
            new OutputUsage("rope", 60),
            new OutputUsage("knife", 20),
            new OutputUsage("guns", 15)
        ));
        stubOutput(expectedOutput);

        //when
        StageThree stageThree = new StageThree(new HttpCaller("http://localhost:" + PORT, restTemplate));
        stageThree.sortToolUsage();

        //then
        wireMockRule.verify(1, getRequestedFor(urlEqualTo("/challenge/input")));
        wireMockRule.verify(1, postRequestedFor(urlEqualTo("/challenge/output")));
    }
}