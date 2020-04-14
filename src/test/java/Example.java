public class Example {

    public static void main(String[] args) {
        // Your amazing code goes here...
        System.out.println("We are making a new PEZ Dispenser");
        PezDispenser dispenser = new PezDispenser("Donatello");

        System.out.printf("The dispenser is %s %n",
                dispenser.getCharacterName()
        );

        if(dispenser.isEmpty()) {
            System.out.println("Dispenser is empty");
        }
        System.out.println("Filling the dispenser with pez");
        dispenser.fill();
        if(!dispenser.isEmpty()) {
            System.out.println("Dispenser is full");
        }
        while (dispenser.dispense()) {
            System.out.println("Chomp");
        }

    }
