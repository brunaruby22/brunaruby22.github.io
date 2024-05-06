class Painting {
    /*A painting tracks the following data:
     * a height
     * a width
     * a 'grid' of PaintingCells (a 'grid' is a 2D array -- an array where the type of variable in each 'slot' of the array is a sub-array.)*/

    private int height;
    private int width;
    private PaintingCell[][] grid;

    /*When a painting is constructed...
     * The painting is given its height and width as integers.
     * These integers are stored on attributes, then used to construct a grid that can hold [height] x [width] painting cells.
     * For each row number in this constructed grid:
             * For each column in that row:
                   - Save a newly created painting cell into that row and column of your grid.*/

    public Painting(int height, int width) {
        this.height = height;
        this.width = width;
        this.grid = new PaintingCell[height][width];

        for (int row = 0; row < height; row = row+1) {
            for (int column = 0; column < width; column = column +1) {
                grid[row][column] = new PaintingCell();
            }
        }
    }

    /*When a painting wants to check boundaries of a given row and column...
     * The painting receives the row and column the user wants to check.
     * If the row is between 0 and the painting's height and the column is between 0 and the painting's width, then the result of the check is true.
     * In any other case, the result of the check is false.*/

    public boolean checkBoundaries(int row, int column) {
        boolean rowBoundaries =(row >= 0) && (row < height);
        boolean columnBoundaries =(column >= 0) && (column < width);
        return rowBoundaries && columnBoundaries;
    }

    /*When a painting wants to paint a cell...
    * The painting receives the row, the column, and the color of the target cell.
    * If the row and column provided are inside the checked boundaries, then:
          - The painting retrieves the cell at that row and column from its grid, and changes the color of that cell appropriately, and then sets its visibility to true.
    * When the cell is successfully edited, painting a cell returns 'true'. Otherwise, it returns false.*/

    public boolean paintCell(int row, int column, String color) {
        if (checkBoundaries(row, column)) {
            if (grid[row][column].changeColor(color)) {
                grid[row][column].setVisibility(true); //this piece of code is what fixed it, thank you professor!
                return true;
            }
        }
        return false;
    }

    /*When a painting wants to erase a cell...
    * The painting receives the row, the column, and the color of the target cell.
    * If the row and column provided are inside the checked boundaries, then:
          - The painting retrieves the cell at that row and column from its grid, and sets the visibility of that cell appropriately.
    * When the cell is successfully edited, painting a cell returns 'true'. Otherwise, it returns false.*/    

    public boolean eraseCell(int row, int column) {
        if (checkBoundaries(row, column)) {
            grid[row][column].setVisibility(false); //this set visibility from paintingCell
            return true;
        }
        return false;
    }

    /*When a painting wants to convert itself to a String...
    * The painting creates a space to hold a string representation.
    * For each row of its grid:
          * For each column in that row:
                 - The painting converts the cell in that column and row of the grid into a string, and appends that to the representation.
          * NOTE: at the end of each row, you must append a newline character to the representation!
    * Once all rows and columns have been processed, the final painting is returned.*/

    @Override
    public String toString() {
        String representation = "";
        for (int row = 0; row < height; row = row+1) {
            for (int column = 0; column < width; column= column + 1) {
                representation = representation + grid[row][column].toString();
            }
            representation= representation + "\n";
        }
        return representation;
    }
}
