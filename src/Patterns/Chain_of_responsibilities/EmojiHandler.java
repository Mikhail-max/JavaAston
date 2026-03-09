package Patterns.Chain_of_responsibilities;

public class EmojiHandler extends MessageHandler {
    @Override
    public void handle(String message) {
        if (message.equals(":)") || message.equals(":(")) {
            String response = message.equals(":)") ? "😊" : "😢";
            System.out.println("EmojiHandler: " + response);
        } else if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }
}
