package Patterns.Straregy;

public class Sparrow extends Birds{
    public Sparrow(){
        super();
        this.flyingStrategy = new Flying_Strategy();
    }

}
