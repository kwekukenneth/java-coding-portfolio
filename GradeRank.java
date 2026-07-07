// GradeRank.java
import java.util.*;

public class GradeRank {
    
    public static void insertionSort(List<Student> students) {
        int n = students.size();
        for (int i = 1; i < n; i++) {
            Student key = students.get(i);
            int j = i - 1;
            while (j >= 0 && students.get(j).compareTo(key) > 0) {
                students.set(j + 1, students.get(j));
                j--;
            }
            students.set(j + 1, key);
        }
    }
    
    public static List<Student> generateStudents(int count) {
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Edward", 
                         "Fiona", "George", "Hannah", "Isaac", "Julia",
                         "Kevin", "Laura", "Michael", "Nina", "Oliver"};
        List<Student> students = new ArrayList<>();
        Random rand = new Random();
        
        for (int i = 0; i < count; i++) {
            String name = names[i % names.length] + (i / names.length > 0 ? i / names.length : "");
            int age = 18 + rand.nextInt(5);
            double grade = 60 + rand.nextDouble() * 40;
            students.add(new Student(name, age, grade));
        }
        return students;
    }
    
    public static void main(String[] args) {
        List<Student> students = generateStudents(10);
        
        System.out.println("Original List:");
        for (Student s : students) {
            System.out.println(s);
        }
        
        // Collections.sort()
        List<Student> list1 = new ArrayList<>(students);
        long start1 = System.nanoTime();
        Collections.sort(list1);
        long end1 = System.nanoTime();
        
        System.out.println("\nSorted with Collections.sort():");
        for (Student s : list1) {
            System.out.println(s);
        }
        System.out.println("Time: " + (end1 - start1) + " nanoseconds");
        
        // Insertion Sort
        List<Student> list2 = new ArrayList<>(students);
        long start2 = System.nanoTime();
        insertionSort(list2);
        long end2 = System.nanoTime();
        
        System.out.println("\nSorted with Insertion Sort:");
        for (Student s : list2) {
            System.out.println(s);
        }
        System.out.println("Time: " + (end2 - start2) + " nanoseconds");
    }
}