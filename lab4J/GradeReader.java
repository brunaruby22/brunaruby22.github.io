import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class GradeReader {

    /*A grade reader tracks the following data:
             * A File object representing the location the grade reader should read from*/
    private File aFile;

    /*When a grade reader is constructed:
            - The grade reader will receive a file name as text, and store a newly created file object representing that file.*/
    public GradeReader(String fileName) {
        this.aFile = new File(fileName);
    }
    /*When a user wants to load a file:
            - Grade reader will construct a Scanner that can read from its stored file.
            - The first line of the file will be read into the program and stored in a string.
            - That first line will be split into a group of Strings based on its commas, and those values will be used to construct a new Transcript.
            - For as long as the scanner still has a next line:
                  - Grade reader will read the next line of the file.
                  - Afterward, it will split that line on commas, and...
                       - If the assignment type of this line is a lab, transcript will record a lab with the relevant details.
                       - Otherwise, if the assignment type of this line is an exam, transcript will record an exam with the relevant details.
            - Once all assignments have been read, grade reader will return the created Transcript.
                   + Note: This function needs to acknowledge the possibility of an exception when the File is Not Found.*/

    public Transcript loadTheFile() throws FileNotFoundException{   
        Scanner read = new Scanner(aFile);

        String firstLine = read.nextLine();
        String[] details = firstLine.split(",");

        String course_name = details[0];
        String student_name = details[1];
        int year = Integer.parseInt(details[2]);
        String semester = details[3];

        Transcript yourTranscript= new Transcript (course_name, student_name, year, semester);

        while (read.hasNextLine()) {
            String nextLine = read.nextLine();
            String[] grades = nextLine.split(",");

            String assignmentType = grades[0];
     
            double pointsEarned = Double.parseDouble(grades[1]);
            double pointsPossible = Double.parseDouble(grades[2]);

            if (assignmentType.equals("Lab")){
                yourTranscript.recordLab(pointsEarned);
            } else if (assignmentType.equals("Exam")){
                yourTranscript.recordExam(pointsEarned);
            }
        }
         return yourTranscript;   
    }
}