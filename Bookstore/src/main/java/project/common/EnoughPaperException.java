package project.common;

public class EnoughPaperException extends Exception {
    public EnoughPaperException(String statement){
        super(statement);
    }
}
