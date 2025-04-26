import java.util.Scanner;

interface GradeCalculator {
    String calculateGrade(double marks);
}

class Person {
    String name;
    int age;

    Person() {
        name = "Unknown";
        age = 0;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Student extends Person {
    int studentId;
    static int count = 0;

    Student(String name, int age, int studentId) {
        super(name, age);
        this.studentId = studentId;
        count++;
    }

    void displayStudentInfo() {
        super.displayInfo();
        System.out.println("Student ID: " + studentId);
    }

    static void showTotalStudents() {
        System.out.println("Total Students: " + count);
    }
}

class GraduateStudent extends Student implements GradeCalculator {
    String thesisTopic;

    GraduateStudent(String name, int age, int studentId, String thesisTopic) {
        super(name, age, studentId);
        this.thesisTopic = thesisTopic;
    }

    @Override
    public String calculateGrade(double marks) {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else return "F";
    }

    void displayGraduateInfo() {
        displayStudentInfo();
        System.out.println("Thesis Topic: " + thesisTopic);
    }
}

class Course {
    String courseName;
    int duration;

    Course(String courseName) {
        this.courseName = courseName;
        this.duration = 3;
    }

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void showCourseDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " months");
    }

    int calculateFees(int feePerMonth) {
        return duration * feePerMonth;
    }

    int calculateFees(int feePerMonth, int discount) {
        return (duration * feePerMonth) - discount;
    }
}

public class StudentInformationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get Student info from user
        System.out.println("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Age: ");
        int age = sc.nextInt();

        System.out.println("Enter Student ID: ");
        int studentId = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        // Create Student
        Student s1 = new Student(name, age, studentId);
        System.out.println("\n--- Student Info ---");
        s1.displayStudentInfo();

        // Graduate Student Info
        System.out.println("\n--- Graduate Student Section ---");
        System.out.println("Enter Graduate Student Name: ");
        String gName = sc.nextLine();

        System.out.println("Enter Age: ");
        int gAge = sc.nextInt();

        System.out.println("Enter Student ID: ");
        int gId = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Enter Thesis Topic: ");
        String thesis = sc.nextLine();

        GraduateStudent g1 = new GraduateStudent(gName, gAge, gId, thesis);
        System.out.println("\n--- Graduate Student Info ---");
        g1.displayGraduateInfo();

        System.out.println("Enter Marks to Calculate Grade: ");
        double marks = sc.nextDouble();
        System.out.println("Grade: " + g1.calculateGrade(marks));

        // Course Info
        System.out.println("\n--- Course Info ---");
        sc.nextLine(); // consume leftover newline
        System.out.println("Enter Course Name: ");
        String courseName = sc.nextLine();

        System.out.println("Enter Course Duration (months): ");
        int duration = sc.nextInt();

        System.out.println("Enter Fee per Month: ");
        int feePerMonth = sc.nextInt();

        System.out.println("Enter Discount Amount: ");
        int discount = sc.nextInt();

        Course c1 = new Course(courseName, duration);
        c1.showCourseDetails();
        System.out.println("Total Fees (without discount): ₹" + c1.calculateFees(feePerMonth));
        System.out.println("Total Fees (with discount): ₹" + c1.calculateFees(feePerMonth, discount));

        // Total Student Count
        System.out.println();
        Student.showTotalStudents();

        sc.close();
    }
}