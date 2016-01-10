package model;

import java.util.ArrayList;
import java.util.Iterator;

public class CurrencySet implements Iterable<Currency>{
    
    private final ArrayList<Currency> currencySet;

    public CurrencySet(ArrayList<Currency> CurrencySet) {
        this.currencySet = CurrencySet;
    }

    public CurrencySet() {
        currencySet = new ArrayList<>();
    }

    public Currency get(int index) {
        return currencySet.get(index);
    }

    public boolean add(Currency e) {
        return currencySet.add(e);
    }

    public boolean remove(Object o) {
        return currencySet.remove(o);
    }

    public ArrayList<Currency> getCurrencySet() {
        return currencySet;
    }
    
    public int size(){
        return this.currencySet.size();
    }

    @Override
    public Iterator<Currency> iterator() {
        return new Iterator<Currency>() {
            private int cursor;

            @Override
            public boolean hasNext() {
                return cursor < CurrencySet.this.currencySet.size();
            }

            @Override
            public Currency next() {
                return CurrencySet.this.get(cursor++);
            }
        };
    }
    
}
