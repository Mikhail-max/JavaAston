package Patterns.Straregy;

public class Hummingbird extends Birds{
    public Hummingbird(){
        super();
        this.flyingStrategy = new Flying_Strategy();
    }
}
