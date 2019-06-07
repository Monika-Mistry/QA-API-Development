package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.business.service.ClassroomService;

@Path("classroom/")
public class ClassroomController {

	@Inject
	private ClassroomService service;

	@Path("getAllclassrooms")
	@GET
	@Produces({ "application/json" })
	public String getAllClassrooms() {
		return service.getAllClassrooms();

	}

	@Path("addAclassroom")
	@POST
	@Produces({ "application/json" })
	public String addAClassroom(String classroom) {
		return service.addAClassroom(classroom);
	}

	@Path("removeAclassroom/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String removeAClassroom(@PathParam("id") int id) {
		return service.removeAClassroom(id);
	}

	@Path("updateAclassroom/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAClassroom(@PathParam("id") int id, String classroom) {
		return service.updateClassroom(id, classroom);
	}

}
