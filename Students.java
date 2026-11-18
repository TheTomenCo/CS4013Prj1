public class Students {
    public static void main(String[] args) {
        String[][] students = {
                {"250001", "Jane Doe"},
                {"250002", "Alice Liddle"},
                {"250003", "Tingle Burberry"},
                {"250004", "Bryan Hodukavich"}
        };

        for (String[] student : students) {
            System.out.println(student[0] + " - " + student[1]);
        }
    }
}
