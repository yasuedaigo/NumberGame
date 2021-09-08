import java.util.Scanner;
import java.util.regex.Pattern;


import java.time.chrono.IsoChronology;
import java.util.InputMismatchException;
import java.util.Random;

public class NumberGuessGame {
    private static int inputNumber;
    private static int targetNumber;
    private static final Random RANDOM = new Random();
    private static final Scanner STDIN = new Scanner(System.in);
    private static final int MAX_CHALLENGE_TIMES = 5;
    private static final int RANDOM_NUM_RANGE = 100;
    private static final int COUNT_OF_START = 1;

    private static final String INTRODUCTION_MESSAGE = "数字を当ててみてね。";
    private static final String RULE_MESSAGE = String.format("答えられるのは%d回までだよ。",MAX_CHALLENGE_TIMES);
    

    public static void main(String[] args){
        targetNumber = RANDOM.nextInt(RANDOM_NUM_RANGE);
        System.out.println(INTRODUCTION_MESSAGE);
        System.out.println(RULE_MESSAGE);
        int challengeTimesCounter = COUNT_OF_START;
        while(challengeTimesCounter <= MAX_CHALLENGE_TIMES){
            System.out.print(String.format("%d目",challengeTimesCounter));
            receiveinputNumber();
            if(inputNumber == targetNumber)
            {
                System.out.println(String.format("すごい！！%d回で当てられちゃった！",challengeTimesCounter));
                break;
            }
            if(isCorrect()){
                System.out.println("もっと小さい数字だよ");
                challengeTimesCounter++;
                continue;
            }
            System.out.println("もっと大きい数字だよ");
            challengeTimesCounter++;
        }
        System.out.println("残念！！ 正解は "+targetNumber+" でした！");
        STDIN.close();
    }

    private static void receiveinputNumber(){
        String inputStr;
        do{
            System.out.println("数字を入力してね");
            inputStr = STDIN.nextLine();
        }while(!isNumber(inputStr));
        inputNumber = Integer.parseInt(inputStr);
    }

    private static boolean isNumber(String inputStr) {
        try {
            Integer.parseInt(inputStr);
            return true;
        } catch (NumberFormatException nfex){
            return false;
        }
    }

    private static boolean isCorrect(){
        if(targetNumber == inputNumber){
            return true;
        }
        return false;
    }

    /*private void decideinputNumber(Scanner STDIN){
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
    }*/
}
