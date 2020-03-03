package com.itwill.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.user.User;

//@MyMapper
@Mapper
public interface UserMapper {
	public User findUser(@Param("userId") String userId);
	public List<User> findUserList();
	public int create(User user) throws Exception;
	public int update(User user) throws Exception;
	public int remove(@Param(value = "userId") String userId) throws Exception;
	public int selectCountByUserId(@Param("userId") String userId) throws Exception;
}