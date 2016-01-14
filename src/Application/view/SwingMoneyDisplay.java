package Application.view;

import javax.swing.JTextField;
import model.Money;
import view.UI.MoneyDisplay;

public class SwingMoneyDisplay extends JTextField implements MoneyDisplay{

    public SwingMoneyDisplay(int i) {
        super(i);
    }
            
    @Override
    public void show(Money money) {
        this.setText(money.getAmount() + "");
    }
    
}
