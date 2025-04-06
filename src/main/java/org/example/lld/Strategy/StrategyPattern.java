package org.example.lld.Strategy;

public class StrategyPattern {
    public void main(String[] args) {
        Vehicle vehicle = new PassengerVehicle(new NormalDrive());
        vehicle.drive();
    }
}

interface DriveStrategy {
    public void drive();
}

class SportsDrive implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Sports Drive");
    }
}

class NormalDrive implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Normal Drive");
    }
}

class PassengerVehicle extends Vehicle {

    public PassengerVehicle(DriveStrategy _driveStrategy) {
        super(_driveStrategy);
    }

}

class Vehicle {
    DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy _driveStrategy) {
        this.driveStrategy = _driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
}



