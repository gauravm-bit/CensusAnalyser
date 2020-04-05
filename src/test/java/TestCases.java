import service.StateCensusAnalyser;
import org.junit.Assert;
import Exception.CensusAnalyserException;
import org.junit.Test;


public class TestCases {

    //TC 1.1
    @Test
    public void givenNumberOfRecords_WhenMatched_ReturnTrue() throws CensusAnalyserException {
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCensusData.csv";
        StateCensusAnalyser stateCensusAnalyzer = new StateCensusAnalyser(CSV_FILE_PATH);
        int numberOfRecords = stateCensusAnalyzer.loadRecords();
        Assert.assertEquals(29,numberOfRecords);
    }

    //TC 1.2
    @Test
    public void givenFileName_WhenWrong_ReturnCustomisedException(){
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
    public void givenFileType_WhenWrong_ReturnCustomiseException(){
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
    public void givenFile_WhenDelimiterIncorrect_ReturnCustomiseException(){
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
    public void givenFile_WhenHeaderIncorrect_ReturnCustomiseException(){
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCensusData2.csv";
        StateCensusAnalyser stateCensusAnalyzer = new StateCensusAnalyser(CSV_FILE_PATH);
        try {
            stateCensusAnalyzer.loadRecords();
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.DELIMITER_INCORRECT,e.exceptionType);
        }
    }

}
