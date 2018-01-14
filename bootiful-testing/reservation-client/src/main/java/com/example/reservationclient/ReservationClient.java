package com.example.reservationclient;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@Component
public class ReservationClient {

	private final RestTemplate restTemplate;

	public ReservationClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Collection<Reservation> getReservations() {
		ParameterizedTypeReference<Collection<Reservation>> type =
				new ParameterizedTypeReference<Collection<Reservation>>() {
				};

		return this
				.restTemplate
				.exchange("http://localhost:8081/reservations", HttpMethod.GET, null, type)
				.getBody();

	}
}
