package br.com.frete.api.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CalculaFreteExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler({ WebClientResponseException.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {	   
		 return new ResponseEntity<Object>(new Error("Falha ao calcular o frete e o prazo ", ex.getLocalizedMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	public static class Error {

		private String message;
		
		private String detailMessage;

		public Error(String message, String detailMessage) {
			this.message = message;
			this.detailMessage = detailMessage;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getDetailMessage() {
			return detailMessage;
		}

		public void setDetailMessage(String detailMessage) {
			this.detailMessage = detailMessage;
		}

		

	}
}
