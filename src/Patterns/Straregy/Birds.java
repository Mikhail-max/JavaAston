package Patterns.Straregy;

public class Birds {
    private String name;
    private String colour;
    private int year;



    public Birds(){};
    public Birds(String name, String colour, int year){
        super();
        this.name = name;
        this.colour = colour;
        this.year = year;
    }
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Name=").append(name).append(", Colour=").append(colour).append(", Year=").append(year);
        return builder.toString();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    FlyingStrategy flyingStrategy;

    public void setFlyingStrategy (FlyingStrategy flyingStrategy) {
        this.flyingStrategy = flyingStrategy;
    }


    public void fly ( ) {
        flyingStrategy.fly ();
    }

    public void to_eat ( ) {
        System.out.println ("Клюю еду");
    }


}
