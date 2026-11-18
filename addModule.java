import java.util.Arrays;

public class addModule {

    // names of these will probably need to change depending on what Áine names her files
    private Students student;
    private Program program;

    //systems classes
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

    //accounting classes
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


    public void addModules(Students[] students) {

        //checking how many students are in the array
        if (students == null || students.length == 0) {
            System.out.println("No students found.");
            return;
        }

        //go through all the students
        for (int i = 0; i < students.length; i++) {

            student = students[i];

            //get the students ID number
            int studentID = student.getStudentID();

            //calling the function to get their program
            program = student.getProgram();

            String[] semesterOne;
            String[] semesterTwo;

            if (program.toString().equalsIgnoreCase("Systems")) {
                // Systems
                semesterTwo = systemsSemesterTwo;

            } else (program.toString().equalsIgnoreCase("Accounting")) {
                // accounting
                semesterTwo = accountingSemesterTwo;

            }

            //attaching the modules for that semester
            student.setModules(semesterTwo);


            //printing their modules
            System.out.println("Student ID: " + studentID);
            System.out.println("Modules:");

            for (String module : allModules) {
                System.out.println(module);
            }

            System.out.println();
        }
    }
}
