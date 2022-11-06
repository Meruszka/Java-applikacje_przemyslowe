package pl.smerski.app.lab03;

import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.smerski.app.lab03.domain.Person;
import pl.smerski.app.lab03.service.ParseCSV;

import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
public class Zad1Application {
	static ParseCSV parseCSV = new ParseCSV();

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(Zad1Application.class, args);
		String csv = parseCSV.getCSV();
		for (CSVRecord record: parseCSV.parseCSV(csv)) {
			Person person = new Person(record.get("id"), record.get("name"), record.get("surname"), record.get("email"), record.get("company_name"));

		}
	}
}
