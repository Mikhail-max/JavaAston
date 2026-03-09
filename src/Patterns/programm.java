package Patterns;

import Patterns.Builder.BirdsBuilders;
import Patterns.Builder.BirdsEngineer;
import Patterns.Builder.BirdsInterface;
import Patterns.Chain_of_responsibilities.*;
import Patterns.Straregy.*;

public class programm {
    public static void main() {
        //Реализовываем паттерн Стратегии,
        // создали 2 стратегии поведения для птиц, которые могут летать и для тех,
        // кто летать не может
        Sparrow sparrow = new Sparrow();
        Hummingbird hummingbird = new Hummingbird();
        Penguin penguin = new Penguin();
        hummingbird.fly();
        penguin.fly();
        sparrow.fly();
        //Сделал возможность изменить стратегию в процессе,
        // вдруг воробей сломает крыло и уже не сможет летать
        sparrow.setFlyingStrategy(new Flightless_Strategy());
        sparrow.fly();
        //Реализовываем Билдер
        BirdsInterface builder = new BirdsBuilders();
        BirdsEngineer engineer = new BirdsEngineer(builder);
        Birds birds = engineer.createBirds("Kokosik", "Blue", 4);
        System.out.println(birds);
        //Реализовываем Цепочку обязанностей

        MessageHandler emojiHandler = new EmojiHandler();
        MessageHandler greetingHandler = new GreetingHandler();
        MessageHandler goodbyeHandler = new GoodbyeHandler();
        MessageHandler defaultHandler = new DefaultHandler();

        emojiHandler.setNext(greetingHandler);
        greetingHandler.setNext(goodbyeHandler);
        goodbyeHandler.setNext(defaultHandler);


        System.out.println("=== Тестирование чат‑бота ===");
        emojiHandler.handle(":)");           // Обработает EmojiHandler
        emojiHandler.handle("привет!");       // Обработает GreetingHandler
        emojiHandler.handle("пока!");        // Обработает GoodbyeHandler
        emojiHandler.handle("как дела?");   // Обработает DefaultHandler
        emojiHandler.handle(":(");           // Обработает EmojiHandler

        //Реализовываем Прокси

    }
}
