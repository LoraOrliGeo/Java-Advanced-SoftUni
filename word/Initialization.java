package java_advanced.polymorphism.word;

public class Initialization {
    // creating static method that returns CommandInterface instance - because of the code provided in Main
    public static CommandInterface buildCommandInterface(StringBuilder text) {
        CommandInterface commandInterface = new CommandImpl(text);
        commandInterface.init();
        return commandInterface;
    }
}
