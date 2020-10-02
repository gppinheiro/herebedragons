import java.util.*;

public class MiniQuest1 {
	public static void printmap (char[][] map) {
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		//MAP
		char [][] map = {
				{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
				{'X', 'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
				{'X', 'D', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
				{'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'E'},
				{'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
				{'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
				{'X', 'K', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
		};
		
		printmap(map);
		
		int hero_pos[] = {1,1};
		//int dragon_pos[] = {3,1}; - Dragon Position
		//int exit_pos[] = {5,9}; - Exit Position
		int aux0 = 0;
		int aux1 = 0;
		boolean key=false;
		
		//BUTTON
		System.out.println(" a-'LEFT'; s-'DOWN' ; d-'RIGHT'; w-'UP' ; c-'CLOSE'");
		String button = "n";
		
		//Read Terminal
		Scanner s = new Scanner(System.in);
		
		//GAME
		while (true) {
			//Select the button
			System.out.println("Press a button:");
			button = s.next();
			
			//Controlling Hero
			if (button.equals("a")) {
				aux0=hero_pos[0];
				aux1=hero_pos[1]-1;
				if( map[aux0][aux1] != 'X' ) {
					map[hero_pos[0]][hero_pos[1]] = ' ';
					hero_pos[1]--;
					map[hero_pos[0]][hero_pos[1]] = 'H';
				}
			} else {
				if (button.equals("s")) {
					aux0=hero_pos[0]+1;
					aux1=hero_pos[1];
					if( map[aux0][aux1] != 'X' ) {
						map[hero_pos[0]][hero_pos[1]] = ' ';
						hero_pos[0]++;
						map[hero_pos[0]][hero_pos[1]] = 'H';
					}
				} else {
					if (button.equals("d")) {
						aux0=hero_pos[0];
						aux1=hero_pos[1]+1;
						if( map[aux0][aux1] != 'X' ) {
							map[hero_pos[0]][hero_pos[1]] = ' ';
							hero_pos[1]++;
							map[hero_pos[0]][hero_pos[1]] = 'H';
						}
					} else {
						if (button.equals("w")) {
							aux0=hero_pos[0]-1;
							aux1=hero_pos[1];
							if( map[aux0][aux1] != 'X' ) {
								map[hero_pos[0]][hero_pos[1]] = ' ';
								hero_pos[0]--;
								map[hero_pos[0]][hero_pos[1]] = 'H';
							}
						} else {
							if (button.equals("c")) {
								break;
							} else {
								System.out.println("Invalid! Please, repeat!\n");
							}
						}			
					}
				}
			}
			
			//Keep away from dragon
			if( (hero_pos[0]==2 || hero_pos[0]==4) && hero_pos[1]==1 ) {
				System.out.println("You are dead! GAME IS OVER!\n");
				break;
			}
			
			//Get the key
			if( hero_pos[0]==8 && hero_pos[1]==1 ) {
				System.out.println("Now, you have the key to exit!\n");
				key=true;
			}
			
			//Exit
			if( hero_pos[0]==5 && hero_pos[1]==8 && !key) {
				System.out.println("You can´t exit! NEED THE KEY!\n");
			}
			if ( hero_pos[0]==5 && hero_pos[1]==9 && key) {
				System.out.println("YOU WON! CONGRATS!\n");
				break;
			}
			
			//More pretty
			System.out.println();
			//Print new map
			printmap(map);
			//Just to separate the last iteration
			System.out.println();
		}
		
		s.close();	
	}

}
