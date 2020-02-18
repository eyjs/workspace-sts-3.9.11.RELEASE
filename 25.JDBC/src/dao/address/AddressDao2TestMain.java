package dao.address;

import java.util.ArrayList;

public class AddressDao2TestMain {

	public static void main(String[] args) throws Exception{
		AddressDao2 addressDao2=new AddressDao2();
		int rowCount=-999;
		System.out.println("-----------insert1----------");
		//rowCount = addressDao2.insert("ttt","����","230-9090","LA");
		System.out.println("inset row:"+rowCount);
		System.out.println("-----------insert2----------");
		//rowCount = addressDao2.insert(new Address(-9999, "vvv", "�ְ��","333-8598", "������"));
		System.out.println("inset row:"+rowCount);
		System.out.println("----------update------------");
		Address updateAddress=new Address(1, "guard", "�躯��", "333-3333", "�����ּ�");
		rowCount=addressDao2.update(updateAddress);
		System.out.println("update count:"+rowCount);
		System.out.println("----------delete------------");
		rowCount=addressDao2.delete(1);
		System.out.println("delete row:"+rowCount);
		
		System.out.println("----------selectByPk------------");
		Address address=addressDao2.selectByPk(5);
		System.out.println(address);
		System.out.println(addressDao2.selectByPk(3));
		System.out.println(addressDao2.selectByPk(4));
		System.out.println(addressDao2.selectByPk(1));
		System.out.println(addressDao2.selectByPk(10));
		System.out.println("----------selectAll------------");
		ArrayList<Address> addressList= addressDao2.selectAll();
		System.out.println(addressList);
		
	}

}












