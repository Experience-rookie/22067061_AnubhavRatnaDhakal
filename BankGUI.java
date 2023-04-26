/**
 * Write a description of class BankGUI here.
 *
 * @author (Anubhav Ratna Dhakal)
 * @version (11April,2023)
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.util.*;
import javax.swing.JOptionPane;

public class BankGUI implements ActionListener
{
    //Declaring Instance Variable
    private JFrame mainFrame;
    private JPanel main_panel1;
    private JPanel main1_panel2;
    private JButton debitCard;
    private JButton creditCard;
    private JLabel welcomeLabel;
    private JLabel cardSelectLabel;
    //Instance Variable for Debit Card
    private JFrame frame_debitCard;
    private JPanel panel_debitCard;
    private JLabel label_debitCard;
    private JLabel debitCardId;
    private JLabel debitBalanceAmount;
    private JLabel debitBankAccount;
    private JLabel debitIssuerBank;
    private JLabel debitClientName;
    private JLabel debitPinNumber;
    private JTextField Text_debitCardId;
    private JTextField Text_debitBalanceAmount;
    private JTextField Text_debitBankAccount;
    private JTextField Text_debitIssuerBank;
    private JTextField Text_debitClientName;
    private JTextField Text_debitPinNumber;
    private JButton btn_debitCard;
    private JButton btn_debitClear;
    private JLabel debitWithdrawlAmount;
    private JLabel debitDateOfWithdrawl;
    private JTextField Text_withdrawlAmount;
    private JButton btnWithdraw;
    private JButton btnDisplay;
    private JButton btnGoBack;
    private JComboBox dc_day;
    private JComboBox dc_month;
    private JComboBox dc_year;
    //Instance variable forCredit Card
    private JFrame frame_creditCard;
    private JPanel panel_creditCard;
    private JLabel label_creditCard;
    private JLabel creditCardId;
    private JLabel creditBalanceAmount;
    private JLabel creditBankAccount;
    private JLabel creditIssuerBank;
    private JLabel creditClientName;
    private JLabel creditCardCvcNumber;
    private JTextField Text_creditCardId;
    private JTextField Text_creditBalanceAmount;
    private JTextField Text_creditBankAccount;
    private JTextField Text_creditIssuerBank;
    private JTextField Text_creditClientName;
    private JTextField Text_creditCardCvcNumber;
    private JButton Addbtn_creditCard;
    private JButton Clrbtn_creditClear;
    private JLabel creditInterestRate;
    private JTextField Text_InterestRate;
    private JLabel creditCardExpirationDate;
    private JLabel creditCardLimit;
    private JTextField Text_creditLimit;
    private JLabel creditCardgracePeriod;
    private JTextField Text_gracePeriod;
    private JButton SetbtnCreditLimit;
    private JButton CCbtn_creditCancleCredit;
    private JButton DisbtnCreditDisplay;
    private JButton GBbtnCreditGoBack;
    private JComboBox cb_day,cb_month,cb_year;
    
    //The array list of type BankCard
    ArrayList <BankCard> Arr_List = new ArrayList<BankCard>();
    
public void actionPerformed(ActionEvent e)
    { 
        if(e.getSource()==debitCard)
        {
             debitInterface();//call the method of debitCard interface
        }
        
        else if(e.getSource()==creditCard)
        {
             creditInterface();//call the method of creditCard interface
        }
        
        //for AddDebitCard
        if(e.getSource()==btn_debitCard)
        {
            // if the correct entry hasnt been added show this message
            if(Text_debitBalanceAmount.getText().isEmpty() || Text_debitCardId.getText().isEmpty() || Text_debitBankAccount.getText().isEmpty() || Text_debitIssuerBank.getText().isEmpty() || 
            Text_debitClientName.getText().isEmpty() ||  Text_debitPinNumber.getText().isEmpty()) 
            {
                // to display if the button was clicked without entering the value
                JOptionPane.showMessageDialog(panel_debitCard,"The fields are Empty !!");
            }else
            {
                try{
                    double debitBalanceAmount= Double.valueOf(Text_debitBalanceAmount.getText());
                    int debitCardId = Integer.valueOf(Text_debitCardId.getText());
                    int debitPinNumber= Integer.valueOf(Text_debitPinNumber.getText());
                    String debitBankAccount= Text_debitBankAccount.getText();
                    String debitIssuerBank= Text_debitIssuerBank.getText();
                    String debitClientName= Text_debitClientName.getText();
                    
                    //This is used to convert integer values to String which can be used to display message
                    String CardId=String.valueOf(debitCardId);
                    String BalanceAmount=String.valueOf(debitBalanceAmount);
                    
                    //Display popup to show all details entered by user
                    String Values = "Card ID: "+CardId + "\n Client Name: "+debitClientName +  "\n Bank Account :"+debitBankAccount +"\n Balance Amount :"+BalanceAmount + 
                    "\n Issuer Bank :"+debitIssuerBank;
                    
                    //Using boolean to check CardId
                    
                    boolean checked = true;// initialze the boolean value as true
                    for(BankCard Bank_obj : Arr_List)
                    {
                        if(Bank_obj instanceof DebitCard)
                        {
                            DebitCard Debit_obj = (DebitCard) Bank_obj;
                            if(Debit_obj.getCard_Id() ==debitCardId)
                            {
                                checked = false;
                            }
                        }
                    }
                    if(checked == true)
                    {
                        //creating object of DebitCard class and giving parameter values
                        DebitCard DC = new DebitCard(debitBalanceAmount, debitCardId, debitBankAccount,debitIssuerBank, debitClientName, debitPinNumber);
                        Arr_List.add(DC);// adding the value to arraylist
                        
                        //given  output using JOptionPane
                        JOptionPane.showMessageDialog(panel_debitCard, "Debit Card added successfully. \n"+Values);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(panel_debitCard, "Debit Card is already in database");
                    }
                    
                }catch(NumberFormatException ex) //exception which is used to check whether the entered value is error or not
                {
                    JOptionPane.showMessageDialog(panel_debitCard, "Invalid !! Please enter correct credentials.");
                    
                }
            }
        }
        else if(e.getSource()==btnDisplay)
        {
            String Date = dc_day.getSelectedItem()+""+dc_month.getSelectedItem()+""+dc_year.getSelectedItem();
            // the user was not put the input and direct add the value then given the empty message
            if(Text_debitBalanceAmount.getText().isEmpty() || Text_debitCardId.getText().isEmpty() || Text_debitBankAccount.getText().isEmpty() || Text_debitIssuerBank.getText().isEmpty() || 
            Text_debitClientName.getText().isEmpty() ||  Text_debitPinNumber.getText().isEmpty()) 
            {
                //message dailog box whne the any values or message provide the user
                JOptionPane.showMessageDialog(panel_debitCard,"The fields are Empty !!");
            }else
            {
                try
                {
                 
                    double debitBalanceAmount= Double.valueOf(Text_debitBalanceAmount.getText());
                    int debitCardId = Integer.valueOf(Text_debitCardId.getText());
                    int debitPinNumber= Integer.valueOf(Text_debitPinNumber.getText());
                    String debitBankAccount= Text_debitBankAccount.getText();
                    String debitIssuerBank= Text_debitIssuerBank.getText();
                    String debitClientName= Text_debitClientName.getText();
                    int WithdrawalAmount= Integer.valueOf(Text_withdrawlAmount.getText());
                    
                    // Converting all integer into String
                    String BalanceAmount = String.valueOf(debitBalanceAmount);
                    String CardId =String.valueOf(debitCardId);
                    String PinNumber = String.valueOf(debitPinNumber);
                    String Withdrawal_Amount = String.valueOf(WithdrawalAmount);
                    // Displaying everything
                     String Display = "Card ID: "+CardId+ "\n Client Name :"+debitClientName+ "\n BalanceAmount : "+BalanceAmount+ "\n Bank Account :"+debitBankAccount+
                     "\n Issuer Bank :"+debitIssuerBank+ "\n Withdrawal Amount :"+Withdrawal_Amount;
                     for(BankCard Bank_obj : Arr_List)
                     {
                         if(Bank_obj instanceof DebitCard)
                         {
                             DebitCard Debit_obj = (DebitCard) Bank_obj;
                             Debit_obj.display();
                             JOptionPane.showMessageDialog(panel_debitCard, "  <Debit Card> \n"+Display);
                         }
                     }
                }
                    
            catch(NumberFormatException ex)
            { 
                JOptionPane.showMessageDialog(panel_debitCard, " Invalid Entry !! Please enter correct credentials.");
            }
        }
    }
        else if(e.getSource()==btnWithdraw)
        {
            String Date = dc_day.getSelectedItem()+""+dc_month.getSelectedItem()+""+dc_year.getSelectedItem();
            // the user was not put the input and direct add the value then given the empty message
            if(Text_debitCardId.getText().isEmpty() || Text_debitPinNumber.getText().isEmpty() || Text_withdrawlAmount.getText().isEmpty()) 
            {
                //message dailog box whne the any values or message provide the user
                JOptionPane.showMessageDialog(panel_debitCard,"The fields are Empty !!");
            }
            else
            {
                try
                { 
                    int debitCardId = Integer.valueOf(Text_debitCardId.getText());
                    int WithdrawalAmount= Integer.valueOf(Text_withdrawlAmount.getText());
                    int debitPinNumber= Integer.valueOf(Text_debitPinNumber.getText());
                    
                    for(BankCard Bank_obj : Arr_List)
                    {
                        if(Bank_obj instanceof DebitCard)
                        {
                            DebitCard Debit_obj = (DebitCard) Bank_obj;
                            if(Debit_obj.getCard_Id() ==debitCardId)
                            
                            {

                                Debit_obj.withdraw(WithdrawalAmount,Date, debitPinNumber);
                                JOptionPane.showMessageDialog(panel_debitCard, " The Amount is withdrawn successfully.");
                            }else
                            {
                                JOptionPane.showMessageDialog(panel_debitCard,"The Card ID didn't match");
                            }
                        }
                        
                    }   
                                        
                }catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(panel_debitCard, "Invalid Entry!! Please enter correct credentials");
                    
                }
            }
            //
            
            
        }
        else if(e.getSource()==btn_debitClear)
        {
            //Clearing the value of TextFields
            Text_debitBalanceAmount.setText("");
            Text_debitCardId.setText("");
            Text_debitBankAccount.setText("");
            Text_debitIssuerBank.setText("");
            Text_debitClientName.setText("");
            Text_debitPinNumber.setText("");
            Text_withdrawlAmount.setText("");
            //Clearing the values of ComboBox
            dc_day.setSelectedIndex(0);
            dc_month.setSelectedIndex(0);
            dc_year.setSelectedIndex(0);
            
            
        }
        else if(e.getSource()==btnGoBack)
        {
            frame_debitCard.dispose();
        }
        
        //Credit Card
        if(e.getSource()==Addbtn_creditCard)
        {
            // if the correct entry hasnt been added show this message
            if(Text_creditCardId.getText().isEmpty() || Text_creditBalanceAmount.getText().isEmpty() || Text_creditBankAccount.getText().isEmpty() || Text_creditIssuerBank.getText().isEmpty() || 
            Text_InterestRate.getText().isEmpty() ||  Text_creditCardCvcNumber.getText().isEmpty()) 
            {
                // to display if the button was clicked without entering the value
                JOptionPane.showMessageDialog(panel_debitCard,"The fields is Empty !!");
            }else
            {
                try
                {
                    //converting data types
                    int CardId= Integer.valueOf(Text_creditCardId.getText());
                    double BalanceAmount=Double.valueOf(Text_creditBalanceAmount.getText());
                    String BankAccount=Text_creditBankAccount.getText();
                    String IssuerBank=Text_creditIssuerBank.getText();
                    String ClientName= Text_creditClientName.getText();
                    double InterestRate=Double.valueOf(Text_InterestRate.getText());
                    int CvcNumber=Integer.valueOf(Text_creditCardCvcNumber.getText());
                    String Date = cb_day.getSelectedItem()+""+cb_month.getSelectedItem()+""+cb_year.getSelectedItem();
                    
                    //Converting all intergers into String
                    String CardID =String.valueOf(CardId);
                    String Balance_Amount= String.valueOf(BalanceAmount);
                    String Interest_Rate=String.valueOf(InterestRate);
                    String CVCNumber= String.valueOf(CvcNumber);
                    
                    // Display all info to show on JoptionPane
                    String credit =  "Card ID :"+CardID+ "\n Client Name :"+ClientName+ "\n Bank Account :"+BankAccount+ "\n Balance Amount :"+Balance_Amount+ "\n Issuer Bank :"+IssuerBank+
                    "\n CVC Number : "+CVCNumber+ "\n Interest Rate : "+Interest_Rate+ "\n Expiration Date :"+Date;
                    
                    // using boolean function
                    boolean Use = true; //initialize the boolean value as true;
                    for(BankCard Bank_obj :Arr_List)
                    {
                        if(Bank_obj instanceof CreditCard)
                        {
                            CreditCard Credit_obj = (CreditCard) Bank_obj;
                            if(Credit_obj.getCard_Id()==CardId)
                            {
                                Use = false;
                            }
                        }
                    }
                    if(Use ==true)
                    {
                        //creating object of CreditCard class and giving parameter values
                        CreditCard CD = new CreditCard(ClientName, CardId, IssuerBank, BankAccount, BalanceAmount,CvcNumber, InterestRate, Date);
                        Arr_List.add(CD);// adding the value into arraylist
                        
                        //using JoptionPane
                        JOptionPane.showMessageDialog(panel_creditCard, " Credit Card successfully added. \n"+credit);
                    }else
                    {
                        JOptionPane.showMessageDialog(panel_creditCard, "Credit Card is already in database");
                    }
                    
                }catch(NumberFormatException c)//expectation which is used to check whether the entered value is error or not
                {
                    JOptionPane.showMessageDialog(panel_creditCard, "Invalid Entry !! Please enter correct credentials.");
                }
            }  
        }
        else if(e.getSource()==Clrbtn_creditClear)
        {
            Text_creditCardId.setText("");
            Text_creditBalanceAmount.setText("");
            Text_creditBankAccount.setText("");
            Text_creditIssuerBank.setText("");
            Text_creditClientName.setText("");
            Text_InterestRate.setText("");
            Text_creditCardCvcNumber.setText("");
            Text_creditLimit.setText("");
            Text_gracePeriod.setText("");
            // Emptying JCombox Indexes
            cb_day.setSelectedIndex(0);
            cb_month.setSelectedIndex(0);
            cb_year.setSelectedIndex(0);
            
            
        }
        else if(e.getSource()==SetbtnCreditLimit)
        {
            // if the correct entry hasnt been added show this message
            if(Text_creditCardId.getText().isEmpty() || Text_creditBalanceAmount.getText().isEmpty() || Text_creditBankAccount.getText().isEmpty() || Text_creditIssuerBank.getText().isEmpty() || 
            Text_InterestRate.getText().isEmpty() ||  Text_creditCardCvcNumber.getText().isEmpty()) 
            {
                // to display if the button was clicked without entering the value
                JOptionPane.showMessageDialog(panel_creditCard,"The fields is Empty !!");
            }else
            {
                try
                {
                    int CardId= Integer.valueOf(Text_creditCardId.getText());
                    double CreditLimit= Double.valueOf(Text_creditLimit.getText());
                    int GracePeriod=Integer.valueOf(Text_gracePeriod.getText());
                    
                    //Converting integers into string
                    String CardID=String.valueOf(CardId);
                    String Credit_Limit=String.valueOf(CreditLimit);
                    String Grace_Period= String.valueOf(GracePeriod);
                    
                    //Display in JOptionPane
                    String CL = "Card ID :"+CardID+ "\n Credit Limit :"+Credit_Limit+"\n Grace Period : "+Grace_Period;
                    
                    for(BankCard Bank_obj : Arr_List)
                    {
                        if(Bank_obj instanceof CreditCard)
                        {
                            CreditCard Credit_obj = (CreditCard) Bank_obj;
                            if(Credit_obj.getCard_Id() ==CardId)
                            {
                                if(CreditLimit <= (Credit_obj.getBalance_Amount()*2.5))
                                {
                                    Credit_obj.setCreditLimit(CreditLimit,GracePeriod);
                                    JOptionPane.showMessageDialog(panel_creditCard," Credit Limit has been set successfully. \n"+CL);
                                }    
                            }else
                            {
                                JOptionPane.showMessageDialog(panel_creditCard, "Error !! Please enter all values.");
                            }
                        }
                    }
                    
                    
                }catch(NumberFormatException b)
                {
                    JOptionPane.showMessageDialog(panel_creditCard, "Invalid Entry !! Please enter correct credentials. ");
                }
            }
            
            
        }
        else if(e.getSource()==CCbtn_creditCancleCredit)
        {
            
            // if the correct entry hasnt been added show this message
            if(Text_creditCardId.getText().isEmpty() || Text_creditBalanceAmount.getText().isEmpty() || Text_creditBankAccount.getText().isEmpty() || Text_creditIssuerBank.getText().isEmpty() || 
            Text_InterestRate.getText().isEmpty() ||  Text_creditCardCvcNumber.getText().isEmpty()) 
            {
                // to display if the button was clicked without entering the value
                JOptionPane.showMessageDialog(panel_creditCard,"The fields is Empty !!");
            }else
            {
                try
                {
                    int CardId= Integer.valueOf(Text_creditCardId.getText());
                    for(BankCard Bank_obj :Arr_List)
                    {
                        if(Bank_obj instanceof CreditCard)
                        {
                            CreditCard Credit_obj = (CreditCard) Bank_obj;
                            if(Credit_obj.getCard_Id()==CardId)
                            {
                                Credit_obj.cancleCreditCard();
                                JOptionPane.showMessageDialog(panel_creditCard, " Your Credit Card has been cancelled successfully.");
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(panel_creditCard, "Your Credit Card hasn't been cancelled.");
                            }
                        }
                    }
                }catch(NumberFormatException f)
                {
                  JOptionPane.showMessageDialog(panel_creditCard, "Invalid Entry !! Please enter correct credentials. ");  
                } 
            }
            
        }
        else if(e.getSource()==DisbtnCreditDisplay)
        {
            // if the correct entry hasnt been added show this message
            if(Text_creditCardId.getText().isEmpty() || Text_creditBalanceAmount.getText().isEmpty() || Text_creditBankAccount.getText().isEmpty() || Text_creditIssuerBank.getText().isEmpty() || 
            Text_InterestRate.getText().isEmpty() ||  Text_creditCardCvcNumber.getText().isEmpty()) 
            {
                // to display if the button was clicked without entering the value
                JOptionPane.showMessageDialog(panel_creditCard,"The fields is Empty !!");
            }
            else
            {
                try
                {
                     //converting data types
                    int CardId= Integer.valueOf(Text_creditCardId.getText());
                    double BalanceAmount=Double.valueOf(Text_creditBalanceAmount.getText());
                    String BankAccount=Text_creditBankAccount.getText();
                    String IssuerBank=Text_creditIssuerBank.getText();
                    String ClientName= Text_creditClientName.getText();
                    double InterestRate=Double.valueOf(Text_InterestRate.getText());
                    int CvcNumber=Integer.valueOf(Text_creditCardCvcNumber.getText());
                    String Date = cb_day.getSelectedItem()+""+cb_month.getSelectedItem()+""+cb_year.getSelectedItem();
                    double CreditLimit=Double.valueOf(Text_creditLimit.getText());
                    int GracePeriod=Integer.valueOf(Text_gracePeriod.getText());
                    // Converting integers into string
                    String CardID = String.valueOf(CardId);
                    String Balance_Amount = String.valueOf(BalanceAmount);
                    String Interest_Rate = String.valueOf(InterestRate);
                    String CVCNumber=String.valueOf(CvcNumber);
                    String Credit_Limit = String.valueOf(CreditLimit);
                    String Grace_Period= String.valueOf(GracePeriod);
                    //Displaying everything
                    String Credit = "Card ID :"+CardID+"\n Client Name : "+ClientName+"\n Bank Account :"+BankAccount+ "\n Issuer Bank :"+IssuerBank+
                    "\n Balance Amount :"+Balance_Amount+ "\n Interest Rate :"+Interest_Rate+ "\n CVC Number : "+CVCNumber+ "\n Expiration Date :"+Date+
                    "\n Credit Limit :"+Credit_Limit+ "\n Grace Period :"+Grace_Period;
                    for(BankCard Bank_obj : Arr_List)
                    {
                        if(Bank_obj instanceof CreditCard)
                        {
                            CreditCard Credit_obj = (CreditCard) Bank_obj;
                            Credit_obj.display();
                            JOptionPane.showMessageDialog(panel_creditCard, " <Credit Card> \n"+Credit);
                    }
                    }
                }catch(NumberFormatException a)
                {
                    JOptionPane.showMessageDialog(panel_creditCard, "Invalid Entry !! Please enter correct credentials. ");
                    
                }
            }   
        }
        else if(e.getSource()==GBbtnCreditGoBack)
        {
            frame_creditCard.dispose();
            
        }
        
    }
    
   public void Inte()
   {
       //JFrame for Bank GUI(Graphical User Interface) 
       mainFrame = new JFrame("Laxmi Bank Card Management System");
       mainFrame.setBounds(370, 150, 670, 555);
       mainFrame.setResizable(false);
       mainFrame.setLayout(null);
       
       //Frist JPanel for Bank GUI
       main_panel1 = new JPanel();
       main_panel1.setBounds(0, 0,673, 534);
       Color colorPanel1 = new Color(255, 165, 0);
       main_panel1.setBackground(colorPanel1);
       main_panel1.setLayout(null);
       
       // Second JPanel for Bank GUI
       main1_panel2 = new JPanel();
       main1_panel2.setBounds(155,92,383,350);
       Color colorPanel2 = new Color(255, 204, 153);
       main1_panel2.setBackground(colorPanel2);
       main_panel1.add(main1_panel2);
       main1_panel2.setLayout(null);
       
       //JButton for Debit Card
       debitCard = new JButton("DEBIT CARD");
       debitCard.setBounds(41,84,307,80);
       debitCard.setFont(new Font("TimesRoman", Font.BOLD,25)); 
       debitCard.setBorder(null);
       debitCard.setOpaque(true);
       Color colorbtn = new Color(241,235,156);
       debitCard.setBackground(colorbtn);
       debitCard.setForeground(Color.BLACK);
       main1_panel2.add(debitCard);
       debitCard.addActionListener(this);
        
       //JButton for Credit Card
       creditCard = new JButton("CREDIT CARD");
       creditCard.setBounds(39,180,300,75);
       creditCard.setFont(new Font("TimesRoman", Font.BOLD,22));
       creditCard.setBorder(null);
       creditCard.setOpaque(true);
       Color colorbtn1 = new Color(241,235,156);
       creditCard.setBackground(colorbtn1);
       creditCard.setForeground( Color.BLACK);
       main1_panel2.add(creditCard);
       creditCard.addActionListener(this);
       
       //JLabel for Bank GUI Interface that shows Welcome Message
       welcomeLabel = new JLabel("Welcome To Laxmi Bank");
       welcomeLabel.setBounds(164, 9, 350, 24);
       welcomeLabel.setForeground( Color.WHITE);
       welcomeLabel.setFont(new Font("TimesRoman", Font.BOLD,27));
       main_panel1.add(welcomeLabel);
       
       //JLabel for Bank GUI Interface to make user select their prefered card
       cardSelectLabel = new JLabel("Please Select Your Prefered Card!");
       cardSelectLabel.setBounds(152, 70, 400, 20);
       cardSelectLabel.setForeground(Color.WHITE);
       cardSelectLabel.setFont(new Font("TimesRoman", Font.BOLD,24));
       main_panel1.add(cardSelectLabel);
       
       //adding to the panel 
       mainFrame.add(main_panel1);
       mainFrame.setVisible(true);
   }
   
   //This method is for DEBIT CARD Interface
   public void debitInterface()
   {
       //JFrame for debitCard Interface
        frame_debitCard = new JFrame("Welcome to Debit Card System");
        frame_debitCard.setBounds(270,90,774,750);
        frame_debitCard.setResizable(false);
        frame_debitCard.setLayout( null);
        frame_debitCard.setVisible(true);
        frame_debitCard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        //Jpanel for debit card interface
        panel_debitCard = new JPanel();
        panel_debitCard.setBounds(0, 0,770, 750);
        Color debitColor = new Color(173, 216, 230);
        panel_debitCard.setBackground(debitColor);
        panel_debitCard.setLayout(null);
        
        
        //JLabel for Debit Card
        label_debitCard = new JLabel("Debit Card");
        label_debitCard.setBounds(320, 10, 200,70);
        label_debitCard.setFont(new Font("TimesRoman", Font.BOLD,25)); 
        label_debitCard.setForeground(Color.BLACK);
        frame_debitCard.add(label_debitCard);
        
        //JLabel for Card ID
        debitCardId = new JLabel("Card ID");
        debitCardId.setBounds(30, 70, 100,70);
        debitCardId.setFont(new Font("TimesRoman", Font.BOLD,18)); 
        debitCardId.setForeground(Color.BLACK);
        frame_debitCard.add(debitCardId);
        
        //JLabel for Balance Amount
        debitBalanceAmount = new JLabel("Balance Amount");
        debitBalanceAmount.setBounds(20, 110, 200,70);
        debitBalanceAmount.setFont(new Font("TimesRoman", Font.BOLD,18)); 
        debitBalanceAmount.setForeground(Color.BLACK);
        frame_debitCard.add(debitBalanceAmount);
        
        //JLabel for Bank Account
        debitBankAccount = new JLabel("Bank Account");
        debitBankAccount.setBounds(20, 150, 200,70);
        debitBankAccount.setFont(new Font("TimesRoman", Font.BOLD,18)); 
        debitBankAccount.setForeground(Color.BLACK);
        frame_debitCard.add(debitBankAccount);
        
        //JLabel for Issuer Bank
        debitIssuerBank = new JLabel("Issuer Bank");
        debitIssuerBank.setBounds( 432, 64, 200, 70);
        debitIssuerBank.setFont(new Font("TimesRoman", Font.BOLD,18)); 
        debitIssuerBank.setForeground(Color.BLACK);
        frame_debitCard.add(debitIssuerBank);
        
        //JLabel for Client Name
        debitClientName = new JLabel("Client Name");
        debitClientName.setBounds( 430, 109, 205, 73);
        debitClientName.setFont(new Font("TimesRoman", Font.BOLD,18)); 
        debitClientName.setForeground(Color.BLACK);
        frame_debitCard.add(debitClientName);
        
        //JLabel for PIN Number
        debitPinNumber = new JLabel("PIN Number");
        debitPinNumber.setBounds(430,150,204,73);
        debitPinNumber.setFont(new Font("TimesRoman", Font.BOLD,18));
        debitPinNumber.setForeground(Color.BLACK);
        frame_debitCard.add(debitPinNumber);
        
        //JTextField for Card ID 
        Text_debitCardId = new JTextField();
        Text_debitCardId.setBounds(230, 85,150,30);
        frame_debitCard.add(Text_debitCardId);
        
        //JTextField for Balance Amount
        Text_debitBalanceAmount = new JTextField();
        Text_debitBalanceAmount.setBounds(230, 128, 150, 30);
        frame_debitCard.add(Text_debitBalanceAmount);
        
        //JTextField for Bank Account
        Text_debitBankAccount = new JTextField();
        Text_debitBankAccount.setBounds(230, 168, 150, 30);
        frame_debitCard.add(Text_debitBankAccount);
        
        //JTextField for Issuer Bank
        Text_debitIssuerBank = new JTextField();
        Text_debitIssuerBank.setBounds( 580, 85, 150, 30);
        frame_debitCard.add(Text_debitIssuerBank);
        
        //JTextField for Client Bank
        Text_debitClientName = new JTextField();
        Text_debitClientName = new JTextField();
        Text_debitClientName.setBounds(580, 128, 150, 30);
        frame_debitCard.add(Text_debitClientName);
        
        //JTextField for PIN Number
        Text_debitPinNumber = new JTextField();
        Text_debitPinNumber.setBounds(580, 168, 150, 30);
        frame_debitCard.add(Text_debitPinNumber);
        
        //JButton for Add Debit Card
        btn_debitCard = new JButton("Add Debit Card");
        btn_debitCard.setBounds(310, 225, 208, 58);
        btn_debitCard.setFont(new Font("TimesRoman", Font.BOLD,19));
        frame_debitCard.add(btn_debitCard);
        btn_debitCard.setBorder(null);
        btn_debitCard.setOpaque(true);
        Color colorAddbtn = new Color(144, 238, 144);
        btn_debitCard.setBackground(colorAddbtn);
        btn_debitCard.setForeground(Color.BLACK);
        btn_debitCard.addActionListener(this);
        
        //JButton for Display
        btnDisplay = new JButton("Display");
        btnDisplay .setBounds(370, 420, 200, 50);
        btnDisplay.setFont(new Font("TimesRoman", Font.BOLD,16));
        frame_debitCard.add(btnDisplay);
        btnDisplay.setBorder(null);
        btnDisplay.setOpaque(true);
        //Color colorDisplaybtn = new Color(230,61,52);
        btnDisplay.setBackground( Color.ORANGE);
        btnDisplay.setForeground( Color.BLACK);
        btnDisplay.addActionListener(this);
        
        
        
        
        //JLabel for WithDrawl Amount
        debitWithdrawlAmount = new JLabel("Withdrawl Amount");
        debitWithdrawlAmount .setBounds(50,298,300,70);
        debitWithdrawlAmount.setFont(new Font("TimesRoman", Font.BOLD,18)); 
        debitWithdrawlAmount.setForeground(Color.BLACK);
        frame_debitCard.add( debitWithdrawlAmount);
        
        //JLabel for Date of Withdrawl
        debitDateOfWithdrawl = new JLabel("Date of Withdrawl");
        debitDateOfWithdrawl.setBounds(50,348,300,70);
        debitDateOfWithdrawl.setFont(new Font("TimesRoman", Font.BOLD,18)); 
        debitDateOfWithdrawl.setForeground(Color.BLACK);
        frame_debitCard.add( debitDateOfWithdrawl);
        
        //JTextField for Withdrawl Amount
        Text_withdrawlAmount = new JTextField();
        Text_withdrawlAmount.setBounds(230,318,260,30);
        frame_debitCard.add(Text_withdrawlAmount);
        
        
       //generating day
        Integer[] day = new Integer[31];
        for (int i=0;i<31;i++)
        {
            day[i]=i+1;
        }
        dc_day = new JComboBox(day);
        dc_day.setBounds(230,368,70,30);
        frame_debitCard.add(dc_day);
        // generating month
        String[] month = new String[] {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
        dc_month = new JComboBox(month);
        dc_month.setBounds(300,368,100,30);
        frame_debitCard.add(dc_month);
        // generating year
        int start=2023;
        Integer[] year = new Integer[123];
        for (int j=0;j<123;j++)
        {
            year[j]=start;
            start--;
        }
        dc_year = new JComboBox(year);
        dc_year.setBounds(400,368,100,30);
        frame_debitCard.add(dc_year);
       
       //JButton for withdraw
        btnWithdraw = new JButton("Withdraw");
        btnWithdraw.setBounds(150, 420, 200, 50);
        btnWithdraw.setFont(new Font("TimesRoman", Font.BOLD,16));
        frame_debitCard.add(btnWithdraw);
        btnWithdraw.setBorder(null);
        btnWithdraw.setOpaque(true);
        Color colorWithdrawbtn = new Color(144, 238, 144);
        btnWithdraw.setBackground(colorWithdrawbtn);
        btnWithdraw.setForeground(Color.BLACK);
        btnWithdraw.addActionListener(this);
       
       
       
       //JButton for Clear
        btn_debitClear = new JButton("Clear");
        btn_debitClear.setBounds(260, 500, 200, 50);
        btn_debitClear.setFont(new Font("TimesRoman", Font.BOLD,16));
        frame_debitCard.add(btn_debitClear);
        btn_debitClear.setBorder( null);
        btn_debitClear.setOpaque(true);
        Color colorClearbtn = new Color(230,61,52);
        btn_debitClear.setBackground( colorClearbtn);
        btn_debitClear.setForeground( Color.WHITE);
        btn_debitClear.addActionListener(this);
       
       
       //JButton for Go Back
        btnGoBack = new JButton("Go Back");
        btnGoBack .setBounds(80, 580, 200, 50);
        btnGoBack.setFont(new Font("TimesRoman", Font.BOLD,16));
        frame_debitCard.add(btnGoBack);
        btnGoBack.setBorder( null);
        btnGoBack.setOpaque(true);
        Color colorDisplaybtn = new Color( 128,199,255);
        btnGoBack.setBackground(colorDisplaybtn );
        btnGoBack.setForeground( Color.BLACK);
        btnGoBack.addActionListener(this);
       
        //adding
        frame_debitCard.add(panel_debitCard);
        frame_debitCard.setVisible(true
        
        );
   }
   
   ////This method is for CREDIT CARD Interface
   public void creditInterface()
   {
        //JFrame for creditCard Interface
        frame_creditCard = new JFrame("Welcome to Credit Card System");
        frame_creditCard.setBounds(270,90,774,750);
        frame_creditCard.setResizable(false);
        frame_creditCard.setLayout( null);
        frame_creditCard.setVisible(true);
        frame_creditCard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //mainFrame.dispose();
        
        //Jpanel for credit card interface
        panel_creditCard = new JPanel();
        panel_creditCard.setBounds(0, 0,770, 750);
        Color creditColor = new Color(255, 255, 143);
        panel_creditCard.setBackground(creditColor);
        panel_creditCard.setLayout(null);
        
        //JLabel for Debit Card
        label_creditCard = new JLabel("Credit Card");
        label_creditCard.setBounds(300, 10, 200,70);
        label_creditCard.setFont(new Font("TimesRoman", Font.BOLD,25)); 
        label_creditCard.setForeground(Color.BLACK);
        frame_creditCard.add(label_creditCard);
        
        //JLabel for Card ID for credit card
        creditCardId = new JLabel("Card ID");
        creditCardId.setBounds(50, 70, 100,70);
        creditCardId.setFont(new Font("TimesRoman", Font.BOLD,18)); 
        creditCardId.setForeground(Color.BLACK);
        frame_creditCard.add(creditCardId);
        
        //JLabel for Balance Amount for credit card
        creditBalanceAmount = new JLabel("Balance Amount");
        creditBalanceAmount.setBounds(50, 110, 200,70);
        creditBalanceAmount.setFont(new Font("TimesRoman", Font.BOLD,18)); 
        creditBalanceAmount.setForeground(Color.BLACK);
        frame_creditCard.add(creditBalanceAmount);
        
        //JLabel for Bank Account for credit card
        creditBankAccount = new JLabel("Bank Account");
        creditBankAccount.setBounds(50, 150, 200,70);
        creditBankAccount.setFont(new Font("TimesRoman", Font.BOLD,18)); 
        creditBankAccount.setForeground(Color.BLACK);
        frame_creditCard.add(creditBankAccount);
        
        //JLabel for Issuer Bank for credit card
        creditIssuerBank = new JLabel("Issuer Bank");
        creditIssuerBank.setBounds( 430, 63, 200, 70);
        creditIssuerBank.setFont(new Font("TimesRoman", Font.BOLD,18)); 
        creditIssuerBank.setForeground(Color.BLACK);
        frame_creditCard.add(creditIssuerBank);
        
        //JLabel for Client Name for credit card
        creditClientName = new JLabel("Client Name");
        creditClientName.setBounds( 430, 109, 200, 70);
        creditClientName.setFont(new Font("TimesRoman", Font.BOLD,18)); 
        creditClientName.setForeground(Color.BLACK);
        frame_creditCard.add(creditClientName);
        
        //JLabel for CVC Number
        creditCardCvcNumber = new JLabel("CVC Number");
        creditCardCvcNumber.setBounds(430,150,200,70);
        creditCardCvcNumber.setFont(new Font("TimesRoman", Font.BOLD,18));
        creditCardCvcNumber.setForeground(Color.BLACK);
        frame_creditCard.add(creditCardCvcNumber);
        
        //JTextField for Card ID 
        Text_creditCardId = new JTextField();
        Text_creditCardId.setBounds(230, 85,150,30);
        frame_creditCard.add(Text_creditCardId);
        
        //JTextField for Balance Amount
        Text_creditBalanceAmount = new JTextField();
        Text_creditBalanceAmount.setBounds(230, 128, 150, 30);
        frame_creditCard.add(Text_creditBalanceAmount);
        
        //JTextField for Bank Account
        Text_creditBankAccount = new JTextField();
        Text_creditBankAccount.setBounds(230, 168, 150, 30);
        frame_creditCard.add(Text_creditBankAccount);
        
        //JTextField for Issuer Bank
        Text_creditIssuerBank = new JTextField();
        Text_creditIssuerBank.setBounds( 580, 85, 150, 30);
        frame_creditCard.add(Text_creditIssuerBank);
        
        //JTextField for Client Bank
        Text_creditClientName = new JTextField();
        Text_creditClientName = new JTextField();
        Text_creditClientName.setBounds( 580, 128, 150, 30);
        frame_creditCard.add(Text_creditClientName);
        
        //JTextField for CVC Number
        Text_creditCardCvcNumber = new JTextField();
        Text_creditCardCvcNumber.setBounds(580, 168, 150, 30);
        frame_creditCard.add(Text_creditCardCvcNumber);
        
        //JButton for Add Credit Card
        Addbtn_creditCard = new JButton("Add Credit Card");
        Addbtn_creditCard.setBounds( 150, 238, 200, 50);
        Addbtn_creditCard.setFont(new Font("TimesRoman", Font.BOLD,16));
        frame_creditCard.add(Addbtn_creditCard);
        Addbtn_creditCard.setBorder( null);
        Addbtn_creditCard.setOpaque(true);
        Color colorAddCreditbtn = new Color(57, 255, 20);
        Addbtn_creditCard.setBackground( colorAddCreditbtn);
        Addbtn_creditCard.setForeground( Color.BLACK);
        Addbtn_creditCard.addActionListener(this);
        
        //JButton for Clear
        CCbtn_creditCancleCredit = new JButton("Cancel Credit Card");
        CCbtn_creditCancleCredit.setBounds( 407, 238, 200, 50);
        CCbtn_creditCancleCredit.setFont(new Font("TimesRoman", Font.BOLD,16));
        frame_creditCard.add(CCbtn_creditCancleCredit);
        CCbtn_creditCancleCredit.setBorder( null);
        CCbtn_creditCancleCredit.setOpaque(true);
        Color colorCancleCredit = new Color(230,61,52);
        CCbtn_creditCancleCredit.setBackground( colorCancleCredit);
        CCbtn_creditCancleCredit.setForeground( Color.WHITE);
        CCbtn_creditCancleCredit.addActionListener(this);
        
        //JLabel for Interest Rate
        creditInterestRate = new JLabel("Interest Rate");
        creditInterestRate .setBounds(50,298,300,70);
        creditInterestRate.setFont(new Font("TimesRoman", Font.BOLD,18)); 
        creditInterestRate.setForeground(Color.BLACK);
        frame_creditCard.add( creditInterestRate);
        
        //JTextField for Withdrawl Amount
        Text_InterestRate = new JTextField();
        Text_InterestRate.setBounds(180,318,80,30);
        frame_creditCard.add(Text_InterestRate);
        
        //JLabel for Date of Withdrawl
        creditCardExpirationDate = new JLabel("Expriation Date");
        creditCardExpirationDate.setBounds(50,405,300,70);
        creditCardExpirationDate.setFont(new Font("TimesRoman", Font.BOLD,18)); 
        creditCardExpirationDate.setForeground(Color.BLACK);
        frame_creditCard.add(creditCardExpirationDate );
        
       //generating day
        Integer[] day = new Integer[31];
        for (int i=0;i<31;i++)
        {
            day[i]=i+1;
        }
        cb_day = new JComboBox(day);
        cb_day.setBounds(215,425,70,30);
        frame_creditCard.add(cb_day);
        // generating month
        String[] month = new String[] {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
        cb_month = new JComboBox(month);
        cb_month.setBounds(285,425,100,30);
        frame_creditCard.add(cb_month);
        // generating year
        int start=2023;
        Integer[] year = new Integer[123];
        for (int j=0;j<123;j++)
        {
            year[j]=start;
            start--;
        }
        cb_year = new JComboBox(year);
        cb_year.setBounds(385,425,100,30);
        frame_creditCard.add(cb_year);
       
        //JLabel for Credit Limit
        creditCardLimit = new JLabel("Credit Limit");
        creditCardLimit.setBounds(50,348,300,70);
        creditCardLimit.setFont(new Font("TimesRoman", Font.BOLD,18)); 
        creditCardLimit.setForeground(Color.BLACK);
        frame_creditCard.add(creditCardLimit);
        
        //JTextField for Credit Limit
        Text_creditLimit = new JTextField();
        Text_creditLimit.setBounds(180,368,210,30);
        frame_creditCard.add(Text_creditLimit);
        
        
        
        //JLabel for Grace Period 
        creditCardgracePeriod = new JLabel("Grace Period");
        creditCardgracePeriod.setBounds(50,470,280,70);
        creditCardgracePeriod.setFont(new Font("TimesRoman", Font.BOLD,18)); 
        creditCardgracePeriod.setForeground(Color.BLACK);
        frame_creditCard.add(creditCardgracePeriod);
        
        //JTextField for Grace Period
        Text_gracePeriod = new JTextField();
        Text_gracePeriod.setBounds(180,495,210,30);
        frame_creditCard.add(Text_gracePeriod);
        
        
        
        
        //JButton for Set Credit Limit
        SetbtnCreditLimit = new JButton("Set Credit Limit");
        SetbtnCreditLimit.setBounds( 450,355,200,50);
        SetbtnCreditLimit.setFont(new Font("TimesRoman", Font.BOLD,16));
        frame_creditCard.add(SetbtnCreditLimit);
        SetbtnCreditLimit.setBorder( null);
        SetbtnCreditLimit.setOpaque(true);
        Color colorCreditLimitbtn = new Color(0, 191, 255);
        SetbtnCreditLimit.setBackground(colorCreditLimitbtn);
        SetbtnCreditLimit.setForeground(Color.BLACK);
        SetbtnCreditLimit.addActionListener(this);
        
        //JButton for Cancle Credit Card
        Clrbtn_creditClear = new JButton("Clear ");
        Clrbtn_creditClear.setBounds(445, 480, 200, 50);
        Clrbtn_creditClear.setFont(new Font("TimesRoman", Font.BOLD,16));
        frame_creditCard.add(Clrbtn_creditClear);
        Clrbtn_creditClear.setBorder( null);
        Clrbtn_creditClear.setOpaque(true);
        Color colorClearCredit = new Color(230,61,52);
        Clrbtn_creditClear.setBackground(colorClearCredit);
        Clrbtn_creditClear.setForeground( Color.WHITE);
        Clrbtn_creditClear.addActionListener(this);

       
       //JButton for Display
        DisbtnCreditDisplay = new JButton("Display");
        DisbtnCreditDisplay .setBounds(50, 550, 200, 50);
        DisbtnCreditDisplay.setFont(new Font("TimesRoman", Font.BOLD,16));
        frame_creditCard.add(DisbtnCreditDisplay);
        DisbtnCreditDisplay.setBorder( null);
        DisbtnCreditDisplay.setOpaque(true);
        //Color colorDisplaybtn = new Color(230,61,52);
        DisbtnCreditDisplay.setBackground( Color.ORANGE);
        DisbtnCreditDisplay.setForeground( Color.BLACK);
        DisbtnCreditDisplay.addActionListener(this);
       
       
       //JButton for Go Back
        GBbtnCreditGoBack = new JButton("Go Back");
        GBbtnCreditGoBack .setBounds( 510, 635, 200, 50);
        GBbtnCreditGoBack.setFont(new Font("TimesRoman", Font.BOLD,16));
        frame_creditCard.add(GBbtnCreditGoBack);
        GBbtnCreditGoBack.setBorder( null);
        GBbtnCreditGoBack.setOpaque(true);
        Color colorCreditDisplaybtn = new Color(128,199,255);
        GBbtnCreditGoBack.setBackground(colorCreditDisplaybtn );
        GBbtnCreditGoBack.setForeground( Color.BLACK);
        GBbtnCreditGoBack.addActionListener(this);
 

        //adding 
        frame_creditCard.add(panel_creditCard);
        frame_creditCard.setVisible(true);

}

public static void main(String[] args)
{
    new BankGUI().Inte();
    
}
}