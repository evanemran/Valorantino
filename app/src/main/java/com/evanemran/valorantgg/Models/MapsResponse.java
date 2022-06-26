package com.evanemran.valorantgg.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class MapsResponse implements Serializable {
    public String uuid;
    public String displayName;
    public String coordinates;
    public String displayIcon;
    public String listViewIcon;
    public String splash;
    public String assetPath;
    public String mapUrl;
    public double xMultiplier;
    public double yMultiplier;
    public double xScalarToAdd;
    public double yScalarToAdd;
    public ArrayList<Callout> callouts;
}
