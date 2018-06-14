package me.eftelist.modulesystem;

public interface IModule {

    void onLoad();

    void onEnable();

    void onDisable();

    boolean getEnabled();
}
