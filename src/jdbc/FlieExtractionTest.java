package jdbc;

import fr.epita.person.datamodel.person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FlieExtractionTest {
    public static void main(String[] args) throws IOException {
        Path currentFilePath = Path.of("data/data.csv");
        System.out.println("looking for file at this location:" + currentFilePath.toFile().getAbsolutePath());
        List<String> lines = Files.readAllLines(currentFilePath);
//        System.out.println(lines);

        List<person> persons = new ArrayList<>();
        lines.remove(0);
        for (String line : lines){
            String[] parts = line.split(",");
            person Person = extractPerson(parts);
            persons.add(Person);
        }

        List<person> personWithStream = lines.stream()
                .map(s -> extractPerson(s.split(",")))
                .toList();

        System.out.println(personWithStream);

    }

    private static person extractPerson(String[] row) {
        person person = new person();
        person.setName(row[0]);
        person.setSex(row[1]);
//        person.setAge(Integer.parseInt(row[2]));
//        person.setHeight(Integer.parseInt(row[3]));
//        person.setWeight(Integer.parseInt(row[4]));

        return person;
    }
}
