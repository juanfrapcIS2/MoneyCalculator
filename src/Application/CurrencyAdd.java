package Application;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Currency;
import view.UI.CurrencyDialog;

public class CurrencyAdd extends JFrame {

    private Currency currency;
    
    public CurrencyAdd(JFrame frame){
        this.deployUI(frame);
        this.buttons();
    }
    
    private void deployUI(JFrame frame) {
        this.setTitle("Añade Divisa");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setMinimumSize(new Dimension(400,100));
        this.setLocationRelativeTo(frame);
    }
    
    private void buttons() {
        Container pane = getContentPane();
        pane.add(new JLabel("Nombre"));
        JTextField nombre = new JTextField(10);
        pane.add(nombre);
        pane.add(new JLabel("Símbolo"));
        JTextField simbolo = new JTextField(1);
        pane.add(simbolo);
        pane.add(new JLabel("Código"));
        JTextField codigo = new JTextField(4);
        pane.add(codigo);
        
        JButton button = new JButton("OK");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                currency = new Currency(nombre.getText(), codigo.getText(), simbolo.getText().charAt(0));
                CurrencyAdd.this.setVisible(false);
            }
        });
        pane.add(button);
    }
    
    public Currency get() {
        return currency;
    }


    
}
