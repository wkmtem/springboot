package com.compass.examination.core.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.compass.examination.pojo.bo.ResultBO;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public ResultBO test() throws Exception {
		return new ResultBO("RC000", "SUCCESS", new Date());
	}
}
