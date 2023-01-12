package org.example;
public class Main {
    public static void main(String[] args) {

        BerlinClock berlinClock = new BerlinClock();
        System.out.println(berlinClock.getClockDigitalToBerlin("16:50:06"));
        System.out.println(berlinClock.getClockBerlinToDigital("ORROOROOOYYRYYRYOOOOYYOO"));

    }
}
