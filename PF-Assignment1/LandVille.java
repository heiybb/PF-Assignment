import java.util.Scanner;

/**
 * Programming Fundamental Assignment 1
 *
 * @author ***
 * @date 2018/03/23
 */

public class LandVille {
    // add the variable 'hasHouse'
    private boolean hasHouse;
    private int[][] land;

    /**
     * A: constructor method (create and initialize land array, hasHouse variable)
     *
     * @param row land row
     * @param col land col
     */

    private LandVille(int row, int col) {
        land = new int[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                land[r][c] = 0;
            }
        }
        hasHouse = false;
    }

    private void displayLand() {
        for (int[] aLand : land) {
            for (int anALand : aLand) {
                System.out.print(anALand + " ");
            }
            System.out.print("\n");
        }
        // B: displayLand method
    }

    private void clearLand() {
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                // Only clean which is not 0
                if (land[i][j] != 0) {
                    land[i][j] = 0;
                }
            }
        }
        hasHouse = false;
    }

    private void buildHouse(int hrow, int hcol) {
        int minDiff = 2;
        if (hrow + minDiff > land.length || hcol + minDiff > land[0].length) {
            System.out.println("Error: row or column number of house is too large, check then enter again");
        } else {
            for (int i = 0; i < (hrow + minDiff); i++) {
                for (int j = 0; j < (hcol + minDiff); j++) {
                    if (i > 0 && i <= hrow && j > 0 && j <= hcol) {
                        land[i][j] = 8;
                    } else {
                        land[i][j] = 1;
                    }
                }
            }
            hasHouse = true;
            displayLand();
        }
        // F: buildHouse method. check the conditions on input, write code for house and
        // border. At the end of the buildHouse method, call displayLand method and
        // update 'hasHouse'
    }


    /**
     * Simplify the number input and judge
     * Input is required to be greater than min and less than or equal to max
     *
     * @param min      int num
     * @param max      int num
     * @param numInput scanner used for input
     */

    private static int numInput(int min, int max, Scanner numInput) {
        int num = 0;
        boolean numInputValid = false;
        while (!numInputValid) {
            String tmpNum = numInput.nextLine();
            try {
                num = Integer.parseInt(tmpNum);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid data type, enter again");
                numInputValid = false;
                // ignore the if-condition below to speed up the program
                continue;
            }
            if (num < min || num > max) {
                System.out.println("Error: Invalid number range, enter again");
                numInputValid = false;
            } else {
                numInputValid = true;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        // D: Input row and column number, check for valid input. Create an object of
        // LandVille class
        // Scanner object for input
        Scanner mainInput = new Scanner(System.in);

        System.out.println("Enter row number of land that greater than 0 and less than or equal to 10");
        int landRow = numInput(1, 10, mainInput);
        System.out.println("Enter column number of land that greater than 0 and less than or equal to 10");
        int landCol = numInput(1, 10, mainInput);

        LandVille newLand = new LandVille(landRow, landCol);

        while (true) {
            System.out.println("--- Enter 1-4 to select option ---");
            System.out.println("1.Build a house");
            System.out.println("2.Display land");
            System.out.println("3.Clear the land");
            System.out.println("4.Quit");
            System.out.println("--- -------------------------- ---");
            int option = numInput(1, 4, mainInput);

            if (option == 1) {
                if (newLand.hasHouse) {
                    System.out.println("Error: House already exist, clean land first then enter again");
                } else {
                    System.out.println("Enter row number of house that greater than 0 and less than or equal to 10");
                    int houseRow = numInput(1, landRow, mainInput);
                    System.out.println("Enter column number of house that greater than 0 and less than or equal to 10");
                    int houseCol = numInput(1, landCol, mainInput);
                    // Call buildHouse method
                    newLand.buildHouse(houseRow, houseCol);
                }
            } else if (option == 2) {
                newLand.displayLand();
            } else if (option == 3) {
                newLand.clearLand();
                newLand.displayLand();
            } else if (option == 4) {
                mainInput.close();
                System.exit(0);
            }
        }
        // E: Show menu. take the menu option as input. If the input is 1, take input
        // for house and call buildHouse method. Show the menu as long as user does not
        // select menu option 4.
    }
}
