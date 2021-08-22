package org.bukkit.util.permissions;

import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

public final class CommandPermissions {
    private static final String ROOT = "bukkit.command";
    private static final String PREFIX = ROOT + ".";

    private CommandPermissions() {}

    public static Permission registerPermissions(Permission parent) {
        Permission commands = DefaultPermissions.registerPermission(ROOT, "Gives the user the ability to use all CraftBukkit commands", parent);

        DefaultPermissions.registerPermission(PREFIX + "plugins", "Allows the user to view the list of plugins running on this server", PermissionDefault.OP, commands);

        commands.recalculatePermissibles();
        return commands;
    }
}
