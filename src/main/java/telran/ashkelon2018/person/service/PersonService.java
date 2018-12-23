package telran.ashkelon2018.person.service;


import org.springframework.stereotype.Service;

import telran.ashkelon2018.person.domain.Address;
import telran.ashkelon2018.person.domain.Person;

@Service
public interface PersonService {
	boolean addPerson(Person person);

	Person getPerson(int id);

	Person removePerson(int id);

	Person updateAddress(int id, Address address);

	Iterable<Person> getPersonsByAge(int minAge, int maxAge);

	Iterable<Person> getPersonsByCity(String city);

	Iterable<Person> getEmployyeesBySalary(int minSalary, int maxSalary);
	
}
