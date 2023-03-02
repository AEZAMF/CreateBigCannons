package rbasamoyai.createbigcannons;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rbasamoyai.createbigcannons.base.CBCRegistries;
import rbasamoyai.createbigcannons.base.PartialBlockDamageManager;
import rbasamoyai.createbigcannons.config.CBCConfigs;
import rbasamoyai.createbigcannons.crafting.BlockRecipeSerializer;
import rbasamoyai.createbigcannons.crafting.BlockRecipeType;
import rbasamoyai.createbigcannons.crafting.casting.CannonCastShape;
import rbasamoyai.createbigcannons.index.*;

public class CreateBigCannons {

	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "createbigcannons";
	
	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

	public static final PartialBlockDamageManager BLOCK_DAMAGE = new PartialBlockDamageManager();
	
	public static void init() {
		CBCRegistries.init();
		
		ModGroup.register();
		CBCBlocks.register();
		CBCItems.register();
		CBCBlockEntities.register();
		CBCEntityTypes.register();
		CBCMenuTypes.register();
		CBCFluids.register();
		CBCRecipeTypes.register(modEventBus);

		CannonCastShape.CANNON_CAST_SHAPES.register(modEventBus);
		CBCContraptionTypes.prepare();
		CBCChecks.register();
		BlockRecipeSerializer.register();
		BlockRecipeType.register();
		
		CBCParticleTypes.PARTICLE_TYPES.register(modEventBus);
		
		CBCTags.register();
		

		
		CBCConfigs.registerConfigs(mlContext);
	}
	
	public static ResourceLocation resource(String path) {
		return new ResourceLocation(MOD_ID, path);
	}
	
}