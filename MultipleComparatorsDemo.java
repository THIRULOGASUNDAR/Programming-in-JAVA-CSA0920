import java.util.*;

// Student Class
class Student {
    private String name;
    private int marks;

    // Constructor
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // Getter Methods
    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}

// Comparator to Sort by Name
class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareToIgnoreCase(s2.getName());
    }
}

// Comparator to Sort by Marks
class MarksComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getMarks(), s2.getMarks());
    }
}

// Main Class
public class MultipleComparatorsDemo {

    // Method to Display Students
    public static void displayStudents(List<Student> students) {

        System.out.println("--------------------------------------");
        System.out.printf("%-15s %-10s%n", "Student Name", "Marks");
        System.out.println("--------------------------------------");

        for (Student s : students) {
            System.out.printf("%-15s %-10d%n", s.getName(), s.getMarks());
        }

        System.out.println("--------------------------------------");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        // User Input
        for (int i = 1; i <= n; i++) {

            System.out.println("\nEnter Details of Student " + i);

            System.out.print("Name  : ");
            String name = sc.nextLine();

            System.out.print("Marks : ");
            int marks = sc.nextInt();
            sc.nextLine();

            students.add(new Student(name, marks));
        }

        // Original List
        System.out.println("\n========== ORIGINAL LIST ==========");
        displayStudents(students);

        // Sort by Name
        Collections.sort(students, new NameComparator());

        System.out.println("\n====== SORTED BY NAME (A-Z) ======");
        displayStudents(students);

        // Sort by Marks
        Collections.sort(students, new MarksComparator());

        System.out.println("\n==== SORTED BY MARKS (LOW-HIGH) ====");
        displayStudents(students);

        sc.close();
    }
}