package com.itwill.address;

public class AddressSQL {

	public static final String ADDRESS_INSERT=
"insert into address values(address_no_seq.nextval,?||address_no_seq.currval,?,?,?)";
	public static final String ADDRESS_DELETE=
"delete from address where no = ?";
	public static final String ADDRESS_UPDATE=
"update address set name=?,phone=?,address=? where no = ?";
	public static final String ADDRESS_SELECT_PK=
			"select no,id,name,phone,address from address where no = ?";
	public static final String ADDRESS_SELECT_ALL=
			"select no,id,name,phone,address from address";
}
