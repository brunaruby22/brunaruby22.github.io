class Assignment{

	/*An assignment tracks the following data:
             * A number of points earned.
             * A number of points possible.
             * Text representing an assignment category */

    private double points_earned;
	private double points_possible;
	private String assignment_category;

	/*When an assignment is constructed:
            - The assignment object receives values for each of its three pieces of information and saves them to its attributes. */


    public Assignment(double pointsEarned, double pointsPossible, String assignmentCategory){

		this.points_earned = pointsEarned;
		this.points_possible = pointsPossible;
		this.assignment_category = assignmentCategory;

	}

	/*Someone using an Assignment object should be able to get (but NOT set) the number of points earned, points possible, and category from an Assignment. */

	public double getPointsEarned() {
		return points_earned;
	}

	public double getPointsPossible() {
		return points_possible;
	}

	public String getAssignmentCategory() {
		return assignment_category;
	}
}