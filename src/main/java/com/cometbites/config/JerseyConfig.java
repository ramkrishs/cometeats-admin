package com.cometbites.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.config.Transactions;
import org.springframework.context.annotation.Configuration;

import com.cometbites.rest.Admin;
import com.cometbites.rest.HelloWorld;




@Configuration
@ApplicationPath("api/v1/admin")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(CorsFilter.class);
		register(HelloWorld.class);
		register(Admin.class);
	}

}
