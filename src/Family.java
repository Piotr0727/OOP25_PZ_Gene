import java.util.HashMap;
import java.util.Map;

public class Family {
    private Map<String, Person> people = new HashMap<>();
    public void add(Person peopleToAdd){
        String newKey = peopleToAdd.getFirst_name()+ " " + peopleToAdd.getLast_name();
        if (people.containsKey(newKey))
            return;
        people.put(newKey,peopleToAdd);
    }
    public void addPeople(Person... peopleToAdd){
        for(Person p : peopleToAdd)
            add(p);
    }
    public Person get(String key){
        return people.get(key);
    }

}
