import java.util.Random;
import java.util.Scanner;

public class BattleShipGame {
    private static final int GRID_SIZE = 12;
    private static final int NUMBER_OF_SHIPS = 5;
    private final int[][] ships = new int[GRID_SIZE][GRID_SIZE];
    private final int[][] shots = new int[GRID_SIZE][GRID_SIZE];
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BattleShipGame game = new BattleShipGame();
        game.PlayGame();
    }

    private void PlayGame() {
        initializeShips();
        System.out.println("Welcome to Battle Ship Game!");
        int hitedShips = 0;

        while (hitedShips < NUMBER_OF_SHIPS) {
            int[] coordinates = getUserCoordinates();
            int shotX = coordinates[0];
            int shotY = coordinates[1];

            if (isInvalidCoordinate(shotX, shotY)) {
                System.out.println("Invalid Coordinate, Please Enter Valid Coordinates!");
                continue;
            }

            if (ships[shotX][shotY] == 1) {
                System.out.println("Congratulations, you hit a ship!");
                ships[shotX][shotY] = 0;
                shots[shotX][shotY] = 1;
                hitedShips++;
            } else if (shots[shotX][shotY] == 1) {
                System.out.println("You have already tried this coordinate, please try another.");
            } else {
                System.out.println("The shot did not hit.");
                shots[shotX][shotY] = 1;
            }
        }

        System.out.println("You won the game, destroyed all ships!");
        scanner.close();
    }

    private void initializeShips() {
        int placedShips = 0;
        while (placedShips < NUMBER_OF_SHIPS) {
            int shipX = random.nextInt(GRID_SIZE);
            int shipY = random.nextInt(GRID_SIZE);
            if (ships[shipX][shipY] == 0) {
                ships[shipX][shipY] = 1;
                placedShips++;
            }
        }
    }

    private int[] getUserCoordinates() {
        System.out.println("Enter coordinate 'X' for shot:");
        int x = scanner.nextInt();
        System.out.println("Enter coordinate 'Y' for shot:");
        int y = scanner.nextInt();
        return new int[]{x, y};
    }

    private boolean isInvalidCoordinate(int x, int y) {
        return x < 0 || x >= GRID_SIZE || y < 0 || y >= GRID_SIZE;
    }
}
