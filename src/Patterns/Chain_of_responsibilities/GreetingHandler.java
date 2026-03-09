package Patterns.Chain_of_responsibilities;

public class GreetingHandler extends MessageHandler {
    @Override
    public void handle(String message) {
        if (message.toLowerCase().contains("привет")) {
            System.out.println("GreetingHandler: Привет! Рад вас видеть!");
        } else if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }
}
