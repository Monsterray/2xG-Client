import sign.signlink;

public final class ItemDef {

	public static ItemDef forID(int i) {
		for (int j = 0; j < 10; j++) {
			if (cache[j].id == i) {
				return cache[j];
			}
		}
		cacheIndex = (cacheIndex + 1) % 10;
		ItemDef itemDef = cache[cacheIndex];
		stream.currentOffset = streamIndices[i];
		itemDef.id = i;
		itemDef.setDefaults();
		itemDef.readValues(stream);
		itemDef = ItemDef_2.itemDef(i, itemDef);
		if (itemDef.certTemplateID != -1) {
			itemDef.toNote();
		}
		if (itemDef.lendTemplateID != -1) {
			itemDef.toLend();
		}
		if (!isMembers && itemDef.membersObject) {
			itemDef.name = "Members Object";
			itemDef.description = "Login to a members' server to use this object.";
			itemDef.groundActions = null;
			itemDef.itemActions = null;
			itemDef.team = 0;
		}
		return itemDef;
	}

	public static byte[] getData(String s) {
		return FileOperations.ReadFile(s);
	}

	public static Sprite getSprite(int i, int j, int k) {
		if (k == 0) {
			Sprite sprite = (Sprite) mruNodes1.insertFromCache(i);
			if (sprite != null && sprite.maxHeight != j
					&& sprite.maxHeight != -1) {
				sprite.unlink();
				sprite = null;
			}
			if (sprite != null) {
				return sprite;
			}
		}
		ItemDef itemDef = forID(i);
		if (itemDef.stackIDs == null) {
			j = -1;
		}
		if (j > 1) {
			int i1 = -1;
			for (int j1 = 0; j1 < 10; j1++) {
				if (j >= itemDef.stackAmounts[j1]
						&& itemDef.stackAmounts[j1] != 0) {
					i1 = itemDef.stackIDs[j1];
				}
			}
			if (i1 != -1) {
				itemDef = forID(i1);
			}
		}
		Model model = itemDef.method201(1);
		if (model == null) {
			return null;
		}
		Sprite sprite = null;
		if (itemDef.certTemplateID != -1) {
			sprite = getSprite(itemDef.certID, 10, -1);
			if (sprite == null) {
				return null;
			}
		}
		if (itemDef.lendTemplateID != -1) {
			sprite = getSprite(itemDef.lendID, 50, 0);
			if (sprite == null) {
				return null;
			}
		}
		Sprite sprite2 = new Sprite(32, 32);
		int k1 = Texture.textureInt1;
		int l1 = Texture.textureInt2;
		int ai[] = Texture.anIntArray1472;
		int ai1[] = DrawingArea.pixels;
		int i2 = DrawingArea.width;
		int j2 = DrawingArea.height;
		int k2 = DrawingArea.topX;
		int l2 = DrawingArea.bottomX;
		int i3 = DrawingArea.topY;
		int j3 = DrawingArea.bottomY;
		Texture.aBoolean1464 = false;
		DrawingArea.initDrawingArea(32, 32, sprite2.myPixels);
		DrawingArea.drawPixels(32, 0, 0, 0, 32);
		Texture.method364();
		int k3 = itemDef.modelZoom;
		if (k == -1) {
			k3 = (int) (k3 * 1.5D);
		}
		if (k > 0) {
			k3 = (int) (k3 * 1.04D);
		}
		int l3 = Texture.anIntArray1470[itemDef.modelRotation1] * k3 >> 16;
		int i4 = Texture.anIntArray1471[itemDef.modelRotation1] * k3 >> 16;
		model.method482(itemDef.modelRotation2, itemDef.anInt204,
				itemDef.modelRotation1, itemDef.modelOffset1, l3
						+ model.modelHeight / 2 + itemDef.modelOffset2, i4
						+ itemDef.modelOffset2);
		for (int i5 = 31; i5 >= 0; i5--) {
			for (int j4 = 31; j4 >= 0; j4--) {
				if (sprite2.myPixels[i5 + j4 * 32] != 0) {
					continue;
				}
				if (i5 > 0 && sprite2.myPixels[(i5 - 1) + j4 * 32] > 1) {
					sprite2.myPixels[i5 + j4 * 32] = 1;
					continue;
				}
				if (j4 > 0 && sprite2.myPixels[i5 + (j4 - 1) * 32] > 1) {
					sprite2.myPixels[i5 + j4 * 32] = 1;
					continue;
				}
				if (i5 < 31 && sprite2.myPixels[i5 + 1 + j4 * 32] > 1) {
					sprite2.myPixels[i5 + j4 * 32] = 1;
					continue;
				}
				if (j4 < 31 && sprite2.myPixels[i5 + (j4 + 1) * 32] > 1) {
					sprite2.myPixels[i5 + j4 * 32] = 1;
				}
			}
		}
		if (k > 0) {
			for (int j5 = 31; j5 >= 0; j5--) {
				for (int k4 = 31; k4 >= 0; k4--) {
					if (sprite2.myPixels[j5 + k4 * 32] != 0) {
						continue;
					}
					if (j5 > 0 && sprite2.myPixels[(j5 - 1) + k4 * 32] == 1) {
						sprite2.myPixels[j5 + k4 * 32] = k;
						continue;
					}
					if (k4 > 0 && sprite2.myPixels[j5 + (k4 - 1) * 32] == 1) {
						sprite2.myPixels[j5 + k4 * 32] = k;
						continue;
					}
					if (j5 < 31 && sprite2.myPixels[j5 + 1 + k4 * 32] == 1) {
						sprite2.myPixels[j5 + k4 * 32] = k;
						continue;
					}
					if (k4 < 31 && sprite2.myPixels[j5 + (k4 + 1) * 32] == 1) {
						sprite2.myPixels[j5 + k4 * 32] = k;
					}
				}
			}
		} else if (k == 0) {
			for (int k5 = 31; k5 >= 0; k5--) {
				for (int l4 = 31; l4 >= 0; l4--) {
					if (sprite2.myPixels[k5 + l4 * 32] == 0 && k5 > 0 && l4 > 0
							&& sprite2.myPixels[(k5 - 1) + (l4 - 1) * 32] > 0) {
						sprite2.myPixels[k5 + l4 * 32] = 0x302020;
					}
				}
			}
		}
		if (itemDef.certTemplateID != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = 32;
			sprite.maxHeight = 32;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}
		if (itemDef.lendTemplateID != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = 32;
			sprite.maxHeight = 32;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}
		if (k == 0) {
			mruNodes1.removeFromCache(sprite2, i);
		}
		DrawingArea.initDrawingArea(j2, i2, ai1);
		DrawingArea.setDrawingArea(j3, k2, l2, i3);
		Texture.textureInt1 = k1;
		Texture.textureInt2 = l1;
		Texture.anIntArray1472 = ai;
		Texture.aBoolean1464 = true;
		if (itemDef.stackable) {
			sprite2.maxWidth = 33;
		} else {
			sprite2.maxWidth = 32;
		}
		sprite2.maxHeight = j;
		return sprite2;
	}

	public static Sprite getSprite(int i, int j, int k, int zoom) {
		if (k == 0 && zoom != -1) {
			Sprite sprite = (Sprite) mruNodes1.insertFromCache(i);
			if (sprite != null && sprite.maxHeight != j
					&& sprite.maxHeight != -1) {
				sprite.unlink();
				sprite = null;
			}
			if (sprite != null) {
				return sprite;
			}
		}
		ItemDef itemDef = forID(i);
		if (itemDef.stackIDs == null) {
			j = -1;
		}
		if (j > 1) {
			int i1 = -1;
			for (int j1 = 0; j1 < 10; j1++) {
				if (j >= itemDef.stackAmounts[j1]
						&& itemDef.stackAmounts[j1] != 0) {
					i1 = itemDef.stackIDs[j1];
				}
			}
			if (i1 != -1) {
				itemDef = forID(i1);
			}
		}
		Model model = itemDef.method201(1);
		if (model == null) {
			return null;
		}
		Sprite sprite = null;
		if (itemDef.certTemplateID != -1) {
			sprite = getSprite(itemDef.certID, 10, -1);
			if (sprite == null) {
				return null;
			}
		}
		if (itemDef.lendID != -1) {
			sprite = getSprite(itemDef.lendID, 50, 0);
			if (sprite == null) {
				return null;
			}
		}
		Sprite sprite2 = new Sprite(32, 32);
		int k1 = Texture.textureInt1;
		int l1 = Texture.textureInt2;
		int ai[] = Texture.anIntArray1472;
		int ai1[] = DrawingArea.pixels;
		int i2 = DrawingArea.width;
		int j2 = DrawingArea.height;
		int k2 = DrawingArea.topX;
		int l2 = DrawingArea.bottomX;
		int i3 = DrawingArea.topY;
		int j3 = DrawingArea.bottomY;
		Texture.aBoolean1464 = false;
		DrawingArea.initDrawingArea(32, 32, sprite2.myPixels);
		DrawingArea.drawPixels(32, 0, 0, 0, 32);
		Texture.method364();
		int k3 = itemDef.modelZoom;
		if (zoom != -1) {
			k3 = (itemDef.modelZoom * 100) / zoom;
		}
		if (k == -1) {
			k3 = (int) (k3 * 1.5D);
		}
		if (k > 0) {
			k3 = (int) (k3 * 1.04D);
		}
		int l3 = Texture.anIntArray1470[itemDef.modelRotation1] * k3 >> 16;
		int i4 = Texture.anIntArray1471[itemDef.modelRotation1] * k3 >> 16;
		model.method482(itemDef.modelRotation2, itemDef.anInt204,
				itemDef.modelRotation1, itemDef.modelOffset1, l3
						+ model.modelHeight / 2 + itemDef.modelOffset2, i4
						+ itemDef.modelOffset2);
		for (int i5 = 31; i5 >= 0; i5--) {
			for (int j4 = 31; j4 >= 0; j4--) {
				if (sprite2.myPixels[i5 + j4 * 32] != 0) {
					continue;
				}
				if (i5 > 0 && sprite2.myPixels[(i5 - 1) + j4 * 32] > 1) {
					sprite2.myPixels[i5 + j4 * 32] = 1;
					continue;
				}
				if (j4 > 0 && sprite2.myPixels[i5 + (j4 - 1) * 32] > 1) {
					sprite2.myPixels[i5 + j4 * 32] = 1;
					continue;
				}
				if (i5 < 31 && sprite2.myPixels[i5 + 1 + j4 * 32] > 1) {
					sprite2.myPixels[i5 + j4 * 32] = 1;
					continue;
				}
				if (j4 < 31 && sprite2.myPixels[i5 + (j4 + 1) * 32] > 1) {
					sprite2.myPixels[i5 + j4 * 32] = 1;
				}
			}
		}
		if (k > 0) {
			for (int j5 = 31; j5 >= 0; j5--) {
				for (int k4 = 31; k4 >= 0; k4--) {
					if (sprite2.myPixels[j5 + k4 * 32] != 0) {
						continue;
					}
					if (j5 > 0 && sprite2.myPixels[(j5 - 1) + k4 * 32] == 1) {
						sprite2.myPixels[j5 + k4 * 32] = k;
						continue;
					}
					if (k4 > 0 && sprite2.myPixels[j5 + (k4 - 1) * 32] == 1) {
						sprite2.myPixels[j5 + k4 * 32] = k;
						continue;
					}
					if (j5 < 31 && sprite2.myPixels[j5 + 1 + k4 * 32] == 1) {
						sprite2.myPixels[j5 + k4 * 32] = k;
						continue;
					}
					if (k4 < 31 && sprite2.myPixels[j5 + (k4 + 1) * 32] == 1) {
						sprite2.myPixels[j5 + k4 * 32] = k;
					}
				}
			}
		} else if (k == 0) {
			for (int k5 = 31; k5 >= 0; k5--) {
				for (int l4 = 31; l4 >= 0; l4--) {
					if (sprite2.myPixels[k5 + l4 * 32] == 0 && k5 > 0 && l4 > 0
							&& sprite2.myPixels[(k5 - 1) + (l4 - 1) * 32] > 0) {
						sprite2.myPixels[k5 + l4 * 32] = 0x302020;
					}
				}
			}
		}
		if (itemDef.certTemplateID != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = 32;
			sprite.maxHeight = 32;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}
		if (itemDef.lendID != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = 32;
			sprite.maxHeight = 32;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}
		if (k == 0) {
			mruNodes1.removeFromCache(sprite2, i);
		}
		DrawingArea.initDrawingArea(j2, i2, ai1);
		DrawingArea.setDrawingArea(j3, k2, l2, i3);
		Texture.textureInt1 = k1;
		Texture.textureInt2 = l1;
		Texture.anIntArray1472 = ai;
		Texture.aBoolean1464 = true;
		sprite2.maxWidth = itemDef.stackable ? 33 : 32;
		sprite2.maxHeight = j;
		return sprite2;
	}

	public static void itemModel() {
		try {
			for (int i = 0; i < 20793; i++) {
				ItemDef itemDef = forID(i);
				System.out.println(i);
				byte abyte0121[] = FileOperations
						.ReadFile((new StringBuilder()).append("./items/")
								.append(itemDef.modelID).append(".mdl")
								.toString());
				FileOperations.WriteFile(
						(new StringBuilder()).append("./dumped/")
								.append(itemDef.modelID).append(".mdl")
								.toString(), abyte0121);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void nullLoader() {
		mruNodes2 = null;
		mruNodes1 = null;
		streamIndices = null;
		cache = null;
		stream = null;
	}

	public static void unpackConfig(StreamLoader streamLoader) {
		stream = new Stream(getData((new StringBuilder()).append(loc)
				.append("obj.dat").toString()));
		Stream stream = new Stream(getData((new StringBuilder()).append(loc)
				.append("obj.idx").toString()));
		totalItems = stream.readUnsignedWord();
		streamIndices = new int[totalItems];
		int i = 2;
		for (int j = 0; j < totalItems; j++) {
			streamIndices[j] = i;
			i += stream.readUnsignedWord();
		}
		cache = new ItemDef[10];
		for (int k = 0; k < 10; k++) {
			cache[k] = new ItemDef();
		}
	}

	public int lendID;

	public int lendTemplateID;

	public static String loc = signlink.findcachedir();

	public static int ITEMAMOUNT = 18635;

	public byte aByte154;

	public int value;

	public int modifiedModelColors[];

	public int id;

	static MRUNodes mruNodes1 = new MRUNodes(100);

	public static MRUNodes mruNodes2 = new MRUNodes(50);

	public int originalModelColors[];

	public boolean membersObject;
	public int anInt162;
	public int certTemplateID;
	public int anInt164;
	public int anInt165;
	public int anInt166;
	public int anInt167;
	public String groundActions[];
	public int modelOffset1;
	public String name;
	public static ItemDef cache[];
	public int anInt173;
	public int modelID;
	public int anInt175;
	public boolean stackable;
	public String description;
	public int certID;
	public static int cacheIndex;
	public int modelZoom;
	public static boolean isMembers = true;
	public static Stream stream;
	public int anInt184;
	public int anInt185;
	public int anInt188;
	public String itemActions[];
	public int modelRotation1;
	public int anInt191;
	public int anInt192;
	public int stackIDs[];
	public int modelOffset2;
	public static int streamIndices[];
	public int anInt196;
	public int anInt197;
	public int modelRotation2;
	public int anInt200;
	public int stackAmounts[];
	public int team;
	public static int totalItems;
	public int anInt204;
	public byte aByte205;

	public ItemDef() {
		id = -1;
	}

	public boolean method192(int j) {
		int k = anInt175;
		int l = anInt166;
		if (j == 1) {
			k = anInt197;
			l = anInt173;
		}
		if (k == -1) {
			return true;
		}
		boolean flag = true;
		if (!Model.method463(k)) {
			flag = false;
		}
		if (l != -1 && !Model.method463(l)) {
			flag = false;
		}
		return flag;
	}

	public Model method194(int j) {
		int k = anInt175;
		int l = anInt166;
		if (j == 1) {
			k = anInt197;
			l = anInt173;
		}
		if (k == -1) {
			return null;
		}
		Model model = Model.method462(k);
		if (l != -1) {
			Model model_1 = Model.method462(l);
			Model models[] = { model, model_1 };
			model = new Model(2, models);
		}
		if (modifiedModelColors != null) {
			for (int i1 = 0; i1 < modifiedModelColors.length; i1++) {
				model.method476(modifiedModelColors[i1],
						originalModelColors[i1]);
			}
		}
		return model;
	}

	public boolean method195(int j) {
		int k = anInt165;
		int l = anInt188;
		int i1 = anInt185;
		if (j == 1) {
			k = anInt200;
			l = anInt164;
			i1 = anInt162;
		}
		if (k == -1) {
			return true;
		}
		boolean flag = true;
		if (!Model.method463(k)) {
			flag = false;
		}
		if (l != -1 && !Model.method463(l)) {
			flag = false;
		}
		if (i1 != -1 && !Model.method463(i1)) {
			flag = false;
		}
		return flag;
	}

	public Model method196(int i) {
		int j = anInt165;
		int k = anInt188;
		int l = anInt185;
		if (i == 1) {
			j = anInt200;
			k = anInt164;
			l = anInt162;
		}
		if (j == -1) {
			return null;
		}
		Model model = Model.method462(j);
		if (k != -1) {
			if (l != -1) {
				Model model_1 = Model.method462(k);
				Model model_3 = Model.method462(l);
				Model model_1s[] = { model, model_1, model_3 };
				model = new Model(3, model_1s);
			} else {
				Model model_2 = Model.method462(k);
				Model models[] = { model, model_2 };
				model = new Model(2, models);
			}
		}
		if (i == 0 && aByte205 != 0) {
			model.method475(0, aByte205, 0);
		}
		if (i == 1 && aByte154 != 0) {
			model.method475(0, aByte154, 0);
		}
		if (modifiedModelColors != null) {
			for (int i1 = 0; i1 < modifiedModelColors.length; i1++) {
				model.method476(modifiedModelColors[i1],
						originalModelColors[i1]);
			}
		}
		return model;
	}

	public Model method201(int i) {
		if (stackIDs != null && i > 1) {
			int j = -1;
			for (int k = 0; k < 10; k++) {
				if (i >= stackAmounts[k] && stackAmounts[k] != 0) {
					j = stackIDs[k];
				}
			}
			if (j != -1) {
				return forID(j).method201(1);
			}
		}
		Model model = (Model) mruNodes2.insertFromCache(id);
		if (model != null) {
			return model;
		}
		model = Model.method462(modelID);
		if (model == null) {
			return null;
		}
		if (anInt167 != 128 || anInt192 != 128 || anInt191 != 128) {
			model.method478(anInt167, anInt191, anInt192);
		}
		if (modifiedModelColors != null) {
			for (int l = 0; l < modifiedModelColors.length; l++) {
				model.method476(modifiedModelColors[l], originalModelColors[l]);
			}
		}
		model.method479(64 + anInt196, 768 + anInt184, -50, -10, -50, true);
		model.aBoolean1659 = true;
		mruNodes2.removeFromCache(model, id);
		return model;
	}

	public Model method202(int i) {
		if (stackIDs != null && i > 1) {
			int j = -1;
			for (int k = 0; k < 10; k++) {
				if (i >= stackAmounts[k] && stackAmounts[k] != 0) {
					j = stackIDs[k];
				}
			}
			if (j != -1) {
				return forID(j).method202(1);
			}
		}
		Model model = Model.method462(modelID);
		if (model == null) {
			return null;
		}
		if (modifiedModelColors != null) {
			for (int l = 0; l < modifiedModelColors.length; l++) {
				model.method476(modifiedModelColors[l], originalModelColors[l]);
			}
		}
		return model;
	}

	private void readValues(Stream stream) {
		do {
			int i = stream.readUnsignedByte();
			if (i == 0) {
				return;
			}
			if (i == 1) {
				modelID = stream.readUnsignedWord();
			} else if (i == 2) {
				name = stream.readString();
			} else if (i == 3) {
				description = stream.readBytes().toString();
			} else if (i == 4) {
				modelZoom = stream.readUnsignedWord();
			} else if (i == 5) {
				modelRotation1 = stream.readUnsignedWord();
			} else if (i == 6) {
				modelRotation2 = stream.readUnsignedWord();
			} else if (i == 7) {
				modelOffset1 = stream.readUnsignedWord();
				if (modelOffset1 > 32767) {
					modelOffset1 -= 0x10000;
				}
			} else if (i == 8) {
				modelOffset2 = stream.readUnsignedWord();
				if (modelOffset2 > 32767) {
					modelOffset2 -= 0x10000;
				}
			} else if (i == 10) {
				stream.readUnsignedWord();
			} else if (i == 11) {
				stackable = true;
			} else if (i == 12) {
				value = stream.readDWord();
			} else if (i == 16) {
				membersObject = true;
			} else if (i == 23) {
				anInt165 = stream.readUnsignedWord();
				aByte205 = stream.readSignedByte();
			} else if (i == 24) {
				anInt188 = stream.readUnsignedWord();
			} else if (i == 25) {
				anInt200 = stream.readUnsignedWord();
				aByte154 = stream.readSignedByte();
			} else if (i == 26) {
				anInt164 = stream.readUnsignedWord();
			} else if (i >= 30 && i < 35) {
				if (groundActions == null) {
					groundActions = new String[5];
				}
				groundActions[i - 30] = stream.readString();
				if (groundActions[i - 30].equalsIgnoreCase("hidden")) {
					groundActions[i - 30] = null;
				}
			} else if (i >= 35 && i < 40) {
				if (itemActions == null) {
					itemActions = new String[5];
				}
				itemActions[i - 35] = stream.readString();
			} else if (i == 40) {
				int j = stream.readUnsignedByte();
				modifiedModelColors = new int[j];
				originalModelColors = new int[j];
				int k = 0;
				while (k < j) {
					modifiedModelColors[k] = stream.readUnsignedWord();
					originalModelColors[k] = stream.readUnsignedWord();
					k++;
				}
			} else if (i == 78) {
				anInt185 = stream.readUnsignedWord();
			} else if (i == 79) {
				anInt162 = stream.readUnsignedWord();
			} else if (i == 90) {
				anInt175 = stream.readUnsignedWord();
			} else if (i == 91) {
				anInt197 = stream.readUnsignedWord();
			} else if (i == 92) {
				anInt166 = stream.readUnsignedWord();
			} else if (i == 93) {
				anInt173 = stream.readUnsignedWord();
			} else if (i == 95) {
				anInt204 = stream.readUnsignedWord();
			} else if (i == 97) {
				certID = stream.readUnsignedWord();
			} else if (i == 98) {
				certTemplateID = stream.readUnsignedWord();
			} else if (i >= 100 && i < 110) {
				if (stackIDs == null) {
					stackIDs = new int[10];
					stackAmounts = new int[10];
				}
				stackIDs[i - 100] = stream.readUnsignedWord();
				stackAmounts[i - 100] = stream.readUnsignedWord();
			} else if (i == 110) {
				anInt167 = stream.readUnsignedWord();
			} else if (i == 111) {
				anInt192 = stream.readUnsignedWord();
			} else if (i == 112) {
				anInt191 = stream.readUnsignedWord();
			} else if (i == 113) {
				anInt196 = stream.readSignedByte();
			} else if (i == 114) {
				anInt184 = stream.readSignedByte() * 5;
			} else if (i == 115) {
				team = stream.readUnsignedByte();
			} else if (i == 121) {
			} else if (i == 122) {
			}
		} while (true);
	}

	private void setDefaults() {
		modelID = 0;
		name = null;
		description = null;
		originalModelColors = null;
		modifiedModelColors = null;
		modelZoom = 2000;
		modelRotation1 = 0;
		modelRotation2 = 0;
		anInt204 = 0;
		modelOffset1 = 0;
		modelOffset2 = 0;
		stackable = false;
		value = 1;
		membersObject = false;
		groundActions = null;
		itemActions = null;
		lendID = -1;
		lendTemplateID = -1;
		anInt165 = -1;
		anInt188 = -1;
		aByte205 = 0;
		anInt200 = -1;
		anInt164 = -1;
		aByte154 = 0;
		anInt185 = -1;
		anInt162 = -1;
		anInt175 = -1;
		anInt166 = -1;
		anInt197 = -1;
		anInt173 = -1;
		stackIDs = null;
		stackAmounts = null;
		certID = -1;
		certTemplateID = -1;
		anInt167 = 128;
		anInt192 = 128;
		anInt191 = 128;
		anInt196 = 0;
		anInt184 = 0;
		team = 0;
	}

	private void toLend() {
		ItemDef itemDef = forID(lendTemplateID);
		itemActions = new String[5];
		modelID = itemDef.modelID;
		modelOffset1 = itemDef.modelOffset1;
		modelRotation2 = itemDef.modelRotation2;
		modelOffset2 = itemDef.modelOffset2;
		modelZoom = itemDef.modelZoom;
		modelRotation1 = itemDef.modelRotation1;
		anInt204 = itemDef.anInt204;
		value = 0;
		ItemDef itemDef_1 = forID(lendID);
		anInt166 = itemDef_1.anInt166;
		originalModelColors = itemDef_1.originalModelColors;
		anInt185 = itemDef_1.anInt185;
		anInt200 = itemDef_1.anInt200;
		anInt173 = itemDef_1.anInt173;
		anInt175 = itemDef_1.anInt175;
		groundActions = itemDef_1.groundActions;
		anInt165 = itemDef_1.anInt165;
		name = itemDef_1.name;
		anInt188 = itemDef_1.anInt188;
		membersObject = itemDef_1.membersObject;
		anInt197 = itemDef_1.anInt197;
		anInt164 = itemDef_1.anInt164;
		anInt162 = itemDef_1.anInt162;
		modifiedModelColors = itemDef_1.modifiedModelColors;
		team = itemDef_1.team;
		if (itemDef_1.itemActions != null) {
			for (int i_33_ = 0; i_33_ < 4; i_33_++) {
				itemActions[i_33_] = itemDef_1.itemActions[i_33_];
			}
		}
		itemActions[4] = "Discard";
	}

	public void toNote() {
		ItemDef itemDef = forID(certTemplateID);
		modelID = itemDef.modelID;
		modelZoom = itemDef.modelZoom;
		modelRotation1 = itemDef.modelRotation1;
		modelRotation2 = itemDef.modelRotation2;
		anInt204 = itemDef.anInt204;
		modelOffset1 = itemDef.modelOffset1;
		modelOffset2 = itemDef.modelOffset2;
		modifiedModelColors = itemDef.modifiedModelColors;
		originalModelColors = itemDef.originalModelColors;
		ItemDef itemDef_1 = forID(certID);
		name = itemDef_1.name;
		membersObject = itemDef_1.membersObject;
		value = itemDef_1.value;
		String s = "a";
		char c = itemDef_1.name.charAt(0);
		if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
			s = "an";
		}
		description = (new StringBuilder())
				.append("Swap this note at any bank for ").append(s)
				.append(" ").append(itemDef_1.name).append(".").toString();
		stackable = true;
	}

}
