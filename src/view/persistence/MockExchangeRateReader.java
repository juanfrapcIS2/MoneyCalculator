package view.persistence;

import model.Currency;
import model.ExchangeRate;

public class MockExchangeRateReader implements ExchangeRateReader {

    @Override
    public ExchangeRate get(Currency from, Currency to) {
        return new ExchangeRate(from, to, 1.25);
    }
    
}
