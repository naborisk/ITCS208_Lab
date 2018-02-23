// Tussoun Jitpanyoyos 6088030 Sec 1

public class MyDate {
    private int year;
    private int month;
    private int day;
    private int objectNumber;
    private static int objectCounter = 0;
    private static String[] strMonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    MyDate(){
        year = 1900;
        month = 1;
        day = 1;

        objectCounter++;
        objectNumber = objectCounter;
    }
    MyDate(int aYear, int aMonth, int aDay){
            year = aYear;
            month = aMonth;
            day = aDay;

            objectCounter++;
            objectNumber = objectCounter;
    }
    public int getObjectNumber() {
        return objectNumber;
    }

    public void setDate(int aYear, int aMonth, int aDay){
        year = aYear;
        month = aMonth;
        day = aDay;
    }

    void setYear(int aYear){
        year = aYear;
    }

    void setMonth(int aMonth){
        month = aMonth;
    }

    void setDay(int aDay){
        day = aDay;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String toString(){
        return day + " " + strMonths[month-1]+ " " + year;
    }

    MyDate nextDay() {

        if(month == 12 && day == 31){
            year++;
            month = 1;
            day = 1;
        }else{
            if(month == 4 || month == 6 || month == 9 || month == 11){
                if(day == 30){
                    month++;
                    day = 1;
                }else{
                    day++;
                }
            }else if(month != 2){
                    if(day == 31){
                        month++;
                        day = 1;
                    }else{
                        day++;
                    }
            }else{
                    if(isLeapYear(year) == true && day == 29) {
                        month++;
                        day = 1;
                    }else if(isLeapYear(year) == false && day == 28){
                        month++;
                        day = 1;
                    }else{
                        day++;
                    }
            }
        }

        return this;
    }

    MyDate nextMonth(){
        if(month == 12){
            month = 1;
            year++;            return this;
        }else if(month == 1 && day >= 29){
            if(isLeapYear(year)){
                day = 29;
            }else{
                day = 28;
            }
        }else if((month == 3 || month == 5 || month == 8 || month == 10) && day >= 30){
            day = 30;
        }

        month++;
        return this;
    }

    MyDate nextYear(){

        if(isLeapYear(year+1) == false && month == 2 && day >= 29) day = 28;
        year++;

        return this;
    }

    MyDate previousDay(){

        if(month == 1 && day == 1){
            year--;
            month = 12;
            day = 31;
        }else{
            if (month == 5 || month == 7 || month == 10 || month == 12){
                if(day == 1){
                    month--;
                    day = 30;
                }else{
                    day--;
                }
            }else if(month != 3){
                if(day == 1){
                    month--;
                    day = 31;
                }else{
                    day--;
                }
            }else{
                if(isLeapYear(year) == true && day == 1){
                    month--;
                    day = 29;
                }else if(day == 1){
                    month--;
                    day = 28;
                }else{
                    day--;
                }
            }
        }

        return this;
    }

    MyDate previousMonth(){
        if(month == 1){
            month = 12;
            year--;
            return this;
        }else if(month == 3 && day >= 29){
            if(isLeapYear(year)){
                day = 29;
            }else{
                day = 28;
            }
        }else if((month == 5 || month == 6 || month == 10 || month == 12) && day >= 30){
            day = 30;
        }

        month--;
        return this;
    }

    MyDate previousYear(){
        if(isLeapYear(year-1) == false && month == 2 && day >= 29) day = 28;
        year--;

        return this;
    }

    public static boolean isLeapYear(int year){
        if(year%4 != 0){
            return false;
        }else if(year%100 != 0){
            return true;
        }else if(year%400 != 0){
            return false;
        }else{
            return true;
        }
    }


}