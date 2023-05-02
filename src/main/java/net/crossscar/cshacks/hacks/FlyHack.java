package net.crossscar.cshacks.hacks;

import net.minecraft.util.math.Vec3d;
import net.minecraft.client.network.ClientPlayerEntity;

public class FlyHack {
	private static int tick = 0;
	
	public static void onUpdate(ClientPlayerEntity player, boolean fly) {
		if (player != null) {
			if (player.getAbilities().creativeMode) {
				return;
			}
			
			if (fly) {
				tick++;

				Vec3d vel = player.getVelocity();
				player.getAbilities().flying = true;
				
				if (tick == 40) {
					player.refreshPositionAndAngles(player.getX() + vel.x, player.getY() - 0.04D, player.getZ() + vel.z, player.getYaw(), player.getPitch());
				} else if (tick == 41) {
					player.refreshPositionAndAngles(player.getX() + vel.x, player.getY() + 0.04D, player.getZ() + vel.z, player.getYaw(), player.getPitch());
				} else if (tick == 80) {
					tick = 0;
				}
            } else {
				player.getAbilities().flying = false;
			}
		}
	}
}
