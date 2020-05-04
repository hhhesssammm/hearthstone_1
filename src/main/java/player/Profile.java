package player;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class Profile {
    private static final Logger logger = (Logger) LogManager.getLogger(Profile.class);
    /**
     * @param coin is saved coin
     * @param dirname is file location
     */
    private String userName;
    private String userPass;
    private String coin;
    private String dirname = "sign up";
    /**for set a profile*/
    /**helping by https://www.geeksforgeeks.org/different-ways-reading-text-file-java*/
    public void setProfile(final String name){
        File file = new File(dirname+"/"+name);
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
                        this.userName = string.substring(string.indexOf(" = ") + 3);
                    }
                    if (i == 1) {
                        String string = st;
                        this.userPass = string.substring(string.indexOf(" = ") + 3);
                    }
                    if (i == 2) {
                        String string = st;
                        this.coin = string.substring(string.indexOf(" = ") + 3);
                    }
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteProfile(String userName){
        /** @param file is our goal to delete*/
        File file=new File(dirname+"/"+userName);
        if(file.delete()){
            logger.info("Deleted the file: " + file.getName());
        }else{
            logger.info("Failed to delete the file : " + file.getName());
        }
    }
    public String getName() {
        return this.userName;
    }
    public String getPass() {
        return this.userPass;
    }
    public String getCoin() {
        return coin;
    }

}