package net.foxdenstudio.foxsuite.foxguard.api.flag;

import net.foxdenstudio.foxsuite.foxcore.platform.entity.living.player.User;

public class EventData {

    transient Object event;

    FlagSet primary;

    User cause;

    public EventData(Object event, FlagSet primary) {
        this.event = event;
        this.primary = primary;
    }
}
