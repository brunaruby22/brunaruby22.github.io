import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Main
We are also going to tweak our main method once again. In this new version of main:*/

public class GradeCalculator {
    public static void main(String[] args) throws FileNotFoundException{
        /* - When main begins, it constructs a Scanner that can read from the terminal (the 'standard input'.)*/

        Scanner input = new Scanner(System.in);//input
        String fileInput = "";

        /*  - While the stored user command isn't "quit":
                  - Main prompts the user to enter a filename.
                  - It then receives the next line of text the user types, and saves it as the user command....:
                      - If the text the user entered was "quit", then the program
                      - Otherwise, main constructs a file object from the user's entered file path, and...
                            + If that file does not exist, it prints an error message.
                            + Otherwise, if that file does exist, main constructs a grade reader object for that file.
                                  - That grade reader object will then load its file and store it into a variable.
                                  - Aftward, the details of the Transcript will be printed along with the student's final grade.*/

        while (!fileInput.equals("quit")) {
            System.out.print("Enter a filename or enter 'quit' to exit: ");
            fileInput = input.nextLine();

            if (!fileInput.equals("quit")) {
                File file = new File(fileInput);

                if (!file.exists()) {
                    System.out.println("I'm sorry. This file does not seem to exist.");
                } else {
                    GradeReader gradeReader = new GradeReader(fileInput);
                    Transcript yourTranscript = gradeReader.loadTheFile();

                    if (yourTranscript != null) {
                        System.out.println(yourTranscript.toString());
                    }
                }
            }
        }
    }
}
