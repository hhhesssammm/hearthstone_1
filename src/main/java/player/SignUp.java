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
    /**checking that there is not any file by this name*/
    /**part of is wrote in stack overflow*/
    /**@param pathname is a directory
     * @param existName is a searching name
     */
    @BeforeClass
    private boolean beingFile(String pathname, final String existName){
        File dir = new File(pathname);
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept (File dir, String name) {
                return name.equals(existName);
            }
        };
        String[] children = dir.list(filter);
        if (children == null) {
            return false;
        }
        return true;
    }
    @Before
    public void setUserName(String userName) {
        /**create a folder i took this code from stack overflow
         */
        File d = new File(dirname);
        d.mkdirs();
        /**getting use name and if its exist print it exist*/
        Warning warning=new Warning();
        while(true) {
            if(beingFile(dirname,userName)==false){
                this.userName=userName;
                try {
                    FileWriter write=new FileWriter(dirname+"//"+userName,true);
                    write.write("username = "+userName+"\n");
                    write.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
                break;
            }else {
                logger.info("there is not any file");
                warning.setMassageWrong("this user name exist please try another username");
                warning.getMassageWrong();
            }
        }
    }
    @After
    public String getUserName() {
        return userName;
    }
    @Before
    public void setPass(String pass) {
        /**conditions that pass is good in must be between 8 to 16 character and include number and alphabet*/
        /**1.checking include number and alphabet*/
        Warning warning=new Warning();
        while (true){
            if(pass.indexOf("0")!=-1||pass.indexOf("1")!=-1||pass.indexOf("2")!=-1||pass.indexOf("3")!=-1||pass.indexOf("4")!=-1||pass.indexOf("5")!=-1||pass.indexOf("6")!=-1||pass.indexOf("7")!=-1||pass.indexOf("8")!=-1||pass.indexOf("9")!=-1){//number test
                if(pass.indexOf("0")==-1&&pass.indexOf("1")==-1&&pass.indexOf("2")==-1&&pass.indexOf("3")==-1&&pass.indexOf("4")==-1&&pass.indexOf("5")==-1&&pass.indexOf("6")==-1&&pass.indexOf("7")==-1&&pass.indexOf("8")==-1&&pass.indexOf("9")==-1) {//alphabet test by "motamammam kardan adadha"
                    /**2.checking length of pass*/
                    while (true) {
                        if (16 >= pass.length() && 8 <= pass.length()) {
                            try {
                                this.pass=pass;
                                FileWriter write=new FileWriter(dirname+"//"+getUserName(),true);
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
    }
    @After
    public String getPass() {
        return pass;
    }
    @Test
    public void signUpTest() throws IOException{
        SignUp signUp=new SignUp();
        signUp.setUserName("hhhesssammm");
        signUp.setPass("hesam1378");
        assertEquals("hhhesssammm",signUp.getUserName());
        assertEquals("hesam1378",signUp.getPass());
    }
}
