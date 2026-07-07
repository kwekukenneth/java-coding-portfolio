
// Custom exception for invalid salary values
class InvalidSalaryException extends Exception {
    private int salary;

    public InvalidSalaryException(int salary){
        this.salary = salary;
    }

    @Override
    public String toString() {
        return salary + "is not a valid positive salary.";
    }
    
}
