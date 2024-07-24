/* Youssef Boujebha
   3/5/2021
   Programming assignment 2
   Draw a rocket using for loops Helper Class */

public class DrawRocketHelper{
	public static final int Height = 3; // Sets the height of the rocket. Size should scale with integer
	
	public static void main(String[] args){
      DrawRocket(); // Calls the method that draws the complete rocket
	}
	public static void DrawTop(){ // Draws the top of the rocket 
	  for (int Line = 1; Line <= (Height *2 - 1); Line++){
		System.out.print(" ");
		for (int Spaces = 1; Spaces <= (Height * 2 - 1) - Line; Spaces++){
				System.out.print(" ");
			}
			for (int Slashes = 1; Slashes <= Line; Slashes++){
				System.out.print("/");
			}
			System.out.print("**");
			for (int Slashes = 1; Slashes <= Line; Slashes++){
				System.out.print("\\");
			}
		System.out.println(" ");
	}
  }	
	public static void DrawLine(){ // Draws the part of the rocket seperating the top and first section
		System.out.print("+");
		for (int i = 1; i <= Height *2; i++){
			System.out.print("=*");
		}
		System.out.println("+");
	}
	public static void DrawTopPart(){ // Draws the top part of the rocket section, is also used at the bottom of the rocket
		for (int Line = 1; Line <= Height; Line++){
			System.out.print("|");
			for (int Repeat = 1; Repeat <= 2; Repeat++){
				for (int Dots = 1; Dots <= Height - Line; Dots++){
					System.out.print(".");
				}
				for (int Points = 1; Points <= Line; Points++){
					System.out.print("/\\");
				}
				for (int Dots = 1; Dots <= Height - Line; Dots++){
					System.out.print(".");
				}
			}
			System.out.println("|");
		}
	}
	public static void DrawBottomPart(){ // Draws the bottom part of the rocket 
		for (int Line = Height; Line >= 1; Line--){
			System.out.print("|");
			for (int Repeat = 1; Repeat <= 2; Repeat++){
				for (int Dots = 1; Dots <= Height - Line; Dots++){
					System.out.print(".");
				}
				for (int Points = 1; Points <= Line; Points++){
					System.out.print("\\/");
				}
				for (int Dots = 1; Dots <= Height - Line; Dots++){
				System.out.print(".");
				}
			}
			System.out.println("|");
		}     
	}
   public static void DrawRocket(){ // Brings everything together and draws the full rocket
   	DrawTop();
		DrawLine();
		DrawTopPart();
		DrawBottomPart();
		DrawLine();
		DrawBottomPart();
		DrawTopPart();
		DrawLine();
		DrawTop();
   } 
}