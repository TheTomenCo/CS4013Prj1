
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

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

        // Systems modules
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

        // Accounting modules
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

    public static String[][] addModules(
            String[][] students,
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

            if (students[i] == null || students[i].length < 2) {
                System.out.println("Invalid student record.");
                modulesByStudent[i] = new String[0];
                continue;
            }

            String studentID = students[i][0];
            String studentName = students[i][1];
            String program = studentProgrammes[i];

            String[] modules;

            if (program != null && program.equalsIgnoreCase("Systems")) {

                modules = Arrays.copyOf(
                        systemsSemesterThree,
                        systemsSemesterThree.length
                );

            } else if (program != null &&
                    program.equalsIgnoreCase("Accounting")) {

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

            System.out.println("\nStudent Name: " + studentName);
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

    private static final String[][] grades = {

            // Jane Doe
            {"78", "72", "56", "45", "66"},

            // Alice Liddle
            {"24", "22", "79", "0", "98"},

            // Tingle Burberry
            {"89", "78", "90", "75", "76"},

            // Bryan Hodukavich
            {"45", "43", "36", "38", "35"}
    };

    public String[][] addGrades(
            String[][] students,
            String[][] modulesByStudent) {

        // Check that all required information exists
        if (students == null || modulesByStudent == null) {
            System.out.println("Student or module information is missing.");
            return new String[0][];
        }

        // Check that all arrays have the same number of entries
        if (students.length != modulesByStudent.length ||
                students.length != grades.length) {

            System.out.println("Student, module and grade records do not match.");
            return new String[0][];
        }

        // Make an array to store the grades
        String[][] recordedGrades = new String[students.length][];

        // Arrays to store individual student QCA and awards
        double[] studentQCA = new double[students.length];
        String[] studentAwards = new String[students.length];

        // Read each student
        for (int i = 0; i < students.length; i++) {

            // Check student information
            if (students[i] == null || students[i].length < 2) {
                System.out.println("Invalid student record.");
                recordedGrades[i] = new String[0];
                studentAwards[i] = "No award";
                continue;
            }

            String studentID = students[i][0];
            String studentName = students[i][1];

            System.out.println("\n--------------------------------");
            System.out.println("Student ID: " + studentID);
            System.out.println("Student Name: " + studentName);
            System.out.println("--------------------------------");

            // Get the modules
            String[] modules = modulesByStudent[i];

            // Get the grades
            String[] studentGrades = grades[i];

            // Check that the student has modules assigned
            if (modules == null || modules.length == 0) {
                System.out.println("No modules found for this student.");
                recordedGrades[i] = new String[0];
                studentAwards[i] = "No award";
                continue;
            }

            // Check that the number of modules matches the grades
            if (modules.length != studentGrades.length) {
                System.out.println("Module and grade records do not match.");
                recordedGrades[i] = new String[0];
                studentAwards[i] = "No award";
                continue;
            }

            // Make somewhere to store the grades
            recordedGrades[i] = new String[modules.length];

            // Initialise QCA
            double QCASEM = 0.0;

            // Read the modules
            for (int j = 0; j < modules.length; j++) {

                System.out.println("\nModule: " + modules[j]);

                // Check if a grade exists
                if (studentGrades[j] != null) {

                    // Store the grade
                    recordedGrades[i][j] = studentGrades[j];

                    int grade = Integer.parseInt(studentGrades[j]);

                    System.out.println("Grade: " + recordedGrades[i][j] + "%");
                    System.out.println("Grade successfully recorded.");

                    // Check the grade and calculate QCA points

                    // Checks if it's an A1
                    if (grade >= 80) {
                        System.out.println("The student got an A1");
                        QCASEM = QCASEM + 4.0;
                    }

                    // Checks if it's an A2
                    else if (grade >= 72) {
                        System.out.println("The student got an A2");
                        QCASEM = QCASEM + 3.6;
                    }

                    // Checks if it's a B1
                    else if (grade >= 64) {
                        System.out.println("The student got a B1");
                        QCASEM = QCASEM + 3.2;
                    }

                    // Checks if it's a B2
                    else if (grade >= 60) {
                        System.out.println("The student got a B2");
                        QCASEM = QCASEM + 3.0;
                    }

                    // Checks if it's a B3
                    else if (grade >= 56) {
                        System.out.println("The student got a B3");
                        QCASEM = QCASEM + 2.8;
                    }

                    // Checks if it's a C1
                    else if (grade >= 52) {
                        System.out.println("The student got a C1");
                        QCASEM = QCASEM + 2.6;
                    }

                    // Checks if it's a C2
                    else if (grade >= 48) {
                        System.out.println("The student got a C2");
                        QCASEM = QCASEM + 2.4;
                    }

                    // Checks if it's a C3
                    else if (grade >= 40) {
                        System.out.println("The student got a C3");
                        QCASEM = QCASEM + 2.0;
                    }

                    // Checks if it's a D1
                    else if (grade >= 35) {
                        System.out.println("The student got a D1");
                        QCASEM = QCASEM + 1.6;
                    }

                    // Checks if it's an F
                    else {
                        System.out.println("You failed");
                    }
                }
            }

            // Calculate QCA and determine award together
            QCASEM = QCASEM / modules.length;

            String award;

            if (QCASEM >= 3.4) {
                award = "First class honours";
            } else if (QCASEM >= 3.0) {
                award = "2.1 Second grade honours";
            } else if (QCASEM >= 2.6) {
                award = "2.2 Second grade honours";
            } else if (QCASEM >= 2.0) {
                award = "Third honours";
            } else {
                award = "You failed";
            }

            System.out.println("You got a " + QCASEM +
                    " so you gained a " + award);

            // Store QCA and award for the transcript
            studentQCA[i] = QCASEM;
            studentAwards[i] = award;

        }

        // Generate individual student transcripts
        for (int i = 0; i < students.length; i++) {

            if (students[i] == null || students[i].length < 2) {
                continue;
            }

            System.out.println("\n========================================");
            System.out.println("             STUDENT TRANSCRIPT");
            System.out.println("========================================");

            System.out.println("Student Name: " + students[i][1]);
            System.out.println("Student ID: " + students[i][0]);

            System.out.println("----------------------------------------");
            System.out.println("                  GRADES");
            System.out.println("----------------------------------------");

            if (recordedGrades[i] != null) {

                for (int j = 0; j < modulesByStudent[i].length; j++) {

                    System.out.println("Module: " + modulesByStudent[i][j]);
                    System.out.println("Grade: " + recordedGrades[i][j] + "%");
                    System.out.println();
                }
            }

            System.out.println("----------------------------------------");
            System.out.println("Overall QCA: " + studentQCA[i]);
            System.out.println("Award: " + studentAwards[i]);
            System.out.println("========================================");
        }

        // Return the recorded grades
        return recordedGrades;
    }
}
