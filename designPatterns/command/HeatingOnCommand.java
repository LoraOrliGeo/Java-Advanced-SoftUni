package designPatterns.command;

public class HeatingOnCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("Here is so cold... Heating ON");
    }
}
