package Exception;

public class CensusAnalyserException extends Exception {
    public enum ExceptionType{
        FILE_NOT_FOUND,
        DELIMITER_INCORRECT
    }

    public ExceptionType exceptionType;

    public CensusAnalyserException(String message, ExceptionType exceptionType) {
        super(message);
        this.exceptionType = exceptionType;
    }
}
