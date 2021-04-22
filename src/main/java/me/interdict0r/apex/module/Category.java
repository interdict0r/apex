package me.interdict0r.apex.module;

public enum Category {
    PVP("pvp"), EXPLOITS("exploits"), RENDER("render"), PLAYER("player"), CLIENT("client");

    public String name;
    public int moduleIndex;

    Category(String name){
        this.name = name;
    }
}
