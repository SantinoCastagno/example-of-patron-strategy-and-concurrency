

public class Global {

    private final int NewConfirmed;
    private final int TotalConfirmed;
    private final int NewDeaths;
    private final int TotalDeaths;
    private final int NewRecovered;
    private final int TotalRecovered;

    public Global(int NewConfirmed, int TotalConfirmed, int NewDeaths, int TotalDeaths, int NewRecovered, int TotalRecovered) {
        this.NewConfirmed = NewConfirmed;
        this.TotalConfirmed = TotalConfirmed;
        this.NewDeaths = NewDeaths;
        this.TotalDeaths = TotalDeaths;
        this.NewRecovered = NewRecovered;
        this.TotalRecovered = TotalRecovered;
    }

    @Override
    public String toString() {
        return "Global{" + "NewConfirmed=" + NewConfirmed + ", TotalConfirmed=" + TotalConfirmed + ", NewDeaths=" + NewDeaths + ", TotalDeaths=" + TotalDeaths + ", NewRecovered=" + NewRecovered + ", TotalRecovered=" + TotalRecovered + '}';
    }

    
}
