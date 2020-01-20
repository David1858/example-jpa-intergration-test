package org.example.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.example.model.Person;
import org.junit.Test;

public class PersonTest {
	
	@Test
	public void testGetLastCommaFirstName() {
		Person person = Person
				.builder()
				.firstName("firstName")
				.lastName("lastName")
				.build();
		assertThat(person.getLastCommaFirstName(), is(equalTo("lastName, firstName")));
	}
}
