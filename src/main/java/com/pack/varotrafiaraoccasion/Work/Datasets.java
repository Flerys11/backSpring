package com.pack.varotrafiaraoccasion.Work;

public class Datasets {
    String label;
    Long[] data;
    Boolean fill= true;
    String borderColor;
    String backgroundColor;
    int borderWidth= 1;
    int pointRadius= 5;
    int pointHoverRadius= 8 ;
    public Datasets(String label,Long[] data,String color){
        this.label=label;
        this.data=data;
        this.borderColor=color;
        this.backgroundColor=color;
    }
}
