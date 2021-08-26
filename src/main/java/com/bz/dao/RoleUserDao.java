package com.bz.dao;

import com.bz.entity.MyRoleUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Mapper
public interface RoleUserDao {
    /**
     * 通过角色id返回所有用户
     * @param id
     * @return
     */
    @Select("select * from my_role_user ru where ru.role_id = #{roleId}")
    List<MyRoleUser> listAllRoleUserByRoleId(Integer id);



    /**
     * 通过用户id查询权限id
     * @param userId
     * @return
     */
    @Select("select * from my_role_user ru where ru.user_id = #{userId}")
    List<MyRoleUser> getMyRoleUserByUserId(Integer userId);

    /**
     * 通过用户id返回角色
     * @param intValue
     * @return
     */
    @Select("select * from my_role_user ru where ru.user_id = #{userId}")
    MyRoleUser getRoleUserByUserId(int intValue);

    /**
     * 更新
     * @param myRoleUser
     * @return
     */
    int updateMyRoleUser(MyRoleUser myRoleUser);

    /**
     * 新建
     * @param myRoleUser
     * @return
     */
    @Insert("insert into my_role_user(user_id, role_id) values(#{userId}, #{roleId})")
    int save(MyRoleUser myRoleUser);

    /**
     * 删除
     * @param id
     * @return
     */
    @Delete("delete from my_role_user where user_id = #{userId}")
    int deleteRoleUserByUserId(Integer id);

	@Update("update my_user set last_login_ip = #{lastLoginIp}, login_times = login_times + 1 where user_id = #{userId}")
	int updateUserIp(@Param("userId") Integer userId, @Param("lastLoginIp") String lastLoginIp);
}
