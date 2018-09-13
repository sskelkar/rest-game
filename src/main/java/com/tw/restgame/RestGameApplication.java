package com.tw.restgame;

import com.tw.restgame.com.tw.stage.four.StageFour;
import com.tw.restgame.com.tw.stage.one.StageOne;
import com.tw.restgame.com.tw.stage.three.StageThree;
import com.tw.restgame.com.tw.stage.two.StageTwo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestGameApplication.class, args);
		System.out.println("started >>>>>>>>>>>>");
		HttpCaller caller = new HttpCaller("https://http-hunt.thoughtworks-labs.net", new RestTemplate());

//		new StageOne(caller).decryptMessage();
//		new StageTwo(caller).findTools();
//		new StageThree(caller).sortToolUsage();
//		new StageFour(caller).findToolsToCarry();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
