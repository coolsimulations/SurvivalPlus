package net.coolsimulations.SurvivalPlus.core.commands;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

public class CommandWeba extends CommandBase{

	@Override
	public String getName() {
		
		return "weba";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		
		return "sp.commands.weba.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		
		if (args.length == 0 || args.length >=2)
        {
            throw new WrongUsageException("sp.commands.weba.usage", new Object[0]);
        }
		else if(args.length == 1)
		{
			EntityPlayer entityplayer = getPlayer(server, sender, args[0]);
			EntityPlayer player = Minecraft.getMinecraft().player;
			
			if (entityplayer == sender)
			{
				throw new PlayerNotFoundException("sp.commands.weba.sameTarget", new Object[0]);
			}else {
				TextComponentTranslation weba = new TextComponentTranslation("sp.commands.weba.display", new Object[] {sender.getDisplayName(), entityplayer.getDisplayName()});
				weba.getStyle().setColor(TextFormatting.GOLD);
				server.getPlayerList().sendMessage(weba);
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
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos)
    {
        return getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames());
    }

}
