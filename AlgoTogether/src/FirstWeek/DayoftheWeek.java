package FirstWeek;

public class DayoftheWeek {
    class Solution {
        int[] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfWeek = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        public String dayOfTheWeek(int day, int month, int year) {
            // today is 2020/05/08, Friday
            int curr = daySinceStart(8, 5, 2020);
            int tmp = daySinceStart(day, month, year);
            return dayOfWeek[((tmp - curr) % 7 + 7) % 7]; // incase of res - curr < 0
        }

        private int daySinceStart(int day, int month, int year) {
            int days = 0;
            for (int i = 1971; i < year; i++) {
                days += 365 + isLeapYear(i);
            }

            for (int i = 1; i < month; i++) {
                days += dayOfMonth[i - 1];
                if (i == 2) {
                    days += isLeapYear(year);
                }
            }
            days += day - 1;
            return days;
        }

        private int isLeapYear(int n) {
            if ((n % 4 == 0 && n % 100 != 0) || n % 400 == 0) {
                return 1;
            }
            return 0;
        }
    }
}
