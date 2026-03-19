import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ReadFile{
  public static int[][] read(String type){
    int [][] data = null;
    Scanner in;
    try{
      if(type.equals("eraseObject")){
        data = new int[21][21];
        in = new Scanner(new File("eraseObjectTestCase.txt"));
        int numRows = in.nextInt();
        
        for(int i = 0; i < numRows; i++){
          int row = in.nextInt();
          int col = in.nextInt();
          data[row][col] = 1;
        }
      }
      else if(type.equals("maze")){
        in = new Scanner(new File("mazeTestCase.txt"));
        int rows = in.nextInt();
        int cols = in.nextInt();
        data = new int[rows][cols];

        while(in.hasNext()){
          int row = in.nextInt();
          int col = in.nextInt();
          data[row][col] = 1;
        }     
      }
      else{
        System.out.println("ERROR IN INPUT, TRY AGAIN");
        return null;
      }
    }
      
    catch(IOException e){
      System.out.println(e.getMessage());
    }

    return data;
  }
}