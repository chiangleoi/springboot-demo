package com.leo.springboot.service;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.UtilAll;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.spring.starter.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.starter.core.RocketMQListener;
import org.apache.rocketmq.spring.starter.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Service;

/**
 * 用来消费  MQ 的消息
 * @author chian
 *
 */
@Service
@RocketMQMessageListener(topic = "olami-test", consumerGroup = "leopapa")
public class RocketMQConsumerService implements RocketMQListener<String>, RocketMQPushConsumerLifecycleListener{

    public void onMessage(String orderPaidEvent) {
        System.out.printf("received orderPaidEvent: %s", orderPaidEvent);
    }
    
    /**
     * 配置方法，设置从哪里开始消费
     * 
     */
    @Override
    public void prepareStart(final DefaultMQPushConsumer consumer) {
        // 从当前时间点开始消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_TIMESTAMP);
        consumer.setConsumeTimestamp(UtilAll.timeMillisToHumanString3(System.currentTimeMillis()));
        
        // 从第一条开始消费
        // consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        
        // 从最后一条开始消费
        // consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
    }
}
