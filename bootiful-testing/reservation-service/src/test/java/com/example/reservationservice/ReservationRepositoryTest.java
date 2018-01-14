package com.example.reservationservice;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ReservationRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private ReservationRepository repo;

	@Test
	public void find() throws Exception {

		this.testEntityManager.persistFlushFind(new Reservation(null, "Foo"));
		this.testEntityManager.persistFlushFind(new Reservation(null, "Bar"));
		this.testEntityManager.persistFlushFind(new Reservation(null, "Bar"));
		Collection<Reservation> reservationName = this.repo.findByName ("Bar");
		Assertions.assertThat(reservationName.size()).isEqualTo(2);

	}
}
