import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Enter student information
        System.out.print("Enter registration number: ");
        String regNo = input.nextLine();

        System.out.print("Enter student name: ");
        String name = input.nextLine();

        System.out.print("Enter age: ");
        int age = input.nextInt();

        System.out.print("Enter mark 1: ");
        double mark1 = input.nextDouble();

        System.out.print("Enter mark 2: ");
        double mark2 = input.nextDouble();

        System.out.print("Enter mark 3: ");
        double mark3 = input.nextDouble();

        // Create Student object
        Student student = new Student(
            regNo, name, age, mark1, mark2, mark3
        );

        // Display student information
        student.displayInformation();

        input.close();
    }
}
