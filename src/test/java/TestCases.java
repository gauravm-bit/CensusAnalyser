import service.StateCensusAnalyser;
import org.junit.Assert;
import Exception.CensusAnalyserException;
import org.junit.Test;
import java.io.IOException;

public class TestCases {

    @Test
    public void givenNumberOfRecords_WhenMatched_ReturnTrue() throws CensusAnalyserException {
        final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCensusData.csv";
        StateCensusAnalyser stateCensusAnalyzer = new StateCensusAnalyser(CSV_FILE_PATH);
        int numberOfRecords = stateCensusAnalyzer.loadRecords();
        Assert.assertEquals(29,numberOfRecords);
    }

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
}
