package service;
import Exception.CSVBuilderException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser <E>{
    private static String CSV_FILE_PATH;
    private final Class<E> csvClass;
    int count=0;

    public StateCensusAnalyser(String path, Class<E> csvClss) {
        //VARIABLES
        CSV_FILE_PATH = path;
        csvClass = csvClss;
    }

    //METHOD TO LOAD RECORDS OF CSV FILE
    public int loadRecords() throws CSVBuilderException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH))
        ) {
            OpenCSVBuilder csvBuilder = CSVBuilderFactory.createCsvBuilder();
            Iterator csvUserIterator = csvBuilder.getIterator(reader, csvClass);
            while (csvUserIterator.hasNext()) {
                csvUserIterator.next();
                count++;
            }
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
        return count;
    }
}