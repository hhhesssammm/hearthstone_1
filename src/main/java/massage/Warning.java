package massage;
/**
 @author Hesamaldin Bagheri
 */
public class Warning {
    Stop stop=new Stop();
    private String massageWrong;
    public String getMassageWrong() {
        stop.stopping();
        System.out.println(massageWrong);
        return massageWrong;
    }
    public void setMassageWrong(String massageWrong) {
        this.massageWrong = massageWrong;
    }
}
