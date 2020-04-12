package service;
import Exception.CSVBuilderException;
import model.CSVUSCensus;

import java.util.Map;

public class USCensusAdapter extends CensusAdapter {
    @Override
    public Map<String, CensusDAO> loadCensusData(String... csvPath) throws CSVBuilderException {
        return super.loadCensusData(CSVUSCensus.class, csvPath[0]);
    }
}
