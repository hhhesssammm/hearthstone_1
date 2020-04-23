package player;
/**
@author Hesamaldin Bagheri
 @see massage
 */
import massage.Warning;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;

public class SignIn {
    /**@param for warning massage*/
    Warning warning=new Warning();
    /**open source profiles*/
    private String dirname = "c:/sign up";
    /**checking info that we are going to open profile*/
    public void inputInfo(String userNameIn,String userPassIn) throws IOException {
        /**opening source file of pass and username*/
        String userName=new String();
        String userPass=new String();

        /**https://www.tutorialspoint.com/ this is source*/
        File dir = new File(dirname);
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept (File dir, String letter) {
                return letter.equals(userNameIn);
            }
        };
        String[] children = dir.list(filter);
        if (children == null) {
        } else {
            File file = new File(dirname+"/"+children[0]);
            Scanner sc = new Scanner(file);
            for (int i=0;sc.hasNextLine();i++) {
                /**i=0 is for username
                 * i=1 is for password
                 * i=2  is for coin
                 */
                if(i==0) {
                    String string = sc.nextLine();
                    userName=string.substring(string.indexOf(" = "));
                }
                if(i==1) {
                    String string = sc.nextLine();
                    userPass = string.substring(string.indexOf(" = "));
                }
            }
        }
        /**checking user and pass and show warning and continue
         * @param userName is real username and we want to check with userNameIn
         * @param userPass is real password and we want to check with userPassIn
         */
        while (true) {
            if (userName.equals(userNameIn) && userPass.equals(userPassIn)) {
                break;
            } else {
                warning.setMassageWrong("Your username or password is wrong try harder:)");
                warning.getMassageWrong();
            }
        }
    }
}
