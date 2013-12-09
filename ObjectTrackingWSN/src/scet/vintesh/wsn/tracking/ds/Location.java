/*
 * Implemented as Tutorial of Masters Program 
 * M.E. - Computer Engineering 
 * For Dissetation Work - Tree based Object Tracking in WSN 
 * SCET, Surat
 */
package scet.vintesh.wsn.tracking.ds;

import java.util.Random;

/**
 *
 * @author Vintesh
 */
public class Location {

    private int x;
    private int y;

    // Indicates size of Area of Simulation senario
    private static final int maxX = 256;
    private static final int maxY = 256;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static Location getRandomLocation() {
        return new Location(new Random().nextInt(256), new Random().nextInt(265));
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    // For testing the methods
    public static void main(String[] args) {
        System.out.println(Location.getRandomLocation());
    }
}
