import java.util.Scanner;
import java.util.Arrays;


public class Main 
{
    public static void main(String [] args)
    {
        //here you will decide which project to run using the console
        System.out.println("Select the project code to run: ");
        System.out.println("   1. EraseObject");
        System.out.println("   2. Maze");
        System.out.println("   3. Knight's Tour");

        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();

        while(Integer.parseInt(choice) < 1 || Integer.parseInt(choice) > 3)
        {
            System.out.println("Please input valid input from menu above");
            choice = in.nextLine();
        }

        int [][] data = new int[8][8];
        
        if(Integer.parseInt(choice) == 1)
        {
            data = ReadFile.read("eraseObject");
            EraseObject run = new EraseObject(data);
            run.run();
            
        }
        else if(Integer.parseInt(choice) == 2)
        {
            data = ReadFile.read("maze");
            new Maze(data);
        }
        else
        {
            for (int i = 0; i < 1000; i++){
            int ranx = (int)(8*Math.random());
            int rany = (int)(8*Math.random());
            KnightsTour tour = new KnightsTour(data);
            System.out.println(tour.playRandom(data, ranx, rany, 1));
            for (int k = 0; k < data.length; k++)
            Arrays.fill(data[k], 0);
            }
        }
    }
}