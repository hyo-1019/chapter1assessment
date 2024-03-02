package question8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GenreQuiz {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 質問文をジャンルに分ける
        String[][][] questions = {
            //FOOD
            {
                {"What is the main ingredient in traditional Italian pizza dough?"}, // イタリアの伝統的なピザ生地の主原料は？
                {"Which country is known for inventing sushi?"}, // 寿司を発明したことで知られる国は？
                {"In which country did the sandwich originate?"}, // サンドイッチの発祥国は？
            },
            // GEOGRAPHY
            {
                {"What is the longest river in the world?"}, // 世界で最も長い川は？
                {"Mount Everest is located in which mountain range?"}, // エベレストはどの山脈にあるか？
                {"What is the capital city of Australia?"} // オーストラリアの首都は？
            }
        };

        // ジャンルの選択
        int userGenre = 0;
        while(true) {
            System.out.println("Select a genre: ");
            System.out.println("1. FOOD");
            System.out.println("2. GEOGRAPHY");
            userGenre = Integer.parseInt(reader.readLine()) - 1;

            if (userGenre >= 0 && userGenre < questions.length) {
                break;
            } else {
                System.out.println("Select again");
            }
        }
        
        // 正解のジャグ配列
        String[][][] answers = {
            {
                {"3: Flour", "3", "Flour", "flour", "Wheat Flour"},
                {"2: Japan", "2", "Japan", "japan", "Nihon", "Nippon"},
                {"2: United Kingdom", "2", "United Kingdom", "UK", "Britain"},
            },
            {
                {"2: Nile River", "2", "Nile River", "Nile"},
                {"3: Himalayas", "3", "Himalayas", "Himalaya Mountains"},
                {"3: Canberra", "3", "Canberra", "canberra"}
            }
        };

        // 選択肢
        String[][][] choices = {
            {
                {"1: Water", "2: Yeast", "3: Flour", "4: Salt"},
                {"1: China", "2: Japan", "3: Korea", "4: Vietnam"},
                {"1: Germany", "2: United Kingdom", "3: USA", "4: Italy"},
            },
            {
                {"1: Amazon River", "2: Nile River", "3: Yangtze River", "4: Mississippi River"},
                {"1: Andes", "2: Rockies", "3: Himalayas", "4: Alps"},
                {"1: Sydney", "2: Melbourne", "3: Canberra", "4: Brisbane"}
            }
        };

        // フィッシャーイェーツのシャッフル
        Random random = new Random();
        for (int i  = questions[userGenre].length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            // 質問をシャッフル
            String tempQuestion = questions[userGenre][i][0];
            questions[userGenre][i][0] = questions[userGenre][j][0];
            questions[userGenre][j][0] = tempQuestion;
            // 正解をシャッフル
            String[] tempAnswer = answers[userGenre][i];
            answers[userGenre][i] = answers[userGenre][j];
            answers[userGenre][j] = tempAnswer;
            String[] tempChoices = choices[userGenre][i];
            choices[userGenre][i] = choices[userGenre][j];
            choices[userGenre][j] = tempChoices;
        }

        int score = 0;

        // 不正解の質問と答えを入れる配列
        String[][] wrongQuestions = new String[questions[userGenre].length][2];
        int wrongCount = 0;

        // 問題の出力
        for (int i = 0; i < questions[userGenre].length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[userGenre][i][0]);
            // 選択肢の出力
            for (String choice : choices[userGenre][i]) {
                System.out.println(choice);
            }
            // 答えの入力を受け入れる
            System.out.print("Please enter your answer: ");
            String userAnswer = reader.readLine();

            boolean correct = false;
            for (String answer : answers[userGenre][i]) {
                if (userAnswer.equals(answer)) {
                    correct = true;
                    break;
                }
            }

            if (correct) {
                System.out.println("Correct!"); // 正解
                score++;
            } else {
                System.out.println("Incorrect."); // 不正解
                // 不正解だった質問と答えを配列に入れる
                wrongQuestions[wrongCount][0] = questions[userGenre][i][0];
                wrongQuestions[wrongCount][1] = answers[userGenre][i][0];
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
