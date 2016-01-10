package Application;

import Application.view.ExchangeRateFileReader;
import Application.view.ExchangeRateSQLliteReader;
import Application.view.SwingCurrencyDialog;
import Application.view.SwingMoneyDialog;
import Application.view.SwingMoneyDisplay;
import control.ExchangeCommand;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.CurrencySet;
import view.UI.CurrencyDialog;
import view.UI.MoneyDialog;
import view.UI.MoneyDisplay;
import view.persistence.ExchangeRateReader;

public class ProcessPane extends JPanel{

    private final CurrencySet currencySet;
    private MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private MoneyDisplay moneyDisplay;
    private ExchangeRateReader exchangeRateReader;
    
    private final JComboBox comboBoxFrom;
    private final JComboBox comboBoxTo;
        
    public ProcessPane(CurrencySet currencySet, String path) throws FileNotFoundException, IOException {
        this.currencySet = currencySet;
        this.selectReader(path);
        this.comboBoxFrom = new JComboBox(options(currencySet));
        this.comboBoxTo = new JComboBox(options(currencySet));
        this.currencyDialog = new SwingCurrencyDialog(comboBoxTo, currencySet);
        this.add(addInputPane());
        this.add(addOutputPane());
    }
    
    private JPanel addInputPane() {
        JPanel pane = new JPanel();
        pane.add(new JLabel("Convertir"));
        pane.add(comboBoxFrom);
        pane.add(new JLabel("a"));
        pane.add(comboBoxTo);
        return pane;
        
    }

    private JPanel addOutputPane() {
        JPanel pane = new JPanel();
        JTextField fieldIn = new JTextField(10);
        pane.add(fieldIn);
        this.moneyDialog = new SwingMoneyDialog(fieldIn, comboBoxFrom, currencySet);
        
        JLabel label = new JLabel(currencySet.get(0).getSymbol() +"");
        pane.add(label);
        comboBoxFrom.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(currencySet.get(comboBoxFrom.getSelectedIndex()).getSymbol() + "");
            }
        });
        
        JButton button = new JButton("equivale a");
        button.addActionListener(executeAction());
        pane.add(button);
        
        JTextField fieldOut = new JTextField(10);
        fieldOut.setEditable(false);
        this.moneyDisplay = new SwingMoneyDisplay(fieldOut);
        pane.add(fieldOut);
        
        JLabel label1 = new JLabel(currencySet.get(0).getSymbol() +"");
        pane.add(label1);
        comboBoxTo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setText(currencySet.get(comboBoxTo.getSelectedIndex()).getSymbol() + "");
                fieldOut.setText("");
            }
        });
        return pane;
    }

    private String[] options(CurrencySet currencySet) {
        String[] currencies = new String[currencySet.size()];
        for (int i = 0; i < currencies.length; i++) {
            currencies[i] = currencySet.get(i).getName();
        }
        return currencies;       
    }

    private ActionListener executeAction() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ExchangeCommand(moneyDialog, currencyDialog, moneyDisplay, exchangeRateReader).execute();
            }
        };
    }

    private void selectReader(String path) {
        if (path.endsWith(".db")) {
            this.exchangeRateReader = new ExchangeRateSQLliteReader(path);
        }else{
            this.exchangeRateReader = new ExchangeRateFileReader(new File(path), currencySet);
        }
    }


    
    
}