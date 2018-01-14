package com.example.reservationservice;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ReservationTest {

	@Test
	public void create() {
		Reservation reservation = new Reservation(1L, "Foo");
//		Assert.assertEquals("Foo", reservation.getName());
//		Assert.assertEquals((Long) 1L, reseoorvation.getId());
//		Assert.assertThat(reservation.getName(), Matchers.is("Foo"));
//		Assert.assertThat(reservation.getId(), Matchers.is(1L));

		Assertions.assertThat(reservation.getId()).isEqualTo(1L);
		Assertions.assertThat(reservation.getName()).isEqualTo("Foo");
	}
}
