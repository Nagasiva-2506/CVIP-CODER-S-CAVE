package p1;
public class WithDraw extends Exception implements Transaction
{
	public WithDraw(String msg)
	{
		super(msg);
	}
	public void process(int amt)throws WithDraw
	{
		try
		{
			if(amt>b.bal)//exception
			{
				WithDraw ob=new WithDraw
						("Insufficient fund");
				throw ob;
			}
			System.out.println("Amount Withdrawn+"+amt);
			b.bal=b.bal-amt;
			System.out.println("Bakance amount="+b.getBalance());
			System.out.println("Transaction Completed");
		}//end of try
		catch(WithDraw ob)
		{
			throw ob;
		}
	}
}
