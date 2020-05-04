package player;
import org.junit.*;

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Log {
    private static final Logger logger = (Logger) LogManager.getLogger(Log.class);
    private String dirname = "sign up";
    private String userName="usernametest1";
    private String pass="hesam1234";
    public void profileTest() throws IOException {
        Profile profile =new Profile();
        profile.setProfile(userName);
        assertEquals(userName,profile.getName());
        logger.info("username is right");
        assertEquals(pass,profile.getPass());
        logger.info("pass is right");
        assertEquals("50",profile.getCoin());
        logger.info("coin is right");
        profile.deleteProfile(userName);
    }
    public void signUpTest() throws IOException {
        SignUp signUp = new SignUp();
        signUp.setUserName(userName);
        assertEquals(userName, signUp.getUserName());
        logger.info("SignUp.username.test is okay: "+userName);
        signUp.setPass(pass);
        assertEquals(pass, signUp.getPass());
        logger.info("SignUp.pass.test is okay: "+pass);
    }
    public void signInTest() throws IOException {
        SignIn signIn = new SignIn();
        assertEquals(true, signIn.inputInfo(userName,pass));
        assertEquals(false, signIn.inputInfo(pass,userName));
        logger.info("signInTest is right");
    }
    @Test
    public void Player_Test() throws IOException {
        signUpTest();
        signInTest();
        profileTest();
        File file = new File(dirname +"/"+ userName);
        if (file.exists() == false){
            logger.info("SignUp.username.test delete: "+userName);
        }
    }
}