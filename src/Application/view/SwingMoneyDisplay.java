package Application.view;

import javax.swing.JTextField;
import model.Money;
import view.UI.MoneyDisplay;

public class SwingMoneyDisplay implements MoneyDisplay{

    private final JTextField field;

    public SwingMoneyDisplay(JTextField field) {
        this.field = field;
    }
            
    @Override
    public void show(Money money) {
        field.setText(money.getAmount() + "");
    }
    
}
