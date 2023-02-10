package com.friendsofgroot.app.cli;

import com.friendsofgroot.app.CliApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("INSIDE ____________ServletInitializer");
		return application.sources(CliApplication.class);
	}

}
