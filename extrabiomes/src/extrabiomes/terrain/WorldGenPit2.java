/**
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license
 * located in /MMPL-1.0.txt
 */

package extrabiomes.terrain;

import java.util.Random;

import extrabiomes.api.ExtrabiomesBlock;


import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenPit2 extends WorldGenerator {
	public WorldGenPit2() {
	}

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		if (ExtrabiomesBlock.quickSand != null) {
			while (world.isAirBlock(x, y, z) && y > 2)
				y--;

			if (world.getBlockId(x, y, z) != Block.grass.blockID)
				return false;

			for (int x1 = -2; x1 <= 2; x1++) {
				for (int z1 = -2; z1 <= 2; z1++) {
					if (world.isAirBlock(x + x1, y - 1, z + z1)
							&& world.isAirBlock(x + x1, y - 2, z + z1)) {
						return false;
					}
				}
			}

			for (int x1 = -1; x1 <= 1; x1++)
				for (int z1 = -1; z1 <= 1; z1++)
					for (int y1 = -2; y1 <= 0; y1++)
						world.setBlock(x + x1, y + y1, z + z1,
								ExtrabiomesBlock.quickSand.get().blockID);
		}

		return true;
	}

}