package Patterns.Decorator;

import Patterns.Proxy.ChatBotInterface;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CensorChatBotDecorator extends ChatBotDecorator {
    private Set<String> badWords = new HashSet<>(Arrays.asList(
            "дурак", "глупый", "плохой", "ужасный", "некрасивый"
    ));

    public CensorChatBotDecorator(ChatBotInterface wrappedBot) {
        super(wrappedBot);
    }

    @Override
    public void sendMessage(String message) {
        // Фильтруем сообщение перед отправкой
        String filteredMessage = filterMessage(message);
        System.out.println("[CENSOR] Исходное сообщение: '" + message + "' → Отфильтрованное: '" + filteredMessage + "'");

        // Передаём отфильтрованное сообщение дальше
        wrappedBot.sendMessage(filteredMessage);
    }

    private String filterMessage(String message) {
        String[] words = message.split("\\s+");
        StringBuilder filtered = new StringBuilder();

        for (String word : words) {
            // Убираем знаки препинания для проверки
            String cleanWord = word.replaceAll("[^a-zA-Zа-яА-Я]", "").toLowerCase();
            if (badWords.contains(cleanWord)) {
                filtered.append("*** ");
            } else {
                filtered.append(word).append(" ");
            }
        }
        return filtered.toString().trim();
    }
}
