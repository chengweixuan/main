package moneycommands;

import controlpanel.MoneyStorage;
import money.Account;
import money.BankTracker;
import controlpanel.Parser;
import controlpanel.Storage;
import controlpanel.Ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CreateBankAccountCommand extends MoneyCommand {

    private BankTracker newTracker;

    public CreateBankAccountCommand(String inputString) throws ParseException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        String desc = inputString.split(" /amt ")[0];
        String info = inputString.split(" /amt ")[1];
        desc = desc.replaceFirst("bank-account ","");
        String[] words = info.split(" ");
        LocalDate initialDate = Parser.shortcutTime(words[2]);
        newTracker = new BankTracker(desc, Integer.parseInt(words[0]),
                initialDate, Double.parseDouble(words[4]));
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Account account, Ui ui, MoneyStorage storage) {
        account.getBankTrackerList().add(newTracker);
        ui.appendToOutput("New bank account tracker has been added to the list: \n");
        ui.appendToOutput(newTracker.getBankAccountInfo() + "\n");
    }
}