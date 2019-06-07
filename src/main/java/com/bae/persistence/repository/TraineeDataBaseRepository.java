package com.bae.persistence.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bae.persistence.domain.Trainee;
import com.bae.util.Constants;
import com.bae.util.JSONUtil;

@Default
public class TraineeDataBaseRepository implements TraineeRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonUtil;

	@Override
	public String getAllTrainees() {
		Query query = manager.createQuery(Constants.GETALLTRAINEEQUERY);

		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();

		return jsonUtil.getJSONForObject(trainees);
	}

}
