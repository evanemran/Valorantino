package com.evanemran.valorantgg.Models;

import java.io.Serializable;

public class ShopData implements Serializable {
    public int cost;
    public String category;
    public String categoryText;
    public GridPosition gridPosition;
    public boolean canBeTrashed;
    public Object image;
    public String newImage;
    public Object newImage2;
    public String assetPath;
}
