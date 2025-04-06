package org.example.lld.ObserverPattern.Observable;

import org.example.lld.ObserverPattern.Observer.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneNotificationObsevableImpl implements StockObservable{
    List<NotificationObserver> observerList=new ArrayList<>();
    public int stockCount=0;


    @Override
    public void add(NotificationObserver observer) {
        observerList.add(observer);


    }

    @Override
    public void remove(NotificationObserver observer) {
        observerList.remove(observer);

    }

    @Override
    public void notifyStockObservers() {
        for (NotificationObserver observer:observerList){
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        if (stockCount==0){
            notifyStockObservers();
        }
        stockCount+=newStockAdded;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
