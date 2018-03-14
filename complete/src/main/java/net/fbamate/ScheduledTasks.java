package net.fbamate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.fbamate.Entity.*;

import java.io.IOException;
import java.sql.Timestamp; 

@Component
public class ScheduledTasks {

	@Autowired
	private AordRepository aordRepository;
	@Autowired
	private TasklistRepository tasklistRepository;
	
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static final SimpleDateFormat picFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final String cmdPattern = "casperjs --ignore-ssl-errors=yes --ssl-protocol=any  /home/amazon2.js --pic=%s --oid=%s --tid=%d";
    

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
    	
        log.info("The time is now {}", dateFormat.format(new Date()));
        //TODO 读取数据库
        Date date =  new Date();
     
        long now = date.getTime();
		long expire = date.getTime();
		
		log.info("The time is now {}", now);
        Aord aord = aordRepository.findFirstByTasktimeLessThanAndExpireGreaterThan(new Timestamp(now),new Timestamp(expire)); 
        if(aord!=null)
        {
        	System.out.println(aord.getOid());
        	//TODO 从配置文件中读取数据
        	long tasktime = now +3*60*1000;
        	aord.setTasktime(new Timestamp(tasktime));
        	//调整aord的tasktime字段，指定下一次执行的时间
        	aord = aordRepository.save(aord);
        	
            // TODO 添加tasklist
            
        	Tasklist t =  new Tasklist();
            t.setAid(aord.getId());
            t.setOid(aord.getOid());
            t.setCatdo(0);
            t.setState(0);
            t.setSellors("");
            t.setTasktime(new Timestamp(now));
            Random random = new Random();
            int postfix = Math.abs(random.nextInt())%10;
            String pic  = picFormat.format(date)+postfix+".jpg";
            t.setPic(pic);
            tasklistRepository.save(t);           
            //TODO 拼接字符串
            String cmd = String.format(cmdPattern, pic,t.getOid(),t.getId());
            log.info(cmd);
            
            //TODO 调用外部接口
            try {
				Runtime.getRuntime().exec(cmd);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}        	
        	
        }
        

    }
}
