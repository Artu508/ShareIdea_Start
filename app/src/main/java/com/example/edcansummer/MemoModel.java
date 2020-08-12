package com.example.edcansummer;

public class MemoModel {

    private String time, text, eamil;

    public MemoModel(){}

    public MemoModel(String time, String text, String eamil) {
        this.time = time;
        this.text = text;
        this.eamil = eamil;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }
}
