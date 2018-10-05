/**
 * 
 */
package com.cc.learning.resources;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cc.learning.models.Saying;
import com.codahale.metrics.annotation.Timed;


/**
 * @author sinni14
 *
 */
@Path("/forkifyApp")
@Produces(MediaType.APPLICATION_JSON)
public class ForkifyAppResource {

	private final String template;
	private final String defaultName;
	private final AtomicLong counter;

	public ForkifyAppResource(String template, String defaultName) {
		this.template = template;
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
	}
	
	@GET
	@Timed
	@Path("/testApi")
	public Response testApi(@QueryParam("name") Optional<String> name) {
		final String value = String.format(template, name.orElse(defaultName));
		return Response.ok().entity(new Saying(counter.incrementAndGet(), value)).build(); 
	}
}
