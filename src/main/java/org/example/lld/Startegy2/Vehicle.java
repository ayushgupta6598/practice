package org.example.lld.Startegy2;

import org.example.lld.Startegy2.WithStrategyPattern.DriveStrategy;

public class Vehicle {

    DriveStrategy driveStrategy;

    Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive(){
        driveStrategy.drive();
    }

}
