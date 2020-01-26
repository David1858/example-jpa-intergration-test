package it.org.example.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import org.example.dao.PersonDao;
import org.example.model.Person;
import org.junit.Before;
import org.junit.Test;

public class PersonDaoIT extends DaoBaseIT{

	PersonDao personDao;
	
	@Before
	public void init() {
		personDao = new PersonDao(entityManager);
	}
	
	@Test
	public void testPersonDao() {
		Person person = Person
				.builder()
				.firstName("first name")
				.build();
		
		entityManager.getTransaction().begin();
		
		int personCount = personDao.findAll().size();
		personDao.insert(person);
		assertThat(personDao.findAll(), hasSize(personCount + 1));
		assertThat(personDao.findAll(), hasSize(4));
		
		entityManager.getTransaction().rollback();
//		entityManager.getTransaction().commit();
	}
	
}
