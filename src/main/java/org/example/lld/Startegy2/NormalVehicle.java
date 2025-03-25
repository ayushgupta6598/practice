package org.example.lld.Startegy2;

import org.example.lld.Startegy2.WithStrategyPattern.NormalDriveStrategy;

public class NormalVehicle extends Vehicle{

    NormalVehicle(){
        super(new NormalDriveStrategy());
    }

}
