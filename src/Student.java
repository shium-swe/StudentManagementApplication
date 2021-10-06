package StudentManagementApp;

import java.util.Scanner;
import java.util.ArrayList;

public class Student {
    private String firstName;
    private String lastName;
    private String gradeYear;
    private String studentID;
    private int tuitionBalance = 0;
    private static int courseCost = 600;
    private static int id = 1000;

    ArrayList<String> courses = new ArrayList<String>();

    public Student() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter student information below");

        System.out.print("First name: ");
        this.firstName = in.nextLine();

        System.out.print("Last name: ");
        this.lastName = in.nextLine();

        System.out.println("Grade year: \n9 - 9th (Freshman)\n10 - 10th (Sophomore)\n11 - 11th (Junior)\n12 - 12th (Senior)");
        this.gradeYear = in.nextLine();

        setStudentID();

        System.out.println(firstName + " " + lastName + " " + studentID);
    }

    private void setStudentID() {
        id++;
        this.studentID = gradeYear + "" + id;
    }

    public void enroll() {
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter the courses to enroll the student in (Enter q to quit). ");
            String course = in.nextLine();

            if (!course.equals("q")) {
                courses.add(course);
                tuitionBalance += courseCost;
            }

            else {
                break;
            }
        } while (1 != 0);
    }

    public void viewBalance() {
        System.out.println("Student's balance is $" + tuitionBalance);
    }

    public void payTuition() {
        viewBalance();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter payment amount: ");
        int payment = in.nextInt();
        tuitionBalance -= payment;
        System.out.println("Payment of $" + payment + " went through");
        viewBalance();
    }

    public void showInfo() {
        StringBuffer sb = new StringBuffer();

        for (String s : courses) {
            sb.append(s);
            sb.append(", ");
        }

        String courseItems = sb.toString();
        System.out.println("Name: " + firstName + " " + lastName +
                "\nGrade level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses enrolled: " + courseItems +
                "\nBalance: $" + tuitionBalance);
    }

}
