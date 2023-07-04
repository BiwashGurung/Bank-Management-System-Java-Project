package coursework;

public class DebitCard extends coursework.BankCard {
    //declaring the variables
    private int PIN;//int that represents the PIN
    private int withdrawalAmount;//int that represents the withdrawalAmount
    private String dateOfWithdrawal;//String values that displays the dateOfWithdrawal
    private boolean hasWithdrawn;//boolean that state true or false value

    //this is a constructor that accepts six parameters to set the attributes value of the variables
    public DebitCard(double balanceAmount, int cardId, String bankAccount, String issuerBank, String clientName, int PIN){
        //calling the constructor from the super(parent)class
        super(cardId, issuerBank, bankAccount,balanceAmount);//calling the super(parent) class constructor
        super.setClientName(clientName);//calling the mutator(setter) method from super(parent) class
        //refers to the instance variable
        this.PIN=PIN;//refers to the instance variable of PIN
        this.hasWithdrawn=false;//refers to the instance variable
    }
    //using the accessor(getter) method for pinNumber
    public int getPIN(){
        return PIN;
    }
    //using the accessor(getter) method for withdrawalAmount
    public int getWithdrawalAmount(){
        return withdrawalAmount;
    }
    //using the accessor(getter) method for dateOfWithdrawal
    public String getDateOfWithdrawal(){
        return dateOfWithdrawal;
    }
    //using accessor(getter) method for hasWithdrawn
    public boolean getHasWithdrawn(){
        return hasWithdrawn;
    }
    //using the mutator(setter) method for withdrawal
    protected void setWithdrawalAmount(int withdrawalAmount)
    {
        this.withdrawalAmount=withdrawalAmount;
    }
    //This is a method for withdraw
    public void withdraw(int withdrawalAmount, String dateOfWithdrawal, int PIN){
        if(this.PIN==PIN){
            if(super.getBalanceAmount()>=withdrawalAmount){
                hasWithdrawn = true;
                super.setBalanceAmount(super.getBalanceAmount() - withdrawalAmount);
                this.dateOfWithdrawal = dateOfWithdrawal;
                this.withdrawalAmount = withdrawalAmount;
            }
            else{
                System.out.println("Insufficient Balance");
            }
        }
        else{
            System.out.println("Invalid PIN number!");
        }
    }
    //This is display method using if, else condition
    protected void display(){
        super.display();//SuperClass(BankCard)
        System.out.println("PIN Number : "+this.PIN);
        if(hasWithdrawn=true)
        {
            System.out.println("Amount of withdrawal : " + this.withdrawalAmount);
            System.out.println("Date Of Withdrawal: " + this.dateOfWithdrawal);
        }
        else{
            System.out.println("Balance Amount: " + super.getBalanceAmount());
        }
    }
}