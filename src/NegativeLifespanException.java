public class NegativeLifespanException extends Exception{
    public NegativeLifespanException(String fname, String lname) {
        super(String.format("Person %s %s has invalid day of birth/death (age is negative)",fname,lname));
    }
}
