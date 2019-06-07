package com.bae.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int classroomId;
	@Column(length = 50)
	private String trainerFirstName;
	@Column(length = 50)
	private String trainerLastName;
	// @OneToOne (mappedBy = "classroom")
	// private List<Trainee> trainees;

	public Classroom() {

	}

	public Classroom(int classroomId, String trainerFirstName, String trainerLastName) {
		super();
		this.classroomId = classroomId;
		this.trainerFirstName = trainerFirstName;
		this.trainerLastName = trainerLastName;
	}

	public int getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(int classroomId) {
		this.classroomId = classroomId;
	}

	public String getTrainerFirstName() {
		return trainerFirstName;
	}

	public void setTrainerFirstName(String trainerFirstName) {
		this.trainerFirstName = trainerFirstName;
	}

	public String getTrainerLastName() {
		return trainerLastName;
	}

	public void setTrainerLastName(String trainerLastName) {
		this.trainerLastName = trainerLastName;
	}

	// public List<Trainee> getTrainees() {
	// return trainees;
	// }
	//
	// public void addTrainee(Trainee trainee) {
	// if (!getTrainees().contains(trainee)) {
	// getTrainees().add(trainee);
	// if (trainee.getClassroom() != null) {
	// trainee.getClassroom().getTrainees().remove(trainee);
	// }
	// trainee.setClassroom(this);
	// }
	// }
	//
	// public void setTrainees(List<Trainee> trainees) {
	// this.trainees = trainees;
	// }

}
