package com.nerjal.random_commands;

import com.nerjal.random_commands.commands.HereCommand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Random_commands implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        LOGGER.info("Registering random commands");
        CommandRegistrationCallback.EVENT.register(((dispatcher, dedicated) -> {
            HereCommand.register(dispatcher);
            // future commands will come here
        }));
    }
}
