package Patterns;

import Patterns.Adapter.AIModuleAdapter;
import Patterns.Adapter.AdvancedAIModule;
import Patterns.Builder.BirdsBuilders;
import Patterns.Builder.BirdsEngineer;
import Patterns.Builder.BirdsInterface;
import Patterns.Chain_of_responsibilities.*;
import Patterns.Decorator.CensorChatBotDecorator;
import Patterns.Decorator.HistoryChatBotDecorator;
import Patterns.Proxy.ChatBot;
import Patterns.Proxy.ChatBotInterface;
import Patterns.Proxy.SecureChatBotProxy;
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
        //Реализовываем Цепочку обязанностей +Прокси+Декоратор+Адаптер на основе условного чат бота

        MessageHandler emojiHandler = new EmojiHandler();
        MessageHandler greetingHandler = new GreetingHandler();
        MessageHandler goodbyeHandler = new GoodbyeHandler();
        MessageHandler defaultHandler = new DefaultHandler();

        emojiHandler.setNext(greetingHandler);
        greetingHandler.setNext(goodbyeHandler);
        goodbyeHandler.setNext(defaultHandler);


        ChatBot realChatBot = new ChatBot(emojiHandler);


        SecureChatBotProxy proxyChatBot = new SecureChatBotProxy(realChatBot);


        AdvancedAIModule externalAIModule = new AdvancedAIModule();


        ChatBotInterface decoratedBot = new HistoryChatBotDecorator(
                new CensorChatBotDecorator(
                        new AIModuleAdapter(proxyChatBot, externalAIModule, "ru")
                )
        );

        System.out.println("=== Тестирование чат‑бота с Proxy, Decorators и Adapter ===");


        decoratedBot.sendMessage("привет, как дела?");

        System.out.println("\n--- Авторизация ---");
        proxyChatBot.authorize("secret123"); // Верный пароль

        System.out.println("\n--- Отправка сообщений после авторизации ---");
        decoratedBot.sendMessage(":)");
        decoratedBot.sendMessage("пока, глупый человек!");
        decoratedBot.sendMessage("что думаешь об этом?");

        if (decoratedBot instanceof HistoryChatBotDecorator) {
            ((HistoryChatBotDecorator) decoratedBot).printHistory();
        }

    }
}
