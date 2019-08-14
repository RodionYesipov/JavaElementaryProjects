package hello;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class Subcriber {
    private Type tsoSlaMetricType = new TypeToken<String>() {}.getType();


    @RabbitListener(queues="${robot.rabbitmq.q.average_hour}")
    @Async
    public void recievedMessageB(Message msg) {
       new Gson().fromJson(new String(msg.getBody()), tsoSlaMetricType);
        return;
    }

}
