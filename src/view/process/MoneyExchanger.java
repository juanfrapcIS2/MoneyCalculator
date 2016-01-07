package view.process;

import model.Currency;
import model.ExchangeRate;
import model.Money;

public class MoneyExchanger {
    
    public static Money exchange(Money money, ExchangeRate exchangeRate){
        Double amount = money.getAmount();
        Double rate = exchangeRate.getRate();
        Currency currency = exchangeRate.getTo();
        return new Money(amount * rate, currency);
    }
}
