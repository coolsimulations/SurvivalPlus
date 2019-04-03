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
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

public class CommandEmportant extends CommandBase{

	@Override
	public String getCommandName() {
		
		return "emportant";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		
		return "sp.commands.emportant.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		
		if (args.length == 0)
        {
            throw new WrongUsageException("sp.commands.emportant.usage", new Object[0]);
        }
        else
        {
        	
        	ITextComponent itextcomponent = getChatComponentFromNthArg(sender, args, 0, !(sender instanceof EntityPlayer));
        	
           	TextComponentTranslation emportant = new TextComponentTranslation("sp.commands.emportant.display", new Object[] {sender.getDisplayName(), itextcomponent.createCopy()});
           	emportant.getStyle().setColor(TextFormatting.BLUE);
           	emportant.getStyle().setBold(true);
           	server.getPlayerList().sendChatMsg(emportant);
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
	public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
		
		return getListOfStringsMatchingLastWord(args);
	}

}
