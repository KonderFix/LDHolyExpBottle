package me.leddev.holyexpbottle;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class BukkitListener implements Listener {

    private final JavaPlugin plugin;

    public BukkitListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();

        if (event.getAction().toString().contains("RIGHT_CLICK") && itemInHand.getType() ==
                Material.EXPERIENCE_BOTTLE) {

            ItemMeta itemMeta = itemInHand.getItemMeta();
            if (itemMeta != null) {
                PersistentDataContainer container = itemMeta.getPersistentDataContainer();
                if (container.has(NamespacedKey.fromString("bottle_one"),
                        PersistentDataType.STRING)) {
                    String value = container.get(
                            NamespacedKey.fromString("bottle_one"),
                            PersistentDataType.STRING);
                    if (value != null && value.equals("one")) {
                        player.giveExp(plugin.getConfig().getInt("item_bottle_one.value"));
                        player.getInventory().getItemInMainHand().setAmount(0);
                        boolean message = plugin.getConfig().getBoolean("item_bottle_one.click-exp.enable");
                        if (message) {
                            player.sendMessage(HexUtil.translate(plugin.getConfig().getString("item_bottle_one.click-exp.message")));
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteract2(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();

        if (event.getAction().toString().contains("RIGHT_CLICK") && itemInHand.getType() ==
                Material.EXPERIENCE_BOTTLE) {

            ItemMeta itemMeta = itemInHand.getItemMeta();
            if (itemMeta != null) {
                PersistentDataContainer container = itemMeta.getPersistentDataContainer();
                if (container.has(NamespacedKey.fromString("bottle_two"),
                        PersistentDataType.STRING)) {
                    String value = container.get(
                            NamespacedKey.fromString("bottle_two"),
                            PersistentDataType.STRING);
                    if (value != null && value.equals("two")) {
                        player.giveExp(plugin.getConfig().getInt("item_bottle_two.value"));
                        ItemStack itemStack = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
                        ItemMeta itemMeta2 = itemStack.getItemMeta();
                        itemMeta2.setDisplayName(HexUtil.translate(Main.getInstance().getConfig().getString("item_bottle_two.name")));
                        itemMeta2.addEnchant(Enchantment.OXYGEN, 1, true);
                        itemMeta2.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                        itemMeta2.getPersistentDataContainer().set(
                                NamespacedKey.fromString("bottle_two"),
                                PersistentDataType.STRING, "two"
                        );

                        List<String> lore = Main.getInstance().getConfig().getStringList("item_bottle_two.lore");
                        List<String> translatedLore = new ArrayList<>();
                        for (String line : lore) {
                            String translatedLine = HexUtil.translate(line);
                            translatedLore.add(translatedLine);
                        }
                        itemMeta2.setLore(translatedLore);

                        itemStack.setItemMeta(itemMeta2);
                        player.getInventory().removeItem(itemStack);
                        boolean message = plugin.getConfig().getBoolean("item_bottle_two.click-exp.enable");
                        if (message) {
                            player.sendMessage(HexUtil.translate(plugin.getConfig().getString("item_bottle_two.click-exp.message")));
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteract3(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();

        if (event.getAction().toString().contains("RIGHT_CLICK") && itemInHand.getType() ==
                Material.EXPERIENCE_BOTTLE) {

            ItemMeta itemMeta = itemInHand.getItemMeta();
            if (itemMeta != null) {
                PersistentDataContainer container = itemMeta.getPersistentDataContainer();
                if (container.has(NamespacedKey.fromString("bottle_three"),
                        PersistentDataType.STRING)) {
                    String value = container.get(
                            NamespacedKey.fromString("bottle_three"),
                            PersistentDataType.STRING);
                    if (value != null && value.equals("three")) {
                        player.giveExp(plugin.getConfig().getInt("item_bottle_three.value"));
                        ItemStack itemStack = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
                        ItemMeta itemMeta2 = itemStack.getItemMeta();
                        itemMeta2.setDisplayName(HexUtil.translate(Main.getInstance().getConfig().getString("item_bottle_three.name")));
                        itemMeta2.addEnchant(Enchantment.OXYGEN, 1, true);
                        itemMeta2.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                        itemMeta2.getPersistentDataContainer().set(
                                NamespacedKey.fromString("bottle_three"),
                                PersistentDataType.STRING, "three"
                        );

                        List<String> lore = Main.getInstance().getConfig().getStringList("item_bottle_three.lore");
                        List<String> translatedLore = new ArrayList<>();
                        for (String line : lore) {
                            String translatedLine = HexUtil.translate(line);
                            translatedLore.add(translatedLine);
                        }
                        itemMeta2.setLore(translatedLore);

                        itemStack.setItemMeta(itemMeta2);
                        player.getInventory().removeItem(itemStack);
                        boolean message = plugin.getConfig().getBoolean("item_bottle_three.click-exp.enable");
                        if (message) {
                            player.sendMessage(HexUtil.translate(plugin.getConfig().getString("item_bottle_three.click-exp.message")));
                        }

                    }
                }
            }
        }
    }
}
