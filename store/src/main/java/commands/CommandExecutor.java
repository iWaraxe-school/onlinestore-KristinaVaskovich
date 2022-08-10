package commands;

public class CommandExecutor {
    private Command chooseCommand;

    public void setCommand(Command command) {
        chooseCommand = command;
    }

    public void execute(){
        chooseCommand.execute();
    }
}
