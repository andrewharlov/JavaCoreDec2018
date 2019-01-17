package com.epam.javacore.homework02.task06;

/**
 * This class represents a ship
 * @author Andrei Kharlov
 * @version 1.0
 */
public class Ship {
    /**name String This is a String that holds a name of a ship*/
    private String name;

    /**
     * Constructor for a ship
     * @param name This is a name of a ship
     */
    public Ship(String name) {
        this.name = name;
    }

    /**
     * Launches a ship
     * @return String This is a message from a running engine
     */
    public String launch(){
        Ship.Engine engine = this.new Engine(450);
        return engine.startEngine();
    }

    /**
     * Returns a ship's name
     * @return String This is a name of a ship
     */
    public String getName() {
        return name;
    }

    /**
     * This class represents a ship's engine
     * @author Andrei Kharlov
     * @version 1.0
     */
    class Engine{
        /**horsepower int This is an int that holds a horsepower number*/
        private int horsepower;

        /**
         * Constructor for an engine
         * @param horsepower This is an engine's amount of horsepower
         */
        public Engine(int horsepower) {
            this.horsepower = horsepower;
        }

        /**
         * Starts an engine
         * @return String This is a message from a running engine
         */
        public String startEngine(){
            return Ship.this.getName() + " puts out " + this.getHorsepower() + " horsepower ...";
        }

        /**
         * Returns a horsepower of an engine
         * @return int This is a horsepower of an engine
         */
        public int getHorsepower() {
            return horsepower;
        }
    }
}
