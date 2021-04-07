package net.foxdenstudio.foxsuite.foxguard.api.flag;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FoxGuardCommonFlags {

    private final FlagManager flagManager;

    public final FlagManager.Flag root;
    public final FlagManager.Flag debuff;
    public final FlagManager.Flag block;
    public final FlagManager.Flag change;
    public final FlagManager.Flag interact;

    public final FlagManager.Flag primary;
    public final FlagManager.Flag secondary;
    public final FlagManager.Flag mainHand;
    public final FlagManager.Flag offHand;



    public final FlagManager.Schema rootSchema;
    public final FlagManager.Schema commonSchema;

    @Inject
    private FoxGuardCommonFlags(FlagManager flagManager) {
        this.flagManager = flagManager;
        this.root = flagManager.obtainFlag("root");
        this.debuff = flagManager.obtainFlag("debuff");
        this.block = flagManager.obtainFlag("block");
        this.change = flagManager.obtainFlag("change");
        this.interact = flagManager.obtainFlag("interact");

        this.primary = flagManager.obtainFlag("primary");
        this.secondary = flagManager.obtainFlag("secondary");
        this.mainHand = flagManager.obtainFlag("main-hand");
        this.offHand = flagManager.obtainFlag("off-hand");

        this.rootSchema = flagManager.obtainSchema(0).addFlags(root, debuff, block, change, interact);
        this.commonSchema = flagManager.obtainSchema(1).addFlags(primary, secondary, mainHand, offHand);

        flagManager.computeMapping();
    }
}
