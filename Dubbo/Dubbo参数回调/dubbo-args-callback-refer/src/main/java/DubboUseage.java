import java.io.IOException;

import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.entity.Computer;
import com.dubbo.entity.User;
import com.dubbo.service.CallbackListener;
import com.dubbo.service.IDemoService;


@Log4j
public class DubboUseage {
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/config/applicationContext.xml");
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
		log.info(res.getName()+" "+res.getId());
		
	}
}
