package com.bae.persistence.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.bae.persistence.domain.Trainee;
import com.bae.util.Constants;
import com.bae.util.JSONUtil;

@Default
@Transactional(TxType.SUPPORTS)
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

	@Override
	@Transactional(TxType.REQUIRED)
	public String addATrainee(String trainee) {
		Trainee traineeObj = jsonUtil.getObjectForJSON(trainee, Trainee.class);

		manager.persist(traineeObj);
		return trainee;
	}

	@Override
	@Transactional(TxType.REQUIRED)
	public String removeATrainee(int id) {
		Trainee traineeObj = manager.find(Trainee.class, id);

		manager.remove(traineeObj);

		return "{\"message\": \"" + traineeObj.getFirstName() + " " + traineeObj.getLastName() + " Deleted\" }";
	}

}
