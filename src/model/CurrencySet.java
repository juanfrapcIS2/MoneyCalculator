package model;

import java.util.ArrayList;

public class CurrencySet {
    
    private final ArrayList<Currency> CurrencySet;

    public CurrencySet(ArrayList<Currency> CurrencySet) {
        this.CurrencySet = CurrencySet;
    }

    public Currency get(int index) {
        return CurrencySet.get(index);
    }

    public boolean add(Currency e) {
        return CurrencySet.add(e);
    }

    public boolean remove(Object o) {
        return CurrencySet.remove(o);
    }

    public ArrayList<Currency> getCurrencySet() {
        return CurrencySet;
    }
    
}
