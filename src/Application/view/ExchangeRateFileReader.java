package Application.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Currency;
import model.CurrencySet;
import model.ExchangeRate;
import view.persistence.ExchangeRateReader;

public class ExchangeRateFileReader implements ExchangeRateReader{

    private final File file;
    
    public ExchangeRateFileReader(File file, CurrencySet currencySet) {
        this.file = file;
    }

    @Override
    public ExchangeRate get(Currency from, Currency to) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null){
                String[] attributes = line.split(";");
                if (from.getCode().equals(attributes[0].trim()) && to.getCode().equals(attributes[1].trim())) {                    
                    return new ExchangeRate(from, to, Double.parseDouble(attributes[2].trim()));
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExchangeRateFileReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExchangeRateFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
