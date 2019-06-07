package com.bae.persistence.repositoryTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.domain.Trainee;
import com.bae.persistence.repository.TraineeMapRepository;

public class TraineeMapRepositoryTest {

	private TraineeMapRepository traineeMapRepository;
	private Trainee trainee1;
	private String trainee1MapJSON = "{\"1\":{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\"}}";

	@Before
	public void setup() {

		traineeMapRepository = new TraineeMapRepository();
		trainee1 = new Trainee(1, "John", "Smith");

	}

	@Test
	public void returnNoTraineesWhenMapIsEmpty() {

		assertEquals(0, traineeMapRepository.getTraineeMap().size());
		assertEquals("{}", traineeMapRepository.getAllTrainees());

	}

	@Test
	public void returnTraineesWhenMapIsFilled() {
		traineeMapRepository.getTraineeMap().put(1, trainee1);

		assertEquals(1, traineeMapRepository.getTraineeMap().size());
		assertEquals(trainee1MapJSON, traineeMapRepository.getAllTrainees());
	}

}
