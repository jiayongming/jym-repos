import java.io.IOException;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.spel.ast.Identifier;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.cluster.support.FailoverCluster;
import com.baizhi.entity.User;
import com.baizhi.service.IDemoService;


public class DubboUseage {
	public static void main(String[] args) throws IOException {
		
	   ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

	   IDemoService demoService=(IDemoService) ctx.getBean("demoService");
	   Object date= demoService.sum(1, 3);
	   System.out.println(date.toString());
	   
	   User user=new User();
	   user.setId(1);
	   user.setName("张三");
	   Object obj= demoService.saveUser(user);
	   System.out.println(obj.toString());
	   
	   
	}
}
