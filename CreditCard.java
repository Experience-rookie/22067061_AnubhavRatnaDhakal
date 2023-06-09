/**
 * The CreditCard class has six attributes: int Cvc_Number, double Credit_Limit, double Interest_Rate,
 * String Expiration_Date, int Grace_Period and boolean Is_Granted
* The constructor accepts eight parameters. The values of those parameter are assign
the corresponding parameter values.
* Each attribute has a corresponding accessor method and setCredit_Limit as setter methods which
* accepts double Credit_Limit and int Grace_Period
* Similarly we have cancleCreditCard method which sets value of Cvc_Number, Credit_Limit,
* Grace_Period and Is_Granted to false
* Then finally display the all attributes values.Hence CreditCard is child class of BankCard
 * @author (22067061 Anubhav Ratna Dhakal)
 * @version (5.1.0)
 */

public class CreditCard extends BankCard
{
    //attributes:
    private int Cvc_Number;//The private access modifier is used to create a variable with the name Cvc_Number with int data type.
    private double Credit_Limit;//The private access modifier is used to create a variable with the name Credit_Limit with double data type.
    private double Interest_Rate;//The private access modifier is used to create a variable with the name Interest_Rate with double data type.
    private String Expiration_Date;//The private access modifier is used to create a variable with the name Expiration_Date with String data type.
    private int Grace_Period;//The private access modifier is used to create a variable with the name Grace_Period with int data type.
    private boolean Is_Granted;//The private access modifier is used to create a variable with the name Is_Granted with boolean data type.
    
    
/*The constructor of this class accepts eight inputs with the corresponding data types: Client_Name, Card_Id, Issuer_Bank, Bank_Account
* Balance_Amount,Cvc_Number, Interest_Rate and Expiration_Date.
*  The instance variable values are then initialized in 
* accordance with the parameter values.
*/
    public CreditCard(String Client_Name, int Card_Id, String Issuer_Bank, String Bank_Account, double Balance_Amount,int Cvc_Number, double Interest_Rate,String Expiration_Date)
    {
        //calling superclass constructor method
        super(Issuer_Bank,Card_Id,Balance_Amount,Bank_Account);
        //calling setter method of superclass
        super.setClient_Name(Client_Name);
        this.Cvc_Number=Cvc_Number;
        this.Interest_Rate=Interest_Rate;
        this.Expiration_Date=Expiration_Date;
        this.Is_Granted=false;
    }
    
    
     /*Getters Method | Accessor Method
      * Each attribute, such as Cvc_Number, Credit_Limit, Interest_Rate,Expiration_Date,Grace_Period and Is_Granted 
     * has an accessor method with a return type that matches the data type of the instance variables.
     *The access modifiers of the accessor methods are public
      */
    
     public int getCvc_Number()
    {
        return this.Cvc_Number;//returns the value of instance variable Cvc_Number
    }
    public double getCredit_Limit()
    {
        return this.Credit_Limit;//returns the value of instance variable Credit_Limit
    }
    public double getInterest_Rate()
    {
        return this.Interest_Rate;//returns the value of instance variable Interest_Rate
    }
    public String getExpiration_Date()
    {
        return this.Expiration_Date;//returns the value of instance variable Expiration_Date
    }
    public int getGrace_Period()
    {
        return this.Grace_Period;//returns the value of instance variable Grace_Period
    }
    public boolean getIs_Granted()
    {
        return this.Is_Granted;//returns the value of instance variable Is_Granted
    }
    
    /*Setters Method | Mutator Method
     * It receives two inputs (double Credit_Limit, int Grace_Period),
     * and then determines whether or not the Credit_Limit can be assigned .
     */
    
    public void setCreditLimit(double Credit_Limit,int Grace_Period)
    {
        //checking credit_Limit either less or equal to 2.5 times of balance_Amount
        if(Credit_Limit <= (2.5*super.getBalance_Amount())) {
            this.Credit_Limit = Credit_Limit;
            this.Grace_Period = Grace_Period;
            this.Is_Granted = true;
        }
        else {
            System.out.println("The credit cannot be issued.");
            System.out.println("You can have maximum credit of: "+(2.5*super.getBalance_Amount()));
        }
    }
    
    
    /*cancleCreditCard Method:
     * Cancels Credit Card and assigns the value of Cvc_Number,Credit_Limit,
     * Grace_Period to 0 and Is_Granted as false.
     */
    
     public void cancleCreditCard()
    {
        this.Cvc_Number = 0;
        this.Credit_Limit = 0;
        this.Grace_Period = 0;
        this.Is_Granted = false;
    }
    
    
    /*Display Method:
     * It displays information based on 
     * the value of Is_Granted  
     */
    
    public void display()
    {
        if(Is_Granted) {
            //calling display method of superclass
            super.display();
            System.out.println("Credit Limit: "+ this.Credit_Limit);
            System.out.println("Grace period: "+ this.Grace_Period);
        }
        else {
            super.display();
            System.out.println("CVC Number: "+ this.Cvc_Number);
            System.out.println("Interest rate:" + this.Interest_Rate);
            System.out.println("Expiration date: " + this.Expiration_Date);
        }
    }
}