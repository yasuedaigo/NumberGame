import java.util.Scanner;
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
    private static final String RULE_MESSAGE = String.format("答えられるのは%d回までだよ。", MAX_CHALLENGE_TIMES);

    public static void main(String[] args) {
        targetNumber = RANDOM.nextInt(RANDOM_NUM_RANGE);
        System.out.println(targetNumber);
        showFirstMessage();
        int challengeTimesCounter = COUNT_OF_START;
        while (!isCountOver(challengeTimesCounter)) {
            showCountMessage(challengeTimesCounter);
            receiveinputNumber();
            if (isCorrect()) {
                break;
            }
            showHintMessage();
            challengeTimesCounter++;
        }
        showResultMessage(challengeTimesCounter);
        STDIN.close();
    }

    private static void showResultMessage(int challengeTimesCounter) {
        if (isCorrect()) {
            System.out.println(String.format("すごい！！%d回で当てられちゃった！", challengeTimesCounter));
            return;
        }
        System.out.println("残念！！ 正解は " + targetNumber + " でした！");
    }

    private static void showCountMessage(int challengeTimesCounter) {
        System.out.println(String.format("%d回目", challengeTimesCounter));
    }

    private static void showFirstMessage() {
        System.out.println(INTRODUCTION_MESSAGE);
        System.out.println(RULE_MESSAGE);
    }

    private static void receiveinputNumber() {
        String inputStr;
        do {
            System.out.println("数字を入力してね");
            inputStr = STDIN.nextLine();
        } while (!isNumber(inputStr));
        inputNumber = Integer.parseInt(inputStr);
    }

    private static boolean isCountOver(int challengeTimesCounter) {
        if (challengeTimesCounter <= MAX_CHALLENGE_TIMES) {
            return false;
        }
        return true;
    }

    private static boolean isNumber(String inputStr) {
        try {
            Integer.parseInt(inputStr);
            return true;
        } catch (NumberFormatException nfex) {
            return false;
        }
    }

    private static boolean isCorrect() {
        if (targetNumber == inputNumber) {
            return true;
        }
        return false;
    }

    private static boolean isTooBig() {
        if (targetNumber >= inputNumber) {
            return false;
        }
        return true;
    }

    private static void showHintMessage() {
        if (isTooBig()) {
            System.out.println("もっと小さい数字だよ");
            return;
        }
        System.out.println("もっと大きい数字だよ");
    }
}
