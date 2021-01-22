package ivan;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {

    public static boolean checkInput(int rows, int cols) {
        if (rows > 100 || cols > 100 ||
                cols % 2 != 0 || rows % 2 != 0) {
            System.out.println("wrong dimenstions");
            return false;
        }
        return true;
    }

    public static boolean threeOfAKind(Cell[][] matrix, Scanner scanner) {
        Map<Integer, Integer> validator = new HashMap<>();
        if (checkInput(matrix[0].length, matrix.length)) {
            for (int i = 0; i < matrix.length ; i++) {
                int[]  = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                // celiqt red go slagame v matricata
//                for (int j = 0; j < matrix[0].length - 1; j++) {
//                    matrix[i][j] = line[j];
//                }
                //minavame prez reda i zpisvame kolko pyti se sreshta vsqka cifra
                //po uslovie ne moje da byde poveche ot dva pyti
                for (int currNum : matrix[i]) {
                    if (!validator.containsKey(currNum)) {
                        validator.put(currNum, 1);
                    } else if (validator.get(currNum) == 2) {
                            System.out.println("three of a kind");
                            return true;
                    } else {
                        validator.put(currNum, 2);
                    }
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        //map koito shte sledi che nqma cifri koito da se sreshtat 3 pyti
        //boolean za tri ednakvi cifri
//        boolean threeOfOneKind = false;
        //boolean za cheten broi redove i koloni
//        boolean evenRowsAndCols = true;
        //vyvejdane na razmerite na matricata
        int[] dimensions = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(dimensions[0]);
        int matrixRows = dimensions[0];
        int matrixCols = dimensions[1];
        Cell[][] matrix = new Cell[matrixRows][matrixCols];

        //po uslovie - max 100 rreda i koloni, kakto i da sa cheten broi




        if (!threeOfAKind(matrix, scanner)) {
            for (int row = 0; row < matrix.length; row += 2) {
                for (int col = 0; col < matrix[0].length;  col += 4) {
                    //Variant A:
                    //1 1 2 2
                    //3 3 4 4
                    if ((matrix[row][col] != matrix[row + 1][col] &&
                            matrix[row][col + 2] != matrix[row + 1][col + 2])) {
                        int first = matrix[row][col];
                        int second = matrix[row][col + 2];
                        int third = matrix[row + 1][col];
                        int forth = matrix[row + 1][col + 2];
                        matrix[row][col] = second;
                        matrix[row + 1][col] = second;
                        matrix[row][col + 1] = first;
                        matrix[row + 1][col + 1] = third;
                        matrix[row][col + 2] = first;
                        matrix[row + 1][col + 2] = third;
                        matrix[row][col + 3] = forth;
                        matrix[row + 1][col + 3] = forth;
                        //Variant B:
                        //2 1 1 4
                        //2 3 3 4
                    } else if ((matrix[row][col] == matrix[row + 1][col] &&
                            matrix[row][col + 2] != matrix[row + 1][col + 2])) {
                        int first = matrix[row][col + 1];
                        int second = matrix[row][col];
                        int third = matrix[row + 1][col + 1];
                        int forth = matrix[row + 1][col + 3];
                        matrix[row][col] = first;
                        matrix[row + 1][col] = third;
                        matrix[row][col + 1] = first;
                        matrix[row + 1][col + 1] = third;
                        matrix[row][col + 2] = second;
                        matrix[row + 1][col + 2] = forth;
                        matrix[row][col + 3] = second;
                        matrix[row + 1][col + 3] = forth;
                        //Variant C:
                        //9   9   3  4   4   8  8  14
                        //11  11  3  13  13  6  6  14
                        //podredbata e po moe usmotrenie, predvid uslovieto na zadachata
                    } else {
                        int first = matrix[row][col]; // 9
                        int second = matrix[row + 1][col]; // 11
                        int third = matrix[row][col + 2]; //3
                        int forth = matrix[row][col + 3]; //4
                        int fifth = matrix[row + 1][col + 3]; // 13
                        int sixth = matrix[row][col + 5]; // 8
                        int seventh = matrix[row + 1][col + 5]; // 6
                        int eight = matrix[row + 1][col + 7]; // 14
                        matrix[row][col] = eight;
                        matrix[row + 1][col] = third;
                        matrix[row][col + 1] = eight;
                        matrix[row + 1][col + 1] = third;
                        matrix[row][col + 2] = first;
                        matrix[row + 1][col + 2] = second;
                        matrix[row][col + 3] = first;
                        matrix[row + 1][col + 3] = second;
                        matrix[row][col + 4] = fifth;
                        matrix[row + 1][col + 4] = sixth;
                        matrix[row][col + 5] = fifth;
                        matrix[row + 1][col + 5] = sixth;
                        matrix[row][col + 6] = seventh;
                        matrix[row + 1][col + 6] = forth;
                        matrix[row][col + 7] = seventh;
                        matrix[row + 1][col + 7] = forth;
                        col += 4;
                    }
                }
            }
            printMatrix(matrix);
        } else {
            System.out.println("-1\nNo solution exists");
        }
    }








    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(ints[col] + " ");
            }
            System.out.println();
        }
    }
}
