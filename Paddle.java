import java.util.Scanner;

public class Paddle {
	
	public Paddle(){
		System.out.println("To move left press [4] ");
		System.out.println("To move right press [6] ");
		System.out.println("To stay at the same position press [SPACE] ");
		System.out.println("To finish the game instantly press [E]");
		System.out.println("Try to focus on hitting RED BRICKS to empower your paddle for 30 rounds!");
		System.out.println("////////////////////////////////" +
				"////////////////////////////////");
		System.out.println("\t\t^^^^^ GAME CONTROL ^^^^^");
	}
	
	char read(){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the next direction of the paddle: ");
		char userInput = input.nextLine().charAt(0);
		if(Map.getBallObject().getI() == 29){
			if(userInput == '6'){
				Map.getBallObject().setDirectionJ(-1);				
			}
			else if(userInput == '4'){
				Map.getBallObject().setDirectionJ(1);
			}
				
		}
		if(userInput == ' '){
			System.out.println("Don't move!");
		}
		else if(userInput == '4'){
			System.out.println("Move left!");
		}
		else if(userInput == '6'){
			System.out.println("Move right!");
		}
		else if(userInput == 'e'){
			System.out.println("Finish game!");
			return userInput;
		}
		else{
			System.out.println("Invalid!");
		}
		return userInput;
	}

}
