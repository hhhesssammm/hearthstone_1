package player;

import massage.Warning;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;
import org.junit.*;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static junit.framework.TestCase.assertEquals;

public class SignUp {
    /**for logging*/
    private static final Logger logger = (Logger) LogManager.getLogger(SignUp.class);
    /**username and pass for sign up */
    private String userName;
    private String pass;
    /** @param dirname is for folder*/
    private String dirname = "sign up";
    /**it is for checking bad characters in username*/
    public boolean badChars(String s){
        int x=0;
        for (int i=0;i<s.length();i++){
            if (((int)s.charAt(i)>=32&&(int)s.charAt(i)<=47)||((int)s.charAt(i)>=58&&(int)s.charAt(i)<=63)) {
                x++;
            }
        }
        if(x>=1){
            return true;
        }
        return false;
    }
    public void setUserName(String userName) {
        /**create a folder i took this code from stack overflow
         */
        File d = new File(dirname);
        d.mkdirs();
        /**getting use name and if its exist print it exist*/
        Warning warning=new Warning();
        /**checking that there is not any file by this name*/
        File file=new File(dirname + userName);
        if(file.exists()==(false)&&(false)==badChars(userName)){
            this.userName=userName;
            try {
                FileWriter write=new FileWriter(dirname+"//"+userName,true);
                write.write("username = "+userName+"\n");
                write.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            if(file.exists()!=(false)) {
                warning.setMassageWrong("this user name exist please try another username");
                warning.getMassageWrong();
            }
            if(badChars(userName)!=(false)) {
                warning.setMassageWrong("there are bad chars in the string");
                warning.getMassageWrong();
            }
        }
    }

    public String getUserName() {
        return userName;
    }

    /**it is for checking that exist number*/
    public static boolean number(String s){
        int exist=0;
        String []numbers={"0","1","2","3","4","5","6","7","8","9"};
        for (int i=0;i<10;i++){
            if(s.indexOf(numbers[i])!=-1) {
                exist++;
            }
        }
        if(exist>=1){
            return true;
        }
        return false;
    }

    /**it is for checking that exist alphabet*/
    public boolean alphabet(String s){
        int exist=0;
        for (int i=0;i<s.length();i++){
            if (((int)s.charAt(i)>=33&&(int)s.charAt(i)<=47)||((int)s.charAt(i)>=58&&(int)s.charAt(i)<=126)) {
                exist++;
            }
        }
        if(exist>=1){
            return true;
        }
        return false;
    }

    public void setPass(String pass) {
        /**conditions that pass is good in must be between 8 to 16 character and include number and alphabet*/
        /**1.checking include number and alphabet*/
        Warning warning=new Warning();
        if(number(pass)==true){//number test
            if(alphabet(pass)==true) {//alphabet test by "motamammam kardan adadha"
                /**2.checking length of pass*/
                while (true) {
                    if (16 >= pass.length() && 8 <= pass.length()) {
                        try {
                            this.pass=pass;
                            FileWriter write=new FileWriter(dirname+"/"+getUserName(),true);
                            write.write("password = "+pass+"\n");
                            write.write("coin = 50\n");
                            write.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        break;
                    }
                    /**massage of warning and tell why is wrong*/
                    if (pass.length() <= 7) {
                        warning.setMassageWrong("Your password must have more than 7 characters");
                        warning.getMassageWrong();
                    }
                    if (pass.length() >= 17) {
                        warning.setMassageWrong("Your password must have less than 17 characters");
                        warning.getMassageWrong();
                    }
                }
            }
        }else{
            /**warning massage because its wrong*/
            warning.setMassageWrong("Your password must have number and alphabet");
            warning.getMassageWrong();
        }
    }

    public String getPass() {
        return pass;
    }
}
