package com.mdt.ocp.chapter2.DesignInterface;

public class Lion implements Run {
    @Override
    public boolean canHuntWhileRunning() {
        return true;
    }

    @Override
    public double getMaxSpeed() {
        return 100;
    }

    @Override
    public boolean isQuadraped() {
        return true;
    }
}

//public interface Sleep extends Lion {} // DOES NOT COMPILE
//public class Tiger extends Walk {} // DOES NOT COMPILE