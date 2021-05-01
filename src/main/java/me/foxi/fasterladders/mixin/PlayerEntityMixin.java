package me.foxi.fasterladders.mixin;

import me.foxi.fasterladders.util.PlayerUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Inject(method = "tickMovement", at = @At("TAIL"))
    private void move(CallbackInfo unused) {
        PlayerEntity player = (PlayerEntity)(Object) this;
        if (player.isClimbing() && !player.isSneaking() && PlayerUtil.isFacingUp(player) &&
                PlayerUtil.isMovingForward(player)) {
            float f1 = (float)Math.abs(player.pitch / 90.0) * 0.4f;
            Vec3d m1 = new Vec3d(0, f1, 0);
            player.move(MovementType.SELF, m1);
        }
        if (player.isClimbing() && !player.isSneaking() && PlayerUtil.isFacingDown(player) &&
                !PlayerUtil.isMovingForward(player) && !PlayerUtil.isMovingBackward(player)) {
            float f2 = (float)Math.abs(player.pitch / 90.0) * 0.4f;
            Vec3d m2 = new Vec3d(0, (f2 * -1), 0);
            player.move(MovementType.SELF, m2);
        }
    }
}
