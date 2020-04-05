package service;
import model.CSVStateCensus;
import Exception.CensusAnalyserException;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;


public class StateCensusAnalyser {
    private static String CSV_FILE_PATH;
    int count=0;

    public StateCensusAnalyser(String path) {
        CSV_FILE_PATH = path;
    }

    public int loadRecords() throws CensusAnalyserException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
        ) {
            CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVStateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVStateCensus> csvUserIterator = csvToBean.iterator();

            while (csvUserIterator.hasNext()) {
                CSVStateCensus csvStateCensus = csvUserIterator.next();
                System.out.println("Name : " + csvStateCensus.getState());
                System.out.println("Email : " + csvStateCensus.getPopulation());
                System.out.println("Phone : " + csvStateCensus.getArea());
                System.out.println("Country : " + csvStateCensus.getDensity());
                System.out.println("==========================");
                count++;
            }
        } catch (NoSuchFileException e) {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND);
        } catch (RuntimeException e) {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.DELIMITER_INCORRECT);
        }
        catch (IOException e) {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND);

        }
        return count;
    }
}