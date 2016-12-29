import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.spel.ast.Identifier;

import com.baizhi.service.IDemoService;


public class DubboUseage {
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		IDemoService demoService=(IDemoService) ctx.getBean("demoService");
		//打印代理类型 底层dubbo使用NIO的RCP做远程调度
		System.out.println("打印引用类型:"+demoService.getClass());
		
		//测试远程方法调度
		
		int sum=demoService.sum(1, 3);
		System.out.println("和："+sum);
	}
}
