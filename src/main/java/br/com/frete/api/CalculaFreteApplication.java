package br.com.frete.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.xml.Jaxb2XmlDecoder;
import org.springframework.http.codec.xml.Jaxb2XmlEncoder;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class CalculaFreteApplication {

	@Bean
	public WebClient webClient(WebClient.Builder builder) {
		return builder
			.baseUrl("http://ws.correios.com.br")
			.exchangeStrategies(ExchangeStrategies.builder().codecs((configurer) -> {
	            configurer.defaultCodecs().jaxb2Encoder(new Jaxb2XmlEncoder());
	            configurer.defaultCodecs().jaxb2Decoder(new Jaxb2XmlDecoder());
	            }).build())
			.build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CalculaFreteApplication.class, args);
	}

}
