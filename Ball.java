
public class Ball {
	
	private int i,j;
	private int directionI, directionJ;
	
	
	public Ball() {
		i = 29;  //i-axis of the starting point of the ball 
		j = 39;	 //j-axis of the starting point of the ball
		directionI = 0;
		directionJ = 0;
	}
	//getDirectionI() method returns the i- direction of the ball
	public int getDirectionI() {
		return directionI;
	}
	//getDirectionJ() method returns the j- direction of the ball
	public int getDirectionJ() {
		return directionJ;
	}
	//getI() method returns the i-axis of the starting point of the ball
	public int getI() {
		return i;
	}
	//getJ() method returns the j-axis of the starting point of the ball
	public int getJ() {
		return j;
	}
	//setDirectionI(int directionX) method setting the direction of x to its directionI variable 
	public void setDirectionI(int directionX) {
		this.directionI = directionX;
	}
	//setDirectionJ(int directionY) method setting the direction of y to its directionJ variable
	public void setDirectionJ(int directionY) {
		this.directionJ = directionY;
	}
	//setI(int i) method assigning i of the point to our instance variable i 
	public void setI(int i) {
		this.i = i;
	}
	//setJ(int j) method assigning j of the point to our instance variable j
	public void setJ(int j) {
		this.j = j;
	}
	
	

}
