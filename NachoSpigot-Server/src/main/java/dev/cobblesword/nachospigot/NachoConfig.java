package dev.cobblesword.nachospigot;

public class NachoConfig {
    public boolean saveEmptyScoreboardTeams = false;
    public boolean enablePluginsCommand = true;
    public boolean useFastOperators = false;
    public boolean patchProtocolLib = true;
    public boolean stopNotifyBungee = false;
    public boolean checkForMalware = false;
    public boolean kickOnIllegalBehavior = true;
    public boolean shouldTickEnchantmentTables = true;
    public boolean usePandaWire = true;
    public boolean constantExplosions = false;
    public boolean explosionProtectedRegions = true;
    public boolean fireEntityExplodeEvent = true;
    public boolean reducedDensityRays = true;
    public int playerTimeStatisticsInterval = 20;
    public String serverBrandName = "HolySpigot";
    public boolean stopDecodingItemStackOnPlace = true;
    public boolean infiniteWaterSources = true;
    public boolean leavesDecayEvent = true;
    public boolean enableMobAI = true;
    public boolean enableMobSound = true;
    public boolean enableEntityActivation = true;
    public boolean enableLavaToCobblestone = true;
    public boolean firePlayerMoveEvent = false; // Highly recommend disable this for lobby/limbo/minigames servers.
    public boolean endermiteSpawning = true;
    public boolean disablePhysicsPlace = false;
    public boolean disablePhysicsUpdate = false;
    public boolean doBlocksOperations = true;
    public boolean doChunkUnload = true;
    public int chunkThreads = 2; // PaperSpigot - Bumped value
    public int playersPerThread = 50;
    public boolean enableTCPNODELAY = true;
    public boolean useFixedPoolForTNT = false;
    public int fixedPoolSize = 500;
    public boolean useFasterCannonTracker = true;
    public boolean disableSpongeAbsorption = false;
}
