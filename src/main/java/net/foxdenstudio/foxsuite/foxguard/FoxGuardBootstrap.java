package net.foxdenstudio.foxsuite.foxguard;

import com.google.common.collect.ImmutableList;
import net.foxdenstudio.foxsuite.foxcore.FoxBootstrapper;
import net.foxdenstudio.foxsuite.foxguard.guice.module.FoxGuardModule;

public class FoxGuardBootstrap implements FoxBootstrapper.Plugin<FoxGuard> {

    @Override
    public void configure(FoxBootstrapper bootstrapper) {
        bootstrapper.registerPluginModules(this, FoxGuard.class, new FoxGuardModule(), ImmutableList.of());
    }

    @Override
    public void init(FoxGuard injectedPluginInstance) {
        injectedPluginInstance.awoo();
        injectedPluginInstance.configureCommands();
        injectedPluginInstance.registerCommands();
        injectedPluginInstance.setupStaticContent();
    }

}
