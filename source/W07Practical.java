import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class W07Practical {

    public static void main(String[] args) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Game marioKart = new Game("Mario Kart", 5, 50, 3);
            marioKart.setMaxOwed(1000);
            BankAccount bankAccount = new BankAccount(simpleDateFormat.parse("03-03-2015"), 150);
            Person dave = new Person("Dave", simpleDateFormat.parse("02-04-1999"), 0, bankAccount);

            // have dave play mario kart once
            marioKart.addPlayer(dave);
            marioKart.removePlayer(dave);

            // pay the balance and then print out what's remaining in bank account
            System.out.println("Balance to Pay: " + dave.getAmountOwed());
            dave.payMoney(50);
            System.out.println("Money Left in Bank Account: " + bankAccount.getBalance());

            // have dave play mario kart twice more
            marioKart.addPlayer(dave);
            marioKart.removePlayer(dave);
            marioKart.addPlayer(dave);
            marioKart.removePlayer(dave);

            // pay the balance again and print out what's remaining in bank account
            System.out.println("Balance to Pay: " + dave.getAmountOwed());
            dave.payMoney(100);
            System.out.println("Money Left in Bank Account: "+ bankAccount.getBalance());

            // have dave play the game one more time
            marioKart.addPlayer(dave);
            marioKart.removePlayer(dave);

            // attempt to pay the balance
            System.out.println("Balance to Pay: " + dave.getAmountOwed());
            dave.payMoney(50);
            System.out.println("Money Left in Bank Account " + bankAccount.getBalance());

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}