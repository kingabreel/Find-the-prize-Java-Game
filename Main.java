import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Start menu for the game
        int userChoose;
        System.out.println("Welcome to the game");
        System.out.println("Which difficulty you want to play:\n1- Easy\n2- Normal\n3- Hard ");
        Scanner scanner = new Scanner(System.in);

        userChoose = scanner.nextInt();
        Game(userChoose);


    }
    static void Game(int Difficuty){
        //Defining an array
        String [][] Matrix;

        int matrixLeng = 0;
        if (Difficuty == 1){
            matrixLeng += 4;
        } else if (Difficuty == 2) {
            matrixLeng += 6;
        } else if (Difficuty == 3) {
            matrixLeng += 8;
        } else {
            System.out.println("Invalid difficulty");
        }

        //Creating the array
        Matrix = new String[matrixLeng][matrixLeng];
        for (int i = 0; i < Matrix.length; i++){
            for(int j = 0; j < Matrix.length; j++) {
                Matrix[i][j] = " * ";
            }
        }

        //Here the game starts
        System.out.println("Generating matrix\n");
        System.out.println(Arrays.deepToString(Matrix).replace("],","\n").replace("[", " ").replace("]]",
                " ").replace(",", "|"));


        //This part select a random place to the objective be
        Random random = new Random();
        int row = random.nextInt(matrixLeng);
        int column = random.nextInt(matrixLeng);

        //Some game configs
        boolean gameOn = true;
        int count = 1;


        do {
            System.out.println("");
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please select a row to try");
            int userRow = scanner.nextInt();
            System.out.println("Now select a column");
            int userColumns = scanner.nextInt();

            Matrix[row][column] = " P ";;

            if (Matrix[Matrix.length - userRow][userColumns - 1] == " P "){

                System.out.println("Congratulation, you won the game!!!\nYou won with " + count + " attempts");
                System.out.println(Arrays.deepToString(Matrix).replace("],","\n").replace("[", " ").replace("]]",
                        " ").replace(",", "|"));
                gameOn = false;

            } else {
                Matrix[row][column] = " * ";
                Matrix[Matrix.length - userRow][userColumns - 1] = " # ";
                System.out.println(Arrays.deepToString(Matrix).replace("],","\n").replace("[", " ").replace("]]",
                        " ").replace(",", "|"));
                count += 1;
            }
        } while (gameOn == true);
    }
}