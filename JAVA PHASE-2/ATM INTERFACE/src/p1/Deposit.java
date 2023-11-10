package p1;
public class Deposit implements Transaction
{
	public void process(int amt)
	{
		System.out.println("Amount deposited="+amt);
		b.bal=b.bal+amt;
		System.out.println("Balance amt:"+b.getBalance());
		System.out.println("Transaction completed...");
	}
}
