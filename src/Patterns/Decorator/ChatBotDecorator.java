package Patterns.Decorator;

import Patterns.Proxy.ChatBotInterface;

public abstract class ChatBotDecorator implements ChatBotInterface {
    protected ChatBotInterface wrappedBot;

    public ChatBotDecorator(ChatBotInterface wrappedBot) {
        this.wrappedBot = wrappedBot;
    }
}