package command;

public class CommandExecutor {
    private Command chooseSortingCommand;

    public void setCommand(Command command) {
        chooseSortingCommand = command;
    }

    public void printSortedProducts(){
        chooseSortingCommand.execute();
    }
}
