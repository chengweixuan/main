package MoneyCommands;

import ControlPanel.Storage;
import ControlPanel.Ui;
import Money.Account;
import Money.Expenditure;
import Money.Income;

public class ListTotalExpenditureCommand extends MoneyCommand{

    public ListTotalExpenditureCommand(){
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Account account, Ui ui, Storage storage) {
        int counter = 1;
        for (Expenditure i : account.getExpListTotal()) {
            System.out.println(" " + counter + "." + i.toString() + "\n");
            counter++;
        }
        System.out.println("Total income so far: $" + account.getTotalExp());
    }
}
