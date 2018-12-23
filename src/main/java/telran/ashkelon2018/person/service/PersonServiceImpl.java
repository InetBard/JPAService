package telran.ashkelon2018.person.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.ashkelon2018.person.dao.PersonRepository;
import telran.ashkelon2018.person.domain.Address;
import telran.ashkelon2018.person.domain.Person;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	PersonRepository personRepository;

	@Override
	@Transactional
	public boolean addPerson(Person person) {
		if (personRepository.existsById(person.getId())) {
			return false;
		}
		personRepository.save(person);
		return true;
	}

	@Override
	public Person getPerson(int id) {
		return personRepository.findById(id).orElse(null);
	}

	@Override
	public Person removePerson(int id) {
		Person person = personRepository.findById(id).orElse(null);
		if (person!=null) {
			personRepository.deleteById(id);	
		}
		return person;
	}

	@Override
	@Transactional
	public Person updateAddress(int id, Address address) {
		Person person = personRepository.findById(id).orElse(null);
		if (person!=null) {
			person.setAddress(address);
//			personRepository.save(person);
		}
		return person;
	}

	@Override
	public Iterable<Person> getPersonsByAge(int minAge, int maxAge) {
		LocalDate from = LocalDate.now().minusYears(maxAge);
		LocalDate to = LocalDate.now().minusYears(minAge);
		return personRepository.findByBirthDateBetween(from, to);
	}

	@Override
	public Iterable<Person> getPersonsByCity(String city) {
		return personRepository.findByAddressCity(city);
	}

	@Override
	public Iterable<Person> getEmployyeesBySalary(int minSalary, int maxSalary) {
		return personRepository.findBySalaryBetween(minSalary, maxSalary);
	}

}
