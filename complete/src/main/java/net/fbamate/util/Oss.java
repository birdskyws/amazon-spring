package net.fbamate.util;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;


import com.aliyun.oss.OSSClient;


public class Oss {
	
	public static OSSClient  getClient() throws IOException
	{
		OSSClient client = null;
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("oss.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        String endpoint = properties.getProperty("oss.endpoint");
        String accessKeyId = properties.getProperty("oss.accessKeyId");
        String accessKeySecret = properties.getProperty("oss.accessKeySecret");
        client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		return client;
	}
	

	
	public static void uploadPic(String key,String filename) throws IOException
	{
		
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("oss.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String bucket = properties.getProperty("oss.bucket");
		OSSClient client = Oss.getClient();
		client.putObject(bucket, key, new File(filename));
		client.shutdown();
	}
	
}
