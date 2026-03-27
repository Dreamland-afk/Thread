package org.dreamquest.designpatterns.adapter;

public class RoundHole {
    private double holeRadius;

    public RoundHole(double radius) { this.holeRadius = radius; }

    public boolean fits(IRoundPeg peg) {
        return this.holeRadius >= peg.getRadius();
    }
}
