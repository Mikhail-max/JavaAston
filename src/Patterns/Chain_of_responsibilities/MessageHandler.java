package Patterns.Chain_of_responsibilities;

public abstract class MessageHandler {
    protected MessageHandler nextHandler;

    public void setNext(MessageHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handle(String message);
}
