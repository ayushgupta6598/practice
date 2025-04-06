package org.example.lld.ObserverPattern.Observer;

import org.example.lld.ObserverPattern.Observable.StockObservable;

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
