package UtilTests;

import Util.CommentAssistant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.time.*;
import java.time.Month;

public class CommentAssistantTests {
    static String expectedLocalHost = "localhost";
    static String expectedIP = "192.168.1";

    @BeforeAll
    public static void setUp() {
        //Clock clock = Clock.fixed(Instant.parse("2007-12-03T10:15:30.00Z"), ZoneId.of("UTC"));
        //LocalDateTime dateTime = LocalDateTime.now(clock);
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
        }catch (Exception e){}
        CommentAssistant.addSystemData("test");
    }

    @Test
    public void getLocalHostName_ReturnsHostNameAndIP(){
        Assertions.assertEquals(expectedLocalHost+"/"+expectedIP, CommentAssistant.getLocalHostName());
    }

    @Test
    public void getHostName_ReturnsHostName(){
        Assertions.assertEquals(expectedLocalHost,CommentAssistant.getHostName());
    }

    @Test
    public void getIP_ReturnsIpAdress(){
        Assertions.assertEquals(expectedIP, CommentAssistant.getIP());
    }


    @Test
    public void getTimeNow() {
        String dateTimeExpected = "2015/07/29 19:30:40";

        Assertions.assertEquals(dateTimeExpected, CommentAssistant.getTime());
    }

    @Test
    public void getMethodNameTest() {
        String expected = "setUp";
        String actual = CommentAssistant.getMethodName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getClassNameTest() {
        String expected = "UtilTests.CommentAssistantTests";
        String actual = CommentAssistant.getClassName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getPackageNameTest(){
        String expected = "UtilTests";
        String actual = CommentAssistant.getPackageName();

        Assertions.assertEquals(expected, actual);
    }
}
