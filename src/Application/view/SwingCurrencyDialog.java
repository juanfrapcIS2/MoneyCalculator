package Application.view;

import javax.swing.JComboBox;
import model.Currency;
import model.CurrencySet;
import view.UI.CurrencyDialog;

public class SwingCurrencyDialog implements CurrencyDialog{
    
    private final JComboBox comboBox;
    private final CurrencySet currencySet;

    public SwingCurrencyDialog(JComboBox comboBox, CurrencySet currencySet) {
        this.comboBox = comboBox;
        this.currencySet = currencySet;
    }
        
    @Override
    public Currency get() {
        return currencySet.get(comboBox.getSelectedIndex());
    }

    
    
}
