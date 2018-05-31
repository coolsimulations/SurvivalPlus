package net.coolsimulations.SurvivalPlus.core.commands;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

public class CommandIndeed extends CommandBase{

	@Override
	public String getName() {
		
		return "indeed";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		
		return "sp.commands.indeed.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		
		if (args.length >= 2)
        {
            throw new WrongUsageException("sp.commands.indeed.usage", new Object[0]);
        }
        else if(args.length == 1)
        {
        	Entity entityplayer = getEntity(server, sender, args[0]);
        	
        	if (entityplayer == sender)
            {
                throw new PlayerNotFoundException("sp.commands.indeed.sameTarget", new Object[0]);
            }else {
            	TextComponentTranslation indeed = new TextComponentTranslation("sp.commands.indeed.display1", new Object[] {sender.getDisplayName(), entityplayer.getDisplayName()});
        		indeed.getStyle().setColor(TextFormatting.DARK_GREEN);
        		server.getPlayerList().sendMessage(indeed);
            }
        }
        else
        {
        	TextComponentTranslation indeed = new TextComponentTranslation("sp.commands.indeed.display2", new Object[] {sender.getDisplayName()});
    		indeed.getStyle().setColor(TextFormatting.DARK_GREEN);
    		server.getPlayerList().sendMessage(indeed);
        }
	}

	@Override
	public int getRequiredPermissionLevel() {
		
		return 0;
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
