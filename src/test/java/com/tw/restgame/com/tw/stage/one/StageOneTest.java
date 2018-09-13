package com.tw.restgame.com.tw.stage.one;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tw.restgame.HttpCaller;
import com.tw.restgame.TestHelper;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class StageOneTest extends TestHelper {

    @Test
    public void shouldDecryptMessage() throws JsonProcessingException {
        //given
        Input input = new Input("F KFRTZX JCUQTWJW TSHJ XFNI, YMFY YMJ JCYWFTWINSFWD NX NS BMFY BJ IT, STY BMT BJ FWJ. LT JCUQTWJ!", 5);
        Output expectedOutput = new Output("A FAMOUS EXPLORER ONCE SAID, THAT THE EXTRAORDINARY IS IN WHAT WE DO, NOT WHO WE ARE. GO EXPLORE!");
        stubInput(input);
        stubOutput(expectedOutput);

        //when
        StageOne stageOne = new StageOne(new HttpCaller("http://localhost:" + PORT, restTemplate));
        stageOne.decryptMessage();

        //then
        wireMockRule.verify(1, getRequestedFor(urlEqualTo("/challenge/input")));
        wireMockRule.verify(1, postRequestedFor(urlEqualTo("/challenge/output")));
    }
}