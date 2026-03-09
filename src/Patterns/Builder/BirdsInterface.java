package Patterns.Builder;

import Patterns.Straregy.Birds;

public interface BirdsInterface {
    public BirdsInterface naming_convention(String name);
    public BirdsInterface color_assignment(String colour);
    public BirdsInterface years(int year);
    public Birds build();
}
