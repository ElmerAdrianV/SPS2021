package com.google.sps.data;

public final class Photo{
    private final String pathImage;
    private final String altAttribute;
    private final String caption;

    public Photo(String pathImage, String altAttribute,String caption){
        this.pathImage = pathImage;
        this.altAttribute = altAttribute;
        this.caption = caption;
    }

    public String getPathImage(){
        return pathImage;
    }

    public String getAltAttribute(){
        return altAttribute;
    }

    public String getCaption(){
       return caption;
    }
}