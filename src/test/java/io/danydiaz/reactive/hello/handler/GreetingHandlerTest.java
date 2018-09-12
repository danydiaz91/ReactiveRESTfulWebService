package io.danydiaz.reactive.hello.handler;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

/**
 * 
 * @author Dany Diaz
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class GreetingHandlerTest {

	@Test
	public void testHelloSpring() {
		
		String expected = "Hello, Spring!";
		
		WebClient webClient = WebClient.create("http://localhost:8080");		
		
		Mono<ClientResponse> monoResult = webClient.get()
				.uri("/hello")
				.accept(MediaType.TEXT_PLAIN)
				.exchange();
		
		String result = monoResult.flatMap(res -> res.bodyToMono(String.class)).block();
		
		assertEquals(expected, result);
	}
}
