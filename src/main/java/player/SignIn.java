package player;
/**
@author Hesamaldin Bagheri
 @see massage
 */
import massage.Warning;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class SignIn {
    private static final Logger logger = (Logger) LogManager.getLogger(SignIn.class);
    /**@param for warning massage*/
    Warning warning=new Warning();
    /**source profiles dic*/
    private String dirname = "sign up";
    /**checking info that we are going to open profile*/
    public boolean inputInfo(String userNameIn,String userPassIn) throws IOException {
        /**opening source file of pass and username*/
        String userName=new String();
        String userPass=new String();
        File file = new File(dirname+"/"+userNameIn);
            if(file.exists()==false){
                logger.error("there is not such a file:"+file.getName());
            }else {
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader(file));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String st;
                try {
                    for (int i = 0; (st = br.readLine()) != null; i++) {
                        /**i=0 is for username
                         * i=1 is for password
                         * i=2 is for coin
                         */
                        if (i == 0) {
                            String string = st;
                            userName = string.substring(string.indexOf(" = ") + 3);
                        }
                        if (i == 1) {
                            String string = st;
                            userPass = string.substring(string.indexOf(" = ") + 3);
                        }
                    }
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        /**checking user and pass and show warning and continue
         * @param userName is real username and we want to check with userNameIn
         * @param userPass is real password and we want to check with userPassIn
         */
        if (userName.equals(userNameIn) && userPass.equals(userPassIn)) {
            return true;
        } else {
            warning.setMassageWrong("Your username or password is wrong try harder:)");
            warning.getMassageWrong();
        }
        return false;
    }
}
