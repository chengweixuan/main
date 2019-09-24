package MoneyCommands;

import ControlPanel.Storage;
import ControlPanel.Ui;
import Money.Account;
import Money.Income;

public class ListTotalIncomeCommand extends MoneyCommand{

    public ListTotalIncomeCommand(){
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Account account, Ui ui, Storage storage) {
        int counter = 1;
        for (Income i : account.getIncomeListTotal()) {
            System.out.println(" " + counter + "." + i.toString() + "\n");
            counter++;
        }
        System.out.println("Total income so far: $" + account.getTotalIncome());
    }
}
