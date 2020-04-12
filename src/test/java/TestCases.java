import model.CSVUSCensus;
import model.StateCensusPojo;
import model.StateCodePojo;
import service.CensusDAO;
import service.StateCensusAnalyser;
import org.junit.Assert;
import Exception.CSVBuilderException;
import com.google.gson.Gson;
import org.junit.Test;

import static service.StateCensusAnalyser.Country.INDIA;
import static service.StateCensusAnalyser.Country.US;


public class TestCases {

    StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(INDIA);
    StateCensusAnalyser usStateCensusAnalyser = new StateCensusAnalyser(US);

    String CORRECT_STATE_CENSUS_CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCensusData.csv";
    String WRONG_STATE_CENSUS_CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StatecensusData.csv";
    String WRONG_STATE_CENSUS_CSV_FILE_EXTENSION = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCensusData.png";
    String WRONG_STATE_CENSUS_CSV_FILE_DELIMITER = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCensusData1.csv";
    String WRONG_STATE_CENSUS_CSV_FILE_HEADER = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCensusData2.csv";
    String CORRECT_STATE_CODE_CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCode.csv";
    String WRONG_STATE_CODE_CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/statecode.csvv";
    String WRONG_STATE_CODE_CSV_FILE_EXTENSION = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCode.txt";
    String WRONG_STATE_CODE_CSV_FILE_DELIMITER = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCode1.csv";
    String WRONG_STATE_CODE_CSV_FILE_HEADER = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/StateCode2.csv";
    String US_CENSUS_CSV_FILE_PATH = "C:/Users/GAURAV/IdeaProjects/Census Analyzer/src/main/resources/USCensusData.csv";

    //TC 1.1
    @Test
    public void givenNumberOfRecords_ShouldWhenMatched_ReturnTrue() throws CSVBuilderException {
        int numberOfRecords = stateCensusAnalyser.loadCensusRecords(INDIA,CORRECT_STATE_CENSUS_CSV_FILE_PATH);
        Assert.assertEquals(29,numberOfRecords);
    }

    //TC 1.2
    @Test
    public void givenFileName_WhenWrong_ShouldReturnCustomException(){
        try {
            stateCensusAnalyser.loadCensusRecords(INDIA,WRONG_STATE_CENSUS_CSV_FILE_PATH);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.FILE_NOT_FOUND,e.exceptionType);
        }
    }

    //TC 1.3
    @Test
    public void givenFileType_WhenWrong_ShouldReturnCustomException(){
        try {
            stateCensusAnalyser.loadCensusRecords(INDIA,WRONG_STATE_CENSUS_CSV_FILE_EXTENSION);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.FILE_NOT_FOUND,e.exceptionType);
        }
    }

    //TC 1.4
    @Test
    public void givenFile_WhenDelimiterIncorrect_ShouldReturnCustomException(){

        try {
            stateCensusAnalyser.loadCensusRecords(INDIA,WRONG_STATE_CENSUS_CSV_FILE_DELIMITER);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.DELIMITER_OR_HEADER_INCORRECT,e.exceptionType);
        }
    }

    //TC 1.5
    @Test
    public void givenFile_WhenHeaderIncorrect_ShouldReturnCustomException(){
        try {
            stateCensusAnalyser.loadCensusRecords(INDIA,WRONG_STATE_CENSUS_CSV_FILE_HEADER);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.DELIMITER_OR_HEADER_INCORRECT,e.exceptionType);
        }
    }

    //TC 2.1
    @Test
    public void givenNumberOfRecordsOfStateCode_WhenMatched_ShouldReturnTrue() throws CSVBuilderException {
        int numberOfRecords = stateCensusAnalyser.loadCensusRecords(INDIA,CORRECT_STATE_CODE_CSV_FILE_PATH);
        Assert.assertEquals(37, numberOfRecords);
    }

    //TC 2.2
    @Test
    public void givenFileNameOfStateCode_WhenWrong_ShouldReturnCustomException() {
        try {
            stateCensusAnalyser.loadCensusRecords(INDIA,WRONG_STATE_CODE_CSV_FILE_PATH);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    //TC 2.3
    @Test
    public void givenFileTypeOfStateCode_WhenWrong_ShouldReturnCustomException() {
        try {
            stateCensusAnalyser.loadCensusRecords(INDIA,WRONG_STATE_CODE_CSV_FILE_EXTENSION);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }

    //TC 2.4
    @Test
    public void givenFileOfStateCode_WhenDelimiterIncorrect_ShouldReturnCustomiseException() {
        try {
            stateCensusAnalyser.loadCensusRecords(INDIA,WRONG_STATE_CODE_CSV_FILE_DELIMITER);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.DELIMITER_OR_HEADER_INCORRECT, e.exceptionType);
        }
    }

    //TC 2.5
    @Test
    public void givenFileOfStateCode_WhenHeadersIncorrect_ShouldReturnCustomiseException() {
        try {
            stateCensusAnalyser.loadCensusRecords(INDIA,WRONG_STATE_CODE_CSV_FILE_HEADER);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.DELIMITER_OR_HEADER_INCORRECT, e.exceptionType);
        }
    }

    //TC 3.1
    @Test
    public void givenCensusData_WhenSorted_ShouldReturnSortedList() throws CSVBuilderException {

        stateCensusAnalyser.loadCensusRecords(INDIA,CORRECT_STATE_CENSUS_CSV_FILE_PATH);
        String SortedData = stateCensusAnalyser.getSortedCensusData(StateCensusAnalyser.SortingMode.STATE);
        StateCensusPojo[] censusCSV = new Gson().fromJson(SortedData, StateCensusPojo[].class);
        Assert.assertEquals("Andhra Pradesh", censusCSV[0].state);
    }

    //TC 4.1
    @Test
    public void givenStateCodeData_WhenSorted_ShouldReturnSortedList() throws CSVBuilderException {
        stateCensusAnalyser.loadCensusRecords(INDIA,CORRECT_STATE_CODE_CSV_FILE_PATH);
        String SortedData = stateCensusAnalyser.getSortedCensusData(StateCensusAnalyser.SortingMode.STATE);
        StateCodePojo[] StateCodes = new Gson().fromJson(SortedData, StateCodePojo[].class);
        Assert.assertEquals("AD", StateCodes[0].stateCode);
    }

    //TC5.1
    @Test
    public void givenStateCensusData_WhenPopulationSorted_ShouldReturnSortedResult() throws CSVBuilderException {
        stateCensusAnalyser.loadCensusRecords(INDIA,CORRECT_STATE_CENSUS_CSV_FILE_PATH);
        String sortedData = stateCensusAnalyser.getSortedCensusData(StateCensusAnalyser.SortingMode.POPULATION);
        StateCensusPojo[] stateCensusPojo = new Gson().fromJson(sortedData, StateCensusPojo[].class);
        Assert.assertEquals(199812341, stateCensusPojo[0].population,0);
    }

    //TC 6.1
    @Test
    public void givenStateCensusData_WhenDensitySorted_ShouldReturnSortedResult() throws CSVBuilderException {
        stateCensusAnalyser.loadCensusRecords(INDIA,CORRECT_STATE_CENSUS_CSV_FILE_PATH);
        String sortedData = stateCensusAnalyser.getSortedCensusData(StateCensusAnalyser.SortingMode.DENSITY);
        StateCensusPojo[] stateCensusPojo = new Gson().fromJson(sortedData, StateCensusPojo[].class);
        Assert.assertEquals(1102, stateCensusPojo[0].density,0);
    }

    //TC 7.1
    @Test
    public void givenStateCensusData_WhenAreaSorted_ShouldReturnSortedResult() throws CSVBuilderException {
        stateCensusAnalyser.loadCensusRecords(INDIA,CORRECT_STATE_CENSUS_CSV_FILE_PATH);
        String sortedData = stateCensusAnalyser.getSortedCensusData(StateCensusAnalyser.SortingMode.AREA);
        StateCensusPojo[] stateCensusPojo = new Gson().fromJson(sortedData, StateCensusPojo[].class);
        Assert.assertEquals(342239, stateCensusPojo[0].area,0);
    }

    //TC 8.1
    @Test
    public void givenUSCensusData_WhenRecordsEqual_ShouldReturnTrue() throws CSVBuilderException {
        int numOfRecords = usStateCensusAnalyser.loadCensusRecords(US,US_CENSUS_CSV_FILE_PATH);
        Assert.assertEquals(51, numOfRecords);
    }

    //TC 9.1
    @Test
    public void givenTheUSCensusData_WhenSortedOnPopulation_ShouldReturnSortedResult() throws CSVBuilderException {
        usStateCensusAnalyser.loadCensusRecords(US, US_CENSUS_CSV_FILE_PATH);
        String sortedData = usStateCensusAnalyser.getSortedCensusData(StateCensusAnalyser.SortingMode.POPULATION);
        CSVUSCensus[] censusDAO = new Gson().fromJson(sortedData, CSVUSCensus[].class);
        Assert.assertEquals("California", censusDAO[0].usState);
    }

    @Test
    public void givenTheUSCensusData_WhenSortedByDensity_ShouldReturnSortedResult() throws CSVBuilderException {
        usStateCensusAnalyser.loadCensusRecords(US, US_CENSUS_CSV_FILE_PATH);
        String sortedData = usStateCensusAnalyser.getSortedCensusData(StateCensusAnalyser.SortingMode.DENSITY);
        CSVUSCensus[] censusDAO = new Gson().fromJson(sortedData, CSVUSCensus[].class);
        Assert.assertEquals("District of Columbia", censusDAO[0].usState);
    }

    @Test
    public void givenTheUSCensusData_WhenSortedByArea_ShouldReturnSortedResult() throws CSVBuilderException {
        usStateCensusAnalyser.loadCensusRecords(US, US_CENSUS_CSV_FILE_PATH);
        String sortedData = usStateCensusAnalyser.getSortedCensusData(StateCensusAnalyser.SortingMode.AREA);
        CSVUSCensus[] censusDAO = new Gson().fromJson(sortedData, CSVUSCensus[].class);
        Assert.assertEquals("Alaska", censusDAO[0].usState);
    }


}
