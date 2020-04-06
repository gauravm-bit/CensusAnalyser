package service;

import Exception.CSVBuilderException;
import model.CSVStateCensus;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;


public class StateCensusAnalyser <E>{

    //VARIABLES
    private static String CSV_FILE_PATH;
    private final Class<E> csvClass;
    List<E> csvUserList = null;

    public StateCensusAnalyser(String path, Class<E> csvClss) {
        CSV_FILE_PATH = path;
        csvClass = csvClss;
    }

    //METHOD TO LOAD RECORDS OF CSV FILE
    public int loadRecords() throws CSVBuilderException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH))
        ) {
            OpenCSVBuilder csvBuilder = CSVBuilderFactory.createCsvBuilder();

            csvUserList = csvBuilder.getList(reader, csvClass);
        return csvUserList.size();
        } catch (NoSuchFileException e) {
            throw new CSVBuilderException(e.getMessage(),
                    CSVBuilderException.ExceptionType.FILE_NOT_FOUND);
        } catch (RuntimeException e) {
            throw new CSVBuilderException(e.getMessage(),
                    CSVBuilderException.ExceptionType.DELIMITER_INCORRECT);
        }
        catch (IOException e) {
          e.printStackTrace();
        }
        return 0;
    }
    public String getSortedCensusData() {
        Comparator<CSVStateCensus> CSVComparator = Comparator.comparing(census -> census.state);
        this.sort((Comparator<E>) CSVComparator);
        String SortedCSVJson = new Gson().toJson(csvUserList);
        return SortedCSVJson;
    }

    private void sort(Comparator<E> csvComparator) {
        for (int i = 0; i < csvUserList.size() - 1; i++) {
            for (int j = 0; j < csvUserList.size() - i - 1; j++) {
                E census1 = csvUserList.get(j);
                E census2 = csvUserList.get(j + 1);
                if (csvComparator.compare(census1, census2) > 0) {
                    csvUserList.set(j, census2);
                    csvUserList.set(j + 1, census1);
                }
            }
        }
    }
}