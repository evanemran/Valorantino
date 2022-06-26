package com.evanemran.valorantgg.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class WeaponStats implements Serializable {
    public double fireRate;
    public int magazineSize;
    public double runSpeedMultiplier;
    public double equipTimeSeconds;
    public double reloadTimeSeconds;
    public double firstBulletAccuracy;
    public int shotgunPelletCount;
    public String wallPenetration = "";
    public String feature = "";
    public Object fireMode;
    public String altFireType = "";
    public AdsStats adsStats;
    public Object altShotgunStats;
    public Object airBurstStats;
    public ArrayList<DamageRanx> damageRanges;
}
