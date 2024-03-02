package question3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArraySum {
    public static void main(String[] args) throws IOException {
        // BufferedReaderの準備
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        /*
         * 保存する配列の準備
         * 数字の入力
         * 格納された配列の出力
         * 配列内の合計点の出力
         */

        int count = 0;
        int[] numbers = new int[5];
        int totalScore = 0;

        while (count < 5) {
            count++;
            System.out.println("Enter number " + count +": ");
            int number = Integer.parseInt(reader.readLine());
            totalScore += number;
            int index = count - 1;
            numbers[index] = number;
        }

        System.out.print("You entered: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        System.out.println();
        System.out.println("Total: " + totalScore);
    }
}
