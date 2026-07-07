import java.util.Arrays;
import java.util.Comparator;

// Extended Student class with faculty attribute
class Student {
    private String name;
    private int age;
    private double grade;
    private String faculty;

    public Student(String name, int age, double grade, String faculty) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.faculty = faculty; 
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public String getFaculty(){
        return faculty;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-3d %-5.0f %-10s", name, age, grade, faculty);
    }
}

// Custom Comparator that sorts by faculty in ascending order then grade in descending order
class FacultyGradeComparator implements Comparator<Student> {
    
    @Override
    public int compare(Student s1, Student s2) {
        // First: Compare by faculty (ascending order of alphabet)
        int facultyComparison = s1.getFaculty().compareToIgnoreCase(s2.getFaculty());

        // If faculties are different, return the faculty comparison result
        if (facultyComparison != 0) {
            return facultyComparison;
        }

      // If faculties are the same, compare by grade in descending order
      // Higher grades should come first, so reverse the comparison
      if (s1.getGrade() > s2.getGrade()) {
        return -1; 
      } else if (s1.getGrade() < s2.getGrade()) {
        return 1;
      } else {
        return 0; // Grades are equal
      }
    }
}

public class FacultyGradeRank {

    public static void main(String[] args) {
        // Create array of Student objects
        Student[] students = {
            new Student("Adam", 20, 32, "Health"),
            new Student("Ben",22, 87, "Arts"),
            new Student("Cindy", 21, 65, "Business"),
            new Student("Daniel", 19, 43, "Engineering"),
            new Student("Emily", 22, 91, "Science"),
            new Student("Frankie", 21, 16, "Education"),
            new Student("Gemma", 19, 29, "Law"),
            new Student("Hilary", 23, 40, "Science"),
            new Student("Iwan", 22, 88, "Arts"),
            new Student("Jake", 21, 58, "Science")
        };
    // Display unsorted students
    System.out.println("Unsorted students:");
    displayStudents(students);

    // Sort using custom Comparator
    Arrays.sort(students, new FacultyGradeComparator());

    // Display sorted students
    System.out.println("\nSorted Students:");
    displayStudents(students); 
}

    // Display array of students
    private static void displayStudents(Student[] students) {
        System.out.println(String.format("%-15s %-3s %-5s %-10s","NAME", "AGE", "GRADE", "FACULTY"));
    
    for (Student student : students) {
        System.out.println(student);
    }
    }
}