package p1;
public interface Transaction {
	public Balance b = new Balance();
	public abstract void process(int amt)throws WithDraw;
}
