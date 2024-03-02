package question4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuizGame {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

				// 質問文
        String[] questions = {
            "What is the main ingredient in traditional Italian pizza dough?", // イタリアの伝統的なピザ生地の主原料は？
            "Which country is known for inventing sushi?", // 寿司を発明したことで知られる国は？
            "In which country did the sandwich originate?", // サンドイッチの発祥国は？
            "What is the longest river in the world?", // 世界で最も長い川は？
            "Mount Everest is located in which mountain range?", // エベレストはどの山脈にあるか？
            "What is the capital city of Australia?" // オーストラリアの首都は？
        };

        // 正解
        String[] answers = {
            "Flour", // 小麦粉
            "Japan", // 日本
            "United Kingdom", // イギリス
            "Nile River", // ナイル川
            "Himalayas", // ヒマラヤ山脈
            "Canberra" // キャンベラ
        };

        int score = 0;

        // 不正解だった質問と答えを入れる配列の準備
        String[][] wrongQuestions = new String[questions.length][2];
        int wrongCount = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            System.out.print("Please enter your answer: ");
            String userAnswer = reader.readLine();

            if (userAnswer.equals(answers[i])) {
                System.out.println("Correct!"); // 正解
                score++;
            } else {
                System.out.println("Incorrect."); // 不正解
                // 不正解だった質問と答えを配列に入れる
                wrongQuestions[wrongCount][0] = questions[i];
                wrongQuestions[wrongCount][1] = answers[i];
                wrongCount++;
            }
        }

        System.out.println("Your score is: " + score);

        // 不正解の質問と答えの出力
        System.out.println("Review the incorrect answer: ");
        for (int i = 0; i < wrongCount; i++) {
            System.out.println("Question: " + wrongQuestions[i][0]);
            System.out.println("Correct answer: " + wrongQuestions[i][1]);
        }
    }
}