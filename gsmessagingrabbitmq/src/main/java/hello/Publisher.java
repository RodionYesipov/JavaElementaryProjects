package hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Publisher {

    @Autowired
    private AmqpTemplate amqpTemplate;



    @Value("${robot.rabbitmq.exchange}")
    private String exchange;
    @Value("${robot.rabbitmq.q.routingkey}")
    private String transaction;


    public void produceMsg(String id,String msg){
        Message message = MessageBuilder
                .withBody(msg.getBytes())
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setCorrelationId(id)
                .build();
        System.out.println("Send message!!!!!!!!!!!!");
        amqpTemplate.convertAndSend(exchange, transaction,message);
    }


}
