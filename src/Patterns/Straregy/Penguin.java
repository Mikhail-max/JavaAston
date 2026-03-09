package Patterns.Straregy;

public class Penguin extends Birds{
    public Penguin(){
        super();
        this.flyingStrategy = new Flightless_Strategy();
    }
}
