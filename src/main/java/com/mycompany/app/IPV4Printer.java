package com.mycompany.app;

import java.io.*;
import java.util.Arrays;

/*        На вход программе задаются два IP адреса, программа перебирает все
    допустимые адреса в введенном диапазоне и выдает их на экран.
    Пример:
    пользователь вводит с клавиатуры
192.168.0.1 и 192.168.0.5
    Программа должна выдать
192.168.0.2
        192.168.0.3
        192.168.0.4

    Желательно (опционально):
            - использовать для сборки maven3 https://maven.apache.org/
            - написать тесты для кода, используя JUnit http://junit.org/junit4/*/

public class IPV4Printer {

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String firstStringFromSystemIn = bufferedReader.readLine();
            String secondStringFromSystemIn = bufferedReader.readLine();
            if (isCorrectIPV4Address(firstStringFromSystemIn) && (isCorrectIPV4Address(secondStringFromSystemIn))) {
                int[] firstIPArray = convertStringIPAddressToIntArray(firstStringFromSystemIn);
                int[] secondIPArray = convertStringIPAddressToIntArray(secondStringFromSystemIn);
                if (isIPV4AddressesInOneNetwork(firstIPArray, secondIPArray)) {
                    printAvailableIPAddresses(firstIPArray, secondIPArray);
                } else {
                    System.out.println("Введенные IP - не в одной сети.");
                }
            } else {
                System.out.println("Один из введенных IP - не корректный.");
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

     static boolean isCorrectIPV4Address (String string) {
        if (string != null) {
            return string.matches("(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");
        }
        return false;
    }

     static int[] convertStringIPAddressToIntArray (String string) {
        String[] strings = string.split("\\.");
        int[] intArray = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            intArray[i] = Integer.valueOf(strings[i]);
        }
        return intArray;
    }

     static boolean isIPV4AddressesInOneNetwork (int[] a, int[] b) {
        for (int i = 0; i < a.length - 1; i++) {
            if(a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

     static void printAvailableIPAddresses (int[] a, int[] b) {
        String networkBody = a[0] + "." + a[1] + "." + a[2] + ".";
        int[] tempArray = new int[]{a[3], b[3]};
        Arrays.sort(tempArray);
            if ((tempArray[1] - tempArray[0] <= 1)) {
                System.out.println("В указанном диапазоне нет IP.");
            } else {
                int networkElement = tempArray[0] + 1;
                while (networkElement != tempArray[1]) {
                    System.out.println(networkBody + networkElement);
                    networkElement++;
            }
        }
    }

}
