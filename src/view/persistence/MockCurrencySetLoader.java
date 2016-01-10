package view.persistence;

import java.util.ArrayList;
import model.Currency;

public class MockCurrencySetLoader implements CurrencySetLoader{

    @Override
    public ArrayList<Currency> load() {
        ArrayList arrayList = new ArrayList<>();
        arrayList.add(new Currency( "EUR", "Euros", '€'));
        arrayList.add(new Currency( "USD", "Dolares", '$'));
        arrayList.add(new Currency( "NOK", "Coronas Noruegas", 'N'));
        arrayList.add(new Currency( "GBP", "Libra Esterlina", '£'));
        return arrayList;
    }
    
}
