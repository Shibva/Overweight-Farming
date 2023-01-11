package net.orcinus.overweightfarming.mixin;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.orcinus.overweightfarming.OFConfig;
import net.orcinus.overweightfarming.common.worldgen.AppleTreeDecorator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ConfiguredFeatures.class)
public class ConfiguredFeatureUtilMixin {
    @Inject(method = "register(Ljava/lang/String;Lnet/minecraft/world/gen/feature/Feature;Lnet/minecraft/world/gen/feature/FeatureConfig;)Lnet/minecraft/util/registry/RegistryEntry;", at = @At("HEAD"))
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(String id, F feature, FC featureConfig, CallbackInfoReturnable<RegistryEntry<ConfiguredFeature<FC, ?>>> cir) {
        if (featureConfig instanceof TreeFeatureConfig) {
            ((TreeFeatureConfig) featureConfig).decorators.add(
                    new AppleTreeDecorator( 0.0000001f * (float)(OFConfig.overweightApplePercent / 100), 0.005f * (float)(OFConfig.overweightApplePercent / 100))
            );
        }
    }
}