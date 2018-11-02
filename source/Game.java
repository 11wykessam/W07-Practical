import java.util.ArrayList;

public class Game {

    // attributes of Game
    private static int nextID = 1;
    private int id;
    private String name;
    private int minimumAge;
    private int fee;
    private int maxOwed = 1000;

    private ArrayList<Person> currentPlayers = new ArrayList<>();
    private int maximumPlayers;

    // constructor
    public Game(String name, int minimumAge, int fee, int maximumPlayers) {
        this.id = getNextID();
        this.name = name;
        this.setMinimumAge(minimumAge);
        this.setFee(fee);
        this.setMaximumPlayers(maximumPlayers);
    }

    // method to add a player to the game
    public void addPlayer(Person person) {
        // first check if the player is old enough to play the game
        if (person.getAge() >= minimumAge) {

            // check if the number of players currently playing is below the maximum
            if (currentPlayers.size() < maximumPlayers) {

                // check that the player is not already in the game
                if (!currentPlayers.contains(person)) {

                    // check the person has not joined more than 100 games.
                    if (person.getGamesJoined() < 100) {

                        // check if the person doesn't owe more than the maximum allowed by this game
                        if (person.getAmountOwed() <= maxOwed) {
                            // add the person to the list of players
                            currentPlayers.add(person);
                            // increase the players balance by the fee of game
                            person.increaseBalance(this.fee);
                            // increment the number of games the person has played
                            person.incrementGamesJoined();
                        }
                        // output an error
                        else {
                            System.out.println("Error: person owes more than is allowed for this game");
                        }

                    }
                    // output an error message informing the user that the person has joined more than 100 games
                    else {
                        System.out.println("Error: person has joined 100 games, limit has been reached");
                    }

                }
                // output an error message saying that the player can't appear twice
                else {
                    System.out.println("Error: player number " + person.getId() + " is already in the game");
                }

            }
            // output an error message is too many players are in the game
            else {

                System.out.println("Error: only " + maximumPlayers + " can play this game at any one time");

            }

        }
        // output an error message if the player is too young to play
        else {

            System.out.println("Error: player too young to play this game");

        }
    }

    // method to remove a player from the game
    public void removePlayer(Person person) {
        // check if the person is playing the game
        if (currentPlayers.contains(person)) {
            currentPlayers.remove(person);
        }
        // otherwise output error message
        else {
            System.out.println("Error: player number " + person.getId() + " is not in this game");
        }
    }

    // method that overrides what is outputted when System.out.println(game) is called
    @Override
    public String toString() {

        // create an empty string to append information to
        String output = "GAME INFORMATION\n";
        output += "id : " + this.id + "\n";
        output += "name : " + this.name + "\n";
        output += "minimum age : " + this.minimumAge + "\n";
        output += "fee : " + this.fee + "\n";
        output += "number of players in game : " + this.currentPlayers.size() + "\n";
        output += "players : ";

        // loop through players printing names
        for(Person person : currentPlayers) {
            output += person.getName() + " ";
        }
        output += "\n=====================";

        return output;

    }

    // method to get next age then increment the global next ID
    public static int getNextID() {
        nextID++;
        return nextID - 1;
    }

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

    public int getMinimumAge() {
        return minimumAge;
    }
    public void setMinimumAge(int minimumAge) {
        if (minimumAge >= 0) this.minimumAge = minimumAge;
        else {
            this.minimumAge = 0;
            System.out.println("Error: minimum age cannot be less than 0, minimum age has been set to 0");
        }
    }

    public int getFee() {
        return fee;
    }
    public void setFee(int fee) {
        if(fee >= 0) this.fee = fee;
        else {
            this.fee = 0;
            System.out.println("Error: fee cannot be less than 0, fee has been set to 0");
        }
    }

    public int getMaximumPlayers() {
        return maximumPlayers;
    }
    public void setMaximumPlayers(int maximumPlayers) {
        if(maximumPlayers >= 1) this.maximumPlayers = maximumPlayers;
        else {
            this.maximumPlayers = 2;
            System.out.println("Error: the max number of players for a game cannot be less than one, it has been set to 2");
        }
    }

    public int getMaxOwed() {
        return maxOwed;
    }
    public void setMaxOwed(int maxOwed) {
        if (maxOwed > 0) {
            this.maxOwed = maxOwed;
        }
    }
}
