package com.ftc.wechat.task.order;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ftc.wechat.order.service.OrderService;

@Component
public class AutoReceiving {
	@Resource
	private OrderService orderservice;
	
	@Scheduled(cron="0 0 1 * * ?") //每晚1点触发
	public void taskCycle(){  
		orderservice.AutoReceiving();
    }  
}
