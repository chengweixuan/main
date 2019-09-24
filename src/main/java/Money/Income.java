package Money;

import java.util.Date;

public class Income extends Item {
    private Date payday;

    public Income(float price, String description, Date payday) {
        super(price, description);
        this.payday = payday;
    }

    public Date getPayday() {
        return payday;
    }

    @Override
    public String toString() {
        return "[I]" + " " + super.getDescription() + "(salary: $" + super.getPrice() + ") (Paid On: " +
                getPayday() + ")";
    }
}
