package com.bae.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trainee {

	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	@Column(length = 50)
	private String firstName;
	@Column(length = 50)
	private String lastName;

	// @OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "classroomId", referencedColumnName = "classroomId")
	// private Classroom classroom;

	public Trainee() {

	}

	public Trainee(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// public Classroom getClassroom() {
	// return classroom;
	// }
	//
	// public void setClassroom(Classroom classroom) {
	// this.classroom = classroom;
	// }

}
