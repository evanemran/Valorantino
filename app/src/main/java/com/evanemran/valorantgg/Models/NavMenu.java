package com.evanemran.valorantgg.Models;

import com.evanemran.valorantgg.R;

public enum NavMenu {
    HOME(R.string.home, R.drawable.ic_valorant),
    VALORANT(R.string.valorant, R.drawable.ic_valorant),
    LANGUAGE(R.string.language, R.drawable.ic_valorant),
    SETTINGS(R.string.settings, R.drawable.ic_valorant),
    ABOUT(R.string.about, R.drawable.ic_valorant),
    THEME(R.string.theme, R.drawable.ic_valorant),
    PROFILE(R.string.profile, R.drawable.ic_valorant);

    private int stringId = 0;
    private int icon = 0;

    NavMenu(int stringId, int icon){
        this.stringId = stringId;
        this.icon = icon;
    }

    public int getStringId() {
        return stringId;
    }

    public void setStringId(int stringId) {
        this.stringId = stringId;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
