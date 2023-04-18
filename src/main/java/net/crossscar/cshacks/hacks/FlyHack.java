package net.crossscar.cshacks.hacks;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public class FlyHack {
	private static int tick = 0;
	
	public static void onUpdate(PlayerEntity player, boolean fly) {
		if (player != null) {
			if (player.getAbilities().creativeMode) {
				return;
			}
			
			if (fly) {
				tick++;
				player.getAbilities().flying = true;
				
				if (tick == 40) {
					player.refreshPositionAndAngles(player.getX(), player.getY() - 0.04D, player.getZ(), player.getYaw(), player.getPitch());
				} else if (tick == 41) {
					player.refreshPositionAndAngles(player.getX(), player.getY() + 0.04D, player.getZ(), player.getYaw(), player.getPitch());
				} else if (tick == 80) {
					tick = 0;
				}
            } else {
				player.getAbilities().flying = false;
			}
		}
	}
}
