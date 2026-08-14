import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("      STUDENT GRADE CALCULATOR");
        System.out.println("====================================");

        // Number of subjects
        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        int totalMarks = 0;

        // Input marks for each subject
        for (int i = 1; i <= subjects; i++) {

            int marks;

            while (true) {
                System.out.print("Enter marks for Subject " + i + " (out of 100): ");
                marks = sc.nextInt();

                if (marks >= 0 && marks <= 100) {
                    break;
                }

                System.out.println("Invalid marks! Please enter marks between 0 and 100.");
            }

            totalMarks += marks;
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / subjects;

        // Grade calculation
        String grade;

        if (averagePercentage >= 90) {
            grade = "A+";
        } 
        else if (averagePercentage >= 80) {
            grade = "A";
        } 
        else if (averagePercentage >= 70) {
            grade = "B";
        } 
        else if (averagePercentage >= 60) {
            grade = "C";
        } 
        else if (averagePercentage >= 50) {
            grade = "D";
        } 
        else if (averagePercentage >= 40) {
            grade = "E";
        } 
        else {
            grade = "F";
        }

        // Display results
        System.out.println("\n====================================");
        System.out.println("           RESULT");
        System.out.println("====================================");

        System.out.println("Total Marks       : " + totalMarks + "/" + (subjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade             : " + grade);

        System.out.println("====================================");

        sc.close();
    }
}