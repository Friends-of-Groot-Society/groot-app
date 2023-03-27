 package cryptonews;

 import com.intuit.karate.junit5.Karate;

 class CryptoRunner {

     @Karate.Test
     Karate testNews() {
         return Karate.run("cryptoNews").relativeTo(getClass());
     }

 }
