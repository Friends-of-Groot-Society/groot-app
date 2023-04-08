package com.friendsofgroot.app.consoles;

import com.friendsofgroot.app.commands.IMaPL;
import com.friendsofgroot.app.commands.MaPL;
import com.friendsofgroot.app.commands.MaPLInvoker;
import com.friendsofgroot.app.commands.MaPLwriter;
import com.friendsofgroot.app.util.constants.Cmds;
import com.friendsofgroot.app.util.logger.LoggerImpl;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;


public class GeoDashboard {
    //    private static Map<Integer, Location> locations = new HashMap<>();//
//        Map<String, Integer> options = null;
    private static Locations locations = new Locations();
    InputStream inputStream = getClass().getResourceAsStream("/data/locations/json/posts.json");
    //cd C:\w\www\_groot\groot-app\src\main\java\com\friendsofgroot\app\data\locations
//    URL url = new URL("jar:file:/absolute/location/of/yourJar.jar!/1.txt");

//    InputStream is = url.openStream();
//    BufferedReader input = new BufferedReader(new InputStreamReader(is));
//    String line = null;
//    while ((line = input.readLine()) != null) {
//        System.out.println(line);
//    }

    public GeoDashboard() throws IOException {
    }

    public static void console(String args) throws SQLException, IOException, ClassNotFoundException {
        ClassLoader classLoader = GeoDashboard.class.getClassLoader();
        InputStream inputStream2 = classLoader.getResourceAsStream("/data/locations/json/posts.json");

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

}
