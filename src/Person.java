import javax.annotation.processing.Filer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Person implements Comparable<Person>{
    private String first_name,last_name;
    private LocalDate birthday, deathday;
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
    public Person(String first_name, String last_name, LocalDate birthday, LocalDate deathday) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthday = birthday;
        this.deathday = deathday;
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

    public LocalDate getDeathday() {
        return deathday;
    }

    public void setDeathday(LocalDate deathday) {
        this.deathday = deathday;
    }
    public static Person fromCsvLine(String line) throws NegativeLifespanException {
        String[] collumns = line.split(",");
        String[] flname = collumns[0].split(" ");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthday = null;
        LocalDate deathday = null;
        if(isNotEmpty(collumns[1])){
            birthday = LocalDate.parse(collumns[1], formatter);
        }
        if(isNotEmpty(collumns[2])){
            deathday = LocalDate.parse(collumns[2], formatter);
            if(isNotEmpty(collumns[1]) && deathday.isBefore(birthday))
                throw new NegativeLifespanException(flname[0],flname[1]);
        }

        return new Person(flname[0],flname[1],birthday,deathday);
    }
    public static boolean isNotEmpty(String s){
        return s != null && s != "" && s != " " && s != "\t";
    }
    public static List<Person> fromCsv(String fpath){
        List<Person> people = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fpath));
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                Person readPerson = fromCsvLine(line);
                for(Person existingPerson : people){
                    if(!(existingPerson.first_name.equals(readPerson.first_name)
                            && existingPerson.last_name.equals(readPerson.first_name))){
                        people.add(readPerson);
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("File doesn't exist");
        } catch (IOException e) {
            System.err.println("yesn't");
        } catch (NegativeLifespanException e) {
            System.err.print(e.getMessage());
        }
        return people;
    }
}
