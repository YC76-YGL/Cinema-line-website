package com.yc.clw;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.clw.biz.MailService;

@SpringBootTest
class IndexTestApplication {

	@Resource
	private MailService ms;
	
	@Test
	public void test2() {
		ms.sendSimpleMail("1481835274@qq.com", "测试邮件", 
				"文件夹区域”是由“我的文件夹”、“其他邮箱”、“记事本”组成。加锁即对这几部分设置密码，以保护你的信息。");
	}

}
