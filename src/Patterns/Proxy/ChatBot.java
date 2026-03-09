package Patterns.Proxy;

import Patterns.Chain_of_responsibilities.MessageHandler;

public class ChatBot implements ChatBotInterface {
    private MessageHandler firstHandler;

    public ChatBot(MessageHandler firstHandler) {
        this.firstHandler = firstHandler;
    }

    @Override
    public void sendMessage(String message) {
        firstHandler.handle(message);
    }
}
