package is.hi.kas108.hbv202g.assignment11;
/**
 * Represents a student user in the library system
 * A student has a name and a status indicating whether the library fee has been paid
 */
public class Student extends User {
    private boolean feePaid;

    /**
     * Constructs a Student with the specified name and fee payment status
     * @param name The name of the student
     * @param feePaid Indicates whether the student has paid the library fee
     */
    public Student(String name, boolean feePaid) {
        super(name);

        this.feePaid = feePaid;

    }
    /**
     * Checks if the student has paid the library fee
     * @return {@code true} if the fee is paid; {@code false} otherwise
     */
    public boolean isFeePaid() {
        return feePaid;
    }
    /**
     * Sets the fee payment status of the student
     * @param feePaid {@code true} if the fee has been paid; {@code false} otherwise
     */
    public void setFeePaid(boolean feePaid) {
        this.feePaid = feePaid;
    }
}
