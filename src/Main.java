import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte[][] board = new byte[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
            }
        }
        frontEnd(board);
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            int move = scanner.nextInt();
            byte cell = (byte) ((i % 2 == 0) ? 1 : 2);
            if (move >= 1 && move <= 9) {
                int row = (move - 1) / 3;
                int col = (move - 1) % 3;
                if (board[row][col] == 0) {
                    board[row][col] = cell;
                } else {
                    System.out.println("Movimiento invalido, la casilla ya esta ocupada.");
                    i--;
                }
            } else {
                System.out.println("Movimiento invalido, ingrese un numero del 1 al 9.");
                i--;
            }
            frontEnd(board);
            if (checkWin(board)) {
                break;
            }
            if (i == 8){
                System.out.println("Es un empate");
            }
        }
    }
    public static void frontEnd(byte[][] board){
        System.out.println(convertBoard(board[0][0]) + " | " + convertBoard(board[0][1]) + " | " + convertBoard(board[0][2]));
        System.out.println("──┼───┼──");
        System.out.println(convertBoard(board[1][0]) + " | " + convertBoard(board[1][1]) + " | " + convertBoard(board[1][2]));
        System.out.println("──┼───┼──");
        System.out.println(convertBoard(board[2][0]) + " | " + convertBoard(board[2][1]) + " | " + convertBoard(board[2][2]));
    }
    public static boolean checkWin(byte[][] board) {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                if (board[row][0] == 1) {
                    System.out.println("Gano el jugador O!");
                    return true;
                } else if (board[row][0] == 2) {
                    System.out.println("Gano el jugador X!");
                    return true;
                }
            }
        }
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                if (board[0][col] == 1) {
                    System.out.println("Gano el jugador O!");
                    return true;
                } else if (board[0][col] == 2) {
                    System.out.println("Gano el jugador X!");
                    return true;
                }
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] ||
                board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[1][1] == 1) {
                System.out.println("Gano el jugador O!");
                return true;
            } else if (board[1][1] == 2) {
                System.out.println("Gano el jugador X!");
                return true;
            }
        }
        return false;
    }
    public static char convertBoard(byte Byte){
        char Char = ' ';
        switch (Byte){
            case 1 -> Char = 'O';
            case 2 -> Char = 'X';
        }
        return Char;
    }
}