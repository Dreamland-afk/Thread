package org.dreamquest.designpatterns.adapter;

public class RoundPeg implements IRoundPeg {
    private double radius;

    public RoundPeg(double radius) { this.radius = radius; }

    @Override
    public double getRadius() {
        return radius;
    }
}
