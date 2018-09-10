package com.mycompany.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

/*2. Есть программа, хранящая в памяти телефонную книгу (забита в коде программы).
        Телефонная книга для каждого ФИО хранит список номеров.
        Входные данные
        Иванов И.И. +8 800 2000 500 +8 800 200 600
        Петров П.П. +8 800 2000 700
        Сидоров С.С. +8 800 2000 800 +8 800 2000 900 +8 800 2000 000

        На вход программе подается ФИО, программа печатает телефоны, привязанные к этому ФИО.
        Если телефона нет, программа должна выдать сообщение о том, что такого ФИО в БД нет.

        Пример:
        Пользователь вводит
        Иванов И.И.
        Программа выдает
        1. +8 800 2000 500
        2. +8 800 200 600

        Обязательно. Использовать для реализации HashMap (для хранения сопоставления ФИО -> телефоны), ArrayList для хранения списка телефонов

        Желательно (опционально):
        - использовать для сборки maven3 https://maven.apache.org/
        - написать тесты для кода, используя JUnit http://junit.org/junit4/
        По двум задачам желательно:
        а. заливать данные в github (проверим работу с гит)
        б. заливать промежуточные результаты, чтобы мы оценили прогресс задачи.*/

public class TelephonesPrinter {

    static Map<String, List<String>> ResultMap;

    static {
        ResultMap = new HashMap<>();
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

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
            String stringFromSystemIn = bufferedReader.readLine();
            print(stringFromSystemIn);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static void print (String string) {
        if ((string!=null)&&(ResultMap!= null)) {
            if (isUserExist(string)) {
                List<String> value = getUserTelephones(string);
                for (int i = 0; i < value.size(); i++) {
                    System.out.println((i+1) + ". " + value.get(i));
                }
            }
        } else {
            System.out.println(string + " ФИО в базе нет.");
        }
    }

    static boolean isUserExist (String string) {
        if(ResultMap.containsKey(string)) {
            return true;
        }
        return false;
    }

    static List<String> getUserTelephones(String string) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, List<String>> mapEntry: ResultMap.entrySet()) {
            String key = mapEntry.getKey();
            List<String> value = mapEntry.getValue();
            if (key.equals(string)) {
                return value;
            }
        }
        return list;
    }

}










