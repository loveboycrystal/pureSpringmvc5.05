package com.chenes.control;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.chenes.entity.DemoEntity;
import com.chenes.entity.ResultData;

/**
 * TODO DEMO测试控制类
 * @author chenes
 * @create time: 2018年5月2日
 * @version 1.0.0
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
	
	private static final Logger logger = LogManager.getLogger(DemoController.class);
	
	@RequestMapping("/toLogin.do")
	@ResponseBody
	private MappingJackson2JsonView toLogin(){
		logger.info("enter toLogin...");
		System.out.println("enter tologin...");
		DemoEntity det = new DemoEntity();
		det.setDemoID(1001L);
		det.setProName("Demo测试请求");
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		result.put("data", det);
		result.put("error", "");
		result.put("totalRecords", 1);
		MappingJackson2JsonView mappingJackson2JsonView = new MappingJackson2JsonView();
		mappingJackson2JsonView.setAttributesMap(result);
		return mappingJackson2JsonView;  
	}
	
	@RequestMapping("/test2.do")
	@ResponseBody
	private DemoEntity test2(){
		try {
			System.out.println("enter test2...");
			logger.info("enter test2...");
			DemoEntity det = new DemoEntity();
			det.setDemoID(1001L);
			det.setProName("Demo测试请求");
			
			return det;  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value="{id:[a-z]+}/{name}.do", method = RequestMethod.GET)
	private ResultData test3(@PathVariable("id") String id,@PathVariable("name") String name) throws Exception{
		ResultData resData = new ResultData();
		resData.setMsg("done ok");
		resData.setRescode("100");
		resData.setData("id="+id+"  name="+name);
		return resData;
	}
}

