package org.example.ObserverPattern.Observer;

import org.example.ObserverPattern.Observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationObserver{
    String email;

    StockObservable stockObservable;
    public EmailAlertObserverImpl(String email, StockObservable stockObservable) {
        this.email = email;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        sendMail(email, "Email Alert: Stock has been updated");
    }

    private void sendMail(String email, String s) {
        System.out.println("Email sent to "+email+" with message "+s);
    }
}
