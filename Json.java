

public class Json {

    private final String Message;
    private final Global Global;
    private final Country[] Countries;

    public Json(String message, Global global, Country[] country) {
        this.Message = message;
        this.Global = global;
        this.Countries = country;
    }

    public Global getGlobal() {
        return Global;
    }

    public Country[] getCountries() {
        return Countries;
    }

}
