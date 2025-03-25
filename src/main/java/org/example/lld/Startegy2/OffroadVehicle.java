package org.example.lld.Startegy2;

import org.example.lld.Startegy2.WithStrategyPattern.DriveStrategy;
import org.example.lld.Startegy2.WithStrategyPattern.SportsDriveStrategy;

public class OffroadVehicle extends Vehicle{


    OffroadVehicle(DriveStrategy driveStrategy) {
        super(new SportsDriveStrategy());
    }
}
