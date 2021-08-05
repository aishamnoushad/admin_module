package com.aisha.adminModule;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

import com.aisha.adminModule.Configuration.SessionConfig;

public class SessionInitializer extends AbstractHttpSessionApplicationInitializer  {
	public SessionInitializer() {
//		super(SessionConfig.class); 
	}

}
