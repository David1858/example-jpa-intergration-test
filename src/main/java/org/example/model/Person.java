package org.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "person")
@NamedQuery(name = "Person.findAll", query = "SELECT p from Person p")
public class Person {
	
	public static final String FIND_ALL = "Person.findAll";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column(name = "first_name", length = 50)
	String firstName;

	@Column(name = "last_name", length = 50)
	String lastName;
	
	public String getLastCommaFirstName() {
		StringBuffer result = new StringBuffer();
		if(getLastName() != null)
			result.append(getLastName());
		if(getFirstName() != null) {
			result.append(", ");
			result.append(getFirstName());
		}
		return result.toString();
	}
}
