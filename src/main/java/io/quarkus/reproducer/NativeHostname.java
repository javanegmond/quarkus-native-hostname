package io.quarkus.reproducer;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

@Path("/hello")
public class NativeHostname {

    private static final Logger LOGGER = Logger.getLogger(NativeHostname.class.getName());

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String logHostname() throws UnknownHostException {
        var helloMessage = "Hello from host " + InetAddress.getLocalHost()
                                                  .getHostName();
        LOGGER.info(helloMessage);
        return helloMessage;
    }
}
