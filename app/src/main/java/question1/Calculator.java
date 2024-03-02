package question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) throws IOException {
        // BufferedReaderの準備
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        /*
         * 1つ目の整数の入力
         * 2つ目の整数の入力
         * 演算子の選択
         * 計算結果の表示
         */

         System.out.println("Enter first number: ");
         int num1 = Integer.parseInt(reader.readLine());

         System.out.println("Enter scond number: ");
         int num2 = Integer.parseInt(reader.readLine());

         System.out.println("Chose operation (+ or -): ");
         String operation = reader.readLine();

         switch (operation) {
            case "+":
                System.out.println("Result: " + (num1 + num2));
                break;
            
            case "-":
                System.out.println("Result: " + (num1 - num2));

            default:
                System.out.println("Error: Invalid operation");
                break;
         }
    }
}
