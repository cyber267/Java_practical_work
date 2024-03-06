package jdbc;

import fr.epita.person.datamodel.person;

import java.io.IOException;
import java.util.List;

public class TestSER2 {
    public static void test() throws IOException {
        PersonCSVDAO dao = new PersonCSVDAO();
        List<person> persons = dao.readAll();
        for (person person : persons) {
            System.out.println(person);
        }
    }
}
