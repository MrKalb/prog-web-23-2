package org.example.message.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.message.response.Message;

@Path("/message")
public class GetMessage {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessage() {
        Message message = new Message();
        message.setMessage("something here");
        return Response.ok(message).build();
    }
}
