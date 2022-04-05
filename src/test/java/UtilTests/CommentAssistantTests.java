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
    static String expectedLocalHost = "localhost";
    static String expectedIP = "192.168.1";

    @BeforeAll
    public static void setUp() {
        LocalDateTime dateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
        mockStatic(LocalDateTime.class);
        when(LocalDateTime.now()).thenReturn(dateTime);

        InetAddress address;
        try {
            address = InetAddress.getLocalHost();
            mockStatic(InetAddress.class);
            when(InetAddress.getLocalHost()).thenReturn(address);
            when(InetAddress.getLocalHost().getHostName()).thenReturn(expectedLocalHost);
            when(InetAddress.getLocalHost().getHostAddress()).thenReturn(expectedLocalHost);
        } catch (Exception e) {
            e.printStackTrace();
        }

        CommentAssistant.addSystemData("test");
    }

    @Test
    public void getLocalHostName_ReturnsHostNameAndIP() {
        String expected = expectedLocalHost + "/" + expectedIP;
        String actual = CommentAssistant.getLocalHostName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getHostName_ReturnsHostName(){
        String expected = expectedLocalHost;
        String actual = CommentAssistant.getHostName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getIP_ReturnsIpAdress(){
        String actual = expectedIP;
        String expected = CommentAssistant.getIP();

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
}
