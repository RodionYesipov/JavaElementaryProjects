package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private Publisher publisher;
    //@GetMapping("{id}")
    public void sendMsg(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        publisher.produceMsg("asdasd","12345 hello");
    }
}
