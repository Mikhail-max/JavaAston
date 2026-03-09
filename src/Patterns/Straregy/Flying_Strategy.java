package Patterns.Straregy;

public class Flying_Strategy implements FlyingStrategy{
    @Override
    public void fly() {
        System.out.println("Полетели");
    }
}
