package UtilTests;

import Util.CommentAssistant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.net.InetAddress;
import java.time.*;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;

class CommentAssistantTests {
    private static final String expectedHost = "testHost";
    private static final String expectedIP = "1.2.3.4";
    private static CommentAssistant commentAssistant;

    @BeforeAll
    static void setUp() {
        // Creating mock for date time.
        Logger logger = Logger.getGlobal();
        commentAssistant = new CommentAssistant(logger);
        LocalDateTime dateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
        mockStatic(LocalDateTime.class);
        when(LocalDateTime.now()).thenReturn(dateTime);

        // Creating mock for InetAddress.
        try {
            InetAddress address = InetAddress.getByName(expectedIP);
            mockStatic(InetAddress.class);
            when(InetAddress.getLocalHost()).thenReturn(address);
            when(InetAddress.getLocalHost().getHostName()).thenReturn(expectedHost);
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }

        // Calling class with test string.
        commentAssistant.addSystemData("test");
    }

    @Test
    public void getLocalHostName_ReturnsHostNameAndIP() {
        String expected = expectedHost + "/" + expectedIP;
        String actual = commentAssistant.getLocalHostName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getHostName_ReturnsHostName(){
        String expected = expectedHost;
        String actual = commentAssistant.getHostName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getIP_ReturnsIpAddress(){
        String expected = expectedIP;
        String actual= commentAssistant.getIP();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void getTimeNow_ReturnsCurrentTime() {
        String expected = "2015/07/29 19:30:40";
        String actual = commentAssistant.getTime();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getMethodName_GivenMethodCall_ReturnsMethodName() {
        String expected = "setUp";
        String actual = commentAssistant.getMethodName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getClassName_GivenMethodHasClass_ReturnsClassName() {
        String expected = "UtilTests.CommentAssistantTests";
        String actual = commentAssistant.getClassName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getPackageName_GivenClassHasPackage_ReturnsPackageName(){
        String expected = "UtilTests";
        String actual = commentAssistant.getPackageName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getFinalString_GivenAddSystemDataWithParameterTest_ReturnsTestWithSystemData() {
        String expected = "test/*{\"METHODNAME\":\"setUp\"," +
                                "\"HOST_NAME\":\"" + expectedHost + "\"," +
                                "\"LOCALHOST\":\"" + expectedHost + "/" + expectedIP + "\"," +
                                "\"IP_ADDRESS\":\"" + expectedIP + "\"," +
                                "\"CLASSNAME\":\"UtilTests.CommentAssistantTests\"," +
                                "\"CURRENT_TIME\":\"2015/07/29 19:30:40\"," +
                                "\"PACKAGENAME\":\"UtilTests\"}*/";
        String actual = commentAssistant.getFinalString();

        Assertions.assertEquals(expected, actual);
    }
}
