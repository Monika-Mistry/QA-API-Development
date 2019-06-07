package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.bae.persistence.domain.Trainee;
import com.bae.util.JSONUtil;

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

}
