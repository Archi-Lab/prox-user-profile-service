package io.archilab.prox.userprofileservice;

import io.archilab.prox.userprofileservice.professor.*;
import io.archilab.prox.userprofileservice.project.Projekt;
import io.archilab.prox.userprofileservice.project.ProjektRepository;
import io.archilab.prox.userprofileservice.project.Projektart;
import io.archilab.prox.userprofileservice.project.Status;
import io.archilab.prox.userprofileservice.tag.Tag;
import io.archilab.prox.userprofileservice.tag.TagRepository;
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
	@Autowired
	private TagRepository tagRepository;

	public static void main(String[] args)
	{
		SpringApplication.run(UserProfileServiceApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception
	{
		repository.deleteAll();
		projektRepository.deleteAll();
		tagRepository.deleteAll();

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
		logger.log(Level.INFO, "Profiles found with findAll():");
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

//		BEISPIELDATEN

		Tag st1 = new Tag("ST1");
		Tag mci = new Tag("MCI");
		Tag ki = new Tag("KI");

		tagRepository.save(st1);
		tagRepository.save(mci);
		tagRepository.save(ki);

		Projekt projekt1 = new Projekt("Entwicklung eines innovativen NOx-Sensors für die In-situ Rauchgasmessung in Zementanlagen",
				"Charakterisierung der Funktionsschichtmorphologie und -analyse von NOx-Sensoren in Abhängigkeit von Material, Fertigungsprozess und Betriebsbedingungen",
				"NONE", Projektart.PROJEKTARBEIT, Status.OFFEN, 6);

		Projekt projekt2 = new Projekt("IMProvT", "IMProvT — Intelligente Messverfahren zur Prozessoptimierung von Trinkwasserbereitstellung",
					"Das Projekt IMProvT behandelt die Gewinnung und Nutzung mehrdimensionaler Prozessdaten zur energie- und ressourceneffizienten Optimierung und Prozesssteuerung bei der Trinkwasseraufbereitung.",
					Projektart.PROJEKTARBEIT, Status.LAUFEND, 6);

		Projekt projekt3 = new Projekt("SYNERGY", "SYNERGY — Synergy for Smart Multi-Objective Optimization",
				"Die TH Köln und die Universität Lille unterstützen das Josef Stefan Institut in Ljubljana/Slowenien beim Aufbau und der Weiterentwicklung seiner Forschungsstrukturen. ",
				Projektart.PROJEKTARBEIT, Status.LAUFEND, 6);

		Projekt projekt4 = new Projekt("UTOPIAE", "UTOPIAE – UNCERTAINTY TREATMENT AND OPTIMISATION IN AEROSPACE ENGINEERING",
				"Das Projekt IMProvT behandelt die Gewinnung und Nutzung mehrdimensionaler Prozessdaten zur energie- und ressourceneffizienten Optimierung und Prozesssteuerung bei der Trinkwasseraufbereitung.",
				Projektart.PROJEKTARBEIT, Status.LAUFEND, 6);

		projektRepository.save(projekt1);
		projektRepository.save(projekt2);
		projektRepository.save(projekt3);
		projektRepository.save(projekt4);

		Professor prof = new Professor("Max", "Mustermann", Title.PROFESSOR, "Raum 1506", 49226181966367L, "Max.Mustermann@th-koeln.de",
										"NONE", "https://ip-ws2019.prox.archi-lab.io/assets/images/profile/placeholder.jpg",
										Fachgebiet.INFORMATIK, new ProfessorDescription(""));

		repository.save(prof);

		prof.addTag(st1);
		prof.addTag(mci);
		prof.addTag(ki);

		prof.addProjekt(projekt1);
		prof.addProjekt(projekt2);
		prof.addProjekt(projekt3);
		prof.addProjekt(projekt4);

		repository.save(prof);

		// Test ob er doppelt hinzufügt - tut er wie man sieht nicht also funktioniert die Methode wie sie soll
		prof.addProjekt(projekt1);

		projektRepository.save(projekt1);
		projektRepository.save(projekt2);
		projektRepository.save(projekt3);
		projektRepository.save(projekt4);

		logger.log(Level.INFO, "---------------------------------");
		logger.log(Level.INFO, "---------BEISPIELDATEN-----------");
		logger.log(Level.INFO, "Ergebniss: " + repository.findByLastName("Mustermann"));
		logger.log(Level.INFO, "Ergebniss: " + projektRepository.findByName("SYNERGY"));

	}
}
