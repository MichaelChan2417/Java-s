/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package turtle;

import java.util.List;
import java.util.ArrayList;

public class TurtleSoup {

    /**
     * Draw a square.
     * 
     * @param turtle the turtle context
     * @param sideLength length of each side
     */
    public static void drawSquare(Turtle turtle, int sideLength) {

        for(int i=0; i<4; i++){
            turtle.forward(sideLength);
            turtle.turn(90);
        }
    }

    /**
     * Determine inside angles of a regular polygon.
     * 
     * There is a simple formula for calculating the inside angles of a polygon;
     * you should derive it and use it here.
     * 
     * @param sides number of sides, where sides must be > 2
     * @return angle in degrees, where 0 <= angle < 360
     */
    public static double calculateRegularPolygonAngle(int sides) {

        throw new RuntimeException("implement me!");
    }

    /**
     * Determine number of sides given the size of interior angles of a regular polygon.
     * 
     * There is a simple formula for this; you should derive it and use it here.
     * Make sure you *properly round* the answer before you return it (see java.lang.Math).
     * HINT: it is easier if you think about the exterior angles.
     * 
     * @param angle size of interior angles in degrees, where 0 < angle < 180
     * @return the integer number of sides
     */
    public static int calculatePolygonSidesFromAngle(double angle) {

        double out_angle = 180 - angle;

        int sides = (int) Math.round(360.0/out_angle);

        return sides;

    }

    /**
     * Given the number of sides, draw a regular polygon.
     * 
     * (0,0) is the lower-left corner of the polygon; use only right-hand turns to draw.
     * 
     * @param turtle the turtle context
     * @param sides number of sides of the polygon to draw
     * @param sideLength length of each side
     */
    public static void drawRegularPolygon(Turtle turtle, int sides, int sideLength) {

        /* Turn to the right first */
        turtle.turn(90);

        /* Calculate the angles */
        double angle = 360.0/sides;

        for(int i=0; i<sides; i++){
            turtle.forward(sideLength);
            turtle.turn(-1*angle);
        }

    }

    /**
     * Given the current direction, current location, and a target location, calculate the heading
     * towards the target point.
     * 
     * The return value is the angle input to turn() that would point the turtle in the direction of
     * the target point (targetX,targetY), given that the turtle is already at the point
     * (currentX,currentY) and is facing at angle currentHeading. The angle must be expressed in
     * degrees, where 0 <= angle < 360. 
     *
     * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
     * 
     * @param currentHeading current direction as clockwise from north
     * @param currentX current location x-coordinate
     * @param currentY current location y-coordinate
     * @param targetX target point x-coordinate
     * @param targetY target point y-coordinate
     * @return adjustment to heading (right turn amount) to get to target point,
     *         must be 0 <= angle < 360
     */
    public static double calculateHeadingToPoint(double currentHeading, int currentX, int currentY,
                                                 int targetX, int targetY) {

        double angle;

        double dx = targetX - currentX;
        double dy = targetY - currentY;

        double targetDir = Math.toDegrees(Math.atan2(dy, dx));
        double base = -1 * (targetDir - 90);
        if(base<0){
            base += 360;
        }

        angle = base - currentHeading;
        System.out.println("MY"+angle+" base:"+base+" heading:"+currentHeading);
        if(angle < 0){
            angle += 360;
            return angle;
        }
        return angle;
    }

    /**
     * Given a sequence of points, calculate the heading adjustments needed to get from each point
     * to the next.
     * 
     * Assumes that the turtle starts at the first point given, facing up (i.e. 0 degrees).
     * For each subsequent point, assumes that the turtle is still facing in the direction it was
     * facing when it moved to the previous point.
     * You should use calculateHeadingToPoint() to implement this function.
     * 
     * @param xCoords list of x-coordinates (must be same length as yCoords)
     * @param yCoords list of y-coordinates (must be same length as xCoords)
     * @return list of heading adjustments between points, of size 0 if (# of points) == 0,
     *         otherwise of size (# of points) - 1
     */
    public static List<Double> calculateHeadings(List<Integer> xCoords, List<Integer> yCoords) {

        List<Double> heading_adjustment = new ArrayList<>();
        double currentHeading = 0;
        int x = xCoords.get(0), y = yCoords.get(0);

        for(int i=1; i<xCoords.size(); i++){
            double changded = calculateHeadingToPoint(currentHeading, x, y, xCoords.get(i), yCoords.get(i));
            heading_adjustment.add(changded);

            currentHeading += changded;
            if(currentHeading > 360){
                currentHeading -= 360;
            }
            x = xCoords.get(i);
            y = yCoords.get(i);
        }



        return heading_adjustment;

    }

    /**
     * Draw your personal, custom art.
     * 
     * Many interesting images can be drawn using the simple implementation of a turtle.  For this
     * function, draw something interesting; the complexity can be as little or as much as you want.
     * 
     * @param turtle the turtle context
     */
    public static void drawPersonalArt(Turtle turtle) {
        throw new RuntimeException("implement me!");
    }

    /**
     * Main method.
     * 
     * This is the method that runs when you run "java TurtleSoup".
     * 
     * @param args unused
     */
    public static void main(String args[]) {
        DrawableTurtle turtle = new DrawableTurtle();

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Double> z = new ArrayList<>();

        x.add(0);
        x.add(0);
        x.add(1);
        x.add(1);
        x.add(0);

        y.add(1);
        y.add(0);
        y.add(0);
        y.add(1);
        y.add(1);

        z = calculateHeadings(x,y);

        System.out.println(z.get(0));
        System.out.println(z.get(1));
        System.out.println(z.get(2));
        System.out.println(z.get(3));
        // draw the window
        // turtle.draw();
    }

}
