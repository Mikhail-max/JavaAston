package Workout.BeytsJava.Charter2.Echo;

public class EchoTestDrive {
    static void main() {
        // результат 10
        Echo e1 = new Echo();
        Echo e2 = new Echo();//в эту строку вставить
        int x = 0;
        while(x < 4){//в эту строку вставить условие
            e1.hello();
            e1.count = e1.count + 1;
            if(x == 3){//в эту строку вставить условие
                e2.count = e2.count + 1;
            }
            if(x > 0){//в эту строку вставить условие
                e2.count = e2.count + e1.count;
            }
            x = x + 1;
        }
        System.out.println(e2.count);

        //результат 24 нельзя получить
    }
}
