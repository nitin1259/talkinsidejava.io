/**
 * 
 */
package com.cc.learning.application;

import com.cc.learning.resources.ForkifyAppResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * @author sinni14
 *
 */
public class ApiHandlerApplication extends Application<ApiHandlerConfiguration>{
	
	public static void main(String[] args) throws Exception {
        new ApiHandlerApplication().run(args);
    }

	@Override
	public void run(ApiHandlerConfiguration conf, Environment env) throws Exception {
		final ForkifyAppResource forkifyApp = new ForkifyAppResource(conf.getTemplate(), conf.getDefaultName());
		env.jersey().register(forkifyApp);
		
	}
	
	@Override
    public String getName() {
        return "Rest Api Handler";
    }

    @Override
    public void initialize(Bootstrap<ApiHandlerConfiguration> bootstrap) {
        // nothing to do yet
    }

}
