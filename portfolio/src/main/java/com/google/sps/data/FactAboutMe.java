/** Class containing format of facts. */
package com.google.sps.data;

public final class FactAboutMe{
    private final String pathImage;
    private final String fact;

    public FactAboutMe(String pathImage, String fact){
        this.pathImage = pathImage;
        this.fact = fact;
    }

    public String getPathImage(){
        return pathImage;
    }

    public String getFact(){
       return fact;
    }
}