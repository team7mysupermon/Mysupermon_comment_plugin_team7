package UtilTests;

import Util.CommentAssistant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.net.InetAddress;
import java.time.*;
import java.time.Month;

public class CommentAssistantTests {
    static String expectedHost = "testHost";
    static String expectedIP = "1.2.3.4";

    @BeforeAll
    public static void setUp() {
        // Creating mock for date time
        LocalDateTime dateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
        mockStatic(LocalDateTime.class);
        when(LocalDateTime.now()).thenReturn(dateTime);

        // Creating mock for InetAddress. IP + Hostname
        try {
            InetAddress address = InetAddress.getByName(expectedIP);
            mockStatic(InetAddress.class);
            when(InetAddress.getLocalHost()).thenReturn(address);
            when(InetAddress.getLocalHost().getHostName()).thenReturn(expectedHost);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Calling class with test string
        CommentAssistant.addSystemData("test");
    }

    @Test
    public void getLocalHostName_ReturnsHostNameAndIP() {
        String expected = expectedHost + "/" + expectedIP;
        String actual = CommentAssistant.getLocalHostName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getHostName_ReturnsHostName(){
        String expected = expectedHost;
        String actual = CommentAssistant.getHostName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getIP_ReturnsIpAddress(){
        String expected = expectedIP;
        String actual= CommentAssistant.getIP();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void getTimeNow_ReturnsCurrentTime() {
        String expected = "2015/07/29 19:30:40";
        String actual = CommentAssistant.getTime();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getMethodName_GivenMethodCall_ReturnsMethodName() {
        String expected = "setUp";
        String actual = CommentAssistant.getMethodName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getClassName_GivenMethodHasClass_ReturnsClassName() {
        String expected = "UtilTests.CommentAssistantTests";
        String actual = CommentAssistant.getClassName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getPackageName_GivenClassHasPackage_ReturnsPackageName(){
        String expected = "UtilTests";
        String actual = CommentAssistant.getPackageName();

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
        String actual = CommentAssistant.getFinalString();

        Assertions.assertEquals(expected, actual);
    }
}
