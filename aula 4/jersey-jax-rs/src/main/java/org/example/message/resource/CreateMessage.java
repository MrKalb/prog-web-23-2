package org.example.message.resource;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.message.request.MessageRequest;
import org.example.message.response.Message;
import org.example.message.service.CreateMessageUseCase;

@Path("/messages")
public class CreateMessage {

    private final CreateMessageUseCase createMessage;

    public CreateMessage() {
        this.createMessage = new CreateMessageUseCase();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMessage(MessageRequest messageRequest) {
        Message message = createMessage.createMessage(messageRequest);
        return Response.ok(message).build();
    }
}
