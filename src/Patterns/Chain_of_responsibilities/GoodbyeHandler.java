package Patterns.Chain_of_responsibilities;

public class GoodbyeHandler extends MessageHandler {
    @Override
    public void handle(String message) {
        if (message.toLowerCase().contains("пока")) {
            System.out.println("GoodbyeHandler: До свидания!");
        } else if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }
}
