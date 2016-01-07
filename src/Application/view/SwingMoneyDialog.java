package Application.view;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import model.CurrencySet;
import model.Money;
import view.UI.CurrencyDialog;
import view.UI.MoneyDialog;

public class SwingMoneyDialog implements MoneyDialog{

    private final JTextField field;
    private final CurrencyDialog currencyDialog;

    public SwingMoneyDialog(JTextField field, JComboBox comboBox, CurrencySet currencySet) {
        this.field = field;
        this.currencyDialog = new SwingCurrencyDialog(comboBox, currencySet);
    }
        
    @Override
    public Money get() {
        return new Money(Double.parseDouble(field.getText()), currencyDialog.get());
    }
    
}
