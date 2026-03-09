package Patterns.Proxy;

import java.util.Date;

public class SecureChatBotProxy implements ChatBotInterface {
    private ChatBotInterface realChatBot;
    private boolean isAuthorized;

    public SecureChatBotProxy(ChatBotInterface realChatBot) {
        this.realChatBot = realChatBot;
        this.isAuthorized = false; // По умолчанию не авторизован
    }

    // Метод для авторизации пользователя
    public void authorize(String password) {
        // Простая проверка пароля (в реальности — более сложная логика)
        if ("secret123".equals(password)) {
            isAuthorized = true;
            System.out.println("[" + new Date() + "] Пользователь авторизован успешно");
        } else {
            System.out.println("[" + new Date() + "] Ошибка авторизации: неверный пароль");
        }
    }

    @Override
    public void sendMessage(String message) {
        // Логирование входящего сообщения
        System.out.println("[" + new Date() + "] ВХОДЯЩЕЕ СООБЩЕНИЕ: " + message);

        // Проверка авторизации
        if (!isAuthorized) {
            System.out.println("[" + new Date() + "] ОШИБКА: Пользователь не авторизован");
            System.out.println("Для отправки сообщений авторизуйтесь командой: /auth <пароль>");
            return;
        }

        // Делегирование реальному объекту
        realChatBot.sendMessage(message);

        // Логирование успешного ответа
        System.out.println("[" + new Date() + "] СООБЩЕНИЕ ОБРАБОТАНО");
    }
}
