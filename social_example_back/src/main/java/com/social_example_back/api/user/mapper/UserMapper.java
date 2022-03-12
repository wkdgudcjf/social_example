package com.social_example_back.api.user.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.social_example_back.api.user.entity.MyUser;
import com.social_example_back.config.db.MysqlDatasourceSelector;

@MysqlDatasourceSelector.User
@Mapper
public interface UserMapper {
    MyUser selectUser(String email);
    List<MyUser> selectUserList();
	public void insertUser(MyUser myUser) throws Exception;
	public void deleteUser(String email) throws Exception;
	public void updateUser(MyUser myUser) throws Exception;
}
