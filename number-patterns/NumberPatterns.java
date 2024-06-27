import java.util.Scanner;

public class NumberPatterns {
	public static void main (String[] args){
      Scanner scanner = new Scanner (System.in);

      System.out.println("Select the type of pattern:");
      System.out.println("1.Triangle");
      System.out.println("2.Floyd's Triangle");
      System.out.println("3.Pascal's Triangle");
      System.out.print("Enter your choice (1/2/3)");
      int choice = scanner.nextInt();

      switch (choice) {
      case 1: 
      	System.out.print("Enter the number of rows for the triangle:");
      	int rowsTriangle = scanner.nextInt();
      	printTriangle(rowsTriangle);
      	break;

      case 2:
        System.out.print("Enter the number of rows for the Floyd's triangle:");	
        int rowsFloyd = scanner.nextInt();
      	printFloydTriangle(rowsFloyd);
      	break;

       case 3:
       	System.out.print("Enter the number of rows for the Pascal's triangle:");	
        int rowsPascal = scanner.nextInt();
      	printPascalTriangle(rowsPascal);
      	break;

      default:
      	System.out.println("Invalid choice");

      }
      scanner.close();
	}
	//Triangle
	private static void printTriangle(int rows){
		for(int i = 1; i <= rows; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

// Floyd's Triangle
    private static void printFloydTriangle(int rows) {
        int number = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }
    }

    // Pascal's Triangle
    private static void printPascalTriangle(int rows) {
        for (int i = 0; i < rows; i++) {
            int number = 1;
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(number + " ");
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}