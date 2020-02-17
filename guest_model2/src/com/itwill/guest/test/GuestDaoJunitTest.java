package com.itwill.guest.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;

public class GuestDaoJunitTest {
	static GuestDao guestDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		guestDao = new GuestDao(JavaSeDataSource.getDataSource());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void selectAll() throws Exception {
		/*
	    assertArrayEquals(a,b) : 배열 a와b가 일치함을 확인
		assertEquals(a,b) : 객체 a와b의 값이 같은지 확인
		assertSame(a,b) : 객체 a와b가 같은 객체임을 확인
		assertTrue(a) : a가 참인지 확인
		assertNotNull(a) : a객체가 null이 아님을 확인
		이외에도 다양한 단정문이 존재합니다. 
			http://junit.sourceforge.net/javadoc/org/junit/Assert.html
		 */
		GuestDao guestDao=new GuestDao(JavaSeDataSource.getDataSource());
		assertNotEquals(0,guestDao.selectAll().size());
		assertNotNull(guestDao.selectAll());
	}
	@Test
	public void selectByNo() throws Exception{
		GuestDao guestDao=new GuestDao(JavaSeDataSource.getDataSource());
		assertNull(guestDao.selectByNo(345234324));
	}
	
	@Test
	@Ignore
	public void insertGuest() throws Exception{
		Guest insertGuest=new Guest(-999, "guest_name", null, "guest_email", "guest_homepage", "guest_title", "guest_content");
		assertTrue(guestDao.insertGuest(insertGuest));
		
	}
	@Test
	public void updateGuest() throws Exception{
		Guest guest = guestDao.selectByNo(5);
		assertEquals(5, guest.guest_no);
		assertTrue("수정성공",guestDao.updateGuest(guest) );
	}
	

}















