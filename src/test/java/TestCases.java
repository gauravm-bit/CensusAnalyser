import service.StateCensusAnalyser;
import org.junit.Assert;
import Exception.CensusAnalyserException;
import service.StateCode;
import org.junit.Test;
import java.io.IOException;


public class TestCases {

    //TC 1.1
    @Test
    public void givenNumberOfRecords_ShouldWhenMatched_ReturnTrue() throws CensusAnalyserException {
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCensusData.csv";
        StateCensusAnalyser stateCensusAnalyzer = new StateCensusAnalyser(CSV_FILE_PATH);
        int numberOfRecords = stateCensusAnalyzer.loadRecords();
        Assert.assertEquals(29,numberOfRecords);
    }

    //TC 1.2
    @Test
    public void givenFileName_WhenWrong_ShouldReturnCustomException(){
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StatecensusData.csv";
        StateCensusAnalyser stateCensusAnalyzer = new StateCensusAnalyser(CSV_FILE_PATH);
        try {
            stateCensusAnalyzer.loadRecords();
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND,e.exceptionType);
        }
    }

    //TC 1.3
    @Test
    public void givenFileType_WhenWrong_ShouldReturnCustomException(){
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCensusData.csv";
        StateCensusAnalyser stateCensusAnalyzer = new StateCensusAnalyser(CSV_FILE_PATH);
        try {
            stateCensusAnalyzer.loadRecords();
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND,e.exceptionType);
        }
    }

    //TC 1.4
    @Test
    public void givenFile_WhenDelimiterIncorrect_ShouldReturnCustomException(){
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCensusData1.csv";
        StateCensusAnalyser stateCensusAnalyzer = new StateCensusAnalyser(CSV_FILE_PATH);
        try {
            stateCensusAnalyzer.loadRecords();
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.DELIMITER_INCORRECT,e.exceptionType);
        }
    }

    //TC 1.5
    @Test
    public void givenFile_WhenHeaderIncorrect_ShouldReturnCustomException(){
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCensusData2.csv";
        StateCensusAnalyser stateCensusAnalyzer = new StateCensusAnalyser(CSV_FILE_PATH);
        try {
            stateCensusAnalyzer.loadRecords();
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.DELIMITER_INCORRECT,e.exceptionType);
        }
    }

    //TC 2.1
    @Test
    public void givenNumberOfRecordsOfStateCode_WhenMatched_ShouldReturnTrue() throws CensusAnalyserException {
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCode.csv";
        StateCode stateCode = new StateCode(CSV_FILE_PATH);
        int numberOfRecords = stateCode.loadStateCodeRecords();
        Assert.assertEquals(37, numberOfRecords);
    }

    //TC 2.2
    @Test
    public void givenFileNameOfStateCode_WhenWrong_ShouldReturnCustomException() {
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/statecode.csv";
        StateCode stateCode = new StateCode(CSV_FILE_PATH);
        try {
            stateCode.loadStateCodeRecords();
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    //TC 2.3
    @Test
    public void givenFileTypeOfStateCode_WhenWrong_ShouldReturnCustomException() {
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCode.txt";
        StateCode stateCode = new StateCode(CSV_FILE_PATH);
        try {
            stateCode.loadStateCodeRecords();
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    //TC 2.4
    @Test
    public void givenFileOfStateCode_WhenDelimiterIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCode1.csv";
        StateCode stateCode = new StateCode(CSV_FILE_PATH);
        try {
            stateCode.loadStateCodeRecords();
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.DELIMITER_INCORRECT, e.exceptionType);
        }
    }

    //TC 2.5
    @Test
    public void givenFileOfStateCode_WhenHeadersIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCode1.csv";
        StateCode stateCode = new StateCode(CSV_FILE_PATH);
        try {
            stateCode.loadStateCodeRecords();
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.DELIMITER_INCORRECT, e.exceptionType);
        }
    }

}
