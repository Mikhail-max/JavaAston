package Workout.BeytsJava.Charter1;

//a-b c-d
public class Shuffle1 {
    static void main() {
        int x = 3;
        if (x > 2) {
            System.out.print("a");
        }

        while (x > 0) {
            x = x - 1;
            System.out.print("-");
            if (x == 1) {
                System.out.print("d");
                x = x - 1;
            }

            if (x == 2) {
                System.out.print("b c");
            }

        }
    }
}


