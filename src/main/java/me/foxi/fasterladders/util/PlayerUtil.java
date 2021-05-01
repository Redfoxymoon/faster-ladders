package me.foxi.fasterladders.util;

import net.minecraft.entity.player.PlayerEntity;

public class PlayerUtil {

    public static boolean isMovingBackward(PlayerEntity player)
    {
        return player.forwardSpeed < 0;
    }

    public static boolean isFacingDown(PlayerEntity player)
    {
        return player.pitch > 0;
    }

    public static boolean isMovingForward(PlayerEntity player)
    {
        return player.forwardSpeed > 0;
    }

    public static boolean isFacingUp(PlayerEntity player)
    {
        return player.pitch < 0;
    }
}
