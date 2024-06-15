package org.acme

import io.quarkus.security.Authenticated
import jakarta.annotation.security.RolesAllowed
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import org.jboss.resteasy.reactive.NoCache

@Path("/api/auth")
class AuthenticatedResource {

    @GET
    @Path("/me")
    @Authenticated
    fun me(): String {
        return "it works"
    }
}