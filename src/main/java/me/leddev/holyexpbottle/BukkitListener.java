package me.leddev.holyexpbottle;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

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
                    }
                }
            }
        }
    }
}
