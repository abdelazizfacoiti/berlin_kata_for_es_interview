package org.example;

public class BerlinClock {
    public String getSingleMinutes(String minutes) {
        StringBuilder result = new StringBuilder("OOOO");
        int barsNumber = (Integer.parseInt(minutes) % 5);
        for (int i = 0; i < barsNumber; i++) {
            result.replace(i, i + 1, "Y");
        }
        return result.toString();
    }

    public String getFiveMinutes(String minutes) {
        StringBuilder result = new StringBuilder("OOOOOOOOOOO");
        int barsNumber = (Integer.parseInt(minutes) / 5);
        for (int i = 0; i < barsNumber; i++) {
            if ((i + 1) % 3 == 0) {
                result.replace(i, i + 1, "R");
            } else {
                result.replace(i, i + 1, "Y");
            }
        }
        return result.toString();
    }

    public String getSingleHours(String hours) {
        StringBuilder result = new StringBuilder("OOOO");
        int barsNumber = (Integer.parseInt(hours) % 5);
        for (int i = 0; i < barsNumber; i++) {
            result.replace(i, i + 1, "R");
        }
        return result.toString();
    }
    //each bar is 5hours so we devide on 5
    public String getFiveHours(String hours) {
        StringBuilder result = new StringBuilder("OOOO");
        int barsNumber = (Integer.parseInt(hours) / 5);
        for (int i = 0; i < barsNumber; i++) {
            result.replace(i, i + 1, "R");
        }
        return result.toString();
    }
    // get seconds lamp if even or odd
    public String getSecondsLamp(String seconds) {
        if (Integer.parseInt(seconds) % 2 == 0) {
            return "Y";
        } else {
            return "O";
        }
    }

    // to return all the berlin representation
    public String getClockDigitalToBerlin(String digitalHour) {
        if (isValidFormat(digitalHour)) {
            String[] timeTable = digitalHour.split(":");
            return getSecondsLamp(timeTable[2]) + getFiveHours(timeTable[0]) + getSingleHours(timeTable[0])
                    + getFiveMinutes(timeTable[1]) + getSingleMinutes(timeTable[1]);

        }
        return "Time is not valid!";
    }

    public boolean isValidFormat(String time) {
        String[] parts = time.split(":");
        if (parts.length != 3) {
            return false;
        }
        try {
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            int seconds = Integer.parseInt(parts[2]);
            if (hours < 0 || hours > 23) {
                return false;
            }
            if (minutes < 0 || minutes > 59) {
                return false;
            }
            if (seconds < 0 || seconds > 59) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    public String berlinToSecondsLamp(String seconds) {
        return (seconds.equals("Y")) ? "00" : "01";
    }

    public String berlinToHours(String hours) {
        int fiveHourscount=0, singleHourscount=0;
        String fiveHours = hours.substring(0,4);
        for(int i=0;i<fiveHours.length();i++){
            if(fiveHours.charAt(i) == 'R')
                fiveHourscount++;
        }
        String singleHours = hours.substring(4,8);
        for(int i=0;i<singleHours.length();i++){
            if(singleHours.charAt(i) == 'R')
                singleHourscount++;
        }
        int hoursValue = (fiveHourscount * 5 )+singleHourscount;
        return hoursValue < 10 ? "0"+hoursValue : ""+hoursValue;
    }

    public String berlinToMinutes(String minutes) {
        int fiveMinutesCount=0, singleMinutesCount=0;
        String fiveMinutes = minutes.substring(0,11);
        for(int i=0;i<fiveMinutes.length();i++){
            if(fiveMinutes.charAt(i) == 'R' || fiveMinutes.charAt(i) == 'Y')
                fiveMinutesCount++;
        }
        String singleMinutes = minutes.substring(11,15);
        for(int i=0;i<singleMinutes.length();i++){
            if(singleMinutes.charAt(i) == 'Y')
                singleMinutesCount++;
        }
        int minutesValue = (fiveMinutesCount * 5 )+singleMinutesCount;
        return minutesValue < 10 ? "0"+minutesValue : ""+minutesValue;
    }

    public String getClockBerlinToDigital(String berlin) {
        if(berlinInputIsValid(berlin)) {
            String berlinSecond = berlin.substring(0, 1);
            String berlinHours = berlin.substring(1, 9);
            String berlinMinutes = berlin.substring(9, 24);
            return berlinToHours(berlinHours) + ":" + berlinToMinutes(berlinMinutes) + ":" + berlinToSecondsLamp(berlinSecond);
        }else{
            return "Berlin input is invalid!";
        }
    }
    public boolean berlinInputIsValid(String berlin) {
        String berlinSecond = berlin.substring(0,1);
        String berlinHours = berlin.substring(1,9);
        String berlinFiveMinutes = berlin.substring(9,20);
        String berlinSingleMinutes = berlin.substring(20,24);
        if(berlin.length() != 24) return false;
        if(!berlinSecond.matches("[OY]+")) return false;
        if(!berlinHours.matches("[OR]+")) return false;
        if(!berlinFiveMinutes.matches("[YRO]+")) return false;
        if(!berlinSingleMinutes.matches("[YO]+")) return false;
        return true;
    }
}