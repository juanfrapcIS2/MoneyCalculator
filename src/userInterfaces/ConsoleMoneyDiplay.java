package userInterfaces;

import model.Money;

public class ConsoleMoneyDiplay implements MoneyDisplay{

    @Override
    public void show(Money money) {
        System.out.println(money.getAmount());
    }
    
}
