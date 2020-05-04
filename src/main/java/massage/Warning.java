package massage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import player.SignUp;

/**
 @author Hesamaldin Bagheri
 */
public class Warning {
    private static final Logger logger = (Logger) LogManager.getLogger(Warning.class);
    Stop stop=new Stop();
    private String massageWrong;
    public String getMassageWrong() {
        stop.stopping();
        logger.warn(massageWrong);
        return massageWrong;
    }
    public void setMassageWrong(String massageWrong) {
        this.massageWrong = massageWrong;
    }
}
