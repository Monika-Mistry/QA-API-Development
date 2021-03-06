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
		traineeMap.remove(id);
		return "{\"message\": \"Trainee Deleted\" }";
	}

	@Override
	public String updateTrainee(int id, String trainee) {
		Trainee traineeToUpdate = traineeMap.get(id);

		Trainee traineeInput = jsonUtil.getObjectForJSON(trainee, Trainee.class);

		traineeToUpdate.setFirstName(traineeInput.getFirstName());
		traineeToUpdate.setLastName(traineeInput.getLastName());

		traineeMap.replace(1, traineeToUpdate);

		return trainee;
	}

}
