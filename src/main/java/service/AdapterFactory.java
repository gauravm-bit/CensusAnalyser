package service;

import Exception.CSVBuilderException;

import java.util.Map;

public class AdapterFactory {
    public static Map<String, CensusDAO> getCensusData(StateCensusAnalyser.Country country, String[] csvFilePath) throws CSVBuilderException {
        if (country.equals(StateCensusAnalyser.Country.INDIA))
            return new IndianCensusAdapter().loadCensusData(csvFilePath);
        else if (country.equals(StateCensusAnalyser.Country.US))
            return new USCensusAdapter().loadCensusData(csvFilePath);
        else
            throw new CSVBuilderException( "INVALID_COUNTRY", CSVBuilderException.ExceptionType.INVALID_COUNTRY);
    }
}
