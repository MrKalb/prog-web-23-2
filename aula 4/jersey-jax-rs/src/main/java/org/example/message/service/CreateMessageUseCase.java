package org.example.message.service;

import org.example.message.entity.MessageEntity;
import org.example.message.request.MessageRequest;
import org.example.message.response.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateMessageUseCase {

    public Message createMessage(MessageRequest messageRequest) {
        Message message = new Message();
        EntityManager entityManager =
                Persistence
                        .createEntityManagerFactory("jersey-jax-rs")
                        .createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            MessageEntity messageEntity = new MessageEntity();
            messageEntity.setId(1L);
            messageEntity.setMessage(messageRequest.getMessage());
            entityManager.persist(messageEntity);
            transaction.commit();
        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return message;
    }

}
