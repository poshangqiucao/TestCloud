package top.cgblogs.testdemo2.controller;

import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.cgblogs.testdemo2.entity.User;
import top.cgblogs.testdemo2.mapper.UserMapper;
import top.cgblogs.testdemo2.remote.RemoteDemo1;

import javax.annotation.Resource;

@Api("demo2接口")
@RestController
@RequestMapping("/demo2")
public class Demo2Controller {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private RemoteDemo1 demo1;

    @ApiOperation("返回远程调用接口消息")
    @RequestMapping("/getData")
    public String index(@RequestParam("name") String name) {
        return demo1.index(name);
    }

    @ApiOperation("分布式事务调用端-事务发起者")
    @GlobalTransactional
    @RequestMapping("/trans")
    public String demo2Transactional() {
        User user = userMapper.selectById(2);
        user.setLevel(user.getLevel()+1);
        userMapper.updateById(user);
        return demo1.demoTransactional();
    }

}
