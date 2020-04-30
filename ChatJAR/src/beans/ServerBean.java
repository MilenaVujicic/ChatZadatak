package beans;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.ServletContext;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Stateless
@Path("")
@LocalBean
public class ServerBean implements ServerLocal, ServerRemote {

	@Context
	ServletContext ctx;
	
	@PostConstruct
	public void init() {
		
	}
	
	
}
