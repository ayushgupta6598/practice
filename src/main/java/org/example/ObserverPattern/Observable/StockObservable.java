package org.example.ObserverPattern.Observable;

import org.example.ObserverPattern.Observer.NotificationObserver;

public interface StockObservable {
    public void  add(NotificationObserver observer);
    public void remove(NotificationObserver observer);
    public void notifyStockObservers();
    public  void setStockCount(int newStockAdded);
    public int getStockCount();


}
