import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
//        System.out.println("EOP");
        Person parent = new Person("Alojzy","Czeremcha", LocalDate.of(1903,12,7));
        Person child1 = new Person("Grazyna","Duda", LocalDate.of(1951,4,8));
        Person child2 = new Person("Ksawery","Czeremcha", LocalDate.of(1955,8,2));
        Person child3 = new Person("Brajan","Czeremcha", LocalDate.of(1959,4,2));
        Person child4 = new Person("Dżesika","Mercedes", LocalDate.of(2000,6,9));
        people.add(parent);
        people.add(child1);
        people.add(child2);
        people.add(child3);
        people.add(child4);
        child1.setFather(parent);
        parent.adopt(child1);
        parent.adopt(child2);
        parent.adopt(child3);
        parent.adopt(child4);
        parent.getYoungestChild();
    }
}