import exercise1.Test;
import exercise2.Lotto;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Test test = new Test();  //Test object
//        test.inputAnswer();

        Lotto lotto = new Lotto();
        lotto.playGame();
    }
}