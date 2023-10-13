package org.example.message.service;

import org.example.message.request.MessageRequest;
import org.example.message.response.Message;

public class CreateMessageUseCase {

    public Message createMessage(MessageRequest messageRequest) {
        Message message = new Message();
        message.setMessage(messageRequest.getMessage());
        return message;
    }

}
