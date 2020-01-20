package org.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.example.model.Person;

public class PersonDao {

	@PersistenceContext
	private EntityManager entityManager;

	public PersonDao() {
		super();
	}

	public PersonDao(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	public List<Person> findAll() {
		return entityManager.createNamedQuery(Person.FIND_ALL).getResultList();
	}

	public Person findById(Long id) {
		return entityManager.find(Person.class, id);
	}

	public Person insert(Person person) {
		entityManager.persist(person);
		return person;
	}
}
