public class Student implements Comparable <Student> {
    private String name;
    private int age;
    private double grade;

public Student(String name, int age, double grade) {
    this.name = name;
    this.age = age;
    this.grade = grade;
}

public String getName() { return name; }
public int getAge() { return age; }
public double getGrade() { return grade; }

@Override
public int compareTo(Student other) {
    // Sorting of grades in descending order
    return Double.compare(other.grade, this.grade);
}

@Override
public String toString() {
    return name + "(Age: " + age + ", Grade: " + grade + ")";
}
}

