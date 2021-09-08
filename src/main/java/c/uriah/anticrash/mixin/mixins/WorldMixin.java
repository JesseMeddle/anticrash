package c.uriah.anticrash.mixin.mixins;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(World.class)
public abstract class WorldMixin {
	
    // cancel spawning entity
    @Inject(method = "spawnEntity", at = @At("HEAD"), cancellable = true)
    public void spawnEntity(Entity entityIn, CallbackInfoReturnable<Boolean> cir) {
       if(entityIn instanceof EntityFireworkRocket) {
           cir.cancel();
       } 
       if(entityIn instanceof EntityWitherSkull) {
           cir.cancel();
       }
    }

    // cancel ticking entity
	@Inject(method = "updateEntity", at = @At("HEAD"), cancellable = true)
    public void updateEntity(Entity ent, CallbackInfo ci) {
        if(ent instanceof EntityFireworkRocket) {
            ci.cancel();
        }
        if(ent instanceof EntityWitherSkull) {
            ci.cancel();
        }
    }
    
    // disable skylight
    @Inject(method = "checkLightFor", at = @At("HEAD"), cancellable = true)
    private void updateLightmapHook(EnumSkyBlock lightType, BlockPos pos, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
            if (lightType == EnumSkyBlock.SKY) {
                callbackInfoReturnable.setReturnValue(true);
                callbackInfoReturnable.cancel();
            }
    }
}
