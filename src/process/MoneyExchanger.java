package process;

import model.ExchangeRate;
import model.Money;

public class MoneyExchanger {
    
    public static Money exchange(Money money, ExchangeRate exchangeRate){
        return new Money(money.getAmount()*exchangeRate.getRate(), exchangeRate.getTo());
    }
}
