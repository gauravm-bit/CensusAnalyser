package Exception;

public class CensusAnalyserException extends Throwable {
    public enum ExceptionType{
        FILE_NOT_FOUND
    }

    public ExceptionType exceptionType;

    public CensusAnalyserException(ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }
}
