package com.mycompany.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    private final static Map<String, List<String>> ResultMap = new HashMap<>();
    private final static List<String> list1 = new ArrayList<>();
    private final static List<String> list2 = new ArrayList<>();
    static {
        list1.add("+8 800 200 600");
        list1.add("+8 800 200 601");
        list2.add("+8 800 200 603");
        ResultMap.put("test1", list1);
        ResultMap.put("test2", list2);
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String stringFromSystemIn = bufferedReader.readLine();
            if (ResultMap.containsKey(stringFromSystemIn)) {
                for (Map.Entry<String, List<String>> mapEntry: ResultMap.entrySet()) {
                    String key = mapEntry.getKey();
                    List<String> value = mapEntry.getValue();
                    if (key.equals(stringFromSystemIn)) {
                        for (int i = 0; i < value.size(); i++) {
                            System.out.println(value.get(i));
                        }
                    }
                }
            } else {
                System.out.println(stringFromSystemIn + " ФИО в базе нет.");
            }
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

}











