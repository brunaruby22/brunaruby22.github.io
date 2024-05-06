//I lilke to put the directions on the work as comments so that I make sure Im not missing anything.
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Painting painting = null;
        Scanner scanner = new Scanner(System.in);

        /*  * As long as the user has not provided a valid path to a painting:
       * Main will ask the user for the path to a painting file.
       * It will then use PaintingLoader's ability to generate a painting from that file, and store the resulting painting (or null if the path was invalid).
   * Once a valid painting has been loaded, main will convert that painting to a string and print it out.*/

        while (painting == null) {
            System.out.print("Please, enter the path to a painting file (.pnt): ");
            String filepath = scanner.nextLine();
            painting = PaintingLoader.generatePainting(filepath);
            if (painting == null) {
                System.out.println("This file path in invalid. Please, try again.");
            }
        }

        System.out.println(painting.toString());
    }
}