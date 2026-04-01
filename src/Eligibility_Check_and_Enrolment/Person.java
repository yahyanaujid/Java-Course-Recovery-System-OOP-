package Eligibility_Check_and_Enrolment;

// Base class (Abstraction + Encapsulation)
public class Person {
    private String id;
    private String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // --- Getters ---
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // --- Setters (if you need them) ---
    public void setName(String name) {
        this.name = name;
    }
}