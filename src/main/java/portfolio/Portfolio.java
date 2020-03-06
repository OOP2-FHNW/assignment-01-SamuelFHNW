package portfolio;

import portfolio.investments.Investment;

import java.util.ArrayList;
import java.util.List;

public class Portfolio<T extends Investment> {
    private List<T> investments = new ArrayList<T>();

    public boolean contains(T ubs) {
        for(T i : investments){
            if(i.equals(ubs)){
                return true;
            }
        }
        return false;
    }

    public void buy(T ubs) {
        if(!contains(ubs)){investments.add(ubs);}
        else {
            T tmp = getShare(ubs.getTitel());
            tmp.setCount(tmp.getCount()+ubs.getCount());
        }
    }

    public void sell(String ubs, double i) {
        T tmp = getShare(ubs);
        if(tmp != null){
            if(tmp.getCount() <= i){investments.remove(tmp);tmp.setCount(0);}
            else{tmp.setCount(tmp.getCount()-i);}
        }
    }

    public T getShare(String ubs) {
        for(T i : investments){
            if(ubs.equals(i.getTitel())){
                return i;
            }
        }
        return null;
    }
    //TODO Complete this implementation and make it generic
}
