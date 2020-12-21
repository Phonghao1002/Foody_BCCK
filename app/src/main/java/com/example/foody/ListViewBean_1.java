package com.example.foody;

public class ListViewBean_1 {
    int image;
    String langTitle, comment;
    public ListViewBean_1(){
    }
    public ListViewBean_1(int image, String langTitle, String comment){
        super();
        this.image = image;
        this.langTitle= langTitle;
        this.comment = comment;
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
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}
