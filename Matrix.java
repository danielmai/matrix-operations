
/**
 * Performs the matrix operations according to the desires of the user:
 * Scalar Multiplication
 * Addition
 * Subtraction
 * Matrix Multiplication 
 * 
 * @author (Jessica Hartono, Daniel Mai) 
 * @version (10/19/11)
 */
import java.util.Scanner;
public class Matrix
{
    public int row;
    public int column;
    public int[][] a;
    public int[][] b;
    public int[][] data;
    public int scal;

    
    public static void main(String[] args)
    {
        //loop the program if the user prompts "y"
        boolean yes = true;
        do
        {
            Scanner in = new Scanner(System.in);

            //user selects desired matrix operation 
            System.out.println("Selection:");
            System.out.println("Press [1] to perform scalar multiplication");
            System.out.println("Press [2] to perform matrix addition");
            System.out.println("Press [3] to perform matrix subtraction");
            System.out.println("Press [4] to perform matrix multiplication");

            System.out.print("Please enter your selection: ");
            int input = in.nextInt();

            //skip line
            System.out.println();

            System.out.println("Create a matrix: ");
            //takes number of rows for the matrix
            System.out.print("Enter number of rows: ");
            int rowA = in.nextInt();

            //takes number of columns for the matrix
            System.out.print("Enter number of columns: ");
            int columnA = in.nextInt();

            //gathers input for array memory compartments
            Matrix data = new Matrix(rowA, columnA);
            data.matrixDataA();

            //Perform Scalar Multiplication
            if (input == 1)
            {
                data.scalar();
            }

            //Perform Matrix Addition
            if (input == 2)
            {
                data.addition();
            }

            //Perform Matrix Subtraction
            if (input == 3)
            {
                data.subtraction();
            }

            //Perform Matrix Multiplcation
            if (input == 4)
            {
                data.multiplication();
            }

            //asks the user to re-run the program or not
            System.out.print("Would you like to continue? (y/n): ");
            String check = in.next();

            System.out.println();
            if (check.equalsIgnoreCase("y"))
            {
                yes = true;
            }

            else
            {
                yes = false;
            }

        }
        while(yes == true);
    }

    /**
     * Constructs the matrix.
     * @param ro number of rows
     * @param col number of columns
     */
    public Matrix(int ro, int col)
    {
        row = ro;
        column = col;
        a = new int [row][column];
        scal = 0;
    }

    /**
     * Inputs values into the two-dimensional array a
     */
    public void matrixDataA()
    {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < row; i++)
        {  
            int u = i + 1;
            System.out.print("Enter values of row " + u + ": ");
            for (int j = 0; j < column; j++)
            {  
                a[i][j] = in.nextInt();
            }
        }
        System.out.println();
    }

    /**
     * Prints a two-dimensional array of integers
     * @param data the values to be printed
     * @param width the column width
     */
    public static void printMatrix(int[][] data, int width)
    {
        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j < data[i].length; j++)
            {              
                //separates array values with a space
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * scalar, multiply the user-inputted matrix with a scalar. 
     */
    public void scalar()
    {

        Scanner in = new Scanner(System.in);
        //takes in the scalar value
        System.out.print("Enter the scalar: ");
        scal = in.nextInt();

        //performs scalar multiplication operation
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                a[i][j] = scal * a[i][j];
            }                
        }
        //prints the final result
        System.out.println("Result:");
        printMatrix(a, column);
    }

    /**
     * addition, Adds two user-inputted matrices.
     */
    public void addition()
    {
        Scanner in = new Scanner(System.in);
        //makes second matrix
        System.out.println("Second matrix: ");

        int[][] b = new int[row][column];
        for (int i = 0; i < row; i++)
        {  
            int u = i + 1;
            System.out.print("Enter values of row " + u + ": ");
            for (int j = 0; j < column; j++)
            {  
                b[i][j] = in.nextInt();
            }
        }
        System.out.println();

        //final result matrix "add"
        int[][] add = new int[row][column];
        for(int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                add[i][j] = a[i][j] + b[i][j];
            }
        }       
        //prints the final result
        System.out.println("Result:");
        printMatrix(add, column);
    }

    /**
     * subtraction, Subtracts two user-inputted matrices.
     */
    public void subtraction()
    {
        Scanner in = new Scanner(System.in);
        //makes second matrix
        System.out.println("Second matrix: ");

        int[][] b = new int[row][column];
        for (int i = 0; i < row; i++)
        {  
            int u = i + 1;
            System.out.print("Enter values of row " + u + ": ");
            for (int j = 0; j < column; j++)
            {  
                b[i][j] = in.nextInt();
            }
        }
        System.out.println();

        //final result matrix "sub"
        int[][] sub = new int[row][column];
        for(int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                sub[i][j] = a[i][j] - b[i][j];
            }
        }
        //prints the final result
        System.out.println("Result:");
        printMatrix(sub, column);
    }

    /**
     * multiplication, Multiplies two user-inputted matrices, upholding the condition that the number of columns of the first matrix
     * is equal to the number of rows of the second matrix.
     */
    public void multiplication()
    {
        Scanner in = new Scanner(System.in);
        //creates second matrix
        System.out.println("Second matrix: ");

        System.out.print("Enter number of rows: ");
        int rowB = in.nextInt();
        System.out.print("Enter number of columns: ");
        int columnB = in.nextInt();

        //if dimensions do not fit the Matrix Multiplication condition, return "Dimensions mismatch..."
        //else, perform the operation
        if (column != rowB)
        {
            System.out.println("Dimensions mismatch! Unable to complete the computation!!! DUMMY");
        }
        else
        {
            int[][] b = new int[rowB][columnB];
            for (int i = 0; i < rowB; i++)
            {  
                int u = i + 1;
                System.out.print("Enter values of row " + u + ": ");
                for (int j = 0; j < columnB; j++)
                {  
                    b[i][j] = in.nextInt();
                }
            }
            System.out.println();

            //final result matrix "mult"
            int[][] mult = new int[row][columnB];

            for(int i = 0; i < row; i++)
            {
                for (int j = 0; j < columnB; j++)
                {
                    int sum = 0;
                    for(int k = 0; k < rowB; k++)
                    {
                        sum = sum + ( a[i][k] * b[k][j] );
                    }
                    mult[i][j] = sum;
                }
            }
            //prints the final matrix
            System.out.println("Result:");
            printMatrix(mult, columnB);
        }
    }
}
