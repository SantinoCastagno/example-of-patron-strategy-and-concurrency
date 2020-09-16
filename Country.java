

import java.util.Date;

public class Country {

    private final String Country;
    private final String CountryCode;
    private final String Slug;
    private final int NewConfirmed;
    private final int TotalConfirmed;
    private final int NewDeaths;
    private final int TotalDeaths;
    private final int NewRecovered;
    private final int TotalRecovered;
    private final Date Date;

    public Country(String country, String code, String slug, int newConf, int totalConf,
            int newDeaths, int totalDeaths, int newRecovered, int totalRecovered, Date date) {

        this.Country = country;
        this.CountryCode = code;
        this.Slug = slug;
        this.NewConfirmed = newConf;
        this.TotalConfirmed = totalConf;
        this.NewDeaths = newDeaths;
        this.TotalDeaths = totalDeaths;
        this.NewRecovered = newRecovered;
        this.TotalRecovered = totalRecovered;
        this.Date = date;
    }
    
    public String getCountry() {
        return this.Country;
    }
    
    public int getNewConfirmed() {
        return this.NewConfirmed;
    }

    public int getNewDeaths() {
        return NewDeaths;
    }

    public int getTotalDeaths() {
        return TotalDeaths;
    }

    public int getNewRecovered() {
        return NewRecovered;
    }

    public int getTotalRecovered() {
        return TotalRecovered;
    }
    
    public int getTotalConfirmed() {
        return this.TotalConfirmed;
    }
    
    public Date getDate(){ 
        return this.Date;
    }

    @Override
    public String toString() {
        return "Country=" + Country + ", NewConfirmed=" + NewConfirmed + ", TotalConfirmed=" + TotalConfirmed + ", NewDeaths=" + NewDeaths + ", TotalDeaths=" + TotalDeaths + ", NewRecovered=" + NewRecovered + ", TotalRecovered=" + TotalRecovered;
    }

}
