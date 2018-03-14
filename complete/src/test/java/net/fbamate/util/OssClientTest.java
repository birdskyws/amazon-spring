package net.fbamate.util;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import net.fbamate.util.Oss;


@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = {"classpath:application.properties"})
@SpringBootTest
public class OssClientTest {
	@Test
	public void testJunit() {
		System.out.println("junit running");
	}
	@Test
	public void testOss() throws IOException
	{
		Oss.uploadPic("201803121112.jpg", "d:/1.jpg");
	}
}
