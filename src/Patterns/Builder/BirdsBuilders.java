package Patterns.Builder;

import Patterns.Straregy.Birds;

public class BirdsBuilders implements BirdsInterface {

    private String name;
    private String colour;
    private int year;

    @Override
    public BirdsInterface naming_convention(String name) {
        this.name = name;
        return this;
    }

    @Override
    public BirdsInterface color_assignment(String colour) {
        this.colour = colour;
        return this;
    }

    @Override
    public BirdsInterface years(int year) {
        this.year = year;
        return this;
    }


    @Override
    public Birds build() {
        Birds birds = new Birds(name, colour, year);
        return birds;
    }
}
