# Extras v0.1.2

### Table of Contents

- [Introduction](#introduction)
- [Installation](#installation)
- [Features](#features)
  	- [Color Translator](#color-translator)
  	- [Skull Creator](#skull-creator)
  	- [Item / Modifier Library](#item-library---modifier-library)
  	- [More Tiny Things!](#more-tiny-things)

## Introduction
****
Hello! This is just a little something I'm trying to make (as I'm learning to code) to help me in my future Spigot plugin development.

If you want to use this, you can import it by using what's below!

Please feel free to give me feed if you see something that could be done better, or if you have suggestions! My discord username is **jordqubbe**!

## Installation
****
I will just be adding Maven to the Github repo, but the rest can be found here: https://jitpack.io/#jordqubbe/Extras

The latest version can be seen here: [![](https://jitpack.io/v/jordqubbe/Extras.svg)](https://jitpack.io/#jordqubbe/Extras)
#### Repository
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

#### Dependency
```xml
<dependency>
    <groupId>com.github.jordqubbe</groupId>
    <artifactId>Extras</artifactId>
    <version>*LATEST-VERSION*</version>
</dependency>
```

## Features

### Color Translator
****
I have forked some code written by Kody Simpson that allows for quicker color code translation. 

This can be used with not only hexidecimal codes, but also all the standard minecraft color codes.

Example:
```java
Color.translate("&c&lThis is some fancy Red & Bold text!");
```

### Skull Creator
****
I did not write this code for the Skull Creator. All credit there goes to Dean B (https://github.com/deanveloper/SkullCreator/tree/master).

All you need to do is copy and paste the value at the bottom (Minecraft URL) and let the method do the work for you!
The skins (heads) can be found here: https://minecraft-heads.com/

Here is an example of it's useage:
```java
// The library I've made, simplifying the process for making these things
public static ItemStack createSkull(String name, List<String> lore, String url) {
    String prefix = "http://textures.minecraft.net/texture/";
    ItemStack item = new ItemStack(Material.PLAYER_HEAD);
    SkullMeta meta = (SkullMeta) item.getItemMeta();
    assert meta != null;
    meta.setDisplayName(Color.format(name));
    meta.setLore(lore);
    item.setItemMeta(meta);
    return SkullCreator.itemWithUrl(item, prefix + url);
}

// The actual usage
public void createSkull() {
    // Minecraft URL value
    String skullURL = "b54a09c8e36cc093e3753287a5cac4b37e5654ca518c6582ab99caa95134595e";
    List<String> lore = new ArrayList<>();
    lore.add("Skull Lore!");
    Item.createSkull("&a&lName", lore, skullURL);
}
```

### Item Library - Modifier Library
****
I have also written out some methods that make things slightly easier. It speeds up the process of making items with names and lore, along with adding Attribute Modifiers, enchantments and things like that.

This is all really for the simplicity of not crowding space when making an item. Instead of having to add everything separately with ItemMeta, it's just one line of code now.
```java
// For making new items, but refer to above for making Skulls
public static ItemStack createItem(String name, Material mat, int amount, List<String> lore) {
    ItemStack item = new ItemStack(mat, amount);
    ItemMeta meta = item.getItemMeta();
    assert meta != null;
    meta.setDisplayName(Color.format(name));
    meta.setLore(lore);
    item.setItemMeta(meta);
    return item;
}

// For adding enchants to an item faster
public static void addEnchant(ItemStack item, Enchantment enchantment, int enchantLevel) {
    ItemMeta meta = item.getItemMeta();
    assert meta != null;
    meta.addEnchant(enchantment, enchantLevel, true);
    item.setItemMeta(meta);
}

// For adding Attribute Modifiers faster
public static void addAttributeModifier(ItemStack item, Attribute attribute, String name, int level, AttributeModifier.Operation operation, EquipmentSlot slot) {
    AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), name, level, operation, slot);
    ItemMeta meta = item.getItemMeta();
    assert meta != null;
    meta.addAttributeModifier(attribute, modifier);
    item.setItemMeta(meta);
}
```

### More Tiny Things
****
* Custom messages and join / leave events (I was tired of how ugly the vanilla ones were)
* New Give and Enchant commands
* Vanish command
* Coordinate command - when run by a player sends current coordinates. Useful for survival when trying to find other people and not having to type out the coords every time.
* Working on a hologram API thingy!

