import model.CSVStateCensus;
import model.StateCodePojo;
import service.StateCensusAnalyser;
import org.junit.Assert;
import Exception.CSVBuilderException;
import com.google.gson.Gson;
import org.junit.Test;

public class TestCases {

    //TC 1.1
    @Test
    public void givenNumberOfRecords_ShouldWhenMatched_ReturnTrue() throws CSVBuilderException {
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCensusData.csv";
        StateCensusAnalyser stateCensusAnalyzer = new StateCensusAnalyser(CSV_FILE_PATH, CSVStateCensus.class);
        int numberOfRecords = stateCensusAnalyzer.loadRecords();
        Assert.assertEquals(29,numberOfRecords);
    }

    //TC 1.2
    @Test
    public void givenFileName_WhenWrong_ShouldReturnCustomException(){
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StatecensusData.csv";
        StateCensusAnalyser stateCensusAnalyzer = new StateCensusAnalyser(CSV_FILE_PATH, CSVStateCensus.class);
        try {
            stateCensusAnalyzer.loadRecords();
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.FILE_NOT_FOUND,e.exceptionType);
        }
    }

    //TC 1.3
    @Test
    public void givenFileType_WhenWrong_ShouldReturnCustomException(){
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCensusData.csv";
        StateCensusAnalyser stateCensusAnalyzer = new StateCensusAnalyser(CSV_FILE_PATH, CSVStateCensus.class);
        try {
            stateCensusAnalyzer.loadRecords();
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.FILE_NOT_FOUND,e.exceptionType);
        }
    }

    //TC 1.4
    @Test
    public void givenFile_WhenDelimiterIncorrect_ShouldReturnCustomException(){
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCensusData1.csv";
        StateCensusAnalyser stateCensusAnalyzer = new StateCensusAnalyser(CSV_FILE_PATH, CSVStateCensus.class);
        try {
            stateCensusAnalyzer.loadRecords();
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.DELIMITER_INCORRECT,e.exceptionType);
        }
    }

    //TC 1.5
    @Test
    public void givenFile_WhenHeaderIncorrect_ShouldReturnCustomException(){
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCensusData2.csv";
        StateCensusAnalyser stateCensusAnalyzer = new StateCensusAnalyser(CSV_FILE_PATH, CSVStateCensus.class);
        try {
            stateCensusAnalyzer.loadRecords();
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.DELIMITER_INCORRECT,e.exceptionType);
        }
    }

    //TC 2.1
    @Test
    public void givenNumberOfRecordsOfStateCode_WhenMatched_ShouldReturnTrue() throws CSVBuilderException {
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCode.csv";
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(CSV_FILE_PATH, StateCodePojo.class);
        int numberOfRecords = stateCensusAnalyser.loadRecords();
        Assert.assertEquals(37, numberOfRecords);
    }

    //TC 2.2
    @Test
    public void givenFileNameOfStateCode_WhenWrong_ShouldReturnCustomException() {
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/statecode.csv";
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(CSV_FILE_PATH, StateCodePojo.class);
        try {
            stateCensusAnalyser.loadRecords();
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    //TC 2.3
    @Test
    public void givenFileTypeOfStateCode_WhenWrong_ShouldReturnCustomException() {
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCode.txt";
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(CSV_FILE_PATH,StateCodePojo.class);
        try {
            stateCensusAnalyser.loadRecords();
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    //TC 2.4
    @Test
    public void givenFileOfStateCode_WhenDelimiterIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCode1.csv";
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(CSV_FILE_PATH,StateCodePojo.class);
        try {
            stateCensusAnalyser.loadRecords();
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.DELIMITER_INCORRECT, e.exceptionType);
        }
    }

    //TC 2.5
    @Test
    public void givenFileOfStateCode_WhenHeadersIncorrect_ShouldReturnCustomiseException() {
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCode1.csv";
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(CSV_FILE_PATH,StateCodePojo.class);
        try {
            stateCensusAnalyser.loadRecords();
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.DELIMITER_INCORRECT, e.exceptionType);
        }
    }

    //TC 3.1
    @Test
    public void givenCensusData_WhenSorted_ShouldReturnSortedList() throws CSVBuilderException {
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCensusData.csv";
        StateCensusAnalyser stateCensusAnalyzer = new StateCensusAnalyser(CSV_FILE_PATH, CSVStateCensus.class);
        stateCensusAnalyzer.loadRecords();
        String SortedData = stateCensusAnalyzer.getSortedCensusData();
        CSVStateCensus[] censusCSV = new Gson().fromJson(SortedData, CSVStateCensus[].class);
        Assert.assertEquals("Andhra Pradesh", censusCSV[0].getState());
    }

}
