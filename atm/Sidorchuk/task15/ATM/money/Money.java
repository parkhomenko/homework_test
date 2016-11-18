package task15.ATM.money;

public class Money {

    private Nominal nominal;
    private Currency currency;
    private int nominalNumber;

    public Money(Nominal nominal, Currency currency) {
        this.nominal = nominal;
        this.currency = currency;
        nominalNumber = getNominalNumber();
    }

    private int getNominalNumber() {
        switch (nominal) {
            case ONE:
                nominalNumber = 1;
                break;
            case TWO:
                nominalNumber = 2;
                break;
            case FIVE:
                nominalNumber = 5;
                break;
            case TEN:
                nominalNumber = 10;
                break;
            case TWENTY:
                nominalNumber = 20;
                break;
            case FIFTY:
                nominalNumber = 50;
                break;
            case ONEHUNDRED:
                nominalNumber = 100;
                break;
            case TWOHUNDRED:
                nominalNumber = 200;
                break;
            case FIVEHUNDRED:
                nominalNumber = 500;
                break;
        }
        return nominalNumber;
    }

}
