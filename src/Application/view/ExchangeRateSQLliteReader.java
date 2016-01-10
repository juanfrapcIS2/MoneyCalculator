package Application.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Currency;
import model.ExchangeRate;
import view.persistence.ExchangeRateReader;

public class ExchangeRateSQLliteReader implements ExchangeRateReader{
    
    private final String path;

    public ExchangeRateSQLliteReader(String path) {
        this.path = path;
    }
    
    @Override
    public ExchangeRate get(Currency from, Currency to) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connec = DriverManager.getConnection(path);
            Statement state = connec.createStatement();
            
            String fromCurrency = from.getCode();
            String toCurrency = to.getCode();
            String ristra = "select * from ExchangeRates where FromCurrency = '" 
                    + fromCurrency+ "' and ToCurrency = '"+ toCurrency+"'";
            ResultSet rs = state.executeQuery(ristra);
            
            while(rs.next()){
                    
                double rate = rs.getDouble("Rate");
                return new ExchangeRate(from, to, rate);
                    
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ExchangeRateSQLliteReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Rate not found");
        return null;
    }
    
}
