public class DisplayData {

    //this is an overly simplistic display to show it is working....
    //MAKE IMPROVEMENTS TO MAKE THIS EASIER TO READ!
    public static void display(int [][] data){
        for(int r = 0; r < data.length; r++){
            for(int c = 0; c < data[0].length; c++)
            {
                System.out.print(data[r][c] + " ");
            }
            System.out.println("");
        }
    }
    
}
