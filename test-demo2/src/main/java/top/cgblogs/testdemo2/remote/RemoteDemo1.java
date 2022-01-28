package top.cgblogs.testdemo2.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "test-demo1")
public interface RemoteDemo1 {

    @RequestMapping("/demo1/getData")
    String index(@RequestParam("name") String name);

    @RequestMapping("/demo1/trans")
    String demoTransactional();

}
