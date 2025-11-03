package en.unideb.inf.SpringDataFX;

import en.unideb.inf.SpringDataFX.model.Person;
import en.unideb.inf.SpringDataFX.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SpringDataFxApplication implements CommandLineRunner {
	@Autowired
	PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataFxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person p = Person.builder()
				.name("John Doe")
				.dateOfBirth(LocalDate.of(1995,5,5))
				.build();

		personRepository.save(p);
	}
}
