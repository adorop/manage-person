package by.it.academy.adorop.controller.commands;

public class ShowMenuCommand extends Command {

    @Override
    public void execute() {
        println("Please choose command");
        println("1. Save student");
        println("2. Save employee");
        println("3. Save department");
        println("4. Find student");
        println("5. Find employee");
        println("6. Find department");
        println("7. Add employee to department");
        println("8. Delete employee from department");
        println("9. Add address to person");
        println("10. Exit");
        print("Your choice is - ");
    }

    private void println(String message) {
        System.out.println(message);
    }
}
