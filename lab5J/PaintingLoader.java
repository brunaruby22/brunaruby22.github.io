import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

class PaintingLoader {
    private PaintingLoader(/*zero argument parameter*/) {
    }

    /* PaintingLoader will have one private static helper function: the ability to convert a letter to color:
       * Converting a letter to a color starts with a given letter.
       * The colors available to a painting are red - "R", yellow - "Y", green -"G" , cyan - "C", blue - "B", purple - "P", black - "X", and white - "O". 
       * If the painting method receives one of these letters, then it returns the corresponding color.*/

    private static String convertLetterToColor(String letter) {
        if ("R".equals(letter)) {
            return "red";
        } else if ("Y".equals(letter)) {
            return "yellow";
        } else if ("G".equals(letter)) {
            return "green";
        } else if ("C".equals(letter)) {
            return "cyan";
        } else if ("B".equals(letter)) {
            return "blue";
        } else if ("P".equals(letter)) {
            return "purple";
        } else if ("X".equals(letter)) {
            return "black";
        } else if ("O".equals(letter)) {
            return "white";
        } else {
            return "black";
        }
    }

    /*PaintingLoader will have a public static method: the ability to generate a painting from a File...
         * When this method is called, it will be provided with one parameter: a string filepath.*/

    public static Painting generatePainting(String filepath) throws FileNotFoundException {

    /* * This filepath will be used to construct and store a File object representing the file holding that information.*/
        File file = new File(filepath);

        /* * If the File created exists and its path ends with ".pnt":
            * PaintingLoader will create a space to track a number of rows, a number of columns, and a group of Strings representing each row of the painting.
                 - NOTE: you can assume a painting will never have more than 25 rows, and that every column has the same number of symbols.*/
        if (!file.exists() || !filepath.endsWith(".pnt")) {
            return null;
        }

        int height = 0;
        int width = 0;
        String[] rows = new String[25];

            /** PaintingLoader will then make a Scanner that can read the file.*/
        Scanner scan = new Scanner(file);

            /** As long as the scanner still has a next line:
               * That next line will be appended to the group of painting rows.
               * The number of columns will be set to the length of that line.
               * The number of rows will be incremented by one.*/

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            rows[height] = line;
            width = line.length();
            height = height+1;
        }

        /* * Once the file has finished being read, the loader will construct a new painting object with the appropriate height and width.
           * Afterward, for each row number in the painting:
                  * The loader will retrieve the string representing that row of the painting, and split that row into a group of letters (using .split("") with an empty string splits on every letter.)
                  * For each column in that group of letters:
                         * The loader will convert the letter in that cell into a color.
                         * Afterward, the loader will tell its painting to paint the cell in that row and column the appropriate color.
          * Once the entire painting has been painting, the loader will return the finished painting.
        * If an invalid path was provided, the method will return null.*/

        Painting painting = new Painting(height, width);
        for (int row = 0; row < height; row = row+1) {
            String[] symbols = rows[row].split("");
            for (int column = 0; column < width; column = column+1) {
                String color = convertLetterToColor(symbols[column]);
                painting.paintCell(row, column, color);
            }
        }

        return painting;
    }

}