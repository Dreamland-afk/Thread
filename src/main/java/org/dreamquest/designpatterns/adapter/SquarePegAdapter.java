package org.dreamquest.designpatterns.adapter;

public class SquarePegAdapter implements IRoundPeg {
    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        // Calculate a minimum circle radius, which can fit this peg.
        return (peg.getWidth() * Math.sqrt(2)) / 2;
    }
}
