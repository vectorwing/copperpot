package com.davigj.copperpot.core.registry;

import com.davigj.copperpot.common.items.*;
import com.davigj.copperpot.core.CopperPotMod;
import com.minecraftabnormals.abnormals_core.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import vectorwing.farmersdelight.registry.ModEffects;

@Mod.EventBusSubscriber(modid = CopperPotMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CopperPotItems {
    // TODO: Find a way to generalize these items to "single additive, double additive, single bottled additive", etc
    public static final ItemSubRegistryHelper HELPER = CopperPotMod.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> COPPER_POT = HELPER.createItem("copper_pot_block", () -> new BlockItem(
            CopperPotBlocks.COPPER_POT.get(), new Item.Properties().maxStackSize(1).group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Item> RAW_MERINGUE = HELPER.createItem("raw_meringue", () -> new Item(
            new Item.Properties().food(Foods.RAW_MERINGUE).group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> MERINGUE = HELPER.createItem("meringue", () -> new Item(
            new Item.Properties().food(Foods.MERINGUE).group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> AUTUMNAL_AGAR = HELPER.createItem("autumnal_agar", () -> new SeasonalAgar(
            new Item.Properties().food(Foods.AUTUMNAL_AGAR).group(ItemGroup.FOOD), "effect.minecraft.resistance",
            "effect.farmersdelight.nourished", "effect.minecraft.absorption", "effect.atmospheric.persistence"));

    public static final RegistryObject<Item> AESTIVAL_AGAR = HELPER.createItem("aestival_agar", () -> new SeasonalAgar(
            new Item.Properties().food(Foods.AESTIVAL_AGAR).group(ItemGroup.FOOD), "effect.minecraft.night_vision",
            "effect.atmospheric.gelled", "effect.minecraft.water_breathing", "effect.minecraft.strength"));

    public static final RegistryObject<Item> BRUMAL_AGAR = HELPER.createItem("brumal_agar", () -> new SeasonalAgar(
            new Item.Properties().food(Foods.BRUMAL_AGAR).group(ItemGroup.FOOD), "effect.farmersdelight.comfort",
            "effect.minecraft.invisibility", "effect.minecraft.fire_resistance", "effect.minecraft.slow_falling"));

    public static final RegistryObject<Item> VERNAL_AGAR = HELPER.createItem("vernal_agar", () -> new SeasonalAgar(
            new Item.Properties().food(Foods.VERNAL_AGAR).group(ItemGroup.FOOD), "effect.minecraft.regeneration",
            "effect.minecraft.jump_boost", "effect.minecraft.haste", "effect.upgrade_aquatic.vibing"));

    public static final RegistryObject<Item> BAKED_ALASKA_BLOCK = HELPER.createItem("baked_alaska_block", () -> new BlockItem(
            CopperPotBlocks.BAKED_ALASKA_BLOCK.get(), new Item.Properties().maxStackSize(1).group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> BAKED_ALASKA_SLICE = HELPER.createItem("baked_alaska_slice", () -> new BakedAlaskaSlice(
            new Item.Properties().food(Foods.BAKED_ALASKA_SLICE).group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> ADZUKI_PASTE = HELPER.createItem("adzuki_paste", () -> new AdzukiPaste(
            new Item.Properties().food(Foods.ADZUKI_PASTE).containerItem(Items.GLASS_BOTTLE).maxStackSize(16).group(ItemGroup.FOOD), "effect.neapolitan.harmony"));

    public static final RegistryObject<Item> MAPLE_BACON_FUDGE = HELPER.createItem("maple_bacon_fudge", () -> new SingleVanillaAdd(
            new Item.Properties().food(Foods.MAPLE_BACON_FUDGE).group(ItemGroup.FOOD), "effect.minecraft.resistance"));

    public static final RegistryObject<Item> PEPPERMINT_BARK_MERINGUE = HELPER.createItem("mint_meringue", () -> new MintMeringue(
            new Item.Properties().food(Foods.PEPPERMINT_BARK_MERINGUE).group(ItemGroup.FOOD), "effect.neapolitan.berserking", "effect.neapolitan.sugar_rush"));

    public static final RegistryObject<Item> SPICED_APPLE_JAM = HELPER.createItem("spiced_apple_jam", () -> new SpicedAppleJam(
            new Item.Properties().food(Foods.SPICED_APPLE_JAM).containerItem(Items.GLASS_BOTTLE).maxStackSize(16).group(ItemGroup.FOOD),
            "effect.fruitful.sustaining", "effect.abundance.supportive"));

    public static final RegistryObject<Item> PORK_SANDWICH = HELPER.createItem("pork_sandwich", () -> new PorkSandwich(
            new Item.Properties().food(Foods.PORK_SANDWICH).group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> CREEPING_YOGURT = HELPER.createItem("creeping_yogurt", () -> new CreepingYogurt(
            new Item.Properties().food(Foods.CREEPING_YOGURT).maxStackSize(16).containerItem(Items.BOWL).group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> ROYAL_JELLY = HELPER.createItem("royal_jelly", () -> new RoyalJelly(
            new Item.Properties().food(Foods.ROYAL_JELLY).group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> MOONCAKE = HELPER.createItem("mooncake", () -> new Mooncake(
            new Item.Properties().food(Foods.MOONCAKE).group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> SOURDOUGH = HELPER.createItem("sourdough", () -> new Sourdough(
            new Item.Properties().food(Foods.SOURDOUGH).group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> CARROT_CUPCAKE = HELPER.createItem("carrot_cupcake", () -> new CarrotCupcake(
            new Item.Properties().food(Foods.CARROT_CUPCAKE).group(ItemGroup.FOOD), "effect.minecraft.jump_boost"));

    public static final RegistryObject<Item> TROPICAL_MERINGUE = HELPER.createItem("tropical_meringue", () -> new TropicalMeringue(
            new Item.Properties().food(Foods.TROPICAL_MERINGUE).group(ItemGroup.FOOD), "effect.atmospheric.spitting", "effect.neapolitan.agility"));

    static class Foods {
        public static final Food RAW_MERINGUE = (new Food.Builder()).hunger(1).saturation(0.6F).fastToEat().effect(() -> new EffectInstance(Effects.HUNGER, 300), 0.6F).build();
        public static final Food MERINGUE = (new Food.Builder()).hunger(1).saturation(0.8F).fastToEat().build();
        public static final Food BAKED_ALASKA_SLICE = (new Food.Builder()).hunger(3).saturation(0.8F).fastToEat().build();
        public static final Food ADZUKI_PASTE = (new Food.Builder()).hunger(4).saturation(0.5F).setAlwaysEdible().build();
        public static final Food MAPLE_BACON_FUDGE = (new Food.Builder()).hunger(5).saturation(0.5F).effect(() -> new EffectInstance(Effects.RESISTANCE, 100, 1), 0.8F).build();
        public static final Food SPICED_APPLE_JAM = (new Food.Builder()).hunger(5).saturation(0.8F).setAlwaysEdible().build();
        public static final Food PORK_SANDWICH = (new Food.Builder()).hunger(9).saturation(0.8F).build();
        public static final Food PEPPERMINT_BARK_MERINGUE = (new Food.Builder()).hunger(2).saturation(0.5F).fastToEat().build();
        public static final Food CREEPING_YOGURT = (new Food.Builder()).hunger(5).saturation(0.6F).build();
        public static final Food SOURDOUGH = (new Food.Builder()).hunger(6).saturation(0.7F).build();
        public static final Food AUTUMNAL_AGAR = (new Food.Builder()).hunger(4).saturation(0.6F).effect(() -> new EffectInstance(
                Effects.ABSORPTION, 100), 0.2F).build();
        public static final Food AESTIVAL_AGAR = (new Food.Builder()).hunger(5).saturation(0.5F).effect(() -> new EffectInstance(
                Effects.NIGHT_VISION, 100), 0.2F).build();
        public static final Food BRUMAL_AGAR = (new Food.Builder()).hunger(3).saturation(0.7F).effect(() -> new EffectInstance(
                ModEffects.COMFORT.get(), 100), 0.2F).build();
        public static final Food VERNAL_AGAR = (new Food.Builder()).hunger(4).saturation(0.6F).effect(() -> new EffectInstance(
                Effects.REGENERATION, 100), 0.2F).build();
        public static final Food ROYAL_JELLY = (new Food.Builder()).hunger(6).saturation(0.6F).effect(() -> new EffectInstance(
                Effects.POISON, 300), 0.1F).build();
        public static final Food MOONCAKE = (new Food.Builder()).hunger(4).saturation(0.7F).effect(() -> new EffectInstance(
                Effects.POISON, 200, 1), 0.6F).build();
        public static final Food CARROT_CUPCAKE = (new Food.Builder()).hunger(4).saturation(0.6F).effect(() -> new EffectInstance(
                Effects.JUMP_BOOST, 200), 0.2F).build();
        public static final Food TROPICAL_MERINGUE = (new Food.Builder()).hunger(3).saturation(0.3F).fastToEat().build();
    }
}