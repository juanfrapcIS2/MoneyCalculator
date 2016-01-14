package Application.view;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import model.CurrencySet;
import model.Money;
import view.UI.CurrencyDialog;
import view.UI.MoneyDialog;

public class SwingMoneyDialog extends JTextField implements MoneyDialog{

    private final CurrencyDialog currencyDialog;

    public SwingMoneyDialog(int i, JComboBox comboBox, CurrencySet currencySet){ 
        super(i);
        this.currencyDialog = new SwingCurrencyDialog(comboBox, currencySet);
    }
        
    @Override
    public Money get() {
        return new Money(Double.parseDouble(this.getText()), currencyDialog.get());
    }
    
}
