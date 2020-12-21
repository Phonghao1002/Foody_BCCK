package com.example.foody;

public class ListViewBean {
    int image;
    String langTitle;
    public ListViewBean(){
    }
    public ListViewBean(int image, String langTitle){
        super();
        this.image = image;
        this.langTitle= langTitle;
    }
    public int getImage(){
        return image;
    }
    public void setImage(int image){
        this.image = image;
    }
    public String getLangTitle(){
        return langTitle;
    }
    public void setLangTitle(String langTitle){
        this.langTitle = langTitle;
    }
}
