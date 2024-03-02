package question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScoreMessage {
    public static void main(String[] args) throws IOException {
        // BufferedReaderの準備
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        /*
         * スコアの入力
         * 各スコアに応じた各スコアに応じたメッセージの出力
         */

         System.out.println("Enter your score (0-100): ");
         int score = Integer.parseInt(reader.readLine());

         if (score >= 0 && score <= 100) {
            if (score >= 80) {
                System.out.println("Great!!");
            } else if (score >= 60) {
                System.out.println("Good!");
            } else if (score >=40) {
                System.out.println("Fair.");
            } else {
                System.out.println("Poor...");
            }
         } else {
            System.out.println("Invalid score.");
         }
    }
}
