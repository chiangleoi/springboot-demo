package com.leo.springboot.service;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.spring.starter.core.RocketMQTemplate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用来发送  MQ 的消息
 * @author chian
 *
 */
@Service
public class RocketMQProviderService{
	
	// 使用 DefaultMQProducer
	@Autowired
	private DefaultMQProducer defaultMQProducer;
	
	// 使用 RocketMQTemplate
	@Autowired
	private RocketMQTemplate rocketMQTemplate;
	
	@Test
	public void test1() throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
		Message msg = new Message("leo-test", "oj8k".getBytes());
		
		SendResult send = defaultMQProducer.send(msg);
		
		System.out.println(send);
	}
	
	@Test
	public void test2() {
		
		rocketMQTemplate.convertAndSend("leo-test", "123123");
		
	}
}
