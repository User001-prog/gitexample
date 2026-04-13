package chat.app;

import java.util.Scanner;


class Login {

    String username;
    String password;
    String cellphone;

    Scanner input = new Scanner(System.in);

    // check username
    public boolean checkUserName(String user) {

        if (user.contains("_") && user.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    // check password
    public boolean checkPasswordComplexity(String pass) {

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        if (pass.length() < 8) {
            return false;
        }

        for (int i = 0; i < pass.length(); i++) {

            char c = pass.charAt(i);

            if (Character.isUpperCase(c)) {
                hasCapital = true;
            }

            if (Character.isDigit(c)) {
                hasNumber = true;
            }

            if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        if (hasCapital && hasNumber && hasSpecial) {
            return true;
        } else {
            return false;
        }
    }

    // check cellphone (regex required)
    public boolean checkCellPhoneNumber(String number) {

        // source: https://www.w3schools.com/java/java_regex.asp
        String pattern = "\\+27\\d{9,10}";

        if (number.matches(pattern)) {
            return true;
        } else {
            return false;
        }
    }

    // register user
    public String registerUser() {

        System.out.print("Enter username: ");
        String user = input.nextLine();

        if (checkUserName(user)) {
            username = user;
            System.out.println("Username successfully captured");
        } else {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no longer than five characters";
        }

        System.out.print("Enter password: ");
        String pass = input.nextLine();

        if (checkPasswordComplexity(pass)) {
            password = pass;
            System.out.println("Password successfully captured");
        } else {
            return "Password is not correctly formatted; please ensure the password contains at least 8 characters, a capital letter, a number and a special character";
        }

        System.out.print("Enter cellphone (+27...): ");
        String phone = input.nextLine();

        if (checkCellPhoneNumber(phone)) {
            cellphone = phone;
            System.out.println("Cellphone number successfully added");
        } else {
            return "Cellphone number is not correctly formatted";
        }

        return "Registration successful";
    }

    // login
    public boolean loginUser() {

        System.out.print("Enter username: ");
        String user = input.nextLine();

        System.out.print("Enter password: ");
        String pass = input.nextLine();

        if (user.equals(username) && pass.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // return message
    public String returnLoginStatus(boolean status) {

        if (status == true) {

            String[] parts = username.split("_");

            String first = parts[0];
            String last = "";

            if (parts.length > 1) {
                last = parts[1];
            }

            return "Welcome " + first + ", " + last + " it is great to see you again";

        } else {
            return "Username or password incorrect, please try again";
        }
    }
}


public class ChatApp {

    public static void main(String[] args) {

        Login obj = new Login();

        String message = obj.registerUser();
        System.out.println(message);

        boolean result = obj.loginUser();
        System.out.println(obj.returnLoginStatus(result));
    }
}