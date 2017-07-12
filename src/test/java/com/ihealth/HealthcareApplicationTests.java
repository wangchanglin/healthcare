package com.ihealth;

import com.ihealth.domian.User;
import com.ihealth.service.UserService;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.StringWriter;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HealthcareApplicationTests {

	@Autowired
	private UserService userSerivce;
	@Autowired
	private JdbcTemplate jdbcTemplate;



	@Test
	public void test() throws Exception {

		/* 首先，初始化运行时引擎，使用默认的配置 */
		Velocity.init();
        /* 创建Context对象，然后把数据放进去 */
		VelocityContext context = new VelocityContext();
        /* 渲染模板 */
		StringWriter w = new StringWriter();
		String s = "We are using $project $name to render this.";
		String sql = "SELECT * FROM user WHERE 1=1  #if($beginDate && $beginDate)and createTime >= $beginDate and createTime<= $endDate #end";
		context.put("beginDate", "'2017-07-01'");
		context.put("endDate", "'2017-07-08'" );
		Map<String,Object> whereMap = new HashMap<>();
		whereMap.put("beginDate", "'2017-07-01'");
		whereMap.put("endDate", "'2017-07-08'" );
		w = new StringWriter();
		Velocity.evaluate( context, w, "mystring", sql);
		RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
		List<User> users1 = jdbcTemplate.query(w.toString(),rowMapper);
		System.out.println(" string : " + w );


	}

}
