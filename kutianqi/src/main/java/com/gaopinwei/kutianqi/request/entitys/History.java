package com.gaopinwei.kutianqi.request.entitys;

public class  History implements Comparable
{
    private String time;
    private String story;

    public History(String time, String story) {
        this.time = time;
        this.story = story;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    @Override
    public String toString() {
        return "History{" +
                "time='" + time + '\'' +
                ", story='" + story + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object another) {
        History  o = (History) another;

       int time1 =  Integer.parseInt(time);
        int time2 =  Integer.parseInt(o.time);

        return  time1 - time2;
    }
}