package net.minecraft.server;

import org.bukkit.command.defaults.PluginsCommand;

import java.util.Iterator;

public class CommandDispatcher extends CommandHandler implements ICommandDispatcher {

    public CommandDispatcher() {
        this.a(new CommandGamemode());
        this.a(new CommandTp());
        this.a(new CommandClear());
        if (MinecraftServer.getServer().ae()) {
            this.a(new CommandOp());
            this.a(new CommandDeop());
            this.a(new CommandStop());
            this.a(new CommandSaveAll());
            this.a(new CommandWhitelist());
        } else {
            this.a(new CommandPublish());

        }

        CommandAbstract.a(this);
    }

    public void a(ICommandListener icommandlistener, ICommand icommand, int i, String s, Object... aobject) {
        boolean flag = true;
        MinecraftServer minecraftserver = MinecraftServer.getServer();

        if (!icommandlistener.getSendCommandFeedback()) {
            flag = false;
        }

        ChatMessage chatmessage = new ChatMessage("chat.type.admin", icommandlistener.getName(), new ChatMessage(s, aobject));

        chatmessage.getChatModifier().setColor(EnumChatFormat.GRAY);
        chatmessage.getChatModifier().setItalic(Boolean.TRUE);
        if (flag) {
            for (EntityPlayer entityPlayer : minecraftserver.getPlayerList().v()) {
                EntityHuman entityhuman = entityPlayer;
                if (entityhuman != icommandlistener && minecraftserver.getPlayerList().isOp(entityhuman.getProfile()) && icommand.canUse(icommandlistener)) {
                    boolean flag1 = icommandlistener instanceof MinecraftServer && MinecraftServer.getServer().r();
                    boolean flag2 = icommandlistener instanceof RemoteControlCommandListener && MinecraftServer.getServer().q();

                    if (flag1 || flag2 || !(icommandlistener instanceof RemoteControlCommandListener) && !(icommandlistener instanceof MinecraftServer)) {
                        entityhuman.sendMessage(chatmessage);
                    }
                }
            }
        }

        if (icommandlistener != minecraftserver && minecraftserver.worldServer[0].getGameRules().getBoolean("logAdminCommands") && !org.spigotmc.SpigotConfig.silentCommandBlocks) { // Spigot
            minecraftserver.sendMessage(chatmessage);
        }

        boolean flag3 = minecraftserver.worldServer[0].getGameRules().getBoolean("sendCommandFeedback");

        if (icommandlistener instanceof CommandBlockListenerAbstract) {
            flag3 = ((CommandBlockListenerAbstract) icommandlistener).m();
        }

        if ((i & 1) != 1 && flag3 || icommandlistener instanceof MinecraftServer) {
            icommandlistener.sendMessage(new ChatMessage(s, aobject));
        }

    }
}
