package net.foxdenstudio.foxsuite.foxguard.content.handler;

import net.foxdenstudio.foxsuite.foxcore.api.archetype.ArchetypeBase;
import net.foxdenstudio.foxsuite.foxcore.api.archetype.type.FoxType;
import net.foxdenstudio.foxsuite.foxcore.api.object.FoxDetailableObject;
import net.foxdenstudio.foxsuite.foxcore.api.storage.FoxObjectData;
import net.foxdenstudio.foxsuite.foxcore.api.storage.FoxStorageDataClass;
import net.foxdenstudio.foxsuite.foxcore.api.storage.ISimpleState;
import net.foxdenstudio.foxsuite.foxcore.content.archetype.RegionArchetype;
import net.foxdenstudio.foxsuite.foxcore.content.attribute.ArchetypeDisplayNameAttribute;
import net.foxdenstudio.foxsuite.foxcore.content.region.QubeRegion;
import net.foxdenstudio.foxsuite.foxcore.platform.command.source.CommandSource;
import net.foxdenstudio.foxsuite.foxcore.platform.fox.text.TextFactory;
import net.foxdenstudio.foxsuite.foxcore.platform.text.Text;
import net.foxdenstudio.foxsuite.foxcore.platform.text.format.TextColors;
import net.foxdenstudio.foxsuite.foxguard.api.flag.EventData;
import net.foxdenstudio.foxsuite.foxguard.api.handler.FoxHandlerBase;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

public class FoxyHandler extends FoxHandlerBase<FoxyHandler.Type> implements FoxDetailableObject, ISimpleState<FoxyHandler.Data> {

    private final TextFactory tf;
    private final TextColors tc;

    @Inject
    private FoxyHandler(FoxyHandler.Type archetype, TextFactory textFactory, TextColors textColors) {
        super(archetype);
        this.tf = textFactory;
        this.tc = textColors;
    }

    @Override
    public Response handle(EventData event) {
        return null;
    }

    @Override
    public Text details(CommandSource source, String arguments) {
        return null;
    }

    @Override
    public Data getData() {
        return null;
    }

    @Override
    public boolean setData(@Nullable Data data) {
        return false;
    }

    @Singleton
    public static class Type extends ArchetypeBase implements FoxType {

        @Inject
        private Type(RegionArchetype regionArchetype,
                     ArchetypeDisplayNameAttribute archetypeDisplayNameAttribute){
            super("foxyh", "FoxyH", regionArchetype, archetypeDisplayNameAttribute);
            writeDefaultName(archetypeDisplayNameAttribute);
        }
    }

    @FoxStorageDataClass(version = 1)
    public static class Data implements FoxObjectData {

    }
}
