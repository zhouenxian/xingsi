package hpu.edu.xingsi.mapper;

import hpu.edu.xingsi.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


/**
 * @author zhou'en'xian
 * @date 2020/9/7  16:06
 */
@Mapper
public interface UserMapper {
    @Select("select * from admin where username=#{username}")
    User loadUserByUsername(String username);
    @Insert("insert into admin(username,password)values(#{username},#{password})")
    int insertUser(User user);
}
