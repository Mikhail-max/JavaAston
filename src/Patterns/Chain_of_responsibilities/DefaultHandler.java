package Patterns.Chain_of_responsibilities;

public class DefaultHandler extends MessageHandler {
    @Override
    public void handle(String message) {
        System.out.println("DefaultHandler: Не понял ваше сообщение");
    }
}
