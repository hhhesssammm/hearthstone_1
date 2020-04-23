package massage;

import java.util.Scanner;

/**for stop the program for reading the massage or any thing*/
public class Stop {
    /**if press somthing it goes on it repair in the next levels*/
    public void stopping(){
        Scanner scanner=new Scanner(System.in);
        while (true){
            String halt=scanner.nextLine();
            if(halt.equals("ok")){
                break;
            }
        }
        scanner.close();
    }
}
