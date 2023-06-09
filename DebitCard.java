/**
 * The DebitCard class has four attributes: int Pin_Number,  int Withdrawal_Amount, String Date_Of_Withdrawal, boolean Has_Withdrawn
* The constructor accepts six parameters. The values of those parameter are assign
the corresponding parameter values.
* Each attribute has a corresponding accessor method and setWithdrawal_Amount which accepts int Withdrawal_Amount as Setters Method and 
* Withdraw method
* Then finally display the all attributes values. Hence DebitCard is child class of BankCard
 * @author (22067061 Anubhav Ratna Dhakal)
 * @version (5.1.0)
 */
public class DebitCard extends BankCard
{
    //attributes:
 private int Pin_Number;//The private access modifier is used to create a variable with the name Pin_Number with int data type.
 private int Withdrawal_Amount;//The private access modifier is used to create a variable with the name Withdrawal_Amount with int data type.
 private String Date_Of_Withdrawal;//The private access modifier is used to create a variable with the name Date_Of_Withdrawal with String data type.
 private boolean Has_Withdrawn;//The private access modifier is used to create a variable with the name Has_Withdrawn with boolean data type.
    
 
 /*The constructor of this class accepts six inputs with the corresponding data types: Balance_Amount, Card_Id, Issuer_Bank, Bank_Account
 * Client_Name,and Pin_Number. The instance variable values are then initialized in 
 * accordance with the parameter values.
  */
public DebitCard(double Balance_Amount, int Card_Id, String Bank_Account, String Issuer_Bank, String Client_Name, int Pin_Number)
{
    //calling constructor using SuperClass i.e. BankCard
    super(Issuer_Bank,Card_Id,Balance_Amount,Bank_Account);
    //calling setter method of superclass
    super.setClient_Name(Client_Name);
    this.Pin_Number=Pin_Number;
    this.Has_Withdrawn=false;
    
}

//Getter Method| Accessor Method
/*  Each attribute, such as Pin_Number, Withdrawal_Amount, Date_Of_Withdrawal, and Has_Withdrawn, 
 * has an accessor method with a return type that matches the data type of the instance variables.
 *The access modifiers of the accessor methods are public
 */
public int getPin_Number()
{
    return this.Pin_Number;//returns the value of instance variable Pin_Number
}
public int getWithdrawal_Amount()
{
    return this.Withdrawal_Amount;//returns the value of instance variable Withdrawal_Amount
}
public String getDate_Of_Withdrawal()
{
    return this.Date_Of_Withdrawal;//returns the value of instance variable Date_Of_Withdraw
}
public boolean getHas_Withdrawn()
{
    return this.Has_Withdrawn;//returns the value of instance variable Has_Withdrawn
}

//Mutator Method | Setters Method
/*It accepts the value of a single parameter (int Withdrawal Amount) 
 * and assigns it into the instance variable Withdrawal Amount 
 */
public void setWithdrawal_Amount(int Withdrawal_Amount)
{
    this.Withdrawal_Amount=Withdrawal_Amount;
}

//Withdraw Method:
/*It accepts three parameters: 
 * int Withdrawal_Amount, string Date_Of_Withdrawal, and 
 * int Pin_Number, and if all requirements are met,then withdraws money,
 * and displays desirable output.
 */
public void withdraw(int Withdrawal_Amount, String Date_Of_Withdrawal, int Pin_Number)
{
    //checking Pin_Number validation
    if(this.Pin_Number == Pin_Number) {
            //checking enough Balance_Amount
            if(Withdrawal_Amount <= super.getBalance_Amount()) {
                //deduct the withdrawal amount from Balance_Amount
                super.setBalance_Amount(super.getBalance_Amount()-Withdrawal_Amount);
                this.Has_Withdrawn = true;
                this.Date_Of_Withdrawal = Date_Of_Withdrawal;
                this.Withdrawal_Amount = Withdrawal_Amount;
                System.out.println("Transaction successful!");
                System.out.println(Withdrawal_Amount+" has been deducted from your Bank Account.");
                System.out.println("Your new Balance Amount is:"+super.getBalance_Amount());
            }
            else {
                System.out.println("Insufficient Balance Amount!!!");
                System.out.println("Your Balance amount is: "+super.getBalance_Amount());
            }
        }
        else {                                                                                              
            System.out.println("Invalid PIN number");
        }
    }
    
    //Display Method:
    /*
     * It displays full card information and, if Has_Withdrawn is true,
     *displays withdrawal information; otherwise, only Balance_Amount is displayed. 
     */
    public void display()
    {
        //calling display method of superclass
        super.display();
        if(this.Has_Withdrawn) {
            System.out.println("PIN number: "+this.Pin_Number);
            System.out.println("Withdrawal Amount: "+this.Withdrawal_Amount);
            System.out.println("Date Of Withdrawal: "+this.Date_Of_Withdrawal);
        }
        else { 
            System.out.println("Balance Amount: "+super.getBalance_Amount());
        }
    }
}
