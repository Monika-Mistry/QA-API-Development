package com.bae.business.service;

import javax.inject.Inject;

import com.bae.persistence.repository.TraineeRepository;

public class TraineeServiceImpl implements TraineeService {

	@Inject
	private TraineeRepository traineeRepository;

	@Override
	public String getAllTrainees() {
		return traineeRepository.getAllTrainees();
	}

	@Override
	public String addATrainee(String trainee) {

		return traineeRepository.addATrainee(trainee);
	}

}
