package com.example.user.hw;
public class Weather {
    private String main;
    private String description;
    private String temp;
    private String min_temp;
    private String max_temp;


    public void setMain(String main) {
        this.main = main;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public void setTemp(String temp) {
        this.temp = temp;
    }


    public void setMin_temp(String min_temp) {
        this.min_temp = min_temp;
    }


    public void setMax_temp(String max_temp) {
        this.max_temp = max_temp;
    }

    public String to_str(){

        return main+"\n"+"Температура: "+temp+"\n"+"Максимальная: "+max_temp+"\n"+"Миниимальная: "+min_temp+"\n"+"Описание: "+description+"\n";
    }

}
