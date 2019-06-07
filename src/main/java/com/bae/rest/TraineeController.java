package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.business.service.TraineeService;

@Path("trainee/")
public class TraineeController {

	@Inject
	private TraineeService service;

	@Path("getAllTrainees")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return service.getAllTrainees();

	}

	@Path("addATrainee")
	@POST
	@Produces({ "application/json" })
	public String addATrainee(String trainee) {
		return service.addATrainee(trainee);
	}

	@Path("removeATrainee/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String removeATrainee(@PathParam("id") int id) {
		return service.removeATrainee(id);
	}
}
