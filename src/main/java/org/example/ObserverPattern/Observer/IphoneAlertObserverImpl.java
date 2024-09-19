package org.example.ObserverPattern.Observer;

import org.example.ObserverPattern.Observable.StockObservable;

public class IphoneAlertObserverImpl implements NotificationObserver{
    String userName;
    StockObservable observable;

    public IphoneAlertObserverImpl(String userName, StockObservable observable) {
        this.userName = userName;
        this.observable = observable;
    }

    @Override
    public void update() {
    }
}
