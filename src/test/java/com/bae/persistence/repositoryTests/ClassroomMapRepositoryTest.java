package com.bae.persistence.repositoryTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.domain.Classroom;
import com.bae.persistence.repository.ClassroomMapRepository;

public class ClassroomMapRepositoryTest {

	private ClassroomMapRepository classroomMapRepository;
	private Classroom classroom1;
	private String cr1JSON = "{\"classroomId\":1,\"trainerFirstName\":\"John\",\"trainerLastName\":\"Smith\"}";
	private String cr2JSON = "{\"classroomId\":2,\"trainerFirstName\":\"Jane\",\"trainerLastName\":\"Doe\"}";

	@Before
	public void setup() {

		classroomMapRepository = new ClassroomMapRepository();
		classroom1 = new Classroom(1, "John", "Smith");
	}

	@Test
	public void returnNoClassroomsWhenMapIsEmpty() {

		assertEquals(0, classroomMapRepository.getClassroomMap().size());
		assertEquals("{}", classroomMapRepository.getAllClassrooms());
	}

	@Test
	public void returnClassroomsWhenMapIsFilled() {
		classroomMapRepository.getClassroomMap().put(1, classroom1);

		assertEquals(1, classroomMapRepository.getClassroomMap().size());
		assertEquals("{\"1\":" + cr1JSON + "}", classroomMapRepository.getAllClassrooms());
	}

	@Test
	public void addAClassroom() {
		classroomMapRepository.addAClassroom(cr1JSON);

		assertEquals(1, classroomMapRepository.getClassroomMap().size());
		assertTrue(classroomMapRepository.getClassroomMap().get(1).getTrainerFirstName().equals("John"));
	}

	@Test
	public void add2Classrooms() {
		classroomMapRepository.addAClassroom(cr1JSON);
		classroomMapRepository.addAClassroom(cr2JSON);

		assertEquals(2, classroomMapRepository.getClassroomMap().size());
		assertTrue(classroomMapRepository.getClassroomMap().get(1).getTrainerFirstName().equals("John"));
		assertTrue(classroomMapRepository.getClassroomMap().get(2).getTrainerFirstName().equals("Jane"));
	}

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
