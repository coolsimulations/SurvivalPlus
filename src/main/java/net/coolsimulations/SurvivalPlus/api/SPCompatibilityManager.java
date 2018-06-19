package net.coolsimulations.SurvivalPlus.api;

import net.minecraftforge.fml.common.Loader;

public class SPCompatibilityManager {
	
	private static boolean modTELoaded;
    private static boolean modGCLoaded;
    private static boolean modGCPLoaded;
    private static boolean modProjectELoaded;
    private static boolean modJeiLoaded;
    private static boolean modIc2Loaded;
    private static boolean modBCraftLoaded;
    private static boolean modAppEngLoaded;
    private static boolean modPneumaticCraftLoaded;
    private static boolean modBopLoaded;
    private static boolean modBaseMetalsLoaded;
    private static boolean modFlourPowerLoaded;
    private static boolean modWoodenBucketLoaded;
    private static boolean modSimpleGrinderLoaded;
    
    public static final String TE_MODID = "thermalexpansion";
    public static final String GCCORE_MODID = "galacticraftcore";
    public static final String GCPLANETS_MODID = "galacticraftplanets";
    public static final String PROJECTE_MODID = "ProjectE";
    public static final String JEI_MODID = "JEI";
    public static final String IC2_MODID = "IC2";
    public static final String BCRAFTCORE_MODID = "buildcraftcore";
    public static final String APPENG_MODID = "appliedenergistics2";
    public static final String PNEUMATICCRAFT_MODID = "pneumaticcraft";
    public static final String BOP_MODID = "BiomesOPlenty";
    public static final String BASEMETALS_MODID = "basemetals";
    public static final String FLOURPOWER_MODID = "flourpower";
    public static final String WOODENBUCKET_MODID = "woodenbucket";
    public static final String VEFLUIDS_MODID = "vefluids";
    public static final String SIMPLEGRINDER_MODID = "simplegrinder";
    
    public static void checkForCompatibleMods(){

        if (Loader.isModLoaded(TE_MODID))
        {
            SPCompatibilityManager.modTELoaded = true;
        }
    	
    	if (Loader.isModLoaded(GCCORE_MODID))
    	{
    		SPCompatibilityManager.modGCLoaded = true;
    	}
    	
    	if (Loader.isModLoaded(GCPLANETS_MODID))
    	{
    		SPCompatibilityManager.modGCPLoaded = true;
    	}
    	
    	if (Loader.isModLoaded(PROJECTE_MODID))
    	{
    		SPCompatibilityManager.modProjectELoaded = true;
    	}
    	
    	if (Loader.isModLoaded(JEI_MODID))
    	{
    		SPCompatibilityManager.modJeiLoaded = true;
    	}

        if (Loader.isModLoaded(IC2_MODID))
        {
            SPCompatibilityManager.modIc2Loaded = true;
        }
        

        if (Loader.isModLoaded(BCRAFTCORE_MODID))
        {
            SPCompatibilityManager.modBCraftLoaded = true;
        }

        if (Loader.isModLoaded(APPENG_MODID))
        {
            SPCompatibilityManager.modAppEngLoaded = true;
        }

        if (Loader.isModLoaded(PNEUMATICCRAFT_MODID))
        {
            SPCompatibilityManager.modPneumaticCraftLoaded = true;
        }
        
        if (Loader.isModLoaded(BOP_MODID))
        {
            SPCompatibilityManager.modBopLoaded = true;
        }
        
        if (Loader.isModLoaded(BASEMETALS_MODID))
        {
            SPCompatibilityManager.modBaseMetalsLoaded = true;
        }
        
        if (Loader.isModLoaded(FLOURPOWER_MODID))
        {
            SPCompatibilityManager.modFlourPowerLoaded = true;
        }
        
        if (Loader.isModLoaded(WOODENBUCKET_MODID) && Loader.isModLoaded(VEFLUIDS_MODID))
        {
            SPCompatibilityManager.modWoodenBucketLoaded = true;
        }
        
        if (Loader.isModLoaded(SIMPLEGRINDER_MODID))
        {
            SPCompatibilityManager.modSimpleGrinderLoaded = true;
        }
    }

    public static boolean isIc2Loaded()
    {
        return SPCompatibilityManager.modIc2Loaded;
    }
    
    public static boolean isProjectELoaded()
    {
        return SPCompatibilityManager.modProjectELoaded;
    }
    
    public static boolean isGCLoaded()
    {
        return SPCompatibilityManager.modGCLoaded;
    }
    
    public static boolean isBCraftLoaded()
    {
        return SPCompatibilityManager.modBCraftLoaded;
    }

    public static boolean isTELoaded()
    {
        return SPCompatibilityManager.modTELoaded;
    }

    public static boolean isGCPLoaded()
    {
        return SPCompatibilityManager.modGCPLoaded;
    }

    public static boolean isAppEngLoaded()
    {
        return SPCompatibilityManager.modAppEngLoaded;
    }

    public static boolean isPneumaticCraftLoaded()
    {
        return SPCompatibilityManager.modPneumaticCraftLoaded;
    }
    
    public static boolean isJeiLoaded()
    {
        return SPCompatibilityManager.modJeiLoaded;
    }
    
    public static boolean isBopLoaded()
    {
        return SPCompatibilityManager.modBopLoaded;
    }
    
    public static boolean isBaseMetalsLoaded()
    {
        return SPCompatibilityManager.modBaseMetalsLoaded;
    }
    
    public static boolean isFlourPowerLoaded()
    {
        return SPCompatibilityManager.modFlourPowerLoaded;
    }
    
    public static boolean isWoodenBucketLoaded()
    {
        return SPCompatibilityManager.modWoodenBucketLoaded;
    }
    
    public static boolean isSimpleGrinderLoaded()
    {
        return SPCompatibilityManager.modSimpleGrinderLoaded;
    }

}
