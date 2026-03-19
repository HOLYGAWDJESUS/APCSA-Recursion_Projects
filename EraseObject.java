import java.util.Scanner;

public class EraseObject
{
    private int [][] board;
    private Scanner in;

    public EraseObject(int [][] data)
    {
        board = data;
        in = new Scanner(System.in);
    }

    public void run()
    {
        DisplayData.display(board);
        input();
        DisplayData.display(board);
    }

    public void input()
    {
        System.out.println("Please input a row -> ");
        int r = in.nextInt();
        System.out.println("Please input a column -> ");
        int c = in.nextInt();
        erase(r, c);
    }

    public void erase(int row, int col)
    {

    }
}