import java.util.Date;

public class Person {

    // attributes of Person
    private static int nextID = 1;
    private int id;
    private String name;
    private Date dateOfBirth;
    private int amountOwed;
    private int totalAccumulated;
    private int gamesJoined;
    private BankAccount bankAccount;

    // constructor
    public Person(String name, Date dateOfBirth, int amountOwed, BankAccount bankAccount) {
        this.id = getNextID();
        this.name = name;
        this.setDateOfBirth(dateOfBirth);
        this.setAmountOwed(amountOwed);
        this.bankAccount = bankAccount;
    }

    // method to override the override what is outputted when System.out.println(person) called
    @Override
    public String toString() {

        // create new person
        String output = "PLAYER INFORMATION\n";
        output += "id : " + this.id + "\n";
        output += "name : " + this.name + "\n";
        output += "age : " + this.getAge() + "\n";
        output += "current balance owed : " + this.amountOwed + "\n=====================";

        return output;
    }

    // method to pay an amount of money to reduce amountOwed
    public void payMoney(int amountPayed) {

        // make sure amountOwed isn't negative after
        if(amountPayed <= amountOwed) {
            // check that the bank account has enough money
            if (bankAccount.getBalance() >= amountPayed) {
                amountOwed -= amountPayed;
                bankAccount.withdraw(amountPayed);
            }
            else {
                System.out.println("Error: not enough money in bank account");
            }
        }
        else {
            System.out.println("Error: cannot pay more than is owed");
        }

    }

    // method to increase balance of a player
    public void increaseBalance(int amountAdded) {
        amountOwed += amountAdded;
        totalAccumulated += amountAdded;
    }

    // calculate the age of the person by working out the difference between current date and DOB
    public int getAge() {
        Date currentDate = new Date();

        // calculate difference between current date and date of birth in milliseconds
        double differenceInMillis = currentDate.getTime() - dateOfBirth.getTime();
        double differenceInYears = differenceInMillis / (365.25*24*60*60*1000);

        // floor the value such that someone only has integer age
        return (int)Math.floor(differenceInYears);

    }

    // method to get next age then increment the global next ID
    public static int getNextID() {
        nextID++;
        return nextID - 1;
    }

    // method to increment the number of games joined
    public void incrementGamesJoined() {
        this.gamesJoined++;
    }

    // getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = getNextID();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        // check if valid date of birth entered
        if (dateOfBirth.before(new Date())) {
            this.dateOfBirth = dateOfBirth;
        }
        else {
            this.dateOfBirth = new Date();
            System.out.println("Error: that date of birth is in the future, date of birth set to current date");
        }
    }

    public int getAmountOwed() {
        return amountOwed;
    }
    public void setAmountOwed(int amountOwed) {
        if(amountOwed >= 0) this.amountOwed = amountOwed;
        else {
            this.amountOwed = 0;
            System.out.println("Error: that amount is less than 0, amount owed set to 0");
        }
    }

    public int getTotalAccumulated() {
        return totalAccumulated;
    }

    public int getGamesJoined() {
        return gamesJoined;
    }
    public void setGamesJoined(int gamesJoined) {
        this.gamesJoined = gamesJoined;
    }
}
