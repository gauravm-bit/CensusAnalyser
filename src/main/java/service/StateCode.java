package service;
import Exception.CensusAnalyserException;
import model.CSVStateCensus;
import java.io.IOException;
import model.StateCodePojo;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.nio.file.NoSuchFileException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCode {
    private static String CSV_FILE_PATH;
    int count = 0;

    public StateCode(String path) {
        CSV_FILE_PATH = path;
    }

    public int loadStateCodeRecords() throws CensusAnalyserException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH))
        ) {
            CsvToBean<StateCodePojo> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(StateCodePojo.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<StateCodePojo> userIterator = csvToBean.iterator();

            while (userIterator.hasNext()) {
                StateCodePojo stateCodePojo = userIterator.next();
                System.out.println("SrNo : " + stateCodePojo.getSrno());
                System.out.println("StateName : " + stateCodePojo.getStateName());
                System.out.println("TIN : " + stateCodePojo.getTin());
                System.out.println("StateCode : " + stateCodePojo.getStateCode());
                System.out.println("==========================");
                count++;
            }
        }catch (NoSuchFileException e) {
            throw new CensusAnalyserException(e.getMessage(),CensusAnalyserException.ExceptionType.FILE_NOT_FOUND);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
