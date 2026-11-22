import java.util.Arrays;

public class Main {
    static void main (String[] args){
        String[] programmeName = {
                "Bachelors Of Computer Science",
                "Bachelors Of Accounting"
        };
        for (String programme : programmeName) {
            System.out.println(programme);
        }

        String[][] students = {
                {"250001", "Jane Doe"},
                {"250002", "Alice Liddle"},
                {"250003", "Tingle Burberry"},
                {"250004", "Bryan Hodukavich"}
        };

        for (String[] student : students) {
            System.out.println(student[0] + " - " + student[1]);
        }


        //systems modules
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

        String[] systemsSemesterThree = {
                "Operating Systems",
                "Software Testing and Inspection",
                "Database Systems",
                "Object Oriented Development",
                "Software Requirements and Modelling "
        };

        //accounting modules
        String[] accountingSemesterOne = {
                "Financial Information Analysis",
                "Corporate Finance",
                "Taxation Theory and Practice",
                "Finance",
                "Capital Taxation"
        };

        String[] studentProgrammes = {
                "Systems",
                "Accounting",
                "Systems",
                "Accounting"
        };

        String[][] modulesByStudent = addModules(
                students,
                studentProgrammes,
                systemsSemesterThree,
                accountingSemesterOne
        );

        recordModuleResults results = new recordModuleResults();

        String[][] recordedGrades = results.addGrades(
                students,
                modulesByStudent
        );
    }

    public static String[][] addModules(String[][] students,
                                        String[] studentProgrammes,
                                        String[] systemsSemesterThree,
                                        String[] accountingSemesterOne) {

        if (students == null || students.length == 0) {
            System.out.println("No students found.");
            return new String[0][];
        }

        if (studentProgrammes == null ||
                studentProgrammes.length < students.length) {
            System.out.println("Student programme information is incomplete.");
            return new String[0][];
        }

        String[][] modulesByStudent = new String[students.length][];

        for (int i = 0; i < students.length; i++) {

            String studentID = students[i][0];
            String studentName = students[i][1];
            String program = studentProgrammes[i];

            String[] modules;

            if (program.equalsIgnoreCase("Systems")) {

                modules = Arrays.copyOf(
                        systemsSemesterThree,
                        systemsSemesterThree.length
                );

            } else if (program.equalsIgnoreCase("Accounting")) {

                modules = Arrays.copyOf(
                        accountingSemesterOne,
                        accountingSemesterOne.length
                );

            } else {
                System.out.println("No programme found for " + studentID);
                modulesByStudent[i] = new String[0];
                continue;
            }

            modulesByStudent[i] = modules;

            System.out.println("Student Name: " + studentName);
            System.out.println("Student ID: " + studentID);
            System.out.println("Programme: " + program);
            System.out.println("Modules:");

            for (String module : modules) {
                System.out.println(module);
            }

            System.out.println();
        }

        return modulesByStudent;
    }
}


class recordModuleResults {

    //grades are hard coded
    //who each student is, is based off the order of students in the Students.java file.
    //I'm not pulling the names out of thin air trust
    private static final String[][] grades = {

            //Jane Doe
            {"78", "72", "56", "45", "66"},

            // Alice Liddle
            {"24", "22", "79", "0", "98"},

            // Tingle Burberry
            {"89", "78", "90", "75", "76"},

            // Bryan Hodukavich
            {"45", "43", "36", "38", "35"}
    };


    public String[][] addGrades(String[][] students, String[][] modulesByStudent) {

        //check that you have all the info - student name, and their modules
        if (students == null || modulesByStudent == null) {
            System.out.println("Student or module information is missing.");
            return new String[0][];
        }

        //checking all arrays have the same number of entries
        if (students.length != modulesByStudent.length ||
                students.length != grades.length) {

            System.out.println("Student, module and grade records do not match.");
            return new String[0][];
        }

        //making an array to store the grades
        String[][] recordedGrades = new String[students.length][];

        //read each student
        for (int i = 0; i < students.length; i++) {

            // Check student information
            if (students[i] == null || students[i].length < 2) {
                System.out.println("Invalid student record.");
                recordedGrades[i] = new String[0];
                continue;
            }

            String studentID = students[i][0];
            String studentName = students[i][1];

            //printing the student ID and name \n pushes it onto a new line
            System.out.println("\n--------------------------------");
            System.out.println("Student ID: " + studentID);
            System.out.println("Student Name: " + studentName);
            System.out.println("--------------------------------");

            //get the classes
            String[] modules = modulesByStudent[i];

            //get the grades
            String[] studentGrades = grades[i];

            //check that the student has classes assigned
            if (modules == null || modules.length == 0) {
                System.out.println("No modules found for this student.");
                recordedGrades[i] = new String[0];
                continue;
            }

            //make somewhere to store the grades
            recordedGrades[i] = new String[modules.length];

            //checking if there are still classes to display
            int classes = 0;

            while (classes < modules.length) {

                //print class
                System.out.println("\nModule: " + modules[classes]);

                //check if a grade exists
                if (studentGrades != null && classes < studentGrades.length) {

                    //store the grade
                    recordedGrades[i][classes] = studentGrades[classes];

                    //print grades
                    System.out.println("Grade: " + recordedGrades[i][classes]);
                    System.out.println("Grade successfully recorded.");

                } else {
                    System.out.println("No grade available.");
                }

                classes++;
            }

            // Print QCA
            // QCA calculation goes here

            // If semester = 2
            // Print overall QCA goes here

            System.out.println();
        }

        //return the grades
        return recordedGrades;
    }
}
