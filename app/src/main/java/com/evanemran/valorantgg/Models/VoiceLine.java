package com.evanemran.valorantgg.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class VoiceLine implements Serializable {
    public double minDuration;
    public double maxDuration;
    public ArrayList<MediaList> mediaList;
}
