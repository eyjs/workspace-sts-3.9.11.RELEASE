package dao.address;

import java.util.ArrayList;

public class AddressDao3TestMain {

	public static void main(String[] args) throws Exception{
		AddressDao3 addressDao3=new AddressDao3();
		int rowCount=-999;
		System.out.println("-----------insert1----------");
		//rowCount = addressDao3.insert("ttt","김경미","230-9090","LA");
		System.out.println("inset row:"+rowCount);
		System.out.println("-----------insert2----------");
		//rowCount = addressDao3.insert(new Address(-9999, "vvv", "최경녀","333-8598", "강원도"));
		System.out.println("inset row:"+rowCount);
		System.out.println("----------update------------");
		Address updateAddress=new Address(1, "guard", "김변경", "333-3333", "변경주소");
		rowCount=addressDao3.update(updateAddress);
		System.out.println("update count:"+rowCount);
		System.out.println("----------delete------------");
		rowCount=addressDao3.delete(1);
		System.out.println("delete row:"+rowCount);
		
		System.out.println("----------selectByPk------------");
		Address address=addressDao3.selectByPk(5);
		System.out.println(address);
		System.out.println(addressDao3.selectByPk(3));
		System.out.println(addressDao3.selectByPk(4));
		System.out.println(addressDao3.selectByPk(1));
		System.out.println(addressDao3.selectByPk(10));
		System.out.println("----------selectAll------------");
		ArrayList<Address> addressList= addressDao3.selectAll();
		System.out.println(addressList);
		
	}

}












