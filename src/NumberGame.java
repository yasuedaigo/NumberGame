import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Random;

public class NumberGame {
    static int inputNumber;
    static int targetNumber;
    public static void main(String[] args) throws Exception {
        NumberGame numberGame = new NumberGame();
        Random r = new Random();
        targetNumber = r.nextInt(100);
        Scanner scan = new Scanner(System.in);
        boolean correct = false;
        System.out.println("数字を当ててみてね。");
        System.out.println("答えられるのは５回までだよ。");
        for (int i=1; i<6; i++){
            System.out.print(i+"回目 : ");
            numberGame.decideinputNumber(scan);
            if(inputNumber == targetNumber)
            {
                System.out.println("すごい！！"+i+"回で当てられちゃった！");
                correct = true;
                break;
            }else if(inputNumber >= targetNumber){
                System.out.println("もっと小さい数字だよ");
            }else if(inputNumber <= targetNumber){
                System.out.println("もっと大きい数字だよ");
            }
        }
        if(correct == false)
        {
            System.out.println("残念！！ 正解は "+targetNumber+" でした！");
        }
        scan.close();
    }

    void decideinputNumber(Scanner scan){
        String inputStr;
        do{
            inputStr = scan.nextLine();
        }while(isnotDecimal(inputStr));
        inputNumber = Integer.parseInt(inputStr);
    }

    boolean isnotDecimal(String value) {
        boolean result;
        Pattern pattern = Pattern.compile("^([1-9]\\d*|0)(\\.\\d+)?$|^(-[1-9]\\d*|0)(\\.\\d+)?$");
        result = pattern.matcher(value).matches();
        return !result;
    }
}
