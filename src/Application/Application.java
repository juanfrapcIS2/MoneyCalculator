package Application;

import Application.view.SQLliteCurrencySetLoader;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import model.CurrencySet;

public class Application extends JFrame {

    private CurrencySet currencySet;
    private String path = "jdbc:sqlite:rates.db";
    
    private JPanel pane;
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        new Application().setVisible(true);
    }
    
    public Application() throws FileNotFoundException, IOException{
        
        this.setTitle("Money Calculator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(400,200));
        this.setLocationRelativeTo(null);
        this.setJMenuBar(añadeMenu());
        this.currencySet = new CurrencySet(new SQLliteCurrencySetLoader(path).load());
        this.pane = processPanel();
        this.getContentPane().add(pane);
    }

    private JPanel processPanel() throws IOException {
        return new ProcessPane(currencySet, path);
    }
    
    private JMenuBar añadeMenu() {
        JMenuBar menuBar = new JMenuBar();
        
        JMenuItem itemNueva = new JMenuItem("Nueva divisa...");
        itemNueva.addActionListener(nuevaListener());
        menuBar.add(itemNueva);
        
        JMenuItem itemAbrir = new JMenuItem("Abrir origen de ratios...");
        itemAbrir.addActionListener(abrirListener());
        menuBar.add(itemAbrir);
        
        
        return menuBar;
    }
    
    private ActionListener nuevaListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CurrencyAdd dialog = new CurrencyAdd(Application.this);
                dialog.setVisible(true);
                currencySet.add(dialog.get());
                Application.this.getContentPane().remove(pane);
                try {
                    Application.this.pane = Application.this.processPanel();
                } catch (IOException ex) {
                    System.out.println("Carpeta no encontrada");
                }
                Application.this.getContentPane().add(pane);
                Application.this.pane.updateUI();
            }
        };
    }

    private ActionListener abrirListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                FileChooser fileChooser = new FileChooser();
                Application.this.path = fileChooser.open(Application.this);
                Application.this.getContentPane().remove(pane);
                if (Application.this.path.endsWith(".db")) {
                    Application.this.currencySet = new CurrencySet(new SQLliteCurrencySetLoader(path).load());
                }
                try {
                    Application.this.pane = Application.this.processPanel();
                } catch (IOException ex) {
                    System.out.println("Carpeta no encontrada");
                }
                Application.this.getContentPane().add(pane);
                Application.this.pane.updateUI();
            }
        };
    }
    
    
    
    
}
