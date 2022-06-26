package com.evanemran.valorantgg.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class BuddiesResponse implements Serializable {
    public String uuid;
    public String displayName;
    public boolean isHiddenIfNotOwned;
    public Object themeUuid;
    public String displayIcon;
    public String assetPath;
    public ArrayList<Levels> levels;
}
