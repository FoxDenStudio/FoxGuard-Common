package net.foxdenstudio.foxsuite.foxguard;

import net.foxdenstudio.foxsuite.foxcore.api.FoxRegistry;
import net.foxdenstudio.foxsuite.foxcore.api.annotation.command.FoxMainDispatcher;
import net.foxdenstudio.foxsuite.foxcore.api.annotation.guice.FoxLogger;
import net.foxdenstudio.foxsuite.foxcore.api.command.standard.FoxCommandDispatcher;
import net.foxdenstudio.foxsuite.foxcore.api.object.index.FoxMainIndex;
import net.foxdenstudio.foxsuite.foxcore.api.world.FoxWorldManager;
import net.foxdenstudio.foxsuite.foxcore.platform.command.PlatformCommandManager;
import net.foxdenstudio.foxsuite.foxcore.platform.command.source.ConsoleSource;
import net.foxdenstudio.foxsuite.foxguard.api.annotation.FoxGuardPluginInstance;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class FoxGuard {

    private final Provider<PlatformCommandManager> commandManager;
    private final FoxCommandDispatcher mainCommandDispatcher;

    // TODO You don't always have the console source, especially when you're running from the client.
    private final Provider<ConsoleSource> consoleSource;

    private final FoxMainIndex mainIndex;

    private final FoxRegistry registry;

    private final FGStaticContent content;

    private final FoxWorldManager worldManager;

    @FoxLogger("guard.greeting")
    private Logger logger;

    @com.google.inject.Inject(optional = true)
    @FoxGuardPluginInstance
    Object foxGuardPlugin = this;

    @Inject
    public FoxGuard(Provider<PlatformCommandManager> commandManager,
                    @FoxMainDispatcher FoxCommandDispatcher mainCommandDispatcher,
                    Provider<ConsoleSource> consoleSource, FoxMainIndex mainIndex,
                    FoxRegistry registry, FGStaticContent content, FoxWorldManager worldManager) {
        this.commandManager = commandManager;
        this.mainCommandDispatcher = mainCommandDispatcher;
        this.consoleSource = consoleSource;
        this.mainIndex = mainIndex;
        this.registry = registry;
        this.content = content;
        this.worldManager = worldManager;

    }

    public void configureCommands() {

    }

    public void registerCommands() {

    }

    public void setupStaticContent() {

    }

    public void awoo() {
        logger.info("Bark bark I'm a guardian fox!");
    }
}
