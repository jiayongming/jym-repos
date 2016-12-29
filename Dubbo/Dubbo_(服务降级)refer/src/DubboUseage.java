import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baizhi.entity.User;
import com.baizhi.service.IDemoService;


public class DubboUseage {
	public static void main(String[] args) throws IOException {
		//ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//IDemoService bean = (IDemoService) ctx.getBean("demoService");
		
		
		//User user = bean.methodInvoke(1, "jiangzz");
		
		//System.out.println(user.getName()+"  "+user.getId());
	}
}
