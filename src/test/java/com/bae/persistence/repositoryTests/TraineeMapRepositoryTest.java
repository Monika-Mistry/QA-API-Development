package com.bae.persistence.repositoryTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.repository.TraineeMapRepository;

public class TraineeMapRepositoryTest {

	private TraineeMapRepository traineeMapRepository;

	@Before
	public void setup() {

		traineeMapRepository = new TraineeMapRepository();

	}

	@Test
	public void returnNoTraineesWhenMapIsEmpty() {

		assertEquals(0, traineeMapRepository.getTraineeMap().size());
		assertEquals("{}", traineeMapRepository.getAllTrainees());

	}

	@Test
	public void returnTraineesWhenMapIsFilled() {
		fail("TODO");
	}

}
