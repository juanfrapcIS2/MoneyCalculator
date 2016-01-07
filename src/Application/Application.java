package Application;

import control.Command;
import control.ExchangeCommand;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import model.CurrencySet;
import view.UI.ConsoleMoneyDiplay;
import view.UI.CurrencyDialog;
import view.UI.MockCurrencyDialog;
import view.UI.MockMoneyDialog;
import view.UI.MoneyDialog;
import view.UI.MoneyDisplay;
import view.persistence.ExchangeRateReader;
import view.persistence.MockExchangeRateReader;

public class Application extends JFrame {

    private CurrencySet currencySet = new CurrencySet();
    private String path ="C:\\Users\\Granfran\\Documents\\NetBeansProjects\\MoneyCalculator\\rates.txt";
    
    public static void main(String[] args) throws FileNotFoundException {
        
        new Application().setVisible(true);
//        CurrencyDialog CurrencyDialog = new MockCurrencyDialog();
//        MoneyDialog MoneyDialog = new MockMoneyDialog();
//        MoneyDisplay MoneyDiplay = new ConsoleMoneyDiplay();
//        ExchangeRateReader ExchangeRateReader = new MockExchangeRateReader();
//        Command command = new ExchangeCommand(MoneyDialog, CurrencyDialog, MoneyDiplay, ExchangeRateReader);
//    
//        command.execute();
    }
    
    public Application() throws FileNotFoundException{
        
        this.setTitle("Money Calculator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(400,200));
        this.setLocationRelativeTo(null);
//        this.setJMenuBar(añadeMenu());
        this.getContentPane().add(processPanel());
    }

//    private JMenuBar añadeMenu() {
//        JMenuBar menuBar = new JMenuBar();
//        
//        JMenu menuCurrency = new JMenu("Añadir divisas");
//        JMenuItem itemNueva = new JMenuItem("Nueva...");
//        itemNueva.addActionListener(nuevaListener());
//        JMenuItem itemFichero = new JMenuItem("Desde Fichero...");
//        JMenuItem itemDB = new JMenuItem("Desde Base de Datos...");
//        menuCurrency.add(itemNueva);
//        menuCurrency.add(itemFichero);
//        menuCurrency.add(itemDB);
//        
//        menuBar.add(menuCurrency);
//        return menuBar;
//    }
//
//    private ActionListener nuevaListener() {
//        return new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                CurrencyAdd dialog = new CurrencyAdd(Application.this);
//                dialog.setVisible(true);
//                currencySet.add(dialog.get());
//            }
//        };
//    }

    private JPanel processPanel() throws FileNotFoundException {
        return new ProcessPane(currencySet, path);
    }
    
    
    
    
}
