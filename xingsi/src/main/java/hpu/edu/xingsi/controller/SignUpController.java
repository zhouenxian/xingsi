package hpu.edu.xingsi.controller;

import hpu.edu.xingsi.mapper.UserMapper;
import hpu.edu.xingsi.pojo.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhou'en'xian
 * @date 2020/9/7  17:19
 */
@RestController
public class SignUpController {
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Resource
    private UserMapper userMapper;
    @PostMapping("/sign/up")
    public void sign(@RequestBody User user){
        System.out.println(user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userMapper.insertUser(user);
    }
}
