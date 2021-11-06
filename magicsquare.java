import java.util.*;

public class MagicSquare{
public static void main(String[] args) {
    
    Scanner sc= new Scanner(System.in);  
    System.out.print("Enter square size (must be odd) ");  
    int n= sc.nextInt();  
    System.out.print("Enter number of rotations ");  
    int rotation = sc.nextInt(); 
    if (n % 2 == 0) throw new RuntimeException("n must be odd");
    
    int[][] Square = new int[n][n];

    int number = 1;
    int row = 0;
    int column = n / 2;
    int curr_row;
    int curr_col;
    while (number <= n * n) {
        Square[row][column] = number;
        number++;
        curr_row = row;
        curr_col = column;
        row -= 1;
        column += 1;
        if (row == -1) {
            row = n - 1;
        }
        if (column == n) {
            column = 0;
        }
        if (Square[row][column] != 0) {
            row = curr_row + 1;
            column = curr_col;
            if (row == -1) {
                row = n - 1;
            }
        }
    }

    if(rotation==0){
        for (int i = 0; i < Square.length; i++) {
            for (int j = 0; j < Square.length; j++) {
                if (Square[i][j] < 10)  System.out.print(" ");  
                if (Square[i][j] < 100) System.out.print(" ");  
                System.out.print(Square[i][j] + " ");
            }
            System.out.println();
        }
    }
    else{
    //rotations
        for (int k = 0; k<rotation; k++){
            for (int i = 0; i < n / 2; i++){
                for (int j = i; j < n - i - 1; j++){
                    int temp = Square[i][j];
                    Square[i][j] = Square[n - 1 - j][i];
                    Square[n - 1 - j][i] = Square[n - 1 - i][n - 1 - j];
                    Square[n - 1 - i][n - 1 - j] = Square[j][n - 1 - i];
                    Square[j][n - 1 - i] = temp;
                }
            }
            
        }
        for (int i = 0; i < Square.length; i++) {
                for (int j = 0; j < Square.length; j++) {
                    if (Square[i][j] < 10)  System.out.print(" ");  
                    if (Square[i][j] < 100) System.out.print(" ");  
                    System.out.print(Square[i][j] + " ");
                }
            System.out.println();
    }
}
}
}