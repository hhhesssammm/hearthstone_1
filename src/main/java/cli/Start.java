package cli;

import massage.Warning;
import player.SignIn;
import player.SignUp;

import java.io.IOException;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) throws IOException {
        Warning warning=new Warning();
        System.out.println("already have an account?(y/n)");
        System.out.println("for exit press e");
        Scanner scanner=new Scanner(System.in);
        while (true) {
            String answer=scanner.nextLine();
            if (answer.equals("y")) {
                signIn();
                scanner.close();
                break;
            }
            if (answer.equals("n")) {
                signUp();
                scanner.close();
                break;
            }
            if (answer.equals("e")) {
                break;
            }
            warning.setMassageWrong("press y(YES) or n(NO) and e(EXIT)");
            warning.getMassageWrong();
        }
        scanner.close();
        menu();
    }
    private static void menu(){
        System.out.println("Choose");
        System.out.println("1.delete player ");
        System.out.println("2.collection");
        System.out.println("3.is a hero");
        System.out.println("4.is m hero");
        System.out.println("5.select hero(hero name)");
        System.out.println("6.is a card");
        System.out.println("7.is m card");
        System.out.println("8.is n card");
        System.out.println("9.add [Card’s Name]");
        System.out.println("10.remove [Card’s Name]");
        System.out.println("11.buy [Card’s name]");
        System.out.println("12.wallet");
        System.out.println("13.sell [Card’s name]");
        System.out.println("14.add [Card’s Name]");
        System.out.println("15.add [Card’s Name]");
    }

    private static void signUp() {
        SignUp signUp=new SignUp();
        System.out.println("      signup     ");
        System.out.print("username =");
        System.out.println("");
        System.out.print("password =");
        System.out.println("");
    }

    private static void signIn() throws IOException {
        SignIn signIn=new SignIn();
        System.out.println("      signIp     ");
        System.out.println("input username and pass in deferent line");
    }
}
