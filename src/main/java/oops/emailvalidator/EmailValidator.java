package oops.emailvalidator;

import java.util.Scanner;

public class EmailValidator {
    private static final String SEPARATORS = "[\s,;:]+";
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new EmailValidator().vaLidateEmails();
    }

    void vaLidateEmails() {
        System.out.println("Please provide your list of emails");
        String emailsInput = scanner.nextLine();
        String[] emailsArray = emailsInput.split(SEPARATORS);
        boolean allEmailsValid = true;
        for (String email : emailsArray) {
            String emailStatus;
            if (this.isValidEmail(email)) {
                emailStatus = "valid";
            } else {
                emailStatus = "invalid";
                allEmailsValid = false;
            }
            System.out.println("The email " + email + " is " + emailStatus);
        }
        if (allEmailsValid) {
            System.out.println("All emails are valid");
        } else {
            System.out.println("Not all emails are valid");
        }

    }

    boolean isValidEmail(String email) {
        return email.matches("[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+\\.[a-zA-Z]+");
    }


}

