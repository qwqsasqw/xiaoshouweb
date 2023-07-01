package com.lx.shop.dao.mapper;

import com.lx.shop.dao.pojo.Car;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CarMapper {

    @Insert("insert into car(cid,gname,gnum,total,gprice,gimg,gid,gdesc,create_time,update_time,username) values(0,#{gname},#{gnum},#{total},#{gprice},#{gimg},#{gid},#{gdesc},DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'),null,#{username})")
    int saveCar(Car car);

    @Update("update car set gnum =gnum+#{gnum} , total=total+#{total} , update_time = DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s') where gid =#{gid} and username = #{username}")
    int updateCar(Car car);

    @Select("select cid from car where gid =#{gid} and username = #{username}")
    Car carInfoIsExist(Integer gid,String username);

    @Select(" select cid,gname,gnum,total,gprice,gimg,gid,gdesc,create_time,update_time,username from car where username =#{username} ")
    List<Car> getCarInfoByUserName(String username);
    @Delete("delete from car where cid =#{cid}")
    int deleteCarInfoByCid(Integer cid);

    @Delete("delete from car where username =#{username}")
    int clearCarByUserName(String userName);
}
