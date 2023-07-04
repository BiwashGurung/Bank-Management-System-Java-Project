package coursework;

public class CreditCard extends coursework.BankCard {
    //declaring the variables
    private int cvcNumber;//int that represents cvcNumber
    private double creditLimit;//double that store decimal number of creditLimit
    private double interestRate;//double that store decimal number of interestRate
    private String expirationDate;//String values that displays the expirationDate
    private int gracePeriod;//int that represents gracePeriod
    private boolean isGranted;//boolean that state true or false values

    //This is a constructor that accepts eight parameters to set the attribute values of the variables.
    public CreditCard(int cardId , String issuerBank, String bankAccount, String clientName, int cvcNumber, double interestRate, String expirationDate, double balanceAmount)
    {
        //calling the constructor from the parent(super) class
        super(cardId, issuerBank, bankAccount, balanceAmount);
        super.setClientName(clientName);//calling from the super(parent)class

        //this refers the instace variables
        this.cvcNumber = cvcNumber;//refers the instace variables of cvcNumber
        this.interestRate = interestRate;//refers the instace variable of interestRate
        this.expirationDate = expirationDate;//refers the instace variable of expirationDate
        this.isGranted = false;//refers the instace variable
    }

    //using the accessor(getter) method for cvcNumber
    public int getCVCNumber()
    {
        return cvcNumber;
    }

    //using the accessor(getter) method for creditLimit
    public double getCreditLimit()
    {
        return creditLimit;
    }

    //using the accessor(getter) method for interestRate
    public double getInterestRate()
    {
        return interestRate;
    }

    //using the accessor(getter) method for expirationDate
    public String getExpirationDate()
    {
        return expirationDate;
    }

    //using the accessor(getter) method for gracePeriod
    public int getGracePeriod()
    {
        return gracePeriod;
    }

    //using the accessor(getter) method for isGranted
    public boolean getIsGranted()
    {
        return isGranted;
    }

    //using the mutator(setter) method for the creditLimit
    public void setCreditLimit(double newCreditLimit, int newGracePeriod)
    {
        if (newCreditLimit <= (2.5 * super.getBalanceAmount())) {
            creditLimit = newCreditLimit;
            gracePeriod = newGracePeriod;
            isGranted = true;
        }
        else{
            System.out.println("The credit cannot be issued. Credit Limit should be less than or equal to 2.5 times the amount of balance.");
        }
    }

    //This is a method for cancelCreditCard
    public void cancelCreditCard() {
        cvcNumber = 0;
        creditLimit = 0;
        gracePeriod = 0;
        isGranted = false;
    }

    //This is a method to display the details of the Credit Card using if else condition
    protected void display()
    {
        super.display();//(SuperClass(BankCard)
        System.out.println("The CVC Number is : " + cvcNumber);
        System.out.println("The interest rate is : " + interestRate);
        System.out.println("The expiration Date is : " + expirationDate);
        if (isGranted == true){

            System.out.println("The Credit Limit is : " + creditLimit);
            System.out.println("The grace period is : " + gracePeriod);
        }else {
            System.out.println("Your Credit Limit and Grace Period cannot be displayed. Your Credit has not been granted.");
        }
    }

}