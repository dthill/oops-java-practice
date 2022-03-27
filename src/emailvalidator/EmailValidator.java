package emailvalidator;

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
        for (int i = 0; i < emailsArray.length; i++) {
            String emailStatus;
            if (this.isValidEmail(emailsArray[i])) {
                emailStatus = "valid";
            } else {
                emailStatus = "invalid";
                allEmailsValid = false;
            }
            System.out.println("The email " + emailsArray[i] + " is " + emailStatus);
        }
        if (allEmailsValid) {
            System.out.println("All emails are valid");
        } else {
            System.out.println("Not all emails are valid");
        }

    }

    boolean isValidEmail(String email) {
        return email.matches("[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+.[a-zA-Z]+");
    }


}

// santa@claus.com  santa1@claus.com,  santa2@claus.com; santa3@claus.com