package view.UI;

import model.Currency;
import model.Money;

public class MockMoneyDialog implements MoneyDialog{

    @Override
    public Money get() {
        return new Money(100, new Currency("USD", "Dolar Americano", '$'));
    }

    
    
}
