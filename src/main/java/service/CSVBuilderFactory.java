package service;

public class CSVBuilderFactory {
    public static OpenCSVBuilder createCsvBuilder() {
        return new OpenCSVBuilder();
    }
}
