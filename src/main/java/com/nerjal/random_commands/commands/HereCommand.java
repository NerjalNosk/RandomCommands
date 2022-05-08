package com.nerjal.random_commands.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.network.MessageType;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

import static net.minecraft.server.command.CommandManager.*;

public class HereCommand {
    public static void register(@NotNull CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("here")
                .requires((source -> source.hasPermissionLevel(0)))
                .executes(HereCommand::sayHere));
    }

    private static int sayHere(@NotNull CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity player = context.getSource().getPlayer();
        String s = String.format("[%d, %d]",(int)player.getX(), (int)player.getY());
        context.getSource().getPlayer().getServerWorld().getPlayers().forEach(
                p -> p.sendMessage(Text.method_30163(
                        String.format("%s is at position %s", player.getDisplayName().getString(), s)
                ), MessageType.CHAT, player.getUuid()));
        return 0;
    }
}
