import exercise1.Test;
import exercise2.Lotto;
import exercise3.CalculateArea;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Test class
        Test test = new Test();  //Test object
//        test.inputAnswer();

        //Lotto class
        Lotto lotto = new Lotto();
//        lotto.playGame();

        //CalculateArea class
        CalculateArea areas = new CalculateArea();
        System.out.println("Area of square: " + areas.area(5));
        System.out.println("Area of rectangle: " + areas.area(4, 6));
        System.out.println("Area of triangle: " + areas.area(3.0, 4.0));
    }
}