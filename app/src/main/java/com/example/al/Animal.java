package com.example.al;



public class Animal
{
    private String name;
    private  int image;
    public Animal(String name,int image)
    {
        this.name=name;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
