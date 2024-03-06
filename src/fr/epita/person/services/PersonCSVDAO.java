package fr.epita.person.services;

import fr.epita.person.datamodel.person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class PersonCSVDAO {
    public List<person> read() throws PersonExtractionException {
        Path currentFilePath = Path.of("data/data.csv");
        System.out.println("looking for file at this location:" + currentFilePath.toFile().getAbsolutePath());
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(currentFilePath);
        } catch (IOException e){
            throw new PersonExtractionException(e);
        }
        List<person> persons = new ArrayList<>();
        lines.remove(0);
        for (String line : lines){
            String[] parts = line.split(";");
            person patient = extractPatient(parts);
            persons.add(patient);
        }
        return persons;
}

    public void update(List<person> patients) throws PersonExtractionException, PersonUpdateException {
        Path currentFilePath = Path.of("patients-data-extraction/data/patients-out.csv");
        String patientsAsCsv = "";
        for (person patient : patients) {
            //pat_num_HC;pat_lastname;pat_firstname;pat_address;pat_tel;pat_insurance_id;pat_subscription_date
            patientsAsCsv += patient.getName() + ";";
            patientsAsCsv += patient.getAge() + ";";
            patientsAsCsv += patient.getSex() + ";";
            patientsAsCsv += patient.getHeight() + ";";
            patientsAsCsv += patient.getWeight() + ";";
            patientsAsCsv += System.getProperty("line.separator");
        }
        try {
            Files.write(currentFilePath, patientsAsCsv.getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e){
            throw new PersonUpdateException(e);
        }
    }


    private static person extractPatient(String[] row) {
        person person = new person();
        person.setName(row[0]);
        person.setAge(Integer.parseInt(row[1]));
        person.setSex(row[2]);
        person.setHeight(Integer.parseInt(row[3]));
        person.setWeight(Integer.parseInt(row[4]));
        return person;
    }

}