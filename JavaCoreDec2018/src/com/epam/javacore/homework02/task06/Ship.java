package com.epam.javacore.homework02.task06;

public class Ship {
    private String name;

    public Ship(String name) {
        this.name = name;
    }

    public String launch(){
        Ship.Engine engine = this.new Engine(450);
        return engine.startEngine();
    }

    public String getName() {
        return name;
    }

    class Engine{
        private int horsepower;

        public Engine(int horsepower) {
            this.horsepower = horsepower;
        }

        public String startEngine(){
            return Ship.this.getName() + " puts out " + this.getHorsepower() + " horsepower ...";
        }

        public int getHorsepower() {
            return horsepower;
        }
    }
}
