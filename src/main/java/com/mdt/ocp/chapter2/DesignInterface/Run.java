package com.mdt.ocp.chapter2.DesignInterface;

public interface Run extends Walk{
    public abstract boolean canHuntWhileRunning();
    abstract double getMaxSpeed();
}
