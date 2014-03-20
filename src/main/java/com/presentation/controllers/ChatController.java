package com.presentation.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @author jderuere
 */
@Controller
public class ChatController {

    @SubscribeMapping("/message2")
    public String subscribeMessage() throws Exception {
        return "Well subscribe";
    }

    @MessageMapping("/message")
    public String processMessage(String message, Principal principal) {
        return "From " + principal.getName() + " : " + message;
    }

    @SendToUser("/topic/message")
    @MessageMapping("/message/me")
    public String processMessageToMe(String message) {
        return message;
    }

//    @MessageExceptionHandler
//    @SendToUser("/queue/errors")
//    public String handleException(Throwable exception) {
//        return exception.getMessage();
//    }
}