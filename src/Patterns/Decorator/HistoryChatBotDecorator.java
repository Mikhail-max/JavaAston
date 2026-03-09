package Patterns.Decorator;

import Patterns.Decorator.ChatBotDecorator;
import Patterns.Proxy.ChatBotInterface;

import java.util.ArrayList;
import java.util.List;

public class HistoryChatBotDecorator extends ChatBotDecorator {
    private List<String> messageHistory = new ArrayList<>();

    public HistoryChatBotDecorator(ChatBotInterface wrappedBot) {
        super(wrappedBot);
    }

    @Override
    public void sendMessage(String message) {
        // Сохраняем входящее сообщение в историю
        messageHistory.add("ВХОД: " + message);

        // Делегируем обработку реальному объекту
        wrappedBot.sendMessage(message);

        // После обработки получаем ответ (это упрощённая логика — в реальности нужно перехватывать вывод)
        // В данном случае мы просто отмечаем факт обработки
        messageHistory.add("ВЫХОД: Обработано");
    }

    // Метод для получения истории
    public List<String> getHistory() {
        return new ArrayList<>(messageHistory);
    }

    // Метод для вывода истории в консоль
    public void printHistory() {
        System.out.println("\n=== ИСТОРИЯ СООБЩЕНИЙ ===");
        for (String entry : messageHistory) {
            System.out.println(entry);
        }
    }
}
