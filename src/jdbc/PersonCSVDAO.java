package jdbc;

import fr.epita.person.datamodel.person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonCSVDAO {
    public static List<person> readAll () throws IOException {
        Path currentFilePath = Path.of("data/data.csv");
//        System.out.println("looking for file at this location:" + currentFilePath.toFile().getAbsolutePath());
        List<String> lines = Files.readAllLines(currentFilePath);
//        System.out.println(lines);

        List<person> persons = new ArrayList<>();
        lines.remove(0);

        for (String line : lines){
            String[] parts = line.split(",");
            person Person = extractPerson(parts);
            persons.add(Person);
        }
        return persons.stream()
                .sorted(Comparator.comparingInt(person::getHeight))
                .collect(Collectors.toList());
    }



    private static person extractPerson(String[] row)  {
        person person = new person();
        person.setName(row[0]);
        person.setSex(row[1].trim());
        person.setAge(Integer.parseInt(row[2].trim()));
        person.setHeight(Integer.parseInt(row[3].trim()));
        person.setWeight(Integer.parseInt(row[4].trim()));
        return person;

}
}
