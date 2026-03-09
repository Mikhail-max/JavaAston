package Patterns.Adapter;

import Patterns.Decorator.ChatBotDecorator;
import Patterns.Proxy.ChatBotInterface;

public class AIModuleAdapter extends ChatBotDecorator {
    private AdvancedAIModule aiModule;
    private String language;

    public AIModuleAdapter(ChatBotInterface wrappedBot, AdvancedAIModule aiModule, String language) {
        super(wrappedBot);
        this.aiModule = aiModule;
        this.language = language;
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("[ADAPTER] Преобразуем сообщение для AI‑модуля: '" + message + "'");

        // Преобразуем формат и вызываем AI‑модуль
        String aiResponse = aiModule.processText(message, language);

        // Конвертируем ответ AI в формат нашей системы
        String adaptedResponse = convertAIResponse(aiResponse);

        System.out.println(adaptedResponse);

        // Передаём оригинальное сообщение дальше по цепочке (если нужно)
        wrappedBot.sendMessage(message);
    }

    private String convertAIResponse(String aiResponse) {
        // Простая конвертация: убираем префикс «AI:» и добавляем эмодзи
        return "🤖 " + aiResponse.replace("AI: ", "");
    }
}
