package com.friendsofgroot.app.consoles;

import com.friendsofgroot.app.commands.IMaPL;
import com.friendsofgroot.app.consoles.MainDashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NavigateRunner {
	
	@Autowired
	private IMaPL navigateConsole ;

	public void runNavigate(IMaPL navigateConsole) {
		navigateConsole.up();
		navigateConsole.down();
		navigateConsole.left(navigateConsole);
		navigateConsole.right(navigateConsole);
			IMaPL.showHistory();
	}
}
