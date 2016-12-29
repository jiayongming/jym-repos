import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.spel.ast.Identifier;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.cluster.support.FailoverCluster;
import com.baizhi.entity.Computer;
import com.baizhi.entity.User;
import com.baizhi.service.CallbackListener;
import com.baizhi.service.IDemoService;


public class DubboUseage {
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		IDemoService demoService=(IDemoService) ctx.getBean("demoService");
		
		Computer res=demoService.methodInvoke("zhangsan", new CallbackListener() {
				public User callBack(User v) {
					// TODO Auto-generated method stub
					Computer computer=new Computer();
					computer.setName("客户端设置的Computer");
					v.setComputer(computer);
					return v;
				}
			
		});
		System.out.println(res.getName()+" "+res.getId());
		
	}
}
