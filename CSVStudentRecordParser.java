import java.util.Scanner;

public class CSVStudentRecordParser {

    // Method to parse the student record
    static void parseStudentRecord(String csvLine) {

        // Split the input using comma
        String[] fields = csvLine.split(",");

        // Check whether exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {

            // Print the formatted student record
            System.out.println("Name: " + fields[0]
                    + " | Roll No: " + fields[1]
                    + " | Dept: " + fields[2]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Accept CSV input
        System.out.print("Enter CSV record: ");
        String csvLine = sc.nextLine();

        // Call the method
        parseStudentRecord(csvLine);

        sc.close();
    }
}