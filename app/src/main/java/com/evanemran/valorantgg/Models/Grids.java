package com.evanemran.valorantgg.Models;

import androidx.fragment.app.Fragment;

import com.evanemran.valorantgg.Fragments.AgentsFragment;
import com.evanemran.valorantgg.Fragments.BuddiesFragment;
import com.evanemran.valorantgg.Fragments.BundlesFragment;
import com.evanemran.valorantgg.Fragments.EventsFragment;
import com.evanemran.valorantgg.Fragments.MapsFragment;
import com.evanemran.valorantgg.Fragments.WeaponsFragment;
import com.evanemran.valorantgg.R;

import java.io.Serializable;

public enum Grids implements Serializable {

    AGENT(R.string.agent, R.drawable.agent, new AgentsFragment()),
    WEAPONS(R.string.weapons, R.drawable.weapons, new WeaponsFragment()),
    MAPS(R.string.maps, R.drawable.maps, new MapsFragment()),
    BUDDIES(R.string.buddies, R.drawable.buddies, new BuddiesFragment()),
    BUNDLES(R.string.bundles, R.drawable.bundles, new BundlesFragment()),
    TIERS(R.string.tiers, R.drawable.tiers, new AgentsFragment()),
    SPRAYS(R.string.sprays, R.drawable.sprays, new AgentsFragment()),
    SEASONS(R.string.seasons, R.drawable.seasons, new AgentsFragment()),
    GEAR(R.string.gear, R.drawable.gear, new AgentsFragment()),
    EVENTS(R.string.events, R.drawable.events, new EventsFragment()),
    MODES(R.string.modes, R.drawable.modes, new AgentsFragment()),
    PLAYERTITLE(R.string.playertitle, R.drawable.playertitle, new AgentsFragment()),
    PLAYERCARD(R.string.playercard, R.drawable.playercards, new AgentsFragment()),
    THEME(R.string.theme, R.drawable.ic_valorant, new AgentsFragment()),
    CEREMONY(R.string.ceremony, R.drawable.events, new AgentsFragment()),
    CURRENCY(R.string.currency, R.drawable.currency, new AgentsFragment());

    private int stringId = 0;
    private int icon = 0;
    private Fragment fragment = null;

    Grids(int stringId, int icon, Fragment fragment) {
        this.stringId = stringId;
        this.icon = icon;
        this.fragment = fragment;
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

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
