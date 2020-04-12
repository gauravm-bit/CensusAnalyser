package service;

import model.CSVUSCensus;
import model.StateCensusPojo;
import model.StateCodePojo;

import java.util.Comparator;

public class CensusDAO {
    public String state;
    public double population;
    public double area;
    public double density;
    public String stateCode;
    public String stateName;
    public String srNo;
    public String tin;

    public CensusDAO(StateCensusPojo stateCensusPojo){
        this.state = stateCensusPojo.state;
        this.population = stateCensusPojo.population;
        this.area = stateCensusPojo.area;
        this.density = stateCensusPojo.density;
    }

    public CensusDAO(StateCodePojo stateCodePojo){
        this.stateCode = stateCodePojo.stateCode;
        this.stateName = stateCodePojo.stateName;
        this.srNo = stateCodePojo.srNo;
        this.tin = stateCodePojo.tin;
    }

    public CensusDAO(CSVUSCensus csvUSCensus) {
        this.state = csvUSCensus.usState;
        this.stateCode = csvUSCensus.usStateId;
        this.population = csvUSCensus.usPopulation;
        this.area = csvUSCensus.usArea;
        this.density = csvUSCensus.usPopulationDensity;
    }

    public static Comparator<CensusDAO> getSortComparator(StateCensusAnalyser.SortingMode mode) {
        if (mode.equals(StateCensusAnalyser.SortingMode.STATE))
            return Comparator.comparing(census -> census.state);
        if (mode.equals(StateCensusAnalyser.SortingMode.POPULATION))
            return Comparator.comparing(CensusDAO::getPopulation).reversed();
        if (mode.equals(StateCensusAnalyser.SortingMode.AREA))
            return Comparator.comparing(CensusDAO::getArea).reversed();
        if (mode.equals(StateCensusAnalyser.SortingMode.DENSITY))
            return Comparator.comparing(CensusDAO::getDensity).reversed();
        return null;
    }

    public double getPopulation() {
        return population;
    }

    public double getArea() {
        return area;
    }

    public double getDensity() {
        return density;
    }

    public Object getCensusDTO(StateCensusAnalyser.Country country) {
        if (country.equals(StateCensusAnalyser.Country.INDIA))
            return new StateCensusPojo(state, population, area, density);
        if (country.equals(StateCensusAnalyser.Country.US))
            return new CSVUSCensus(stateCode, state, population, area, density);
        return null;
    }
}

