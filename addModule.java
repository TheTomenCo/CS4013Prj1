import java.util.Arrays;
import public Students student;
import public Programme programmeName;

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


    public void addModules() {

        //reading students
        String[][] students = Students.students;

        //check if there are students in the array
        if (students == null || students.length == 0) {
            System.out.println("No students found.");
            return;
        }

        //if there are students, it starts filtering through them
        for (int i = 0; i < students.length; i++) {

            //read the details
            String studentID = students[i][0];
            String studentName = students[i][1];

            //get their program
            String program = Program.getProgram(studentID);

            String[] semesterTwo;

            // SYSTEMS
            if (program.equalsIgnoreCase("Systems")) {

                semesterTwo = Arrays.copyOf(
                        systemsSemesterTwo,
                        systemsSemesterTwo.length
                );

            }

            // ACCOUNTING
            else if (program.equalsIgnoreCase("Accounting")) {

                semesterTwo = Arrays.copyOf(
                        accountingSemesterTwo,
                        accountingSemesterTwo.length
                );

            }

            else {
                System.out.println("No programme found for " + studentID);
                continue;
            }

            // Display assigned Semester 2 modules
            System.out.println("Student ID: " + studentID);
            System.out.println("Student Name: " + studentName);
            System.out.println("Semester 2 Modules:");

            for (String module : semesterTwo) {
                System.out.println(module);
            }

            System.out.println();
        }
    }
}

void main() {
}
