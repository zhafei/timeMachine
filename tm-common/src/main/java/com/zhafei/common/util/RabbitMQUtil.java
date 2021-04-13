package com.zhafei.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @author yyf
 */
@Component
public class RabbitMQUtil {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RabbitTemplate rabbitTemplate;
	/**
	 * 	这里就是确认消息的回调监听接口，用于确认消息是否被broker所收到
	 */
	private final RabbitTemplate.ConfirmCallback confirmCallback = (correlationData, ack, s) -> {
        if (ack) {
            System.out.println(correlationData.getId());
        } else {
            log.error("ConfirmCallback消息发送失败: {}", s);
        }
    };
    private final RabbitTemplate.ReturnsCallback returnsCallback =  (returned)->{
    	log.error("ReturnCallback消息发送失败: {}", new String(returned.getMessage().getBody(), StandardCharsets.UTF_8));
    };

    /**
     * 发送消息
     * @param exchangeName
     * @param routingKeyName
     * @param content
     * @param <T>
     *
     */
    public <T> void sendMsg(String exchangeName, String routingKeyName, T content)  {
        ObjectMapper mapper = new ObjectMapper();
        // 设置每个消息都返回一个确认消息
        this.rabbitTemplate.setMandatory(true);
        // 消息确认机制
        this.rabbitTemplate.setConfirmCallback(confirmCallback);
        // 消息发送失败机制
        this.rabbitTemplate.setReturnsCallback(returnsCallback);
        // 异步发送消息
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(UUID.randomUUID().toString());
        try {
            this.rabbitTemplate.convertAndSend(exchangeName, routingKeyName, mapper.writeValueAsString(content), correlationData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
