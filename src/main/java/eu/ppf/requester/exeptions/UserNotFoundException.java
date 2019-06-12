package eu.ppf.requester.exeptions;

public class UserNotFoundException extends Exception {
    public String toString() {
        return "User not found exception! Enter correct data!";
    }
}
