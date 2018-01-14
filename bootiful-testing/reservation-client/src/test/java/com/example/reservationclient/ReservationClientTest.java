package com.example.reservationclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@AutoConfigureStubRunner(ids = "com.example:reservation-service:+:8081", workOffline = true)
//@AutoConfigureWireMock(port = 8081)
@RunWith(SpringRunner.class)
@AutoConfigureJsonTesters
@SpringBootTest(classes = ReservationClientApplication.class)
public class ReservationClientTest {

	//	@Autowired
//	private ObjectMapper objectMapper;

	@Autowired
	private ReservationClient client;

	@Test
	public void getReservation() throws Exception {


	/*
	String body = this.objectMapper
				.writeValueAsString(Arrays.asList(
						new Reservation(1L, "John"),
						new Reservation(2L, "Jane")));


		WireMock.stubFor(
				WireMock.get("/reservations")
						.willReturn(WireMock.aResponse()
								.withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
								.withStatus(HttpStatus.OK.value())
								.withBody(body)
						));
*/
		Collection<Reservation> reservations = this.client.getReservations();
		Assertions.assertThat(reservations.size()).isEqualTo(2);
		Assertions.assertThat(reservations.stream().filter(r -> r.getName().equalsIgnoreCase("Jane")).findAny().get()).isNotNull();
	}

}
