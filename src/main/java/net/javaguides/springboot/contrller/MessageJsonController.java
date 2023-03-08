package net.javaguides.springboot.contrller;

import net.javaguides.springboot.dto.User;
import net.javaguides.springboot.publisher.RabbitMQJsonProducer;
import net.javaguides.springboot.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

    private RabbitMQJsonProducer jsonProducer;

    public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {

        jsonProducer.sendJsonMessage(user);

        return ResponseEntity.ok("Json message sent to RabbitMQ ...");
    }
}
