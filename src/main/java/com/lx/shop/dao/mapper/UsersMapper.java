package com.lx.shop.dao.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.shop.dao.pojo.UserInfo;
import com.lx.shop.dao.pojo.Users;
import com.lx.shop.vo.params.GoodsParam;
import com.lx.shop.vo.params.LoginParam;
import com.lx.shop.vo.params.UserParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UsersMapper extends BaseMapper<Users> {


    @Select("select uid,username,password,register_time,last_login_time,status from users where  username=#{username}")
    public Users selectUsersByUserName(String username);


    @Select("select uid,username,password,register_time,last_login_time,status from users where username=#{username} and password=#{password}  ")
    public Users findUser(LoginParam LoginParam);

    @Update("update users set status=1,last_login_time =DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s') where username=#{username} and status =0")
    public int updateLoginStatus(String username);

    @Insert(" INSERT INTO users(uid,username,password,register_time,last_login_time,status,email) values(0,#{username},#{password},DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'),null,0,#{email})")
    public int insert(Users user);
    @Insert("insert into user_info(uinfo_id,uid,uname,gender,birthday,phone,address,profile,balance) values(0,#{uid},'用户',0,DATE_FORMAT(now(),'%Y-%m-%d'),'073143567xx','湖南省永州市零陵区湖南科技学院',null,0.00)")
    public int creatDefaultUserInfo(int uid);

    @Update("update users set status=0 where username=#{username} and status=1")
    public int loginOut(String username);

    @Select("select uid from users where username =#{username}")
    public Users getUserByUserName(String username);

    @Select("select uinfo_id,uid,uname,gender,birthday,phone,address,profile,balance from user_info where uid =#{uid}")
    public UserInfo getUserInfoByUserName(Integer uid);

    @Update("update user_info set balance=balance-#{totalMoney} where uid =#{uid}")
    public int changeUserBalance(int uid,double totalMoney);

    @Update("update user_info set balance=balance+#{balance} where uid =#{uid}")
    public int reChargeUserBalance(int uid,double balance);

    @Select("select password,username from users where email =#{email}")
    public Users emailIsExist(String email);

    @Select("select password,username from users where email =#{email} and username =#{username}")
    public Users emailIsExistByUserName(String email,String username);

    @Update("update users set password = #{password} where username =#{username} and email =#{email}")
    public int changePassword(Users users);

    @Select("select u.username,ui.uname,ui.phone,ui.address,u.last_login_time,u.register_time from users u left join user_info ui on u.uid = ui.uid  ")
    IPage<UserParam> getUserInfoByPage(IPage<UserParam> page);
}
