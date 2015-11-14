package moneycalculator;

import control.*;
import persistence.*;
import userInterfaces.*;

public class Application {

    public static void main(String[] args) {
        
        CurrencyDialog CurrencyDialog = new MockCurrencyDialog();
        MoneyDialog MoneyDialog = new MockMoneyDialog();
        MoneyDisplay MoneyDiplay = new ConsoleMoneyDiplay();
        ExchangeRateReader ExchangeRateReader = new MockExchangeRateReader();
        Command command = new ExchangeCommand(MoneyDialog, CurrencyDialog, MoneyDiplay, ExchangeRateReader);
    
        command.execute();
    }
    
}
