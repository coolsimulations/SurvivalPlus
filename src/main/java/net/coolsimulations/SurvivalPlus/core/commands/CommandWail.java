package net.coolsimulations.SurvivalPlus.core.commands;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

public class CommandWail extends CommandBase{

	@Override
	public String getName() {
		
		return "wail";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		
		return "sp.commands.wail.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		
		if (args.length >= 1)
        {
            throw new WrongUsageException("sp.commands.wail.usage", new Object[0]);
            
        } else {
        	TextComponentTranslation wail = new TextComponentTranslation("sp.commands.wail.display", new Object[] {sender.getDisplayName()});
        	wail.getStyle().setColor(TextFormatting.AQUA);
        	server.getPlayerList().sendMessage(wail);
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
        return getListOfStringsMatchingLastWord(args);
    }

}
