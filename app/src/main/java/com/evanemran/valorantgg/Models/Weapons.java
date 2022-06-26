package com.evanemran.valorantgg.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Weapons implements Serializable {
    public String uuid = "";
    public String displayName = "";
    public String category = "";
    public String defaultSkinUuid = "";
    public String displayIcon = "";
    public String killStreamIcon = "";
    public String assetPath = "";
    public WeaponStats weaponStats;
    public ShopData shopData;
    public ArrayList<Skin> skins;
}
