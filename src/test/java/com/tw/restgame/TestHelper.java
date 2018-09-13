package com.tw.restgame;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestHelper {
    protected static final int PORT = 8089;
    protected ObjectMapper mapper = new ObjectMapper();

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(PORT);

    @Autowired
    protected RestTemplate restTemplate;

    protected void stubInput(Object input) throws JsonProcessingException {
        wireMockRule.stubFor(get(urlEqualTo("/challenge/input"))
                .withHeader("userId", equalTo("cjramvOaj"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("content-type", "application/json; charset=utf-8")
                        .withBody(mapper.writeValueAsString(input))));
    }

    protected void stubOutput(Object expectedOutput) throws JsonProcessingException {
        wireMockRule.stubFor(post(urlEqualTo("/challenge/output"))
                .withHeader("content-type", equalTo("application/json"))
                .withHeader("userId", equalTo("cjramvOaj"))
                .withRequestBody(equalToJson(mapper.writeValueAsString(expectedOutput)))
                .willReturn(aResponse()
                        .withStatus(200)));
    }
}
