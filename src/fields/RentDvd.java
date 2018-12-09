package fields;

public interface RentDvd {
	public boolean returnDVD(String name, int stock)throws MyException;
	public double rentDVD(String name,int day,int stock) throws MyException ;
}
