package control;

import model.Currency;
import model.ExchangeRate;
import model.Money;
import view.persistence.ExchangeRateReader;
import view.process.MoneyExchanger;
import view.UI.CurrencyDialog;
import view.UI.MoneyDialog;
import view.UI.MoneyDisplay;

public class ExchangeCommand implements Command{

    MoneyDialog moneyDialog;
    CurrencyDialog currencyDialog;
    MoneyDisplay moneyDisplay;
    ExchangeRateReader exchangeRateReader;

    public ExchangeCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, MoneyDisplay moneyDisplay, ExchangeRateReader exchangeRateReader) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.moneyDisplay = moneyDisplay;
        this.exchangeRateReader = exchangeRateReader;
    }
            
    
    @Override
    public void execute() {
        Money money = moneyDialog.get();
        Currency currency = currencyDialog.get();
        ExchangeRate rate = exchangeRateReader.get(money.getCurrency(), currency);
        moneyDisplay.show(MoneyExchanger.exchange(money, rate));
    }
    
}
