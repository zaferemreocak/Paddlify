
public class Map {
	
	static Ball ball = new Ball();
	
	char[][] coordMap = new char[32][64];
	int i,j = 0;
	
	//To implement RED BONUS 
	int contactedBall;
	int round=0;
	//int check=0;
	

	//To implement the ball movement
	void update(int pCoord){
		
		int plength=0;int jIndex = 0;int j1=j;
		
		//To find the starting point of paddle
		for(j1=0;j1<=63;j1++){
				if(coordMap[30][j1]  == '='){
					jIndex=j1;
					break;
				}
			}
		//Map bounds have been initialized
		if(jIndex==1 || jIndex==39){
				if(jIndex==1 && pCoord==-1)
					pCoord=0;
				else if(jIndex==1  && pCoord==1)
					pCoord=1;
				else if(jIndex==39 && pCoord==1)
					pCoord=0;
				else if(jIndex==39 && pCoord==-1)
					pCoord=-1;
			}
			
			//New starting point of the paddle
		if(pCoord==1 && (jIndex != 1 || jIndex != 39))
			coordMap[30][jIndex] = ' ';
		if(pCoord==-1 && (jIndex != 1 || jIndex != 39))
			coordMap[30][jIndex+23] = ' ';
			
		jIndex=jIndex+pCoord;
		plength=jIndex+23;
		for(int x=jIndex;x<=plength;x++){
			coordMap[30][x]='=';
			}
			j1=0;
			System.out.println(contactedBall + round);
		//RED BRICK BONUS CHECK
		if(contactedBall == 1 && round >=30){
			contactedBall = 0;
		}
		if(contactedBall == 1 && round <= 29){//***************************************
			coordMap[ball.getI()][ball.getJ()] = ' ';
			ball.setI(ball.getDirectionI()+ball.getI());
			ball.setJ(ball.getDirectionJ()+ball.getJ());
			calculateBall(pCoord);
			printBall(ball);
			System.out.println(round);
			round = round + 1;
		}
		
		if(contactedBall == 0){
			coordMap[ball.getI()][ball.getJ()] = ' ';
			ball.setI(ball.getDirectionI()+ball.getI());
			ball.setJ(ball.getDirectionJ()+ball.getJ());
			calculateBall(pCoord);
			printBall(ball);
				
			coordMap[ball.getI()][ball.getJ()] = ' ';
			ball.setI(ball.getDirectionI()+ball.getI());
			ball.setJ(ball.getDirectionJ()+ball.getJ());
			calculateBall(pCoord);
			printBall(ball);

		}
		
		//PRINT OUT
		for(i=0;i<=31;i++){
			for(j1=0;j1<=63;j1++){
				System.out.print(coordMap[i][j1]);
			}
			System.out.print("\n");
		}
	}
	//DRAW THE MAP AND THE PADDLE FOR THE FIRST TIME
	void drawMap(){
		
		int j2=j;
		for(i=0;i<=31;i++){
				//Upper and Lower Bounds
				if( i == 0 || i == 31 ){
					for(j2=0;j2<=63;j2++){
						coordMap[i][j2]='*';
					}
					j2=0;
				}	
				else{
					//Left and Right Bounds
					for(j2=0;j2<=63;j2++){
						if((j2 == 0 || j2 == 63)){
							coordMap[i][j2]='|';
						}
						//To move the paddle
						else{
							coordMap[i][j2]= ' ';
						}
					}
					j2=0;
				}
		}
		
		for(j2=22;j2<=45;j2++){
			coordMap[30][j2] = '=';
		}
		printBall(ball);
		Brick brick = new Brick();
		brick.drawBrick(coordMap);
		
		
		//PRINT OUT
		for(i=0;i<=31;i++){
			for(j2=0;j2<=63;j2++){
				System.out.print(coordMap[i][j2]);
			}
			System.out.print("\n");
		}
		j2=0;
		
	}
	
	//getBall(Ball ballValue) method drawing the ball on the map
	void printBall(Ball ballValue){
		coordMap[ballValue.getI()][ballValue.getJ()] = 'O';
	}
	
	//Collision Calculation
	void calculateBall(int pCoord) {
		int directionI=ball.getDirectionI();
		int directionJ=ball.getDirectionJ();
		//Check ball whether the game will continue or not depends on the condition
		if(ball.getI() == 29){
			//Bounces from paddle 
			if((ball.getDirectionI() == 1) && coordMap[30][ball.getJ()+ball.getDirectionJ()] == '='){
				if(ball.getDirectionJ() == 0 && pCoord == 4){
					ball.setDirectionI(-1);
					ball.setDirectionJ(1);
				}
				else if(ball.getDirectionJ() == 0 && pCoord == 6){
					ball.setDirectionI(-1);
					ball.setDirectionJ(-1);
				}
				else{
					ball.setDirectionI(-1);
				}
				
			}
			//Game Over
			else if((ball.getDirectionI() == 1) && (coordMap[30][ball.getJ()+ball.getDirectionJ()] != '=')){
				coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] = 'O';
				for(i=0;i<=31;i++){
					for(j=0;j<=63;j++){
						System.out.print(coordMap[i][j]);
					}
					System.out.print("\n");
				}
				System.out.println("GAME OVER!");
				System.exit(0);
			}
			else{
				ball.setDirectionI(-1);
			}
		}
		//Ball bounces off from walls
		if(ball.getI() == 1){
			ball.setDirectionI(1);
		}
		if(ball.getJ() == 2){
			ball.setDirectionJ(1);
		}
		if(ball.getJ() == 62){
			ball.setDirectionJ(-1);
		}
		//The Brick Collision Check
		if((ball.getI() != 29) && (ball.getI() != 1) && (ball.getJ() != 2) && (ball.getJ() != 62)){
			if(		(coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] == 'B') || 
					(coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] == 'R') ||
					(coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] == 'G') ||
					(coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] == 'Y')		){
				
				
				//Red Brick Bonus
				if((round > 29) && coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] != 'R'){
					contactedBall = 0;
				}
				if((round > 29) && coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] == 'R'){
					contactedBall = 1;
					round = 0;
					//check = 1;
				}
				if((round <= 29) && coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] == 'R'){
					contactedBall = 1;
					round = 0;
					//check = 1;
				}
				if((round <= 29) && coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] != 'R'){
					contactedBall = 1;
				}
				
				//Change direction of the ball after collision
				if(directionI == 1 && directionJ == 1){
					//00
					if(coordMap[ball.getI()+ball.getDirectionI()-1][ball.getJ()+ball.getDirectionJ()] == ' ' &&
							coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()-1] == ' '){
						coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] = ' ';
						ball.setDirectionI(-1);
						
					}
					//10
					else if(coordMap[ball.getI()+ball.getDirectionI()-1][ball.getJ()+ball.getDirectionJ()] != ' ' &&
							coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()-1] == ' '){
						coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] = ' ';
						ball.setDirectionJ(-1);
						/*if(ball.getI() != 4 && ball.getJ() != 3 && ball.getJ() != 60)
							ball.setI(ball.getDirectionI()+2);
						*/
					}
					//01
					else if(coordMap[ball.getI()+ball.getDirectionI()-1][ball.getJ()+ball.getDirectionJ()] == ' ' &&
							coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()-1] != ' '){
						coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] = ' ';
						ball.setDirectionI(-1);
						/*if(ball.getI() != 4 && ball.getJ() != 3 && ball.getJ() != 60)
							ball.setI(ball.getDirectionJ()+2);
						*/
					}
					//11
					else if(coordMap[ball.getI()+ball.getDirectionI()-1][ball.getJ()+ball.getDirectionJ()] != ' ' &&
							coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()-1] != ' '){
						coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] = ' ';
						ball.setDirectionI(-1);
						ball.setDirectionJ(-1);
						
					}
					
				}
					
				if(directionI == -1 && directionJ == 1){
					//00
					if(coordMap[ball.getI()+ball.getDirectionI()+1][ball.getJ()+ball.getDirectionJ()] == ' ' &&
							coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()-1] == ' '){
						coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] = ' ';
						ball.setDirectionI(1);
						
					}
					//10
					else if(coordMap[ball.getI()+ball.getDirectionI()+1][ball.getJ()+ball.getDirectionJ()] != ' ' &&
							coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()-1] == ' '){
						coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] = ' ';
						ball.setDirectionJ(-1);
						/*if(ball.getI() != 4 && ball.getJ() != 3 && ball.getJ() != 60)
							ball.setI(ball.getDirectionI()-2);
						*/
					}
					//01
					else if(coordMap[ball.getI()+ball.getDirectionI()+1][ball.getJ()+ball.getDirectionJ()] == ' ' &&
							coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()-1] != ' '){
						coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] = ' ';
						ball.setDirectionI(1);
						/*if(ball.getI() != 4 && ball.getJ() != 3 && ball.getJ() != 60)
							ball.setI(ball.getDirectionJ()+2);
						*/
					}
					//11
					else if(coordMap[ball.getI()+ball.getDirectionI()+1][ball.getJ()+ball.getDirectionJ()] != ' ' &&
							coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()-1] != ' '){
						coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] = ' ';
						ball.setDirectionI(1);
						ball.setDirectionJ(-1);
						
					}
					
					//ball.setDirectionJ(-1);
				}
					
				if(directionI == 1 && directionJ == -1){
					//00
					if(coordMap[ball.getI()+ball.getDirectionI()-1][ball.getJ()+ball.getDirectionJ()] == ' ' &&
							coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()+1] == ' '){
						coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] = ' ';
						ball.setDirectionI(-1);
						
					}
					//10
					else if(coordMap[ball.getI()+ball.getDirectionI()-1][ball.getJ()+ball.getDirectionJ()] != ' ' &&
							coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()+1] == ' '){
						coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] = ' ';
						ball.setDirectionJ(1);
						/*if(ball.getI() != 4 && ball.getJ() != 3 && ball.getJ() != 60)
							ball.setI(ball.getDirectionJ()-2);
						*/	
					}
					//01
					else if(coordMap[ball.getI()+ball.getDirectionI()-1][ball.getJ()+ball.getDirectionJ()] == ' ' &&
							coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()+1] != ' '){
						coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] = ' ';
						ball.setDirectionI(-1);
						/*if(ball.getI() != 4 && ball.getJ() != 3 && ball.getJ() != 60)
							ball.setI(ball.getDirectionI()+2);
						*/
					}
					//11
					else if(coordMap[ball.getI()+ball.getDirectionI()-1][ball.getJ()+ball.getDirectionJ()] != ' ' &&
							coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()+1] != ' '){
						coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] = ' ';
						ball.setDirectionI(-1);
						ball.setDirectionJ(1);
						
					}
					//ball.setDirectionJ(1);
				}
					
				if(directionI == -1 && directionJ == -1){
					//00
					if(coordMap[ball.getI()+ball.getDirectionI()+1][ball.getJ()+ball.getDirectionJ()] == ' ' &&
							coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()+1] == ' '){
						coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] = ' ';
						ball.setDirectionI(1);
						
					}
					//10
					else if(coordMap[ball.getI()+ball.getDirectionI()+1][ball.getJ()+ball.getDirectionJ()] != ' ' &&
							coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()+1] == ' '){
						coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] = ' ';
						ball.setDirectionJ(1);
						/*if(ball.getI() != 4 && ball.getJ() != 3 && ball.getJ() != 60)
							ball.setI(ball.getDirectionI()-2);
						*/
					}
					//01
					else if(coordMap[ball.getI()+ball.getDirectionI()+1][ball.getJ()+ball.getDirectionJ()] == ' ' &&
							coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()+1] != ' '){
						coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] = ' ';
						ball.setDirectionI(1);
						/*if(ball.getI() != 4 && ball.getJ() != 3 && ball.getJ() != 60)
							ball.setI(ball.getDirectionJ()-2);
						*/
					}
					//11
					else if(coordMap[ball.getI()+ball.getDirectionI()+1][ball.getJ()+ball.getDirectionJ()] != ' ' &&
							coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()+1] != ' '){
						coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] = ' ';
						ball.setDirectionI(1);
						ball.setDirectionJ(1);
						
					}
					//ball.setDirectionJ(1);
				}
				
				if(directionI == -1 && directionJ == 0){
					coordMap[ball.getI()+ball.getDirectionI()][ball.getJ()+ball.getDirectionJ()] = ' ';
					ball.setDirectionI(1);
				}
			}
		}
	}
	
	static Ball getBallObject(){
		return ball;
	}
	
	public static void main(String[] args) {
		Map map = new Map();
		Paddle paddle = new Paddle();
		//Create map and paddle with initial conditions
		
		map.drawMap();
		char pDirection; int pCoord=0;
		//Get command from user until the game ends
		while(true){
			pDirection=paddle.read();
			if(pDirection == '4'){
				pCoord=-1;
			}
			else if(pDirection == '6'){
				pCoord=1;
			}
			else if(pDirection == ' '){
				pCoord=0;
			}
			else if(pDirection == 'e'){
				pCoord=0;
				break;
			}
			map.update(pCoord);		
		}
	}
	
}
