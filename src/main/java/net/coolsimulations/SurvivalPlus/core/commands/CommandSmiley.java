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

public class CommandSmiley extends CommandBase{

	@Override
	public String getCommandName() {
		
		return ":)";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		
		return "sp.commands.smiley.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		
		if (args.length >= 1)
        {
            throw new WrongUsageException("sp.commands.smiley.usage", new Object[0]);
            
        } else {
        	TextComponentTranslation smiley = new TextComponentTranslation("sp.commands.smiley.display", new Object[] {sender.getDisplayName()});
			smiley.getStyle().setColor(TextFormatting.GREEN);
        	server.getPlayerList().sendChatMsg(smiley);
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
    public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos)
    {
        return getListOfStringsMatchingLastWord(args);
    }

}
