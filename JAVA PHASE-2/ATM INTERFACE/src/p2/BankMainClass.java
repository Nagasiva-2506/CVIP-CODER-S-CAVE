package p2;
import java.util.*;
import p1.*;
public class BankMainClass extends Exception
{
	public BankMainClass(String msg)
	{
		super(msg);
	}
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		try
		{
			int count=0;
			xyz:while(true)//labled loop
			{
				try
				{
					System.out.println("Enter the pinNo");
					int pinNo=s.nextInt();
					if(!(pinNo>=1111 && pinNo<=9999))
					{
						BankMainClass bmc= new BankMainClass
								("Invalid PinNo");
						throw bmc;
					}
					boolean k = new CheckPinNo().verify(pinNo);
					if(!k)//exception
					{
						BankMainClass bmc=new BankMainClass
								("PinNo donot exist...");
						throw bmc;
					}
					System.out.println("***Choice***");
					System.out.println("\t1.Withdraw"
							+"\n\t2.Deposit");
					System.out.println("Enter the choice");
					int choice =s.nextInt();
					switch(choice)
					{
					case 1:
						try
						{
							System.out.println("Enter the amount");
							int a1= s.nextInt();
							if(!(a1>0 && a1%100==0))
							{
								BankMainClass bmc=new BankMainClass
										("Invalid amount");
								throw bmc;
							}
							WithDraw wd=new WithDraw("");
							wd.process(a1);
						}//end of try
						catch(BankMainClass bmc)
						{
							System.out.println(bmc.getMessage());
						}
						catch(WithDraw ob)
						{
							System.out.println(ob.getMessage());
						}
						break xyz;//stop the loop
					case 2:
						try
						{
							System.out.println("Enter the amount");
							int a2=s.nextInt();
							if(!(a2>0 && a2%100==0))
							{
								BankMainClass bmc= new BankMainClass
										("Invalid amount");
								throw bmc;
							}//end of throw
							Deposit dp=new Deposit();
							dp.process(a2);
						}//end of try
						catch(BankMainClass bmc)
						{
							System.out.println(bmc.getMessage());
						}
						break xyz;//stop the loop
					default:
						System.out.println("Invalid choice...");
						break xyz;//stop the loop
					}//end of switch
				}//end of try
				catch(BankMainClass bmc)
				{
					System.out.println(bmc.getMessage());
					count++;
					if(count==3)
					{
						System.out.println("Transaction Blocked...");
						break;//loop stopped
					}
				}
			}//end of loop
		}
		finally
		{
			s.close();
		}
	}
}
