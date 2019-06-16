package com.tecnowlogia.spring.sse.springsseexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class SpringSseExampleApplication {

	public static final String INDEX = "classpath:/public/index.html";

	public static void main(String[] args) {
		SpringApplication.run(SpringSseExampleApplication.class, args);
	}

	@Bean
	public RouterFunction<ServerResponse> index(@Value(INDEX) final Resource index) {
		return route(GET("/"),
				request -> ok()
						.contentType(MediaType.TEXT_HTML)
						.syncBody(index));
	}
}
