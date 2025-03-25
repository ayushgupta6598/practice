package org.example.lld.Startegy2;

import org.example.lld.Startegy2.WithStrategyPattern.DriveStrategy;
import org.example.lld.Startegy2.WithStrategyPattern.NormalDriveStrategy;
import org.example.lld.Startegy2.WithStrategyPattern.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {


    SportsVehicle(DriveStrategy driveStrategy) {
        super(new SportsDriveStrategy());
    }
}
