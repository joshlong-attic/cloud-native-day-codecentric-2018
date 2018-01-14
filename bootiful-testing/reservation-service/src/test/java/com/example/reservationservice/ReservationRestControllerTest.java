package com.example.reservationservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@RunWith(SpringRunner.class)
public class ReservationRestControllerTest {

	@MockBean
	private ReservationRepository reservationRepository;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getReservations() throws Exception {

		Mockito.when(this.reservationRepository.findAll())
				.thenReturn(Collections.singletonList(new Reservation(1L, "Jane")));

		this.mockMvc.perform(get("/reservations"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("@.[0].name").value("Jane"));
	}
}
