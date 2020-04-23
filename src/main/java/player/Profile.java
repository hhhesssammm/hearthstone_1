package player;



import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;

public class Profile {

    /**
     * @param coin is saved coin
     * @param dirname is file location
     */
    private String userName;
    private String userPass;
    private String coin;
    private String dirname = "c:/sign up";
    /**for set a profile*/
    public void setProfile(final String name) throws IOException {
        /**https://www.tutorialspoint.com/ this is source*/
        File dir = new File(dirname);
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept (File dir, String letter) {
                return letter.equals(name);
            }
        };
        String[] children = dir.list(filter);
        if (children == null) {
            System.out.println("Either dir does not exist or is not a directory");
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
                    this.userName=string.substring(string.indexOf(" = ")+3);
                }
                if(i==1){
                    String string = sc.nextLine();
                    this.userPass=string.substring(string.indexOf(" = ")+3);
                }
                if(i==2){
                    String string = sc.nextLine();
                    this.coin=string.substring(string.indexOf(" = ")+3);
                }
            }
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