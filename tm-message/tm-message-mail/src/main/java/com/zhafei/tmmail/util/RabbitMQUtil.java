package com.zhafei.tmmail.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.zhafei.common.dto.MailDto;
import com.zhafei.tmmail.mail.MailUtil;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * mq消费者
 * bean的包结构不一样会导致反序列化失败
 */
@Component
public class RabbitMQUtil {
	
	/**
	 * 	组合使用监听
	 * 	@RabbitListener @QueueBinding @Queue @Exchange
	 * @param message
	 * @param channel
	 * @throws Exception
	 */
	@RabbitListener(bindings = @QueueBinding(
					value = @Queue(value = "queue-1", durable = "true"),
					exchange = @Exchange(name = "captcha",
					durable = "true",
					type = "direct",
					ignoreDeclarationExceptions = "true"),
					key = "tm.email"
				)
			)
	@RabbitHandler
	public void process(Message<?> message, Channel channel) throws Exception {
		boolean redelivered = (boolean) message.getHeaders().get(AmqpHeaders.REDELIVERED);
		Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
		try {
			//1. 收到消息以后进行业务端消费处理
			System.err.println("消费消息:" + message.getPayload());
			ObjectMapper mapper=new ObjectMapper();
			MailDto mailDto=mapper.readValue(message.getPayload().toString(), MailDto.class);
			System.out.println(mailDto.getId());
			MailUtil.sendMail(mailDto);
			//  2. 处理成功之后 获取deliveryTag 并进行手工的ACK操作, 因为我们配置文件里配置的是 手工签收
			//	spring.rabbitmq.listener.simple.acknowledge-mode=manual
			System.out.println(message.getHeaders().get(AmqpHeaders.REDELIVERED)+"");
			channel.basicAck(deliveryTag, false);
		} catch (Exception e) {
			if(redelivered) {
				System.err.println("消费消息失败:{}" + message.getPayload());
				channel.basicReject(deliveryTag, false);
			}else {
				e.printStackTrace();
				System.err.println("消费消息失败:{}" + message.getPayload());
				 //重新入队一次
                channel.basicNack(deliveryTag,false,true);
			}
		}
		
	}
}
