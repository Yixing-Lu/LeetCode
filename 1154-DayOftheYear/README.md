Given a string `date` representing a [Gregorian calendar](https://en.wikipedia.org/wiki/Gregorian_calendar) date formatted as `YYYY-MM-DD`, return the day number of the year.

---

> Input: date = "2019-01-09"
> Output: 9
> Explanation: Given date is the 9th day of the year in 2019.

---

If it is leap year then simple add 1 to feb

```JAVA
 public int dayOfYear(String S) {
        String[] s = S.split("-");
        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int date = Integer.parseInt(s[2]);
        boolean isLeap = checkYear(year);
        int noOfDays = 0;
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month - 1; i++) {
            if (isLeap && i == 1) {
                noOfDays += days[i] + 1;
                continue;
            }
            noOfDays += days[i];
        }
        return noOfDays + date;
    }
```

```JAVA
boolean checkYear(int year) {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        if (year % 4 == 0)
            return true;
        return false;
    }
```

