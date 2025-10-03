package exercise3;

public class CalculateArea {

    //Method 1: area of a square
    public static int area(int side) {
        return side * side;
    }

    //Method 2: area of a rectangle
    public static int area(int length, int width) {
        return length * width;
    }

    //Method 3: area of a triangle
    public static double area(double base, double height) {
        return 0.5 * base * height;
    }
}
