package com.example.reservationservice;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
//@SpringBootTest(classes = ReservationServiceApplication.class)
@RunWith(SpringRunner.class)
public class JpaReservationTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void jpaPersistance() throws Exception {
		Reservation jane = this.testEntityManager.persistFlushFind(new Reservation(null, "Jane"));
		Assertions.assertThat(jane.getName()).isEqualToIgnoringCase("Jane");
	}
}
