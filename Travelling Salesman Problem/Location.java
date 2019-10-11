/**
 *  Student Name: Artur Karolewski
 *  Student Number: 17388976
 * 
 *  -- This class stores the order number, x and y coordinate of a location as well as a number if getter and setter function and a function
 *     that returns a String containing the information about the order and the location (Did not include time)
 */

public class Location {

    private int order;
    private double x;
    private double y;

    // Default constructor
    public Location() {

        this.order = 0;
        this.x = 0;
        this.y = 0;
    }

    // Parameterised constructor
    public Location(int order, double x, double y) {

        this.order = order;
        this.x = x;
        this.y = y;
    }

    // Sets the value of x coordinate
    public void setX(double x) {

        this.x = x;
    } 

    // Sets value of y coordinate
    public void setY(double y) {

        this.y = y;
    }

    // Returns the value of x coordinate 
    public double getX() {

        return x;
    }

    // Returns the value of y coordinate
    public double getY() {

        return y;
    }

    // Sets the value for order
    public void setOrderNum(int order) {

        this.order = order;
    }

    // Returns order number
    public int getOrderNum() {

        return order;
    }

    // Returns a String containing information about order and location
    public String toString() {

        return "Order number: " + order + "\nX coordinate: " + x + "\nY coordinate: " + y;
    }
}