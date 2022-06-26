package com.evanemran.valorantgg.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Datum implements Serializable {
    public String uuid;
    public String displayName;
    public String description;
    public String developerName;
    public ArrayList<String> characterTags;
    public String displayIcon;
    public String displayIconSmall;
    public String bustPortrait;
    public String fullPortrait;
    public String killfeedPortrait;
    public String background;
    public String assetPath;
    public boolean isFullPortraitRightFacing;
    public boolean isPlayableCharacter;
    public boolean isAvailableForTest;
    public boolean isBaseContent;
    public Role role;
    public ArrayList<Ability> abilities;
    public VoiceLine voiceLine;
}
