package org.dreamquest.designpatterns.adapter;

public class Executor {
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(5);
        SquarePeg squarePeg = new SquarePeg(5);

        System.out.println(hole.fits(roundPeg)); // true

        // Adapter
        SquarePegAdapter adapter = new SquarePegAdapter(squarePeg);
        System.out.println(hole.fits(adapter)); // true
    }
}
