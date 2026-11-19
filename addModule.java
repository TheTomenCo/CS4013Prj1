import java.util.Arrays;

public class addModule {

    //systems
    String[] systemsSemesterOne = {
            "Introduction to Programming",
            "Discrete Mathematics",
            "Representation and Modelling",
            "Foundations of Computer Science 1",
            "Fundamentals of Computer Organisation"
    };

    String[] systemsSemesterTwo = {
            "Games Modelling Design",
            "Computer Maths 2",
            "Software Development",
            "Foundations of Computer Science 2",
            "Computing System Organisation"
    };

    //accounting
    String[] accountingSemesterOne = {
            "Financial Information Analysis",
            "Corporate Finance",
            "Taxation Theory and Practice",
            "Finance",
            "Capital Taxation"
    };

    String[] accountingSemesterTwo = {
            "Cooperative Education"
    };


    public void addModules(String[][] students, String[] studentProgrammes) {

        if (students == null || students.length == 0) {
            System.out.println("No students found.");
            return;
        }

        for (int i = 0; i < students.length; i++) {

            String studentID = students[i][0];
            String studentName = students[i][1];
            String program = studentProgrammes[i];

            String[] semesterTwo;

            if (program.equalsIgnoreCase("Systems")) {

                semesterTwo = Arrays.copyOf(
                        systemsSemesterTwo,
                        systemsSemesterTwo.length
                );

            } else if (program.equalsIgnoreCase("Accounting")) {

                semesterTwo = Arrays.copyOf(
                        accountingSemesterTwo,
                        accountingSemesterTwo.length
                );

            } else {
                System.out.println("No programme found for " + studentID);
                continue;
            }

            System.out.println("Student Name: " + studentName);
            System.out.println("Student ID: " + studentID);
            System.out.println("Programme: " + program);
            System.out.println("Semester 2 Modules:");

            for (String module : semesterTwo) {
                System.out.println(module);
            }

            System.out.println();
        }
    }
}
