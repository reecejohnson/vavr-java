package java;

public class InvalidOrderException extends Exception {
    public static InvalidOrderException create() {
        return new InvalidOrderException();
    }
}
