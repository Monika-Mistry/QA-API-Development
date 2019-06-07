package com.bae.persistence.repository;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bae.persistence.domain.Trainee;
import com.bae.util.JSONUtil;

public class TraineeDataBaseRepository implements TraineeRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonUtil;

	@Override
	public String getAllTrainees() {
		Query query = manager.createQuery("SELECT t FROM Trainee t");

		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();

		return jsonUtil.getJSONForObject(trainees);
	}

}
