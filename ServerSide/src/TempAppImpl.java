
import model.Country;
import org.omg.CORBA.ORB;
import TempApp.*;
import java.util.ArrayList;
import java.util.List;

public class TempAppImpl extends TempCheckerPOA {

    private List<Country> countries = new ArrayList<>();
    private ORB orb;

    public TempAppImpl() {
        initList();
    }

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    private void initList() {
        countries.add(new Country("brasil", 24.0));
        countries.add(new Country("argentina", 25.0));
        countries.add(new Country("chile", 20.5));
    }

    @Override
    public String getCountries() {
        StringBuilder result = new StringBuilder();
        for (Country c:
             countries) {
            result.append(c.getName() + " (" + c.getTemp() + "ºC) \n");
        }
        return result.toString();
    }

    @Override
    public String convertCelsiusToF(String symbol) {
        StringBuilder result = new StringBuilder();
        for (Country c:
                countries) {
             if (c.getName().equalsIgnoreCase(symbol)){
                 double convertedValue = 1.8 * c.getTemp() + 32;
                 c.setTemp(convertedValue);
                 result.append(c.getName() + " - " + c.getTemp() + "ºF");
             }
        }

        return result.toString();
    }

}


