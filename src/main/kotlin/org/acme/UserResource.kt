package org.acme

import io.quarkus.security.identity.SecurityIdentity
import jakarta.annotation.security.RolesAllowed
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import org.jboss.resteasy.reactive.NoCache

@Path("/api/users")
class UserResource(private val securityIdentity: SecurityIdentity) {

    @GET
    @Path("/me")
    @RolesAllowed("user")
    @NoCache
    fun me(): User {
        return User(securityIdentity)
    }

    class User internal constructor(securityIdentity: SecurityIdentity) {
        val userName: String = securityIdentity.principal.name
    }
}
