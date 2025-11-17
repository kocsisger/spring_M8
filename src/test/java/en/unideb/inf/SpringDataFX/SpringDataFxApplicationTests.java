package en.unideb.inf.SpringDataFX;


import en.unideb.inf.SpringDataFX.model.Person;
import en.unideb.inf.SpringDataFX.model.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class SpringDataFxApplicationTests {

	@Autowired
	PersonRepository personRepository;

	@Test
	void contextLoads() {
		Person person = Person.builder()
				.age(20).name("Sanyi a ló").build();
		System.out.println("körte");
		Person savedPerson = personRepository.save(person);
		Assertions.assertThat(savedPerson).isNotNull();
		Assertions.assertThat(savedPerson.getId()).isGreaterThan(0);
		Assertions.assertThat(savedPerson).isEqualTo(person);
	}

	@Test
	void testFindAllPersons(){
		Iterable<Person> persons = personRepository.findAll();
		Assertions.assertThat(persons).hasSizeGreaterThan(0);

		for (Person p : persons) {
			System.out.println(p);
		}
	}

	@Test
	void testUpdatePerson(){
		Person person = Person.builder()
				.name("Rebeka").age(21).build();
		Person p1 = personRepository.save(person);
		p1.setAge(31);
		Person p2 = personRepository.save(p1);

		Assertions.assertThat(p2.getAge()).isEqualTo(31);
	}

	@Test
	void testDeletePerson(){
		personRepository.save(Person.builder()
				.name("Rebeka").age(21).build());
		personRepository.save(Person.builder()
				.name("Rebeka").age(21).build());

		Person p = personRepository.findFirstByName("Rebeka").get();
		long previousId = p.getId();

		personRepository.delete(p);

		p = personRepository.findFirstByName("Rebeka").get();
		long newId = p.getId();

		personRepository.delete(p);

		Assertions.assertThat(previousId).isNotEqualTo(newId);
	}

}
