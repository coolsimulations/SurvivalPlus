package net.coolsimulations.SurvivalPlus.core.commands;

import java.util.List;

import javax.annotation.Nullable;

import net.coolsimulations.SurvivalPlus.api.SPConfig;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

public class CommandWak extends CommandBase{

	@Override
	public String getName() {
		
		return "wak";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		
		return "sp.commands.wak.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		
		if (args.length == 0 || args.length >=2)
        {
            throw new WrongUsageException("sp.commands.wak.usage", new Object[0]);
        }
		else if(args.length == 1)
		{
			EntityPlayer entityplayer = getPlayer(server, sender, args[0]);
			
			if (entityplayer == sender)
			{
				throw new PlayerNotFoundException("sp.commands.wak.sameTarget", new Object[0]);
			}else {
				TextComponentTranslation wak = new TextComponentTranslation("sp.commands.wak.display", new Object[] {sender.getDisplayName(), entityplayer.getDisplayName()});
				wak.getStyle().setColor(TextFormatting.DARK_RED);
				server.getPlayerList().sendMessage(wak);
			}
		}
		
	}

	@Override
	public int getRequiredPermissionLevel() {
		
		if(SPConfig.opWak > 4) {
			return 4;
		} else {
			return SPConfig.opWak;
		}
	}
	
    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender)
    {
        return true;
    }
    
    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos)
    {
        return getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames());
    }

}
