package Utils;

import Run.BirthdaySystemReminder;
import beans.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BirthdayStatistics {
    final static int MONTHS = 12;
    static BirthdaySystemReminder birthdaySystemReminder = BirthdaySystemReminder.getInstance();

    public static int countMembers() {
        return birthdaySystemReminder.getPeople().size();
    }

    public static int getHappyMonth() {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < MONTHS; i++) {
//            map.put(i, 0);
//        }
//
//        for (Person person : birthdaySystemReminder.getPeople()) {
//            map.put(person.getBirthday().getMonthValue() - 1, map.get(person.getBirthday().getMonthValue() - 1) + 1);
//        }
//
//        int max = map.get(0);
//
//        for (int i = 0; i < map.size() - 1; i++) {
//            if (map.get(i) < map.get(i + 1)) {
//                max = i + 1;
//            }
//        }
//
//        return max;
        int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (Person person : birthdaySystemReminder.getPeople()) {
            switch (person.getBirthday().getMonthValue()) {
                case 1:
                    arr[0]++;
                    break;
                case 2:
                    arr[1]++;
                    break;
                case 3:
                    arr[2]++;
                    break;
                case 4:
                    arr[3]++;
                    break;
                case 5:
                    arr[4]++;
                    break;
                case 6:
                    arr[5]++;
                    break;
                case 7:
                    arr[6]++;
                    break;
                case 8:
                    arr[7]++;
                    break;
                case 9:
                    arr[8]++;
                    break;
                case 10:
                    arr[9]++;
                    break;
                case 11:
                    arr[10]++;
                    break;
                case 12:
                    arr[11]++;
                    break;
            }
        }

        int max = arr[0];
        int maxIdx = 1;

        for (int i = 1; i < arr.length; i++) {
            if (max == 0) {
                max = arr[i];
                maxIdx = i + 1;
                continue;
            }

            if (arr[i] > max) {
                max = arr[i];
                maxIdx = i + 1;
            }
        }
        return maxIdx;
    }

    public static int getSadlyMonth() {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < MONTHS; i++) {
//            map.put(i, 0);
//        }
//
//        for (Person person : birthdaySystemReminder.getPeople()) {
//            map.put(person.getBirthday().getMonthValue() - 1, map.get(person.getBirthday().getMonthValue() - 1) + 1);
//        }
//
//        int min = map.get(0);
//
//        for (int i = 0; i < map.size() - 1; i++) {
//            if (map.get(i) > map.get(i + 1)) {
//                min = i + 1;
//            }
//        }
//
//        return min;

        int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (Person person : birthdaySystemReminder.getPeople()) {
            switch (person.getBirthday().getMonthValue()) {
                case 1:
                    arr[0]++;
                    break;
                case 2:
                    arr[1]++;
                    break;
                case 3:
                    arr[2]++;
                    break;
                case 4:
                    arr[3]++;
                    break;
                case 5:
                    arr[4]++;
                    break;
                case 6:
                    arr[5]++;
                    break;
                case 7:
                    arr[6]++;
                    break;
                case 8:
                    arr[7]++;
                    break;
                case 9:
                    arr[8]++;
                    break;
                case 10:
                    arr[9]++;
                    break;
                case 11:
                    arr[10]++;
                    break;
                case 12:
                    arr[11]++;
                    break;
            }
        }

        int min = arr[0];
        int minIdx = 1;

        for (int i = 1; i < arr.length; i++) {
            if (min == 0) {
                min = arr[i];
                minIdx = i + 1;
                continue;
            }

            if (arr[i] < min && arr[i] != 0) {
                min = arr[i];
                minIdx = i + 1;
            }
        }
        return minIdx;
    }

    public static Map<Integer, Integer> getEvents() {
        // TODO when printing add to the key + 1
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < MONTHS; i++) {
            map.put(i, 0);
        }

        for (Person person : birthdaySystemReminder.getPeople()) {
            map.put(person.getBirthday().getMonthValue() - 1, map.get(person.getBirthday().getMonthValue() - 1) + 1);
        }

        return map;
    }

}
