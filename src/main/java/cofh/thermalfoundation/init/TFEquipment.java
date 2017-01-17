package cofh.thermalfoundation.init;

import cofh.api.core.IModelRegister;
import cofh.core.item.ItemArmorAdv;
import cofh.core.item.tool.*;
import cofh.lib.util.helpers.StringHelper;
import cofh.thermalfoundation.ThermalFoundation;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Locale;

import static cofh.lib.util.helpers.ItemHelper.ShapedRecipe;
import static cofh.lib.util.helpers.ItemHelper.addRecipe;

public class TFEquipment {

	private TFEquipment() {

	}

	public static boolean preInit() {

		for (ArmorSet e : ArmorSet.values()) {
			e.preInit();
			ThermalFoundation.proxy.addIModelRegister(e);
		}
		for (ToolSet e : ToolSet.values()) {
			e.preInit();
			ThermalFoundation.proxy.addIModelRegister(e);
		}
		for (ToolSetVanilla e : ToolSetVanilla.values()) {
			e.preInit();
			ThermalFoundation.proxy.addIModelRegister(e);
		}
		return true;
	}

	public static boolean initialize() {

		return true;
	}

	public static boolean postInit() {

		for (ArmorSet e : ArmorSet.values()) {
			e.postInit();
		}
		for (ToolSet e : ToolSet.values()) {
			e.postInit();
		}
		for (ToolSetVanilla e : ToolSetVanilla.values()) {
			e.postInit();
		}
		return true;
	}

	/* MATERIALS */
	public static final ArmorMaterial ARMOR_MATERIAL_COPPER = EnumHelper.addArmorMaterial("TF:COPPER", "copper_armor", 6, new int[] { 1, 3, 3, 1 }, 6, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0F);
	public static final ArmorMaterial ARMOR_MATERIAL_TIN = EnumHelper.addArmorMaterial("TF:TIN", "tin_armor", 8, new int[] { 1, 4, 3, 1 }, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0F);
	public static final ArmorMaterial ARMOR_MATERIAL_SILVER = EnumHelper.addArmorMaterial("TF:SILVER", "silver_armor", 11, new int[] { 2, 4, 4, 1 }, 20, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0F);
	public static final ArmorMaterial ARMOR_MATERIAL_LEAD = EnumHelper.addArmorMaterial("TF:LEAD", "lead_armor", 15, new int[] { 2, 5, 4, 3 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0F);
	public static final ArmorMaterial ARMOR_MATERIAL_NICKEL = EnumHelper.addArmorMaterial("TF:NICKEL", "nickel_armor", 15, new int[] { 2, 5, 5, 2 }, 18, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0F);
	public static final ArmorMaterial ARMOR_MATERIAL_ELECTRUM = EnumHelper.addArmorMaterial("TF:ELECTRUM", "electrum_armor", 8, new int[] { 2, 4, 4, 2 }, 30, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0F);
	public static final ArmorMaterial ARMOR_MATERIAL_INVAR = EnumHelper.addArmorMaterial("TF:INVAR", "invar_armor", 21, new int[] { 2, 7, 5, 2 }, 16, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1F);
	public static final ArmorMaterial ARMOR_MATERIAL_BRONZE = EnumHelper.addArmorMaterial("TF:BRONZE", "bronze_armor", 18, new int[] { 3, 6, 6, 2 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1F);
	public static final ArmorMaterial ARMOR_MATERIAL_PLATINUM = EnumHelper.addArmorMaterial("TF:PLATINUM", "platinum_armor", 40, new int[] { 3, 8, 6, 3 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2F);

	public static final ToolMaterial TOOL_MATERIAL_COPPER = EnumHelper.addToolMaterial("TF:COPPER", 1, 175, 4.0F, 0.75F, 6);
	public static final ToolMaterial TOOL_MATERIAL_TIN = EnumHelper.addToolMaterial("TF:TIN", 1, 200, 4.5F, 1.0F, 7);
	public static final ToolMaterial TOOL_MATERIAL_SILVER = EnumHelper.addToolMaterial("TF:SILVER", 2, 200, 6.0F, 1.5F, 20);
	public static final ToolMaterial TOOL_MATERIAL_LEAD = EnumHelper.addToolMaterial("TF:LEAD", 1, 150, 5.0F, 1.0F, 9);
	public static final ToolMaterial TOOL_MATERIAL_NICKEL = EnumHelper.addToolMaterial("TF:NICKEL", 2, 300, 6.5F, 2.5F, 18);
	public static final ToolMaterial TOOL_MATERIAL_ELECTRUM = EnumHelper.addToolMaterial("TF:ELECTRUM", 0, 100, 14.0F, 0.5F, 30);
	public static final ToolMaterial TOOL_MATERIAL_INVAR = EnumHelper.addToolMaterial("TF:INVAR", 2, 450, 7.0F, 3.0F, 16);
	public static final ToolMaterial TOOL_MATERIAL_BRONZE = EnumHelper.addToolMaterial("TF:BRONZE", 2, 500, 6.0F, 2.0F, 15);
	public static final ToolMaterial TOOL_MATERIAL_PLATINUM = EnumHelper.addToolMaterial("TF:PLATINUM", 4, 1700, 9.0F, 4.0F, 9);

	/* ARMOR */
	public enum ArmorSet implements IModelRegister {

		// @formatter:off
		COPPER("copper", ARMOR_MATERIAL_COPPER, "ingotCopper"),
		TIN("tin", ARMOR_MATERIAL_TIN, "ingotTin"),
		SILVER("silver", ARMOR_MATERIAL_SILVER, "ingotSilver"),
		LEAD("lead", ARMOR_MATERIAL_LEAD, "ingotLead"),
		NICKEL("nickel", ARMOR_MATERIAL_NICKEL, "ingotNickel"),
		ELECTRUM("electrum", ARMOR_MATERIAL_ELECTRUM, "ingotElectrum"),
		INVAR("invar", ARMOR_MATERIAL_INVAR, "ingotInvar"),
		BRONZE("bronze", ARMOR_MATERIAL_BRONZE, "ingotBronze"),
		PLATINUM("platinum", ARMOR_MATERIAL_PLATINUM, "ingotPlatinum");
		// @formatter: on

		private final String name;
		private final String ingot;
		private final ArmorMaterial ARMOR_MATERIAL;

		public ItemArmorAdv itemHelmet;
		public ItemArmorAdv itemPlate;
		public ItemArmorAdv itemLegs;
		public ItemArmorAdv itemBoots;

		public ItemStack armorHelmet;
		public ItemStack armorPlate;
		public ItemStack armorLegs;
		public ItemStack armorBoots;

		public boolean[] enable = new boolean[4];

		ArmorSet(String name, ArmorMaterial material, String ingot) {

			this.name = name.toLowerCase(Locale.US);
			this.ingot = ingot;
			ARMOR_MATERIAL = material;
		}

		protected void create() {

			itemHelmet = new ItemArmorAdv(ARMOR_MATERIAL, EntityEquipmentSlot.HEAD);
			itemPlate = new ItemArmorAdv(ARMOR_MATERIAL, EntityEquipmentSlot.CHEST);
			itemLegs = new ItemArmorAdv(ARMOR_MATERIAL, EntityEquipmentSlot.LEGS);
			itemBoots = new ItemArmorAdv(ARMOR_MATERIAL, EntityEquipmentSlot.FEET);
		}

		protected void preInit() {

			final String ARMOR = "thermalfoundation.armor." + name;
			final String PATH_ARMOR = "thermalfoundation:textures/armor/";
			final String[] TEXTURE = { PATH_ARMOR + name + "_1.png", PATH_ARMOR + name + "_2.png" };

			String category = "Equipment.Armor." + StringHelper.titleCase(name);

			enable[0] = ThermalFoundation.CONFIG.getConfiguration().get(category, "Helmet", true).getBoolean(true);
			enable[1] = ThermalFoundation.CONFIG.getConfiguration().get(category, "Chestplate", true).getBoolean(true);
			enable[2] = ThermalFoundation.CONFIG.getConfiguration().get(category, "Leggings", true).getBoolean(true);
			enable[3] = ThermalFoundation.CONFIG.getConfiguration().get(category, "Boots", true).getBoolean(true);

			for (int i = 0; i < enable.length; i++) {
				enable[i] &= !TFProps.disableAllArmor;
			}
			create();

			/* HELMET */
			itemHelmet.setArmorTextures(TEXTURE).setUnlocalizedName(ARMOR + "Helmet").setCreativeTab(ThermalFoundation.tabArmor);
			itemHelmet.setShowInCreative(enable[0]);
			itemHelmet.setRegistryName("armor.helmet_" + name);
			GameRegistry.register(itemHelmet);

			/* PLATE */
			itemPlate.setArmorTextures(TEXTURE).setUnlocalizedName(ARMOR + "Plate").setCreativeTab(ThermalFoundation.tabArmor);
			itemPlate.setShowInCreative(enable[1]);
			itemPlate.setRegistryName("armor.plate_" + name);
			GameRegistry.register(itemPlate);

			/* LEGS */
			itemLegs.setArmorTextures(TEXTURE).setUnlocalizedName(ARMOR + "Legs").setCreativeTab(ThermalFoundation.tabArmor);
			itemLegs.setShowInCreative(enable[2]);
			itemLegs.setRegistryName("armor.legs_" + name);
			GameRegistry.register(itemLegs);

			/* BOOTS */
			itemBoots.setArmorTextures(TEXTURE).setUnlocalizedName(ARMOR + "Boots").setCreativeTab(ThermalFoundation.tabArmor);
			itemBoots.setShowInCreative(enable[3]);
			itemBoots.setRegistryName("armor.boots_" + name);
			GameRegistry.register(itemBoots);

			/* REFERENCES */
			armorHelmet = new ItemStack(itemHelmet);
			armorPlate = new ItemStack(itemPlate);
			armorLegs = new ItemStack(itemLegs);
			armorBoots = new ItemStack(itemBoots);
		}

		protected void postInit() {

			if (enable[0]) {
				addRecipe(ShapedRecipe(armorHelmet, "III", "I I", 'I', ingot));
			}
			if (enable[1]) {
				addRecipe(ShapedRecipe(armorPlate, "I I", "III", "III", 'I', ingot));
			}
			if (enable[2]) {
				addRecipe(ShapedRecipe(armorLegs, "III", "I I", "I I", 'I', ingot));
			}
			if (enable[3]) {
				addRecipe(ShapedRecipe(armorBoots, "I I", "I I", 'I', ingot));
			}
		}

		/* HELPERS */
		@SideOnly (Side.CLIENT)
		public void registerModel(Item item, String stackName) {

			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(ThermalFoundation.MOD_ID + ":armor/" + name + "/" + stackName, "inventory"));
		}

		/* IModelRegister */
		@Override
		@SideOnly (Side.CLIENT)
		public void registerModels() {

			registerModel(itemHelmet, name + "_helmet");
			registerModel(itemPlate, name + "_chestplate");
			registerModel(itemLegs, name + "_leggings");
			registerModel(itemBoots, name + "_boots");
		}
	}

	/* TOOLS */
	public enum ToolSet implements IModelRegister {

		// @formatter:off
		COPPER("copper", TOOL_MATERIAL_COPPER, "ingotCopper"),
		TIN("tin", TOOL_MATERIAL_TIN, "ingotTin"),
		SILVER("silver", TOOL_MATERIAL_SILVER, "ingotSilver"),
		LEAD("lead", TOOL_MATERIAL_LEAD, "ingotLead"),
		NICKEL("nickel", TOOL_MATERIAL_NICKEL, "ingotNickel"),
		ELECTRUM("electrum", TOOL_MATERIAL_ELECTRUM, "ingotElectrum"),
		INVAR("invar",TOOL_MATERIAL_INVAR, "ingotInvar"),
		BRONZE("bronze", TOOL_MATERIAL_BRONZE, "ingotBronze"),
		PLATINUM("platinum", TOOL_MATERIAL_PLATINUM, "ingotPlatinum");
		// @formatter: on

		private final String name;
		private final String ingot;
		private final ToolMaterial TOOL_MATERIAL;

		/* BOW */
		private float arrowDamage = 1.5F;
		private float arrowSpeed = 3.0F;

		/* FISHING ROD */
		private int luckModifier = 1;
		private int speedModifier = 1;

		/* TOOLS */
		public ItemSwordAdv itemSword;
		public ItemShovelAdv itemShovel;
		public ItemPickaxeAdv itemPickaxe;
		public ItemAxeAdv itemAxe;
		public ItemHoeAdv itemHoe;
		public ItemBowAdv itemBow;
		public ItemFishingRodAdv itemFishingRod;
		public ItemShearsAdv itemShears;
		public ItemSickleAdv itemSickle;
		public ItemHammerAdv itemHammer;
		public ItemShieldAdv itemShield;

		public ItemStack toolSword;
		public ItemStack toolShovel;
		public ItemStack toolPickaxe;
		public ItemStack toolAxe;
		public ItemStack toolHoe;
		public ItemStack toolBow;
		public ItemStack toolFishingRod;
		public ItemStack toolShears;
		public ItemStack toolSickle;
		public ItemStack toolHammer;
		public ItemStack toolShield;

		public boolean[] enable = new boolean[11];

		ToolSet(String name, ToolMaterial material, String ingot) {

			this.name = name.toLowerCase(Locale.US);
			this.ingot = ingot;
			TOOL_MATERIAL = material;
		}

		protected void create() {

			itemSword = new ItemSwordAdv(TOOL_MATERIAL);
			itemShovel = new ItemShovelAdv(TOOL_MATERIAL);
			itemPickaxe = new ItemPickaxeAdv(TOOL_MATERIAL);
			itemAxe = new ItemAxeAdv(TOOL_MATERIAL);
			itemHoe = new ItemHoeAdv(TOOL_MATERIAL);
			itemBow = new ItemBowAdv(TOOL_MATERIAL);
			itemFishingRod = new ItemFishingRodAdv(TOOL_MATERIAL);
			itemShears = new ItemShearsAdv(TOOL_MATERIAL);
			itemSickle = new ItemSickleAdv(TOOL_MATERIAL);
			itemHammer = new ItemHammerAdv(TOOL_MATERIAL);
			itemShield = new ItemShieldAdv(TOOL_MATERIAL);
		}

		protected void preInit() {

			final String TOOL = "thermalfoundation.tool." + name;

			String category = "Equipment.Tool." + StringHelper.titleCase(name);

			enable[0] = ThermalFoundation.CONFIG.getConfiguration().get(category, "Wrench", true).getBoolean(true);
			enable[1] = ThermalFoundation.CONFIG.getConfiguration().get(category, "BattleWrench", true).getBoolean(true);
			enable[2] = ThermalFoundation.CONFIG.getConfiguration().get(category, "Sword", true).getBoolean(true);
			enable[3] = ThermalFoundation.CONFIG.getConfiguration().get(category, "Shovel", true).getBoolean(true);
			enable[4] = ThermalFoundation.CONFIG.getConfiguration().get(category, "Pickaxe", true).getBoolean(true);
			enable[5] = ThermalFoundation.CONFIG.getConfiguration().get(category, "Axe", true).getBoolean(true);
			enable[6] = ThermalFoundation.CONFIG.getConfiguration().get(category, "Bow", true).getBoolean(true);
			enable[7] = ThermalFoundation.CONFIG.getConfiguration().get(category, "FishingRod", true).getBoolean(true);
			enable[8] = ThermalFoundation.CONFIG.getConfiguration().get(category, "Sickle", true).getBoolean(true);

			// TODO: Add Hammer/Shield
			// enable[9] = ThermalFoundation.CONFIG.getConfiguration().get(category, "Hammer", true).getBoolean(true);
			// enable[10] = ThermalFoundation.CONFIG.getConfiguration().get(category, "Shield", true).getBoolean(true);

			enable[9] = false;
			enable[10] = false;

			for (int i = 0; i < enable.length; i++) {
				enable[i] &= !TFProps.disableAllTools;
			}
			create();

			/* SWORD */
			itemSword.setUnlocalizedName(TOOL + "Sword").setCreativeTab(ThermalFoundation.tabTools);
			itemSword.setShowInCreative(enable[0] | TFProps.showDisabledEquipment);
			itemSword.setRegistryName("tool.sword_" + name);
			GameRegistry.register(itemSword);

			/* SHOVEL */
			itemShovel.setUnlocalizedName(TOOL + "Shovel").setCreativeTab(ThermalFoundation.tabTools);
			itemShovel.setShowInCreative(enable[1] | TFProps.showDisabledEquipment);
			itemShovel.setRegistryName("tool.shovel_" + name);
			GameRegistry.register(itemShovel);

			/* PICKAXE */
			itemPickaxe.setUnlocalizedName(TOOL + "Pickaxe").setCreativeTab(ThermalFoundation.tabTools);
			itemPickaxe.setShowInCreative(enable[2] | TFProps.showDisabledEquipment);
			itemPickaxe.setRegistryName("tool.pickaxe_" + name);
			GameRegistry.register(itemPickaxe);

			/* AXE */
			itemAxe.setUnlocalizedName(TOOL + "Axe").setCreativeTab(ThermalFoundation.tabTools);
			itemAxe.setShowInCreative(enable[3] | TFProps.showDisabledEquipment);
			itemAxe.setRegistryName("tool.axe_" + name);
			GameRegistry.register(itemAxe);

			/* HOE */
			itemHoe.setRepairIngot(ingot).setUnlocalizedName(TOOL + "Hoe").setCreativeTab(ThermalFoundation.tabTools);
			itemHoe.setShowInCreative(enable[4] | TFProps.showDisabledEquipment);
			itemHoe.setRegistryName("tool.hoe_" + name);
			GameRegistry.register(itemHoe);

			/* BOW */
			itemBow.setUnlocalizedName(TOOL + "Bow").setCreativeTab(ThermalFoundation.tabTools);
			itemBow.setArrowDamage(arrowDamage).setArrowSpeed(arrowSpeed);
			itemBow.setShowInCreative(enable[5] | TFProps.showDisabledEquipment);
			itemBow.setRegistryName("tool.bow_" + name);
			GameRegistry.register(itemBow);

			/* FISHING ROD */
			itemFishingRod.setUnlocalizedName(TOOL + "FishingRod").setCreativeTab(ThermalFoundation.tabTools);
			itemFishingRod.setLuckModifier(luckModifier).setSpeedModifier(speedModifier);
			itemFishingRod.setShowInCreative(enable[6]);
			itemFishingRod.setRegistryName("tool.fishing_rod_" + name);
			GameRegistry.register(itemFishingRod);

			/* SHEARS */
			itemShears.setRepairIngot(ingot).setUnlocalizedName(TOOL + "Shears").setCreativeTab(ThermalFoundation.tabTools);
			itemShears.setShowInCreative(enable[7] | TFProps.showDisabledEquipment);
			itemShears.setRegistryName("tool.shears_" + name);
			GameRegistry.register(itemShears);

			/* SICKLE */
			itemSickle.setUnlocalizedName(TOOL + "Sickle").setCreativeTab(ThermalFoundation.tabTools);
			itemSickle.setShowInCreative(enable[8] | TFProps.showDisabledEquipment);
			itemSickle.setRegistryName("tool.sickle_" + name);
			GameRegistry.register(itemSickle);

			/* HAMMER */
			itemHammer.setUnlocalizedName(TOOL + "Hammer").setCreativeTab(ThermalFoundation.tabTools);
			itemHammer.setShowInCreative(enable[9]); //| TFProps.showDisabledEquipment);
			itemHammer.setRegistryName("tool.hammer_" + name);
			GameRegistry.register(itemHammer);

			/* SHIELD */
			itemShield.setUnlocalizedName(TOOL + "Shield").setCreativeTab(ThermalFoundation.tabTools);
			itemShield.setShowInCreative(enable[10]); //| TFProps.showDisabledEquipment);
			itemShield.setRegistryName("tool.shield_" + name);
			GameRegistry.register(itemShield);


			/* REFERENCES */
			toolSword = new ItemStack(itemSword);
			toolShovel = new ItemStack(itemShovel);
			toolPickaxe = new ItemStack(itemPickaxe);
			toolAxe = new ItemStack(itemAxe);
			toolHoe = new ItemStack(itemHoe);
			toolBow = new ItemStack(itemBow);
			toolFishingRod = new ItemStack(itemFishingRod);
			toolShears = new ItemStack(itemShears);
			toolSickle = new ItemStack(itemSickle);
			toolHammer = new ItemStack(itemHammer);
			toolShield = new ItemStack(itemShield);
		}

		protected void postInit() {

			if (enable[0]) {
				GameRegistry.addRecipe(ShapedRecipe(toolSword, "I", "I", "S", 'I', ingot, 'S', "stickWood"));
			}
			if (enable[1]) {
				GameRegistry.addRecipe(ShapedRecipe(toolShovel, "I", "S", "S", 'I', ingot, 'S', "stickWood"));
			}
			if (enable[2]) {
				GameRegistry.addRecipe(ShapedRecipe(toolPickaxe, "III", " S ", " S ", 'I', ingot, 'S', "stickWood"));
			}
			if (enable[3]) {
				GameRegistry.addRecipe(ShapedRecipe(toolAxe, "II", "IS", " S", 'I', ingot, 'S', "stickWood"));
			}
			if (enable[4]) {
				GameRegistry.addRecipe(ShapedRecipe(toolHoe, "II", " S", " S", 'I', ingot, 'S', "stickWood"));
			}
			if (enable[5]) {
				GameRegistry.addRecipe(ShapedRecipe(toolBow, " I#", "S #", " I#", 'I', ingot, 'S', "stickWood", '#', Items.STRING));
			}
			if (enable[6]) {
				GameRegistry.addRecipe(ShapedRecipe(toolFishingRod, "  I", " I#", "S #", 'I', ingot, 'S', "stickWood", '#', Items.STRING));
			}
			if (enable[7]) {
				GameRegistry.addRecipe(ShapedRecipe(toolShears, " I", "I ", 'I', ingot));
			}
			if (enable[8]) {
				GameRegistry.addRecipe(ShapedRecipe(toolSickle, " I ", "  I", "SI ", 'I', ingot, 'S', "stickWood"));
			}
			if (enable[9]) {
				GameRegistry.addRecipe(ShapedRecipe(toolHammer, "III", "ISI", " S ", 'I', ingot, 'S', "stickWood"));
			}
			if (enable[10]) {
				GameRegistry.addRecipe(ShapedRecipe(toolHammer, "III", "ISI", " S ", 'I', ingot, 'S', "stickWood"));
			}
		}

		/* HELPERS */
		@SideOnly (Side.CLIENT)
		public void registerModel(Item item, String stackName) {

			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(ThermalFoundation.MOD_ID + ":tool/" + name + "/" + stackName, "inventory"));
		}

		/* IModelRegister */
		@Override
		@SideOnly (Side.CLIENT)
		public void registerModels() {

			registerModel(itemSword, name + "_sword");
			registerModel(itemShovel, name + "_shovel");
			registerModel(itemPickaxe, name + "_pickaxe");
			registerModel(itemAxe, name + "_axe");
			registerModel(itemHoe, name + "_hoe");
			registerModel(itemBow, name + "_bow");
			registerModel(itemFishingRod, name + "_fishing_rod");
			registerModel(itemShears, name + "_shears");
			registerModel(itemSickle, name + "_sickle");
			registerModel(itemHammer, name + "_hammer");
			registerModel(itemShield, name + "_shield");
		}
	}

	/* VANILLA */
	public enum ToolSetVanilla implements IModelRegister {

		// @formatter:off
    	WOOD("wood", ToolMaterial.WOOD, "plankWood") {

    		@Override
    		protected void create() {

    			itemBow = Items.BOW;
    			itemFishingRod = Items.FISHING_ROD;
				itemShears = new ItemShearsAdv(TOOL_MATERIAL);
    			itemSickle = new ItemSickleAdv(TOOL_MATERIAL);
    			itemHammer = new ItemHammerAdv(TOOL_MATERIAL);
    			itemShield = Items.SHIELD;
    		}
    	},
    	STONE("stone", ToolMaterial.STONE, "cobblestone"),
    	IRON("iron", ToolMaterial.IRON, "ingotIron") {

    		@Override
    		protected void create() {

				itemBow = new ItemBowAdv(TOOL_MATERIAL);
    			itemFishingRod = new ItemFishingRodAdv(TOOL_MATERIAL);
				itemShears = Items.SHEARS;
    			itemSickle = new ItemSickleAdv(TOOL_MATERIAL);
				itemHammer = new ItemHammerAdv(TOOL_MATERIAL);
				itemShield = new ItemShieldAdv(TOOL_MATERIAL);

    		}
    	},
    	DIAMOND("diamond", ToolMaterial.DIAMOND, "gemDiamond"),
    	GOLD("gold", ToolMaterial.GOLD, "ingotGold");
		// @formatter:on

		private final String name;
		private final String ingot;
		public final ToolMaterial TOOL_MATERIAL;

		/* BOW */
		private float arrowSpeed = 1.0F;
		private float arrowDamage = 1.0F;

		/* FISHING ROD */
		private int luckModifier = 0;
		private int speedModifier = 0;

		/* TOOLS */
		public ItemBow itemBow;
		public ItemFishingRod itemFishingRod;
		public ItemShears itemShears;
		public ItemSickleAdv itemSickle;
		public ItemHammerAdv itemHammer;
		public Item itemShield;

		public ItemStack toolBow;
		public ItemStack toolFishingRod;
		public ItemStack toolShears;
		public ItemStack toolSickle;
		public ItemStack toolHammer;
		public ItemStack toolShield;

		public boolean[] enable = new boolean[6];

		ToolSetVanilla(String name, ToolMaterial material, String ingot) {

			this.name = name;
			this.ingot = ingot;
			TOOL_MATERIAL = material;

			/* BOW */
			arrowDamage = 1.0F + TOOL_MATERIAL.getDamageVsEntity() / 8F;
			// arrowSpeed = 2.0F + speed / 8F;

			/* FISHING ROD */
			luckModifier = TOOL_MATERIAL.getHarvestLevel() / 2;
			speedModifier = (int) (TOOL_MATERIAL.getEfficiencyOnProperMaterial() / 5);
		}

		protected void create() {

			itemBow = new ItemBowAdv(TOOL_MATERIAL);
			itemFishingRod = new ItemFishingRodAdv(TOOL_MATERIAL);
			itemShears = new ItemShearsAdv(TOOL_MATERIAL);
			itemSickle = new ItemSickleAdv(TOOL_MATERIAL);
			itemHammer = new ItemHammerAdv(TOOL_MATERIAL);
			itemShield = new ItemShieldAdv(TOOL_MATERIAL);
		}

		protected void preInit() {

			final String TOOL = "thermalfoundation.tool." + name;

			String category = "Equipment.Tool." + StringHelper.titleCase(name);

			if (this != WOOD) {
				enable[0] = ThermalFoundation.CONFIG.getConfiguration().get(category, "Bow", true).getBoolean(true);
				enable[1] = ThermalFoundation.CONFIG.getConfiguration().get(category, "FishingRod", true).getBoolean(true);
			}
			if (this != IRON) {
				enable[2] = ThermalFoundation.CONFIG.getConfiguration().get(category, "Shears", true).getBoolean(true);
			}
			enable[3] = ThermalFoundation.CONFIG.getConfiguration().get(category, "Sickle", true).getBoolean(true);

			// TODO: Add Hammer/Shield
			// enable[4] = ThermalFoundation.CONFIG.getConfiguration().get(category, "Hammer", true).getBoolean(true);

			// if (this != WOOD) {
			// enable[5] = ThermalFoundation.CONFIG.getConfiguration().get(category, "Shield", true).getBoolean(true);
			// }
			enable[4] = false;
			enable[5] = false;

			for (int i = 0; i < enable.length; i++) {
				enable[i] &= !TFProps.disableAllTools;
			}
			create();

			/* BOW */
			if (itemBow instanceof ItemBowAdv) {
				ItemBowAdv itemBow = (ItemBowAdv) this.itemBow;
				itemBow.setRepairIngot(ingot).setArrowSpeed(arrowSpeed).setArrowDamage(arrowDamage).setUnlocalizedName(TOOL + "Bow").setCreativeTab(ThermalFoundation.tabTools);
				itemBow.setShowInCreative(enable[0] | TFProps.showDisabledEquipment);
				itemBow.setRegistryName("tool.bow_" + name);
				GameRegistry.register(itemBow);
			}

			/* FISHING ROD */
			if (itemFishingRod instanceof ItemFishingRodAdv) {
				ItemFishingRodAdv itemFishingRod = (ItemFishingRodAdv) this.itemFishingRod;
				itemFishingRod.setRepairIngot(ingot).setUnlocalizedName(TOOL + "FishingRod").setCreativeTab(ThermalFoundation.tabTools);
				itemFishingRod.setLuckModifier(luckModifier).setSpeedModifier(speedModifier);
				itemFishingRod.setShowInCreative(enable[1] | TFProps.showDisabledEquipment);
				itemFishingRod.setRegistryName("tool.fishing_rod_" + name);
				GameRegistry.register(itemFishingRod);
			}

			/* SHEARS */
			if (itemShears instanceof ItemShearsAdv) {
				ItemShearsAdv itemShears = (ItemShearsAdv) this.itemShears;
				itemShears.setRepairIngot(ingot).setUnlocalizedName(TOOL + "Shears").setCreativeTab(ThermalFoundation.tabTools);
				itemShears.setShowInCreative(enable[2] | TFProps.showDisabledEquipment);
				itemShears.setRegistryName("tool.shears_" + name);
				GameRegistry.register(itemShears);
			}

			/* SICKLE */
			itemSickle.setRepairIngot(ingot).setUnlocalizedName(TOOL + "Sickle").setCreativeTab(ThermalFoundation.tabTools);
			itemSickle.setShowInCreative(enable[3] | TFProps.showDisabledEquipment);
			itemSickle.setRegistryName("tool.sickle_" + name);
			GameRegistry.register(itemSickle);

			/* HAMMER */
			itemHammer.setRepairIngot(ingot).setUnlocalizedName(TOOL + "Hammer").setCreativeTab(ThermalFoundation.tabTools);
			itemHammer.setShowInCreative(enable[4]); //| TFProps.showDisabledEquipment);
			itemHammer.setRegistryName("tool.hammer_" + name);
			GameRegistry.register(itemHammer);

			/* SHIELD */
			if (itemShield instanceof ItemShieldAdv) {
				((ItemShieldAdv) itemShield).setRepairIngot(ingot).setUnlocalizedName(TOOL + "Shield").setCreativeTab(ThermalFoundation.tabTools);
				((ItemShieldAdv) itemShield).setShowInCreative(enable[5]); //| TFProps.showDisabledEquipment);
				itemShield.setRegistryName("tool.shield_" + name);
				GameRegistry.register(itemShield);
			}

			toolBow = new ItemStack(itemBow);
			toolFishingRod = new ItemStack(itemFishingRod);
			toolShears = new ItemStack(itemShears);
			toolSickle = new ItemStack(itemSickle);
			toolHammer = new ItemStack(itemHammer);
			toolShield = new ItemStack(itemShield);
		}

		protected void postInit() {

			if (enable[0]) {
				addRecipe(ShapedRecipe(toolBow, " I#", "S #", " I#", 'I', ingot, 'S', "stickWood", '#', Items.STRING));
			}
			if (enable[1]) {
				addRecipe(ShapedRecipe(toolFishingRod, "  I", " I#", "S #", 'I', ingot, 'S', "stickWood", '#', Items.STRING));
			}
			if (enable[2]) {
				addRecipe(ShapedRecipe(toolShears, " I", "I ", 'I', ingot));
			}
			if (enable[3]) {
				addRecipe(ShapedRecipe(toolSickle, " I ", "  I", "SI ", 'I', ingot, 'S', "stickWood"));
			}
			if (enable[4]) {
				addRecipe(ShapedRecipe(toolHammer, "III", "ISI", " S ", 'I', ingot, 'S', "stickWood"));
			}
			if (enable[5]) {
				addRecipe(ShapedRecipe(toolShield, "ISI", "III", " I ", 'I', ingot, 'S', "ingotIron"));
			}
		}

		/* HELPERS */
		@SideOnly (Side.CLIENT)
		public void registerModel(Item item, String stackName) {

			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(ThermalFoundation.MOD_ID + ":tool/" + name + "/" + stackName, "inventory"));
		}

		/* IModelRegister */
		@Override
		@SideOnly (Side.CLIENT)
		public void registerModels() {

			if (itemBow instanceof ItemBowAdv) {
				registerModel(itemBow, name + "_bow");
			}
			if (itemFishingRod instanceof ItemFishingRodAdv) {
				registerModel(itemFishingRod, name + "_fishing_rod");
			}
			if (itemShears instanceof ItemShearsAdv) {
				registerModel(itemShears, name + "_shears");
			}
			registerModel(itemSickle, name + "_sickle");
			registerModel(itemHammer, name + "_hammer");

			if (itemShield instanceof ItemShieldAdv) {
				registerModel(itemShield, name + "_shield");
			}
		}
	}

}
