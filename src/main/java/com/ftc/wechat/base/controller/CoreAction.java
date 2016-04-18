package com.ftc.wechat.base.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ftc.wechat.base.param.CheckSignature;
import com.ftc.wechat.base.util.SignUtil;

@Controller
@RequestMapping("/coreAction")
public class CoreAction {
	
	@RequestMapping(value = "checkSignature",method = RequestMethod.GET) 
	public void checkSignature(HttpServletRequest request, HttpServletResponse response,CheckSignature checkSign) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (SignUtil.checkSignature(checkSign.getSignature(), checkSign.getTimestamp(), checkSign.getNonce())) {
				out.print(checkSign.getEchostr());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
			out = null;
		}
	}
}
