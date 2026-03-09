package Patterns.Builder;

import Patterns.Straregy.Birds;

public class BirdsEngineer {
    private BirdsInterface builder;
    public BirdsEngineer(BirdsInterface builder){
        super();
        this.builder = builder;
    }
    public Birds createBirds(String name, String colour, int year){
        return builder.naming_convention(name).color_assignment(colour).years(year).build();
    }
}
