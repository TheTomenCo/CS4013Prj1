public class QCACalculation {
    public static void main(String[] args) {
        //Student grades are checked
        int[] grade = {20, 40, 60, 80, 99};
        for (int i = 0; i < 5; i++) {
            //Checks if it's an A1
            if (grade[i] >= 80) {
                System.out.println("The student got an A1");
            }

            //Checks if it's an A2
            else if (grade[i] >= 72) {
                System.out.println("The student got an A2");
            }

            //Checks if it's a B1
            else if (grade[i] >= 64) {
                System.out.println("The student got an B1");
            }

            //Checks if it's a B2
            else if (grade[i] >= 60) {
                System.out.println("The student got an B2");
            }

            //Checks if it's a B3
            else if (grade[i] >= 56) {
                System.out.println("The student got an B3");
            }

            //Checks if it's a C1
            else if (grade[i] >= 52) {
                System.out.println("The student got an B3");
            }

            //Checks if it's a C2
            else if (grade[i] >= 48) {
                System.out.println("The student got an C2");
            }

            //Checks if it's a C3
            else if (grade[i] >= 40) {
                System.out.println("The student got an C3");
            }

            //Checks if it's a D1
            else if (grade[i] >= 35) {
                System.out.println("The student got an D1");
            }

            //Checks if it's an F
            else {
                System.out.println("You failed");
            }
        }
    }
}
