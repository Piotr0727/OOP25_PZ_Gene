import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Person implements Comparable<Person>{
    private String first_name,last_name;
    private LocalDate birthday;
    private Set<Person> children;

    public boolean adopt(Person child){
        return children.add(child);
    }
    public Person getYoungestChild(){
//        if(children.isEmpty())
//            return null;
        LocalDate youngestChildAge = LocalDate.MIN;
        Person youngestChild = null;
        for (Person child: children){
            if (child.birthday.isAfter(youngestChildAge)) {
                youngestChildAge = child.birthday;
                youngestChild = child;
            }
        }
        return youngestChild;
    }

    @Override
    public int compareTo(Person o) {
        return this.birthday.compareTo(o.birthday);
    }

    public Person(String first_name, String last_name, LocalDate birthday) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthday = birthday;
        this.children = new TreeSet<>();
    }
    public List<Person> getChildren(){
        return List.copyOf(children);
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }
}
