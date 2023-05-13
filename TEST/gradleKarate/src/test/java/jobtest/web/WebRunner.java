package jobtest.web;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import common.ReportUtils;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
 

/**
 *
 * @author pthomas3
 */
public class WebRunner {
	
	  @BeforeAll
	    public static void before() {
	        System.setProperty("karate.env", "jobserver");
	    }

    @Test
    void test() {
        Results results = Runner.path("classpath:jobtest/web").tags("~@ignore").parallel(1);
        ReportUtils.generateReport(results.getReportDir());
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }     
    
}
