package com.friendsofgroot.app.commands;

import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.repositories.UsersRepository;
import com.friendsofgroot.app.util.Utilities;
import com.friendsofgroot.app.util.constants.Cmds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static com.friendsofgroot.app.util.constants.Datum.SRC_DATA_STARTUP_TEXT_ADMIN_TXT;


public class MaPLAdminInvoker  extends MaPL  {
    private UsersRepository usersRepository;
    public MaPLAdminInvoker(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    private User u = new User();

    static String STARTUP_TEXT = SRC_DATA_STARTUP_TEXT_TXT;


    public String getStarterText() {
        return STARTUP_TEXT;
    }

    public MaPLAdminInvoker(String startupText) {
        if (startupText.equals("")) {
            startupText =   SRC_DATA_STARTUP_TEXT_ADMIN_TXT;
        }
        System.out.println("SRC_DATA_STARTUP_TEXT_TXT MaPLInvoker.getMapleState() = "+startupText  );

    };

    /**
     *
     */
    @Override
    public void getMapleState() {
        //  implement pre-registered commands to MaPL instance tasks
//        usersRepository.findAll().forEach(System.out::println);
        System.out.println("MaPLAdminInvoker.getMapleState() = "  );

    }

    protected static void loadDefault() {
        readStartupFile(SRC_DATA_STARTUP_TEXT_TXT);
    }
    protected static File readStartupFile(String path) {
        String fileFullPath = (path != null) ? path : String.valueOf(SRC_DATA_STARTUP_TEXT_TXT);
        Path absolutePath = FileSystems.getDefault().getPath(fileFullPath);
        System.out.println("Loading from "+absolutePath);
        File textFile = new File(fileFullPath);
        return textFile;
    }

    private void getClassProps(IMaPL m) {
        System.out.println("\nm.getClass(): "+m.getClass());
        System.out.println("getSuggestion: "+((MaPL) m).getSuggestion());
        System.out.println("getCommandName: "+ ((MaPL) m).getCommandName());
        System.out.println("m.getCmds(): " + Arrays.toString(m.getCmds()));
        Utilities.getReflectionInfo(m);
           }

    @Override
    public void execute() {
        System.out.println("... MaPLInvoker execute()");
    }


    /**
     * @param o
     */
    @Override
    public void up(Object o) {

    }

    /**
     * @return string of Mapl-specific commands
     */
    @Override
    public String[] getCmds() {
        return new String[0];
    }


//    public void setCommand(MaPLControl maPLControl) {
//    }
}
