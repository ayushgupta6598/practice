package org.example.lld.Startegy2.WithStrategyPattern;

public class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("NormalDriveStrategy");
    }
}
