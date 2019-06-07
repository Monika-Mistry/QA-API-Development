package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.bae.persistence.domain.Trainee;

public class TraineeMapRepository implements TraineeRepository {

	private Map<Integer, Trainee> traineeMap = new HashMap<Integer, Trainee>();

	@Override
	public String getAllTrainees() {
		return "{}";
	}

	public Map<Integer, Trainee> getTraineeMap() {
		return traineeMap;
	}

}
