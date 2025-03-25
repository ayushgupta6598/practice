package org.example.lld.Startegy2.WithStrategyPattern;

public class SportsDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("SportsDriveStrategy");
    }
}
