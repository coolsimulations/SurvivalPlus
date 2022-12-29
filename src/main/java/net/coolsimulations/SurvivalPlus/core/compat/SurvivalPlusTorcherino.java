package net.coolsimulations.SurvivalPlus.core.compat;

import io.netty.buffer.Unpooled;
import net.coolsimulations.SurvivalPlus.core.blocks.tileentity.TileEntitySconce;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import torcherino.Torcherino;
import torcherino.TorcherinoImpl;
import torcherino.block.entity.TorcherinoBlockEntity;
import torcherino.client.screen.TorcherinoScreen;

public class SurvivalPlusTorcherino {
	
    private static final ResourceLocation UPDATE_TORCHERINO_VALUES = Torcherino.resloc("update_torcherino_values");
    private static final ResourceLocation OPEN_TORCHERINO_SCREEN = Torcherino.resloc("open_torcherino_screen");
	
	public static void init() {
		if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            ClientNetworking.initialize();
        }
		ServerPlayConnectionEvents.INIT.register((handler, server) -> {
            ServerPlayNetworking.registerReceiver(handler, UPDATE_TORCHERINO_VALUES, (server1, player, handler1, buffer, responseSender) -> {
                Level level = player.getLevel();
                BlockPos pos = buffer.readBlockPos();
                int xRange = buffer.readInt();
                int zRange = buffer.readInt();
                int yRange = buffer.readInt();
                int speed = buffer.readInt();
                int redstoneMode = buffer.readInt();
                server1.submit(() -> {
                    if (level.getBlockEntity(pos) instanceof TileEntitySconce blockEntity) {
                        if (!blockEntity.readClientData(xRange, zRange, yRange, speed, redstoneMode)) {
                        	TorcherinoImpl.LOGGER.error("Data received from " + player.getName().getString() + "(" + player.getStringUUID() + ") is invalid.");
                        }
                    } else if (level.getBlockEntity(pos) instanceof TorcherinoBlockEntity blockEntity) {
                        if (!blockEntity.readClientData(xRange, zRange, yRange, speed, redstoneMode)) {
                        	TorcherinoImpl.LOGGER.error("Data received from " + player.getName().getString() + "(" + player.getStringUUID() + ") is invalid.");
                        }
                    }
                });
            });
        });
	}
	
	public static void s2c_openTorcherinoScreen(ServerPlayer player, BlockPos pos, Component name, int xRange, int zRange, int yRange, int speed, int redstoneMode) {
        if (ServerPlayNetworking.canSend(player, OPEN_TORCHERINO_SCREEN)) {
            FriendlyByteBuf buffer = new FriendlyByteBuf(Unpooled.buffer());
            buffer.writeBlockPos(pos);
            buffer.writeComponent(name);
            buffer.writeInt(xRange);
            buffer.writeInt(zRange);
            buffer.writeInt(yRange);
            buffer.writeInt(speed);
            buffer.writeInt(redstoneMode);
            ServerPlayNetworking.send(player, OPEN_TORCHERINO_SCREEN, buffer);
        }
    }
	private static class ClientNetworking {
        private static void initialize() {
            ClientPlayConnectionEvents.INIT.register((handler, client) -> {
                ClientPlayNetworking.registerReceiver(OPEN_TORCHERINO_SCREEN, (client1, handler1, buffer, responseSender) -> {
                    Level world = Minecraft.getInstance().level;
                    BlockPos pos = buffer.readBlockPos();
                    Component title = buffer.readComponent();
                    int xRange = buffer.readInt();
                    int zRange = buffer.readInt();
                    int yRange = buffer.readInt();
                    int speed = buffer.readInt();
                    int redstoneMode = buffer.readInt();
                    buffer.retain();
                    client1.execute(() -> {
                        if (world.getBlockEntity(pos) instanceof TileEntitySconce blockEntity) {
                            Minecraft.getInstance().setScreen(new TorcherinoScreen(title, xRange, zRange, yRange, speed, redstoneMode, pos, blockEntity.getTier()));
                        } else if (world.getBlockEntity(pos) instanceof TorcherinoBlockEntity blockEntity) {
                            Minecraft.getInstance().setScreen(new TorcherinoScreen(title, xRange, zRange, yRange, speed, redstoneMode, pos, blockEntity.getTier()));
                        }
                        buffer.release();
                    });
                });
            });
        }
    }
}
