import java.util.Scanner;

public class FileExtensionValidator {

    // Method to validate file extension
    static String validateFileExtension(String filename) {

        // Find the last dot
        int dotIndex = filename.lastIndexOf(".");

        // If there is no dot, extension is invalid
        if (dotIndex == -1) {
            return "Rejected — invalid file type";
        }

        // Extract extension
        String extension = filename.substring(dotIndex + 1);

        // Compare extension ignoring case
        if (extension.equalsIgnoreCase("pdf") ||
            extension.equalsIgnoreCase("docx") ||
            extension.equalsIgnoreCase("zip")) {

            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Accept filename
        System.out.print("Enter filename: ");
        String filename = sc.nextLine();

        // Validate the extension
        String result = validateFileExtension(filename);

        // Display result
        System.out.println(result);

        sc.close();
    }
}