
public class recordModuleResults {
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

            //read the modules
            for (int j = 0; j < modules.length; j++) {

                System.out.println("\nModule: " + modules[j]);

                //check if a grade exists
                if (studentGrades != null && j < studentGrades.length) {

                    //store the grade
                    recordedGrades[i][j] = studentGrades[j];

                    System.out.println("Grade: " + recordedGrades[i][j]);
                    System.out.println("Grade successfully recorded.");

                } else {

                    //no grade given
                    recordedGrades[i][j] = "Not recorded";

                    System.out.println("No grade available for this module.");
                }
            }

            System.out.println();
        }

        //return the grades
        return recordedGrades;
    }
}
