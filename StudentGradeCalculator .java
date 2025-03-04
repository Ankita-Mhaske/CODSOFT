import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Taking input for the number of subjects
            int numSubjects;
            while (true) {
                System.out.print("\nEnter the number of subjects: ");
                numSubjects = scanner.nextInt();
                if (numSubjects > 0) {
                    break;
                } else {
                    System.out.println("Invalid input! Number of subjects must be greater than 0.");
                }
            }

            int[] marks = new int[numSubjects];
            int totalMarks = 0;

            // Taking input for marks in each subject
            for (int i = 0; i < numSubjects; i++) {
                while (true) {
                    System.out.print("Enter marks for Subject " + (i + 1) + " (out of 100): ");
                    marks[i] = scanner.nextInt();

                    // Validate marks input
                    if (marks[i] >= 0 && marks[i] <= 100) {
                        break;
                    } else {
                        System.out.println("Invalid marks! Please enter a value between 0 and 100.");
                    }
                }
                totalMarks += marks[i];
            }

            // Calculate average percentage
            double averagePercentage = (double) totalMarks / numSubjects;

            // Determine grade and remarks
            String grade, remarks;
            if (averagePercentage >= 90) {
                grade = "A+";
                remarks = "Excellent Performance! ";
            } else if (averagePercentage >= 80) {
                grade = "A";
                remarks = "Very Good! ";
            } else if (averagePercentage >= 70) {
                grade = "B";
                remarks = "Good Effort! ";
            } else if (averagePercentage >= 60) {
                grade = "C";
                remarks = "Satisfactory! Keep Improving! ";
            } else if (averagePercentage >= 50) {
                grade = "D";
                remarks = "Needs Improvement! ";
            } else {
                grade = "F (Fail)";
                remarks = "Failed! Better Luck Next Time! ";
            }

            // Convert percentage to CGPA (out of 10)
            double cgpa = averagePercentage / 10;

            // Display Results
            System.out.println("\n=================================");
            System.out.println("         Student Report          ");
            System.out.println("=================================");
            for (int i = 0; i < numSubjects; i++) {
                System.out.println("Subject " + (i + 1) + " Marks: " + marks[i] + "/100");
            }
            System.out.println("---------------------------------");
           
