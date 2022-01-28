package top.cgblogs.testdemo1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.cgblogs.testdemo1.entity.User;
import top.cgblogs.testdemo1.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.List;

@Api("Demo1接口")
@RestController
@RequestMapping("/demo1")
public class Demo1Controller {

    @Resource
    private UserMapper userMapper;

    @ApiOperation("返回问候消息")
    @RequestMapping("/getData")
    public String index(@RequestParam("name") String name) {
        return "I am demo1 hello " + name;
    }

    @ApiOperation("返回全部用户")
    @RequestMapping("/users")
    public List<User> getUsers() {
        return userMapper.selectList(new QueryWrapper<User>());
    }

    @ApiOperation("分布式分支事务测试")
    @Transactional
    @RequestMapping("/trans")
    public String demoTransactional() {
        User user = userMapper.selectById(1);
        user.setLevel(user.getLevel()+1);
        //测试分布式事务回滚
//        int i = 1/0;
//        System.out.println(i);
        userMapper.updateById(user);
        return "success";
    }
}
