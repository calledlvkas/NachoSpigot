package org.bukkit.craftbukkit.util.permissions;

import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.util.permissions.DefaultPermissions;

public final class CommandPermissions {
    private static final String ROOT = "minecraft.command";
    private static final String PREFIX = ROOT + ".";

    private CommandPermissions() {}

    public static Permission registerPermissions(Permission parent) {
        Permission commands = DefaultPermissions.registerPermission(ROOT, "Gives the user the ability to use all vanilla minecraft commands", parent);

        DefaultPermissions.registerPermission(PREFIX + "teleport", "Allows the user to teleport players", PermissionDefault.OP, commands);
        DefaultPermissions.registerPermission(PREFIX + "stop", "Allows the user to stop the server", PermissionDefault.OP, commands);

        commands.recalculatePermissibles();
        return commands;
    }
}
