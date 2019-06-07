package com.bae.persistence.repositoryTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.repository.ClassroomMapRepository;

public class ClassroomMapRepositoryTest {

	private ClassroomMapRepository classroomMapRepository;

	@Before
	public void setup() {

		classroomMapRepository = new ClassroomMapRepository();
	}

	@Test
	public void returnNoClassroomsWhenMapIsEmpty() {

		assertEquals(0, classroomMapRepository.getClassroomMap().size());
		assertEquals("{}", classroomMapRepository.getAllClassrooms());
	}

	@Test
	public void returnClassroomsWhenMapIsFilled() {
		classroomMapRepository.getClassroomMap().put(1, trainee1);

		assertEquals(1, classroomMapRepository.getClassroomMap().size());
		assertEquals("{\"1\":" + trainee1JSON + "}", classroomMapRepository.getAllTrainees());
	}

	// @Test
	// public void addAClassroom() {
	// classroomMapRepository.addATrainee(trainee1JSON);
	//
	// assertEquals(1, classroomMapRepository.getClassroomMap().size());
	// assertTrue(classroomMapRepository.getClassroomMap().get(1).getFirstName().equals("John"));
	// }
	//
	// @Test
	// public void add2Classrooms() {
	// classroomMapRepository.addATrainee(trainee1JSON);
	// classroomMapRepository.addATrainee(trainee2JSON);
	//
	// assertEquals(2, classroomMapRepository.getClassroomMap().size());
	// assertTrue(classroomMapRepository.getClassroomMap().get(1).getFirstName().equals("John"));
	// assertTrue(classroomMapRepository.getClassroomMap().get(2).getFirstName().equals("Jane"));
	// }
	//
	// @Test
	// public void removeAClassroom() {
	// classroomMapRepository.addATrainee(trainee1JSON);
	//
	// classroomMapRepository.removeATrainee(1);
	//
	// assertEquals(0, classroomMapRepository.getClassroomMap().size());
	// }
	//
	// @Test
	// public void remove2Classrooms() {
	// classroomMapRepository.addATrainee(trainee1JSON);
	// classroomMapRepository.addATrainee(trainee2JSON);
	//
	// classroomMapRepository.removeATrainee(1);
	// assertEquals(1, classroomMapRepository.getClassroomMap().size());
	//
	// classroomMapRepository.removeATrainee(2);
	// assertEquals(0, classroomMapRepository.getClassroomMap().size());
	// }
	//
	// @Test
	// public void updateAClassroom() {
	// classroomMapRepository.addATrainee(trainee1JSON);
	// String updatedTrainee =
	// "{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Doe\"}";
	//
	// classroomMapRepository.updateTrainee(1, updatedTrainee);
	//
	// assertEquals(1, classroomMapRepository.getClassroomMap().size());
	// assertTrue(classroomMapRepository.getClassroomMap().get(1).getLastName().equals("Doe"));
	// }

}
