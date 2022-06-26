package com.evanemran.valorantgg.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Skin implements Serializable {
    public String uuid;
    public String displayName;
    public String themeUuid;
    public String contentTierUuid;
    public String displayIcon;
    public Object wallpaper;
    public String assetPath;
    public ArrayList<Chroma> chromas;
    public ArrayList<Level> levels;
}
