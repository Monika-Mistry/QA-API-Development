package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.bae.persistence.domain.Trainee;
import com.bae.util.JSONUtil;

@Alternative
public class TraineeMapRepository implements TraineeRepository {

	private Map<Integer, Trainee> traineeMap = new HashMap<Integer, Trainee>();

	private JSONUtil jsonUtil = new JSONUtil();

	@Override
	public String getAllTrainees() {

		return jsonUtil.getJSONForObject(traineeMap);
	}

	public Map<Integer, Trainee> getTraineeMap() {
		return traineeMap;
	}

	@Override
	public String addATrainee(String trainee) {

		Trainee traineeObj = jsonUtil.getObjectForJSON(trainee, Trainee.class);

		traineeMap.put(traineeObj.getId(), traineeObj);

		return "{\"message\": \"Trainee Created: " + trainee + "\" }";
	}

	@Override
	public String removeATrainee(int id) {
		traineeMap.remove(1);
		return "{\"message\": \"Trainee Deleted\" }";
	}

}
