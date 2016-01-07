package view.UI;

import model.Currency;

public class MockCurrencyDialog implements CurrencyDialog {

    public MockCurrencyDialog() {
    }

    @Override
    public Currency get() {
        return new Currency("EUR", "Euro", '€');
    }

    
    
}
