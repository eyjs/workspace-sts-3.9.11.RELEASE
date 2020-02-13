package com.itwill.address;

import java.util.ArrayList;

public class AddressService {
	private AddressDao addressDao;
	public AddressService() {
		addressDao=new AddressDao();
	}
	
	public ArrayList<Address> findAll() throws Exception{
		return addressDao.selectAll();
	}
	public Address findByNo(int no) throws Exception{
		return addressDao.selectByPk(no);
	}
	public int insert(Address address) throws Exception{
		return addressDao.insert(address);
	}
	public int delete(int no) throws Exception{
		return addressDao.delete(no);
	}
	public int update(Address address)throws Exception {
		return addressDao.update(address);
	}
		
	
	
	
}
