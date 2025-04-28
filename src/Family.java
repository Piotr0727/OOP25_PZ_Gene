import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Family {
    private Map<String, List<Person>> people = new HashMap<>();
    public void add(Person peopleToAdd){
        String newKey = peopleToAdd.getFirst_name()+ " " + peopleToAdd.getLast_name();
        if (people.containsKey(newKey))
            return;
        people.put(newKey,List.add(peopleToAdd));
    }
    public void addPeople(Person... peopleToAdd){
        for(Person p : peopleToAdd)
            add(p);
    }
    public List<Person> get(String key){
        List<Person> temp = new ArrayList<>();
        //temp.sort();
        return people.get(key);
    }

}