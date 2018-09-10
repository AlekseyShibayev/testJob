package com.mycompany.app;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class IPV4PrinterTest {

    @Test
    public void test_isCorrectIPV4Address() {
        assertTrue(IPV4Printer.isCorrectIPV4Address("192.168.0.1"));
        assertTrue(IPV4Printer.isCorrectIPV4Address("0.0.0.0"));

        assertFalse(IPV4Printer.isCorrectIPV4Address("asdfg"));
        assertFalse(IPV4Printer.isCorrectIPV4Address("192.168.0088.001"));
        assertFalse(IPV4Printer.isCorrectIPV4Address("19a.168.0.1"));
        assertFalse(IPV4Printer.isCorrectIPV4Address("1921.168.88.01"));
        assertFalse(IPV4Printer.isCorrectIPV4Address("192.168..1"));
        assertFalse(IPV4Printer.isCorrectIPV4Address("192.168.0.-1"));
        assertFalse(IPV4Printer.isCorrectIPV4Address("192.168.00100000001.1"));
        assertFalse(IPV4Printer.isCorrectIPV4Address("192.168.0.256"));
        assertFalse(IPV4Printer.isCorrectIPV4Address(null));

        List<String> listTrue = new ArrayList<>();
        listTrue.add("192.168.000.1");
        listTrue.add("192.168.0.001");
        listTrue.add("192.168.0.01");
        listTrue.add("192.168.00.1");
        for (String s : listTrue) {
            assertTrue(IPV4Printer.isCorrectIPV4Address(s));
        }
    }

    @Test
    public void test_convertStringIPAddressToIntArray() {
        List<String> listTrue = new ArrayList<>();
        listTrue.add("192.168.000.1");
        listTrue.add("192.168.0.001");
        listTrue.add("192.168.0.01");
        listTrue.add("192.168.00.1");
        for (int i = 1; i < listTrue.size(); i++) {
            int[] a = IPV4Printer.convertStringIPAddressToIntArray(listTrue.get(i-1));
            int[] b = IPV4Printer.convertStringIPAddressToIntArray(listTrue.get(i));
            assertTrue(Arrays.equals(a, b));
        }
    }

    @Test
    public void test_isIPV4AddressesInOneNetwork() {
        List<String> listTrue = new ArrayList<>();
        listTrue.add("192.168.1.1");
        listTrue.add("192.168.0.255");
        for (int i = 1; i < listTrue.size(); i++) {
            int[] a = IPV4Printer.convertStringIPAddressToIntArray(listTrue.get(i-1));
            int[] b = IPV4Printer.convertStringIPAddressToIntArray(listTrue.get(i));
            assertFalse(IPV4Printer.isIPV4AddressesInOneNetwork(a, b));
        }
    }

}