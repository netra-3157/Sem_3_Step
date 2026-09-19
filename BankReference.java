import java.util.Scanner;

public class BankReference {

    // Method to normalize the reference
    static String normalizeReference(String raw) {
        raw = raw.trim();

        // Convert only first 3 characters to uppercase
        String bankCode = raw.substring(0, 3).toUpperCase();
        String rest = raw.substring(3);

        return bankCode + rest;
    }

    // Method to validate and format the reference
    static String validateAndFormat(String reference) {

        // Check length
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Check remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: transaction body must contain only digits";
            }
        }

        // Extract date and sequence number
        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequence = reference.substring(9, 14);

        // Convert date from ddMMyy to dd/MM/yy
        String formattedDate = date.substring(0, 2) + "/"
                             + date.substring(2, 4) + "/"
                             + date.substring(4, 6);

        // Build final output
        StringBuilder result = new StringBuilder();

        result.append("[")
              .append(bankCode)
              .append("] DATE: ")
              .append(formattedDate)
              .append(" | SEQ: ")
              .append(sequence);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String raw = sc.nextLine();

        String normalized = normalizeReference(raw);

        String result = validateAndFormat(normalized);

        System.out.println(result);

        sc.close();
    }
}