package net.foxdenstudio.foxsuite.foxguard.api.handler;

import net.foxdenstudio.foxsuite.foxcore.api.archetype.FoxArchetype;
import net.foxdenstudio.foxsuite.foxcore.api.attribute.FoxAttribute;
import net.foxdenstudio.foxsuite.foxcore.api.object.FoxObjectBase;

public abstract class FoxHandlerBase<A extends FoxArchetype> extends FoxObjectBase<A> implements FoxHandler {

    protected FoxHandlerBase(A archetype, FoxAttribute<?>... attributes) {
        super(archetype, attributes);
    }
}
