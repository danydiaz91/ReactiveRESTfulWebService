/**
 * 
 */
package io.danydiaz.reactive.hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import io.danydiaz.reactive.hello.handler.GreetingHandler;

/**
 * @author Dany Diaz
 *
 */
@Configuration
public class GreetingRouter {
	
	@Bean
	public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
		
		return RouterFunctions.route(RequestPredicates.GET("/hello")
				.and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), greetingHandler::hello);
	}
}