/** Class containing format of facts. */
package com.google.sps.data;

public final class FactAboutMe{
    private final String pathImage;
    private final String altAttribute;
    private final String fact;

    public FactAboutMe(String pathImage, String altAttribute,String fact){
        this.pathImage = pathImage;
        this.altAttribute = altAttribute;
        this.fact = fact;
    }

    public String getPathImage(){
        return pathImage;
    }

    public String getAltAttribute(){
        return altAttribute;
    }

    public String getFact(){
       return fact;
    }
}