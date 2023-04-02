package Exceptions;
public class ParsingException extends RuntimeException {
    public ParsingException(String attributeName) {
        super("Problem with parsing " + attributeName + ". Please try again");
    }
}
