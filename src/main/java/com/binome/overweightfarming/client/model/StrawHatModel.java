package com.binome.overweightfarming.client.model;

import com.binome.overweightfarming.OverweightFarming;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

public class StrawHatModel<T extends LivingEntity> extends BipedEntityModel<T> {
    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(OverweightFarming.MODID, "strawhatmodel"), "main");
    public final ModelPart hat1;

    public StrawHatModel(ModelPart root) {
        super(root, RenderLayer::getArmorCutoutNoCull);
        hat1 = head.getChild("armorHead").getChild("hat1");
    }

    public static TexturedModelData createBodyLayer() {
        ModelData meshdefinition = BipedEntityModel.getModelData(Dilation.NONE, 0);
        ModelPartData partdefinition = meshdefinition.getRoot();
        ModelPartData head = meshdefinition.getRoot().getChild(EntityModelPartNames.HEAD);
        ModelPartData armorHead = head.addChild("armorHead", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        ModelPartData hat1 = armorHead.addChild("hat1", ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-8.0F, -4.0F, -8.0F, 16.0F, 0.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
        .uv(0, -10).cuboid(0.0F, -1.0F, 4.0F, 0.0F, 5.0F, 10.0F, new Dilation(0.0F))
        .uv(16, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.75F)), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

        return TexturedModelData.of(meshdefinition, 48, 48);
    }
}