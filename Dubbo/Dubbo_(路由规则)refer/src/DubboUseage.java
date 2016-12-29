import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcContext;
import com.baizhi.service.IDemoServiceA;
import com.baizhi.service.IDemoServiceB;


public class DubboUseage {
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
        IDemoServiceA demoServiceA=(IDemoServiceA) ctx.getBean("demoServiceA");
        int sum = demoServiceA.sum(1, 2);
        System.out.println(sum);
        
        String localAddressString = RpcContext.getContext().getLocalAddress().getHostName();
        System.out.println(localAddressString);
        IDemoServiceB demoServiceB=(IDemoServiceB) ctx.getBean("demoServiceB");
        int minus = demoServiceB.minus(1, 2);
        System.out.println(minus);
	}
	
}
