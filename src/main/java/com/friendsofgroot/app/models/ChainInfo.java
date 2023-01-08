package com.friendsofgroot.app.models;

/**
 * A Projection for the {@link Chain} entity
 */
public interface ChainInfo {
    Integer getId();

    String getName();

    String getSymbol();

    String getDescription();

    String getLongDescription();

    String getIconUrl();

    String getCategory();

    Integer getAddressesCount();
}