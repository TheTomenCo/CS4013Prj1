import java.util.Arrays;

public class Main {
    public static void main (String[] args){
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

