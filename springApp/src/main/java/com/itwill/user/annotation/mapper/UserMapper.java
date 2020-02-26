package com.itwill.user.annotation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.user.User;
/*
별도의 mapper xml을 만들 필요는 없지만, dynamic query를 사용하지 못하는 등의 제약사항이 따름
 */
//@Mapper
//@MyMapper
public interface UserMapper {
	@Select("select userId,password,name,email from userinfo where userId=#{userId}")
	public User findUser(@Param("userId") String userId);
	@Select("select userId,password,name,email from userinfo")
	public List<User> findUserList();
	@Insert("insert into userinfo values(#{userId},#{password},#{name},#{email})")
	public int create(User user) throws Exception;
	@Update("update userinfo set password=#{password},name=#{name},email=#{email} where userId=#{userId}")
	public int update(User user) throws Exception;
	@Delete("delete from userinfo where userId=#{userId}")
	public int remove(@Param(value = "userId") String userId) throws Exception;
	@Select("select count(*) cnt from userinfo where userId=#{userId}")
	public int selectCountByUserId(@Param("userId") String userId) throws Exception;
}