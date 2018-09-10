package com.mycompany.app;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TelephonesPrinterTest {

    @Before
    public void test_print() {
        Map<String, List<String>> ResultMap = new HashMap<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        list1.add("+8 800 2000 500");
        list1.add("+8 800 200 600");
        list2.add("+8 800 2000 700");
        list3.add("+8 800 2000 800");
        list3.add("+8 800 2000 900");
        list3.add("+8 800 2000 000");
        ResultMap.put("Иванов И.И.",list1);
        ResultMap.put("Петров П.П.",list2);
        ResultMap.put("Сидоров С.С.",list3);
    }

    @Test
    public void test_isUserExist() {
        assertTrue(TelephonesPrinter.isUserExist("Иванов И.И."));
        assertFalse(TelephonesPrinter.isUserExist("Иванов И.П."));
    }

    @Test
    public void test_getUserTelephones() {
        assertTrue(TelephonesPrinter.getUserTelephones("Иванов И.И.").size() > 0);
        assertTrue(TelephonesPrinter.getUserTelephones("Иванов И.П.").size() == 0);
    }

}