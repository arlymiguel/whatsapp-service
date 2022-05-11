package com.whatsapp.controller;

import com.whatsapp.model.Message;
import com.whatsapp.model.OutputMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
public class MessageController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) throws Exception {
        log.info("message: {}", message);
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        OutputMessage outputMsg = new OutputMessage(message.getFrom(), message.getText(), time);
        log.info("outputMsg: {}", outputMsg);
        return outputMsg;
    }

}
