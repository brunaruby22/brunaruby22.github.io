class Transcript{

	/* A transcript tracks the following data:
             * A course name.
             * A student name.
             * A year the course was taken.
             * A semester the course was taken (either "Spring" or "Fall").
             * A group of Assignment objects
             * A number of assignments recorded */

	private String course_name;
	private String student_name;
	private int year;
	private String semester;
	private Assignment[] assignments;
	private int num_of_assignments_recorded;

    /* When a transcript is constructed:
            - The transcript will receive a course name, student name, year, and semester as function parameters.
            - These parameters will be saved into the proper attributes of the transcript.
            - Transcript will then save itself an empty group of Assignments that can hold up to twenty assignments.
            - Transcript's "number of assignments recorded" will be set to appropriately represent the empty group. */

	public Transcript(String course_name, String student_name, int year, String semester){

		this.course_name = course_name;
		this.student_name = student_name;
		this.year = year;
		this.semester = semester;
		this.assignments = new Assignment[20];  /* up to 20 assignments */
		this.num_of_assignments_recorded = 0;
	}

	/* When a user wants to record a lab:
            - The transcript will receive the number of points scored on the lab.
            - Transcript will then construct a new assignment using that received score, worth 50 possible points and having the category "lab".
            - This assignment will get stored in the first empty slot of the transcript's group of recorded assignments.
                      + Note: the "number of assignments recorded" can help you find the first empty slot!
            - Transcript's number of assignments recorded will increment by one to describe the new 'first empty slot'. */

	public void recordLab(double points_earned){
		if (num_of_assignments_recorded < assignments.length){
		Assignment lab = new Assignment(points_earned, 50, "lab");
		assignments[num_of_assignments_recorded] = lab;
		num_of_assignments_recorded = num_of_assignments_recorded + 1;}
	}

	/* When a user wants to record an exam:
            - The transcript will receive the number of points scored on the exam.
            - Transcript will follow the same rules as for a lab, except exams are worth 100 possible points and having the category "exam".
                      + Note: this might be an indication that a private helper method could reduce code duplication! */

	public void recordExam(double points_earned){
		if (num_of_assignments_recorded < assignments.length){
		Assignment exam = new Assignment(points_earned, 100, "exam");
		assignments[num_of_assignments_recorded] = exam;
		num_of_assignments_recorded = num_of_assignments_recorded + 1;}
	}

	/* When a user wants to calculate the course grade:
           - The transcript needs no additional information.
           - Transcript will create four variables to separately store the total received and possible points on labs and exams, respectively.
           - For each assignment transcript has recorded:
                   - If the assignment is a "lab", then add the possible and received points to the possible and received lab totals.
                   - Otherwise if the assignment is an "exam", add the possible and received points to the possible and received exam totals.
                   - If no assignment was saved to this 'slot' do nothing!
                               + Note: you should think about what order these different 'branches' of behavior need to be checked in!
          - Once all assignments have been totalled, calculate the weighted average (labs are worth 60% of the grade, exams are worth a combined 40%.)
          - Calculating the course grade returns a summative course grade as a decimal value. */

	public double calculateCourseGrade(/*no additional info*/) {
        double sum_points_earned_lab = 0.0;
        double sum_points_possible_lab = 0.0;
        double sum_points_earned_exam = 0.0;
        double sum_points_possible_exam = 0.0;

        for (int recorded_assignment = 0; recorded_assignment < num_of_assignments_recorded; recorded_assignment = recorded_assignment + 1 ) {
            Assignment assignment = assignments[recorded_assignment];
            if (assignment.getAssignmentCategory().equals("lab")) {
                sum_points_earned_lab = sum_points_earned_lab + assignment.getPointsEarned();
                sum_points_possible_lab = sum_points_possible_lab + assignment.getPointsPossible();
            } else if (assignment.getAssignmentCategory().equals("exam")) {
                sum_points_earned_exam = sum_points_earned_exam + assignment.getPointsEarned();
                sum_points_possible_exam = sum_points_possible_exam + assignment.getPointsPossible();
            }
        }


        double lab_average = (sum_points_earned_lab/sum_points_possible_lab);
        double exam_average = (sum_points_earned_exam/sum_points_possible_exam);
        double total_course_grade = (lab_average*60) + (exam_average*40);

        return total_course_grade;
    }
    
    /* Transcript should have a private helper method that can convert a numeric grade to a letter:
          - Given a numeric grade:
                if the grade is above...                         ...the user receives:
                                         93.5                                    A
                                         90.0                                    A-
                                         87.0                                    B+
                        ...and so on */

    private String convert_to_letter_grade(double numeric_grade){

    	if (numeric_grade >= 93.5){
    		return "A";
    	} else if (numeric_grade >= 90.0){
    		return "A-";
    	} else if (numeric_grade >= 87.0){
    		return "B+";
    	} else if (numeric_grade >= 83.0){
    		return "B";
    	} else if (numeric_grade >= 80.0){
    		return "B-";
    	} else if (numeric_grade >= 77.0){
    		return "C+";
    	} else if (numeric_grade >= 73.0){
    		return "C";
    	} else if (numeric_grade >= 70.0){
    		return "C-";
    	} else if (numeric_grade >= 67.0){
    		return "D+";
    	} else if (numeric_grade >= 63.0){
    		return "D";
    	} else{
    		return "F";
    	} 
    }
    
    /* When a user wants to convert a transcript to a String:
         - Transcript overrides the toString() function with its standard signature.
         - It then saves a string that holds information about the transcript's course, the related student, the received grades, and the final average.
         - Also display the letter grade for the course after the course average (e.g "93.6 (A)" ).
         - This textual representation of the Transcript is returned at the end of the method ( not immediately printed here.) */

    @Override
    public String toString() {
    	double total_course_grade = calculateCourseGrade();
    	String letter_grade = convert_to_letter_grade(total_course_grade);
    	String text = "\nTranscript for the class of " + this.semester + " " + this.course_name + ", " + this.year + ". For student - " + this.student_name + ": \n" +
                "_______________________________________________________________________ \n" +
                "Total number of Assignments: " + num_of_assignments_recorded + " \n" +

                "\nTotal Course Grade: " + total_course_grade + " (" + letter_grade + ")" + "\n";

        return text;
    }   
}