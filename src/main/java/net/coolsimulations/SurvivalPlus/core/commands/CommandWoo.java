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

public class CommandWoo extends CommandBase{

	@Override
	public String getName() {
		
		return "woo";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		
		return "sp.commands.woo.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		
		if (args.length >= 1)
        {
            throw new WrongUsageException("sp.commands.woo.usage", new Object[0]);
            
        } else {
        	TextComponentTranslation woo = new TextComponentTranslation("sp.commands.woo.display", new Object[] {sender.getDisplayName()});
        	woo.getStyle().setColor(TextFormatting.BLUE);
        	server.getPlayerList().sendMessage(woo);
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
