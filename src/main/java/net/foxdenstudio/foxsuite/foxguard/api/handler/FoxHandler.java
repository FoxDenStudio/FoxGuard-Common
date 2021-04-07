package net.foxdenstudio.foxsuite.foxguard.api.handler;

import net.foxdenstudio.foxsuite.foxcore.api.object.FoxObject;
import net.foxdenstudio.foxsuite.foxcore.platform.event.Event;
import net.foxdenstudio.foxsuite.foxcore.platform.util.Tristate;
import net.foxdenstudio.foxsuite.foxguard.api.flag.EventData;

public interface FoxHandler extends FoxObject {

    Response handle(EventData event);

    interface Response {

        Tristate action();

        boolean renderMessage();
    }

}
