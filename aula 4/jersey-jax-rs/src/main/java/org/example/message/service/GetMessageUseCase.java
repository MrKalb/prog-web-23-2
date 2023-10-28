package org.example.message.service;

import org.example.message.entity.MessageEntity;
import org.example.message.response.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetMessageUseCase {

    public Message getMessage() {
        EntityManager entityManager =
                Persistence
                        .createEntityManagerFactory("jersey-jax-rs")
                        .createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        MessageEntity entity = new MessageEntity();
        try{
            transaction.begin();
            entity = entityManager.find(MessageEntity.class, 1L);
            transaction.commit();
        } finally {
            entityManager.clear();
            entityManager.close();
        }

        Message message = new Message();
        message.setMessage(entity.getMessage());
        return message;
    }

}
