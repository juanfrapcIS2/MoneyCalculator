package Application.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Currency;
import view.persistence.CurrencySetLoader;

public class SQLliteCurrencySetLoader implements CurrencySetLoader {

    private final ArrayList<Currency> lista = new ArrayList<>();
    private final String path;

    public SQLliteCurrencySetLoader(String path) {
        this.path = path;
    }
                    
    @Override
    public ArrayList<Currency> load(){
        try {
            
            Class.forName("org.sqlite.JDBC");
            Connection connec = DriverManager.getConnection(path);
            Statement state = connec.createStatement();
            
            ResultSet rs = state.executeQuery("SELECT * FROM Currencies");
             
                while(rs.next()){
                    
                    String code = rs.getString(1);
                    String name = rs.getString(2);
                    char symbol;
                    symbol = rs.getString(3).charAt(0);
                    
                    lista.add(new Currency(code, name, symbol));
                }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SQLliteCurrencySetLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
}
