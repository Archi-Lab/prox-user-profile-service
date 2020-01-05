package io.archilab.prox.userprofileservice;

import io.archilab.prox.userprofileservice.professor.Professor;
import io.archilab.prox.userprofileservice.professor.ProfessorDescription;
import io.archilab.prox.userprofileservice.professor.ProfessorRepository;
import io.archilab.prox.userprofileservice.project.Projekt;
import io.archilab.prox.userprofileservice.project.ProjektRepository;
import io.archilab.prox.userprofileservice.project.Projektart;
import io.archilab.prox.userprofileservice.project.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class UserProfileServiceApplication implements CommandLineRunner
{


	Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Autowired
	private ProfessorRepository repository;
	@Autowired
	private ProjektRepository projektRepository;

	public static void main(String[] args)
	{
		SpringApplication.run(UserProfileServiceApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception
	{
		repository.deleteAll();
		projektRepository.deleteAll();

		// save a couple of profiles
		Professor firstProfessor = new Professor("Alice", "Smith", new ProfessorDescription("Hallo, ich bin Alice Smith."));
		repository.save(firstProfessor);
		repository.save(new Professor("Bob", "Smith",  new ProfessorDescription("Hallo, ich bin Bob Smith.")));
		repository.save(new Professor("Daryl", "Li",  new ProfessorDescription("TestTestTest")));
		repository.save(new Professor("Angela", "Aldersson", new ProfessorDescription("Gebe Vorlesung mit Herz")));
		repository.save(new Professor("John", "Bread", new ProfessorDescription("Hallostop")));

		repository.save(new Professor("Markus", "Söder", new ProfessorDescription("")));
		repository.save(new Professor("Joseph", "Seed", new ProfessorDescription("")));

		Projekt firstProjekt = new Projekt("TestProjekt",  "Ein Test Projekt jajjajaja", "öiug", Projektart.BACHELORARBEIT, Status.LAUFEND, 1);
		projektRepository.save(firstProjekt);
		// fetch all profiles
		System.out.println("Profiles found with findAll():");
		System.out.println("-------------------------------");
		for (Professor profile : repository.findAll())
		{
			System.out.println(profile);
		}
		System.out.println();
		logger.log(Level.INFO,"Logger example:"+firstProfessor.toString());
		// fetch an individual profile
		System.out.println("Profiles found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Profiles found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Professor profile : repository.findByLastName("Smith"))
		{
			System.out.println(profile);
		}

		System.out.println();

		System.out.println("Profiles found with findByFirstName('Angela'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Angela"));

		System.out.println("Profiles found with findByLastName('Li'):");
		System.out.println("--------------------------------");
		for (Professor profile : repository.findByLastName("Li"))
		{
			System.out.println(profile);
		}

		System.out.println("--------------------------------");
		System.out.println("--------------------------------");
		System.out.println("--------------------------------");
		System.out.println("Profile mit leerer Beschreibung: ");

		System.out.println(repository.findByDescription(new ProfessorDescription("")));

		System.out.println("----------------------------------");
		System.out.println("Projekte: ");

		System.out.println(projektRepository.findByName("TestProjekt"));

		firstProfessor.addProjekt(firstProjekt);
		repository.save(firstProfessor);
		projektRepository.save(firstProjekt);

//		firstProjekt.getProfessors_ids().add(firstProfessor);
//		projektRepository.save(firstProjekt);


		System.out.println("Profiles found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.err.println(repository.findByFirstName("Alice"));



		System.out.println("----------------------------------");
		System.out.println("Projekte: ");

		System.err.println(projektRepository.findByName("TestProjekt"));
	}
}
