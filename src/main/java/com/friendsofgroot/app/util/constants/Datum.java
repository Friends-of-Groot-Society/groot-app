package com.friendsofgroot.app.util.constants;

public class Datum {

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DEFAULT_PAGE_NUMBER = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";
    public static final String DEFAULT_SORT_BY = "id";
    public static final String DEFAULT_SORT_DIRECTION = "asc";


    // FILES
    public static final String LOCAL_SCANNER_TXT = "src/data/scannertext.txt" ;
    public static final String  FILE_IN_COINS = "src/data/files/fileInCoins.txt" ;
    public static final String FILE_IN_WEBLINKS = "src/data/files/fileInWeblinks.txt" ;
    public static final String FILE_OUT_WEBLINKS = "src/data/pages/fileOutWeblinks" ;

    public static final String FILE_IN_BOOKS = "src/data/files/fileInBooks.txt" ;
    public static final String FILE_IN_MOVIES = "src/data/files/fileInMovies.txt" ;
    public static final String FILE_OUT_MOVIES = "src/data/files/fileOutMovies.txt" ;
    public static final String FILE_IN_OFFERS = "src/data/files/fileInOffers.txt" ;
    public static final String FILE_IN_USERS = "src/data/files/fileInUsers.txt" ;
    public static final String FILE_OUT_USERS = "src/data/files/fileOutUsers.txt" ;
    public static final String FILE_OUT_USER = "src/data/files/fileOutUser.txt" ;
    public static final String FILE_OUT_ARRAY = "src/data/files/fileOutArray.txt" ;

    public static final String FILE_IN_GROUPS = "src/data/files/fileInGroups.txt";

    public Datum(String datum) {
        this.datum = datum;
    };


    private Datum String (Datum datum) {
      return  datum ;
    };

    private String datum;

}
