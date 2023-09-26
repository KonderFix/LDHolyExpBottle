package me.leddev.holyexpbottle;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {

    public static Plugin instance;

    private FileConfiguration config = this.getConfig();

    public static Plugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new BukkitListener(this), this);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("ldholyexpbottle")
                && args.length >= 1 && sender.hasPermission("ldholyexpbottle.admin")) {
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                reloadConfig();
                sender.sendMessage(HexUtil.translate(this.getConfig().getString("messages.reload-config")));
                return true;

            } else if (command.getName().equalsIgnoreCase("ldholyexpbottle")
                    && args.length >= 3 && sender.hasPermission("ldholyexpbottle.admin")
                    && args.length >= 3 && args[0].equalsIgnoreCase("give")) {
                String playerName = args[1];
                String itemType = args[2];

                Player player = getServer().getPlayer(playerName);

                if (player != null) {
                    ItemStack itemStack = null;

                    if (itemType.equalsIgnoreCase("bottle_one")) {
                        itemStack = new ItemStack(Material.EXPERIENCE_BOTTLE);
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        itemMeta.setDisplayName(HexUtil.translate(this.getConfig().getString("item_bottle_one.name")));
                        itemMeta.addEnchant(Enchantment.OXYGEN, 1, true);
                        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                        itemMeta.getPersistentDataContainer().set(
                                NamespacedKey.fromString("bottle_one"),
                                PersistentDataType.STRING, "one"
                        );

                        List<String> lore = this.getConfig().getStringList("item_bottle_one.lore");
                        List<String> translatedLore = new ArrayList<>();
                        for (String line : lore) {
                            String translatedLine = HexUtil.translate(line);
                            translatedLore.add(translatedLine);
                        }
                        itemMeta.setLore(translatedLore);

                        itemStack.setItemMeta(itemMeta);
                    } else if (itemType.equalsIgnoreCase("bottle_two")) {
                        itemStack = new ItemStack(Material.EXPERIENCE_BOTTLE);
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        itemMeta.setDisplayName(HexUtil.translate(this.getConfig().getString("item_bottle_two.name")));
                        itemMeta.addEnchant(Enchantment.OXYGEN, 1, true);
                        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                        itemMeta.getPersistentDataContainer().set(
                                NamespacedKey.fromString("bottle_two"),
                                PersistentDataType.STRING, "two"
                        );

                        List<String> lore = this.getConfig().getStringList("item_bottle_two.lore");
                        List<String> translatedLore = new ArrayList<>();
                        for (String line : lore) {
                            String translatedLine = HexUtil.translate(line);
                            translatedLore.add(translatedLine);
                        }
                        itemMeta.setLore(translatedLore);

                        itemStack.setItemMeta(itemMeta);
                    } else if (itemType.equalsIgnoreCase("bottle_three")) {
                        itemStack = new ItemStack(Material.EXPERIENCE_BOTTLE);
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        itemMeta.setDisplayName(HexUtil.translate(this.getConfig().getString("item_bottle_three.name")));
                        itemMeta.addEnchant(Enchantment.OXYGEN, 1, true);
                        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                        itemMeta.getPersistentDataContainer().set(
                                NamespacedKey.fromString("bottle_three"),
                                PersistentDataType.STRING, "three"
                        );

                        List<String> lore = this.getConfig().getStringList("item_bottle_three.lore");
                        List<String> translatedLore = new ArrayList<>();
                        for (String line : lore) {
                            String translatedLine = HexUtil.translate(line);
                            translatedLore.add(translatedLine);
                        }
                        itemMeta.setLore(translatedLore);

                        itemStack.setItemMeta(itemMeta);
                    }

                    if (itemStack != null) {
                        player.getInventory().addItem(itemStack);
                        sender.sendMessage(HexUtil.translate(this.getConfig().getString("messages.give-bottle")));
                        return true;
                    } else {
                        sender.sendMessage(HexUtil.translate(this.getConfig().getString("messages.no_bottle")));
                    }
                } else {
                    FileConfiguration config = this.getConfig();
                    String message = HexUtil.translate(config.getString("messages.no_player"))
                            .replace("{player}", playerName);
                    sender.sendMessage(message);
                }
            }

            return true;
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("ldholyexpbottle") && sender.hasPermission("ldholyexpbottle.tab")) {
            if (args.length == 1) {
                List<String> completions = new ArrayList<>();
                completions.add("give");
                completions.add("reload");
                return completions;
            } else if (args.length == 3 && args[0].equalsIgnoreCase("give")
                    && sender.hasPermission("ldholyexpbottle.tab")) {
                List<String> completions = new ArrayList<>();
                completions.add("bottle_one");
                completions.add("bottle_two");
                completions.add("bottle_three");
                return completions;
            }
        }
        return null;
    }
}