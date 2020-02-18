package dao.address;

public class AddressDao1TestMain {

	public static void main(String[] args) throws Exception{
		AddressDao1 addressDao1=new AddressDao1();
		addressDao1.insert();
		addressDao1.update();
		addressDao1.delete();
		addressDao1.selectByPk();
		addressDao1.selectAll();
	}

}
