import service.StateCensusAnalyser;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

public class TestCases {
    private static final String CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCensusData.csv";

    @Test
    public void givenNumberOfRecords_WhenMatched_ReturnTrue() throws IOException {
        StateCensusAnalyser stateCensusAnalyzer = new StateCensusAnalyser();
        int numberOfRecords = stateCensusAnalyzer.loadRecords();
        Assert.assertEquals(29,numberOfRecords);
    }
}
