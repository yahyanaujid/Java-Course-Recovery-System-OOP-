package Eligibility_Check_and_Enrolment;

/**
 * Student is a specific type of Person.
 */
public class EligibilityStudent extends Person {

    private int failedCourses;
    private double cgpa;
    // 1 = Freshman, 2 = Sophomore, 3 = Junior, 4 = Senior, 5 = Graduated
    private int currentLevel;

    // Matches: new Student(studentID, fullName, level);
    public EligibilityStudent(String studentID, String fullName, int currentLevel) {
        super(studentID, fullName);   // Person(id, name)
        this.currentLevel = currentLevel;
        this.failedCourses = 0;
        this.cgpa = 0.0;
    }

    // Used in the table for Student ID
    public String getStudentID() {
        return getId(); // from Person
    }

    // --- Getters ---
    public int getFailedCourses() {
        return failedCourses;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    // --- Setters ---
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public void setFailedCourses(int failedCourses) {
        this.failedCourses = failedCourses;
    }

    // Eligibility: CGPA >= 2.0 AND failedCourses <= 1
    public boolean isEligible() {
        return cgpa >= 2.0 && failedCourses <= 1;
    }

    // Year as text for the table
    public String getYearText() {
        switch (currentLevel) {
            case 1: return "Freshman";
            case 2: return "Sophomore";
            case 3: return "Junior";
            case 4: return "Senior";
            case 5: return "Graduated";
            default: return "Unknown";
        }
    }

    // Progression logic
    public void progress() {
        if (currentLevel >= 1 && currentLevel < 4) {
            currentLevel++;   // Freshman → Sophomore → Junior → Senior
        } else if (currentLevel == 4) {
            currentLevel = 5; // Graduated
        }
        // If already 5, do nothing
    }
}