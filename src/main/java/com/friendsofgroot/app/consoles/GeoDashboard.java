package com.friendsofgroot.app.consoles;

import com.friendsofgroot.app.commands.IMaPL;
import com.friendsofgroot.app.commands.MaPL;
import com.friendsofgroot.app.commands.MaPLInvoker;
import com.friendsofgroot.app.commands.MaPLwriter;
import com.friendsofgroot.app.util.constants.Cmds;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

@Component
public class GeoDashboard implements IMaPL {
    //    private static Map<Integer, Location> locations = new HashMap<>();//
//        Map<String, Integer> options = null;
    private static Locations locations = new Locations();

    @Override
    public void openMaPLControl() throws SQLException {
        System.out.println(Cmds.WELCOME_TO_MY_PERSONAL_LIBRARIAN_MY_NAME_IS_MA_PL);
        MaPLInvoker mc = new MaPLInvoker();
        mc.getMapleState();

        sessionMaPL(mc);
    }

    private static void sessionMaPL(MaPLInvoker mapleInvokerSession) throws SQLException {
        // LOAD UP THE COMMANDS FROM THE DB ADMIN TABLE
        System.out.println(mapleInvokerSession.getMaplCommands());
        while (true) {
            try (Scanner scan = new Scanner(System.in)) {
                System.out.println("______________Session MaPL: AdminDashboard______________");
                System.out.println("What next? - enter number; 0 to quit()");
                int nextCommand = scan.nextInt();
                if (nextCommand == 0)
                    console(Arrays.toString(new String[]{"GeoDashboard"}));

                mapleInvokerSession.execute(nextCommand);
                System.out.println("Invoked command executed.\n");
                sessionMaPL(mapleInvokerSession);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void console(String args) throws SQLException, IOException, ClassNotFoundException {

        Scanner scanNav = new Scanner(System.in);
        Locations.mainLocationsTXT(new String[]{});
        Locations.mainLocationsDAT(new String[]{});
        Locations.mainLocationsBIN(new String[]{});


        Map<String, String> vocab_ = new HashMap<String, String>();
        vocab_.put("QUIT", "Q");
        vocab_.put("NORTH", "N");
        vocab_.put("SOUTH", "S");
        vocab_.put("WEST", "W");
        vocab_.put("EAST", "E");

        int loc = 1;
//        int loc = 64;
        while (true) {
            scanNav = new Scanner(System.in);
            System.out.println(locations.get(loc).getDescription()); //startingout
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanNav.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                for (String word : words) {
                    if (vocab_.containsKey(word)) {
                        direction = vocab_.get(word);
                        break;
                    }
                }
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);

            } else {
                System.out.println("You cannot go in that direction");
            }
        }
        MainDashboard.console(new String[]{});
    }

    /**
     * @return
     */
    @Override
    public String[] getCmds() {
        return new String[0];
    }

    /**
     * @param cmdName
     * @param cmd
     */
    @Override
    public void register(Integer cmdName, MaPL cmd) {

    }

    /**
     *
     */
    @Override
    public void getMapleState() {

    }

    /**
     * @param cmdName
     * @param cmd
     */
    @Override
    public void register(String cmdName, MaPLwriter cmd) {

    }

    /**
     * @param cmdName
     * @param cmd
     */
    @Override
    public void register(Integer cmdName, MaPLwriter cmd) {

    }

    /**
     * @param cmdId
     */
    @Override
    public void execute(int cmdId) {

    }

    /**
     *
     */
    @Override
    public void execute() {

    }

    /**
     *
     */
    @Override
    public void up() {

    }

    /**
     *
     */
    @Override
    public void down() {

    }

    /**
     *
     */
    @Override
    public void left() {

    }

    /**
     *
     */
    @Override
    public void right() {

    }

    /**
     * @param o
     */
    @Override
    public void up(Object o) {

    }

    /**
     * @param o
     */
    @Override
    public void down(Object o) {

    }

    /**
     * @param o
     */
    @Override
    public void left(Object o) {

    }

    /**
     * @param o
     */
    @Override
    public void right(Object o) {

    }
}
