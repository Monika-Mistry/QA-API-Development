package com.bae.persistence.repositoryTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.domain.Trainee;
import com.bae.persistence.repository.TraineeMapRepository;

public class TraineeMapRepositoryTest {

	private TraineeMapRepository traineeMapRepository;
	private Trainee trainee1;
	private Trainee trainee2;
	private String trainee1JSON = "{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\"}";
	private String trainee2JSON = "{\"id\":2,\"firstName\":\"Jane\",\"lastName\":\"Doe\"}";

	@Before
	public void setup() {

		traineeMapRepository = new TraineeMapRepository();
		trainee1 = new Trainee(1, "John", "Smith");
		trainee2 = new Trainee(2, "Jane", "Doe");

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
		assertEquals("{\"1\":" + trainee1JSON + "}", traineeMapRepository.getAllTrainees());
	}

	@Test
	public void addATrainee() {
		traineeMapRepository.addATrainee(trainee1JSON);

		assertEquals(1, traineeMapRepository.getTraineeMap().size());
		assertTrue(traineeMapRepository.getTraineeMap().get(1).getFirstName().equals("John"));
	}

	@Test
	public void add2Trainees() {
		traineeMapRepository.addATrainee(trainee1JSON);
		traineeMapRepository.addATrainee(trainee2JSON);

		assertEquals(2, traineeMapRepository.getTraineeMap().size());
		assertTrue(traineeMapRepository.getTraineeMap().get(1).getFirstName().equals("John"));
		assertTrue(traineeMapRepository.getTraineeMap().get(2).getFirstName().equals("Jane"));
	}

	@Test
	public void removeATrainee() {
		traineeMapRepository.getTraineeMap().put(1, trainee1);

		traineeMapRepository.removeATrainee(1);

		assertEquals(0, traineeMapRepository.getTraineeMap().size());
	}

	@Test
	public void remove2Trainees() {
		traineeMapRepository.getTraineeMap().put(1, trainee1);
		traineeMapRepository.getTraineeMap().put(2, trainee1);

		traineeMapRepository.removeATrainee(1);
		assertEquals(1, traineeMapRepository.getTraineeMap().size());

		traineeMapRepository.removeATrainee(2);
		assertEquals(0, traineeMapRepository.getTraineeMap().size());
	}

	@Test
	public void updateATrainee() {
		traineeMapRepository.getTraineeMap().put(1, trainee1);
		String updatedTrainee = "{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Doe\"}";

		traineeMapRepository.updateTrainee(1, updatedTrainee);

		assertEquals(1, traineeMapRepository.getTraineeMap().size());
		assertTrue(traineeMapRepository.getTraineeMap().get(1).getLastName().equals("Doe"));
	}

}
