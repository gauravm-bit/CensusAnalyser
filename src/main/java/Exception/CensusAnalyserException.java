package Exception;

public class CensusAnalyserException extends Exception {
    public enum ExceptionType{
        FILE_NOT_FOUND,
        DELIMITER_INCORRECT
    }

    public ExceptionType exceptionType;

    public CensusAnalyserException(ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }
}
