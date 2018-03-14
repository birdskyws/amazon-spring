package net.fbamate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.fbamate.Entity.*;
import net.fbamate.util.Oss;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired
	private TasklistRepository tasklistRespository;
	
	
	@GetMapping(path="/pic")
	public @ResponseBody String pic (@RequestParam String tid) throws IOException {
		//TODO 接受参数
		Integer id = Integer.valueOf(tid); 
		Tasklist t = new Tasklist();
		t = tasklistRespository.findOneById(id);
		//TODO 读取数据库
		t.getPic();
		// 上传到Oss上
		String filename = "/home/capture/"+t.getPic();
		Oss.uploadPic(t.getPic(), filename);
		return t.getPic();

	}
	

}
