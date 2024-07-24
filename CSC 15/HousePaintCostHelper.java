/* Youssef Boujebha
   3/24/2021
   programming assignment 3
   HousePaintCost helper class */
   
import java.lang.Math; //Makes it easier to do math
import java.util.Scanner; //Imports a scanner so the program can take user imputs

public class HousePaintCostHelper {
  static final double BLACK_PAINT = 1.35; // These are the prices of the paint in dollars per cubic foot
  static final double WHITE_PAINT = 2.99;
  static final double RED_PAINT = 3.49;
  static final double ANGLE = 60; // This is the angle of the roof
  
 public static void main(String[] args){ //main method that calls the finished program
       wholeHousePaintCost(); //Calls the method that runs the finished program
  }
  
  public static double Perimeter(double side) { //Calculates the perimeter of the roof
    return 3 * side;
  }

  public static double RoofArea(double side, double depth) { //Calculates the area of the roof

    double sum_of_sides = Perimeter(side) / 2;
    double area_of_triangles = 2 * Math.sqrt(sum_of_sides * (sum_of_sides - side) * (sum_of_sides - side) * (sum_of_sides - side));
    double area_of_parallelograms = 2 * side * depth * Math.sin(Math.toRadians(ANGLE));

    return (area_of_triangles + area_of_parallelograms);
  }
  public static double RoofPaintCost(double side, double depth){ //Calculates the cost of painting the roof
    double roof_area = RoofArea(side, depth);
    return (roof_area * RED_PAINT);
  }
  public static double BaseArea(double height, double width, double depth){ //Calculates the area of the chimney
    return (2 * height * width + 2 * height * depth);
  }
  public static double BasePaintCost(double height, double width, double depth){ //Calculates the cost of painting the base
    double base_area = BaseArea(height, width, depth);
    return (base_area * WHITE_PAINT);
  }
  public static double ChimneyArea(double height, double radius){ //Calculates the area of the chimney
    return (2 * Math.PI * radius * height);
  }
  public static double ChimneyPaintCost(double height, double radius){ //Calculates the cost of painting the roof
    double chimney_area = ChimneyArea(height, radius);
    return (chimney_area * BLACK_PAINT);
  } 
  
  public static void wholeHousePaintCost(){ //Displays the final screen where you enter the dimensions and it shows the cost
   Scanner input = new Scanner(System.in); 
    double roof_side, roof_depth, base_height, base_width, base_depth, chimney_height, chimney_radius;
    double roof_cost, base_cost, chimney_cost;
    System.out.println("------------------------------------------------------------------"); //The first part that asks for the roof dimensions and gives the cost
    System.out.println("Calculating Roof Cost - Please enter dimensions");
    System.out.println("------------------------------------------------------------------");
    System.out.print("Please Enter length of side of roof: ");
    roof_side = input.nextDouble();
    System.out.print("Please Enter the depth of roof: ");
    roof_depth = input.nextDouble();
    System.out.printf("The area of the roof in cubic feet is: %.2f\n", RoofArea(roof_side, roof_depth));
    roof_cost = RoofPaintCost(roof_side, roof_depth);
    System.out.printf("The cost of painting the roof with red paint is %.2f\n", roof_cost); //The cost of painting the roof
    System.out.println("------------------------------------------------------------------"); //The second part that asks for the base dimensions and gives the cost
    System.out.println("Calculating Base Cost - Please enter dimensions");
    System.out.println("------------------------------------------------------------------");
    System.out.print("Please Enter the height of the house: ");
    base_height = input.nextDouble();
    System.out.print("Please Enter the width of the house: ");
    base_width = input.nextDouble();
    System.out.print("Please Enter the depth of the house: ");
    base_depth = input.nextDouble();
    System.out.printf("The area of the base in cubic feet is: %.2f\n", BaseArea(base_height, base_width, base_depth));
    base_cost = BasePaintCost(base_height, base_width, base_depth);
    System.out.printf("The cost of painting the base of the house white paint is %.2f\n", base_cost); //The cost of painting the house
    System.out.println("------------------------------------------------------------------");//The last part that asks for the dimensions of the chimney and gives a cost
    System.out.println("Calculating Chimney Cost - Please enter dimensions");
    System.out.println("------------------------------------------------------------------");
    System.out.print("Please Enter the height of the chimney: ");
    chimney_height = input.nextDouble();
    System.out.print("Please Enter the radius of the chimney: ");
    chimney_radius = input.nextDouble();
    System.out.printf("The area of the chimney in cubic feet is: %.2f\n", ChimneyArea(chimney_height, chimney_radius));
    chimney_cost = ChimneyPaintCost(chimney_height, chimney_radius);
    System.out.printf("The cost of painting the roof with red paint is %.2f\n", chimney_cost); //The cost of painting the chimney 
    System.out.println("------------------------------------------------------------------");
    System.out.println("Program to Calculate Cost of Painting The Exterior of a House");
    System.out.println("------------------------------------------------------------------");
    System.out.printf("The total cost of painting the house is $%.2f\n", (roof_cost + base_cost + chimney_cost));
  }
  
}