import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.spel.ast.Identifier;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.cluster.support.FailoverCluster;
import com.baizhi.entity.Computer;
import com.baizhi.entity.User;
import com.baizhi.service.IDemoService;


public class DubboUseage {
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		IDemoService demoService=(IDemoService) ctx.getBean("demoService");
		try {
			User user = demoService.methodInvoke(-1, "jiangzz");
			System.out.println(user.getName()+"  "+user.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
}
