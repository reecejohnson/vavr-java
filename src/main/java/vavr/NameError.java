package vavr;

public class NameError extends Exception {
    public static NameError create() {
        return new NameError();
    }
}
