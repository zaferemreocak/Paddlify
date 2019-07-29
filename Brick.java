
public class Brick {
	
void drawBrick(char coordMap[][]){
		
	int i,j;
		
		//Drawing the bricks on the map
		for(i = 2;i<= 6;i++){
			for (j = 10;j< 17;j++){
				coordMap[i][j] = 'R';	//R stands for red brick 
			}
			
			for (j = 45;j< 52;j++){
				coordMap[i][j] = 'G';	//G stands for green brick
				
			}
			for (j = 28;j< 35;j++){
				coordMap[i][j] = 'B';	//B stands for blue brick
			}	
		}
		
		int k,t;
		for(i = 8; i<= 13; i++){
			for(j = 15;j <= 20; j++){
					k = i;
					t = j;
					coordMap[k][t] = 'Y';	//Y stands for yellow brick
					k = k + 1;
					t = t- 2;
			}
				
		}
		
		for(i = 8; i<= 13; i++){
			for(j = 39;j <= 45; j++){
					k = i;
					t = j;
					coordMap[k][t] = 'Y';			
					k = k + 1;
					t = t- 2;
			}
				
		}
		for(i = 13; i<= 15; i++){
			for(j = 29;j <= 34; j++){
					k = i;
					t = j;
					coordMap[k][t] = 'G';			
					k = k + 1;
					t = t- 2;
			}
				
		}
		
		for(i = 13; i<= 15; i++){
			for(j = 5;j <= 10; j++){
					k = i;
					t = j;
					coordMap[k][t] = 'B';			
					k = k + 1;
					t = t- 2;
			}
				
		}
		
		for(i = 13; i<= 15; i++){
			for(j = 50;j <= 55; j++){
					k = i;
					t = j;
					coordMap[k][t] = 'R';			
					k = k + 1;
					t = t- 2;
			}	
		}
	}
}
