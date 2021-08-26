package com.bz.dao;


import com.bz.entity.MyUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserDao {

    /**
     * 分页返回所有用户
     * @param myUser
     * @return
     */
     List<MyUser> getFuzzyUserByPage(MyUser myUser);

    //计算所有用户数量
    // @Select("select count(*) from My_user")
    // Long countAllUser();

    /**
     *
     * 通过id返回用户
     * @param userId
     * @return
     */
    @Select("select * from my_user where user_id = #{userId}")
    MyUser getUserById(Integer userId);

    /**
     * 通过手机返回用户
     * @param phone
     * @return
     */
    MyUser checkPhoneUnique(String phone);

    /**
     * 通过用户名返回用户
     * @param userName
     * @return
     */
    MyUser checkUsernameUnique(String userName);
    /**
     * 更新用户
     * @param myUser
     * @return
     */
    int updateUser(MyUser myUser);



    /**
     * 插入用户
     * @param myUser
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    @Insert("insert into my_user(address, user_name, password, nick_name, phone, status, is_del, create_time, update_time) values(#{address},#{userName}, #{password}, #{nickName}, #{phone}, #{status}, ${isDel}, now(), now())")
    int save(MyUser myUser);

    /**
     * 通过id删除用户
     * @param userId
     * @return
     */
    @Update("update my_user set is_del = 1, status = 0 where user_id = #{userId}")
    int deleteUserById(Integer userId);

//	@Delete("delete from my_user where user_id = #{userId}")
//	int deleteUserById(Integer userId);




	/**
     *  根据用户名查询用户
     * @param userName
     * @return
     */
    @Select("select * from my_user t where t.user_name = #{userName}")
    MyUser getUser(String userName);

	List<MyUser> getUserBystatus();

	int get(@Param("deptId") Integer deptId);

	List<MyUser> getGroupUserByPage(MyUser myUser);

	MyUser getUserStatusByName(String userName);

	List<MyUser> getDept();

	int updatePwd(MyUser user);

	MyUser getUserAndDeptById(Integer userId);

	List<Integer> getUserIdBystatus();

	Integer getUserByName(@Param("userName") String userName);
}
