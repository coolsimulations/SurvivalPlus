package net.coolsimulations.SurvivalPlus.core.commands;

import java.util.List;

import javax.annotation.Nullable;

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

public class CommandConfrats extends CommandBase{

	@Override
	public String getName() {
		
		return "confrats";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		
		return "sp.commands.confrats.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		
		if (args.length == 0 || args.length >=2)
        {
            throw new WrongUsageException("sp.commands.confrats.usage", new Object[0]);
        }
        else
        {
        	EntityPlayer entityplayer = getPlayer(server, sender, args[0]);
        	
        	if (entityplayer == sender)
            {
                throw new PlayerNotFoundException("sp.commands.confrats.sameTarget", new Object[0]);
            }else {
            	TextComponentTranslation confrats = new TextComponentTranslation("sp.commands.confrats.display", new Object[] {entityplayer.getDisplayName(), sender.getDisplayName()});
            	confrats.getStyle().setColor(TextFormatting.YELLOW);
            	server.getPlayerList().sendMessage(confrats);
            }
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
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
		
		return getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames());
	}

}
