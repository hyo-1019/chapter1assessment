package question5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultipleChoice {
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

        // 正解の番号
        String[] answers = {"3", "2", "2", "2", "3", "3"};

        // 選択肢
        String[][] choices = {
            {"1: Water", "2: Yeast", "3: Flour", "4: Salt"},
                {"1: China", "2: Japan", "3: Korea", "4: Vietnam"},
                {"1: Germany", "2: United Kingdom", "3: USA", "4: Italy"},
                {"1: Amazon River", "2: Nile River", "3: Yangtze River", "4: Mississippi River"},
                {"1: Andes", "2: Rockies", "3: Himalayas", "4: Alps"},
                {"1: Sydney", "2: Melbourne", "3: Canberra", "4: Brisbane"}
        };

        int score = 0;

        // 不正解の質問と答えを入れる配列
        String[][] wrongQuestions = new String[questions.length][3];
        int wrongCount = 0;

        // 問題の出力
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            // 選択肢の出力
            for (String choice : choices[i]) {
                System.out.println(choice);
            }
            // 答えの入力を受け入れる
            System.out.print("Please enter the number of your answer: ");
            String userAnswer = reader.readLine();

            if (userAnswer.equals(answers[i])) {
                System.out.println("Correct!"); // 正解
                score++;
            } else {
                System.out.println("Incorrect."); // 不正解
                // 不正解だった質問と答えを配列に入れる
                wrongQuestions[wrongCount][0] = questions[i];
                wrongQuestions[wrongCount][1] = answers[i];
                wrongQuestions[wrongCount][2] = choices[i][Integer.parseInt(answers[i]) - 1];
                wrongCount++;
            }
        }

        System.out.println("Your score is: " + score);

        // 不正解の質問と答えの出力
        System.out.println("Review the incorrect answer: ");
        for (int i = 0; i < wrongCount; i++) {
            System.out.println("Question: " + wrongQuestions[i][0]);
            System.out.println("Correct answer: " + wrongQuestions[i][2]);
        }
    }
}
