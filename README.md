# X-Ray Goggles

A Minecraft Fabric mod that adds craftable X-Ray Goggles. When worn as a helmet, they allow you to see through stone, dirt, gravel, and deepslate to reveal ores, caves, and underground structures.

## Features

- **X-Ray Vision**: When wearing the goggles and activating them, common blocks like stone, dirt, gravel, and deepslate become transparent
- **Toggle Control**: Press sneak (crouch) while wearing the goggles to toggle the X-ray effect on/off
- **Visual Indicator**: A subtle green overlay appears on the screen edges when X-ray mode is active
- **Craftable Item**: Create the goggles using diamonds, glass panes, and gold ingots

## Crafting Recipe

```
D G D
G   G
I   I

D = Diamond
G = Glass Pane
I = Gold Ingot
```

## Requirements

- Minecraft 1.21.1
- Fabric Loader 0.16+
- Fabric API

## Installation

1. Install Fabric for Minecraft 1.21.1
2. Download the JAR from `build/libs/`
3. Place it in your `.minecraft/mods/` folder
4. Launch Minecraft with the Fabric profile

## Usage

1. Craft the X-Ray Goggles using the recipe above
2. Equip them in your helmet slot
3. Press sneak to toggle X-ray vision on/off
4. Look for the green screen overlay to know when X-ray is active

## Building from Source

```bash
gradle build
```

The compiled JAR will be in `build/libs/`.
