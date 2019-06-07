package com.bae.rest;

import javax.inject.Inject;

import com.bae.business.service.TraineeService;

public class TraineeController {

	@Inject
	private TraineeService service;

	public String getAllTrainees() {
		return service.getAllTrainees();

	}
}
