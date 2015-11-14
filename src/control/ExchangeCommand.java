package control;

import persistence.ExchangeRateReader;
import process.MoneyExchanger;
import userInterfaces.CurrencyDialog;
import userInterfaces.MoneyDialog;
import userInterfaces.MoneyDisplay;

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
        moneyDisplay.show(MoneyExchanger.exchange(moneyDialog.get(), exchangeRateReader.get(currencyDialog.get(), currencyDialog.get())));
    }
    
}
