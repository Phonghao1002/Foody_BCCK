package com.example.foody;

public class ListViewBean_2 {
    int image;
    String langTitle;
    public ListViewBean_2(){
    }
    public ListViewBean_2(int image, String langTitle){
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
