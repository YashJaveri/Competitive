package oopm;

public class TaskObject {

    private String task = "";
    private int hour = 0;
    private int minute = 0;
    public int duration = 0;
    private Boolean isAM = true;

    TaskObject(String _task, int _hour, int _minute, Boolean _isAM, int _duration) {
        hour = _hour;
        minute = _minute;
        task = _task;
        isAM = _isAM;
        duration = _duration;
    }

    public String getTask() {
        return task;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public Boolean isAM() {
        return isAM;
    }

    public int getDuration() {
        return duration;
    }

    public String getTime() {
        String temp = (minute < 10) ? "0" : "";    //to get rid of single digit problem in time
        if (isAM) {
            String time = Integer.toString(hour) + ":" + temp + Integer.toString(minute) + " AM";
            return time;
        } else {
            String time = Integer.toString(hour) + ":" + temp + Integer.toString(minute) + " PM";
            return time;
        }
    }

    public String numberToWord(int num) {
        String ones[] = {" ", " ONE", " TWO", " THREE", " FOUR", " FIVE", " SIX", " SEVEN", " EIGHT", " NINE", " TEN", " ELEVEN", " TWELVE", " THIRTEEN", " FOURTEEN", " FIFTEEN", " SIXTEEN", " SEVENTEEN", " EIGHTEEN", " NINETEEN"
        };
        String tens[] = {" ", " ", " TWENTY", " THIRTY", " FOURTY", " FIFTY", " SIXTY", " SEVENTY", " EIGHTY", " NINETY"};

        String word = "";
        if (num > 19) {
            word = tens[num / 10] + " " + ones[num % 10];
        } else {
            word = ones[num];
        }
        return word;
    }

    public String getSmartVoice() {
        String ampm = (isAM) ? " A M" : " PM";
        String sVT = task + " at " + numberToWord(hour) + " " + numberToWord(minute) + ampm + "  ..........";
        return sVT;
    }
}
