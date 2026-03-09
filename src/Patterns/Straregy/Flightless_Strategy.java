package Patterns.Straregy;

public class Flightless_Strategy implements FlyingStrategy{
    @Override
    public void fly() {
        System.out.println("Данная птичка не может летать");
    }
}
