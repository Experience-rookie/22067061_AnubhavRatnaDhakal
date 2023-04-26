/**
 *The BankCard class has five attributes: String Client_Name, String Issuer_Bank, int Card_Id, double Balance_Amount, String Bank_Account
* The constructor accepts four parameters. The values of those parameter are assign
the corresponding parameter values.
* Each attribute has a corresponding accessor method and setClient_Name and setBalance_Amount are setter methods.
* Then finally display the all attributes values.Hence BankCard is Parent class.
 * @author (22067061 Anubhav Ratna Dhakal)
 * @version (5.1.0)
 */

public class BankCard
{
    //attributes:
     private String Client_Name;//The private access modifier is used to create a variable with the name Client_Name with String data type.
     private String Issuer_Bank;//The private access modifier is used to create a variable with the name Issuer_Bank with String int data type.
     private int Card_Id;//The private access modifier is used to create a variable with the name Card_Id with int data type.
     private double Balance_Amount;//The private access modifier is used to create a variable with the name Balance_Amount with double data type.
     private String Bank_Account;//The private access modifier is used to create a variable with the name Bank_Account with String data type.
     
    /*The constructor of this class accepts four inputs with the corresponding data types: Card_Id, Issuer_Bank,
     * Bank_Account,and Balance_Amount. The instance variable values are then initialized in 
     * accordance with the parameter values.
     */
    public BankCard( String Issuer_Bank, int Card_Id, double Balance_Amount, String Bank_Account)
    {
        //assigns instance variable to its parameter i.e Card_Id, Issuer_Bank,Balance_Amount,Bank_Account and Client_Name
        this.Card_Id=Card_Id;
        this.Issuer_Bank=Issuer_Bank;
        this.Balance_Amount=Balance_Amount;
        this.Bank_Account= Bank_Account;
        this.Client_Name="";
    }
    
    
    /*Getters Method | Accessor Method
     * Each attribute, such as cardId, issuerBank, bankAccount, and balanceAmount, 
     * has an accessor method with a return type that matches the data type of the instance variables.
     *The access modifiers of the accessor methods are public
     */
    
    public String getClient_Name()
    {
        return this.Client_Name;//returns the value of instance variable Client_Name
    }
    public String getIssuer_Bank()
    {
        return this.Issuer_Bank;//returns the value of instance variable Issuer_Bank
    }
    
    public int getCard_Id()
    {
        return this.Card_Id;//returns the value of instance variable Card_Id
    }
    public double getBalance_Amount()
    {
        return this.Balance_Amount;//returns the value of instance variable Balance_Amount
    }
    public String getBank_Account()
    {
        return this.Bank_Account;//returns the value of instance variable Bank_Account
    }
    
    
    /*Setters Method | Mutator Method
     * ClientName and balanceAmount values are set using the setter methods.
     * The setter methods' return type is void, and their access modifiers are public.
     */
    
    public void setClient_Name(String Client_Name)
    {
        this.Client_Name=Client_Name;//assigns the value of parameter Client_Name to instance variable Client_Name
    }
    public void setBalance_Amount(double Balance_Amount)
    {
        this.Balance_Amount=Balance_Amount;//assigns the value of parameter Balance_Amount to instance variable Balance_Amount
    }
    
    
    /*Display Method:
     * The values of the instance variables Card_Id, Client_Name, Issuer_Bank, Bank_Account, 
     * and Balance_Amount are shown by the display method.
     * If the clientName is empty, a message will be shown.
     * The display method's access modifier is set to public, and its return type is void.
     */
    
    public void display()
    {
        //checking client_Name validation
        if(this.Client_Name=="") { 
            System.out.println("The Client Name is Empty!! Please Enter Client Name");
        }
        else{
            System.out.println("The Client Name is:"+ this.Client_Name);
            System.out.println( "The Card is: "+this.Card_Id);
            System.out.println("The Issuer Bank is: "+this.Issuer_Bank);
            System.out.println("The Balance Amount is: "+this.Balance_Amount);
            System.out.println("The Bank Account is: "+this.Bank_Account);
        }
    }
    }

