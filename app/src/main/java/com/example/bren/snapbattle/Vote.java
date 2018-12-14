package com.example.bren.snapbattle;

public class Vote {

    private String Name;
    private String Score ;
    private int Thumbnail ;

    public Vote() {
    }

    public Vote(String name, String score, int thumbnail) {
        Name = name;
        Score = score;
        Thumbnail = thumbnail;
    }


    public String getName() {
        return Name;
    }

    public String getScore() {
        return Score;
    }



    public int getThumbnail() {
        return Thumbnail;
    }


    public void setName(String name) {
        Name = name;
    }

    public void setScore(String score) {
        Score = score;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}