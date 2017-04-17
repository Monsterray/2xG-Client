public final class RSInterface {

	public static int boxIds[] = { 4041, 4077, 4113, 4047, 4083, 4119, 4053,
			4089, 4125, 4059, 4095, 4131, 4065, 4101, 4137, 4071, 4107, 4143,
			4154, 12168, 13918 };

	public static StreamLoader aClass44;

	public static void addActionButton(int id, int sprite, int sprite2,
			int width, int height, String s) {
		RSInterface rsi = interfaceCache[id] = new RSInterface();
		rsi.sprite1 = CustomSpriteLoader(sprite, "");
		if (sprite2 == sprite) {
			rsi.sprite2 = CustomSpriteLoader(sprite, "a");
		} else {
			rsi.sprite2 = CustomSpriteLoader(sprite2, "");
		}
		rsi.tooltip = s;
		rsi.contentType = 0;
		rsi.atActionType = 1;
		rsi.width = width;
		rsi.mOverInterToTrigger = 52;
		rsi.parentID = id;
		rsi.id = id;
		rsi.type = 5;
		rsi.height = height;
	}

	public static void addBobStorage(int index) {
		RSInterface rsi = interfaceCache[index] = new RSInterface();
		rsi.itemActions = new String[5];
		rsi.spritesX = new int[20];
		rsi.invStackSizes = new int[30];
		rsi.inv = new int[30];
		rsi.spritesY = new int[20];

		rsi.children = new int[0];
		rsi.childX = new int[0];
		rsi.childY = new int[0];

		rsi.itemActions[0] = "Take 1";
		rsi.itemActions[1] = "Take 5";
		rsi.itemActions[2] = "Take 10";
		rsi.itemActions[3] = "Take All";
		rsi.centerText = false;
		rsi.aBoolean227 = false;
		rsi.aBoolean235 = false;
		rsi.usableItemInterface = false;
		rsi.isInventoryInterface = false;
		// rsi.aBoolean251 = false;
		rsi.aBoolean259 = true;
		// rsi.interfaceShown = false;
		rsi.textShadow = false;
		rsi.type = -1;
		rsi.invSpritePadX = 24;
		rsi.invSpritePadY = 24;
		rsi.height = 5;
		rsi.width = 6;
		rsi.parentID = 2702;
		rsi.id = 2700;
		rsi.type = 2;
	}

	private static void addButton(int ID, int type, int hoverID, int dS,
			int eS, String NAME, int W, int H, String text, int configFrame,
			int configId) {
		RSInterface rsinterface = addInterface(ID);
		rsinterface.id = ID;
		rsinterface.parentID = ID;
		rsinterface.type = 5;
		rsinterface.atActionType = type;
		rsinterface.opacity = 0;
		rsinterface.mOverInterToTrigger = hoverID;
		rsinterface.sprite1 = imageLoader(dS, NAME);
		rsinterface.sprite2 = imageLoader(eS, NAME);
		rsinterface.width = W;
		rsinterface.height = H;
		rsinterface.tooltip = text;
		rsinterface.isMouseoverTriggered = true;
		rsinterface.valueCompareType = new int[1];
		rsinterface.requiredValues = new int[1];
		rsinterface.valueCompareType[0] = 1;
		rsinterface.requiredValues[0] = configId;
		rsinterface.valueIndexArray = new int[1][3];
		rsinterface.valueIndexArray[0][0] = 5;
		rsinterface.valueIndexArray[0][1] = configFrame;
		rsinterface.valueIndexArray[0][2] = 0;
	}

	public static void addButton(int i, int j, String name, int W, int H,
			String S, int AT) {
		RSInterface RSInterface = addInterface(i);
		RSInterface.id = i;
		RSInterface.parentID = i;
		RSInterface.type = 5;
		RSInterface.atActionType = AT;
		RSInterface.contentType = 0;
		RSInterface.opacity = 0;
		RSInterface.mOverInterToTrigger = 52;
		RSInterface.sprite1 = imageLoader(j, name);
		RSInterface.sprite2 = imageLoader(j, name);
		RSInterface.width = W;
		RSInterface.height = H;
		RSInterface.tooltip = S;
	}

	public static void addButton(int id, int sid, String spriteName,
			String tooltip) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 1;
		tab.contentType = 0;
		tab.opacity = 0;
		tab.mOverInterToTrigger = 52;
		tab.sprite1 = imageLoader(sid, spriteName);
		tab.sprite2 = imageLoader(sid, spriteName);
		tab.width = tab.sprite1.myWidth;
		tab.height = tab.sprite2.myHeight;
		tab.tooltip = tooltip;
	}

	public static void addButton(int id, int sid, String spriteName,
			String tooltip, int w, int h) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 1;
		tab.contentType = 0;
		tab.opacity = 0;
		tab.mOverInterToTrigger = 52;
		tab.sprite1 = imageLoader(sid, spriteName);
		tab.sprite2 = imageLoader(sid, spriteName);
		tab.width = w;
		tab.height = h;
		tab.tooltip = tooltip;
	}

	public static void addCacheSprite(int id, int sprite1, int sprite2,
			String sprites) {
		RSInterface rsi = interfaceCache[id] = new RSInterface();
		rsi.sprite1 = method207(sprite1, aClass44, sprites);
		rsi.sprite2 = method207(sprite2, aClass44, sprites);
		rsi.parentID = id;
		rsi.id = id;
		rsi.type = 5;
	}

	public static void addClickableText(int id, String text, String tooltip,
			TextDrawingArea tda[], int idx, int color, boolean center,
			boolean shadow, int width) {
		RSInterface tab = addTabInterface(id);
		tab.parentID = id;
		tab.id = id;
		tab.type = 4;
		tab.atActionType = 1;
		tab.width = width;
		tab.height = 11;
		tab.contentType = 0;
		tab.opacity = 0;
		tab.mOverInterToTrigger = -1;
		tab.centerText = center;
		tab.textShadow = shadow;
		tab.textDrawingAreas = tda[idx];
		tab.message = text;
		tab.disabledText = "";
		tab.textColor = color;
		tab.anInt219 = 0;
		tab.textHoverColour = 0xffffff;
		tab.anInt239 = 0;
		tab.tooltip = tooltip;
	}

	public static void addConfigButton(int ID, int pID, int bID, int bID2,
			String bName, int width, int height, String tT, int configID,
			int aT, int configFrame) {
		RSInterface Tab = addTabInterface(ID);
		Tab.parentID = pID;
		Tab.id = ID;
		Tab.type = 5;
		Tab.atActionType = aT;
		Tab.contentType = 0;
		Tab.width = width;
		Tab.height = height;
		Tab.opacity = 0;
		Tab.mOverInterToTrigger = -1;
		Tab.valueCompareType = new int[1];
		Tab.requiredValues = new int[1];
		Tab.valueCompareType[0] = 1;
		Tab.requiredValues[0] = configID;
		Tab.valueIndexArray = new int[1][3];
		Tab.valueIndexArray[0][0] = 5;
		Tab.valueIndexArray[0][1] = configFrame;
		Tab.valueIndexArray[0][2] = 0;
		Tab.sprite1 = imageLoader(bID, bName);
		Tab.sprite2 = imageLoader(bID2, bName);
		Tab.tooltip = tT;
	}

	public static void addHoverBox(int id, String text) {
		RSInterface rsi = interfaceCache[id];
		rsi.id = id;
		rsi.parentID = id;
		rsi.isMouseoverTriggered = true;
		rsi.type = 8;
		rsi.hoverText = text;
	}

	public static void addInAreaHover(int i, String imageName, int sId,
			int sId2, int w, int h, String text, int contentType, int actionType) {
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = i;
		tab.type = 5;
		tab.atActionType = actionType;
		tab.contentType = contentType;
		tab.opacity = 0;
		tab.mOverInterToTrigger = i;
		if (sId != -1) {
			tab.sprite1 = imageLoader(sId, imageName);
		}
		tab.sprite2 = imageLoader(sId2, imageName);
		tab.width = w;
		tab.height = h;
		tab.tooltip = text;
	}

	public static void addLunar2RunesSmallBox(int ID, int r1, int r2, int ra1,
			int ra2, int rune1, int lvl, String name, String descr,
			TextDrawingArea TDA[], int sid, int suo, int type) {
		RSInterface rsInterface = addTabInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.mOverInterToTrigger = ID + 1;
		rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast On";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = (new StringBuilder()).append("Cast @gre@")
				.append(name).toString();
		rsInterface.spellName = name;
		rsInterface.valueCompareType = new int[3];
		rsInterface.requiredValues = new int[3];
		rsInterface.valueCompareType[0] = 3;
		rsInterface.requiredValues[0] = ra1;
		rsInterface.valueCompareType[1] = 3;
		rsInterface.requiredValues[1] = ra2;
		rsInterface.valueCompareType[2] = 3;
		rsInterface.requiredValues[2] = lvl;
		rsInterface.valueIndexArray = new int[3][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[3];
		rsInterface.valueIndexArray[2][0] = 1;
		rsInterface.valueIndexArray[2][1] = 6;
		rsInterface.valueIndexArray[2][2] = 0;
		rsInterface.sprite2 = loadSprite(sid, "Lunar/LUNARON");
		rsInterface.sprite1 = loadSprite(sid, "Lunar/LUNAROFF");
		RSInterface hover = addTabInterface(ID + 1);
		hover.mOverInterToTrigger = -1;
		hover.isMouseoverTriggered = true;
		setChildren(7, hover);
		addSprite(ID + 2, 0, "Lunar/BOX");
		setBounds(ID + 2, 0, 0, 0, hover);
		addText(ID + 3, (new StringBuilder()).append("Level ").append(lvl + 1)
				.append(": ").append(name).toString(), 0xff981f, true, true,
				52, 1);
		setBounds(ID + 3, 90, 4, 1, hover);
		addText(ID + 4, descr, 0xaf6a1a, true, true, 52, 0);
		setBounds(ID + 4, 90, 19, 2, hover);
		setBounds(30016, 37, 35, 3, hover);
		setBounds(rune1, 112, 35, 4, hover);
		addRuneText(ID + 5, ra1 + 1, r1, TDA);
		setBounds(ID + 5, 50, 66, 5, hover);
		addRuneText(ID + 6, ra2 + 1, r2, TDA);
		setBounds(ID + 6, 123, 66, 6, hover);
	}

	public static void addLunar3RunesBigBox(int ID, int r1, int r2, int r3,
			int ra1, int ra2, int ra3, int rune1, int rune2, int lvl,
			String name, String descr, TextDrawingArea TDA[], int sid, int suo,
			int type) {
		RSInterface rsInterface = addTabInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.mOverInterToTrigger = ID + 1;
		rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = (new StringBuilder()).append("Cast @gre@")
				.append(name).toString();
		rsInterface.spellName = name;
		rsInterface.valueCompareType = new int[4];
		rsInterface.requiredValues = new int[4];
		rsInterface.valueCompareType[0] = 3;
		rsInterface.requiredValues[0] = ra1;
		rsInterface.valueCompareType[1] = 3;
		rsInterface.requiredValues[1] = ra2;
		rsInterface.valueCompareType[2] = 3;
		rsInterface.requiredValues[2] = ra3;
		rsInterface.valueCompareType[3] = 3;
		rsInterface.requiredValues[3] = lvl;
		rsInterface.valueIndexArray = new int[4][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[4];
		rsInterface.valueIndexArray[2][0] = 4;
		rsInterface.valueIndexArray[2][1] = 3214;
		rsInterface.valueIndexArray[2][2] = r3;
		rsInterface.valueIndexArray[2][3] = 0;
		rsInterface.valueIndexArray[3] = new int[3];
		rsInterface.valueIndexArray[3][0] = 1;
		rsInterface.valueIndexArray[3][1] = 6;
		rsInterface.valueIndexArray[3][2] = 0;
		rsInterface.sprite2 = loadSprite(sid, "Lunar/LUNARON");
		rsInterface.sprite1 = loadSprite(sid, "Lunar/LUNAROFF");
		RSInterface hover = addTabInterface(ID + 1);
		hover.mOverInterToTrigger = -1;
		hover.isMouseoverTriggered = true;
		setChildren(9, hover);
		addSprite(ID + 2, 1, "Lunar/BOX");
		setBounds(ID + 2, 0, 0, 0, hover);
		addText(ID + 3, (new StringBuilder()).append("Level ").append(lvl + 1)
				.append(": ").append(name).toString(), 0xff981f, true, true,
				52, 1);
		setBounds(ID + 3, 90, 4, 1, hover);
		addText(ID + 4, descr, 0xaf6a1a, true, true, 52, 0);
		setBounds(ID + 4, 90, 21, 2, hover);
		setBounds(30016, 14, 48, 3, hover);
		setBounds(rune1, 74, 48, 4, hover);
		setBounds(rune2, 130, 48, 5, hover);
		addRuneText(ID + 5, ra1 + 1, r1, TDA);
		setBounds(ID + 5, 26, 79, 6, hover);
		addRuneText(ID + 6, ra2 + 1, r2, TDA);
		setBounds(ID + 6, 87, 79, 7, hover);
		addRuneText(ID + 7, ra3 + 1, r3, TDA);
		setBounds(ID + 7, 142, 79, 8, hover);
	}

	public static void addLunar3RunesLargeBox(int ID, int r1, int r2, int r3,
			int ra1, int ra2, int ra3, int rune1, int rune2, int lvl,
			String name, String descr, TextDrawingArea TDA[], int sid, int suo,
			int type) {
		RSInterface rsInterface = addTabInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.mOverInterToTrigger = ID + 1;
		rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = (new StringBuilder()).append("Cast @gre@")
				.append(name).toString();
		rsInterface.spellName = name;
		rsInterface.valueCompareType = new int[4];
		rsInterface.requiredValues = new int[4];
		rsInterface.valueCompareType[0] = 3;
		rsInterface.requiredValues[0] = ra1;
		rsInterface.valueCompareType[1] = 3;
		rsInterface.requiredValues[1] = ra2;
		rsInterface.valueCompareType[2] = 3;
		rsInterface.requiredValues[2] = ra3;
		rsInterface.valueCompareType[3] = 3;
		rsInterface.requiredValues[3] = lvl;
		rsInterface.valueIndexArray = new int[4][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[4];
		rsInterface.valueIndexArray[2][0] = 4;
		rsInterface.valueIndexArray[2][1] = 3214;
		rsInterface.valueIndexArray[2][2] = r3;
		rsInterface.valueIndexArray[2][3] = 0;
		rsInterface.valueIndexArray[3] = new int[3];
		rsInterface.valueIndexArray[3][0] = 1;
		rsInterface.valueIndexArray[3][1] = 6;
		rsInterface.valueIndexArray[3][2] = 0;
		rsInterface.sprite2 = loadSprite(sid, "Lunar/LUNARON");
		rsInterface.sprite1 = loadSprite(sid, "Lunar/LUNAROFF");
		RSInterface hover = addTabInterface(ID + 1);
		hover.isMouseoverTriggered = true;
		hover.mOverInterToTrigger = -1;
		setChildren(9, hover);
		addSprite(ID + 2, 2, "Lunar/BOX");
		setBounds(ID + 2, 0, 0, 0, hover);
		addText(ID + 3, (new StringBuilder()).append("Level ").append(lvl + 1)
				.append(": ").append(name).toString(), 0xff981f, true, true,
				52, 1);
		setBounds(ID + 3, 90, 4, 1, hover);
		addText(ID + 4, descr, 0xaf6a1a, true, true, 52, 0);
		setBounds(ID + 4, 90, 34, 2, hover);
		setBounds(30016, 14, 61, 3, hover);
		setBounds(rune1, 74, 61, 4, hover);
		setBounds(rune2, 130, 61, 5, hover);
		addRuneText(ID + 5, ra1 + 1, r1, TDA);
		setBounds(ID + 5, 26, 92, 6, hover);
		addRuneText(ID + 6, ra2 + 1, r2, TDA);
		setBounds(ID + 6, 87, 92, 7, hover);
		addRuneText(ID + 7, ra3 + 1, r3, TDA);
		setBounds(ID + 7, 142, 92, 8, hover);
	}

	public static void addLunar3RunesSmallBox(int ID, int r1, int r2, int r3,
			int ra1, int ra2, int ra3, int rune1, int rune2, int lvl,
			String name, String descr, TextDrawingArea TDA[], int sid, int suo,
			int type) {
		RSInterface rsInterface = addTabInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.mOverInterToTrigger = ID + 1;
		rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = (new StringBuilder()).append("Cast @gre@")
				.append(name).toString();
		rsInterface.spellName = name;
		rsInterface.valueCompareType = new int[4];
		rsInterface.requiredValues = new int[4];
		rsInterface.valueCompareType[0] = 3;
		rsInterface.requiredValues[0] = ra1;
		rsInterface.valueCompareType[1] = 3;
		rsInterface.requiredValues[1] = ra2;
		rsInterface.valueCompareType[2] = 3;
		rsInterface.requiredValues[2] = ra3;
		rsInterface.valueCompareType[3] = 3;
		rsInterface.requiredValues[3] = lvl;
		rsInterface.valueIndexArray = new int[4][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[4];
		rsInterface.valueIndexArray[2][0] = 4;
		rsInterface.valueIndexArray[2][1] = 3214;
		rsInterface.valueIndexArray[2][2] = r3;
		rsInterface.valueIndexArray[2][3] = 0;
		rsInterface.valueIndexArray[3] = new int[3];
		rsInterface.valueIndexArray[3][0] = 1;
		rsInterface.valueIndexArray[3][1] = 6;
		rsInterface.valueIndexArray[3][2] = 0;
		rsInterface.sprite2 = loadSprite(sid, "Lunar/LUNARON");
		rsInterface.sprite1 = loadSprite(sid, "Lunar/LUNAROFF");
		RSInterface hover = addTabInterface(ID + 1);
		hover.mOverInterToTrigger = -1;
		hover.isMouseoverTriggered = true;
		setChildren(9, hover);
		addSprite(ID + 2, 0, "Lunar/BOX");
		setBounds(ID + 2, 0, 0, 0, hover);
		addText(ID + 3, (new StringBuilder()).append("Level ").append(lvl + 1)
				.append(": ").append(name).toString(), 0xff981f, true, true,
				52, 1);
		setBounds(ID + 3, 90, 4, 1, hover);
		addText(ID + 4, descr, 0xaf6a1a, true, true, 52, 0);
		setBounds(ID + 4, 90, 19, 2, hover);
		setBounds(30016, 14, 35, 3, hover);
		setBounds(rune1, 74, 35, 4, hover);
		setBounds(rune2, 130, 35, 5, hover);
		addRuneText(ID + 5, ra1 + 1, r1, TDA);
		setBounds(ID + 5, 26, 66, 6, hover);
		addRuneText(ID + 6, ra2 + 1, r2, TDA);
		setBounds(ID + 6, 87, 66, 7, hover);
		addRuneText(ID + 7, ra3 + 1, r3, TDA);
		setBounds(ID + 7, 142, 66, 8, hover);
	}

	public static void addPrayer(int i, int configId, int configFrame,
			int requiredValues, int spriteID, String prayerName) {
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = 5608;
		tab.type = 5;
		tab.atActionType = 4;
		tab.contentType = 0;
		tab.opacity = 0;
		tab.mOverInterToTrigger = -1;
		tab.sprite1 = imageLoader(0, "PRAYERGLOW");
		tab.sprite2 = imageLoader(1, "PRAYERGLOW");
		tab.width = 34;
		tab.height = 34;
		tab.valueCompareType = new int[1];
		tab.requiredValues = new int[1];
		tab.valueCompareType[0] = 1;
		tab.requiredValues[0] = configId;
		tab.valueIndexArray = new int[1][3];
		tab.valueIndexArray[0][0] = 5;
		tab.valueIndexArray[0][1] = configFrame;
		tab.valueIndexArray[0][2] = 0;
		tab.tooltip = (new StringBuilder()).append("Activate@or2@ ")
				.append(prayerName).toString();
		RSInterface tab2 = addTabInterface(i + 1);
		tab2.id = i + 1;
		tab2.parentID = 5608;
		tab2.type = 5;
		tab2.atActionType = 0;
		tab2.contentType = 0;
		tab2.opacity = 0;
		tab2.mOverInterToTrigger = -1;
		tab2.sprite1 = imageLoader(spriteID, "/PRAYER/PRAYON");
		tab2.sprite2 = imageLoader(spriteID, "/PRAYER/PRAYOFF");
		tab2.width = 34;
		tab2.height = 34;
		tab2.valueCompareType = new int[1];
		tab2.requiredValues = new int[1];
		tab2.valueCompareType[0] = 2;
		tab2.requiredValues[0] = requiredValues + 1;
		tab2.valueIndexArray = new int[1][3];
		tab2.valueIndexArray[0][0] = 2;
		tab2.valueIndexArray[0][1] = 5;
		tab2.valueIndexArray[0][2] = 0;
	}

	public static void addRuneText(int ID, int runeAmount, int RuneID,
			TextDrawingArea font[]) {
		RSInterface rsInterface = addTabInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 4;
		rsInterface.atActionType = 0;
		rsInterface.contentType = 0;
		rsInterface.width = 0;
		rsInterface.height = 14;
		rsInterface.mOverInterToTrigger = -1;
		rsInterface.valueCompareType = new int[1];
		rsInterface.requiredValues = new int[1];
		rsInterface.valueCompareType[0] = 3;
		rsInterface.requiredValues[0] = runeAmount - 1;
		rsInterface.valueIndexArray = new int[1][4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = RuneID;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.centerText = true;
		rsInterface.textDrawingAreas = font[0];
		rsInterface.textShadow = true;
		rsInterface.message = (new StringBuilder()).append("%1/")
				.append(runeAmount).append("").toString();
		rsInterface.disabledText = "";
		rsInterface.textColor = 0xc00000;
		rsInterface.anInt219 = 49152;
	}

	public static void addText(int i, String s, int k, boolean l, boolean m,
			int a, int j) {
		RSInterface rsinterface = addTabInterface(i);
		rsinterface.parentID = i;
		rsinterface.id = i;
		rsinterface.type = 4;
		rsinterface.atActionType = 0;
		rsinterface.width = 0;
		rsinterface.height = 0;
		rsinterface.contentType = 0;
		rsinterface.mOverInterToTrigger = a;
		rsinterface.centerText = l;
		rsinterface.textShadow = m;
		rsinterface.textDrawingAreas = fonts[j];
		rsinterface.message = s;
		rsinterface.textColor = k;
	}

	public static void addText(int i, String s, int k, boolean l, boolean m,
			int a, TextDrawingArea TDA[], int j) {
		RSInterface RSInterface = addInterface(i);
		RSInterface.parentID = i;
		RSInterface.id = i;
		RSInterface.type = 4;
		RSInterface.atActionType = 0;
		RSInterface.width = 0;
		RSInterface.height = 0;
		RSInterface.contentType = 0;
		RSInterface.mOverInterToTrigger = a;
		RSInterface.centerText = l;
		RSInterface.textShadow = m;
		RSInterface.textDrawingAreas = TDA[j];
		RSInterface.message = s;
		RSInterface.disabledText = "";
		RSInterface.textColor = k;
	}

	public static void addText(int id, String text, TextDrawingArea tda[],
			int idx, int color, boolean centered) {
		RSInterface rsi = interfaceCache[id] = new RSInterface();
		if (centered) {
			rsi.centerText = true;
		}
		rsi.textShadow = true;
		rsi.textDrawingAreas = tda[idx];
		rsi.message = text;
		rsi.textColor = color;
		rsi.id = id;
		rsi.type = 4;
	}

	public static void addText(int id, String text, TextDrawingArea tda[],
			int idx, int color, boolean center, boolean shadow) {
		RSInterface tab = addTabInterface(id);
		tab.parentID = id;
		tab.id = id;
		tab.type = 4;
		tab.atActionType = 0;
		tab.width = 0;
		tab.height = 11;
		tab.contentType = 0;
		tab.mOverInterToTrigger = -1;
		tab.centerText = center;
		tab.textShadow = shadow;
		tab.textDrawingAreas = tda[idx];
		tab.message = text;
		tab.disabledText = "";
		tab.textColor = color;
		tab.anInt219 = 0;
		tab.textHoverColour = 0;
		tab.anInt239 = 0;
	}

	public static void addToggleButton(int id, int sprite, int setconfig,
			int width, int height, String s) {
		RSInterface rsi = addInterface(id);
		rsi.sprite1 = CustomSpriteLoader(sprite, "");
		rsi.sprite2 = CustomSpriteLoader(sprite, "a");
		rsi.requiredValues = new int[1];
		rsi.requiredValues[0] = 1;
		rsi.valueCompareType = new int[1];
		rsi.valueCompareType[0] = 1;
		rsi.valueIndexArray = new int[1][3];
		rsi.valueIndexArray[0][0] = 5;
		rsi.valueIndexArray[0][1] = setconfig;
		rsi.valueIndexArray[0][2] = 0;
		rsi.atActionType = 4;
		rsi.width = width;
		rsi.mOverInterToTrigger = -1;
		rsi.parentID = id;
		rsi.id = id;
		rsi.type = 5;
		rsi.height = height;
		rsi.tooltip = s;
	}

	public static void addTooltip(int id, String text) {
		RSInterface rsinterface = addTabInterface(id);
		rsinterface.parentID = id;
		rsinterface.type = 0;
		rsinterface.isMouseoverTriggered = true;
		rsinterface.mOverInterToTrigger = -1;
		addTooltipBox(id + 1, text);
		rsinterface.totalChildren(1);
		rsinterface.child(0, id + 1, 0, 0);
	}

	public static void addTooltip(int id, String text, int H, int W) {
		RSInterface rsi = addTabInterface(id);
		rsi.id = id;
		rsi.type = 0;
		rsi.isMouseoverTriggered = true;
		rsi.mOverInterToTrigger = -1;
		addTooltipBox(id + 1, text);
		rsi.totalChildren(1);
		rsi.child(0, id + 1, 0, 0);
		rsi.height = H;
		rsi.width = W;
	}

	public static void addTooltipBox(int id, String text) {
		RSInterface rsi = addInterface(id);
		rsi.id = id;
		rsi.parentID = id;
		rsi.type = 9;
		rsi.message = text;
	}

	public static void constructLunar() {
		RSInterface Interface = addTabInterface(29999);
		setChildren(80, Interface);
		setBounds(30000, 11, 10, 0, Interface);
		setBounds(30017, 40, 9, 1, Interface);
		setBounds(30025, 71, 12, 2, Interface);
		setBounds(30032, 103, 10, 3, Interface);
		setBounds(30040, 135, 12, 4, Interface);
		setBounds(30048, 165, 10, 5, Interface);
		setBounds(30056, 8, 38, 6, Interface);
		setBounds(30064, 39, 39, 7, Interface);
		setBounds(30075, 71, 39, 8, Interface);
		setBounds(30083, 103, 39, 9, Interface);
		setBounds(30091, 135, 39, 10, Interface);
		setBounds(30099, 165, 37, 11, Interface);
		setBounds(30106, 12, 68, 12, Interface);
		setBounds(30114, 42, 68, 13, Interface);
		setBounds(30122, 71, 68, 14, Interface);
		setBounds(30130, 103, 68, 15, Interface);
		setBounds(30138, 135, 68, 16, Interface);
		setBounds(30146, 165, 68, 17, Interface);
		setBounds(30154, 14, 97, 18, Interface);
		setBounds(30162, 42, 97, 19, Interface);
		setBounds(30170, 71, 97, 20, Interface);
		setBounds(30178, 101, 97, 21, Interface);
		setBounds(30186, 135, 98, 22, Interface);
		setBounds(30194, 168, 98, 23, Interface);
		setBounds(30202, 11, 125, 24, Interface);
		setBounds(30210, 42, 124, 25, Interface);
		setBounds(30218, 74, 125, 26, Interface);
		setBounds(30226, 103, 125, 27, Interface);
		setBounds(30234, 135, 125, 28, Interface);
		setBounds(30242, 164, 126, 29, Interface);
		setBounds(30250, 10, 155, 30, Interface);
		setBounds(30258, 42, 155, 31, Interface);
		setBounds(30266, 71, 155, 32, Interface);
		setBounds(30274, 103, 155, 33, Interface);
		setBounds(30282, 136, 155, 34, Interface);
		setBounds(30290, 165, 155, 35, Interface);
		setBounds(30298, 13, 185, 36, Interface);
		setBounds(30306, 42, 185, 37, Interface);
		setBounds(30314, 71, 184, 38, Interface);
		setBounds(30322, 104, 184, 39, Interface);
		setBounds(30001, 6, 184, 40, Interface);
		setBounds(30018, 5, 176, 41, Interface);
		setBounds(30026, 5, 176, 42, Interface);
		setBounds(30033, 5, 163, 43, Interface);
		setBounds(30041, 5, 176, 44, Interface);
		setBounds(30049, 5, 176, 45, Interface);
		setBounds(30057, 5, 176, 46, Interface);
		setBounds(30065, 5, 176, 47, Interface);
		setBounds(30076, 5, 163, 48, Interface);
		setBounds(30084, 5, 176, 49, Interface);
		setBounds(30092, 5, 176, 50, Interface);
		setBounds(30100, 5, 176, 51, Interface);
		setBounds(30107, 5, 176, 52, Interface);
		setBounds(30115, 5, 163, 53, Interface);
		setBounds(30123, 5, 176, 54, Interface);
		setBounds(30131, 5, 163, 55, Interface);
		setBounds(30139, 5, 163, 56, Interface);
		setBounds(30147, 5, 163, 57, Interface);
		setBounds(30155, 5, 176, 58, Interface);
		setBounds(30163, 5, 176, 59, Interface);
		setBounds(30171, 5, 176, 60, Interface);
		setBounds(30179, 5, 163, 61, Interface);
		setBounds(30187, 5, 176, 62, Interface);
		setBounds(30195, 5, 149, 63, Interface);
		setBounds(30203, 5, 176, 64, Interface);
		setBounds(30211, 5, 163, 65, Interface);
		setBounds(30219, 5, 163, 66, Interface);
		setBounds(30227, 5, 176, 67, Interface);
		setBounds(30235, 5, 149, 68, Interface);
		setBounds(30243, 5, 176, 69, Interface);
		setBounds(30251, 5, 5, 70, Interface);
		setBounds(30259, 5, 5, 71, Interface);
		setBounds(30267, 5, 5, 72, Interface);
		setBounds(30275, 5, 5, 73, Interface);
		setBounds(30283, 5, 5, 74, Interface);
		setBounds(30291, 5, 5, 75, Interface);
		setBounds(30299, 5, 5, 76, Interface);
		setBounds(30307, 5, 5, 77, Interface);
		setBounds(30323, 5, 5, 78, Interface);
		setBounds(30315, 5, 5, 79, Interface);
	}

	public static void drawBlackBox(int xPos, int yPos) {
		DrawingArea.drawPixels(71, yPos - 1, xPos - 2, 0x726451, 1);
		DrawingArea.drawPixels(69, yPos, xPos + 174, 0x726451, 1);
		DrawingArea.drawPixels(1, yPos - 2, xPos - 2, 0x726451, 178);
		DrawingArea.drawPixels(1, yPos + 68, xPos, 0x726451, 174);
		DrawingArea.drawPixels(71, yPos - 1, xPos - 1, 0x2e2b23, 1);
		DrawingArea.drawPixels(71, yPos - 1, xPos + 175, 0x2e2b23, 1);
		DrawingArea.drawPixels(1, yPos - 1, xPos, 0x2e2b23, 175);
		DrawingArea.drawPixels(1, yPos + 69, xPos, 0x2e2b23, 175);
		DrawingArea.method335(0, yPos, 174, 68, 220, xPos);
	}

	public static void drawRune(int i, int id, String runeName) {
		RSInterface RSInterface = addTabInterface(i);
		RSInterface.type = 5;
		RSInterface.atActionType = 0;
		RSInterface.contentType = 0;
		RSInterface.opacity = 0;
		RSInterface.mOverInterToTrigger = 52;
		RSInterface.sprite1 = loadSprite(id, "Lunar/RUNE");
		RSInterface.width = 500;
		RSInterface.height = 500;
	}

	public static void homeTeleport() {
		RSInterface RSInterface = addTabInterface(30000);
		RSInterface.tooltip = "Open Loadstone Network";
		RSInterface.id = 30000;
		RSInterface.parentID = 30000;
		RSInterface.type = 5;
		RSInterface.atActionType = 5;
		RSInterface.contentType = 0;
		RSInterface.opacity = 0;
		RSInterface.mOverInterToTrigger = 30001;
		RSInterface.sprite1 = loadSprite(1, "Lunar/SPRITE");
		RSInterface.width = 20;
		RSInterface.height = 20;
		RSInterface hover = addTabInterface(30001);
		hover.mOverInterToTrigger = -1;
		hover.isMouseoverTriggered = true;
		setChildren(1, hover);
		addSprite(30002, 0, "Lunar/SPRITE");
		setBounds(30002, 0, 0, 0, hover);
	}

	@SuppressWarnings("unused")
	private static Sprite loadSprite(int i, String s) {
		Sprite sprite;
		try {
			sprite = new Sprite((new StringBuilder()).append(s).append(" ")
					.append(i).toString());
			if (sprite != null) {
				return sprite;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem loading sprites");
			return null;
		}
		return sprite;
	}

	public static void setBoundry(int frame, int ID, int X, int Y,
			RSInterface RSInterface) {
		RSInterface.children[frame] = ID;
		RSInterface.childX[frame] = X;
		RSInterface.childY[frame] = Y;
	}

	public static void setChildren(int total, RSInterface i) {
		i.children = new int[total];
		i.childX = new int[total];
		i.childY = new int[total];
	}

	// /~~~~~~~~~~~~~~~~~~~~~Variables
	// Section~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public String popupString;

	public String hoverText;

	public boolean drawsTransparent;

	public Sprite sprite1;

	public int anInt208;

	public Sprite sprites[];

	public static RSInterface interfaceCache[];

	public int requiredValues[];

	public int contentType;

	public int spritesX[];

	public int textHoverColour;

	public int atActionType;

	public String spellName;

	public int anInt219;

	public int width;

	public String tooltip;

	public String selectedActionName;

	public boolean centerText;

	public int scrollPosition;

	public String itemActions[];

	public int valueIndexArray[][];

	public boolean aBoolean227;

	public String disabledText;

	public int mOverInterToTrigger;

	public int invSpritePadX;

	public int textColor;

	public int anInt233;

	public int mediaID;

	public boolean aBoolean235;

	public int parentID;

	public int spellUsableOn;

	private static MRUNodes aMRUNodes_238;

	public int anInt239;

	public int children[];

	public int childX[];

	public boolean usableItemInterface;

	public TextDrawingArea textDrawingAreas;

	public int invSpritePadY;

	public int valueCompareType[];

	public int anInt246;

	public int spritesY[];

	public String message;

	public boolean isInventoryInterface;

	public int id;

	public int invStackSizes[];

	public int inv[];

	public byte opacity;

	private int anInt255;

	private int anInt256;

	public int anInt257;

	public int anInt258;

	public boolean aBoolean259;

	public Sprite sprite2;

	public int scrollMax;

	public int type;

	public int anInt263;

	private static final MRUNodes aMRUNodes_264 = new MRUNodes(30);

	public int anInt265;

	public boolean isMouseoverTriggered;

	public int height;

	public boolean textShadow;

	public int modelZoom;

	public int modelRotation1;

	public int modelRotation2;

	public int childY[];

	public int itemSpriteId1;

	public int itemSpriteId2;

	public int itemSpriteZoom1;

	public int itemSpriteZoom2;

	public int itemSpriteIndex;

	public boolean greyScale;

	public static TextDrawingArea fonts[];

	private static int summoningLevelRequirements[] = { 1, 4, 10, 13, 16, 17,
			18, 19, 22, 23, 25, 28, 29, 31, 32, 33, 34, 34, 34, 34, 36, 40, 41,
			42, 43, 43, 43, 43, 43, 43, 43, 46, 46, 47, 49, 52, 54, 55, 56, 56,
			57, 57, 57, 58, 61, 62, 63, 64, 66, 66, 67, 68, 69, 70, 71, 72, 73,
			74, 75, 76, 76, 77, 78, 79, 79, 79, 80, 83, 83, 85, 86, 88, 89, 92,
			93, 95, 96, 99 };

	private static int pouchItems[] = { 12047, 12043, 12059, 12019, 12009,
			12778, 12049, 12055, 12808, 12067, 12063, 12091, 12800, 12053,
			12065, 12021, 12818, 12780, 12798, 12814, 12073, 12087, 12071,
			12051, 12095, 12097, 12099, 12101, 12103, 12105, 12107, 12075,
			12816, 12041, 12061, 12007, 12035, 12027, 12077, 12531, 12810,
			12812, 12784, 12023, 12085, 12037, 12015, 12045, 12079, 12123,
			12031, 12029, 12033, 12820, 12057, 14623, 12792, 12069, 12011,
			12081, 12782, 12794, 12013, 12802, 12804, 12806, 12025, 12017,
			12788, 12776, 12083, 12039, 12786, 12089, 12796, 12822, 12093,
			12790 };

	private static int scrollItems[] = { 12425, 12445, 12428, 12459, 12533,
			12838, 12460, 12432, 12839, 12430, 12446, 12440, 12834, 12447,
			12433, 12429, 12443, 12443, 12443, 12443, 12461, 12431, 12422,
			12448, 12458, 12458, 12458, 12458, 12458, 12458, 12458, 12462,
			12829, 12426, 12444, 12441, 12454, 12453, 12463, 12424, 12835,
			12836, 12840, 12455, 12468, 12427, 12436, 12467, 12464, 12452,
			12439, 12438, 12423, 12830, 12451, 14622, 12826, 12449, 12450,
			12465, 12841, 12831, 12457, 12824, 12824, 12824, 12442, 12456,
			12837, 12832, 12466, 12434, 12833, 12437, 12827, 12828, 12435,
			12825 };

	private static String scrollNames[] = { "Howl", "Dreadfowl Strike",
			"Egg Spawn", "Slime Spray", "Stony Shell", "Pester",
			"Electric Lash", "Venom Shot", "Fireball Assault", "Cheese Feast",
			"Sandstorm", "Generate Compost", "Explode", "Vampire Touch",
			"Insane Ferocity", "Multichop", "Call of Arms", "Call of Arms",
			"Call of Arms", "Call of Arms", "Bronze Bull Rush", "Unburden",
			"Herbcall", "Evil Flames", "Petrifying gaze", "Petrifying gaze",
			"Petrifying gaze", "Petrifying gaze", "Petrifying gaze",
			"Petrifying gaze", "Petrifying gaze", "Iron Bull Rush",
			"Immense Heat", "Thieving Fingers", "Blood Drain", "Tireless Run",
			"Abyssal Drain", "Dissolve", "Steel Bull Rush", "Fish Rain",
			"Goad", "Ambush", "Rending", "Doomsphere Device", "Dust Cloud",
			"Abyssal Stealth", "Ophidian Incubation", "Poisonous Blast",
			"Mithril Bull Rush", "Toad Bark", "Testudo", "Swallow Whole",
			"Fruitfall", "Famine", "Arctic Blast", "Rise from the Ashes",
			"Volcanic Strength", "Crushing Claw", "Mantis Strike",
			"Adamant Bull Rush", "Inferno", "Deadly Claw", "Acorn Missile",
			"Titan's Consitution", "Titan's Consitution",
			"Titan's Consitution", "Regrowth", "Spike Shot", "Ebon Thunder",
			"Swamp Plague", "Rune Bull Rush", "Healing Aura", "Boil",
			"Magic Focus", "Essence Shipment", "Iron Within", "Winter Storage",
			"Steel of Legends" };

	private static String pouchNames[] = { "Spirit wolf", "Dreadfowl",
			"Spirit spider", "Thorny snail", "Granite crab", "Spirit mosquito",
			"Desert wyrm", "Spirit scorpion", "Spirit tz-kih", "Albino rat",
			"Spirit kalphite", "Compost mound", "Giant chinchompa",
			"Vampire bat", "Honey badger", "Beaver", "Void ravager",
			"Void spinner", "Void torcher", "Void shifter", "Bronze minotaur",
			"Bull ant", "Macaw", "Evil turnip", "Sp. cockatrice",
			"Sp. guthatrice", "Sp. saratrice", "Sp. zamatrice",
			"Sp. pengatrice", "Sp. coraxatrice", "Sp. vulatrice",
			"Iron minotaur", "Pyrelord", "Magpie", "Bloated leech",
			"Spirit terrorbird", "Abyssal parasite", "Spirit jelly",
			"Steel minotaur", "Ibis", "Spirit graahk", "Spirit kyatt",
			"Spirit larupia", "Karam. overlord", "Smoke devil",
			"Abyssal lurker", "Spirit cobra", "Stranger plant",
			"Mithril minotaur", "Barker toad", "War tortoise", "Bunyip",
			"Fruit bat", "Ravenous locust", "Arctic bear", "Phoenix",
			"Obsidian golem", "Granite lobster", "Praying mantis",
			"Adamant minotaur", "Forge regent", "Talon beast", "Giant ent",
			"Fire titan", "Moss titan", "Ice titan", "Hydra",
			"Spirit dagannoth", "Lava titan", "Swamp titan", "Rune minotaur",
			"Unicorn stallion", "Geyser titan", "Wolpertinger",
			"Abyssal titan", "Iron titan", "Pack yak", "Steel titan" };

	public static void addAura(int i) {
		RSInterface rsinterface = interfaceCache[i] = new RSInterface();
		rsinterface.itemActions = new String[5];
		rsinterface.spritesX = new int[20];
		rsinterface.invStackSizes = new int[30];
		rsinterface.inv = new int[30];
		rsinterface.spritesY = new int[20];
		rsinterface.children = new int[0];
		rsinterface.childX = new int[0];
		rsinterface.childY = new int[0];
		rsinterface.spritesY[0] = 0;
		rsinterface.spritesY[1] = 0;
		rsinterface.spritesY[2] = 0;
		rsinterface.spritesY[3] = 0;
		rsinterface.spritesY[4] = 0;
		rsinterface.spritesY[5] = 0;
		rsinterface.spritesY[6] = 0;
		rsinterface.spritesY[7] = 0;
		rsinterface.spritesY[8] = 0;
		rsinterface.spritesY[9] = 0;
		rsinterface.spritesY[10] = 0;
		rsinterface.spritesY[11] = 0;
		rsinterface.spritesY[12] = 0;
		rsinterface.spritesY[13] = 0;
		rsinterface.spritesY[14] = 0;
		rsinterface.spritesY[15] = 0;
		rsinterface.spritesY[16] = 0;
		rsinterface.spritesY[17] = 0;
		rsinterface.spritesY[18] = 0;
		rsinterface.spritesY[19] = 0;
		rsinterface.invStackSizes[0] = 0;
		rsinterface.invStackSizes[1] = 0;
		rsinterface.invStackSizes[2] = 0;
		rsinterface.invStackSizes[3] = 0;
		rsinterface.invStackSizes[4] = 0;
		rsinterface.invStackSizes[5] = 0;
		rsinterface.invStackSizes[6] = 0;
		rsinterface.invStackSizes[7] = 0;
		rsinterface.invStackSizes[8] = 0;
		rsinterface.invStackSizes[9] = 0;
		rsinterface.invStackSizes[10] = 0;
		rsinterface.invStackSizes[11] = 0;
		rsinterface.invStackSizes[12] = 0;
		rsinterface.invStackSizes[13] = 0;
		rsinterface.invStackSizes[14] = 0;
		rsinterface.invStackSizes[15] = 0;
		rsinterface.invStackSizes[16] = 0;
		rsinterface.invStackSizes[17] = 0;
		rsinterface.invStackSizes[18] = 0;
		rsinterface.invStackSizes[19] = 0;
		rsinterface.invStackSizes[20] = 0;
		rsinterface.invStackSizes[21] = 0;
		rsinterface.invStackSizes[22] = 0;
		rsinterface.invStackSizes[23] = 0;
		rsinterface.invStackSizes[24] = 0;
		rsinterface.invStackSizes[25] = 0;
		rsinterface.invStackSizes[26] = 0;
		rsinterface.invStackSizes[27] = 0;
		rsinterface.invStackSizes[28] = 0;
		rsinterface.invStackSizes[29] = 0;
		rsinterface.inv[0] = 0;
		rsinterface.inv[1] = 0;
		rsinterface.inv[2] = 0;
		rsinterface.inv[3] = 0;
		rsinterface.inv[4] = 0;
		rsinterface.inv[5] = 0;
		rsinterface.inv[6] = 0;
		rsinterface.inv[7] = 0;
		rsinterface.inv[8] = 0;
		rsinterface.inv[9] = 0;
		rsinterface.inv[10] = 0;
		rsinterface.inv[11] = 0;
		rsinterface.inv[12] = 0;
		rsinterface.inv[13] = 0;
		rsinterface.inv[14] = 0;
		rsinterface.inv[15] = 0;
		rsinterface.inv[16] = 0;
		rsinterface.inv[17] = 0;
		rsinterface.inv[18] = 0;
		rsinterface.inv[19] = 0;
		rsinterface.inv[20] = 0;
		rsinterface.inv[21] = 0;
		rsinterface.inv[22] = 0;
		rsinterface.inv[23] = 0;
		rsinterface.inv[24] = 0;
		rsinterface.inv[25] = 0;
		rsinterface.inv[26] = 0;
		rsinterface.inv[27] = 0;
		rsinterface.inv[28] = 0;
		rsinterface.inv[29] = 0;
		rsinterface.spritesX[0] = 0;
		rsinterface.spritesX[1] = 0;
		rsinterface.spritesX[2] = 0;
		rsinterface.spritesX[3] = 0;
		rsinterface.spritesX[4] = 0;
		rsinterface.spritesX[5] = 0;
		rsinterface.spritesX[6] = 0;
		rsinterface.spritesX[7] = 0;
		rsinterface.spritesX[8] = 0;
		rsinterface.spritesX[9] = 0;
		rsinterface.spritesX[10] = 0;
		rsinterface.spritesX[11] = 0;
		rsinterface.spritesX[12] = 0;
		rsinterface.spritesX[13] = 0;
		rsinterface.spritesX[14] = 0;
		rsinterface.spritesX[15] = 0;
		rsinterface.spritesX[16] = 0;
		rsinterface.spritesX[17] = 0;
		rsinterface.spritesX[18] = 0;
		rsinterface.spritesX[19] = 0;
		rsinterface.itemActions[0] = null;
		rsinterface.itemActions[1] = null;
		rsinterface.itemActions[2] = null;
		rsinterface.itemActions[3] = null;
		rsinterface.itemActions[4] = null;
		rsinterface.centerText = false;
		rsinterface.aBoolean227 = false;
		rsinterface.aBoolean235 = false;
		rsinterface.usableItemInterface = false;
		rsinterface.isInventoryInterface = false;
		rsinterface.aBoolean259 = true;
		rsinterface.textShadow = false;
		rsinterface.width = 6;
		rsinterface.invSpritePadX = 24;
		rsinterface.parentID = 10794;
		rsinterface.invSpritePadY = 24;
		rsinterface.type = 2;
		rsinterface.height = 5;
	}

	public static void addBankHover(int interfaceID, int actionType,
			int hoverid, int spriteId, int spriteId2, String NAME, int Width,
			int Height, int configFrame, int configId, String Tooltip,
			int hoverId2, int hoverSpriteId, int hoverSpriteId2,
			String hoverSpriteName, int hoverId3, String hoverDisabledText,
			String hoverEnabledText, int X, int Y) {
		RSInterface hover = addTabInterface(interfaceID);
		hover.id = interfaceID;
		hover.parentID = interfaceID;
		hover.type = 5;
		hover.atActionType = actionType;
		hover.contentType = 0;
		hover.opacity = 0;
		hover.mOverInterToTrigger = hoverid;
		hover.sprite1 = imageLoader(spriteId, NAME);
		hover.sprite2 = imageLoader(spriteId2, NAME);
		hover.width = Width;
		hover.tooltip = Tooltip;
		hover.height = Height;
		hover.valueCompareType = new int[1];
		hover.requiredValues = new int[1];
		hover.valueCompareType[0] = 1;
		hover.requiredValues[0] = configId;
		hover.valueIndexArray = new int[1][3];
		hover.valueIndexArray[0][0] = 5;
		hover.valueIndexArray[0][1] = configFrame;
		hover.valueIndexArray[0][2] = 0;
		hover = addTabInterface(hoverid);
		hover.parentID = hoverid;
		hover.id = hoverid;
		hover.type = 0;
		hover.atActionType = 0;
		hover.width = 550;
		hover.height = 334;
		hover.isMouseoverTriggered = true;
		hover.mOverInterToTrigger = -1;
		addSprite(hoverId2, hoverSpriteId, hoverSpriteId2, hoverSpriteName,
				configId, configFrame);
		addHoverBox(hoverId3, interfaceID, hoverDisabledText, hoverEnabledText,
				configId, configFrame);
		setChildren(2, hover);
		setBounds(hoverId2, 15, 60, 0, hover);
		setBounds(hoverId3, X, Y, 1, hover);
	}

	public static void addBankHover1(int interfaceID, int actionType,
			int hoverid, int spriteId, String NAME, int Width, int Height,
			String Tooltip, int hoverId2, int hoverSpriteId,
			String hoverSpriteName, int hoverId3, String hoverDisabledText,
			int X, int Y) {
		RSInterface hover = addTabInterface(interfaceID);
		hover.id = interfaceID;
		hover.parentID = interfaceID;
		hover.type = 5;
		hover.atActionType = actionType;
		hover.contentType = 0;
		hover.opacity = 0;
		hover.mOverInterToTrigger = hoverid;
		hover.sprite1 = imageLoader(spriteId, NAME);
		hover.width = Width;
		hover.tooltip = Tooltip;
		hover.height = Height;
		hover = addTabInterface(hoverid);
		hover.parentID = hoverid;
		hover.id = hoverid;
		hover.type = 0;
		hover.atActionType = 0;
		hover.width = 550;
		hover.height = 334;
		hover.isMouseoverTriggered = true;
		hover.mOverInterToTrigger = -1;
		addSprite(hoverId2, hoverSpriteId, hoverSpriteId, hoverSpriteName, 0, 0);
		addHoverBox(hoverId3, interfaceID, hoverDisabledText,
				hoverDisabledText, 0, 0);
		setChildren(2, hover);
		setBounds(hoverId2, 15, 60, 0, hover);
		setBounds(hoverId3, X, Y, 1, hover);
	}

	public static void addButton(int i, int j, int hoverId, String name, int W,
			int H, String S, int AT) {
		RSInterface RSInterface = addInterface(i);
		RSInterface.id = i;
		RSInterface.parentID = i;
		RSInterface.type = 5;
		RSInterface.atActionType = AT;
		RSInterface.opacity = 0;
		RSInterface.mOverInterToTrigger = hoverId;
		RSInterface.sprite1 = imageLoader(j, name);
		RSInterface.sprite2 = imageLoader(j, name);
		RSInterface.width = W;
		RSInterface.height = H;
		RSInterface.tooltip = S;
	}

	public static void addButton(int id, int sid, String spriteName,
			String tooltip, int mOver, int atAction, int width, int height) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = atAction;
		tab.contentType = 0;
		tab.opacity = 0;
		tab.mOverInterToTrigger = mOver;
		tab.sprite1 = imageLoader(sid, spriteName);
		tab.sprite2 = imageLoader(sid, spriteName);
		tab.width = width;
		tab.height = height;
		tab.tooltip = tooltip;
		// tab.inventoryhover = true;
	}

	public static void addCardSprite(int startID, int endID, String suit) { // summon
																			// pouch
																			// creation
		int count = 0;
		String spriteId;
		for (int i = startID; i <= endID; i++) {
			if (count == 0) {
				spriteId = "A";
			} else if (count == 11) {
				spriteId = "J";
			} else if (count == 12) {
				spriteId = "Q";
			} else if (count == 13) {
				spriteId = "K";
			} else {
				spriteId = count + "";
			}
			RSInterface tab = interfaceCache[i] = new RSInterface();
			tab.id = i;
			tab.parentID = i;
			tab.type = 5;
			tab.atActionType = 0;
			tab.contentType = 0;
			tab.opacity = 0;
			tab.mOverInterToTrigger = 52;
			tab.sprite1 = cardImageLoader(spriteId, "Monsterray/Playing cards",
					suit);
			tab.sprite2 = cardImageLoader(spriteId, "Monsterray/Playing cards",
					suit);
			tab.width = 512;
			tab.height = 334;
			count++;
		}
	}

	public static void addChar(int ID) {
		RSInterface t = interfaceCache[ID] = new RSInterface();
		t.id = ID;
		t.parentID = ID;
		t.type = 6;
		t.atActionType = 0;
		t.contentType = 328;
		t.width = 136;
		t.height = 168;
		t.opacity = 0;
		t.mOverInterToTrigger = 0;
		t.modelZoom = 560;
		t.modelRotation1 = 150;
		t.modelRotation2 = 0;
		t.anInt257 = -1;
		t.anInt258 = -1;
	}

	public static void addHDHoverButton(int i, String imageName, int j,
			int width, int height, String text, int contentType, int hoverOver,
			int aT) {// hoverable button
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = i;
		tab.type = 12;
		tab.atActionType = aT;
		tab.contentType = contentType;
		tab.mOverInterToTrigger = hoverOver;
		tab.sprite1 = imageLoader(j, imageName);
		tab.sprite2 = imageLoader(j, imageName);
		tab.width = width;
		tab.height = height;
		tab.tooltip = text;
	}

	public static void addHDHoveredButton(int i, String imageName, int j,
			int w, int h, int IMAGEID) {// hoverable button
		RSInterface tab = addTabInterface(i);
		tab.parentID = i;
		tab.id = i;
		tab.type = 0;
		tab.atActionType = 0;
		tab.width = w;
		tab.height = h;
		tab.isMouseoverTriggered = true;
		tab.mOverInterToTrigger = -1;
		tab.scrollMax = 0;
		addHDHoverImage(IMAGEID, j, j, imageName);
		tab.totalChildren(1);
		tab.child(0, IMAGEID, 0, 0);
	}

	public static void addHDHoverImage(int i, int j, int k, String name) {
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = i;
		tab.type = 12;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.width = 512;
		tab.height = 334;
		tab.mOverInterToTrigger = 52;
		tab.sprite1 = imageLoader(j, name);
		tab.sprite2 = imageLoader(k, name);
	}

	private static void addHead2(int id, int w, int h, int zoom) { // tewst
		RSInterface rsinterface = addInterface(id);
		rsinterface.type = 6;
		rsinterface.anInt233 = 2;
		rsinterface.mediaID = 4000;//
		rsinterface.modelZoom = zoom;
		rsinterface.modelRotation1 = 40;// 40;//wait
		rsinterface.modelRotation2 = 1900;// 1900;
		rsinterface.height = h;
		rsinterface.width = w;
	}

	public static void addHover(int i, int aT, int contentType, int hoverOver,
			int sId, String imageName, int width, int height, String text) {
		addHoverButton(i, imageName, sId, width, height, text, contentType,
				hoverOver, aT);
	}

	public static void addHoverBox(int id, int ParentID, String text,
			String text2, int configId, int configFrame) {
		RSInterface rsi = addTabInterface(id);
		rsi.id = id;
		rsi.parentID = ParentID;
		rsi.type = 8;
		rsi.disabledText = text;
		rsi.message = text2;
		rsi.valueCompareType = new int[1];
		rsi.requiredValues = new int[1];
		rsi.valueCompareType[0] = 1;
		rsi.requiredValues[0] = configId;
		rsi.valueIndexArray = new int[1][3];
		rsi.valueIndexArray[0][0] = 5;
		rsi.valueIndexArray[0][1] = configFrame;
		rsi.valueIndexArray[0][2] = 0;
	}

	public static void addHoverButton(int ID, String imageName, int imageId,
			int width, int height, String toolText, int contentType,
			int hoverOver, int aT) {
		RSInterface tab = addTabInterface(ID);
		tab.id = ID;
		tab.parentID = ID;
		tab.type = 5;
		tab.atActionType = aT;
		tab.contentType = contentType;
		tab.opacity = 0;
		tab.mOverInterToTrigger = hoverOver;
		tab.sprite1 = imageLoader(imageId, imageName);
		tab.sprite2 = imageLoader(imageId, imageName);
		tab.width = width;
		tab.height = height;
		tab.tooltip = toolText;
	}

	public static void addHovered(int i, int j, String imageName, int w, int h,
			int IMAGEID) {
		addHoveredButton(i, imageName, j, w, h, IMAGEID);
	}

	public static void addHoveredButton(int ID, String imageName, int spriteId,
			int width, int height, int IMAGEID) {
		RSInterface tab = addTabInterface(ID);
		tab.parentID = ID;
		tab.id = ID;
		tab.type = 0;
		tab.atActionType = 0;
		tab.width = width;
		tab.height = height;
		tab.isMouseoverTriggered = true;
		tab.opacity = 0;
		tab.mOverInterToTrigger = -1;
		tab.scrollMax = 0;
		addHoverImage(IMAGEID, spriteId, spriteId, imageName);
		tab.totalChildren(1);
		tab.child(0, IMAGEID, 0, 0);
	}

	public static void addHoverImage(int imageChildId, int spriteId,
			int spriteId2, String name) {
		RSInterface tab = addTabInterface(imageChildId);
		tab.id = imageChildId;
		tab.parentID = imageChildId;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.width = 512;
		tab.height = 334;
		tab.opacity = 0;
		tab.mOverInterToTrigger = 52;
		tab.sprite1 = imageLoader(spriteId, name);
		tab.sprite2 = imageLoader(spriteId2, name);
	}

	public static void addHoverText(int id, String text, String tooltip,
			TextDrawingArea tda[], int idx, int color, boolean center,
			boolean textShadow, int width) {
		RSInterface rsinterface = addInterface(id);
		rsinterface.id = id;
		rsinterface.parentID = id;
		rsinterface.type = 4;
		rsinterface.atActionType = 1;
		rsinterface.width = width;
		rsinterface.height = 11;
		rsinterface.contentType = 0;
		rsinterface.opacity = 0;
		rsinterface.mOverInterToTrigger = -1;
		rsinterface.centerText = center;
		rsinterface.textShadow = textShadow;
		rsinterface.textDrawingAreas = tda[idx];
		rsinterface.message = text;
		// rsinterface.aString228 = "";
		rsinterface.textColor = color;
		rsinterface.anInt219 = 0;
		// rsinterface.anInt216 = 0xffffff;
		rsinterface.anInt239 = 0;
		rsinterface.tooltip = tooltip;
	}

	public static RSInterface addInterface(int id) {
		RSInterface rsi = interfaceCache[id] = new RSInterface();
		rsi.id = id;
		rsi.parentID = id;
		rsi.width = 512;
		rsi.height = 334;
		return rsi;
	}

	public static void addPouch(int ID, int r1[], int ra1, int r2, int lvl,
			String name, TextDrawingArea TDA[], int imageID, int type) {
		RSInterface rsInterface = addTabInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.mOverInterToTrigger = ID + 1;
		rsInterface.width = 32;
		rsInterface.height = 32;
		rsInterface.tooltip = (new StringBuilder()).append("Infuse @or1@")
				.append(name).toString();
		rsInterface.spellName = name;
		rsInterface.valueCompareType = new int[2];
		rsInterface.requiredValues = new int[2];
		rsInterface.valueCompareType[0] = 3;
		rsInterface.requiredValues[0] = ra1;
		rsInterface.valueCompareType[1] = 3;
		rsInterface.requiredValues[1] = lvl - 1;
		rsInterface.valueIndexArray = new int[2 + r1.length][];
		for (int i = 0; i < r1.length; i++) {
			rsInterface.valueIndexArray[i] = new int[4];
			rsInterface.valueIndexArray[i][0] = 4;
			rsInterface.valueIndexArray[i][1] = 3214;
			rsInterface.valueIndexArray[i][2] = r1[i];
			rsInterface.valueIndexArray[i][3] = 0;
		}
		rsInterface.valueIndexArray[1] = new int[3];
		rsInterface.valueIndexArray[1][0] = 1;
		rsInterface.valueIndexArray[1][1] = 6;
		rsInterface.valueIndexArray[1][2] = 0;
		rsInterface.itemSpriteId1 = r2;
		rsInterface.itemSpriteId2 = r2;
		rsInterface.itemSpriteIndex = imageID;
		rsInterface.greyScale = true;
		RSInterface hover = addTabInterface(ID + 1);
		hover.mOverInterToTrigger = -1;
		hover.isMouseoverTriggered = true;
		setChildren(5, hover);
		addSprite(ID + 2, 0, "Lunar/BOX");
		addText(ID + 3, (new StringBuilder()).append("Level ").append(lvl)
				.append(": ").append(name).toString(), 0xff981f, true, true,
				52, 1);
		addText(ID + 4, "This item requires", 0xaf6a1a, true, true, 52, 0);
		addRuneText(ID + 5, ra1, r1[0], TDA);
		addSprite(ID + 6, r1[0], null);
		addSprite(ID + 7, r1[1], null);
		addSprite(ID + 8, r1[2], null);
		setBounds(ID + 2, 0, 0, 0, hover);
		setBounds(ID + 3, 90, 4, 1, hover);
		setBounds(ID + 4, 90, 19, 2, hover);
		setBounds(ID + 5, 87, 66, 3, hover);
		setBounds(ID + 6, 14, 33, 4, hover);
	}

	public static void addPrayer(int i, int configId, int configFrame,
			int requiredValues, int prayerSpriteID, String PrayerName, int Hover) {
		// START OF FIX BY GABBE
		RSInterface Interface = addTabInterface(i);
		Interface.id = i;
		Interface.parentID = 22500;
		Interface.type = 5;
		Interface.atActionType = 4;
		Interface.contentType = 0;
		Interface.opacity = 0;
		Interface.mOverInterToTrigger = Hover;
		Interface.sprite1 = imageLoader(0, "CurseTab/GLOW");
		Interface.sprite2 = imageLoader(1, "CurseTab/GLOW");
		Interface.width = 34;
		Interface.height = 34;
		Interface.valueCompareType = new int[1];
		Interface.requiredValues = new int[1];
		Interface.valueCompareType[0] = 1;
		Interface.requiredValues[0] = configId;
		Interface.valueIndexArray = new int[1][3];
		Interface.valueIndexArray[0][0] = 5;
		Interface.valueIndexArray[0][1] = configFrame;
		Interface.valueIndexArray[0][2] = 0;
		Interface.tooltip = "Activate@or1@ " + PrayerName;
		Interface = addTabInterface(i + 1);
		Interface.id = i + 1;
		Interface.parentID = 22500;
		Interface.type = 5;
		Interface.atActionType = 0;
		Interface.contentType = 0;
		Interface.opacity = 0;
		Interface.sprite1 = imageLoader(prayerSpriteID, "CurseTab/PRAYON");
		Interface.sprite2 = imageLoader(prayerSpriteID, "CurseTab/PRAYOFF");
		Interface.width = 34;
		Interface.height = 34;
		Interface.valueCompareType = new int[1];
		Interface.requiredValues = new int[1];
		Interface.valueCompareType[0] = 2;
		Interface.requiredValues[0] = requiredValues + 1;
		Interface.valueIndexArray = new int[1][3];
		Interface.valueIndexArray[0][0] = 2;
		Interface.valueIndexArray[0][1] = 5;
		Interface.valueIndexArray[0][2] = 0;
	}

	public static void addPrayer2(int i, int configId, int configFrame,
			int requiredValues, int prayerSpriteID, String PrayerName, int Hover) {
		RSInterface Interface = addTabInterface(i);
		Interface.id = i;
		Interface.parentID = 22500;
		Interface.type = 5;
		Interface.atActionType = 4;
		Interface.contentType = 0;
		Interface.opacity = 0;
		Interface.mOverInterToTrigger = Hover;
		Interface.sprite1 = imageLoader(0, "Curses/GLOW");
		Interface.sprite2 = imageLoader(1, "Curses/GLOW");
		Interface.width = 34;
		Interface.height = 34;
		Interface.valueCompareType = new int[1];
		Interface.requiredValues = new int[1];
		Interface.valueCompareType[0] = 1;
		Interface.requiredValues[0] = configId;
		Interface.valueIndexArray = new int[1][3];
		Interface.valueIndexArray[0][0] = 5;
		Interface.valueIndexArray[0][1] = configFrame;
		Interface.valueIndexArray[0][2] = 0;
		Interface.tooltip = (new StringBuilder()).append("Activate@lre@ ")
				.append(PrayerName).toString();
		Interface = addTabInterface(i + 1);
		Interface.id = i + 1;
		Interface.parentID = 22500;
		Interface.type = 5;
		Interface.atActionType = 0;
		Interface.contentType = 0;
		Interface.opacity = 0;
		Interface.sprite1 = imageLoader(prayerSpriteID, "Curses/PRAYON");
		Interface.sprite2 = imageLoader(prayerSpriteID, "Curses/PRAYOFF");
		Interface.width = 34;
		Interface.height = 34;
		Interface.valueCompareType = new int[1];
		Interface.requiredValues = new int[1];
		Interface.valueCompareType[0] = 2;
		Interface.requiredValues[0] = requiredValues + 1;
		Interface.valueIndexArray = new int[1][3];
		Interface.valueIndexArray[0][0] = 2;
		Interface.valueIndexArray[0][1] = 5;
		Interface.valueIndexArray[0][2] = 0;
	}

	public static void addPrayerWithTooltip(int i, int configId,
			int configFrame, int requiredValues, int prayerSpriteID, int Hover,
			String tooltip) {
		RSInterface Interface = addTabInterface(i);
		Interface.id = i;
		Interface.parentID = 5608;
		Interface.type = 5;
		Interface.atActionType = 4;
		Interface.contentType = 0;
		Interface.opacity = 0;
		Interface.mOverInterToTrigger = Hover;
		Interface.sprite1 = imageLoader(0, "Interfaces/PrayerTab/PRAYERGLOW");
		Interface.sprite2 = imageLoader(1, "Interfaces/PrayerTab/PRAYERGLOW");
		Interface.width = 34;
		Interface.height = 34;
		Interface.valueCompareType = new int[1];
		Interface.requiredValues = new int[1];
		Interface.valueCompareType[0] = 1;
		Interface.requiredValues[0] = configId;
		Interface.valueIndexArray = new int[1][3];
		Interface.valueIndexArray[0][0] = 5;
		Interface.valueIndexArray[0][1] = configFrame;
		Interface.valueIndexArray[0][2] = 0;
		Interface.tooltip = tooltip;
		Interface = addTabInterface(i + 1);
		Interface.id = i + 1;
		Interface.parentID = 5608;
		Interface.type = 5;
		Interface.atActionType = 0;
		Interface.contentType = 0;
		Interface.opacity = 0;
		Interface.sprite1 = imageLoader(prayerSpriteID,
				"Interfaces/PrayerTab/PRAYERON");
		Interface.sprite2 = imageLoader(prayerSpriteID,
				"Interfaces/PrayerTab/PRAYEROFF");
		Interface.width = 34;
		Interface.height = 34;
		Interface.valueCompareType = new int[1];
		Interface.requiredValues = new int[1];
		Interface.valueCompareType[0] = 2;
		Interface.requiredValues[0] = requiredValues + 1;
		Interface.valueIndexArray = new int[1][3];
		Interface.valueIndexArray[0][0] = 2;
		Interface.valueIndexArray[0][1] = 5;
		Interface.valueIndexArray[0][2] = 0;
	}

	public static RSInterface addScreenInterface(int id) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 0;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.width = 512;
		tab.height = 334;
		tab.opacity = 0;
		tab.mOverInterToTrigger = -1;
		return tab;
	}

	public static void addScroll(int ID, int r1, int ra1, int r2, int lvl,
			String name, TextDrawingArea TDA[], int imageID, int type) {
		RSInterface rsInterface = addTabInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.mOverInterToTrigger = ID + 1;
		rsInterface.width = 32;
		rsInterface.height = 32;
		rsInterface.tooltip = (new StringBuilder()).append("Transform @or1@")
				.append(name).toString();
		rsInterface.spellName = name;
		rsInterface.valueCompareType = new int[2];
		rsInterface.requiredValues = new int[2];
		rsInterface.valueCompareType[0] = 3;
		rsInterface.requiredValues[0] = ra1;
		rsInterface.valueCompareType[1] = 3;
		rsInterface.requiredValues[1] = lvl - 1;
		rsInterface.valueIndexArray = new int[3][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[3];
		rsInterface.valueIndexArray[1][0] = 1;
		rsInterface.valueIndexArray[1][1] = 6;
		rsInterface.valueIndexArray[1][2] = 0;
		rsInterface.itemSpriteId1 = r2;
		rsInterface.itemSpriteId2 = r2;
		rsInterface.itemSpriteIndex = imageID;
		rsInterface.greyScale = true;
		RSInterface hover = addTabInterface(ID + 1);
		hover.mOverInterToTrigger = -1;
		hover.isMouseoverTriggered = true;
		setChildren(5, hover);
		addSprite(ID + 2, 0, "Lunar/BOX");
		addText(ID + 3, (new StringBuilder()).append("Level ").append(lvl)
				.append(": ").append(name).toString(), 0xff981f, true, true,
				52, 1);
		addText(ID + 4, "This item requires", 0xaf6a1a, true, true, 52, 0);
		addRuneText(ID + 5, ra1, r1, TDA);
		addSprite(ID + 6, r1, null);
		setBounds(ID + 2, 0, 0, 0, hover);
		setBounds(ID + 3, 90, 4, 1, hover);
		setBounds(ID + 4, 90, 19, 2, hover);
		setBounds(ID + 5, 87, 66, 3, hover);
		setBounds(ID + 6, 72, 33, 4, hover);
	}

	public static void addSprite(int i, int j, int k) {
		RSInterface rsinterface = interfaceCache[i] = new RSInterface();
		rsinterface.id = i;
		rsinterface.parentID = i;
		rsinterface.type = 5;
		rsinterface.atActionType = 1;
		rsinterface.contentType = 0;
		rsinterface.width = 20;
		rsinterface.height = 20;
		rsinterface.opacity = 0;
		rsinterface.mOverInterToTrigger = 52;
		rsinterface.sprite1 = imageLoader(j, "Interfaces/Equipment/SPRITE");
		rsinterface.sprite2 = imageLoader(k, "Interfaces/Equipment/SPRITE");
	}

	public static void addSprite(int ID, int i, int i2, String name,
			int configId, int configFrame) {
		RSInterface Tab = addTabInterface(ID);
		Tab.id = ID;
		Tab.parentID = ID;
		Tab.type = 5;
		Tab.atActionType = 0;
		Tab.contentType = 0;
		Tab.width = 512;
		Tab.height = 334;
		Tab.opacity = 0;
		Tab.mOverInterToTrigger = -1;
		Tab.valueCompareType = new int[1];
		Tab.requiredValues = new int[1];
		Tab.valueCompareType[0] = 1;
		Tab.requiredValues[0] = configId;
		Tab.valueIndexArray = new int[1][3];
		Tab.valueIndexArray[0][0] = 5;
		Tab.valueIndexArray[0][1] = configFrame;
		Tab.valueIndexArray[0][2] = 0;
		if (name == null) {
			Tab.itemSpriteZoom1 = -1;
			Tab.itemSpriteId1 = i;
			Tab.itemSpriteZoom2 = 70;
			Tab.itemSpriteId2 = i2;
		} else {
			Tab.sprite1 = imageLoader(i, name);
			Tab.sprite2 = imageLoader(i2, name);
		}
	}

	public static void addSprite(int id, int spriteId, String spriteName) {
		addSprite(id, spriteId, spriteName, -1, -1);
	}

	public static void addSprite(int id, int spriteId, String spriteName,
			int zoom1, int zoom2) { // summon pouch creation
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.opacity = 0;
		tab.mOverInterToTrigger = 52;
		if (spriteName == null) {
			tab.itemSpriteZoom1 = zoom1;
			tab.itemSpriteId1 = spriteId;
			tab.itemSpriteZoom2 = zoom2;
			tab.itemSpriteId2 = spriteId;
		} else {
			tab.sprite1 = imageLoader(spriteId, spriteName);
			tab.sprite2 = imageLoader(spriteId, spriteName);
		}
		tab.width = 512;
		tab.height = 334;
	}

	public static void addSpriteWithHover(int id, int spriteId,
			String spriteName, int hover) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.opacity = (byte) 0;
		tab.type = hover;
		tab.sprite1 = imageLoader(spriteId, spriteName);
		tab.sprite2 = imageLoader(spriteId, spriteName);
		tab.width = 190;
		tab.height = 47;
	}

	public static RSInterface addTabInterface(int id) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 0;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.width = 512;
		tab.height = 700;
		tab.opacity = 0;
		tab.mOverInterToTrigger = -1;
		return tab;
	}

	public static void addText(int id, String text, TextDrawingArea wid[],
			int idx, int color) {
		RSInterface rsinterface = addTabInterface(id);
		rsinterface.id = id;
		rsinterface.parentID = id;
		rsinterface.type = 4;
		rsinterface.atActionType = 0;
		rsinterface.width = 174;
		rsinterface.height = 11;
		rsinterface.contentType = 0;
		rsinterface.opacity = 0;
		rsinterface.mOverInterToTrigger = -1;
		rsinterface.centerText = false;
		rsinterface.textShadow = true;
		rsinterface.textDrawingAreas = wid[idx];
		rsinterface.message = text;
		rsinterface.textColor = color;
	}

	public static void addTransparentSprite(int id, int spriteId,
			String spriteName, int op) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 10;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.mOverInterToTrigger = 52;
		tab.sprite1 = imageLoader(spriteId, spriteName);
		tab.sprite2 = imageLoader(spriteId, spriteName);
		tab.width = 512;
		tab.height = 334;
		tab.opacity = (byte) op;
		tab.drawsTransparent = true;
	}

	public static void ancientMagicTab(TextDrawingArea tda[]) {
		RSInterface tab = addInterface(12855);
		addButton(12856, 1, "Magic/Home", "Cast @gre@Home Teleport");
		RSInterface homeButton = interfaceCache[12856];
		homeButton.mOverInterToTrigger = 1196;
		int itfChildren[] = { 12856, 12939, 12987, 13035, 12901, 12861, 13045,
				12963, 13011, 13053, 12919, 12881, 13061, 12951, 12999, 13069,
				12911, 12871, 13079, 12975, 13023, 13087, 12929, 12891, 13095,
				1196, 12940, 12988, 13036, 12902, 12862, 13046, 12964, 13012,
				13054, 12920, 12882, 13062, 12952, 13000, 13070, 12912, 12872,
				13080, 12976, 13024, 13088, 12930, 12892, 13096 };
		tab.totalChildren(itfChildren.length);
		int i1 = 0;
		int xPos = 18;
		int yPos = 8;
		while (i1 < itfChildren.length) {
			if (xPos > 175) {
				xPos = 18;
				yPos += 28;
			}
			if (i1 < 25) {
				tab.child(i1, itfChildren[i1], xPos, yPos);
			}
			if (i1 > 24) {
				yPos = i1 >= 41 ? 1 : 181;
				tab.child(i1, itfChildren[i1], 4, yPos);
			}
			i1++;
			xPos += 45;
		}
	}

	public static void Bank() {
		RSInterface Interface = addTabInterface(5292);
		setChildren(19, Interface);
		addSprite(5293, 0, "Bank/BANK");
		setBounds(5293, 13, 13, 0, Interface);
		addHover(5384, 3, 0, 5380, 1, "Bank/BANK", 17, 17, "Close Window");
		addHovered(5380, 2, "Bank/BANK", 17, 17, 5379);
		setBounds(5384, 476, 16, 3, Interface);
		setBounds(5380, 476, 16, 4, Interface);
		addHover(5294, 4, 0, 5295, 3, "Bank/BANK", 114, 25, "Set A Bank PIN");
		addHovered(5295, 4, "Bank/BANK", 114, 25, 5296);
		setBounds(5294, 110, 285, 5, Interface);
		setBounds(5295, 110, 285, 6, Interface);
		addBankHover(21000, 4, 21001, 5, 8, "Bank/BANK", 35, 25, 304, 1,
				"Swap Withdraw Mode", 21002, 7, 6, "Bank/BANK", 21003,
				"Switch to insert items \nmode",
				"Switch to swap items \nmode.", 12, 20);
		setBounds(21000, 25, 285, 7, Interface);
		setBounds(21001, 10, 225, 8, Interface);
		addBankHover(21004, 4, 21005, 13, 15, "Bank/BANK", 35, 25, 0, 1,
				"Search", 21006, 14, 16, "Bank/BANK", 21007,
				"Click here to search your \nbank",
				"Click here to search your \nbank", 12, 20);
		setBounds(21004, 65, 285, 9, Interface);
		setBounds(21005, 50, 225, 10, Interface);
		addBankHover(21008, 4, 21009, 9, 11, "Bank/BANK", 35, 25, 115, 1,
				"Search", 21010, 10, 12, "Bank/BANK", 21011,
				"Switch to note withdrawal \nmode",
				"Switch to item withdrawal \nmode", 12, 20);
		setBounds(21008, 240, 285, 11, Interface);
		setBounds(21009, 225, 225, 12, Interface);
		addBankHover1(21012, 5, 21013, 17, "Bank/BANK", 35, 25,
				"Deposit carried tems", 21014, 18, "Bank/BANK", 21015,
				"Empty your backpack into\nyour bank", 0, 20);
		setBounds(21012, 375, 285, 13, Interface);
		setBounds(21013, 360, 225, 14, Interface);
		addBankHover1(21016, 5, 21017, 19, "Bank/BANK", 35, 25,
				"Deposit worn items", 21018, 20, "Bank/BANK", 21019,
				"Empty the items your are\nwearing into your bank", 0, 20);
		setBounds(21016, 415, 285, 15, Interface);
		setBounds(21017, 400, 225, 16, Interface);
		addBankHover1(21020, 5, 21021, 21, "Bank/BANK", 35, 25,
				"Deposit beast of burden inventory.", 21022, 22, "Bank/BANK",
				21023, "Empty your BoB's inventory\ninto your bank", 0, 20);
		setBounds(21020, 455, 285, 17, Interface);
		setBounds(21021, 440, 225, 18, Interface);
		setBounds(5383, 170, 15, 1, Interface);
		setBounds(5385, -4, 74, 2, Interface);
		Interface = interfaceCache[5385];
		Interface.height = 206;
		Interface.width = 480;
		Interface = interfaceCache[5382];
		Interface.width = 10;
		Interface.invSpritePadX = 12;
		Interface.height = 35;
	}

	public static void BeretChange(TextDrawingArea[] TDA) {
		RSInterface Interface = addTabInterface(29912);
		setChildren(22, Interface);

		addText(29929, "Beret Color Changer", TDA, 2, 0xFF9900, false, true);
		addSprite(29913, 0, "Monsterray/MainSprites/BACKGROUND");

		addHover(29914, 3, 0, 29815, 0, "Monsterray/MainSprites/CLOSE", 17, 16,
				"Exit");
		addHovered(29915, 1, "Monsterray/MainSprites/CLOSE", 17, 16, 29916);

		addHoverButton(29917, "Monsterray/Beret/EXAMINE", 0, 72, 64,
				"Examine @bla@Beret@whi@", -1, 29918, 1);
		addHoveredButton(29918, "Monsterray/Beret/EXAMINE", 0, 72, 64, 29919);

		addHoverButton(29920, "Monsterray/Beret/EXAMINE", 1, 72, 64,
				"Examine @whi@Beret@whi@", -1, 29921, 1);
		addHoveredButton(29921, "Monsterray/Beret/EXAMINE", 1, 72, 64, 29922);

		addHoverButton(29923, "Monsterray/Beret/EXAMINE", 2, 72, 64,
				"Examine @blu@Beret@whi@", -1, 29924, 1);
		addHoveredButton(29924, "Monsterray/Beret/EXAMINE", 2, 72, 64, 29925);

		addText(29942, "@bla@Buy", TDA, 1, 0xFFFFFF, false, true);
		addHoverButton(29930, "Monsterray/MainSprites/BUTTON", 0, 75, 23,
				"@whi@Buy@bla@ Black@whi@ Dye", -1, 29931, 1);
		addHoveredButton(29931, "Monsterray/MainSprites/BUTTON", 1, 75, 23,
				29932);

		addText(29943, "@whi@Buy", TDA, 1, 0xFFFFFF, false, true);
		addHoverButton(29933, "Monsterray/MainSprites/BUTTON", 0, 75, 23,
				"@whi@Buy White Dye", -1, 29934, 1);
		addHoveredButton(29934, "Monsterray/MainSprites/BUTTON", 1, 75, 23,
				29935);

		addText(29944, "@blu@Buy", TDA, 1, 0xFFFFFF, false, true);
		addHoverButton(29936, "Monsterray/MainSprites/BUTTON", 0, 75, 23,
				"@whi@Buy@blu@ Blue@whi@ Dye", -1, 29937, 1);
		addHoveredButton(29937, "Monsterray/MainSprites/BUTTON", 1, 75, 23,
				29938);

		addText(29946,
				"Change The Colour Of Your Beret for 150 Loyalty Points", TDA,
				0, 0xFF9900, false, true);
		addText(29947, "@red@This Is A Non-Refundable Purchase!", TDA, 0,
				0xFF9900, false, true);
		addText(29948,
				"@red@This Will Change The First Beret In Your Inventory!",
				TDA, 0, 0xFF9900, false, true);

		setBounds(29913, 60, 71, 0, Interface);
		setBounds(29914, 433, 80, 1, Interface);
		setBounds(29915, 433, 80, 2, Interface);
		setBounds(29917, 142/**/, 111, 3, Interface);
		setBounds(29918, 142, 111, 4, Interface);
		setBounds(29920, 230/**/, 111, 5, Interface);
		setBounds(29921, 230, 111, 6, Interface);
		setBounds(29923, 318/**/, 111, 7, Interface);
		setBounds(29924, 318, 111, 8, Interface);
		setBounds(29929, 163, 78, 9, Interface);
		setBounds(29930, 135/**/, 191, 10, Interface);
		setBounds(29931, 135, 191, 11, Interface);
		setBounds(29933, 223/**/, 191, 12, Interface);
		setBounds(29934, 223, 191, 13, Interface);
		setBounds(29936, 311/**/, 191, 14, Interface);
		setBounds(29937, 311, 191, 15, Interface);
		setBounds(29942, 162, 193, 16, Interface);
		setBounds(29943, 250, 193, 17, Interface);
		setBounds(29944, 338, 193, 18, Interface);
		setBounds(29946, 80, 223, 19, Interface);
		setBounds(29947, 185, 239, 20, Interface);
		setBounds(29948, 180, 252, 21, Interface);
	}

	public static void bobInterface(TextDrawingArea[] TDA) {
		RSInterface rsi = addTabInterface(2700);
		addSprite(2701, 20, "Interfaces/SummonTab/SUMMON");
		addBobStorage(2702);
		addHoverButton(2703, "Interfaces/Equipment/SPRITE", 1, 21, 21, "Close",
				250, 2704, 3);
		addHoveredButton(2704, "Interfaces/Equipment/SPRITE", 3, 21, 21, 2705);
		// addButton(2706, 0, "sprite", 30, 30, "Beast of burden inventory", 1);
		rsi.totalChildren(4);
		rsi.child(0, 2701, 90, 14);
		rsi.child(1, 2702, 100, 56);
		rsi.child(2, 2703, 431, 23);
		rsi.child(3, 2704, 431, 23);
		// rsi.child(4, 2706, 427, 290);
	}

	public static final void boss(TextDrawingArea[] TDA) {
		RSInterface rsinterface = addTabInterface(45500);
		addText(45501, "Boss Teleport", 0xff9b00, false, true, 52, TDA, 2);
		addHoverButton(45502, "Interfaces/Minigame/Hover", 0, 172, 24, "Nex",
				-1, 45503, 1);
		addHoveredButton(45503, "Interfaces/Minigame/Hover", 3, 172, 24, 45504);
		addHoverButton(45518, "Interfaces/Minigame/Hover", 0, 172, 24,
				"King Black Dragon", -1, 45519, 1);
		addHoveredButton(45519, "Interfaces/Minigame/Hover", 3, 172, 24, 45520);
		addHoverButton(45521, "Interfaces/Minigame/Hover", 0, 172, 24,
				"Dagannoth Kings", -1, 45522, 1);
		addHoveredButton(45522, "Interfaces/Minigame/Hover", 3, 172, 24, 45523);
		addHoverButton(45524, "Interfaces/Minigame/Hover", 0, 172, 24,
				"Tormented Demons", -1, 45525, 1);
		addHoveredButton(45525, "Interfaces/Minigame/Hover", 3, 172, 24, 45526);
		addHoverButton(45527, "Interfaces/Minigame/Hover", 0, 172, 24,
				"Corporal Beast", -1, 45528, 1);
		addHoveredButton(45528, "Interfaces/Minigame/Hover", 3, 172, 24, 45529);
		addHoverButton(45533, "Interfaces/Minigame/Back", 0, 16, 16, "Back",
				-1, 45534, 1);
		addHoveredButton(45534, "Interfaces/Minigame/Back", 1, 16, 16, 45535);
		addSprite(45505, 1, "Interfaces/Minigame/Godwars");
		addSprite(45506, 1, "Interfaces/Minigame/Kbd");
		addSprite(45507, 1, "Interfaces/Minigame/Dagganoths");
		addSprite(45508, 1, "Interfaces/Minigame/Chaos");
		addSprite(45509, 1, "Interfaces/Minigame/Corporeal");
		addSprite(45511, 1, "Interfaces/Minigame/Background");
		addText(45512, "Nex", 0xd67b29, true, true, 52, TDA, 2);
		addText(45513, "King Black Dragon", 0xd67b29, true, true, 52, TDA, 2);
		addText(45514, "Dagannoth Kings", 0xd67b29, true, true, 52, TDA, 2);
		addText(45515, "Tormented Demons", 0xd67b29, true, true, 52, TDA, 2);
		addText(45516, "Corporal Beast", 0xd67b29, true, true, 52, TDA, 2);
		byte childAmount = 24;
		int indexChild = 0;
		setChildren(childAmount, rsinterface);
		setBounds(45511, -1, 26, indexChild, rsinterface);
		indexChild++;
		setBounds(45501, 33, 7, indexChild, rsinterface);
		indexChild++;
		setBounds(45502, 8, 35, indexChild, rsinterface);
		indexChild++;
		setBounds(45503, 8, 35, indexChild, rsinterface);
		indexChild++;
		setBounds(45512, 80, 39, indexChild, rsinterface);
		indexChild++;
		setBounds(45518, 8, 72, indexChild, rsinterface);
		indexChild++;
		setBounds(45519, 8, 72, indexChild, rsinterface);
		indexChild++;
		setBounds(45513, 80, 76, indexChild, rsinterface);
		indexChild++;
		setBounds(45521, 8, 109, indexChild, rsinterface);
		indexChild++;
		setBounds(45522, 8, 109, indexChild, rsinterface);
		indexChild++;
		setBounds(45514, 80, 113, indexChild, rsinterface);
		indexChild++;
		setBounds(45524, 8, 146, indexChild, rsinterface);
		indexChild++;
		setBounds(45525, 8, 146, indexChild, rsinterface);
		indexChild++;
		setBounds(45515, 80, 150, indexChild, rsinterface);
		indexChild++;
		setBounds(45527, 8, 183, indexChild, rsinterface);
		indexChild++;
		setBounds(45528, 8, 183, indexChild, rsinterface);
		indexChild++;
		setBounds(45516, 80, 187, indexChild, rsinterface);
		indexChild++;
		setBounds(45505, 148, 33, indexChild, rsinterface);
		indexChild++;
		setBounds(45506, 148, 70, indexChild, rsinterface);
		indexChild++;
		setBounds(45507, 148, 104, indexChild, rsinterface);
		indexChild++;
		setBounds(45508, 148, 144, indexChild, rsinterface);
		indexChild++;
		setBounds(45509, 148, 179, indexChild, rsinterface);
		indexChild++;
		setBounds(45533, 10, 6, indexChild, rsinterface);
		indexChild++;
		setBounds(45534, 10, 6, indexChild, rsinterface);
		indexChild++;
	}

	/*
	 * private static void addHead2(int i, int width, int height, int zoom, int
	 * rot, int rot2){ RSInterface class9_2 = interfaceCache[i] = new
	 * RSInterface(); class9_2.type = 6; class9_2.modelZoom = zoom;
	 * class9_2.modelRotation1 = rot; class9_2.modelRotation2 = rot2;
	 * class9_2.height = height; class9_2.width = width; }
	 */

	/*
	 * public static void Shop(TextDrawingArea TDA[]){ RSInterface Interface =
	 * addTabInterface(3824); setChildren(8, Interface); addSprite(3825, 0,
	 * "Bank/SHOP"); addHover(3902, 3, 0, 3826, 1, "Bank/BANK", 17, 17,
	 * "Close Window"); addHovered(3826, 2, "Bank/BANK", 17, 17, 3827);
	 * addText(19679, "Main Stock", 0xff981f, false, true, 52, TDA, 1);
	 * addText(19680, "Store Info", 0xbf751d, false, true, 52, TDA, 1);
	 * addButton(19681, 2, "Bank/SHOP", 95, 19, "Store Information", 1);
	 * setBounds(3825, 12, 12, 0, Interface); setBounds(3902, 471, 22, 1,
	 * Interface); setBounds(3826, 471, 22, 2, Interface); setBounds(3900, 60,
	 * 85, 3, Interface); setBounds(3901, 240, 21, 4, Interface);
	 * setBounds(19679, 42, 54, 5, Interface); setBounds(19680, 150, 54, 6,
	 * Interface); setBounds(19681, 129, 50, 7, Interface); Interface =
	 * interfaceCache[3900]; Interface.invSpritePadX = 8; Interface.width = 10;
	 * Interface.height = 4; Interface.invSpritePadY = 19; Interface =
	 * addTabInterface(19682); addSprite(19683, 1, "Bank/SHOP"); addText(19684,
	 * "Main Stock", 0xbf751d, false, true, 52, TDA, 1); addText(19685,
	 * "Store Info", 0xff981f, false, true, 52, TDA, 1); addButton(19686, 2,
	 * "Bank/SHOP", 95, 19, "Main Stock", 1); setChildren(7, Interface);
	 * setBounds(19683, 12, 12, 0, Interface); setBounds(3901, 240, 21, 1,
	 * Interface); setBounds(19684, 42, 54, 2, Interface); setBounds(19685, 150,
	 * 54, 3, Interface); setBounds(19686, 23, 50, 4, Interface);
	 * setBounds(3902, 471, 22, 5, Interface); setBounds(3826, 60, 85, 6,
	 * Interface); }
	 */

	/*
	 * public static void equipmentScreen(TextDrawingArea wid[]){ RSInterface
	 * Interface = interfaceCache[1644]; addButton(19144, 6, "Equipment/CUSTOM",
	 * 150, 40, "Show Equipment Stats", 1); // addButton(19145, 6,
	 * "Equipment/BOX", 150, 40, "More options", 1); //addTooltip(27659,
	 * "Locks/unlocks your EXP"); //addButton(27653, 1, "Equipment/BOX",
	 * "Show Equipment Stats", 27655, 1, 40, 39); //addTooltip(27655,
	 * "Show Equipment Stats"); //addButton(27654, 2, "Equipment/BOX",
	 * "Xp Lock", 27657, 1, 40, 39); // removeSomething(19145);
	 * removeSomething(19146); removeSomething(19147); setBounds(19144, 21, 210,
	 * 23, Interface); setBounds(19145, 40, 210, 24, Interface);
	 * setBounds(19146, 40, 210, 25, Interface); setBounds(19147, 40, 210, 26,
	 * Interface); RSInterface tab = addTabInterface(15106); addSprite(15107, 7,
	 * "Equipment/CUSTOM"); addHoverButton(15210, "Equipment/CUSTOM", 8, 21, 21,
	 * "Close", 250, 15211, 3); addHoveredButton(15211, "Equipment/CUSTOM", 9,
	 * 21, 21, 15212); addText(15111, "Equip Your Character...", wid, 2,
	 * 0xe4a146, false, true); addText(15112, "Attack bonus", wid, 2, 0xe4a146,
	 * false, true); addText(15113, "Defence bonus", wid, 2, 0xe4a146, false,
	 * true); addText(15114, "Other bonuses", wid, 2, 0xe4a146, false, true);
	 * for(int i = 1675; i <= 1684; i++) textSize(i, wid, 1);
	 * 
	 * textSize(1686, wid, 1); textSize(1687, wid, 1); addChar(15125);
	 * tab.totalChildren(44); tab.child(0, 15107, 4, 20); tab.child(1, 15210,
	 * 476, 29); tab.child(2, 15211, 476, 29); tab.child(3, 15111, 14, 30); int
	 * Child = 4; int Y = 69; for(int i = 1675; i <= 1679; i++) {
	 * tab.child(Child, i, 20, Y); Child++; Y += 14; }
	 * 
	 * tab.child(9, 1680, 20, 161); tab.child(10, 1681, 20, 177); tab.child(11,
	 * 1682, 20, 192); tab.child(12, 1683, 20, 207); tab.child(13, 1684, 20,
	 * 221); tab.child(14, 1686, 20, 262); tab.child(15, 15125, 170, 200);
	 * tab.child(16, 15112, 16, 55); tab.child(17, 1687, 20, 276); tab.child(18,
	 * 15113, 16, 147); tab.child(19, 15114, 16, 248); tab.child(20, 1645, 399,
	 * 97); tab.child(21, 1646, 399, 163); tab.child(22, 1647, 399, 163);
	 * tab.child(23, 1648, 399, 204); tab.child(24, 1649, 343, 176);
	 * tab.child(25, 1650, 343, 212); tab.child(26, 1651, 455, 176);
	 * tab.child(27, 1652, 455, 212); tab.child(28, 1653, 369, 139);
	 * tab.child(29, 1654, 428, 139); tab.child(30, 1655, 379, 100);
	 * tab.child(31, 1656, 433, 99); tab.child(32, 1657, 399, 62); tab.child(33,
	 * 1658, 358, 101); tab.child(34, 1659, 399, 101); tab.child(35, 1660, 440,
	 * 101); tab.child(36, 1661, 343, 140); tab.child(37, 1662, 399, 140);
	 * tab.child(38, 1663, 455, 140); tab.child(39, 1664, 399, 180);
	 * tab.child(40, 1665, 399, 220); tab.child(41, 1666, 343, 220);
	 * tab.child(42, 1667, 455, 220); tab.child(43, 1688, 345, 102); for(int i =
	 * 1675; i <= 1684; i++) { RSInterface rsi = interfaceCache[i];
	 * rsi.textColor = 0xe4a146; rsi.centerText = false; }
	 * 
	 * for(int i = 1686; i <= 1687; i++) { RSInterface rsi = interfaceCache[i];
	 * rsi.textColor = 0xe4a146; rsi.centerText = false; }
	 * 
	 * }
	 */

	/*
	 * public static void questTab(TextDrawingArea tda[]){ RSInterface tab =
	 * addTabInterface(638); RSInterface list = addTabInterface(16025);
	 * addText(640, "Quests", tda, 2, 0xeb981f, false, true); addText(663,
	 * "Free", tda, 2, 0xff9900, false, true); addText(682, "Members", tda, 2,
	 * 0xff9900, false, true); addSprite(16022, 4, "interfaces/quest/SPRITE");
	 * addText(16023, "Quest Points: ---", tda, 0, 0xeb981f, false, true);
	 * addSprite(16024, 5, "interfaces/quest/SPRITE"); tab.totalChildren(6);
	 * tab.child(0, 640, 5, 5); tab.child(1, 16024, 0, 25); tab.child(2, 16025,
	 * 6, 24); tab.child(3, 16022, 0, 22); tab.child(4, 16022, 0, 249);
	 * tab.child(5, 16023, 4, 251); for(int i = 16026; i <= 16125; i++)
	 * addClickableText(i, (new
	 * StringBuilder()).append("").append(i).toString(), "Show", tda, 0,
	 * 0xff0000, false, true, 150);
	 * 
	 * list.totalChildren(101); list.child(0, 663, 4, 2); int id = 1; for(int
	 * cid = 16026; id <= 100 && cid <= 16125; cid++) { list.childY[1] = 18;
	 * list.child(id, cid, 9, list.childY[id - 1] + 13); id++; }
	 * 
	 * list.width = 168; list.height = 225; list.scrollMax = 1320; }
	 */

	/*
	 * public static void SummonTab(TextDrawingArea wid[]){ RSInterface Tab =
	 * addTabInterface(17011); addSprite(17012, 6, "SummonTab/SUMMON");
	 * addButton(17013, 7, "/SummonTab/SUMMON", "Click"); addSprite(17014, 6,
	 * "SummonTab/SUMMON"); addConfigButton(17015, 17032, 14, 8,
	 * "/SummonTab/SUMMON", 20, 30, "Familiar Special", 1, 5, 300);
	 * addHoverButton(17018, "/SummonTab/SUMMON", 2, 38, 36,
	 * "Beast of burden Inventory", -1, 17028, 1); addHoveredButton(17028,
	 * "/SummonTab/SUMMON", 12, 38, 36, 17029); addHoverButton(17022,
	 * "/SummonTab/SUMMON", 1, 38, 36, "Call Familiar", -1, 17030, 1);
	 * addHoveredButton(17030, "/SummonTab/SUMMON", 13, 38, 36, 17031);
	 * addHoverButton(17023, "/SummonTab/SUMMON", 3, 38, 36, "Dismiss Familiar",
	 * -1, 17033, 1); addHoveredButton(17033, "/SummonTab/SUMMON", 15, 38, 36,
	 * 17034); addSprite(17016, 5, "SummonTab/SUMMON"); addText(17017,
	 * "Spirit Wolf", wid, 2, 0xdaa520, false, true); addSprite(17019, 9,
	 * "SummonTab/SUMMON"); addText(17021, "6.00", wid, 0, 0xffa500, false,
	 * true); addSprite(17020, 10, "SummonTab/SUMMON"); addSprite(17024, 11,
	 * "SummonTab/SUMMON"); addText(17025, "49/50", wid, 0, 0xffa500, false,
	 * true); addText(17026, "10", wid, 0, 0xffa500, false, true);
	 * Tab.totalChildren(19); Tab.child(0, 17012, 10, 25); Tab.child(1, 17013,
	 * 24, 7); Tab.child(2, 17014, 10, 25); Tab.child(3, 17015, 11, 25);
	 * Tab.child(4, 17016, 15, 140); Tab.child(5, 17017, 45, 143); Tab.child(6,
	 * 17018, 20, 170); Tab.child(7, 17019, 115, 167); Tab.child(8, 17020, 143,
	 * 170); Tab.child(9, 17021, 135, 197); Tab.child(10, 17022, 20, 213);
	 * Tab.child(11, 17023, 67, 193); Tab.child(12, 17024, 135, 214);
	 * Tab.child(13, 17025, 135, 240); Tab.child(14, 17026, 21, 59);
	 * Tab.child(15, 17027, 75, 55); Tab.child(16, 17028, 20, 170);
	 * Tab.child(17, 17030, 20, 213); Tab.child(18, 17033, 67, 193); }
	 */

	private static Sprite cardImageLoader(String spriteId, String path,
			String suit) {
		long longString;
		if (spriteId.equals("A")) {
			longString = Long.parseLong("0");
		} else if (spriteId.equals("J")) {
			longString = Long.parseLong("11");
		} else if (spriteId.equals("Q")) {
			longString = Long.parseLong("12");
		} else if (spriteId.equals("K")) {
			longString = Long.parseLong("13");
		} else {
			longString = Long.parseLong(spriteId);
		}
		long l = (TextClass.method585(path) << 8) + longString;
		Sprite sprite = (Sprite) aMRUNodes_238.insertFromCache(l);
		if (sprite != null) {
			return sprite;
		}
		try {
			sprite = new Sprite((new StringBuilder()).append(path).append(" ")
					.append(spriteId).append(" " + suit).toString());
			aMRUNodes_238.removeFromCache(sprite, l);
		} catch (Exception exception) {
			System.out.println("Failed to find: " + path + "/" + spriteId + " "
					+ suit);
			return null;
		}
		return sprite;
	}

	public static void cardTable(TextDrawingArea[] TDA) {
		/*
		 * for(int i = 0; i <= TDA.length - 1; i++){
		 * System.out.println("anIntArray1492: "); System.out.println("");
		 * printArray(TDA[i].anIntArray1492);
		 * System.out.println("anIntArray1493: "); System.out.println("");
		 * printArray(TDA[i].anIntArray1493);
		 * System.out.println("anIntArray1494: "); System.out.println("");
		 * printArray(TDA[i].anIntArray1494);
		 * System.out.println("anIntArray1495: "); System.out.println("");
		 * printArray(TDA[i].anIntArray1495);
		 * System.out.println("anIntArray1496: "); System.out.println("");
		 * printArray(TDA[i].anIntArray1496); }
		 */
		RSInterface Interface = addTabInterface(29900);
		setChildren(15, Interface);
		// addCardSprite(int ID, String spriteId, String spritePath);
		// addHoverButton(int ID, String imageName, int imageId, int width, int
		// height, String toolText, int contentType, int hoverOver, int aT){
		// addHoveredButton(int ID, String imageName, int imageChildId, int
		// width, int height, int IMAGEID){
		// addHover( int i, int aT, int contentType, int hoverOver, int sId,
		// String imageName, int width, int height, String text){
		// addHover( 39814, 3, 0, 29815, 0, "Monsterray/MainSprites/CLOSE", 17,
		// 16, "Exit");
		addCardSprite(29901, 29914, "Clubs"); // 13 childs
		addCardSprite(20015, 29928, "Spades"); // 26 childs
		addCardSprite(29929, 29942, "Hearts"); // 39 childs
		addCardSprite(29943, 29956, "Diamonds"); // 52 childs
		addHoverButton(29957, "Monsterray/MainSprites/CLOSE", 0, 17, 17,
				"Close Window", 0, 29958, 3);
		addHoveredButton(29958, "Monsterray/MainSprites/CLOSE", 1, 17, 17,
				29959);
		addText(29960, "Trading With:", 0xff9933, true, true, 52, TDA, 2);
		addText(29961, "Trader's Offer", 0xff9933, false, true, 52, TDA, 1);
		addText(29962, "Your Offer", 0xff9933, false, true, 52, TDA, 1);
		addText(29963, "Accept", 49152, true, true, 52, TDA, 1);
		addText(29964, "Decline", 0xc00000, true, true, 52, TDA, 1);
		addText(29965, "Waiting For Other Player", 0xffffff, true, true, 52,
				TDA, 1);
		addHover(29966, 1, 0, 29967, 5, "Bank/TRADE", 65, 32, "Accept");
		addHovered(29967, 2, "Bank/TRADE", 65, 32, 29968);
		addHover(29969, 3, 0, 29970, 5, "Bank/TRADE", 65, 32, "Close Window");
		addHovered(29970, 2, "Bank/TRADE", 65, 32, 29971);

		setBounds(29957, 0, 16, 0, Interface);
		setBounds(29958, 485, 24, 1, Interface);
		setBounds(29960, 485, 24, 2, Interface);
		setBounds(29961, 258, 25, 3, Interface);
		setBounds(29962, 355, 51, 4, Interface);
		setBounds(29963, 68, 51, 5, Interface);
		setBounds(29964, 256, 127, 10, Interface);
		setBounds(29965, 256, 167, 11, Interface);
		setBounds(29966, 256, 272, 12, Interface);
		setBounds(29967, 223, 120, 6, Interface);
		setBounds(29968, 223, 120, 7, Interface);
		setBounds(29969, 223, 160, 8, Interface);
		setBounds(29970, 223, 160, 9, Interface);
	}

	public static void clanChatTab(TextDrawingArea tda[]) {
		RSInterface tab = addTabInterface(18128);
		addHoverButton(18129, "/Clan Chat/SPRITE", 6, 72, 32, "Join Chat", 550,
				18130, 1);
		addHoveredButton(18130, "/Clan Chat/SPRITE", 7, 72, 32, 18131);
		addHoverButton(18132, "/Clan Chat/SPRITE", 6, 72, 32, "Leave Chat", -1,
				18133, 5);
		addHoveredButton(18133, "/Clan Chat/SPRITE", 7, 72, 32, 18134);
		addButton(18250, 0, "/Clan Chat/Lootshare", "Toggle lootshare");
		addText(18135, "Join Chat", tda, 0, 0xff9b00, true, true);
		addText(18136, "Leave Chat", tda, 0, 0xff9b00, true, true);
		addSprite(18137, 37, "/Clan Chat/SPRITE");
		addText(18138, "Clan Chat", tda, 1, 0xff9b00, true, true);
		addText(18139, "Talking in: Not in chat", tda, 0, 0xff9b00, false, true);
		addText(18140, "Owner: None", tda, 0, 0xff9b00, false, true);
		tab.totalChildren(14);
		tab.child(0, 16126, 0, 221);
		tab.child(1, 16126, 0, 59);
		tab.child(2, 18137, 0, 62);
		tab.child(3, 18143, 0, 62);
		tab.child(4, 18129, 15, 226);
		tab.child(5, 18130, 15, 226);
		tab.child(6, 18132, 103, 226);
		tab.child(7, 18133, 103, 226);
		tab.child(8, 18135, 51, 237);
		tab.child(9, 18136, 139, 237);
		tab.child(10, 18138, 95, 1);
		tab.child(11, 18139, 10, 23);
		tab.child(12, 18140, 25, 38);
		tab.child(13, 18250, 145, 15);
		RSInterface list = addTabInterface(18143);
		list.totalChildren(100);
		for (int i = 18144; i <= 18244; i++) {
			addText(i, "", tda, 0, 0xffffff, false, true);
		}

		int id = 18144;
		for (int i = 0; id <= 18243 && i <= 99; i++) {
			list.children[i] = id;
			list.childX[i] = 5;
			int id2 = 18144;
			for (int i2 = 1; id2 <= 18243 && i2 <= 99; i2++) {
				list.childY[0] = 2;
				list.childY[i2] = list.childY[i2 - 1] + 14;
				id2++;
			}
			id++;
		}
		list.height = 158;
		list.width = 174;
		list.scrollMax = 1405;
	}

	public static void Classes(TextDrawingArea[] TDA) {
		RSInterface tab = addTabInterface(17050);
		addSprite(17051, 1, "Interfaces/Classes/CHOOSE");
		addHover(17052, 1, 0, 19151, 1, "Interfaces/Classes/MAGIC", 134, 180,
				"Choose Mage As A Class");
		addHover(17053, 1, 0, 19151, 3, "Interfaces/Classes/MELEE", 134, 180,
				"Choose Melee As A Class");
		addHover(17054, 1, 0, 19151, 2, "Interfaces/Classes/RANGE", 134, 180,
				"Choose Range As A Class");
		tab.totalChildren(4);
		tab.child(0, 17051, 10, 15);
		tab.child(1, 17052, 30, 78);
		tab.child(2, 17053, 182, 78);
		tab.child(3, 17054, 334, 78);
	}

	public static void configureLunar(TextDrawingArea TDA[]) {
		homeTeleport();
		drawRune(30003, 1, "Fire");
		drawRune(30004, 2, "Water");
		drawRune(30005, 3, "Air");
		drawRune(30006, 4, "Earth");
		drawRune(30007, 5, "Mind");
		drawRune(30008, 6, "Body");
		drawRune(30009, 7, "Death");
		drawRune(30010, 8, "Nature");
		drawRune(30011, 9, "Chaos");
		drawRune(30012, 10, "Law");
		drawRune(30013, 11, "Cosmic");
		drawRune(30014, 12, "Blood");
		drawRune(30015, 13, "Soul");
		drawRune(30016, 14, "Astral");
		addLunar3RunesSmallBox(30017, 9075, 554, 555, 0, 4, 3, 30003, 30004,
				64, "Bake Pie", "Bake pies without a stove", TDA, 0, 16, 2);
		addLunar2RunesSmallBox(30025, 9075, 557, 0, 7, 30006, 65, "Cure Plant",
				"Cure disease on farming patch", TDA, 1, 4, 2);
		addLunar3RunesBigBox(30032, 9075, 564, 558, 0, 0, 0, 30013, 30007, 65,
				"Monster Examine",
				"Detect the combat statistics of a\\nmonster", TDA, 2, 2, 2);
		addLunar3RunesSmallBox(30040, 9075, 564, 556, 0, 0, 1, 30013, 30005,
				66, "NPC Contact", "Speak with varied NPCs", TDA, 3, 0, 2);
		addLunar3RunesSmallBox(30048, 9075, 563, 557, 0, 0, 9, 30012, 30006,
				67, "Cure Other", "Cure poisoned players", TDA, 4, 8, 2);
		addLunar3RunesSmallBox(30056, 9075, 555, 554, 0, 2, 0, 30004, 30003,
				67, "Humidify", "fills certain vessels with water", TDA, 5, 0,
				5);
		addLunar3RunesSmallBox(30064, 9075, 563, 557, 1, 0, 1, 30012, 30006,
				68, "Skill Teleport", "Skill Teleport", TDA, 6, 0, 5);
		addLunar3RunesBigBox(30075, 9075, 563, 557, 1, 0, 3, 30012, 30006, 69,
				"Minigames", "Barrows & Assault", TDA, 7, 0, 5);
		addLunar3RunesSmallBox(30083, 9075, 563, 557, 1, 0, 5, 30012, 30006,
				70, "Boss Teleport", "Boss Teleport", TDA, 8, 0, 5);
		addLunar3RunesSmallBox(30091, 9075, 564, 563, 1, 1, 0, 30013, 30012,
				70, "Cure Me", "Cures Poison", TDA, 9, 0, 5);
		addLunar2RunesSmallBox(30099, 9075, 557, 1, 1, 30006, 70, "Hunter Kit",
				"Get a kit of hunting gear", TDA, 10, 0, 5);
		addLunar3RunesSmallBox(30106, 9075, 563, 555, 1, 0, 0, 30012, 30004,
				71, "Pk Teleport", "Gives your several of options", TDA, 11, 0,
				5);
		addLunar3RunesBigBox(30114, 9075, 563, 555, 1, 0, 4, 30012, 30004, 72,
				"Monster Teleport", "Monster Teleport", TDA, 12, 0, 5);
		addLunar3RunesSmallBox(30122, 9075, 564, 563, 1, 1, 1, 30013, 30012,
				73, "Cure Group", "Cures Poison on players", TDA, 13, 0, 5);
		addLunar3RunesBigBox(30130, 9075, 564, 559, 1, 1, 4, 30013, 30008, 74,
				"Stat Spy",
				"Cast on another player to see their\\nskill levels", TDA, 14,
				8, 2);
		addLunar3RunesBigBox(30138, 9075, 563, 554, 1, 1, 2, 30012, 30003, 74,
				"Barbarian Teleport",
				"Teleports you to the Barbarian\\noutpost", TDA, 15, 0, 5);
		addLunar3RunesBigBox(30146, 9075, 563, 554, 1, 1, 5, 30012, 30003, 75,
				"Tele Group Barbarian",
				"Teleports players to the Barbarian\\noutpost", TDA, 16, 0, 5);
		addLunar3RunesSmallBox(30154, 9075, 554, 556, 1, 5, 9, 30003, 30005,
				76, "Superglass Make", "Make glass without a furnace", TDA, 17,
				16, 2);
		addLunar3RunesSmallBox(30162, 9075, 563, 555, 1, 1, 3, 30012, 30004,
				77, "Khazard Teleport", "Teleports you to Port khazard", TDA,
				18, 0, 5);
		addLunar3RunesSmallBox(30170, 9075, 563, 555, 1, 1, 7, 30012, 30004,
				78, "Tele Group Khazard", "Teleports players to Port khazard",
				TDA, 19, 0, 5);
		addLunar3RunesBigBox(30178, 9075, 564, 559, 1, 0, 4, 30013, 30008, 78,
				"Dream", "Take a rest and restore hitpoints 3\\n times faster",
				TDA, 20, 0, 5);
		addLunar3RunesSmallBox(30186, 9075, 557, 555, 1, 9, 4, 30006, 30004,
				79, "String Jewellery", "String amulets without wool", TDA, 21,
				0, 5);
		addLunar3RunesLargeBox(30194, 9075, 557, 555, 1, 9, 9, 30006, 30004,
				80, "Stat Restore Pot\\nShare",
				"Share a potion with up to 4 nearby\\nplayers", TDA, 22, 0, 5);
		addLunar3RunesSmallBox(30202, 9075, 554, 555, 1, 6, 6, 30003, 30004,
				81, "Magic Imbue", "Combine runes without a talisman", TDA, 23,
				0, 5);
		addLunar3RunesBigBox(30210, 9075, 561, 557, 2, 1, 14, 30010, 30006, 82,
				"Fertile Soil",
				"Fertilise a farming patch with super\\ncompost", TDA, 24, 4, 2);
		addLunar3RunesBigBox(30218, 9075, 557, 555, 2, 11, 9, 30006, 30004, 83,
				"Boost Potion Share",
				"Shares a potion with up to 4 nearby\\nplayers", TDA, 25, 0, 5);
		addLunar3RunesSmallBox(30226, 9075, 563, 555, 2, 2, 9, 30012, 30004,
				84, "Fishing Guild Teleport",
				"Teleports you to the fishing guild", TDA, 26, 0, 5);
		addLunar3RunesLargeBox(30234, 9075, 563, 555, 1, 2, 13, 30012, 30004,
				85, "Tele Group Fishing\\nGuild",
				"Teleports players to the Fishing\\nGuild", TDA, 27, 0, 5);
		addLunar3RunesSmallBox(30242, 9075, 557, 561, 2, 14, 0, 30006, 30010,
				85, "Plank Make", "Turn Logs into planks", TDA, 28, 16, 5);
		addLunar3RunesSmallBox(30250, 9075, 563, 555, 2, 2, 9, 30012, 30004,
				86, "Catherby Teleport", "Teleports you to Catherby", TDA, 29,
				0, 5);
		addLunar3RunesSmallBox(30258, 9075, 563, 555, 2, 2, 14, 30012, 30004,
				87, "Tele Group Catherby", "Teleports players to Catherby",
				TDA, 30, 0, 5);
		addLunar3RunesSmallBox(30266, 9075, 563, 555, 2, 2, 7, 30012, 30004,
				88, "Ice Plateau Teleport", "Teleports you to Ice Plateau",
				TDA, 31, 0, 5);
		addLunar3RunesBigBox(30274, 9075, 563, 555, 2, 2, 15, 30012, 30004, 89,
				"Tele Group Ice\\n Plateau",
				"Teleports players to Ice Plateau", TDA, 32, 0, 5);
		addLunar3RunesBigBox(
				30282,
				9075,
				563,
				561,
				2,
				1,
				0,
				30012,
				30010,
				90,
				"Energy Transfer",
				"Spend hitpoints and SA Energy to\\n give another player hitpoints and run energy",
				TDA, 33, 8, 2);
		addLunar3RunesBigBox(30290, 9075, 563, 565, 2, 2, 0, 30012, 30014, 91,
				"Heal Other",
				"Transfer up to 75% of hitpoints\\n to another player", TDA,
				34, 8, 2);
		addLunar3RunesBigBox(30298, 9075, 560, 557, 2, 1, 9, 30009, 30006, 92,
				"Vengeance Other",
				"Allows another player to rebound\\ndamage to an opponent",
				TDA, 35, 8, 2);
		addLunar3RunesSmallBox(30306, 9075, 560, 557, 3, 1, 9, 30009, 30006,
				93, "Vengeance", "Rebound damage to an opponent", TDA, 36, 0, 5);
		addLunar3RunesBigBox(30314, 9075, 565, 563, 3, 2, 5, 30014, 30012, 94,
				"Heal Group", "Transfer up to 75% of hitpoints to a group",
				TDA, 37, 0, 5);
		addLunar3RunesBigBox(30322, 9075, 564, 563, 2, 1, 0, 30013, 30012, 95,
				"Spellbook Swap",
				"Change to another spellbook for 1\\nspell cast", TDA, 38, 0, 5);
	}

	public static void Construction(TextDrawingArea TDA[]) {
		RSInterface Interface = addInterface(31250);
		setChildren(53, Interface);
		addHoverButton(29561, "Interfaces/Construction/BUTTON", 0, 16, 16,
				"Close", 0, 29562, 1);// CLOSE
		addHoveredButton(29562, "Interfaces/Construction/BUTTON", 1, 16, 16,
				29563);// CLOSE HOVER
		addSprite(31249, 0, "Interfaces/Construction/CONSTRUCTION");// BACKGROUND

		addButton(31251, 0, "Interfaces/Construction/CONS", "Build @or1@Fern");
		addTooltip(31252, "Fern (lvl 1):\n1x Guam, 1x Logs");

		addButton(31254, 1, "Interfaces/Construction/CONS", "Build @or1@Tree");
		addTooltip(31255, "Tree (lvl 5):\n3x Logs");

		addButton(31257, 2, "Interfaces/Construction/CONS", "Build @or1@Chair");
		addTooltip(31258, "Chair (lvl 19):\n10x Nails, 2x Oak plank");

		addButton(31260, 3, "Interfaces/Construction/CONS",
				"Build @or1@Bookcase");
		addTooltip(31261, "Bookcase (lvl 29):\n15x Nails, 3x Oak plank");

		addButton(31263, 4, "Interfaces/Construction/CONS",
				"Build @or1@Greenman's ale");
		addTooltip(31264, "Greenamn's ale (lvl 26):\n15x Nails, 2x Oak plank");

		addButton(31266, 5, "Interfaces/Construction/CONS",
				"Build @or1@Small oven");
		addTooltip(31267, "Small oven (lvl 24):\n2x Iron bar");

		addButton(31269, 6, "Interfaces/Construction/CONS",
				"Build @or1@Carved oak bench");
		addTooltip(31270, "Carved oak bench (lvl 31):\n15x Nails, 3x Oak plank");

		addButton(31272, 7, "Interfaces/Construction/CONS",
				"Build @or1@Painting stand");
		addTooltip(31273, "Painting stand (lvl 41):\n20x Nails, 2x Oak plank");

		addButton(31275, 8, "Interfaces/Construction/CONS", "Build @or1@Bed");
		addTooltip(31276, "Bed (lvl 40):\n20x Nails, 3x Oak plank");

		addButton(31278, 9, "Interfaces/Construction/CONS",
				"Build @or1@Teak drawers");
		addTooltip(31279, "Teak drawers (lvl 51):\n20x Nails, 2x Teak plank");

		addButton(31281, 10, "Interfaces/Construction/CONS",
				"Build @or1@Mithril armour");
		addTooltip(31282,
				"Mithril armour (lvl 28):\n1x Mithril full helm, platebody, platelegs");

		addButton(31284, 11, "Interfaces/Construction/CONS",
				"Build @or1@Adamant armour");
		addTooltip(31285,
				"Adamant armour (lvl 28):\n1x Adamant full helm, platebody, platelegs");

		addButton(31287, 12, "Interfaces/Construction/CONS",
				"Build @or1@Rune armour");
		addTooltip(31288,
				"Rune armour (lvl 28):\n1x Rune full helm, platebody, platelegs");

		addButton(31290, 13, "Interfaces/Construction/CONS",
				"Build @or1@Rune display case");
		addTooltip(31291,
				"Rune display case (lvl 41):\n100x Law rune, 100x Nature rune, 1x Teak plank");

		addButton(31293, 14, "Interfaces/Construction/CONS",
				"Build @or1@Archery target");
		addTooltip(31294, "Archery target (lvl 81):\n25x Nails, 3x Teak plank");

		addButton(31296, 15, "Interfaces/Construction/CONS",
				"Build @or1@Combat stone");
		addTooltip(31297, "Combat stone (lvl 59):\n4x Iron bar");

		addButton(31299, 16, "Interfaces/Construction/CONS",
				"Build @or1@Elemental balance");
		addTooltip(31300, "Elemental balance (lvl 77):\n4x Iron bar");

		addButton(31302, 17, "Interfaces/Construction/CONS",
				"Build @or1@Mahogany prize chest");
		addTooltip(31303,
				"Mahogany prize chest (lvl 54):\n20x Nails, 2x Mahogany plank");

		addButton(31305, 18, "Interfaces/Construction/CONS",
				"Build @or1@Lectern");
		addTooltip(31306, "Lectern (lvl 67):\n40x Nails, 2x Mahogany plank");

		addButton(31308, 19, "Interfaces/Construction/CONS",
				"Build @or1@Crystal of power");
		addTooltip(31309,
				"Crystal of power (lvl 66):\n15x Nails, 2x Mahogany plank, 1x Iron bar");

		addButton(31311, 20, "Interfaces/Construction/CONS", "Build @or1@Altar");
		addTooltip(31312,
				"Altar (lvl 64):\n15x Nails, 2x Mahogany plank, 1x Iron bar");

		addButton(31314, 21, "Interfaces/Construction/CONS",
				"Build @or1@Intense burners");
		addTooltip(31315,
				"Intense burners (lvl 61):\n10x Nails, 2x Mahogany plank, 1x Kwuarm");

		addButton(31317, 22, "Interfaces/Construction/CONS", "Build @or1@Hedge");
		addTooltip(31318, "Hedge (lvl 80):\n2x Logs, 2x Kwuarm");

		addButton(31320, 23, "Interfaces/Construction/CONS",
				"Build @or1@Rocnar");
		addTooltip(31321, "Rocnar (lvl 83):\n2x Adamant bar, 2x Kwuarm");

		addButton(31323, 24, "Interfaces/Construction/CONS",
				"Build @or1@Bank chest");
		addTooltip(31324,
				"Bank chest (lvl 92):\n40x Nails, 2x Mahogany plank, 1x Iron bar");

		setBounds(29561, 413, 9, 1, Interface);// CLOSE
		setBounds(29562, 413, 9, 2, Interface);// CLOSE HOVER
		setBounds(31249, 69, 3, 0, Interface);// BACKOGRUND X Y

		setBounds(31251, 109, 28, 3, Interface);// Build item
		setBounds(31252, 76, 285, 4, Interface);// Requirements

		setBounds(31254, 172, 28, 5, Interface);// Build item
		setBounds(31255, 76, 285, 6, Interface);// Requirements

		setBounds(31257, 236, 28, 7, Interface);// Build item
		setBounds(31258, 76, 285, 8, Interface);// Requirements

		setBounds(31260, 300, 28, 9, Interface);// Build item
		setBounds(31261, 76, 285, 10, Interface);// Requirements

		setBounds(31263, 364, 28, 11, Interface);// Build item
		setBounds(31264, 76, 285, 12, Interface);// Requirements

		setBounds(31266, 109, 76, 13, Interface);// Build item
		setBounds(31267, 76, 285, 14, Interface);// Requirements

		setBounds(31269, 172, 76, 15, Interface);// Build item
		setBounds(31270, 76, 285, 16, Interface);// Requirements

		setBounds(31272, 236, 76, 17, Interface);// Build item
		setBounds(31273, 76, 285, 18, Interface);// Requirements

		setBounds(31275, 300, 76, 19, Interface);// Build item
		setBounds(31276, 76, 285, 20, Interface);// Requirements

		setBounds(31278, 364, 76, 21, Interface);// Build item
		setBounds(31279, 76, 285, 22, Interface);// Requirements

		setBounds(31281, 109, 124, 23, Interface);// Build item
		setBounds(31282, 76, 285, 24, Interface);// Requirements

		setBounds(31284, 172, 124, 25, Interface);// Build item
		setBounds(31285, 76, 285, 26, Interface);// Requirements

		setBounds(31287, 236, 124, 27, Interface);// Build item
		setBounds(31288, 76, 285, 28, Interface);// Requirements

		setBounds(31290, 300, 124, 29, Interface);// Build item
		setBounds(31291, 76, 285, 30, Interface);// Requirements

		setBounds(31293, 364, 124, 31, Interface);// Build item
		setBounds(31294, 76, 285, 32, Interface);// Requirements

		setBounds(31296, 109, 172, 33, Interface);// Build item
		setBounds(31297, 76, 285, 34, Interface);// Requirements

		setBounds(31299, 172, 172, 35, Interface);// Build item
		setBounds(31300, 76, 285, 36, Interface);// Requirements

		setBounds(31302, 236, 172, 37, Interface);// Build item
		setBounds(31303, 76, 285, 38, Interface);// Requirements

		setBounds(31305, 300, 172, 39, Interface);// Build item
		setBounds(31306, 76, 285, 40, Interface);// Requirements

		setBounds(31308, 364, 172, 41, Interface);// Build item
		setBounds(31309, 76, 285, 42, Interface);// Requirements

		setBounds(31311, 109, 220, 43, Interface);// Build item
		setBounds(31312, 76, 285, 44, Interface);// Requirements

		setBounds(31314, 172, 220, 45, Interface);// Build item
		setBounds(31315, 76, 285, 46, Interface);// Requirements

		setBounds(31317, 236, 220, 47, Interface);// Build item
		setBounds(31318, 76, 285, 48, Interface);// Requirements

		setBounds(31320, 300, 220, 49, Interface);// Build item
		setBounds(31321, 76, 285, 50, Interface);// Requirements

		setBounds(31323, 364, 220, 51, Interface);// Build item
		setBounds(31324, 76, 285, 52, Interface);// Requirements

		Interface = addInterface(31330);
		addSprite(31329, 1, "Interfaces/Construction/CONSTRUCTION");// Back

		addHoverButton(31331, "Interfaces/Construction/BUTTON", 2, 90, 44,
				"Choose", 0, 31332, 1);
		addHoveredButton(31332, "Interfaces/Construction/BUTTON", 4, 90, 44,
				31333);

		addHoverButton(31334, "Interfaces/Construction/BUTTON", 2, 90, 44,
				"Choose", 0, 31335, 1);
		addHoveredButton(31335, "Interfaces/Construction/BUTTON", 4, 90, 44,
				31336);

		addText(31337, "Public", 0xFFEE33, false, true, 52, TDA, 2);
		addText(31338, "Private", 0xFFEE33, false, true, 52, TDA, 2);

		addHoverButton(29561, "Interfaces/Construction/BUTTON", 0, 16, 16,
				"Close", 0, 29562, 1);// CLOSE
		addHoveredButton(29562, "Interfaces/Construction/BUTTON", 1, 16, 16,
				29563);// CLOSE HOVER

		setChildren(9, Interface);
		setBounds(31329, 169, 79, 0, Interface);// Back

		setBounds(31331, 195, 95, 1, Interface);// Button 1
		setBounds(31332, 195, 95, 2, Interface);// Button 1

		setBounds(31334, 195, 157, 3, Interface);// Button 2
		setBounds(31335, 195, 157, 4, Interface);// Button 2

		setBounds(31337, 210, 108, 5, Interface);// Text 1
		setBounds(31338, 210, 170, 6, Interface);// Text 2

		setBounds(29561, 289, 85, 7, Interface);// CLOSE
		setBounds(29562, 289, 85, 8, Interface);// CLOSE HOVER
	}

	public static void Curses(TextDrawingArea[] TDA) {
		RSInterface Interface = addTabInterface(22500);
		int index = 0;
		addText(687, "99/99", 0xFF981F, false, false, -1, TDA, 1);
		addSprite(22502, 0, "CurseTab/ICON");
		addPrayer(22503, 0, 610, 49, 7, "Protect Item", 22582);// 1
		addPrayer(22505, 0, 611, 49, 4, "Sap Warrior", 22544);// 2
		addPrayer(22507, 0, 612, 51, 5, "Sap Ranger", 22546);// 3
		addPrayer(22509, 0, 613, 53, 3, "Sap Mage", 22548);// 4
		addPrayer(22511, 0, 614, 55, 2, "Sap Spirit", 22550);// 5
		addPrayer(22513, 0, 615, 58, 18, "Berserker", 22552);// 6
		addPrayer(22515, 0, 616, 61, 15, "Deflect Summoning", 22554);// /7
		addPrayer(22517, 0, 617, 64, 17, "Deflect Magic", 22556);// /8
		addPrayer(22519, 0, 618, 67, 16, "Deflect Missiles", 22558);// /9
		addPrayer(22521, 0, 619, 70, 6, "Deflect Melee", 22560);// /10
		addPrayer(22523, 0, 620, 73, 9, "Leech Attack", 22562);// 11
		addPrayer(22525, 0, 621, 75, 10, "Leech Ranged", 22564);// 12
		addPrayer(22527, 0, 622, 77, 11, "Leech Magic", 22566);// 13
		addPrayer(22529, 0, 623, 79, 12, "Leech Defence", 22568);// 14
		addPrayer(22531, 0, 624, 81, 13, "Leech Strength", 22570);// 15
		addPrayer(22533, 0, 625, 83, 14, "Leech Energy", 22572);// 16
		addPrayer(22535, 0, 626, 85, 19, "Leech Special Attack", 22574);// 17
		addPrayer(22537, 0, 627, 88, 1, "Wrath", 22576);// /18
		addPrayer(22539, 0, 628, 91, 8, "Soul Split", 22578);// /19
		addPrayer(22541, 0, 629, 94, 20, "Turmoil", 22580);// 20
		addTooltip(22582,
				"Level 50\nProtect Item\nKeep 1 extra item if you die");
		addTooltip(
				22544,
				"Level 50\nSap Warrior\nDrains 10% of enemy Attack,\nStrength and Defence,\nincreasing to 20% over time");
		addTooltip(
				22546,
				"Level 52\nSap Ranger\nDrains 10% of enemy Ranged\nand Defence, increasing to 20%\nover time");
		addTooltip(
				22548,
				"Level 54\nSap Mage\nDrains 10% of enemy Magic\nand Defence, increasing to 20%\nover time");
		addTooltip(22550,
				"Level 56\nSap Spirit\nDrains enenmy special attack\nenergy");
		addTooltip(22552, "Level 59\nBerserker\nBoosted stats last 15% longer");
		addTooltip(
				22554,
				"Level 62\nDeflect Summoning\nReduces damage dealt from\nSummoning scrolls, prevents the\nuse of a familiar's special\nattack, and can deflect some of\ndamage back to the attacker");
		addTooltip(
				22556,
				"Level 65\nDeflect Magic\nProtects against magical attacks\nand can deflect some of the\ndamage back to the attacker");
		addTooltip(
				22558,
				"Level 68\nDeflect Missiles\nProtects against ranged attacks\nand can deflect some of the\ndamage back to the attacker");
		addTooltip(
				22560,
				"Level 71\nDeflect Melee\nProtects against melee attacks\nand can deflect some of the\ndamage back to the attacker");
		addTooltip(
				22562,
				"Level 74\nLeech Attack\nBoosts Attack by 5%, increasing\nto 10% over time, while draining\nenemy Attack by 10%, increasing\nto 25% over time");
		addTooltip(
				22564,
				"Level 76\nLeech Ranged\nBoosts Ranged by 5%, increasing\nto 10% over time, while draining\nenemy Ranged by 10%,\nincreasing to 25% over\ntime");
		addTooltip(
				22566,
				"Level 78\nLeech Magic\nBoosts Magic by 5%, increasing\nto 10% over time, while draining\nenemy Magic by 10%, increasing\nto 25% over time");
		addTooltip(
				22568,
				"Level 80\nLeech Defence\nBoosts Defence by 5%, increasing\nto 10% over time, while draining\n enemy Defence by10%,\nincreasing to 25% over\ntime");
		addTooltip(
				22570,
				"Level 82\nLeech Strength\nBoosts Strength by 5%, increasing\nto 10% over time, while draining\nenemy Strength by 10%, increasing\n to 25% over time");
		addTooltip(22572,
				"Level 84\nLeech Energy\nDrains enemy run energy, while\nincreasing your own");
		addTooltip(
				22574,
				"Level 86\nLeech Special Attack\nDrains enemy special attack\nenergy, while increasing your\nown");
		addTooltip(22576,
				"Level 89\nWrath\nInflicts damage to nearby\ntargets if you die");
		addTooltip(
				22578,
				"Level 92\nSoul Split\n1/4 of damage dealt is also removed\nfrom opponent's Prayer and\nadded to your Hitpoints");
		addTooltip(
				22580,
				"Level 95\nTurmoil\nIncreases Attack and Defence\nby 15%, plus 15% of enemy's\nlevel, and Strength by 23% plus\n10% of enemy's level");
		setChildren(62, Interface);

		setBounds(687, 85, 241, index, Interface);
		index++;
		setBounds(22502, 65, 241, index, Interface);
		index++;
		setBounds(22503, 2, 5, index, Interface);
		index++;
		setBounds(22504, 8, 8, index, Interface);
		index++;
		setBounds(22505, 40, 5, index, Interface);
		index++;
		setBounds(22506, 47, 12, index, Interface);
		index++;
		setBounds(22507, 76, 5, index, Interface);
		index++;
		setBounds(22508, 82, 11, index, Interface);
		index++;
		setBounds(22509, 113, 5, index, Interface);
		index++;
		setBounds(22510, 116, 8, index, Interface);
		index++;
		setBounds(22511, 150, 5, index, Interface);
		index++;
		setBounds(22512, 155, 10, index, Interface);
		index++;
		setBounds(22513, 2, 45, index, Interface);
		index++;
		setBounds(22514, 9, 48, index, Interface);
		index++;
		setBounds(22515, 39, 45, index, Interface);
		index++;
		setBounds(22516, 42, 47, index, Interface);
		index++;
		setBounds(22517, 76, 45, index, Interface);
		index++;
		setBounds(22518, 79, 48, index, Interface);
		index++;
		setBounds(22519, 113, 45, index, Interface);
		index++;
		setBounds(22520, 116, 48, index, Interface);
		index++;
		setBounds(22521, 151, 45, index, Interface);
		index++;
		setBounds(22522, 154, 48, index, Interface);
		index++;
		setBounds(22523, 2, 82, index, Interface);
		index++;
		setBounds(22524, 6, 86, index, Interface);
		index++;
		setBounds(22525, 40, 82, index, Interface);
		index++;
		setBounds(22526, 42, 86, index, Interface);
		index++;
		setBounds(22527, 77, 82, index, Interface);
		index++;
		setBounds(22528, 79, 86, index, Interface);
		index++;
		setBounds(22529, 114, 83, index, Interface);
		index++;
		setBounds(22530, 119, 87, index, Interface);
		index++;
		setBounds(22531, 153, 83, index, Interface);
		index++;
		setBounds(22532, 156, 86, index, Interface);
		index++;
		setBounds(22533, 2, 120, index, Interface);
		index++;
		setBounds(22534, 7, 125, index, Interface);
		index++;
		setBounds(22535, 40, 120, index, Interface);
		index++;
		setBounds(22536, 45, 124, index, Interface);
		index++;
		setBounds(22537, 78, 120, index, Interface);
		index++;
		setBounds(22538, 86, 124, index, Interface);
		index++;
		setBounds(22539, 114, 120, index, Interface);
		index++;
		setBounds(22540, 120, 125, index, Interface);
		index++;
		setBounds(22541, 151, 120, index, Interface);
		index++;
		setBounds(22542, 153, 127, index, Interface);
		index++;
		setBounds(22582, 10, 40, index, Interface);
		index++;
		setBounds(22544, 20, 40, index, Interface);
		index++;
		setBounds(22546, 20, 40, index, Interface);
		index++;
		setBounds(22548, 20, 40, index, Interface);
		index++;
		setBounds(22550, 20, 40, index, Interface);
		index++;
		setBounds(22552, 10, 80, index, Interface);
		index++;
		setBounds(22554, 10, 80, index, Interface);
		index++;
		setBounds(22556, 10, 80, index, Interface);
		index++;
		setBounds(22558, 10, 80, index, Interface);
		index++;
		setBounds(22560, 10, 80, index, Interface);
		index++;
		setBounds(22562, 10, 120, index, Interface);
		index++;
		setBounds(22564, 10, 120, index, Interface);
		index++;
		setBounds(22566, 10, 120, index, Interface);
		index++;
		setBounds(22568, 5, 120, index, Interface);
		index++;
		setBounds(22570, 5, 120, index, Interface);
		index++;
		setBounds(22572, 10, 160, index, Interface);
		index++;
		setBounds(22574, 10, 160, index, Interface);
		index++;
		setBounds(22576, 10, 160, index, Interface);
		index++;
		setBounds(22578, 10, 160, index, Interface);
		index++;
		setBounds(22580, 10, 160, index, Interface);
		index++;

	}

	private static Sprite CustomSpriteLoader(int id, String s) {
		long l = (TextClass.method585(s) << 8) + id;
		Sprite sprite = (Sprite) aMRUNodes_238.insertFromCache(l);
		if (sprite != null) {
			return sprite;
		}
		try {
			sprite = new Sprite((new StringBuilder()).append("/Attack/")
					.append(id).append(s).toString());
			aMRUNodes_238.removeFromCache(sprite, l);
		} catch (Exception exception) {
			return null;
		}
		return sprite;
	}

	public static void dungTab(TextDrawingArea[] TDA) {
		RSInterface Interface = addInterface(638);
		setChildren(4, Interface);
		addText(29155, "Quests", 0xFF981F, false, true, 52, TDA, 2);
		addButton(29156, 2, "QuestTab/QUEST", 18, 18, "Swap to PK Tab", 1);
		addSprite(29157, 0, "Interfaces/QuestTab/QUEST");
		setBounds(29155, 10, 5, 0, Interface);
		setBounds(29156, 165, 5, 1, Interface);
		setBounds(29157, 3, 24, 2, Interface);
		setBounds(29160, 5, 29, 3, Interface);
		Interface = addInterface(29160);
		Interface.height = 214;
		Interface.width = 165;
		Interface.scrollMax = 1700;
		setChildren(105, Interface);
		addText(29161, "", 0xFF981F, false, true, 52, TDA, 2);
		addHoverText(29162, "", "", TDA, 0, 0xff0000, false, true, 150);
		addText(29163, "", 0xFF981F, false, true, 52, TDA, 2);
		addHoverText(29164, "", "", TDA, 0, 0xff0000, false, true, 150);
		addText(29165, "", 0xFF981F, false, true, 52, TDA, 2);
		addHoverText(29166, "", "", TDA, 0, 0xff0000, false, true, 150);
		setBounds(29161, 4, 4, 0, Interface);
		setBounds(29162, 8, 22, 1, Interface);
		setBounds(29163, 4, 35, 2, Interface);
		setBounds(29164, 8, 53, 3, Interface);
		setBounds(663, 4, 67, 4, Interface);
		int Ypos = 83;
		int frameID = 5;
		for (int iD = 29165; iD <= 29264; iD++) {
			addHoverText(iD, "", "Continue"/* "View Quest Journal, "+iD */,
					TDA, 0, 0xff0000, false, true, 150);
			setBounds(iD, 8, Ypos, frameID, Interface);
			frameID++;
			Ypos += 15;
			Ypos++;
		}
		Interface = addInterface(29265);
		try {
			setChildren(4, Interface);
			addText(29266, "Coming soon!", 0xFF981F, false, true, -1, TDA, 2);
			addButton(29267, 1, "Interfaces/QuestTab/QUEST", 18, 18,
					"Swap to Player Info", 1);
			addSprite(29269, 0, "Interfaces/QuestTab/QUEST");
			setBounds(29266, 10, 5, 0, Interface);
			setBounds(29267, 165, 5, 1, Interface);
			setBounds(29269, 3, 24, 2, Interface);
			setBounds(29268, 5, 29, 3, Interface);
			Interface = addInterface(29268);
			Interface.height = 214;
			Interface.width = 165;
			Interface.scrollMax = 1700;
			setChildren(20, Interface);
			setBounds(29295, 8, 4, 0, Interface);
			setBounds(29296, 8, 16, 1, Interface);
			setBounds(29297, 8, 29, 2, Interface);
			setBounds(29298, 8, 42, 3, Interface);
			setBounds(29299, 8, 54, 4, Interface);
			setBounds(29300, 8, 66, 5, Interface);
			setBounds(29301, 8, 78, 6, Interface);
			setBounds(29302, 8, 90, 7, Interface);
			setBounds(29303, 8, 102, 8, Interface);
			setBounds(29304, 8, 114, 9, Interface);
			setBounds(29305, 8, 126, 10, Interface);
			setBounds(29306, 8, 138, 11, Interface);
			setBounds(29307, 8, 150, 12, Interface);
			setBounds(29308, 8, 162, 13, Interface);
			setBounds(29309, 8, 174, 14, Interface);
			setBounds(29310, 8, 186, 15, Interface);
			setBounds(29311, 8, 198, 16, Interface);
			setBounds(29312, 8, 210, 17, Interface);
			setBounds(29313, 8, 222, 18, Interface);
			setBounds(29314, 8, 234, 19, Interface);
			addHoverText(29295, "Please register at", "Please Register", TDA,
					1, 0xFF981F, false, true, 150);
			addHoverText(29296, "InsanityX.Net", "", TDA, 0, 0xff0000, false,
					true, 150);
			addHoverText(29297, "And advertise/vote daily!", "", TDA, 0,
					0xff0000, false, true, 150);
			addHoverText(29298, "::vote for more players!", "", TDA, 0,
					0xff0000, false, true, 150);
			addHoverText(29299, "More players=More updates!", "", TDA, 0,
					0xff0000, false, true, 150);
			addHoverText(29300, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(29301, "", "", TDA, 1, 0xFF981F, false, true, 150);
			addHoverText(29302, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(29303, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(29304, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(29305, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(29306, "", "", TDA, 1, 0xFF981F, false, true, 150);
			addHoverText(29307, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(29308, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(29309, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(29310, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(29311, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(29312, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(29313, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(29314, "", "", TDA, 0, 0xff0000, false, true, 150);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void emoteTab() {
		RSInterface tab = addTabInterface(147);
		RSInterface scroll = addTabInterface(148);
		tab.totalChildren(1);
		tab.child(0, 148, 0, 1);
		int ButtonIDs[] = { 168, 169, 164, 165, 162, 163, 13370, 171, 167, 170,
				13366, 13368, 166, 13363, 13364, 13365, 161, 11100, 13362,
				13367, 172, 13369, 13383, 13384, 667, 6503, 6506, 666, 18464,
				18465, 15166, 18686, 18689, 18688, 18691, 18692, 18687, 154,
				22586, 22587, 22588, 22589, 22590, 22591, 22592, 22593, 22594 };
		int EmoteX[] = { 10, 54, 98, 137, 9, 48, 95, 137, 7, 51, 95, 139, 6,
				50, 90, 135, 8, 51, 99, 137, 10, 53, 88, 138, 3, 52, 96, 141,
				5, 53, 88, 142, 10, 51, 139, 88, 12, 49, 97, 140, 10, 50, 90,
				140, 10, 60, 90 };
		int EmoteY[] = { 6, 6, 13, 6, 55, 55, 55, 55, 104, 104, 103, 104, 153,
				153, 153, 153, 203, 202, 203, 202, 250, 250, 255, 249, 300,
				299, 299, 299, 349, 350, 352, 350, 401, 402, 406, 402, 452,
				450, 452, 452, 505, 505, 505, 505, 560, 560, 560 };
		int EmoteIDs[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
				15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 33, 34, 35,
				36, 28, 29, 30, 37, 31, 32, 38, 39, 40, 41, 42, 43, 44, 45, 46 };
		String EmoteTooltip[] = { "Yes", "No", "Bow", "Angry", "Think", "Wave",
				"Shrug", "Cheer", "Beckon", "Laugh", "Jump for Joy", "Yawn",
				"Dance", "Jig", "Spin", "Headbang", "Cry", "Blow Kiss",
				"Panic", "Raspberry", "Clap", "Salute", "Goblin Bow",
				"Goblin Salute", "Glass Box", "Climb Rope", "Lean on Air",
				"Glass Wall", "Idea", "Stomp", "Flap", "Slap Head",
				"Zombie Walk", "Zombie Dance", "Scared", "Zombie Hand",
				"Bunny Hop", "Skill Cape", "Snowman Dance", "Air Guitar",
				"Safety First", "Explore", "Trick", "Freeze & Melt",
				"Give Thanks", "Around The World In Eggty Days",
				"Dramatic Point" };
		scroll.totalChildren(ButtonIDs.length);
		for (int index = 0; index < ButtonIDs.length; index++) {
			addButton(ButtonIDs[index], EmoteIDs[index], "Emotes/EMOTE",
					EmoteTooltip[index]);
		}

		for (int index = 0; index < ButtonIDs.length; index++) {
			scroll.child(index, ButtonIDs[index], EmoteX[index], EmoteY[index]);
		}

		scroll.width = 173;
		scroll.height = 260;
		scroll.scrollMax = 610;
	}

	public static void equipmentScreen(TextDrawingArea[] TDA) {
		RSInterface Interface = addInterface(19148);
		addSprite(19149, 0, "Equipment/CHAR");
		addHover(19150, 3, 0, 19151, 3, "Equipment/CHAR", 21, 21, "Close");
		addHovered(19151, 2, "Equipment/CHAR", 21, 21, 19152);
		addText(19154, "Equip Your Character...", 0xFF981F, false, true, 52,
				TDA, 2);
		addText(1673, "Attack bonus", 0xFF981F, false, true, 52, TDA, 2);
		addText(1674, "Defense bonus", 0xFF981F, false, true, 52, TDA, 2);
		addText(1685, "Other bonuses", 0xFF981F, false, true, 52, TDA, 2);
		addText(1675, "Stab:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1676, "Slash:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1677, "Crush:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1678, "Magic:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1679, "Ranged:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1680, "Stab:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1681, "Slash:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1682, "Crush:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1683, "Magic:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1684, "Ranged:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1686, "Strength:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1687, "Prayer:", 0xFF981F, false, true, 52, TDA, 1);
		addText(19155, "0%", 0xFF981F, false, true, 52, TDA, 1);
		addChar(19153);
		int last = 45;
		int frame = 0;
		setChildren(last, Interface);
		setBounds(19149, 12, 20, frame, Interface);
		frame++;
		setBounds(19150, 472, 27, frame, Interface);
		frame++;
		setBounds(19151, 472, 27, frame, Interface);
		frame++;
		setBounds(19153, 193, 190, frame, Interface);
		frame++;
		setBounds(19154, 23, 29, frame, Interface);
		frame++;
		setBounds(1673, 365, 71, frame, Interface);
		frame++;
		setBounds(1674, 365, 163, frame, Interface);
		frame++;
		setBounds(1675, 372, 85, frame, Interface);
		frame++;
		setBounds(1676, 372, 99, frame, Interface);
		frame++;
		setBounds(1677, 372, 113, frame, Interface);
		frame++;
		setBounds(1678, 372, 127, frame, Interface);
		frame++;
		setBounds(1679, 372, 141, frame, Interface);
		frame++;
		setBounds(1680, 372, 177, frame, Interface);
		frame++;
		setBounds(1681, 372, 191, frame, Interface);
		frame++;
		setBounds(1682, 372, 205, frame, Interface);
		frame++;
		setBounds(1683, 372, 219, frame, Interface);
		frame++;
		setBounds(1684, 372, 233, frame, Interface);
		frame++;
		setBounds(1685, 365, 253, frame, Interface);
		frame++;
		setBounds(1686, 372, 267, frame, Interface);
		frame++;
		setBounds(1687, 372, 281, frame, Interface);
		frame++;
		setBounds(19155, 94, 286, frame, Interface);
		frame++;
		setBounds(1645, 83, 106, frame, Interface);
		frame++;
		setBounds(1646, 83, 135, frame, Interface);
		frame++;
		setBounds(1647, 83, 172, frame, Interface);
		frame++;
		setBounds(1648, 83, 213, frame, Interface);
		frame++;
		setBounds(1649, 27, 185, frame, Interface);
		frame++;
		setBounds(1650, 27, 221, frame, Interface);
		frame++;
		setBounds(1651, 139, 185, frame, Interface);
		frame++;
		setBounds(1652, 139, 221, frame, Interface);
		frame++;
		setBounds(1653, 53, 148, frame, Interface);
		frame++;
		setBounds(1654, 112, 148, frame, Interface);
		frame++;
		setBounds(1655, 63, 109, frame, Interface);
		frame++;
		setBounds(1656, 117, 108, frame, Interface);
		frame++;
		setBounds(1657, 83, 71, frame, Interface);
		frame++;
		setBounds(1658, 42, 110, frame, Interface);
		frame++;
		setBounds(1659, 83, 110, frame, Interface);
		frame++;
		setBounds(1660, 124, 110, frame, Interface);
		frame++;
		setBounds(1661, 27, 149, frame, Interface);
		frame++;
		setBounds(1662, 83, 149, frame, Interface);
		frame++;
		setBounds(1663, 139, 149, frame, Interface);
		frame++;
		setBounds(1664, 83, 189, frame, Interface);
		frame++;
		setBounds(1665, 83, 229, frame, Interface);
		frame++;
		setBounds(1666, 27, 229, frame, Interface);
		frame++;
		setBounds(1667, 139, 229, frame, Interface);
		frame++;
		setBounds(1688, 29, 111, frame, Interface);
		frame++;
	}

	public static void EquipmentTab(TextDrawingArea[] wid) {
		RSInterface Interface = interfaceCache[1644];
		addSprite(15101, 0, "Equipment/bl");// cheap hax
		addSprite(15102, 1, "Equipment/bl");// cheap hax
		addSprite(15109, 2, "Equipment/bl");// cheap hax
		removeSomething(15103);
		removeSomething(15104);
		Interface.children[23] = 15101;
		Interface.childX[23] = 40;
		Interface.childY[23] = 205;
		Interface.children[24] = 15102;
		Interface.childX[24] = 110;
		Interface.childY[24] = 205;
		Interface.children[25] = 15109;
		Interface.childX[25] = 39;
		Interface.childY[25] = 240;
		Interface.children[26] = 27650;
		Interface.childX[26] = 0;
		Interface.childY[26] = 0;
		Interface = addInterface(27650);
		addButton(27651, 6, "Equipment/BOX", "Donator Tab", 27659, 1, 26, 33);
		// addTooltip(27659, "Locks/unlocks your EXP");
		addButton(27653, 1, "Equipment/BOX", "Show Equipment Stats", 27655, 1,
				40, 39);
		// addTooltip(27655, "Show Equipment Stats");
		addButton(27654, 2, "Equipment/BOX", "Items Kept On Death", 27657, 1,
				40, 39);
		// addTooltip(27657, "Shows items kept on death.");
		setChildren(3, Interface);
		setBounds(27651, 84, 215, 0, Interface);
		setBounds(27653, 29, 205, 1, Interface);
		setBounds(27654, 124, 205, 2, Interface);
		// setBounds(27659, 39, 240, 3, Interface);
		// setBounds(27655, 39, 240, 4, Interface);
		// setBounds(27657, 39, 240, 5, Interface);
	}

	public static void extraEquipment(TextDrawingArea[] TDA) { // this is the
																// donator tab
		RSInterface rsinterface = addTabInterface(27620);
		addButton(27621, 3, "Interfaces/Equipment/BOX", "New Slayer Task",
				27640, 1, 40, 39);
		addTooltip(27640, "Anywhere Slayer");
		addButton(27622, 4, "Interfaces/Equipment/BOX",
				"Change your spellbook", 27642, 1, 40, 39);
		addTooltip(27642, "Switch spellbook");
		addButton(27623, 5, "Interfaces/Equipment/BOX", "Donator Zone", 27644,
				1, 40, 39);
		addTooltip(27644, "Teleport to Donator-Zone!");
		addText(27624, "Information:", 0xFF981F, false, true, 52, TDA, 1);
		addSprite(27634, 0, "Interfaces/Options/LINE");
		addText(27625, "Slayer Task:", 0xFF981F, false, true, 52, TDA, 1);
		addText(27647, "Get a Slayer task", 0xFF981F, false, true, 52, TDA, 1);
		addText(27626, "Anywhere in 2xG", 0xFF981F, false, true, 52, TDA, 1);
		addText(27627, "Without a slayer master!", 0xFF981F, false, true, 52,
				TDA, 1);
		addText(27628, "Spellbook change:", 0xFF981F, false, true, 52, TDA, 1);
		addText(27629, "Change your Spellbook", 0xFF981F, false, true, 52, TDA,
				1);
		addText(27630, "anywhere ingame", 0xFF981F, false, true, 52, TDA, 1);
		addText(27631, "but in the wilderness.", 0xFF981F, false, true, 52,
				TDA, 1);
		addText(27632, "Donator Zone:", 0xFF981F, false, true, 52, TDA, 1);
		addText(27633, "Has lots of good benefits.", 0xFF981F, false, true, 52,
				TDA, 1);
		addText(27636, "Go Back", 0xFF981F, false, true, 52, TDA, 1);
		addButton(27635, 7, "Interfaces/Equipment/BOX", "Back", -1, 1, 71, 23);
		addTooltip(27648, "Go back");
		int last = 21;
		int frame = 0;
		setChildren(last, rsinterface);
		/** Buttons + text */
		setBounds(27621, 5, 5, frame, rsinterface);
		frame++;
		setBounds(27622, 75, 5, frame, rsinterface);
		frame++;
		setBounds(27623, 145, 5, frame, rsinterface);
		frame++;
		setBounds(27635, 55, 235, frame, rsinterface);
		frame++;
		setBounds(27636, 70, 240, frame, rsinterface);
		frame++;
		setBounds(27634, 0, 62, frame, rsinterface);
		frame++;
		setBounds(27624, 55, 46, frame, rsinterface);
		frame++;
		setBounds(27625, 15, 65, frame, rsinterface);
		frame++;
		setBounds(27647, 20, 80, frame, rsinterface);
		frame++;
		setBounds(27626, 20, 95, frame, rsinterface);
		frame++;
		setBounds(27627, 20, 110, frame, rsinterface);
		frame++;
		setBounds(27628, 15, 125, frame, rsinterface);
		frame++;
		setBounds(27629, 20, 140, frame, rsinterface);
		frame++;
		setBounds(27630, 20, 155, frame, rsinterface);
		frame++;
		setBounds(27631, 20, 170, frame, rsinterface);
		frame++;
		setBounds(27632, 15, 185, frame, rsinterface);
		frame++;
		setBounds(27633, 20, 200, frame, rsinterface);
		frame++;
		/** Tooltips */
		setBounds(27640, 10, 50, frame, rsinterface);
		frame++;
		setBounds(27642, 30, 50, frame, rsinterface);
		frame++;
		setBounds(27644, 35, 50, frame, rsinterface);
		frame++;
		setBounds(27648, 40, 240, frame, rsinterface);
		frame++;
	}

	public static void friendsTab(TextDrawingArea tda[]) {
		RSInterface tab = addTabInterface(5065);
		RSInterface list = interfaceCache[5066];
		addText(5067, "Friends List", tda, 1, 0xff9933, true, true);
		addText(5070, "Add Friend", tda, 0, 0xff9933, false, true);
		addText(5071, "Delete Friend", tda, 0, 0xff9933, false, true);
		addSprite(16126, 4, "/Friends/SPRITE");
		addSprite(16127, 8, "/Friends/SPRITE");
		addHoverButton(5068, "/Friends/SPRITE", 6, 72, 32, "Add Friend", 201,
				5072, 1);
		addHoveredButton(5072, "/Friends/SPRITE", 7, 72, 32, 5073);
		addHoverButton(5069, "/Friends/SPRITE", 6, 72, 32, "Delete Friend",
				202, 5074, 1);
		addHoveredButton(5074, "/Friends/SPRITE", 7, 72, 32, 5075);
		tab.totalChildren(11);
		tab.child(0, 5067, 95, 4);
		tab.child(1, 16127, 0, 25);
		tab.child(2, 16126, 0, 221);
		tab.child(3, 5066, 0, 24);
		tab.child(4, 16126, 0, 22);
		tab.child(5, 5068, 15, 226);
		tab.child(6, 5072, 15, 226);
		tab.child(7, 5069, 103, 226);
		tab.child(8, 5074, 103, 226);
		tab.child(9, 5070, 25, 237);
		tab.child(10, 5071, 106, 237);
		list.height = 196;
		list.width = 174;
		int id = 5092;
		for (int i = 0; id <= 5191 && i <= 99; i++) {
			list.children[i] = id;
			list.childX[i] = 3;
			list.childY[i] = list.childY[i] - 7;
			id++;
		}
		id = 5192;
		for (int i = 100; id <= 5291 && i <= 199; i++) {
			list.children[i] = id;
			list.childX[i] = 131;
			list.childY[i] = list.childY[i] - 7;
			id++;
		}

	}

	public static void GodWars(TextDrawingArea[] TDA) {
		RSInterface rsinterface = addTabInterface(16220);
		addText(16211, "NPC killcount", 0xff9040, false, true, 52, TDA, 0);
		addText(16212, "Armadyl kills", 0xff9040, false, true, 52, TDA, 0);
		addText(16213, "Bandos kills", 0xff9040, false, true, 52, TDA, 0);
		addText(16214, "Saradomin kills", 0xff9040, false, true, 52, TDA, 0);
		addText(16215, "Zamorak kills", 0xff9040, false, true, 52, TDA, 0);
		addText(16216, "0", 0x66FFFF, false, true, 52, TDA, 0);// armadyl
		addText(16217, "0", 0x66FFFF, false, true, 52, TDA, 0);// bandos
		addText(16218, "0", 0x66FFFF, false, true, 52, TDA, 0);// saradomin
		addText(16219, "0", 0x66FFFF, false, true, 52, TDA, 0);// zamorak
		rsinterface.scrollMax = 0;
		rsinterface.children = new int[9];
		rsinterface.childX = new int[9];
		rsinterface.childY = new int[9];
		rsinterface.children[0] = 16211;
		rsinterface.childX[0] = -52 + 375 + 30;
		rsinterface.childY[0] = 7;
		rsinterface.children[1] = 16212;
		rsinterface.childX[1] = -52 + 375 + 30;
		rsinterface.childY[1] = 30;
		rsinterface.children[2] = 16213;
		rsinterface.childX[2] = -52 + 375 + 30;
		rsinterface.childY[2] = 44;
		rsinterface.children[3] = 16214;
		rsinterface.childX[3] = -52 + 375 + 30;
		rsinterface.childY[3] = 58;
		rsinterface.children[4] = 16215;
		rsinterface.childX[4] = -52 + 375 + 30;
		rsinterface.childY[4] = 73;

		rsinterface.children[5] = 16216;
		rsinterface.childX[5] = -52 + 460 + 60;
		rsinterface.childY[5] = 31;
		rsinterface.children[6] = 16217;
		rsinterface.childX[6] = -52 + 460 + 60;
		rsinterface.childY[6] = 45;
		rsinterface.children[7] = 16218;
		rsinterface.childX[7] = -52 + 460 + 60;
		rsinterface.childY[7] = 59;
		rsinterface.children[8] = 16219;
		rsinterface.childX[8] = -52 + 460 + 60;
		rsinterface.childY[8] = 74;
	} // if i compile i get errors 'missing symbol rsinterface'

	public static void ignoreTab(TextDrawingArea tda[]) {
		RSInterface tab = addTabInterface(5715);
		RSInterface list = interfaceCache[5716];
		addText(5717, "Ignore List", tda, 1, 0xff9933, true, true);
		addText(5720, "Add Name", tda, 0, 0xff9933, false, true);
		addText(5721, "Delete Name", tda, 0, 0xff9933, false, true);
		addHoverButton(5718, "/Friends/SPRITE", 6, 72, 32, "Add Name", 501,
				5722, 1);
		addHoveredButton(5722, "/Friends/SPRITE", 7, 72, 32, 5723);
		addHoverButton(5719, "/Friends/SPRITE", 6, 72, 32, "Delete Name", 502,
				5724, 1);
		addHoveredButton(5724, "/Friends/SPRITE", 7, 72, 32, 5725);
		tab.totalChildren(11);
		tab.child(0, 5717, 95, 4);
		tab.child(1, 16127, 0, 25);
		tab.child(2, 16126, 0, 221);
		tab.child(3, 5716, 0, 24);
		tab.child(4, 16126, 0, 22);
		tab.child(5, 5718, 15, 226);
		tab.child(6, 5722, 15, 226);
		tab.child(7, 5719, 103, 226);
		tab.child(8, 5724, 103, 226);
		tab.child(9, 5720, 27, 237);
		tab.child(10, 5721, 108, 237);
		list.height = 196;
		list.width = 174;
		int id = 5742;
		for (int i = 0; id <= 5841 && i <= 99; i++) {
			list.children[i] = id;
			list.childX[i] = 3;
			list.childY[i] = list.childY[i] - 7;
			id++;
		}
	}

	private static Sprite imageLoader(int spriteId, String path) {
		long l = (TextClass.method585(path) << 8) + spriteId;
		Sprite sprite = (Sprite) aMRUNodes_238.insertFromCache(l);
		if (sprite != null) {
			return sprite;
		}
		try {
			sprite = new Sprite((new StringBuilder()).append(path).append(" ")
					.append(spriteId).toString());
			aMRUNodes_238.removeFromCache(sprite, l);
		} catch (Exception exception) {
			return null;
		}
		return sprite;
	}

	public static void itemsOnDeath(TextDrawingArea[] wid) {
		RSInterface rsinterface = addInterface(17100);
		addSprite(17101, 2, 2);
		addHover(17102, 3, 0, 10601, 1, "Interfaces/Equipment/SPRITE", 17, 17,
				"Close Window");
		addHovered(10601, 3, "Interfaces/Equipment/SPRITE", 17, 17, 10602);
		// addText(17103, "Items Kept On Death", wid, 2, 0xff981f);
		addText(17104, "Items you will keep on death (if not skulled):", wid,
				1, 0xff981f);
		addText(17105, "Items you will lose on death (if not skulled):", wid,
				1, 0xff981f);
		addText(17106, "Information", wid, 1, 0xff981f);
		addText(17107, "Max items kept on death:", wid, 1, 0xffcc33);
		addText(17108, "~ 3 ~", wid, 1, 0xffcc33);
		rsinterface.scrollMax = 0;
		rsinterface.isMouseoverTriggered = false;
		rsinterface.children = new int[12];
		rsinterface.childX = new int[12];
		rsinterface.childY = new int[12];

		rsinterface.children[0] = 17101;
		rsinterface.childX[0] = 7;
		rsinterface.childY[0] = 8;
		rsinterface.children[1] = 17102;
		rsinterface.childX[1] = 480;
		rsinterface.childY[1] = 17;
		rsinterface.children[2] = 17103;
		rsinterface.childX[2] = 185;
		rsinterface.childY[2] = 18;
		rsinterface.children[3] = 17104;
		rsinterface.childX[3] = 22;
		rsinterface.childY[3] = 50;
		rsinterface.children[4] = 17105;
		rsinterface.childX[4] = 22;
		rsinterface.childY[4] = 110;
		rsinterface.children[5] = 17106;
		rsinterface.childX[5] = 347;
		rsinterface.childY[5] = 47;
		rsinterface.children[6] = 17107;
		rsinterface.childX[6] = 349;
		rsinterface.childY[6] = 270;
		rsinterface.children[7] = 17108;
		rsinterface.childX[7] = 398;
		rsinterface.childY[7] = 298;
		rsinterface.children[8] = 17115;
		rsinterface.childX[8] = 348;
		rsinterface.childY[8] = 64;
		rsinterface.children[9] = 10494;
		rsinterface.childX[9] = 26;
		rsinterface.childY[9] = 74;
		rsinterface.children[10] = 10600;
		rsinterface.childX[10] = 26;
		rsinterface.childY[10] = 133;
		rsinterface.children[11] = 10601;
		rsinterface.childX[11] = 480;
		rsinterface.childY[11] = 17;
	}

	public static void itemsOnDeathDATA(TextDrawingArea[] wid) {
		RSInterface rsinterface = addInterface(17115);
		addText(17109, "", wid, 0, 0xff981f);
		addText(17110, "The normal amount of", wid, 0, 0xff981f);
		addText(17111, "items kept is three.", wid, 0, 0xff981f);
		addText(17112, "", wid, 0, 0xff981f);
		addText(17113, "If you are skulled,", wid, 0, 0xff981f);
		addText(17114, "you will lose all your", wid, 0, 0xff981f);
		addText(17117, "items, unless an item", wid, 0, 0xff981f);
		addText(17118, "protecting prayer is", wid, 0, 0xff981f);
		addText(17119, "used.", wid, 0, 0xff981f);
		addText(17120, "", wid, 0, 0xff981f);
		addText(17121, "Item protecting prayers", wid, 0, 0xff981f);
		addText(17122, "will allow you to keep", wid, 0, 0xff981f);
		addText(17123, "one extra item.", wid, 0, 0xff981f);
		addText(17124, "", wid, 0, 0xff981f);
		addText(17125, "The items kept are", wid, 0, 0xff981f);
		addText(17126, "selected by the server", wid, 0, 0xff981f);
		addText(17127, "and include the most", wid, 0, 0xff981f);
		addText(17128, "expensive items you're", wid, 0, 0xff981f);
		addText(17129, "carrying.", wid, 0, 0xff981f);
		addText(17130, "", wid, 0, 0xff981f);
		rsinterface.parentID = 17115;
		rsinterface.id = 17115;
		rsinterface.type = 0;
		rsinterface.atActionType = 0;
		rsinterface.contentType = 0;
		rsinterface.width = 130;
		rsinterface.height = 197;
		rsinterface.opacity = 0;
		rsinterface.mOverInterToTrigger = -1;
		rsinterface.scrollMax = 280;
		rsinterface.children = new int[20];
		rsinterface.childX = new int[20];
		rsinterface.childY = new int[20];
		rsinterface.children[0] = 17109;
		rsinterface.childX[0] = 0;
		rsinterface.childY[0] = 0;
		rsinterface.children[1] = 17110;
		rsinterface.childX[1] = 0;
		rsinterface.childY[1] = 12;
		rsinterface.children[2] = 17111;
		rsinterface.childX[2] = 0;
		rsinterface.childY[2] = 24;
		rsinterface.children[3] = 17112;
		rsinterface.childX[3] = 0;
		rsinterface.childY[3] = 36;
		rsinterface.children[4] = 17113;
		rsinterface.childX[4] = 0;
		rsinterface.childY[4] = 48;
		rsinterface.children[5] = 17114;
		rsinterface.childX[5] = 0;
		rsinterface.childY[5] = 60;
		rsinterface.children[6] = 17117;
		rsinterface.childX[6] = 0;
		rsinterface.childY[6] = 72;
		rsinterface.children[7] = 17118;
		rsinterface.childX[7] = 0;
		rsinterface.childY[7] = 84;
		rsinterface.children[8] = 17119;
		rsinterface.childX[8] = 0;
		rsinterface.childY[8] = 96;
		rsinterface.children[9] = 17120;
		rsinterface.childX[9] = 0;
		rsinterface.childY[9] = 108;
		rsinterface.children[10] = 17121;
		rsinterface.childX[10] = 0;
		rsinterface.childY[10] = 120;
		rsinterface.children[11] = 17122;
		rsinterface.childX[11] = 0;
		rsinterface.childY[11] = 132;
		rsinterface.children[12] = 17123;
		rsinterface.childX[12] = 0;
		rsinterface.childY[12] = 144;
		rsinterface.children[13] = 17124;
		rsinterface.childX[13] = 0;
		rsinterface.childY[13] = 156;
		rsinterface.children[14] = 17125;
		rsinterface.childX[14] = 0;
		rsinterface.childY[14] = 168;
		rsinterface.children[15] = 17126;
		rsinterface.childX[15] = 0;
		rsinterface.childY[15] = 180;
		rsinterface.children[16] = 17127;
		rsinterface.childX[16] = 0;
		rsinterface.childY[16] = 192;
		rsinterface.children[17] = 17128;
		rsinterface.childX[17] = 0;
		rsinterface.childY[17] = 204;
		rsinterface.children[18] = 17129;
		rsinterface.childX[18] = 0;
		rsinterface.childY[18] = 216;
		rsinterface.children[19] = 17130;
		rsinterface.childX[19] = 0;
		rsinterface.childY[19] = 228;
	}

	public static void LodestoneNetwork(TextDrawingArea[] tda) { // the
																	// lodestone
																	// interface
		RSInterface tab = addTabInterface(26200);
		addSprite(26201, 0, "Monsterray/Lodestones/Main");
		addHoverButton(26202, "Monsterray/Lodestones/Unlock", 14, 40, 40,
				"Lunar Isle", 250, 26203, 5);
		addHoveredButton(26203, "Monsterray/Lodestones/UnlockHover", 14, 50,
				50, 26204);
		addHoverButton(26205, "Monsterray/Lodestones/Unlock", 0, 40, 40,
				"Lumbridge", 250, 26206, 5);
		addHoveredButton(26206, "Monsterray/Lodestones/UnlockHover", 0, 50, 50,
				26207);
		addHoverButton(26208, "Monsterray/Lodestones/Unlock", 5, 40, 40,
				"Burthorpe", 250, 26209, 5);
		addHoveredButton(26209, "Monsterray/Lodestones/UnlockHover", 5, 50, 50,
				26210);
		addHoverButton(26211, "Monsterray/Lodestones/Unlock", 13, 40, 40,
				"Bandit Camp", 250, 26212, 5);
		addHoveredButton(26212, "Monsterray/Lodestones/UnlockHover", 13, 50,
				50, 26213);
		addHoverButton(26214, "Monsterray/Lodestones/Unlock", 4, 40, 40,
				"Taverley", 250, 26215, 5);
		addHoveredButton(26215, "Monsterray/Lodestones/UnlockHover", 4, 50, 50,
				26216);
		addHoverButton(26217, "Monsterray/Lodestones/Unlock", 12, 40, 40,
				"Al Kharid", 250, 26218, 5);
		addHoveredButton(26218, "Monsterray/Lodestones/UnlockHover", 12, 50,
				50, 26219);
		addHoverButton(26220, "Monsterray/Lodestones/Unlock", 1, 40, 40,
				"Varrock", 250, 26221, 5);
		addHoveredButton(26221, "Monsterray/Lodestones/UnlockHover", 1, 50, 50,
				26222);
		addHoverButton(26223, "Monsterray/Lodestones/Unlock", 11, 40, 40,
				"Edgeville", 250, 26224, 5);
		addHoveredButton(26224, "Monsterray/Lodestones/UnlockHover", 11, 50,
				50, 26225);
		addHoverButton(26226, "Monsterray/Lodestones/Unlock", 2, 40, 40,
				"Falador", 250, 26227, 5);
		addHoveredButton(26227, "Monsterray/Lodestones/UnlockHover", 2, 50, 50,
				26228);
		addHoverButton(26229, "Monsterray/Lodestones/Unlock", 8, 40, 40,
				"Port Sarim", 250, 26230, 5);
		addHoveredButton(26230, "Monsterray/Lodestones/UnlockHover", 8, 50, 50,
				26231);
		addHoverButton(26232, "Monsterray/Lodestones/Unlock", 9, 40, 40,
				"Draynor Village", 250, 26233, 5);
		addHoveredButton(26233, "Monsterray/Lodestones/UnlockHover", 9, 50, 50,
				26234);
		addHoverButton(26235, "Monsterray/Lodestones/Unlock", 3, 40, 40,
				"Ardougne", 250, 26236, 5);
		addHoveredButton(26236, "Monsterray/Lodestones/UnlockHover", 3, 50, 50,
				26237);
		addHoverButton(26238, "Monsterray/Lodestones/Unlock", 6, 40, 40,
				"Catherby", 250, 26239, 5);
		addHoveredButton(26239, "Monsterray/Lodestones/UnlockHover", 6, 50, 50,
				26240);
		addHoverButton(26241, "Monsterray/Lodestones/Unlock", 10, 40, 40,
				"Yanille", 250, 26242, 5);
		addHoveredButton(26242, "Monsterray/Lodestones/UnlockHover", 10, 50,
				50, 26243);
		addHoverButton(26244, "Monsterray/Lodestones/Unlock", 7, 40, 40,
				"Seers' Village", 250, 26245, 5);
		addHoveredButton(26245, "Monsterray/Lodestones/UnlockHover", 7, 50, 50,
				26246);
		addHoverButton(26247, "Monsterray/Lodestones/Close", 0, 26, 26,
				"Seers' Village", 250, 26248, 3);
		addHoveredButton(26248, "Monsterray/Lodestones/Close", 1, 26, 26, 26249);
		tab.totalChildren(33);
		tab.child(0, 26201, 6, 18);
		tab.child(1, 26202, 30, 53);
		tab.child(2, 26203, 25, 48);
		tab.child(3, 26205, 302, 217);
		tab.child(4, 26206, 297, 212);
		tab.child(5, 26208, 230, 120);
		tab.child(6, 26209, 225, 115);
		tab.child(7, 26211, 300, 270);
		tab.child(8, 26212, 295, 265);
		tab.child(9, 26214, 230, 155);
		tab.child(10, 26215, 225, 150);
		tab.child(11, 26217, 340, 200);
		tab.child(12, 26218, 335, 195);
		tab.child(13, 26220, 322, 162);
		tab.child(14, 26221, 317, 157);
		tab.child(15, 26223, 275, 130);
		tab.child(16, 26224, 270, 125);
		tab.child(17, 26226, 256, 181);
		tab.child(18, 26227, 251, 176);
		tab.child(19, 26229, 260, 235);
		tab.child(20, 26230, 255, 230);
		tab.child(21, 26232, 287, 182);
		tab.child(22, 26233, 282, 177);
		tab.child(23, 26235, 145, 185);
		tab.child(24, 26236, 140, 180);
		tab.child(25, 26238, 200, 157);
		tab.child(26, 26239, 195, 153);
		tab.child(27, 26241, 135, 240);
		tab.child(28, 26242, 130, 235);
		tab.child(29, 26244, 172, 135);
		tab.child(30, 26245, 167, 130);
		tab.child(31, 26247, 480, 21);
		tab.child(32, 26248, 480, 21);
	}

	public static void lotteryItem(int i) {
		RSInterface rsinterface = interfaceCache[i] = new RSInterface();
		rsinterface.itemActions = new String[5];
		rsinterface.spritesX = new int[36];
		rsinterface.invStackSizes = new int[36];
		rsinterface.inv = new int[36];
		rsinterface.spritesY = new int[36];
		rsinterface.children = new int[0];
		rsinterface.childX = new int[0];
		rsinterface.childY = new int[0];
		rsinterface.spritesY[0] = 0;
		rsinterface.spritesY[1] = 0;
		rsinterface.spritesY[2] = 0;
		rsinterface.spritesY[3] = 0;
		rsinterface.spritesY[4] = 0;
		rsinterface.spritesY[5] = 0;
		rsinterface.spritesY[6] = 0;
		rsinterface.spritesY[7] = 0;
		rsinterface.spritesY[8] = 0;
		rsinterface.spritesY[9] = 0;
		rsinterface.spritesY[10] = 0;
		rsinterface.spritesY[11] = 0;
		rsinterface.spritesY[12] = 0;
		rsinterface.spritesY[13] = 0;
		rsinterface.spritesY[14] = 0;
		rsinterface.spritesY[15] = 0;
		rsinterface.spritesY[16] = 0;
		rsinterface.spritesY[17] = 0;
		rsinterface.spritesY[18] = 0;
		rsinterface.spritesY[19] = 0;
		rsinterface.spritesY[20] = 0;
		rsinterface.spritesY[21] = 0;
		rsinterface.spritesY[22] = 0;
		rsinterface.spritesY[23] = 0;
		rsinterface.spritesY[24] = 0;
		rsinterface.spritesY[25] = 0;
		rsinterface.spritesY[26] = 0;
		rsinterface.spritesY[27] = 0;
		rsinterface.spritesY[28] = 0;
		rsinterface.spritesY[29] = 0;
		rsinterface.spritesY[30] = 0;
		rsinterface.spritesY[31] = 0;
		rsinterface.spritesY[32] = 0;
		rsinterface.spritesY[33] = 0;
		rsinterface.spritesY[34] = 0;
		rsinterface.spritesY[35] = 0;
		rsinterface.invStackSizes[0] = 0;
		rsinterface.invStackSizes[1] = 0;
		rsinterface.invStackSizes[2] = 0;
		rsinterface.invStackSizes[3] = 0;
		rsinterface.invStackSizes[4] = 0;
		rsinterface.invStackSizes[5] = 0;
		rsinterface.invStackSizes[6] = 0;
		rsinterface.invStackSizes[7] = 0;
		rsinterface.invStackSizes[8] = 0;
		rsinterface.invStackSizes[9] = 0;
		rsinterface.invStackSizes[10] = 0;
		rsinterface.invStackSizes[11] = 0;
		rsinterface.invStackSizes[12] = 0;
		rsinterface.invStackSizes[13] = 0;
		rsinterface.invStackSizes[14] = 0;
		rsinterface.invStackSizes[15] = 0;
		rsinterface.invStackSizes[16] = 0;
		rsinterface.invStackSizes[17] = 0;
		rsinterface.invStackSizes[18] = 0;
		rsinterface.invStackSizes[19] = 0;
		rsinterface.invStackSizes[20] = 0;
		rsinterface.invStackSizes[21] = 0;
		rsinterface.invStackSizes[22] = 0;
		rsinterface.invStackSizes[23] = 0;
		rsinterface.invStackSizes[24] = 0;
		rsinterface.invStackSizes[25] = 0;
		rsinterface.invStackSizes[26] = 0;
		rsinterface.invStackSizes[27] = 0;
		rsinterface.invStackSizes[28] = 0;
		rsinterface.invStackSizes[29] = 0;
		rsinterface.invStackSizes[30] = 0;
		rsinterface.invStackSizes[31] = 0;
		rsinterface.invStackSizes[32] = 0;
		rsinterface.invStackSizes[33] = 0;
		rsinterface.invStackSizes[34] = 0;
		rsinterface.invStackSizes[35] = 0;
		rsinterface.inv[0] = 0;
		rsinterface.inv[1] = 0;
		rsinterface.inv[2] = 0;
		rsinterface.inv[3] = 0;
		rsinterface.inv[4] = 0;
		rsinterface.inv[5] = 0;
		rsinterface.inv[6] = 0;
		rsinterface.inv[7] = 0;
		rsinterface.inv[8] = 0;
		rsinterface.inv[9] = 0;
		rsinterface.inv[10] = 0;
		rsinterface.inv[11] = 0;
		rsinterface.inv[12] = 0;
		rsinterface.inv[13] = 0;
		rsinterface.inv[14] = 0;
		rsinterface.inv[15] = 0;
		rsinterface.inv[16] = 0;
		rsinterface.inv[17] = 0;
		rsinterface.inv[18] = 0;
		rsinterface.inv[19] = 0;
		rsinterface.inv[20] = 0;
		rsinterface.inv[21] = 0;
		rsinterface.inv[22] = 0;
		rsinterface.inv[23] = 0;
		rsinterface.inv[24] = 0;
		rsinterface.inv[25] = 0;
		rsinterface.inv[26] = 0;
		rsinterface.inv[27] = 0;
		rsinterface.inv[28] = 0;
		rsinterface.inv[29] = 0;
		rsinterface.inv[30] = 0;
		rsinterface.inv[31] = 0;
		rsinterface.inv[32] = 0;
		rsinterface.inv[33] = 0;
		rsinterface.inv[34] = 0;
		rsinterface.inv[35] = 0;
		rsinterface.spritesX[0] = 0;
		rsinterface.spritesX[1] = 0;
		rsinterface.spritesX[2] = 0;
		rsinterface.spritesX[3] = 0;
		rsinterface.spritesX[4] = 0;
		rsinterface.spritesX[5] = 0;
		rsinterface.spritesX[6] = 0;
		rsinterface.spritesX[7] = 0;
		rsinterface.spritesX[8] = 0;
		rsinterface.spritesX[9] = 0;
		rsinterface.spritesX[10] = 0;
		rsinterface.spritesX[11] = 0;
		rsinterface.spritesX[12] = 0;
		rsinterface.spritesX[13] = 0;
		rsinterface.spritesX[14] = 0;
		rsinterface.spritesX[15] = 0;
		rsinterface.spritesX[16] = 0;
		rsinterface.spritesX[17] = 0;
		rsinterface.spritesX[18] = 0;
		rsinterface.spritesX[19] = 0;
		rsinterface.spritesX[20] = 0;
		rsinterface.spritesX[21] = 0;
		rsinterface.spritesX[22] = 0;
		rsinterface.spritesX[23] = 0;
		rsinterface.spritesX[24] = 0;
		rsinterface.spritesX[25] = 0;
		rsinterface.spritesX[26] = 0;
		rsinterface.spritesX[27] = 0;
		rsinterface.spritesX[28] = 0;
		rsinterface.spritesX[29] = 0;
		rsinterface.spritesX[30] = 0;
		rsinterface.spritesX[31] = 0;
		rsinterface.spritesX[32] = 0;
		rsinterface.spritesX[33] = 0;
		rsinterface.spritesX[34] = 0;
		rsinterface.spritesX[35] = 0;
		rsinterface.centerText = false;
		rsinterface.aBoolean227 = false;
		rsinterface.aBoolean235 = false;
		rsinterface.usableItemInterface = false;
		rsinterface.isInventoryInterface = false;
		rsinterface.usableItemInterface = false;
		rsinterface.aBoolean259 = true;
		rsinterface.isMouseoverTriggered = false;
		rsinterface.textShadow = false;
		rsinterface.width = 8;
		rsinterface.mOverInterToTrigger = -1;
		rsinterface.invSpritePadX = 24;
		rsinterface.parentID = 17827;
		rsinterface.invSpritePadY = 24;
		rsinterface.id = 17824;
		rsinterface.type = 2;
		rsinterface.height = 4;
	}

	public static void magicTab(TextDrawingArea tda[]) {
		RSInterface tab = addTabInterface(1151);
		RSInterface homeHover = addTabInterface(1196);
		RSInterface spellButtons = interfaceCache[12424];
		spellButtons.scrollMax = 0;
		spellButtons.height = 260;
		spellButtons.width = 190;
		int spellButton[] = { 1196, 1199, 1206, 1215, 1224, 1231, 1240, 1249,
				1258, 1267, 1274, 1283, 1573, 1290, 1299, 1308, 1315, 1324,
				1333, 1340, 1349, 1358, 1367, 1374, 1381, 1388, 1397, 1404,
				1583, 12038, 1414, 1421, 1430, 1437, 1446, 1453, 1460, 1469,
				15878, 1602, 1613, 1624, 7456, 1478, 1485, 1494, 1503, 1512,
				1521, 1530, 1544, 1553, 1563, 1593, 1635, 12426, 12436, 12446,
				12456, 6004, 18471 };
		tab.totalChildren(63);
		tab.child(0, 12424, 13, 24);
		for (int i1 = 0; i1 < spellButton.length; i1++) {
			int yPos = i1 <= 34 ? 183 : 8;
			tab.child(1, 1195, 13, 24);
			tab.child(i1 + 2, spellButton[i1], 5, yPos);
			addButton(1195, 1, "Magic/Home", "Cast @gre@Home Teleport");
			RSInterface homeButton = interfaceCache[1195];
			homeButton.mOverInterToTrigger = 1196;
		}
		for (int i2 = 0; i2 < spellButton.length; i2++) {
			if (i2 < 60) {
				spellButtons.childX[i2] = spellButtons.childX[i2] + 24;
			}
			if (i2 == 6 || i2 == 12 || i2 == 19 || i2 == 35 || i2 == 41
					|| i2 == 44 || i2 == 49 || i2 == 51) {
				spellButtons.childX[i2] = 0;
			}
			spellButtons.childY[6] = 24;
			spellButtons.childY[12] = 48;
			spellButtons.childY[19] = 72;
			spellButtons.childY[49] = 96;
			spellButtons.childY[44] = 120;
			spellButtons.childY[51] = 144;
			spellButtons.childY[35] = 170;
			spellButtons.childY[41] = 192;
		}
		homeHover.isMouseoverTriggered = true;
		addText(1197, "Level 0: Home Teleport", tda, 1, 0xfe981f, true, true);
		RSInterface homeLevel = interfaceCache[1197];
		homeLevel.width = 174;
		homeLevel.height = 68;
		addText(1198, "A teleport which requires no", tda, 0, 0xaf6a1a, true,
				true);
		addText(18998, "runes and no required level that", tda, 0, 0xaf6a1a,
				true, true);
		addText(18999, "teleports you to the main land.", tda, 0, 0xaf6a1a,
				true, true);
		homeHover.totalChildren(4);
		homeHover.child(0, 1197, 3, 4);
		homeHover.child(1, 1198, 91, 23);
		homeHover.child(2, 18998, 91, 34);
		homeHover.child(3, 18999, 91, 45);
	}

	private static Sprite method207(int i, StreamLoader streamLoader, String s) {
		long l = (TextClass.method585(s) << 8) + i;
		Sprite sprite = (Sprite) aMRUNodes_238.insertFromCache(l);
		if (sprite != null) {
			return sprite;
		}
		try {
			sprite = new Sprite(streamLoader, s, i);
			aMRUNodes_238.removeFromCache(sprite, l);
		} catch (Exception _ex) {
			return null;
		}
		return sprite;
	}

	public static void method208(boolean flag, Model model) {
		int i = 0;
		int j = 5;
		if (flag) {
			return;
		}
		aMRUNodes_264.unlinkAll();
		if (model != null && j != 4) {
			aMRUNodes_264.removeFromCache(model, (j << 16) + i);
		}
	}

	public static final void minigame(TextDrawingArea[] TDA) {
		RSInterface rsinterface = addTabInterface(45200);
		addText(45201, "Minigames Teleport", 0xff9b00, false, true, 52, TDA, 2);
		addHoverButton(45202, "Interfaces/Minigame/Hover", 0, 172, 24,
				"Duel Arena", -1, 45203, 1);
		addHoveredButton(45203, "Interfaces/Minigame/Hover", 4, 172, 24, 45204);
		addHoverButton(45218, "Interfaces/Minigame/Hover", 0, 172, 24,
				"Barrows", -1, 45219, 1);
		addHoveredButton(45219, "Interfaces/Minigame/Hover", 4, 172, 24, 45220);
		addHoverButton(45221, "Interfaces/Minigame/Hover", 0, 172, 24,
				"Pest Control", -1, 45222, 1);
		addHoveredButton(45222, "Interfaces/Minigame/Hover", 4, 172, 24, 45223);
		addHoverButton(45224, "Interfaces/Minigame/Hover", 0, 172, 24,
				"Tzhaar", -1, 45225, 1);
		addHoveredButton(45225, "Interfaces/Minigame/Hover", 4, 172, 24, 45226);
		addHoverButton(45227, "Interfaces/Minigame/Hover", 0, 172, 24,
				"Warriors Guild", -1, 45228, 1);
		addHoveredButton(45228, "Interfaces/Minigame/Hover", 4, 172, 24, 45229);
		addHoverButton(45233, "Interfaces/Minigame/Back", 0, 16, 16, "Back",
				-1, 45234, 1);
		addHoveredButton(45234, "Interfaces/Minigame/Back", 1, 16, 16, 45235);
		addSprite(45205, 1, "Interfaces/Minigame/DuelArena");
		addSprite(45206, 1, "Interfaces/Minigame/Barrows");
		addSprite(45207, 1, "Interfaces/Minigame/PestControl");
		addSprite(45208, 1, "Interfaces/Minigame/Tzhaar");
		addSprite(45209, 1, "Interfaces/Minigame/Warriors");
		addSprite(45211, 1, "Interfaces/Minigame/Background");
		addText(45212, "Duel Arena", 0xd67b29, true, true, 52, TDA, 2);
		addText(45213, "Barrows", 0xd67b29, true, true, 52, TDA, 2);
		addText(45214, "Pest Control", 0xd67b29, true, true, 52, TDA, 2);
		addText(45215, "Tzhaar", 0xd67b29, true, true, 52, TDA, 2);
		addText(45216, "Warriors Guild", 0xd67b29, true, true, 52, TDA, 2);
		byte childAmount = 24;
		int indexChild = 0;
		setChildren(childAmount, rsinterface);
		setBounds(45211, 0, 26, indexChild, rsinterface);
		indexChild++;
		setBounds(45201, 33, 7, indexChild, rsinterface);
		indexChild++;
		setBounds(45202, 8, 35, indexChild, rsinterface);
		indexChild++;
		setBounds(45203, 8, 35, indexChild, rsinterface);
		indexChild++;
		setBounds(45212, 80, 39, indexChild, rsinterface);
		indexChild++;
		setBounds(45218, 8, 72, indexChild, rsinterface);
		indexChild++;
		setBounds(45219, 8, 72, indexChild, rsinterface);
		indexChild++;
		setBounds(45213, 80, 76, indexChild, rsinterface);
		indexChild++;
		setBounds(45221, 8, 109, indexChild, rsinterface);
		indexChild++;
		setBounds(45222, 8, 109, indexChild, rsinterface);
		indexChild++;
		setBounds(45214, 80, 113, indexChild, rsinterface);
		indexChild++;
		setBounds(45224, 8, 146, indexChild, rsinterface);
		indexChild++;
		setBounds(45225, 8, 146, indexChild, rsinterface);
		indexChild++;
		setBounds(45215, 80, 150, indexChild, rsinterface);
		indexChild++;
		setBounds(45227, 8, 183, indexChild, rsinterface);
		indexChild++;
		setBounds(45228, 8, 183, indexChild, rsinterface);
		indexChild++;
		setBounds(45216, 80, 187, indexChild, rsinterface);
		indexChild++;
		setBounds(45205, 148, 33, indexChild, rsinterface);
		indexChild++;
		setBounds(45206, 148, 70, indexChild, rsinterface);
		indexChild++;
		setBounds(45207, 148, 104, indexChild, rsinterface);
		indexChild++;
		setBounds(45208, 148, 140, indexChild, rsinterface);
		indexChild++;
		setBounds(45209, 148, 179, indexChild, rsinterface);
		indexChild++;
		setBounds(45233, 10, 6, indexChild, rsinterface);
		indexChild++;
		setBounds(45234, 10, 6, indexChild, rsinterface);
		indexChild++;
	}

	public static void newLamp(TextDrawingArea[] tda) {
		RSInterface rsinterface = addTabInterface(52000);
		addSprite(52001, 1, "Interfaces/Lamp/lamp");
		addButton(52002, 1, "Interfaces/Lamp/X", "Exit");
		addHoverButton(52003, "Interfaces/Lamp/lamp", 2, 74, 22, "Confirm", -1,
				52004, 1);
		addHoveredButton(52004, "Interfaces/Lamp/lamp", 3, 74, 22, 52005);
		addButton(52006, 1, "Interfaces/Lamp/attack", "Select Attack");
		addButton(52007, 1, "Interfaces/Lamp/str", "Select Strength");
		addButton(52008, 1, "Interfaces/Lamp/range", "Select Ranged");
		addButton(52009, 1, "Interfaces/Lamp/mage", "Select Magic");
		addButton(52010, 1, "Interfaces/Lamp/def", "Select Defence");
		addButton(52011, 1, "Interfaces/Lamp/craft", "Select Crafting");
		addButton(52012, 1, "Interfaces/Lamp/hp", "Select Hitpoints");
		addButton(52013, 1, "Interfaces/Lamp/pray", "Select Prayer");
		addButton(52014, 1, "Interfaces/Lamp/agility", "Select Agility");
		addButton(52015, 1, "Interfaces/Lamp/herb", "Select Herblore");
		addButton(52016, 1, "Interfaces/Lamp/thiev", "Select Thieving");
		addButton(52017, 1, "Interfaces/Lamp/fish", "Select Fishing");
		addButton(52018, 1, "Interfaces/Lamp/rc", "Select Runecraft");
		addButton(52019, 1, "Interfaces/Lamp/slay", "Select Slayer");
		addButton(52020, 1, "Interfaces/Lamp/farm", "Select Farming");
		addButton(52021, 1, "Interfaces/Lamp/mine", "Select Mining");
		addButton(52022, 1, "Interfaces/Lamp/smith", "Select Smithing");
		addButton(52023, 1, "Interfaces/Lamp/hunt", "Select Hunter");
		addButton(52024, 1, "Interfaces/Lamp/cook", "Select Cooking");
		addButton(52025, 1, "Interfaces/Lamp/fm", "Select Firemaking");
		addButton(52026, 1, "Interfaces/Lamp/wc", "Select Woodcutting");
		addButton(52027, 1, "Interfaces/Lamp/fletch", "Select Fletching");
		addButton(52028, 1, "Interfaces/Lamp/con", "Select Construction");
		addButton(52029, 1, "Interfaces/Lamp/summ", "Select Summoning");
		addButton(52030, 1, "Interfaces/Lamp/dung", "Select Dungeoneering");
		rsinterface.totalChildren(29);
		rsinterface.child(0, 52001, 0, 0);
		rsinterface.child(1, 52002, 431, 11);
		rsinterface.child(2, 52003, 352, 237);
		rsinterface.child(3, 52004, 352, 237);
		rsinterface.child(4, 52006, 60, 60);
		rsinterface.child(5, 52007, 119, 60);
		rsinterface.child(6, 52008, 172, 60);
		rsinterface.child(7, 52009, 230, 60);
		rsinterface.child(8, 52010, 288, 60);
		rsinterface.child(9, 52011, 328, 60);
		rsinterface.child(10, 52012, 380, 60);
		rsinterface.child(11, 52013, 55, 115);
		rsinterface.child(12, 52014, 113, 115);
		rsinterface.child(13, 52015, 168, 115);
		rsinterface.child(14, 52016, 228, 124);
		rsinterface.child(15, 52017, 281, 115);
		rsinterface.child(16, 52018, 330, 115);
		rsinterface.child(17, 52019, 383, 115);
		rsinterface.child(18, 52020, 55, 171);
		rsinterface.child(19, 52021, 113, 171);
		rsinterface.child(20, 52022, 168, 174);
		rsinterface.child(21, 52023, 228, 171);
		rsinterface.child(22, 52024, 281, 171);
		rsinterface.child(23, 52025, 330, 171);
		rsinterface.child(24, 52026, 383, 171);
		rsinterface.child(25, 52027, 113, 227);
		rsinterface.child(26, 52028, 168, 227);
		rsinterface.child(27, 52029, 228, 228);
		rsinterface.child(28, 52030, 281, 227);
	}

	public static void NewSkillLamp(
			TextDrawingArea[] paramArrayOfTextDrawingArea) {
		RSInterface localRSInterface = addTabInterface(35000);

		setChildren(61, localRSInterface);
		addSprite(35001, 0, "Monsterray/NewSkillLamp/BACKGROUND");
		addHover(35002, 3, 0, 35003, 0, "Monsterray/NewSkillLamp/EXIT", 21, 21,
				"Exit");
		addHovered(35003, 1, "Monsterray/NewSkillLamp/EXIT", 21, 21, 35004);
		addSprite(35005, 0, "Monsterray/NewSkillLamp/BANNER");
		addText(35006, "Choose XP Type...", paramArrayOfTextDrawingArea, 1,
				14929103, true, true);
		addHoverButton(35007, "", 0, 46, 44, "Choose Attack", -1, 35008, 1);
		addHoveredButton(35008, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35009);
		addHoverButton(35010, "", 0, 46, 44, "Choose Magic", -1, 35011, 1);
		addHoveredButton(35011, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35012);
		addHoverButton(35013, "", 0, 46, 44, "Choose Mining", -1, 35014, 1);
		addHoveredButton(35014, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35015);
		addHoverButton(35016, "", 0, 46, 44, "Choose Woodcutting", -1, 35017, 1);
		addHoveredButton(35017, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35018);
		addHoverButton(35019, "", 0, 46, 44, "Choose Agility", -1, 35020, 1);
		addHoveredButton(35020, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35021);
		addHoverButton(35022, "", 0, 46, 44, "Choose Fletching", -1, 35023, 1);
		addHoveredButton(35023, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35024);
		addHoverButton(35025, "", 0, 46, 44, "Choose Thieving", -1, 35026, 1);
		addHoveredButton(35026, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35027);

		addHoverButton(35028, "", 0, 46, 44, "Choose Strength", -1, 35029, 1);
		addHoveredButton(35029, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35030);
		addHoverButton(35031, "", 0, 46, 44, "Choose Ranged", -1, 35032, 1);
		addHoveredButton(35032, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35033);
		addHoverButton(35034, "", 0, 46, 44, "Choose Smithing", -1, 35035, 1);
		addHoveredButton(35035, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35036);
		addHoverButton(35037, "", 0, 46, 44, "Choose Firemaking", -1, 35038, 1);
		addHoveredButton(35038, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35039);
		addHoverButton(35040, "", 0, 46, 44, "Choose Herblore", -1, 35041, 1);
		addHoveredButton(35041, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35042);
		addHoverButton(35043, "", 0, 46, 44, "Choose Slayer", -1, 35044, 1);
		addHoveredButton(35044, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35045);
		addHoverButton(35046, "", 0, 46, 44, "Choose Construction", -1, 35047,
				1);
		addHoveredButton(35047, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35048);

		addHoverButton(35049, "", 0, 46, 44, "Choose Defence", -1, 35050, 1);
		addHoveredButton(35050, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35051);
		addHoverButton(35052, "", 0, 46, 44, "Choose Prayer", -1, 35053, 1);
		addHoveredButton(35053, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35054);
		addHoverButton(35055, "", 0, 46, 44, "Choose Fishing", -1, 35056, 1);
		addHoveredButton(35056, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35057);
		addHoverButton(35058, "", 0, 46, 44, "Choose Crafting", -1, 35059, 1);
		addHoveredButton(35059, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35060);
		addHoverButton(35061, "", 0, 46, 44, "Choose Farming", -1, 35062, 1);
		addHoveredButton(35062, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35063);
		addHoverButton(35064, "", 0, 46, 44, "Choose Hunter", -1, 35065, 1);
		addHoveredButton(35065, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35066);
		addHoverButton(35067, "", 0, 46, 44, "Choose Summoning", -1, 35068, 1);
		addHoveredButton(35068, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35069);

		addHoverButton(35070, "", 0, 46, 44, "Choose Constitution", -1, 35071,
				1);
		addHoveredButton(35071, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35072);
		addHoverButton(35073, "", 0, 46, 44, "Choose Dungeoneering", -1, 35074,
				1);
		addHoveredButton(35074, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35075);
		addHoverButton(35076, "", 0, 46, 44, "Choose Cooking", -1, 35077, 1);
		addHoveredButton(35077, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35078);
		addHoverButton(35079, "", 0, 46, 44, "Choose Runecrafting", -1, 35080,
				1);
		addHoveredButton(35080, "Monsterray/NewSkillLamp/CIRCLE", 1, 46, 44,
				35081);

		addHover(35082, 3, 0, 35083, 0, "Monsterray/NewSkillLamp/CANCEL", 127,
				21, "");
		addHovered(35083, 1, "Monsterray/NewSkillLamp/CANCEL", 127, 21, 35084);
		addHoverButton(35085, "Monsterray/NewSkillLamp/CONFIRM", 0, 127, 21,
				"Confirm", -1, 35086, 1);
		addHoveredButton(35086, "Monsterray/NewSkillLamp/CONFIRM", 1, 127, 21,
				35087);
		addText(35088, "Confirm", paramArrayOfTextDrawingArea, 1, 14929103,
				false, true);
		addText(35089, "Not right now", paramArrayOfTextDrawingArea, 1,
				14929103, false, true);

		setBounds(35001, 10, 14, 0, localRSInterface);
		setBounds(35002, 470, 20, 1, localRSInterface);
		setBounds(35003, 470, 20, 2, localRSInterface);
		setBounds(35005, 181, 48, 3, localRSInterface);
		setBounds(35006, 255, 52, 4, localRSInterface);

		setBounds(35007, 37, 80, 5, localRSInterface);
		setBounds(35008, 37, 80, 6, localRSInterface);
		setBounds(35010, 102, 80, 7, localRSInterface);
		setBounds(35011, 102, 80, 8, localRSInterface);
		setBounds(35013, 167, 80, 9, localRSInterface);
		setBounds(35014, 167, 80, 10, localRSInterface);
		setBounds(35016, 232, 80, 11, localRSInterface);
		setBounds(35017, 232, 80, 12, localRSInterface);
		setBounds(35019, 297, 80, 13, localRSInterface);
		setBounds(35020, 297, 80, 14, localRSInterface);
		setBounds(35022, 362, 80, 15, localRSInterface);
		setBounds(35023, 362, 80, 16, localRSInterface);
		setBounds(35025, 427, 80, 17, localRSInterface);
		setBounds(35026, 427, 80, 18, localRSInterface);

		setBounds(35028, 37, 138, 19, localRSInterface);
		setBounds(35029, 37, 138, 20, localRSInterface);
		setBounds(35031, 102, 138, 21, localRSInterface);
		setBounds(35032, 102, 138, 22, localRSInterface);
		setBounds(35034, 167, 138, 23, localRSInterface);
		setBounds(35035, 167, 138, 24, localRSInterface);
		setBounds(35037, 232, 138, 25, localRSInterface);
		setBounds(35038, 232, 138, 26, localRSInterface);
		setBounds(35040, 297, 138, 27, localRSInterface);
		setBounds(35041, 297, 138, 28, localRSInterface);
		setBounds(35043, 362, 138, 29, localRSInterface);
		setBounds(35044, 362, 138, 30, localRSInterface);
		setBounds(35046, 427, 138, 31, localRSInterface);
		setBounds(35047, 427, 138, 32, localRSInterface);

		setBounds(35049, 37, 196, 33, localRSInterface);
		setBounds(35050, 37, 196, 34, localRSInterface);
		setBounds(35052, 102, 196, 35, localRSInterface);
		setBounds(35053, 102, 196, 36, localRSInterface);
		setBounds(35055, 167, 196, 37, localRSInterface);
		setBounds(35056, 167, 196, 38, localRSInterface);
		setBounds(35058, 232, 196, 39, localRSInterface);
		setBounds(35059, 232, 196, 40, localRSInterface);
		setBounds(35061, 297, 196, 41, localRSInterface);
		setBounds(35062, 297, 196, 42, localRSInterface);
		setBounds(35064, 362, 196, 43, localRSInterface);
		setBounds(35065, 362, 196, 44, localRSInterface);
		setBounds(35067, 427, 196, 45, localRSInterface);
		setBounds(35068, 427, 196, 46, localRSInterface);

		setBounds(35070, 37, 254, 47, localRSInterface);
		setBounds(35071, 37, 254, 48, localRSInterface);
		setBounds(35073, 102, 254, 49, localRSInterface);
		setBounds(35074, 102, 254, 50, localRSInterface);
		setBounds(35076, 167, 254, 51, localRSInterface);
		setBounds(35077, 167, 254, 52, localRSInterface);
		setBounds(35079, 232, 254, 53, localRSInterface);
		setBounds(35080, 232, 254, 54, localRSInterface);

		setBounds(35082, 322, 280, 55, localRSInterface);
		setBounds(35083, 322, 280, 56, localRSInterface);
		setBounds(35085, 322, 250, 57, localRSInterface);
		setBounds(35086, 322, 250, 58, localRSInterface);
		setBounds(35088, 360, 253, 59, localRSInterface);
		setBounds(35089, 350, 283, 60, localRSInterface);
	}

	public static void optionTab(TextDrawingArea tda[]) {
		RSInterface Interface = addTabInterface(904);
		setChildren(46, Interface);
		addSprite(25801, 0, "/OptionTab/OPTION");
		addSprite(25802, 1, "/OptionTab/OPTION");
		addSprite(25803, 1, "/OptionTab/OPTION");
		addSprite(25804, 1, "/OptionTab/OPTION");
		setBounds(25801, 49, 17, 0, Interface);
		setBounds(25802, 49, 54, 1, Interface);
		setBounds(25803, 49, 90, 2, Interface);
		setBounds(25804, 49, 127, 3, Interface);
		addButton(25805, 5, -1, 2, 2, "/OptionTab/OPTION", 32, 32,
				"Adjust Brightness", 166, 1);
		setBounds(25805, 9, 8, 4, Interface);
		addButton(25806, 5, -1, -1, 18, "/OptionTab/OPTION", 16, 16, "Select",
				166, 1);
		addButton(25807, 5, -1, -1, 18, "/OptionTab/OPTION", 16, 16, "Select",
				166, 2);
		addButton(25808, 5, -1, -1, 18, "/OptionTab/OPTION", 16, 16, "Select",
				166, 3);
		addButton(25809, 5, -1, -1, 18, "/OptionTab/OPTION", 16, 16, "Select",
				166, 4);
		setBounds(25806, 57, 16, 5, Interface);
		setBounds(25807, 88, 16, 6, Interface);
		setBounds(25808, 119, 16, 7, Interface);
		setBounds(25809, 153, 16, 8, Interface);
		addButton(25810, 5, -1, 3, 4, "/OptionTab/OPTION", 32, 32,
				"Adjust Music Level", 168, 4);
		setBounds(25810, 9, 45, 9, Interface);
		addButton(25811, 5, -1, -1, 18, "/OptionTab/OPTION", 16, 16, "Select",
				168, 4);
		addButton(25812, 5, -1, -1, 18, "/OptionTab/OPTION", 16, 16, "Select",
				168, 3);
		addButton(25813, 5, -1, -1, 18, "/OptionTab/OPTION", 16, 16, "Select",
				168, 2);
		addButton(25814, 5, -1, -1, 18, "/OptionTab/OPTION", 16, 16, "Select",
				168, 1);
		addButton(25815, 5, -1, -1, 18, "/OptionTab/OPTION", 16, 16, "Select",
				168, 0);
		setBounds(25811, 54, 53, 10, Interface);
		setBounds(25812, 78, 53, 11, Interface);
		setBounds(25813, 105, 53, 12, Interface);
		setBounds(25814, 131, 53, 13, Interface);
		setBounds(25815, 156, 53, 14, Interface);
		addButton(25816, 5, -1, 5, 6, "/OptionTab/OPTION", 32, 32,
				"Adjust Sounds", 169, 4);
		setBounds(25816, 9, 81, 15, Interface);
		addButton(25817, 5, -1, -1, 18, "/OptionTab/OPTION", 16, 16, "Select",
				169, 4);
		addButton(25818, 5, -1, -1, 18, "/OptionTab/OPTION", 16, 16, "Select",
				169, 3);
		addButton(25819, 5, -1, -1, 18, "/OptionTab/OPTION", 16, 16, "Select",
				169, 2);
		addButton(25820, 5, -1, -1, 18, "/OptionTab/OPTION", 16, 16, "Select",
				169, 1);
		addButton(25821, 5, -1, -1, 18, "/OptionTab/OPTION", 16, 16, "Select",
				169, 0);
		setBounds(25817, 54, 89, 16, Interface);
		setBounds(25818, 78, 89, 17, Interface);
		setBounds(25819, 105, 89, 18, Interface);
		setBounds(25820, 131, 89, 19, Interface);
		setBounds(25821, 156, 89, 20, Interface);
		addButton(25822, 5, -1, 7, 8, "/OptionTab/OPTION", 32, 32,
				"Adjust Sound Effects", 400, 0);
		setBounds(25822, 10, 119, 21, Interface);
		addButton(25823, 5, -1, -1, 18, "/OptionTab/OPTION", 16, 16, "Select",
				400, 0);
		addButton(25824, 5, -1, -1, 18, "/OptionTab/OPTION", 16, 16, "Select",
				400, 1);
		addButton(25825, 5, -1, -1, 18, "/OptionTab/OPTION", 16, 16, "Select",
				400, 2);
		addButton(25826, 5, -1, -1, 18, "/OptionTab/OPTION", 16, 16, "Select",
				400, 3);
		addButton(25827, 5, -1, -1, 18, "/OptionTab/OPTION", 16, 16, "Select",
				400, 4);
		setBounds(25823, 54, 126, 22, Interface);
		setBounds(25824, 78, 126, 23, Interface);
		setBounds(25825, 105, 126, 24, Interface);
		setBounds(25826, 131, 126, 25, Interface);
		setBounds(25827, 156, 126, 26, Interface);
		addButton(25828, 4, 25829, 9, 10, "/OptionTab/OPTION", 40, 40,
				"Toggle Mouse Buttons", 170, 1);
		addTooltip(25829, "Toggle Mouse Buttons");
		addButton(25831, 4, 25832, 9, 10, "/OptionTab/OPTION", 40, 40,
				"Toggle Chat Effects", 171, 1);
		addTooltip(25832, "Toggle Chat Effects");
		addButton(25834, 4, 25835, 9, 10, "/OptionTab/OPTION", 40, 40,
				"Toggle Split-Level Chat", 287, 1);
		addTooltip(25835, "Toggle Split-Level Chat");
		addButton(25837, 4, 25838, 9, 10, "/OptionTab/OPTION", 40, 40,
				"Toggle Fullscreen", 427, 0);
		addTooltip(25838, "Toggle Fullscreen");
		addButton(152, 4, 25841, 9, 10, "/OptionTab/OPTION", 40, 40,
				"Toggle Run Mode", 173, 1);
		addTooltip(25841, "Toggle Run-Mode");
		addButton(25842, 4, 25843, 9, 10, "/OptionTab/OPTION", 40, 40,
				"More Options", 175, 1);
		addTooltip(25843, "More client options,\\nincluding fullscreen");
		setBounds(25828, 19, 152, 27, Interface);
		setBounds(25831, 75, 152, 28, Interface);
		setBounds(25834, 131, 152, 29, Interface);
		setBounds(25837, 19, 206, 30, Interface);
		setBounds(152, 75, 206, 31, Interface);
		setBounds(25857, 78, 159, 32, Interface);
		setBounds(25858, 136, 158, 33, Interface);
		setBounds(25859, 23, 212, 34, Interface);
		setBounds(25860, 86, 210, 35, Interface);
		setBounds(25856, 23, 159, 36, Interface);
		setBounds(25829, 19, 130, 37, Interface);
		setBounds(25832, 78, 130, 38, Interface);
		setBounds(25835, 71, 130, 39, Interface);
		setBounds(25838, 19, 185, 40, Interface);
		setBounds(25841, 78, 185, 41, Interface);
		setBounds(25842, 131, 206, 42, Interface);
		setBounds(25861, 139, 217, 43, Interface);
		setBounds(25843, 137, 185, 44, Interface);
		addSprite(25856, 11, "/OptionTab/OPTION");
		addSprite(25857, 12, "/OptionTab/OPTION");
		addSprite(25858, 13, "/OptionTab/OPTION");
		addSprite(25859, 14, "/OptionTab/OPTION");
		addSprite(25860, 15, "/OptionTab/OPTION");
		addSprite(25861, 12, "/sideicon/sideicons");
		addText(149, "100%", 0xff9800, true, true, 52, tda, 1);
		setBounds(149, 94, 230, 45, Interface);
	}

	public static void passwordChanger(TextDrawingArea tda[]) {
		int xPos = 71;
		int yPos = 92;
		RSInterface Interface = addTabInterface(22595);
		setChildren(6, Interface);
		addSprite(22596, 0, "interfaces/password/backing");
		addButton(22597, 0, "interfaces/password/button", 53, 21, "Change", 1);
		addButton(22598, 1, "interfaces/password/button", 53, 21, "Close", 3);
		addText(22599, "Password Changer", 0xff981f, false, true, 52, tda, 2);
		addText(22600, "Choose your new password.", 0xffffff, false, true, 52,
				tda, 0);
		addText(22601, "Password Strength: None.", 0xf3ede1, false, true, 52,
				tda, 1);
		setBounds(22596, xPos, yPos, 0, Interface);
		setBounds(22597, xPos + 120, yPos + 114, 1, Interface);
		setBounds(22598, xPos + 215, yPos + 114, 2, Interface);
		setBounds(22599, xPos + 125, yPos + 7, 3, Interface);
		setBounds(22600, xPos + 153, yPos + 30, 4, Interface);
		setBounds(22601, xPos + 10, yPos + 96, 5, Interface);
	}

	public static void Pestpanel(TextDrawingArea tda[]) {
		RSInterface RSinterface = addInterface(27119);
		addText(27120, "What", 0x999999, false, true, 52, tda, 1);
		addText(27121, "What", 0x33cc00, false, true, 52, tda, 1);
		addText(27122, "(Need 5 to 25 players)", 0xffcc33, false, true, 52,
				tda, 1);
		addText(27123, "Points", 0x33ccff, false, true, 52, tda, 1);
		int last = 4;
		RSinterface.children = new int[last];
		RSinterface.childX = new int[last];
		RSinterface.childY = new int[last];
		setBounds(27120, 15, 12, 0, RSinterface);
		setBounds(27121, 15, 30, 1, RSinterface);
		setBounds(27122, 15, 48, 2, RSinterface);
		setBounds(27123, 15, 66, 3, RSinterface);
	}

	public static void Pestpanel2(TextDrawingArea tda[]) {
		RSInterface RSinterface = addInterface(21100);
		addSprite(21101, 0, "Pest Control/PEST1");
		addSprite(21102, 1, "Pest Control/PEST1");
		addSprite(21103, 2, "Pest Control/PEST1");
		addSprite(21104, 3, "Pest Control/PEST1");
		addSprite(21105, 4, "Pest Control/PEST1");
		addSprite(21106, 5, "Pest Control/PEST1");
		addText(21107, "", 0xcc00cc, false, true, 52, tda, 1);
		addText(21108, "", 255, false, true, 52, tda, 1);
		addText(21109, "", 0xffff44, false, true, 52, tda, 1);
		addText(21110, "", 0xcc0000, false, true, 52, tda, 1);
		addText(21111, "250", 0x99ff33, false, true, 52, tda, 1);
		addText(21112, "250", 0x99ff33, false, true, 52, tda, 1);
		addText(21113, "250", 0x99ff33, false, true, 52, tda, 1);
		addText(21114, "250", 0x99ff33, false, true, 52, tda, 1);
		addText(21115, "200", 0x99ff33, false, true, 52, tda, 1);
		addText(21116, "0", 0x99ff33, false, true, 52, tda, 1);
		addText(21117, "Time Remaining:", 0xffffff, false, true, 52, tda, 0);
		addText(21118, "", 0xffffff, false, true, 52, tda, 0);
		int last = 18;
		RSinterface.children = new int[last];
		RSinterface.childX = new int[last];
		RSinterface.childY = new int[last];
		setBounds(21101, 361, 26, 0, RSinterface);
		setBounds(21102, 396, 26, 1, RSinterface);
		setBounds(21103, 436, 26, 2, RSinterface);
		setBounds(21104, 474, 26, 3, RSinterface);
		setBounds(21105, 3, 21, 4, RSinterface);
		setBounds(21106, 3, 50, 5, RSinterface);
		setBounds(21107, 371, 60, 6, RSinterface);
		setBounds(21108, 409, 60, 7, RSinterface);
		setBounds(21109, 443, 60, 8, RSinterface);
		setBounds(21110, 479, 60, 9, RSinterface);
		setBounds(21111, 362, 10, 10, RSinterface);
		setBounds(21112, 398, 10, 11, RSinterface);
		setBounds(21113, 436, 10, 12, RSinterface);
		setBounds(21114, 475, 10, 13, RSinterface);
		setBounds(21115, 32, 32, 14, RSinterface);
		setBounds(21116, 32, 62, 15, RSinterface);
		setBounds(21117, 8, 88, 16, RSinterface);
		setBounds(21118, 87, 88, 17, RSinterface);
	}

	public static void pkingTab(TextDrawingArea[] TDA) {
		RSInterface Interface = addInterface(648);
		setChildren(4, Interface);
		addText(49155, "PKing Tab", 0xFF981F, false, true, 52, TDA, 2);
		addButton(49156, 2, "QuestTab/QUEST", 18, 18, "PKing Tab", 1);
		addSprite(49157, 0, "Interfaces/QuestTab/QUEST");
		setBounds(49155, 10, 5, 0, Interface);
		setBounds(49156, 165, 5, 1, Interface);
		setBounds(49157, 3, 24, 2, Interface);
		setBounds(49160, 5, 49, 3, Interface);
		Interface = addInterface(49160);
		Interface.height = 214;
		Interface.width = 165;
		Interface.scrollMax = 1700;
		setChildren(105, Interface);
		addText(49161, "", 0xFF981F, false, true, 52, TDA, 2);
		addHoverText(49162, "", "", TDA, 0, 0xff0000, false, true, 150);
		addText(49163, "", 0xFF981F, false, true, 52, TDA, 2);
		addHoverText(49164, "", "", TDA, 0, 0xff0000, false, true, 150);
		addText(49165, "", 0xFF981F, false, true, 52, TDA, 2);
		addHoverText(49166, "", "", TDA, 0, 0xff0000, false, true, 150);
		setBounds(49161, 4, 4, 0, Interface);
		setBounds(49162, 8, 22, 1, Interface);
		setBounds(49163, 4, 35, 2, Interface);
		setBounds(49164, 8, 53, 3, Interface);
		setBounds(663, 4, 67, 4, Interface);
		int Ypos = 83;
		int frameID = 5;
		for (int iD = 49165; iD <= 49264; iD++) {
			addHoverText(iD, "", "Continue"/* "View Quest Journal, "+iD */,
					TDA, 0, 0xff0000, false, true, 150);
			setBounds(iD, 8, Ypos, frameID, Interface);
			frameID++;
			Ypos += 15;
			Ypos++;
		}
		Interface = addInterface(49265);
		try {
			setChildren(4, Interface);
			addText(49266, "Coming soon!", 0xFF981F, false, true, -1, TDA, 2);
			addButton(49267, 1, "Interfaces/QuestTab/QUEST", 18, 18, "", 1);
			addSprite(49269, 0, "Interfaces/QuestTab/QUEST");
			setBounds(49266, 10, 5, 0, Interface);
			setBounds(49267, 165, 5, 1, Interface);
			setBounds(49269, 3, 24, 2, Interface);
			setBounds(49268, 5, 49, 3, Interface);
			Interface = addInterface(49268);
			Interface.height = 214;
			Interface.width = 165;
			Interface.scrollMax = 1700;
			setChildren(20, Interface);
			setBounds(49495, 8, 4, 0, Interface);
			setBounds(49496, 8, 16, 1, Interface);
			setBounds(49497, 8, 49, 2, Interface);
			setBounds(49498, 8, 42, 3, Interface);
			setBounds(49499, 8, 54, 4, Interface);
			setBounds(49300, 8, 66, 5, Interface);
			setBounds(49301, 8, 78, 6, Interface);
			setBounds(49302, 8, 90, 7, Interface);
			setBounds(49303, 8, 102, 8, Interface);
			setBounds(49304, 8, 114, 9, Interface);
			setBounds(49305, 8, 126, 10, Interface);
			setBounds(49306, 8, 138, 11, Interface);
			setBounds(49307, 8, 150, 12, Interface);
			setBounds(49308, 8, 162, 13, Interface);
			setBounds(49309, 8, 174, 14, Interface);
			setBounds(49310, 8, 186, 15, Interface);
			setBounds(49311, 8, 498, 16, Interface);
			setBounds(49312, 8, 210, 17, Interface);
			setBounds(49313, 8, 222, 18, Interface);
			setBounds(49314, 8, 234, 19, Interface);// lol fail ur error is
													// fixed. :D ty
			addHoverText(49495, "Please register at", "Please Register", TDA,
					1, 0xFF981F, false, true, 150);
			addHoverText(49496, "InsanityX.Net", "", TDA, 0, 0xff0000, false,
					true, 150);
			addHoverText(49497, "And advertise/vote daily!", "", TDA, 0,
					0xff0000, false, true, 150);
			addHoverText(49498, "::vote for more players!", "", TDA, 0,
					0xff0000, false, true, 150);
			addHoverText(49499, "More players=More updates!", "", TDA, 0,
					0xff0000, false, true, 150);
			addHoverText(49300, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(49301, "", "", TDA, 1, 0xFF981F, false, true, 150);
			addHoverText(49302, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(49303, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(49304, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(49305, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(49306, "", "", TDA, 1, 0xFF981F, false, true, 150);
			addHoverText(49307, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(49308, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(49309, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(49310, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(49311, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(49312, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(49313, "", "", TDA, 0, 0xff0000, false, true, 150);
			addHoverText(49314, "", "", TDA, 0, 0xff0000, false, true, 150);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void pouchCreation(TextDrawingArea TDA[]) {
		int totalScrolls = pouchItems.length;
		int xPadding = 53;
		int yPadding = 57;
		int xPos = 13;
		int yPos = 20;
		RSInterface rsinterface = addTabInterface(23471);
		setChildren(7, rsinterface);
		addSprite(23472, 1, "interfaces/summoning/creation/summoning");
		addButton(23475, 0, "interfaces/summoning/creation/tab",
				"Transform Scolls");
		addSprite(23474, 1, "interfaces/summoning/creation/pouch");
		addSprite(23473, 1, "interfaces/summoning/creation/tab");
		addSprite(23476, 0, "interfaces/summoning/creation/scroll");
		addInAreaHover(23477, "interfaces/summoning/creation/close", 0, 1, 16,
				16, "Close", 250, 3);
		RSInterface scroll = addTabInterface(23478);
		setChildren(3 * totalScrolls, scroll);
		for (int i = 0; i < totalScrolls; i++) {
			addInAreaHover(23479 + i * 8, "interfaces/summoning/creation/box",
					0, 1, 48, 52, "nothing", -1, 0);
			int req[] = { 1, 2, 3 };
			addPouch(23480 + i * 8, req, 1, pouchItems[i],
					summoningLevelRequirements[i], pouchNames[i], TDA, i, 5);
			addSprite(23485 + i * 8, pouchItems[i], null, 50, 50);
			setBounds(23479 + i * 8, 36 + (i % 8) * xPadding, 0 + (i / 8)
					* yPadding, 0 + i * 2, scroll);
			setBounds(23480 + i * 8, 43 + (i % 8) * xPadding, 2 + (i / 8)
					* yPadding, 1 + i * 2, scroll);
		}
		for (int i = 0; i < totalScrolls; i++) {
			int drawX = 5 + (i % 8) * xPadding;
			if (drawX > 292) {
				drawX -= 90;
			}
			int drawY = 55 + (i / 8) * yPadding;
			if (drawY > 160) {
				drawY -= 80;
			}
			setBounds(23481 + i * 8, drawX, drawY, 2 + (totalScrolls - 1) * 2
					+ i, scroll);
		}
		scroll.parentID = 23478;
		scroll.id = 23478;
		scroll.atActionType = 0;
		scroll.contentType = 0;
		scroll.width = 474;
		scroll.height = 257;
		scroll.scrollMax = 570;
		setBounds(23472, xPos, yPos, 0, rsinterface);
		setBounds(23473, xPos + 9, yPos + 9, 1, rsinterface);
		setBounds(23474, xPos + 29, yPos + 10, 2, rsinterface);
		setBounds(23475, xPos + 79, yPos + 9, 3, rsinterface);
		setBounds(23476, xPos + 106, yPos + 10, 4, rsinterface);
		setBounds(23477, xPos + 461, yPos + 10, 5, rsinterface);
		setBounds(23478, 0, yPos + 39, 6, rsinterface);
	}

	public static void prayerMenu(TextDrawingArea TDA[]) {
		RSInterface prayerMenu = addInterface(5608);
		int index = 0;
		int prayIndex = 0;
		int firstRowXPos = 10;
		int firstRowYPos = 50;
		int secondRowXPos = 10;
		int secondRowYPos = 86;
		int thirdRowXPos = 10;
		int thirdRowYPos = 122;
		int fourthRowXPos = 10;
		int fourthRowYPos = 159;
		int fifthRowXPos = 10;
		int fifthRowYPos = 86;
		int sixthRowXPos = 1;
		int sixthRowYPos = 52;
		addText(687, "", 0xff981f, false, true, -1, TDA, 1);
		addSprite(25105, 0, "Interfaces/PrayerTab/PRAYERICON");
		addPrayerWithTooltip(25000, 0, 83, 0, prayIndex, 25052,
				"Activate @lre@Thick Skin");
		prayIndex++;
		addPrayerWithTooltip(25002, 0, 84, 3, prayIndex, 25054,
				"Activate @lre@Burst of Strength");
		prayIndex++;
		addPrayerWithTooltip(25004, 0, 85, 6, prayIndex, 25056,
				"Activate @lre@Clarity of Thought");
		prayIndex++;
		addPrayerWithTooltip(25006, 0, 601, 7, prayIndex, 25058,
				"Activate @lre@Sharp Eye");
		prayIndex++;
		addPrayerWithTooltip(25008, 0, 602, 8, prayIndex, 25060,
				"Activate @lre@Mystic Will");
		prayIndex++;
		addPrayerWithTooltip(25010, 0, 86, 9, prayIndex, 25062,
				"Activate @lre@Rock Skin");
		prayIndex++;
		addPrayerWithTooltip(25012, 0, 87, 12, prayIndex, 25064,
				"Activate @lre@Superhuman Strength");
		prayIndex++;
		addPrayerWithTooltip(25014, 0, 88, 15, prayIndex, 25066,
				"Activate @lre@Improved Reflexes");
		prayIndex++;
		addPrayerWithTooltip(25016, 0, 89, 18, prayIndex, 25068,
				"Activate @lre@Rapid Restore");
		prayIndex++;
		addPrayerWithTooltip(25018, 0, 90, 21, prayIndex, 25070,
				"Activate @lre@Rapid Heal");
		prayIndex++;
		addPrayerWithTooltip(25020, 0, 91, 24, prayIndex, 25072,
				"Activate @lre@Protect Item");
		prayIndex++;
		addPrayerWithTooltip(25022, 0, 603, 25, prayIndex, 25074,
				"Activate @lre@Hawk Eye");
		prayIndex++;
		addPrayerWithTooltip(25024, 0, 604, 26, prayIndex, 25076,
				"Activate @lre@Mystic Lore");
		prayIndex++;
		addPrayerWithTooltip(25026, 0, 92, 27, prayIndex, 25078,
				"Activate @lre@Steel Skin");
		prayIndex++;
		addPrayerWithTooltip(25028, 0, 93, 30, prayIndex, 25080,
				"Activate @lre@Ultimate Strength");
		prayIndex++;
		addPrayerWithTooltip(25030, 0, 94, 33, prayIndex, 25082,
				"Activate @lre@Incredible Reflexes");
		prayIndex++;
		addPrayerWithTooltip(25032, 0, 95, 36, prayIndex, 25084,
				"Activate @lre@Protect from Magic");
		prayIndex++;
		addPrayerWithTooltip(25034, 0, 96, 39, prayIndex, 25086,
				"Activate @lre@Protect from Missles");
		prayIndex++;
		addPrayerWithTooltip(25036, 0, 97, 42, prayIndex, 25088,
				"Activate @lre@Protect from Melee");
		prayIndex++;
		addPrayerWithTooltip(25038, 0, 605, 43, prayIndex, 25090,
				"Activate @lre@Eagle Eye");
		prayIndex++;
		addPrayerWithTooltip(25040, 0, 606, 44, prayIndex, 25092,
				"Activate @lre@Mystic Might");
		prayIndex++;
		addPrayerWithTooltip(25042, 0, 98, 45, prayIndex, 25094,
				"Activate @lre@Retribution");
		prayIndex++;
		addPrayerWithTooltip(25044, 0, 99, 48, prayIndex, 25096,
				"Activate @lre@Redemption");
		prayIndex++;
		addPrayerWithTooltip(25046, 0, 100, 51, prayIndex, 25098,
				"Activate @lre@Smite");
		prayIndex++;
		addPrayerWithTooltip(25048, 0, 607, 59, prayIndex, 25100,
				"Activate @lre@Chivalry");
		prayIndex++;
		addPrayerWithTooltip(25050, 0, 608, 69, prayIndex, 25102,
				"Activate @lre@Piety");
		prayIndex++;
		addTooltip(25052, "Level 01\nThick Skin\nIncreases your Defence by 5%");
		addTooltip(25054,
				"Level 04\nBurst of Strength\nIncreases your Strength by 5%");
		addTooltip(25056,
				"Level 07\nClarity of Thought\nIncreases your Attack by 5%");
		addTooltip(25058, "Level 08\nSharp Eye\nIncreases your Ranged by 5%");
		addTooltip(25060, "Level 09\nMystic Will\nIncreases your Magic by 5%");
		addTooltip(25062, "Level 10\nRock Skin\nIncreases your Defence by 10%");
		addTooltip(25064,
				"Level 13\nSuperhuman Strength\nIncreases your Strength by 10%");
		addTooltip(25066,
				"Level 16\nImproved Reflexes\nIncreases your Attack by 10%");
		addTooltip(
				25068,
				"Level 19\nRapid Restore\n2x restore rate for all stats\nexcept Hitpoints, Summoning\nand Prayer");
		addTooltip(25070,
				"Level 22\nRapid Heal\n2x restore rate for the\nHitpoints stat");
		addTooltip(25072,
				"Level 25\nProtect Item\nKeep 1 extra item if you die");
		addTooltip(25074, "Level 26\nHawk Eye\nIncreases your Ranged by 10%");
		addTooltip(25076, "Level 27\nMystic Lore\nIncreases your Magic by 10%");
		addTooltip(25078, "Level 28\nSteel Skin\nIncreases your Defence by 15%");
		addTooltip(25080,
				"Level 31\nUltimate Strength\nIncreases your Strength by 15%");
		addTooltip(25082,
				"Level 34\nIncredible Reflexes\nIncreases your Attack by 15%");
		addTooltip(25084,
				"Level 37\nProtect from Magic\nProtection from magical attacks");
		addTooltip(25086,
				"Level 40\nProtect from Missles\nProtection from ranged attacks");
		addTooltip(25088,
				"Level 43\nProtect from Melee\nProtection from melee attacks");
		addTooltip(25090, "Level 44\nEagle Eye\nIncreases your Ranged by 15%");
		addTooltip(25092, "Level 45\nMystic Might\nIncreases your Magic by 15%");
		addTooltip(25094,
				"Level 46\nRetribution\nInflicts damage to nearby\ntargets if you die");
		addTooltip(25096,
				"Level 49\nRedemption\nHeals you when damaged\nand Hitpoints falls\nbelow 10%");
		addTooltip(25098,
				"Level 52\nSmite\n1/4 of damage dealt is\nalso removed from\nopponent's Prayer");
		addTooltip(
				25100,
				"Level 60\nChivalry\nIncreases your Defence by 20%,\nStrength by 18%, and Attack by\n15%");
		addTooltip(
				25102,
				"Level 70\nPiety\nIncreases your Defence by 25%,\nStrength by 23%, and Attack by\n20%");
		setChildren(80, prayerMenu);
		setBounds(687, 85, 241, index, prayerMenu);
		index++;
		setBounds(25105, 65, 241, index, prayerMenu);
		index++;
		setBounds(25000, 2, 5, index, prayerMenu);
		index++;
		setBounds(25001, 5, 8, index, prayerMenu);
		index++;
		setBounds(25002, 40, 5, index, prayerMenu);
		index++;
		setBounds(25003, 44, 8, index, prayerMenu);
		index++;
		setBounds(25004, 76, 5, index, prayerMenu);
		index++;
		setBounds(25005, 79, 11, index, prayerMenu);
		index++;
		setBounds(25006, 113, 5, index, prayerMenu);
		index++;
		setBounds(25007, 116, 10, index, prayerMenu);
		index++;
		setBounds(25008, 150, 5, index, prayerMenu);
		index++;
		setBounds(25009, 153, 9, index, prayerMenu);
		index++;
		setBounds(25010, 2, 45, index, prayerMenu);
		index++;
		setBounds(25011, 5, 48, index, prayerMenu);
		index++;
		setBounds(25012, 39, 45, index, prayerMenu);
		index++;
		setBounds(25013, 44, 47, index, prayerMenu);
		index++;
		setBounds(25014, 76, 45, index, prayerMenu);
		index++;
		setBounds(25015, 79, 49, index, prayerMenu);
		index++;
		setBounds(25016, 113, 45, index, prayerMenu);
		index++;
		setBounds(25017, 116, 50, index, prayerMenu);
		index++;
		setBounds(25018, 151, 45, index, prayerMenu);
		index++;
		setBounds(25019, 154, 50, index, prayerMenu);
		index++;
		setBounds(25020, 2, 82, index, prayerMenu);
		index++;
		setBounds(25021, 4, 84, index, prayerMenu);
		index++;
		setBounds(25022, 40, 82, index, prayerMenu);
		index++;
		setBounds(25023, 44, 87, index, prayerMenu);
		index++;
		setBounds(25024, 77, 82, index, prayerMenu);
		index++;
		setBounds(25025, 81, 85, index, prayerMenu);
		index++;
		setBounds(25026, 114, 83, index, prayerMenu);
		index++;
		setBounds(25027, 117, 85, index, prayerMenu);
		index++;
		setBounds(25028, 153, 83, index, prayerMenu);
		index++;
		setBounds(25029, 156, 87, index, prayerMenu);
		index++;
		setBounds(25030, 2, 120, index, prayerMenu);
		index++;
		setBounds(25031, 5, 125, index, prayerMenu);
		index++;
		setBounds(25032, 40, 120, index, prayerMenu);
		index++;
		setBounds(25033, 43, 124, index, prayerMenu);
		index++;
		setBounds(25034, 78, 120, index, prayerMenu);
		index++;
		setBounds(25035, 83, 124, index, prayerMenu);
		index++;
		setBounds(25036, 114, 120, index, prayerMenu);
		index++;
		setBounds(25037, 115, 121, index, prayerMenu);
		index++;
		setBounds(25038, 151, 120, index, prayerMenu);
		index++;
		setBounds(25039, 154, 124, index, prayerMenu);
		index++;
		setBounds(25040, 2, 158, index, prayerMenu);
		index++;
		setBounds(25041, 5, 160, index, prayerMenu);
		index++;
		setBounds(25042, 39, 158, index, prayerMenu);
		index++;
		setBounds(25043, 41, 158, index, prayerMenu);
		index++;
		setBounds(25044, 76, 158, index, prayerMenu);
		index++;
		setBounds(25045, 79, 163, index, prayerMenu);
		index++;
		setBounds(25046, 114, 158, index, prayerMenu);
		index++;
		setBounds(25047, 116, 158, index, prayerMenu);
		index++;
		setBounds(25048, 153, 158, index, prayerMenu);
		index++;
		setBounds(25049, 161, 160, index, prayerMenu);
		index++;
		setBounds(25050, 2, 196, index, prayerMenu);
		index++;
		setBounds(25051, 4, 207, index, prayerMenu);
		setBoundry(++index, 25052, firstRowXPos - 2, firstRowYPos, prayerMenu);
		setBoundry(++index, 25054, firstRowXPos - 5, firstRowYPos, prayerMenu);
		setBoundry(++index, 25056, firstRowXPos, firstRowYPos, prayerMenu);
		setBoundry(++index, 25058, firstRowXPos, firstRowYPos, prayerMenu);
		setBoundry(++index, 25060, firstRowXPos, firstRowYPos, prayerMenu);
		setBoundry(++index, 25062, secondRowXPos - 9, secondRowYPos, prayerMenu);
		setBoundry(++index, 25064, secondRowXPos - 11, secondRowYPos,
				prayerMenu);
		setBoundry(++index, 25066, secondRowXPos, secondRowYPos, prayerMenu);
		setBoundry(++index, 25068, secondRowXPos, secondRowYPos, prayerMenu);
		setBoundry(++index, 25070, secondRowXPos + 25, secondRowYPos,
				prayerMenu);
		setBoundry(++index, 25072, thirdRowXPos, thirdRowYPos, prayerMenu);
		setBoundry(++index, 25074, thirdRowXPos - 2, thirdRowYPos, prayerMenu);
		setBoundry(++index, 25076, thirdRowXPos, thirdRowYPos, prayerMenu);
		setBoundry(++index, 25078, thirdRowXPos - 7, thirdRowYPos, prayerMenu);
		setBoundry(++index, 25080, thirdRowXPos - 10, thirdRowYPos, prayerMenu);
		setBoundry(++index, 25082, fourthRowXPos, fourthRowYPos, prayerMenu);
		setBoundry(++index, 25084, fourthRowXPos - 8, fourthRowYPos, prayerMenu);
		setBoundry(++index, 25086, fourthRowXPos - 7, fourthRowYPos, prayerMenu);
		setBoundry(++index, 25088, fourthRowXPos - 2, fourthRowYPos, prayerMenu);
		setBoundry(++index, 25090, fourthRowXPos - 2, fourthRowYPos, prayerMenu);
		setBoundry(++index, 25092, fifthRowXPos, fifthRowYPos, prayerMenu);
		setBoundry(++index, 25094, fifthRowXPos, fifthRowYPos - 20, prayerMenu);
		setBoundry(++index, 25096, fifthRowXPos, fifthRowYPos - 25, prayerMenu);
		setBoundry(++index, 25098, fifthRowXPos + 15, fifthRowYPos - 25,
				prayerMenu);
		setBoundry(++index, 25100, fifthRowXPos - 12, fifthRowYPos - 20,
				prayerMenu);
		setBoundry(++index, 25102, sixthRowXPos - 2, sixthRowYPos, prayerMenu);
		index++;
	}

	@SuppressWarnings("unused")
	private static void printArray(int[] args) {
		for (int i = 0; i <= args.length - 1; i++) {
			System.out.println(args[i]);
		}
	}

	public static void printArray(String[] args) {
		for (int i = 0; i <= args.length - 1; i++) {
			System.out.println(args[i]);
		}
	}

	public static void questTab(TextDrawingArea[] TDA) {
		RSInterface localRSInterface = addInterface(639);
		setChildren(4, localRSInterface);
		addText(39155, "Quests", 16750623, false, true, 52, TDA, 2);
		addButton(39156, 1, "Interfaces/QuestTab/QUEST", 18, 18,
				"Swap to Information Tab", 1);
		addSprite(39157, 0, "Interfaces/QuestTab/QUEST");
		setBounds(39155, 10, 5, 0, localRSInterface);
		setBounds(39156, 165, 5, 1, localRSInterface);
		setBounds(39157, 3, 24, 2, localRSInterface);
		setBounds(39160, 5, 29, 3, localRSInterface);
		localRSInterface = addInterface(39160);
		localRSInterface.height = 214;
		localRSInterface.width = 165;
		localRSInterface.scrollMax = 1700;
		setChildren(105, localRSInterface);
		addText(39161, "", 16750623, false, true, 52, TDA, 2);
		addHoverText(39162, "", "", TDA, 0, 16711680, false, true, 150);
		addText(39163, "", 16750623, false, true, 52, TDA, 2);
		addHoverText(39164, "", "", TDA, 0, 16711680, false, true, 150);
		addText(39165, "", 16750623, false, true, 52, TDA, 2);
		addHoverText(39166, "", "", TDA, 0, 16711680, false, true, 150);
		setBounds(39161, 4, 4, 0, localRSInterface);
		setBounds(39162, 8, 22, 1, localRSInterface);
		setBounds(39163, 4, 35, 2, localRSInterface);
		setBounds(39164, 8, 53, 3, localRSInterface);
		setBounds(663, 4, 67, 4, localRSInterface);
		int i = 83;
		int j = 5;
		for (int k = 39165; k <= 39264; k++) {
			addHoverText(k, "", "View Quest", TDA, 0, 16711680, false, true,
					150);
			setBounds(k, 8, i, j, localRSInterface);
			j++;
			i += 15;
			i++;
		}
		localRSInterface = addInterface(39265);
		try {
			setChildren(4, localRSInterface);
			addText(39266, " ", 16750623, false, true, -1, TDA, 2);
			addButton(39267, 2, "Interfaces/QuestTab/QUEST", 18, 18,
					"Swap to Quest Diary", 1);
			addSprite(39269, 0, "Interfaces/QuestTab/QUEST");
			setBounds(39266, 10, 5, 0, localRSInterface);
			setBounds(39267, 165, 5, 1, localRSInterface);
			setBounds(39269, 3, 24, 2, localRSInterface);
			setBounds(39268, 5, 29, 3, localRSInterface);
			localRSInterface = addInterface(39268);
			localRSInterface.height = 214;
			localRSInterface.width = 165;
			localRSInterface.scrollMax = 1700;
			setChildren(20, localRSInterface);
			setBounds(39295, 8, 4, 0, localRSInterface);
			setBounds(39296, 8, 16, 1, localRSInterface);
			setBounds(39297, 8, 29, 2, localRSInterface);
			setBounds(39298, 8, 42, 3, localRSInterface);
			setBounds(39299, 8, 54, 4, localRSInterface);
			setBounds(39300, 8, 66, 5, localRSInterface);
			setBounds(39301, 8, 78, 6, localRSInterface);
			setBounds(39302, 8, 90, 7, localRSInterface);
			setBounds(39303, 8, 102, 8, localRSInterface);
			setBounds(39304, 8, 114, 9, localRSInterface);
			setBounds(39305, 8, 126, 10, localRSInterface);
			setBounds(39306, 8, 138, 11, localRSInterface);
			setBounds(39307, 8, 150, 12, localRSInterface);
			setBounds(39308, 8, 162, 13, localRSInterface);
			setBounds(39309, 8, 174, 14, localRSInterface);
			setBounds(39310, 8, 186, 15, localRSInterface);
			setBounds(39311, 8, 198, 16, localRSInterface);
			setBounds(39312, 8, 210, 17, localRSInterface);
			setBounds(39313, 8, 222, 18, localRSInterface);
			setBounds(39314, 8, 234, 19, localRSInterface);
			addHoverText(39295, "lol", "Do it?", TDA, 0, 16750623, false, true,
					150);
			addHoverText(39296, "2", "", TDA, 0, 16711680, false, true, 150);
			addHoverText(39297, "3", "", TDA, 0, 16711680, false, true, 150);
			addHoverText(39298, "4", "", TDA, 0, 16711680, false, true, 150);
			addHoverText(39299, "5", "", TDA, 0, 16711680, false, true, 150);
			addHoverText(39300, "6", "", TDA, 0, 16711680, false, true, 150);
			addHoverText(39301, "7", "", TDA, 0, 16750623, false, true, 150);
			addHoverText(39302, "8", "", TDA, 0, 16711680, false, true, 150);
			addHoverText(39303, "9", "", TDA, 0, 16711680, false, true, 150);
			addHoverText(39304, "10", "", TDA, 0, 16711680, false, true, 150);
			addHoverText(39305, "11", "", TDA, 0, 16711680, false, true, 150);
			addHoverText(39306, "12", "", TDA, 0, 16750623, false, true, 150);
			addHoverText(39307, "13", "", TDA, 0, 16711680, false, true, 150);
			addHoverText(39308, "14", "", TDA, 0, 16711680, false, true, 150);
			addHoverText(39309, "15", "", TDA, 0, 16711680, false, true, 150);
			addHoverText(39310, "16", "", TDA, 0, 16711680, false, true, 150);
			addHoverText(39311, "17", "", TDA, 0, 16711680, false, true, 150);
			addHoverText(39312, "18", "", TDA, 0, 16711680, false, true, 150);
			addHoverText(39313, "19", "", TDA, 0, 16711680, false, true, 150);
			addHoverText(39314, "20", "", TDA, 0, 16711680, false, true, 150);
		} catch (Exception localException) {
			localException.printStackTrace();
		}
	}

	public static void quickCurses(TextDrawingArea TDA[]) {
		int frame = 0;
		RSInterface tab = addTabInterface(17234);
		addText(17235, "Select your quick curses:", TDA, 0, 0xff981f, false,
				true);
		int i = 17202;
		for (int j = 630; i <= 17222 || j <= 656; j++) {
			addConfigButton(i, 17200, 2, 1, "/Interfaces/QuickPrayer/Sprite",
					14, 15, "Select", 0, 1, j);
			i++;
		}
		addHoverButton(17231, "/Interfaces/QuickPrayer/Sprite", 4, 190, 24,
				"Confirm Selection", -1, 17232, 1);
		addHoveredButton(17232, "/Interfaces/QuickPrayer/Sprite", 5, 190, 24,
				17233);
		setChildren(46, tab);
		setBounds(22504, 5, 28, frame++, tab);
		setBounds(22506, 44, 28, frame++, tab);
		setBounds(22508, 79, 31, frame++, tab);
		setBounds(22510, 116, 30, frame++, tab);
		setBounds(22512, 153, 29, frame++, tab);
		setBounds(22514, 5, 68, frame++, tab);
		setBounds(22516, 44, 67, frame++, tab);
		setBounds(22518, 79, 69, frame++, tab);
		setBounds(22520, 116, 70, frame++, tab);
		setBounds(22522, 154, 70, frame++, tab);
		setBounds(22524, 4, 104, frame++, tab);
		setBounds(22526, 44, 107, frame++, tab);
		setBounds(22528, 81, 105, frame++, tab);
		setBounds(22530, 117, 105, frame++, tab);
		setBounds(22532, 156, 107, frame++, tab);
		setBounds(22534, 5, 145, frame++, tab);
		setBounds(22536, 43, 144, frame++, tab);
		setBounds(22538, 83, 144, frame++, tab);
		setBounds(22540, 115, 141, frame++, tab);
		setBounds(22542, 154, 144, frame++, tab);
		setBounds(17229, 0, 25, frame++, tab);
		setBounds(17201, 0, 22, frame++, tab);
		setBounds(17201, 0, 237, frame++, tab);
		setBounds(17202, 2, 25, frame++, tab);
		setBounds(17203, 41, 25, frame++, tab);
		setBounds(17204, 76, 25, frame++, tab);
		setBounds(17205, 113, 25, frame++, tab);
		setBounds(17206, 150, 25, frame++, tab);
		setBounds(17207, 2, 65, frame++, tab);
		setBounds(17208, 41, 65, frame++, tab);
		setBounds(17209, 76, 65, frame++, tab);
		setBounds(17210, 113, 65, frame++, tab);
		setBounds(17211, 150, 65, frame++, tab);
		setBounds(17212, 2, 102, frame++, tab);
		setBounds(17213, 41, 102, frame++, tab);
		setBounds(17214, 76, 102, frame++, tab);
		setBounds(17215, 113, 102, frame++, tab);
		setBounds(17216, 150, 102, frame++, tab);
		setBounds(17217, 2, 141, frame++, tab);
		setBounds(17218, 41, 141, frame++, tab);
		setBounds(17219, 76, 141, frame++, tab);
		setBounds(17220, 113, 141, frame++, tab);
		setBounds(17221, 150, 141, frame++, tab);
		setBounds(17235, 5, 5, frame++, tab);
		setBounds(17231, 0, 237, frame++, tab);
		setBounds(17232, 0, 237, frame++, tab);
	}

	public static void quickPrayers(TextDrawingArea TDA[]) {
		int frame = 0;
		RSInterface tab = addTabInterface(17200);
		addSprite(17201, 3, "/Interfaces/QuickPrayer/Sprite");
		addText(17230, "Select your quick prayers:", TDA, 0, 0xff981f, false,
				true);
		addTransparentSprite(17229, 0, "/Interfaces/QuickPrayer/Sprite", 50);
		int i = 17202;
		for (int j = 630; i <= 17228 || j <= 656; j++) {
			addConfigButton(i, 17200, 2, 1, "/Interfaces/QuickPrayer/Sprite",
					14, 15, "Select", 0, 1, j);
			i++;
		}
		addHoverButton(17231, "/Interfaces/QuickPrayer/Sprite", 4, 190, 24,
				"Confirm Selection", -1, 17232, 1);
		addHoveredButton(17232, "/Interfaces/QuickPrayer/Sprite", 5, 190, 24,
				17233);
		setChildren(58, tab);
		setBounds(25001, 5, 28, frame++, tab);
		setBounds(25003, 44, 28, frame++, tab);
		setBounds(25005, 79, 31, frame++, tab);
		setBounds(25007, 116, 30, frame++, tab);
		setBounds(25009, 153, 29, frame++, tab);
		setBounds(25011, 5, 68, frame++, tab);
		setBounds(25013, 44, 67, frame++, tab);
		setBounds(25015, 79, 69, frame++, tab);
		setBounds(25017, 116, 70, frame++, tab);
		setBounds(25019, 154, 70, frame++, tab);
		setBounds(25021, 4, 104, frame++, tab);
		setBounds(25023, 44, 107, frame++, tab);
		setBounds(25025, 81, 105, frame++, tab);
		setBounds(25027, 117, 105, frame++, tab);
		setBounds(25029, 156, 107, frame++, tab);
		setBounds(25031, 5, 145, frame++, tab);
		setBounds(25033, 43, 144, frame++, tab);
		setBounds(25035, 83, 144, frame++, tab);
		setBounds(25037, 115, 141, frame++, tab);
		setBounds(25039, 154, 144, frame++, tab);
		setBounds(25041, 5, 180, frame++, tab);
		setBounds(25043, 41, 178, frame++, tab);
		setBounds(25045, 79, 183, frame++, tab);
		setBounds(25047, 116, 178, frame++, tab);
		setBounds(25049, 161, 180, frame++, tab);
		setBounds(25051, 4, 219, frame++, tab);
		setBounds(17229, 0, 25, frame++, tab);
		setBounds(17201, 0, 22, frame++, tab);
		setBounds(17201, 0, 237, frame++, tab);
		setBounds(17202, 2, 25, frame++, tab);
		setBounds(17203, 41, 25, frame++, tab);
		setBounds(17204, 76, 25, frame++, tab);
		setBounds(17205, 113, 25, frame++, tab);
		setBounds(17206, 150, 25, frame++, tab);
		setBounds(17207, 2, 65, frame++, tab);
		setBounds(17208, 41, 65, frame++, tab);
		setBounds(17209, 76, 65, frame++, tab);
		setBounds(17210, 113, 65, frame++, tab);
		setBounds(17211, 150, 65, frame++, tab);
		setBounds(17212, 2, 102, frame++, tab);
		setBounds(17213, 41, 102, frame++, tab);
		setBounds(17214, 76, 102, frame++, tab);
		setBounds(17215, 113, 102, frame++, tab);
		setBounds(17216, 150, 102, frame++, tab);
		setBounds(17217, 2, 141, frame++, tab);
		setBounds(17218, 41, 141, frame++, tab);
		setBounds(17219, 76, 141, frame++, tab);
		setBounds(17220, 113, 141, frame++, tab);
		setBounds(17221, 150, 141, frame++, tab);
		setBounds(17222, 2, 177, frame++, tab);
		setBounds(17223, 41, 177, frame++, tab);
		setBounds(17224, 76, 177, frame++, tab);
		setBounds(17225, 113, 177, frame++, tab);
		setBounds(17226, 150, 177, frame++, tab);
		setBounds(17227, 1, 211, frame++, tab);
		setBounds(17230, 5, 5, frame++, tab);
		setBounds(17231, 0, 237, frame++, tab);
		setBounds(17232, 0, 237, frame++, tab);
	}

	public static void removeSomething(int id) {
	}

	public static void robinChange(TextDrawingArea[] TDA) {
		RSInterface Interface = addTabInterface(39812);
		setChildren(28, Interface);
		addText(39829, "Robin Hood Hat Color Change", TDA, 2, 0xFF9900, false,
				true);
		addSprite(39813, 0, "Monsterray/MainSprites/Background");

		addHover(39814, 3, 0, 29815, 0, "Monsterray/MainSprites/CLOSE", 17, 16,
				"Exit");
		addHovered(39815, 1, "Monsterray/MainSprites/CLOSE", 17, 16, 39816);

		addHoverButton(39817, "Monsterray/robin/EXAMINE", 0, 72, 64,
				"Examine @or1@Robin Hood Hat", -1, 39818, 1);
		addHoveredButton(39818, "Monsterray/robin/EXAMINE", 0, 72, 64, 39819);

		addHoverButton(39820, "Monsterray/robin/EXAMINE", 1, 72, 64,
				"Examine @or1@Robin Hood Hat", -1, 39821, 1);
		addHoveredButton(39821, "Monsterray/robin/EXAMINE", 1, 72, 64, 39822);

		addHoverButton(39823, "Monsterray/robin/EXAMINE", 2, 72, 64,
				"Examine @or1@Robin Hood Hat", -1, 39824, 1);
		addHoveredButton(39824, "Monsterray/robin/EXAMINE", 2, 72, 64, 39825);

		addHoverButton(39826, "Monsterray/robin/EXAMINE", 3, 72, 64,
				"Examine @or1@Robin Hood Hat", -1, 39827, 1);
		addHoveredButton(39827, "Monsterray/robin/EXAMINE", 3, 72, 64, 29828);

		addText(39842, "Buy", TDA, 1, 0xFFFFFF, false, true);
		addHoverButton(39830, "Monsterray/MainSprites/BUTTON", 0, 75, 23,
				"Buy", -1, 39831, 1);
		addHoveredButton(39831, "Monsterray/MainSprites/BUTTON", 1, 75, 23,
				39832);

		addText(39843, "Buy", TDA, 1, 0xFFFFFF, false, true);
		addHoverButton(39833, "Monsterray/MainSprites/BUTTON", 0, 75, 23,
				"Buy", -1, 39834, 1);
		addHoveredButton(39834, "Monsterray/MainSprites/BUTTON", 1, 75, 23,
				39835);

		addText(39844, "Buy", TDA, 1, 0xFFFFFF, false, true);
		addHoverButton(39836, "Monsterray/MainSprites/BUTTON", 0, 75, 23,
				"Buy", -1, 39837, 1);
		addHoveredButton(39837, "Monsterray/MainSprites/BUTTON", 1, 75, 23,
				39838);

		addText(39845, "Buy", TDA, 1, 0xFFFFFF, false, true);
		addHoverButton(39839, "Monsterray/MainSprites/BUTTON", 0, 75, 23,
				"Buy", -1, 39840, 1);
		addHoveredButton(39840, "Monsterray/MainSprites/BUTTON", 1, 75, 23,
				39841);

		addText(39846, "Change The Colour Of You Hat for 150 Loyalty Points",
				TDA, 0, 0xFF9900, false, true);
		addText(39847, "@red@This is a non-refundable Purchase!", TDA, 0,
				0xFF9900, false, true);
		addText(39848, "@red@Also You Cant Trade The New One!", TDA, 0,
				0xFF9900, false, true);
		setBounds(39813, 60, 71, 0, Interface);
		setBounds(39814, 433, 80, 1, Interface);
		setBounds(39815, 433, 80, 2, Interface);
		setBounds(39817, 95, 111, 3, Interface);
		setBounds(39818, 95, 111, 4, Interface);
		setBounds(39820, 180, 111, 5, Interface);
		setBounds(39821, 180, 111, 6, Interface);
		setBounds(39823, 265, 111, 7, Interface);
		setBounds(39824, 265, 111, 8, Interface);
		setBounds(39826, 350, 111, 9, Interface);
		setBounds(39827, 350, 111, 10, Interface);
		setBounds(39829, 163, 78, 11, Interface);
		setBounds(39830, 92, 191, 12, Interface);
		setBounds(39831, 92, 191, 13, Interface);
		setBounds(39833, 178, 191, 14, Interface);
		setBounds(39834, 178, 191, 15, Interface);
		setBounds(39836, 264, 191, 16, Interface);
		setBounds(39837, 264, 191, 17, Interface);
		setBounds(39839, 350, 191, 18, Interface);
		setBounds(39840, 350, 191, 19, Interface);
		setBounds(39842, 118, 193, 20, Interface);
		setBounds(39843, 204, 193, 21, Interface);
		setBounds(39844, 290, 193, 22, Interface);
		setBounds(39845, 376, 193, 23, Interface);
		setBounds(39846, 80, 223, 24, Interface);
		setBounds(39847, 190, 239, 25, Interface);
		setBounds(39848, 190, 252, 26, Interface);
		setBounds(39816, 433, 80, 27, Interface);
	}

	public static void scrollCreation(TextDrawingArea TDA[]) {
		int totalScrolls = pouchItems.length;
		int xPadding = 53;
		int yPadding = 57;
		int xPos = 13;
		int yPos = 20;
		RSInterface rsinterface = addTabInterface(22760);
		setChildren(7, rsinterface);
		addSprite(22761, 0, "interfaces/summoning/creation/summoning");
		addButton(22762, 0, "interfaces/summoning/creation/tab",
				"Infuse Pouches");
		addSprite(22763, 0, "interfaces/summoning/creation/pouch");
		addSprite(22764, 1, "interfaces/summoning/creation/tab");
		addSprite(22765, 1, "interfaces/summoning/creation/scroll");
		addInAreaHover(22766, "interfaces/summoning/creation/close", 0, 1, 16,
				16, "Close", 250, 3);
		RSInterface scroll = addTabInterface(22767);
		setChildren(4 * totalScrolls, scroll);
		for (int i = 0; i < totalScrolls; i++) {
			addInAreaHover(22768 + i * 9, "interfaces/summoning/creation/box",
					0, 1, 48, 52, "nothing", -1, 0);
			addScroll(22769 + i * 9, pouchItems[i], 1, scrollItems[i],
					summoningLevelRequirements[i], scrollNames[i], TDA, i, 5);
			addSprite(22776 + i * 9, pouchItems[i], null, 50, 50);
			setBounds(22768 + i * 9, 36 + (i % 8) * xPadding, 0 + (i / 8)
					* yPadding, 0 + i * 3, scroll);
			setBounds(22769 + i * 9, 43 + (i % 8) * xPadding, 2 + (i / 8)
					* yPadding, 1 + i * 3, scroll);
			setBounds(22776 + i * 9, 28 + (i % 8) * xPadding, 28 + (i / 8)
					* yPadding, 2 + i * 3, scroll);
		}
		for (int i = 0; i < totalScrolls; i++) {
			int drawX = 5 + (i % 8) * xPadding;
			if (drawX > 292) {
				drawX -= 90;
			}
			int drawY = 55 + (i / 8) * yPadding;
			if (drawY > 160) {
				drawY -= 80;
			}
			setBounds(22770 + i * 9, drawX, drawY, 3 + (totalScrolls - 1) * 3
					+ i, scroll);
		}
		scroll.parentID = 22767;
		scroll.id = 22767;
		scroll.atActionType = 0;
		scroll.contentType = 0;
		scroll.width = 474;
		scroll.height = 257;
		scroll.scrollMax = 570;
		setBounds(22761, xPos, yPos, 0, rsinterface);
		setBounds(22762, xPos + 9, yPos + 9, 1, rsinterface);
		setBounds(22763, xPos + 29, yPos + 10, 2, rsinterface);
		setBounds(22764, xPos + 79, yPos + 9, 3, rsinterface);
		setBounds(22765, xPos + 106, yPos + 10, 4, rsinterface);
		setBounds(22766, xPos + 461, yPos + 10, 5, rsinterface);
		setBounds(22767, 0, yPos + 39, 6, rsinterface);
	}

	public static void setBounds(int ID, int X, int Y, int frame,
			RSInterface RSi) {
		RSi.children[frame] = ID;
		RSi.childX[frame] = X;
		RSi.childY[frame] = Y;
	}

	public static void setCardBounds(int startID, int endID, int X, int Y,
			int frame, RSInterface RSi) {
		int k = frame;
		for (int i = startID; i <= endID; i++) {
			RSi.children[k] = i;
			RSi.childX[k] = X;
			RSi.childY[k] = Y;
			k++;
		}
	}

	public static void settingsInterface(TextDrawingArea TDA[]) {
		RSInterface rsinterface = addTabInterface(26000);
		int x = 168;
		int y = 49;
		addSprite(26001, 0, "interfaces/settings/base");
		addText(26002, "More Options", 0xe4a146, true, true, 52, 2);
		addInAreaHover(26003, "interfaces/summoning/creation/close", 0, 1, 16,
				16, "Close", 250, 3);
		addText(26004, "Use the new function keys,\\nuntick to use old.",
				0xe4a146, false, true, 52, 0);
		addSprite(26005, 0, "interfaces/settings/split");
		addSprite(26011, 1, "interfaces/settings/split");
		addText(26006, "Use the new style health\\nbars, untick to use old.",
				0xe4a146, false, true, 52, 0);
		addText(26009,
				"Display the new x10 style\\ndamage, untick to use old.",
				0xe4a146, false, true, 52, 0);
		addButton(26007, 4, -1, 2, 3, "interfaces/settings/click", 15, 15,
				"Toggle function keys", 650, 1);
		addButton(26008, 4, -1, 2, 3, "interfaces/settings/click", 15, 15,
				"Toggle halth bars", 651, 1);
		addButton(26010, 4, -1, 2, 3, "interfaces/settings/click", 15, 15,
				"Toggle x10 damage", 652, 1);
		addButton(26012, 4, 26013, 9, 10, "/OptionTab/OPTION", 40, 40,
				"Toggle Full-Screen", 653, 1);
		addSprite(26013, 17, "/OptionTab/OPTION");
		setChildren(17, rsinterface);
		int i = 0;
		setBounds(26001, x + 0, y + 0, i, rsinterface);
		i++;
		setBounds(26002, x + 89, y + 3, i, rsinterface);
		i++;
		setBounds(26003, x + 151, y + 3, i, rsinterface);
		i++;
		setBounds(26004, x + 9, y + 25, i, rsinterface);
		i++;
		setBounds(26006, x + 9, y + 57, i, rsinterface);
		i++;
		setBounds(26007, x + 154, y + 29, i, rsinterface);
		i++;
		setBounds(26008, x + 154, y + 61, i, rsinterface);
		i++;
		setBounds(26009, x + 9, y + 89, i, rsinterface);
		i++;
		setBounds(26005, x + 7, y + 115, i, rsinterface);
		i++;
		setBounds(26010, x + 154, y + 93, i, rsinterface);
		i++;
		setBounds(26005, x + 7, y + 51, i, rsinterface);
		i++;
		setBounds(26005, x + 7, y + 83, i, rsinterface);
		i++;
		setBounds(26011, x + 151, y + 22, i, rsinterface);
		i++;
		setBounds(26011, x + 151, y + 53, i, rsinterface);
		i++;
		setBounds(26011, x + 151, y + 85, i, rsinterface);
		i++;
		setBounds(26012, (x + 7 + 81) - 20, (y + 86 + 77) - 20, i, rsinterface);
		i++;
		setBounds(26013, ((x + 7 + 81) - 20) + 4, ((y + 86 + 77) - 20) + 6, i,
				rsinterface);
		i++;
	}

	public static void Shop(TextDrawingArea[] TDA) {
		RSInterface rsinterface = addTabInterface(3824);
		setChildren(8, rsinterface);
		addSprite(3825, 0, "Shop/SHOP");
		addHover(3902, 3, 0, 3826, 1, "Shop/CLOSE", 17, 17, "Close Window");
		addHovered(3826, 2, "Shop/CLOSE", 17, 17, 3827);
		addText(19679, "", 0xff981f, false, true, 52, TDA, 1);
		addText(19680, "", 0xbf751d, false, true, 52, TDA, 1);
		addButton(19681, 2, "Shop/SHOP", 0, 0, "", 1);
		addSprite(19687, 1, "Shop/ITEMBG");
		setBounds(3825, 6, 8, 0, rsinterface);
		setBounds(3902, 478, 10, 1, rsinterface);
		setBounds(3826, 478, 10, 2, rsinterface);
		setBounds(3900, 26, 44, 3, rsinterface);
		setBounds(3901, 240, 11, 4, rsinterface);
		setBounds(19679, 42, 54, 5, rsinterface);
		setBounds(19680, 150, 54, 6, rsinterface);
		setBounds(19681, 129, 50, 7, rsinterface);
		rsinterface = interfaceCache[3900];
		setChildren(1, rsinterface);
		setBounds(19687, 6, 15, 0, rsinterface);
		rsinterface.invSpritePadX = 15;
		rsinterface.width = 10;
		rsinterface.height = 4;
		rsinterface.invSpritePadY = 25;
		rsinterface = addTabInterface(19682);
		addSprite(19683, 1, "Shop/SHOP");
		addText(19684, "Main Stock", 0xbf751d, false, true, 52, TDA, 1);
		addText(19685, "Store Info", 0xff981f, false, true, 52, TDA, 1);
		addButton(19686, 2, "Shop/SHOP", 95, 19, "Main Stock", 1);
		setChildren(7, rsinterface);
		setBounds(19683, 12, 12, 0, rsinterface);
		setBounds(3901, 240, 21, 1, rsinterface);
		setBounds(19684, 42, 54, 2, rsinterface);
		setBounds(19685, 150, 54, 3, rsinterface);
		setBounds(19686, 23, 50, 4, rsinterface);
		setBounds(3902, 471, 22, 5, rsinterface);
		setBounds(3826, 60, 85, 6, rsinterface);
	}

	public static void Sidebar0(TextDrawingArea tda[]) {
		Sidebar0a(1698, 1701, 7499, "Chop", "Hack", "Smash", "Block", 42, 75,
				127, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103,
				tda);
		Sidebar0a(2276, 2279, 7574, "Stab", "Lunge", "Slash", "Block", 43, 75,
				124, 75, 41, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103,
				tda);
		Sidebar0a(2423, 2426, 7599, "Chop", "Slash", "Lunge", "Block", 42, 75,
				125, 75, 40, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103,
				tda);
		Sidebar0a(3796, 3799, 7624, "Pound", "Pummel", "Spike", "Block", 39,
				75, 121, 75, 41, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40,
				103, tda);
		Sidebar0a(4679, 4682, 7674, "Lunge", "Swipe", "Pound", "Block", 40, 75,
				124, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103,
				tda);
		Sidebar0a(4705, 4708, 7699, "Chop", "Slash", "Smash", "Block", 42, 75,
				125, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103,
				tda);
		Sidebar0a(5570, 5573, 7724, "Spike", "Impale", "Smash", "Block", 41,
				75, 123, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40,
				103, tda);
		Sidebar0a(7762, 7765, 7800, "Chop", "Slash", "Lunge", "Block", 42, 75,
				125, 75, 40, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103,
				tda);
		Sidebar0b(776, 779, "Reap", "Chop", "Jab", "Block", 42, 75, 126, 75,
				46, 128, 125, 128, 122, 103, 122, 50, 40, 103, 40, 50, tda);
		Sidebar0c(425, 428, 7474, "Pound", "Pummel", "Block", 39, 75, 121, 75,
				42, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(1749, 1752, 7524, "Accurate", "Rapid", "Longrange", 33, 75,
				125, 75, 29, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(1764, 1767, 7549, "Accurate", "Rapid", "Longrange", 33, 75,
				125, 75, 29, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(4446, 4449, 7649, "Accurate", "Rapid", "Longrange", 33, 75,
				125, 75, 29, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(5855, 5857, 7749, "Punch", "Kick", "Block", 40, 75, 129, 75,
				42, 128, 40, 50, 122, 50, 40, 103, tda);
		Sidebar0c(6103, 6132, 6117, "Bash", "Pound", "Block", 43, 75, 124, 75,
				42, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(8460, 8463, 8493, "Jab", "Swipe", "Fend", 46, 75, 124, 75,
				43, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(12290, 12293, 12323, "Flick", "Lash", "Deflect", 44, 75, 127,
				75, 36, 128, 40, 50, 40, 103, 122, 50, tda);
		Sidebar0d(328, 331, "Bash", "Pound", "Focus", 42, 66, 39, 101, 41, 136,
				40, 120, 40, 50, 40, 85, tda);
		RSInterface rsi = addInterface(19300);
		textSize(3983, tda, 0);
		addToggleButton(150, 150, 172, 150, 44, "Auto Retaliate");
		rsi.totalChildren(2, 2, 2);
		rsi.child(0, 3983, 52, 25);
		rsi.child(1, 150, 21, 153);
		rsi = interfaceCache[3983];
		rsi.centerText = true;
		rsi.textColor = 0xff981f;
	}

	public static void Sidebar0a(int id, int id2, int id3, String text1,
			String text2, String text3, String text4, int str1x, int str1y,
			int str2x, int str2y, int str3x, int str3y, int str4x, int str4y,
			int img1x, int img1y, int img2x, int img2y, int img3x, int img3y,
			int img4x, int img4y, TextDrawingArea tda[]) {
		RSInterface rsi = addInterface(id);
		addText(id2, "-2", tda, 3, 0xff981f, true);
		addText(id2 + 11, text1, tda, 0, 0xff981f, false);
		addText(id2 + 12, text2, tda, 0, 0xff981f, false);
		addText(id2 + 13, text3, tda, 0, 0xff981f, false);
		addText(id2 + 14, text4, tda, 0, 0xff981f, false);
		rsi.specialBar(id3);
		rsi.width = 190;
		rsi.height = 261;
		int last = 15;
		int frame = 0;
		rsi.totalChildren(last, last, last);
		rsi.child(frame, id2 + 3, 21, 46);
		frame++;
		rsi.child(frame, id2 + 4, 104, 99);
		frame++;
		rsi.child(frame, id2 + 5, 21, 99);
		frame++;
		rsi.child(frame, id2 + 6, 105, 46);
		frame++;
		rsi.child(frame, id2 + 7, img1x, img1y);
		frame++;
		rsi.child(frame, id2 + 8, img2x, img2y);
		frame++;
		rsi.child(frame, id2 + 9, img3x, img3y);
		frame++;
		rsi.child(frame, id2 + 10, img4x, img4y);
		frame++;
		rsi.child(frame, id2 + 11, str1x, str1y);
		frame++;
		rsi.child(frame, id2 + 12, str2x, str2y);
		frame++;
		rsi.child(frame, id2 + 13, str3x, str3y);
		frame++;
		rsi.child(frame, id2 + 14, str4x, str4y);
		frame++;
		rsi.child(frame, 19300, 0, 0);
		frame++;
		rsi.child(frame, id2, 94, 4);
		frame++;
		rsi.child(frame, id3, 21, 205);
		frame++;
		for (int i = id2 + 3; i < id2 + 7; i++) {
			rsi = interfaceCache[i];
			rsi.sprite1 = CustomSpriteLoader(19301, "");
			rsi.sprite2 = CustomSpriteLoader(19301, "a");
			rsi.width = 68;
			rsi.height = 44;
		}
	}

	public static void Sidebar0b(int id, int id2, String text1, String text2,
			String text3, String text4, int str1x, int str1y, int str2x,
			int str2y, int str3x, int str3y, int str4x, int str4y, int img1x,
			int img1y, int img2x, int img2y, int img3x, int img3y, int img4x,
			int img4y, TextDrawingArea tda[]) {
		RSInterface rsi = addInterface(id);
		addText(id2, "-2", tda, 3, 0xff981f, true);
		addText(id2 + 11, text1, tda, 0, 0xff981f, false);
		addText(id2 + 12, text2, tda, 0, 0xff981f, false);
		addText(id2 + 13, text3, tda, 0, 0xff981f, false);
		addText(id2 + 14, text4, tda, 0, 0xff981f, false);
		rsi.width = 190;
		rsi.height = 261;
		int last = 14;
		int frame = 0;
		rsi.totalChildren(last, last, last);
		rsi.child(frame, id2 + 3, 21, 46);
		frame++;
		rsi.child(frame, id2 + 4, 104, 99);
		frame++;
		rsi.child(frame, id2 + 5, 21, 99);
		frame++;
		rsi.child(frame, id2 + 6, 105, 46);
		frame++;
		rsi.child(frame, id2 + 7, img1x, img1y);
		frame++;
		rsi.child(frame, id2 + 8, img2x, img2y);
		frame++;
		rsi.child(frame, id2 + 9, img3x, img3y);
		frame++;
		rsi.child(frame, id2 + 10, img4x, img4y);
		frame++;
		rsi.child(frame, id2 + 11, str1x, str1y);
		frame++;
		rsi.child(frame, id2 + 12, str2x, str2y);
		frame++;
		rsi.child(frame, id2 + 13, str3x, str3y);
		frame++;
		rsi.child(frame, id2 + 14, str4x, str4y);
		frame++;
		rsi.child(frame, 19300, 0, 0);
		frame++;
		rsi.child(frame, id2, 94, 4);
		frame++;
		for (int i = id2 + 3; i < id2 + 7; i++) {
			rsi = interfaceCache[i];
			rsi.sprite1 = CustomSpriteLoader(19301, "");
			rsi.sprite2 = CustomSpriteLoader(19301, "a");
			rsi.width = 68;
			rsi.height = 44;
		}
	}

	public static void Sidebar0c(int id, int id2, int id3, String text1,
			String text2, String text3, int str1x, int str1y, int str2x,
			int str2y, int str3x, int str3y, int img1x, int img1y, int img2x,
			int img2y, int img3x, int img3y, TextDrawingArea tda[]) {
		RSInterface rsi = addInterface(id);
		addText(id2, "-2", tda, 3, 0xff981f, true);
		addText(id2 + 9, text1, tda, 0, 0xff981f, false);
		addText(id2 + 10, text2, tda, 0, 0xff981f, false);
		addText(id2 + 11, text3, tda, 0, 0xff981f, false);
		rsi.specialBar(id3);
		rsi.width = 190;
		rsi.height = 261;
		int last = 12;
		int frame = 0;
		rsi.totalChildren(last, last, last);
		rsi.child(frame, id2 + 3, 21, 99);
		frame++;
		rsi.child(frame, id2 + 4, 105, 46);
		frame++;
		rsi.child(frame, id2 + 5, 21, 46);
		frame++;
		rsi.child(frame, id2 + 6, img1x, img1y);
		frame++;
		rsi.child(frame, id2 + 7, img2x, img2y);
		frame++;
		rsi.child(frame, id2 + 8, img3x, img3y);
		frame++;
		rsi.child(frame, id2 + 9, str1x, str1y);
		frame++;
		rsi.child(frame, id2 + 10, str2x, str2y);
		frame++;
		rsi.child(frame, id2 + 11, str3x, str3y);
		frame++;
		rsi.child(frame, 19300, 0, 0);
		frame++;
		rsi.child(frame, id2, 94, 4);
		frame++;
		rsi.child(frame, id3, 21, 205);
		frame++;
		for (int i = id2 + 3; i < id2 + 6; i++) {
			rsi = interfaceCache[i];
			rsi.sprite1 = CustomSpriteLoader(19301, "");
			rsi.sprite2 = CustomSpriteLoader(19301, "a");
			rsi.width = 68;
			rsi.height = 44;
		}
	}

	public static void Sidebar0d(int id, int id2, String text1, String text2,
			String text3, int str1x, int str1y, int str2x, int str2y,
			int str3x, int str3y, int img1x, int img1y, int img2x, int img2y,
			int img3x, int img3y, TextDrawingArea tda[]) {
		RSInterface rsi = addInterface(id);
		addText(id2, "-2", tda, 3, 0xff981f, true);
		addText(id2 + 9, text1, tda, 0, 0xff981f, false);
		addText(id2 + 10, text2, tda, 0, 0xff981f, false);
		addText(id2 + 11, text3, tda, 0, 0xff981f, false);
		removeSomething(353);
		addText(354, "Spell", tda, 0, 0xff981f, false);
		addCacheSprite(337, 19, 0, "combaticons");
		addCacheSprite(338, 13, 0, "combaticons2");
		addCacheSprite(339, 14, 0, "combaticons2");
		removeSomething(349);
		addToggleButton(350, 350, 108, 68, 44, "Select");
		rsi.width = 190;
		rsi.height = 261;
		int last = 15;
		int frame = 0;
		rsi.totalChildren(last, last, last);
		rsi.child(frame, id2 + 3, 20, 115);
		frame++;
		rsi.child(frame, id2 + 4, 20, 80);
		frame++;
		rsi.child(frame, id2 + 5, 20, 45);
		frame++;
		rsi.child(frame, id2 + 6, img1x, img1y);
		frame++;
		rsi.child(frame, id2 + 7, img2x, img2y);
		frame++;
		rsi.child(frame, id2 + 8, img3x, img3y);
		frame++;
		rsi.child(frame, id2 + 9, str1x, str1y);
		frame++;
		rsi.child(frame, id2 + 10, str2x, str2y);
		frame++;
		rsi.child(frame, id2 + 11, str3x, str3y);
		frame++;
		rsi.child(frame, 349, 105, 46);
		frame++;
		rsi.child(frame, 350, 104, 106);
		frame++;
		rsi.child(frame, 353, 125, 74);
		frame++;
		rsi.child(frame, 354, 125, 134);
		frame++;
		rsi.child(frame, 19300, 0, 0);
		frame++;
		rsi.child(frame, id2, 94, 4);
		frame++;
	}

	public static void skillInterface(int i, int j) {
		RSInterface rsinterface = interfaceCache[i] = new RSInterface();
		rsinterface.id = i;
		rsinterface.parentID = i;
		rsinterface.type = 5;
		rsinterface.atActionType = 0;
		rsinterface.contentType = 0;
		rsinterface.width = 26;
		rsinterface.height = 34;
		rsinterface.opacity = 0;
		rsinterface.mOverInterToTrigger = 0;
		rsinterface.sprite1 = imageLoader(j, "Skill/Skill");
		rsinterface.sprite2 = imageLoader(j, "Skill/Skill");
	}

	public static void skillInterface(TextDrawingArea[] wid) {
		RSInterface rsinterface = addTabInterface(3917);
		skillInterface(19746, 255);
		skillInterface(19749, 52);
		addText(29801, "", wid, 0, 0xFFEE33); // Summoning
		addText(29800, "", wid, 0, 0xFFEE33); // Hunter
		addButton(19747, 51, 27700, "Skill/Skill", 62, 32,
				"View @lre@Hunter @whi@Guide", 1);
		addButton(19748, 50, 27701, "Skill/Skill", 62, 32,
				"@lre@Dismiss Summoning Familiar@whi@", 1);
		addText(13984, "Total", wid, 0, 0xFFEE33);
		addText(3985, "", wid, 0, 0xFFEE33);
		addText(13983, "", wid, 0, 0xFFEE33, true, true);
		for (int k = 0; k < boxIds.length; k++) {
			skillInterface(boxIds[k], 256);
		}
		// RSInterface rsinterface = addTabInterface(3917);
		rsinterface.children = new int[63];
		rsinterface.childX = new int[63];
		rsinterface.childY = new int[63];
		rsinterface.children[0] = 3918;
		rsinterface.childX[0] = 0;
		rsinterface.childY[0] = 0;
		rsinterface.children[1] = 3925;
		rsinterface.childX[1] = 0;
		rsinterface.childY[1] = 31;
		rsinterface.children[2] = 3932;
		rsinterface.childX[2] = 0;
		rsinterface.childY[2] = 62;
		rsinterface.children[3] = 3939;
		rsinterface.childX[3] = 0;
		rsinterface.childY[3] = 93;
		rsinterface.children[4] = 3946;
		rsinterface.childX[4] = 0;
		rsinterface.childY[4] = 124;
		rsinterface.children[5] = 3953;
		rsinterface.childX[5] = 0;
		rsinterface.childY[5] = 155;
		rsinterface.children[6] = 4148;
		rsinterface.childX[6] = 0;
		rsinterface.childY[6] = 186;
		rsinterface.children[7] = 19746;
		rsinterface.childX[7] = 70;
		rsinterface.childY[7] = 69;
		rsinterface.children[8] = 19748;
		rsinterface.childX[8] = 1;
		rsinterface.childY[8] = 219;
		rsinterface.children[9] = 19747;
		rsinterface.childX[9] = 64;
		rsinterface.childY[9] = 219;
		rsinterface.children[10] = 14000;
		rsinterface.childX[10] = 10;
		rsinterface.childY[10] = 219;
		rsinterface.children[11] = 19749;
		rsinterface.childX[11] = 128;
		rsinterface.childY[11] = 220;
		rsinterface.children[12] = 13983;
		rsinterface.childX[12] = 158;
		rsinterface.childY[12] = 238;
		rsinterface.children[13] = 3984;
		rsinterface.childX[13] = 300;
		rsinterface.childY[13] = 225;
		rsinterface.children[14] = 3985;
		rsinterface.childX[14] = 130;
		rsinterface.childY[14] = 238;
		rsinterface.children[15] = 29800;
		rsinterface.childX[15] = 98;
		rsinterface.childY[15] = 220;
		rsinterface.children[16] = 29800;
		rsinterface.childX[16] = 107;
		rsinterface.childY[16] = 235;
		rsinterface.children[17] = 29801;
		rsinterface.childX[17] = 36;
		rsinterface.childY[17] = 220;
		rsinterface.children[18] = 29801;
		rsinterface.childX[18] = 45;
		rsinterface.childY[18] = 235;
		rsinterface.children[19] = 4040;
		rsinterface.childX[19] = 5;
		rsinterface.childY[19] = 20;
		rsinterface.children[20] = 8654;
		rsinterface.childX[20] = 0;
		rsinterface.childY[20] = 2;
		rsinterface.children[21] = 8655;
		rsinterface.childX[21] = 64;
		rsinterface.childY[21] = 2;
		rsinterface.children[22] = 4076;
		rsinterface.childX[22] = 20;
		rsinterface.childY[22] = 20;
		rsinterface.children[23] = 8656;
		rsinterface.childX[23] = 128;
		rsinterface.childY[23] = 2;
		rsinterface.children[24] = 4112;
		rsinterface.childX[24] = 20;
		rsinterface.childY[24] = 20;
		rsinterface.children[25] = 8657;
		rsinterface.childX[25] = 0;
		rsinterface.childY[25] = 33;
		rsinterface.children[26] = 4046;
		rsinterface.childX[26] = 20;
		rsinterface.childY[26] = 50;
		rsinterface.children[27] = 8658;
		rsinterface.childX[27] = 64;
		rsinterface.childY[27] = 33;
		rsinterface.children[28] = 4082;
		rsinterface.childX[28] = 20;
		rsinterface.childY[28] = 50;
		rsinterface.children[29] = 8659;
		rsinterface.childX[29] = 128;
		rsinterface.childY[29] = 33;
		rsinterface.children[30] = 4118;
		rsinterface.childX[30] = 20;
		rsinterface.childY[30] = 50;
		rsinterface.children[31] = 8660;
		rsinterface.childX[31] = 0;
		rsinterface.childY[31] = 60 + 10;
		rsinterface.children[32] = 4052;
		rsinterface.childX[32] = 20;
		rsinterface.childY[32] = 83;
		rsinterface.children[33] = 8661;
		rsinterface.childX[33] = 65;
		rsinterface.childY[33] = 60 + 10;
		rsinterface.children[34] = 4088;
		rsinterface.childX[34] = 20;
		rsinterface.childY[34] = 83;
		rsinterface.children[35] = 8662;
		rsinterface.childX[35] = 130;
		rsinterface.childY[35] = 60 + 10;
		rsinterface.children[36] = 4124;
		rsinterface.childX[36] = 20;
		rsinterface.childY[36] = 83;
		rsinterface.children[37] = 8663;
		rsinterface.childX[37] = 0;
		rsinterface.childY[37] = 90 + 10;
		rsinterface.children[38] = 4058;
		rsinterface.childX[38] = 20;
		rsinterface.childY[38] = 120;
		rsinterface.children[39] = 8664;
		rsinterface.childX[39] = 65;
		rsinterface.childY[39] = 90 + 10;
		rsinterface.children[40] = 4094;
		rsinterface.childX[40] = 20;
		rsinterface.childY[40] = 120;
		rsinterface.children[41] = 8665;
		rsinterface.childX[41] = 130;
		rsinterface.childY[41] = 90 + 10;
		rsinterface.children[42] = 4130;
		rsinterface.childX[42] = 20;
		rsinterface.childY[42] = 120;
		rsinterface.children[43] = 8666;
		rsinterface.childX[43] = 0;
		rsinterface.childY[43] = 130;
		rsinterface.children[44] = 4064;
		rsinterface.childX[44] = 20;
		rsinterface.childY[44] = 150;
		rsinterface.children[45] = 8667;
		rsinterface.childX[45] = 65;
		rsinterface.childY[45] = 130;
		rsinterface.children[46] = 4100;
		rsinterface.childX[46] = 20;
		rsinterface.childY[46] = 150;
		rsinterface.children[47] = 8668;
		rsinterface.childX[47] = 130;
		rsinterface.childY[47] = 130;
		rsinterface.children[48] = 4136;
		rsinterface.childX[48] = 20;
		rsinterface.childY[48] = 150;
		rsinterface.children[49] = 8669;
		rsinterface.childX[49] = 0;
		rsinterface.childY[49] = 160;
		rsinterface.children[50] = 4070;
		rsinterface.childX[50] = 20;
		rsinterface.childY[50] = 180;
		rsinterface.children[51] = 8670;
		rsinterface.childX[51] = 65;
		rsinterface.childY[51] = 160;
		rsinterface.children[52] = 4106;
		rsinterface.childX[52] = 20;
		rsinterface.childY[52] = 180;
		rsinterface.children[53] = 8671;
		rsinterface.childX[53] = 130;
		rsinterface.childY[53] = 160;
		rsinterface.children[54] = 4142;
		rsinterface.childX[54] = 20;
		rsinterface.childY[54] = 180;
		rsinterface.children[55] = 8672;
		rsinterface.childX[55] = 0;
		rsinterface.childY[55] = 190;
		rsinterface.children[56] = 4160;
		rsinterface.childX[56] = 20;
		rsinterface.childY[56] = 150;
		rsinterface.children[57] = 4160;
		rsinterface.childX[57] = 20;
		rsinterface.childY[57] = 150;
		rsinterface.children[58] = 12162;
		rsinterface.childX[58] = 65;
		rsinterface.childY[58] = 190;
		rsinterface.children[59] = 2832;
		rsinterface.childX[59] = 20;
		rsinterface.childY[59] = 150;
		rsinterface.children[60] = 13928;
		rsinterface.childX[60] = 130;
		rsinterface.childY[60] = 190;
		rsinterface.children[61] = 13917;
		rsinterface.childX[61] = 20;
		rsinterface.childY[61] = 150;
		rsinterface.children[62] = 13984;
		rsinterface.childX[62] = 145;
		rsinterface.childY[62] = 225;
	}

	public static void SolChange(TextDrawingArea[] TDA) {
		RSInterface Interface = addTabInterface(29812);
		setChildren(27, Interface);

		addText(29829, "Staff Of Light Color Change", TDA, 2, 0xFF9900, false,
				true);
		addSprite(29813, 0, "Monsterray/MainSprites/BACKGROUND");

		addHover(29814, 3, 0, 29815, 0, "Monsterray/MainSprites/CLOSE", 17, 16,
				"Exit");
		addHovered(29815, 1, "Monsterray/MainSprites/CLOSE", 17, 16, 29816);

		addHoverButton(29817, "Monsterray/sol/EXAMINE", 0, 72, 64,
				"Examine @yel@Staff Of Light", -1, 29818, 1);
		addHoveredButton(29818, "Monsterray/sol/EXAMINE", 0, 72, 64, 29819);

		addHoverButton(29820, "Monsterray/sol/EXAMINE", 1, 72, 64,
				"Examine @red@Staff Of Light", -1, 29821, 1);
		addHoveredButton(29821, "Monsterray/sol/EXAMINE", 1, 72, 64, 29822);

		addHoverButton(29823, "Monsterray/sol/EXAMINE", 2, 72, 64,
				"Examine @gre@Staff Of Light", -1, 29824, 1);
		addHoveredButton(29824, "Monsterray/sol/EXAMINE", 2, 72, 64, 29825);

		addHoverButton(29826, "Monsterray/sol/EXAMINE", 3, 72, 64,
				"Examine @cya@Staff Of Light", -1, 29827, 1);
		addHoveredButton(29827, "Monsterray/sol/EXAMINE", 3, 72, 64, 29828);

		addText(29842, "@yel@Buy", TDA, 1, 0xFFFFFF, false, true);
		addHoverButton(29830, "Monsterray/MainSprites/BUTTON", 0, 75, 23,
				"@yel@Buy Yellow Dye", -1, 29831, 1);
		addHoveredButton(29831, "Monsterray/MainSprites/BUTTON", 1, 75, 23,
				29832);

		addText(29843, "@red@Buy", TDA, 1, 0xFFFFFF, false, true);
		addHoverButton(29833, "Monsterray/MainSprites/BUTTON", 0, 75, 23,
				"@red@Buy Red Dye", -1, 29834, 1);
		addHoveredButton(29834, "Monsterray/MainSprites/BUTTON", 1, 75, 23,
				29835);

		addText(29844, "@gre@Buy", TDA, 1, 0xFFFFFF, false, true);
		addHoverButton(29836, "Monsterray/MainSprites/BUTTON", 0, 75, 23,
				"@gre@Buy Green Dye", -1, 29837, 1);
		addHoveredButton(29837, "Monsterray/MainSprites/BUTTON", 1, 75, 23,
				29838);

		addText(29845, "@cya@Buy", TDA, 1, 0xFFFFFF, false, true);
		addHoverButton(29839, "Monsterray/MainSprites/BUTTON", 0, 75, 23,
				"@cya@Buy Cyan Dye", -1, 29840, 1);
		addHoveredButton(29840, "Monsterray/MainSprites/BUTTON", 1, 75, 23,
				29841);

		addText(29846,
				"Change The Colour Of You Staff of Light for 150 Loyalty Points",
				TDA, 0, 0xFF9900, false, true);
		addText(29847, "@red@This Is A Non-Refundable Purchase!", TDA, 0,
				0xFF9900, false, true);
		addText(29848, "@red@Also They Can't Be Traded!", TDA, 0, 0xFF9900,
				false, true);

		setBounds(29813, 60, 71, 0, Interface);
		setBounds(29814, 433, 80, 1, Interface);
		setBounds(29815, 433, 80, 2, Interface);
		setBounds(29817, 95, 111, 3, Interface);
		setBounds(29818, 95, 111, 4, Interface);
		setBounds(29820, 180, 111, 5, Interface);
		setBounds(29821, 180, 111, 6, Interface);
		setBounds(29823, 265, 111, 7, Interface);
		setBounds(29824, 265, 111, 8, Interface);
		setBounds(29826, 350, 111, 9, Interface);
		setBounds(29827, 350, 111, 10, Interface);
		setBounds(29829, 163, 78, 11, Interface);
		setBounds(29830, 92, 191, 12, Interface);
		setBounds(29831, 92, 191, 13, Interface);
		setBounds(29833, 178, 191, 14, Interface);
		setBounds(29834, 178, 191, 15, Interface);
		setBounds(29836, 264, 191, 16, Interface);
		setBounds(29837, 264, 191, 17, Interface);
		setBounds(29839, 350, 191, 18, Interface);
		setBounds(29840, 350, 191, 19, Interface);
		setBounds(29842, 118, 193, 20, Interface);
		setBounds(29843, 204, 193, 21, Interface);
		setBounds(29844, 290, 193, 22, Interface);
		setBounds(29845, 376, 193, 23, Interface);
		setBounds(29846, 80, 223, 24, Interface);
		setBounds(29847, 190, 239, 25, Interface);
		setBounds(29848, 190, 252, 26, Interface);
	}

	public static void sprite1(int id, int sprite) {
		RSInterface class9 = interfaceCache[id];
		class9.sprite1 = CustomSpriteLoader(sprite, "");
	}

	public static void SquealOfFortune(TextDrawingArea atextdrawingarea[]) { // this
																				// is
																				// the
																				// tab
																				// interface
		RSInterface rsinterface = addTabInterface(48500);
		addSprite(48501, 0, "SquealOfFortune/BG");
		addHoverButton(48502, "SquealOfFortune/SPRITE", 0, 156, 62,
				"Open Squeal of Fortune", -1, 48503, 1);
		addHoveredButton(48503, "SquealOfFortune/SPRITE", 1, 156, 62, 48504);
		addHoverButton(48505, "SquealOfFortune/SPRITE", 0, 156, 62,
				"Buy Spins", -1, 48506, 1);
		addHoveredButton(48506, "SquealOfFortune/SPRITE", 2, 156, 62, 48507);
		addText(48508, "BARBASSAULT", 0xe3cccf, true, true, 52, 2);
		setChildren(6, rsinterface);
		setBounds(48501, 8, 0, 0, rsinterface);
		setBounds(48502, 25, 81, 1, rsinterface);
		setBounds(48503, 25, 81, 2, rsinterface);
		setBounds(48505, 25, 149, 3, rsinterface);
		setBounds(48506, 25, 149, 4, rsinterface);
		setBounds(48508, 102, 241, 5, rsinterface);
	}

	public static void SquealOfFortuneScreen(TextDrawingArea[] wid) { // this is
																		// the
																		// prize
																		// interface
		RSInterface rsinterface = addTabInterface(16600);
		rsinterface.totalChildren(15);
		addSprite(16601, 2, "SquealOfFortune/BG");
		lotteryItem(16602);
		addText(16603, "", wid, 0, 0xffffff, false, true); // You've won a
		addHoverButton(16604, "SquealOfFortune/HOVER", 0, 124, 19,
				"Claim item", -1, 16605, 1);
		addHoveredButton(16605, "SquealOfFortune/HOVER", 1, 124, 19, 16606);
		addHoverButton(16607, "SquealOfFortune/HOVER", 0, 101, 19,
				"Play again", -1, 16608, 1);
		addHoveredButton(16608, "SquealOfFortune/HOVER", 5, 101, 19, 16609);
		addHoverButton(16610, "SquealOfFortune/DISCARD", 1, 124, 19,
				"Discard Item", -1, 16611, 1);
		addHoveredButton(16611, "SquealOfFortune/DISCARD", 2, 124, 19, 16612);
		addHoverButton(16613, "SquealOfFortune/HOVER", 3, 101, 19,
				"Claim Later", -1, 16614, 1);
		addHoveredButton(16614, "SquealOfFortune/HOVER", 4, 101, 19, 16615);
		addHoverButton(16616, "SquealOfFortune/BUY", 1, 42, 31, "Buy Spins",
				-1, 16617, 1);
		addHoveredButton(16617, "SquealOfFortune/BUY", 2, 42, 31, 16618);
		addText(16619, "", wid, 0, 0xffffff, false, true);
		addText(16620, "", wid, 0, 0xffffff, false, true);
		rsinterface.child(0, 16601, 0, 0);
		rsinterface.child(1, 16602, 87, 133);
		rsinterface.child(2, 16603, 170, 145);
		rsinterface.child(3, 16604, 338, 134);
		rsinterface.child(4, 16605, 338, 134);
		rsinterface.child(5, 16607, 361, 197);
		rsinterface.child(6, 16608, 361, 197);
		rsinterface.child(7, 16610, 338, 159);
		rsinterface.child(8, 16611, 338, 159);
		rsinterface.child(9, 16613, 361, 225);
		rsinterface.child(10, 16614, 361, 225);
		rsinterface.child(11, 16616, 107, 259);
		rsinterface.child(12, 16617, 107, 259);
		rsinterface.child(13, 16619, 147, 155);
		rsinterface.child(14, 16620, 280, 230);
	}

	public static void SquealOfFortuneScreenSpinning(TextDrawingArea[] wid) { // this
																				// is
																				// the
																				// interface
																				// when
																				// you
																				// see
																				// the
																				// wheel
		RSInterface rsinterface = addTabInterface(16500);
		rsinterface.totalChildren(8);
		addSprite(16501, 1, "SquealOfFortune/BG");
		lotteryItem(16502);
		addText(16503, "", wid, 0, 0xffffff, false, true); // You've won a
		addHoverButton(16504, "SquealOfFortune/HOVER", 0, 124, 19,
				"Claim item", -1, 16505, 1);
		addHoveredButton(16505, "SquealOfFortune/HOVER", 6, 124, 19, 16506);
		addHoverButton(16507, "SquealOfFortune/HOVER CIRCLE", 0, 25, 26,
				"Spin", -1, 16508, 1);
		addHoveredButton(16508, "SquealOfFortune/HOVER CIRCLE", 1, 25, 26,
				16509);
		addText(16510, "", wid, 0, 0xffffff, false, true);
		rsinterface.child(0, 16501, 0, 0);
		rsinterface.child(1, 16502, 418, 127);
		rsinterface.child(2, 16503, 87, 133);
		rsinterface.child(3, 16504, 338, 134);
		rsinterface.child(4, 16505, 338, 134);
		rsinterface.child(5, 16507, 414, 216);
		rsinterface.child(6, 16508, 414, 216);
		rsinterface.child(7, 16510, 255, 66);
	}

	public static void staffTab(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(24999);
		addText(28024, "Staff List", 0xff9933, true, true, -1, 1);
		addSprite(16126, 0, "Interfaces/stafftab/SPRITE");
		addSprite(16127, 1, "Interfaces/stafftab/SPRITE");
		addHoverButton(28018, "Interfaces/stafftab/SPRITE", 2, 160, 32,
				"Request Staff Assistance", -1, 28019, 1);
		addHoveredButton(28019, "Interfaces/stafftab/SPRITE", 3, 160, 32, 28020);
		addText(28000, "", 0xffffff, false, true, -1, 1);
		addText(28001, "", 0xff0000, false, true, -1, 1);
		addText(28002, "", 0xffffff, false, true, -1, 1);
		addText(28003, "", 0xff0000, false, true, -1, 1);
		addText(28004, "", 0xffffff, false, true, -1, 1);
		addText(28005, "", 0xff0000, false, true, -1, 1);
		addText(28006, "", 0xffffff, false, true, -1, 1);
		addText(28007, "", 0xff0000, false, true, -1, 1);
		addText(28008, "", 0xffffff, false, true, -1, 1);
		addText(28009, "", 0xff0000, false, true, -1, 1);
		addText(28010, "", 0xffffff, false, true, -1, 1);
		addText(28011, "", 0xff0000, false, true, -1, 1);
		addText(28012, "", 0xffffff, false, true, -1, 1);
		addText(28013, "", 0xff0000, false, true, -1, 1);
		addText(28014, "", 0xffffff, false, true, -1, 1);
		addText(28015, "", 0xff0000, false, true, -1, 1);
		addText(28016, "", 0xffffff, false, true, -1, 1);
		addText(28017, "", 0xff0000, false, true, -1, 1);
		addText(28021, "Owners", 0xff9933, true, true, -1, 3);
		addText(28022, "Administrators", 0xff9933, true, true, -1, 3);
		addText(28023, "Moderators", 0xff9933, true, true, -1, 3);
		tab.totalChildren(32);
		tab.child(0, 28024, 95, 4);
		tab.child(1, 16127, 0, 25);
		tab.child(2, 16126, 0, 221);
		tab.child(3, 16126, 0, 22);
		tab.child(4, 16126, 0, 40);
		tab.child(5, 16126, 0, 73);
		tab.child(6, 16126, 0, 91);
		tab.child(7, 16126, 0, 124);
		tab.child(8, 16126, 0, 141);
		tab.child(9, 28000, 3, 42);
		tab.child(10, 28002, 3, 57);
		tab.child(11, 28004, 3, 93);
		tab.child(12, 28006, 3, 108);
		tab.child(13, 28008, 3, 144);
		tab.child(14, 28010, 3, 159);
		tab.child(15, 28012, 3, 174);
		tab.child(16, 28014, 3, 189);
		tab.child(17, 28016, 3, 204);
		tab.child(18, 28001, 146, 42);
		tab.child(19, 28003, 146, 57);
		tab.child(20, 28005, 146, 93);
		tab.child(21, 28007, 146, 108);
		tab.child(22, 28009, 146, 144);
		tab.child(23, 28011, 146, 159);
		tab.child(24, 28013, 146, 174);
		tab.child(25, 28015, 146, 189);
		tab.child(26, 28017, 146, 204);
		tab.child(27, 28018, 15, 226);
		tab.child(28, 28019, 15, 226);
		tab.child(29, 28021, 95, 24);
		tab.child(30, 28022, 95, 75);
		tab.child(31, 28023, 95, 125);
	}

	public static void summoning(TextDrawingArea tda[]) {
		RSInterface tab = addTabInterface(25605);
		addSprite(25606, 4, "Summon/SUMMON");
		addSprite(25607, 5, "Summon/SUMMON");
		addSprite(25608, 9, "Summon/SUMMON");
		addButton(25609, 1, "Summon/SUMMON", "Call");
		addButton(25619, 2, "Summon/SUMMON", "Renew");
		addButton(25610, 3, "Summon/SUMMON", "Dismiss");
		addSprite(25611, 7, "Summon/SUMMON");
		addText(25612, "na/na", tda, 1, 0xc4b074, false, true);
		addText(25616, "SA.", tda, 1, 0xff9040, false, true);
		addText(25614, "Familiar", tda, 2, 0xcc9900, true, true);
		addText(25615, "99.99", tda, 1, 0xc4b074, false, true);
		addButton(25613, 8, "Summon/SUMMON", "Special Move");
		addText(25617, "Special Move 60/60", tda, 1, 0xffffff, false, true);
		addSprite(25618, 11, "Summon/SUMMON");
		addHead2(25618, 250, 250, 2000);
		tab.totalChildren(14);
		tab.child(0, 25606, 11, 163);
		tab.child(1, 25607, 12, 141);
		tab.child(2, 25608, 9, 29);
		tab.child(3, 25609, 23, 211);
		tab.child(4, 25610, 121, 211);
		tab.child(5, 25611, 20, 10);
		tab.child(6, 25612, 29, 194);
		tab.child(7, 25613, 9, 29);
		tab.child(8, 25614, 97, 144);
		tab.child(9, 25615, 127, 194);
		tab.child(10, 25616, 20, 63);
		tab.child(11, 25617, 35, 10);
		tab.child(12, 25618, 70, 59);
		tab.child(13, 25619, 72, 211);
	}

	public static void summoningLevelUp(TextDrawingArea wid[]) {
		RSInterface Interface = addTabInterface(22602);
		setChildren(2, Interface);
		addSprite(22603, 0, "interfaces/summoning/cons2/levelup");
		setBounds(6206, 0, 5, 0, Interface);
		setBounds(22603, 22, 5, 1, Interface);
	}

	public static void SummonTab(TextDrawingArea[] TDA) {
		RSInterface summonTI = addTabInterface(17011);
		addSprite(17012, 6, "SummonTab/SUMMON");
		addButton(17013, 7, "/SummonTab/SUMMON", "Click");

		addSprite(17014, 6, "SummonTab/SUMMON");
		addConfigButton(17015, 17032, 14, 8, "/SummonTab/SUMMON", 20, 30,
				"Call Familiar", 1, 5, 300);
		addHoverButton(17018, "/SummonTab/SUMMON", 2, 38, 36,
				"Beast of burden Inventory", -1, 17028, 1);
		addHoveredButton(17028, "/SummonTab/SUMMON", 12, 38, 36, 17029);
		addHoverButton(17022, "/SummonTab/SUMMON", 1, 38, 36, "Call Familiar",
				-1, 17030, 1);
		addHoveredButton(17030, "/SummonTab/SUMMON", 13, 38, 36, 17031);
		addHoverButton(17023, "/SummonTab/SUMMON", 3, 38, 36,
				"Dismiss Familiar", -1, 17033, 1);
		addHoveredButton(17033, "/SummonTab/SUMMON", 15, 38, 36, 17034);
		addSprite(17016, 5, "SummonTab/SUMMON");
		addText(17017, "", TDA, 2, 14329120, false, true);
		addSprite(17019, 9, "SummonTab/SUMMON");
		addText(17021, "", TDA, 0, 16753920, false, true);
		addSprite(17020, 10, "SummonTab/SUMMON");
		addSprite(17024, 11, "SummonTab/SUMMON");
		addText(17025, "", TDA, 0, 16753920, false, true);
		addText(17026, "", TDA, 0, 16753920, false, true);
		addHead2(17027, 75, 55, 2000);
		summonTI.totalChildren(19);
		summonTI.child(0, 17012, 10, 25);
		summonTI.child(1, 17013, 24, 7);
		summonTI.child(2, 17014, 10, 25);
		summonTI.child(3, 17015, 11, 25);
		summonTI.child(4, 17016, 15, 140);
		summonTI.child(5, 17017, 45, 143);
		summonTI.child(6, 17018, 20, 170);
		summonTI.child(7, 17019, 115, 167);
		summonTI.child(8, 17020, 143, 170);
		summonTI.child(9, 17021, 135, 197);
		summonTI.child(10, 17022, 20, 213);
		summonTI.child(11, 17023, 67, 193);
		summonTI.child(12, 17024, 135, 214);
		summonTI.child(13, 17025, 135, 240);
		summonTI.child(14, 17026, 21, 59);
		summonTI.child(15, 17027, 75, 55);
		summonTI.child(16, 17028, 20, 170);
		summonTI.child(17, 17030, 20, 213);
		summonTI.child(18, 17033, 67, 193);
	}

	public static void teleport(TextDrawingArea[] TDA) {
		RSInterface localRSInterface = addInterface(11650);
		addSprite(11651, 10, "CLICK");
		addHoverButton(11652, "CLICK", 2, 200, 30, "Which Zone?", -1, 11653, 1);
		addHoveredButton(11653, "CLICK", 2, 200, 30, 11654);
		addHoverButton(11655, "CLICK", 3, 200, 30, "Which Zone?", -1, 11656, 1);
		addHoveredButton(11656, "CLICK", 3, 200, 30, 11657);
		addHoverButton(11658, "CLICK", 3, 200, 30, "Which Zone?", -1, 11659, 1);
		addHoveredButton(11659, "CLICK", 3, 200, 30, 11660);
		addHoverButton(11661, "CLICK", 3, 200, 30, "Which Zone?", -1, 11662, 1);
		addHoveredButton(11662, "CLICK", 3, 200, 30, 11663);
		addHoverButton(11664, "CLICK", 3, 200, 30, "Which Zone?", -1, 11665, 1);
		addHoveredButton(11665, "CLICK", 3, 200, 30, 11666);
		addHoverButton(11667, "CLICK", 3, 200, 30, "Which Zone?", -1, 11668, 1);
		addHoveredButton(11668, "CLICK", 3, 200, 30, 11669);
		addHoverButton(11670, "CLICK", 3, 200, 30, "Which Zone?", -1, 11671, 1);
		addHoveredButton(11671, "CLICK", 3, 200, 30, 11672);
		addHoverButton(11673, "CLICK", 1, 200, 30, "Stop Viewing", -1, 11674, 1);
		addHoveredButton(11674, "CLICK", 1, 200, 30, 11675);
		addText(11204, "Yak's/Rock Crabs", TDA, 0, 16750623, false, true);
		addText(11208, "Taverly Dungeon", TDA, 0, 16750623, false, true);
		addText(11212, "Slayer Tower", TDA, 0, 16750623, false, true);
		addText(11216, "Brimhaven Dungeon", TDA, 0, 16750623, false, true);
		addText(11220, "Hill Giants", TDA, 0, 16750623, false, true);
		// addText(11220, "Hill Giants", TDA, false, true, -1, TDA, 2);
		addText(11224, "Dark Beasts", TDA, 0, 16750623, false, true);
		addText(11228, "Strykeworms", TDA, 0, 16750623, false, true);
		localRSInterface.totalChildren(24);
		localRSInterface.child(0, 11651, 0, 0);
		localRSInterface.child(1, 11652, 12, 40);
		localRSInterface.child(2, 11653, 11, 40);
		localRSInterface.child(3, 11655, 12, 65);
		localRSInterface.child(4, 11656, 11, 65);
		localRSInterface.child(5, 11658, 12, 90);
		localRSInterface.child(6, 11659, 11, 90);
		localRSInterface.child(7, 11661, 12, 115);
		localRSInterface.child(8, 11662, 11, 115);
		localRSInterface.child(9, 11664, 12, 143);
		localRSInterface.child(10, 11665, 11, 143);
		localRSInterface.child(11, 11667, 12, 168);
		localRSInterface.child(12, 11668, 11, 168);
		localRSInterface.child(13, 11670, 12, 193);
		localRSInterface.child(14, 11671, 11, 193);
		localRSInterface.child(15, 11673, 38, 236);
		localRSInterface.child(16, 11674, 38, 236);
		localRSInterface.child(17, 11204, 38, 45);
		localRSInterface.child(18, 11208, 38, 70);
		localRSInterface.child(19, 11212, 38, 95);
		localRSInterface.child(20, 11216, 38, 120);
		localRSInterface.child(21, 11220, 38, 147);
		localRSInterface.child(22, 11224, 38, 174);
		localRSInterface.child(23, 11228, 38, 201);
		localRSInterface = addTabInterface(14000);
		localRSInterface.width = 474;
		localRSInterface.height = 213;
		localRSInterface.scrollMax = 305;
		for (int i = 14001; i <= 14030; ++i) {
			addText(i, "", TDA, 1, 16777215, false, true);
		}
		localRSInterface.totalChildren(30);
		int i = 0;
		int j = 5;
		for (int k = 14001; k <= 14030; ++k) {
			localRSInterface.child(i, k, 248, j);
			++i;
			j += 13;
		}
	}

	public static void textColor(int id, int color) {
		RSInterface rsi = interfaceCache[id];
		rsi.textColor = color;
	}

	public static void textSize(int id, TextDrawingArea tda[], int idx) {
		RSInterface rsi = interfaceCache[id];
		rsi.textDrawingAreas = tda[idx];
	}

	public static void Trade(TextDrawingArea TDA[]) {
		RSInterface Interface = addTabInterface(3323);
		setChildren(15, Interface);
		addSprite(3324, 6, "Bank/TRADE");
		addHover(3442, 3, 0, 3325, 1, "Bank/BANK", 17, 17, "Close Window");
		addHovered(3325, 2, "Bank/BANK", 17, 17, 3326);
		addText(3417, "Trading With:", 0xff9933, true, true, 52, TDA, 2);
		addText(3418, "Trader's Offer", 0xff9933, false, true, 52, TDA, 1);
		addText(3419, "Your Offer", 0xff9933, false, true, 52, TDA, 1);
		addText(3421, "Accept", 49152, true, true, 52, TDA, 1);
		addText(3423, "Decline", 0xc00000, true, true, 52, TDA, 1);
		addText(3431, "Waiting For Other Player", 0xffffff, true, true, 52,
				TDA, 1);
		addHover(3420, 1, 0, 3327, 5, "Bank/TRADE", 65, 32, "Accept");
		addHovered(3327, 2, "Bank/TRADE", 65, 32, 3328);
		addHover(3422, 3, 0, 3329, 5, "Bank/TRADE", 65, 32, "Close Window");
		addHovered(3329, 2, "Bank/TRADE", 65, 32, 3330);
		setBounds(3324, 0, 16, 0, Interface);
		setBounds(3442, 485, 24, 1, Interface);
		setBounds(3325, 485, 24, 2, Interface);
		setBounds(3417, 258, 25, 3, Interface);
		setBounds(3418, 355, 51, 4, Interface);
		setBounds(3419, 68, 51, 5, Interface);
		setBounds(3420, 223, 120, 6, Interface);
		setBounds(3327, 223, 120, 7, Interface);
		setBounds(3422, 223, 160, 8, Interface);
		setBounds(3329, 223, 160, 9, Interface);
		setBounds(3421, 256, 127, 10, Interface);
		setBounds(3423, 256, 167, 11, Interface);
		setBounds(3431, 256, 272, 12, Interface);
		setBounds(3415, 12, 64, 13, Interface);
		setBounds(3416, 321, 64, 14, Interface);
		Interface = addTabInterface(3443);
		setChildren(15, Interface);
		addSprite(3444, 3, "Bank/TRADE");
		addButton(3546, 2, "Bank/SHOP", 63, 24, "Accept", 1);
		addButton(3548, 2, "Bank/SHOP", 63, 24, "Decline", 3);
		addText(3547, "Accept", 49152, true, true, 52, TDA, 1);
		addText(3549, "Decline", 0xc00000, true, true, 52, TDA, 1);
		addText(3450, "Trading With:", 65535, true, true, 52, TDA, 2);
		addText(3451, "Yourself", 65535, true, true, 52, TDA, 2);
		setBounds(3444, 12, 20, 0, Interface);
		setBounds(3442, 470, 32, 1, Interface);
		setBounds(3325, 470, 32, 2, Interface);
		setBounds(3535, 130, 28, 3, Interface);
		setBounds(3536, 105, 47, 4, Interface);
		setBounds(3546, 189, 295, 5, Interface);
		setBounds(3548, 258, 295, 6, Interface);
		setBounds(3547, 220, 299, 7, Interface);
		setBounds(3549, 288, 299, 8, Interface);
		setBounds(3557, 71, 87, 9, Interface);
		setBounds(3558, 315, 87, 10, Interface);
		setBounds(3533, 64, 70, 11, Interface);
		setBounds(3534, 297, 70, 12, Interface);
		setBounds(3450, 95, 289, 13, Interface);
		setBounds(3451, 95, 304, 14, Interface);
	}

	public static void unpack(StreamLoader streamLoader,
			TextDrawingArea textDrawingAreas[], StreamLoader streamLoader_1) {
		fonts = textDrawingAreas;
		aMRUNodes_238 = new MRUNodes(60000);
		Stream stream = new Stream(streamLoader.getDataForName("data"));
		int i = -1;
		stream.readUnsignedWord();
		interfaceCache = new RSInterface[60000];
		do {
			if (stream.currentOffset >= stream.buffer.length) {
				break;
			}
			int k = stream.readUnsignedWord();
			if (k == 65535) {
				i = stream.readUnsignedWord();
				k = stream.readUnsignedWord();
			}
			RSInterface rsInterface = interfaceCache[k] = new RSInterface();
			rsInterface.id = k;
			rsInterface.parentID = i;
			rsInterface.type = stream.readUnsignedByte();
			rsInterface.atActionType = stream.readUnsignedByte();
			rsInterface.contentType = stream.readUnsignedWord();
			rsInterface.width = stream.readUnsignedWord();
			rsInterface.height = stream.readUnsignedWord();
			rsInterface.opacity = (byte) stream.readUnsignedByte();
			rsInterface.mOverInterToTrigger = stream.readUnsignedByte();
			if (rsInterface.mOverInterToTrigger != 0) {
				rsInterface.mOverInterToTrigger = (rsInterface.mOverInterToTrigger - 1 << 8)
						+ stream.readUnsignedByte();
			} else {
				rsInterface.mOverInterToTrigger = -1;
			}
			int i1 = stream.readUnsignedByte();
			if (i1 > 0) {
				rsInterface.valueCompareType = new int[i1];
				rsInterface.requiredValues = new int[i1];
				for (int j1 = 0; j1 < i1; j1++) {
					rsInterface.valueCompareType[j1] = stream
							.readUnsignedByte();
					rsInterface.requiredValues[j1] = stream.readUnsignedWord();
				}

			}
			int k1 = stream.readUnsignedByte();
			if (k1 > 0) {
				rsInterface.valueIndexArray = new int[k1][];
				for (int l1 = 0; l1 < k1; l1++) {
					int i3 = stream.readUnsignedWord();
					rsInterface.valueIndexArray[l1] = new int[i3];
					for (int l4 = 0; l4 < i3; l4++) {
						rsInterface.valueIndexArray[l1][l4] = stream
								.readUnsignedWord();
					}
				}

			}
			if (rsInterface.type == 0) {
				rsInterface.drawsTransparent = false;
				rsInterface.scrollMax = stream.readUnsignedWord();
				rsInterface.isMouseoverTriggered = stream.readUnsignedByte() == 1;
				int i2 = stream.readUnsignedWord();
				rsInterface.children = new int[i2];
				rsInterface.childX = new int[i2];
				rsInterface.childY = new int[i2];
				for (int j3 = 0; j3 < i2; j3++) {
					rsInterface.children[j3] = stream.readUnsignedWord();
					rsInterface.childX[j3] = stream.readSignedWord();
					rsInterface.childY[j3] = stream.readSignedWord();
				}

			}
			if (rsInterface.type == 1) {
				stream.readUnsignedWord();
				stream.readUnsignedByte();
			}
			if (rsInterface.type == 2) {
				rsInterface.inv = new int[rsInterface.width
						* rsInterface.height];
				rsInterface.invStackSizes = new int[rsInterface.width
						* rsInterface.height];
				rsInterface.aBoolean259 = stream.readUnsignedByte() == 1;
				rsInterface.isInventoryInterface = stream.readUnsignedByte() == 1;
				rsInterface.usableItemInterface = stream.readUnsignedByte() == 1;
				rsInterface.aBoolean235 = stream.readUnsignedByte() == 1;
				rsInterface.invSpritePadX = stream.readUnsignedByte();
				rsInterface.invSpritePadY = stream.readUnsignedByte();
				rsInterface.spritesX = new int[20];
				rsInterface.spritesY = new int[20];
				rsInterface.sprites = new Sprite[20];
				for (int j2 = 0; j2 < 20; j2++) {
					int k3 = stream.readUnsignedByte();
					if (k3 != 1) {
						continue;
					}
					rsInterface.spritesX[j2] = stream.readSignedWord();
					rsInterface.spritesY[j2] = stream.readSignedWord();
					String s1 = stream.readString();
					if (streamLoader_1 != null && s1.length() > 0) {
						int i5 = s1.lastIndexOf(",");
						rsInterface.sprites[j2] = method207(
								Integer.parseInt(s1.substring(i5 + 1)),
								streamLoader_1, s1.substring(0, i5));
					}
				}
				rsInterface.itemActions = new String[6];
				for (int l3 = 0; l3 < 5; l3++) {
					rsInterface.itemActions[l3] = stream.readString();
					if (rsInterface.parentID == 3824) {
						rsInterface.itemActions[4] = "Buy 200";
					}
					// if(rsInterface.parentID == 3822)
					// rsInterface.itemActions[4] = "Sell 50";
					if (rsInterface.itemActions[l3].length() == 0) {
						rsInterface.itemActions[l3] = null;
					}
					if (rsInterface.parentID == 1644) {
						rsInterface.itemActions[2] = "Operate";
					}
				}

			}
			if (rsInterface.type == 3) {
				rsInterface.aBoolean227 = stream.readUnsignedByte() == 1;
			}
			if (rsInterface.type == 4 || rsInterface.type == 1) {
				rsInterface.centerText = stream.readUnsignedByte() == 1;
				int k2 = stream.readUnsignedByte();
				if (textDrawingAreas != null) {
					rsInterface.textDrawingAreas = textDrawingAreas[k2];
				}
				rsInterface.textShadow = stream.readUnsignedByte() == 1;
			}
			if (rsInterface.type == 4) {
				rsInterface.message = stream.readString();
				rsInterface.disabledText = stream.readString();
			}
			if (rsInterface.type == 1 || rsInterface.type == 3
					|| rsInterface.type == 4) {
				rsInterface.textColor = stream.readDWord();
			}
			if (rsInterface.type == 3 || rsInterface.type == 4) {
				rsInterface.anInt219 = stream.readDWord();
				rsInterface.textHoverColour = stream.readDWord();
				rsInterface.anInt239 = stream.readDWord();
			}
			if (rsInterface.type == 5) {
				rsInterface.drawsTransparent = false;
				String s = stream.readString();
				if (streamLoader_1 != null && s.length() > 0) {
					int i4 = s.lastIndexOf(",");
					rsInterface.sprite1 = method207(
							Integer.parseInt(s.substring(i4 + 1)),
							streamLoader_1, s.substring(0, i4));
				}
				s = stream.readString();
				if (streamLoader_1 != null && s.length() > 0) {
					int j4 = s.lastIndexOf(",");
					rsInterface.sprite2 = method207(
							Integer.parseInt(s.substring(j4 + 1)),
							streamLoader_1, s.substring(0, j4));
				}
			}
			if (rsInterface.type == 6) {
				int l = stream.readUnsignedByte();
				if (l != 0) {
					rsInterface.anInt233 = 1;
					rsInterface.mediaID = (l - 1 << 8)
							+ stream.readUnsignedByte();
				}
				l = stream.readUnsignedByte();
				if (l != 0) {
					rsInterface.anInt255 = 1;
					rsInterface.anInt256 = (l - 1 << 8)
							+ stream.readUnsignedByte();
				}
				l = stream.readUnsignedByte();
				if (l != 0) {
					rsInterface.anInt257 = (l - 1 << 8)
							+ stream.readUnsignedByte();
				} else {
					rsInterface.anInt257 = -1;
				}
				l = stream.readUnsignedByte();
				if (l != 0) {
					rsInterface.anInt258 = (l - 1 << 8)
							+ stream.readUnsignedByte();
				} else {
					rsInterface.anInt258 = -1;
				}
				rsInterface.modelZoom = stream.readUnsignedWord();
				rsInterface.modelRotation1 = stream.readUnsignedWord();
				rsInterface.modelRotation2 = stream.readUnsignedWord();
			}
			if (rsInterface.type == 7) {
				rsInterface.inv = new int[rsInterface.width
						* rsInterface.height];
				rsInterface.invStackSizes = new int[rsInterface.width
						* rsInterface.height];
				rsInterface.centerText = stream.readUnsignedByte() == 1;
				int l2 = stream.readUnsignedByte();
				if (textDrawingAreas != null) {
					rsInterface.textDrawingAreas = textDrawingAreas[l2];
				}
				rsInterface.textShadow = stream.readUnsignedByte() == 1;
				rsInterface.textColor = stream.readDWord();
				rsInterface.invSpritePadX = stream.readSignedWord();
				rsInterface.invSpritePadY = stream.readSignedWord();
				rsInterface.isInventoryInterface = stream.readUnsignedByte() == 1;
				rsInterface.itemActions = new String[6];
				for (int k4 = 0; k4 < 5; k4++) {
					rsInterface.itemActions[k4] = stream.readString();
					if (rsInterface.itemActions[k4].length() == 0) {
						rsInterface.itemActions[k4] = null;
					}
				}

			}
			if (rsInterface.atActionType == 2 || rsInterface.type == 2) {
				rsInterface.selectedActionName = stream.readString();
				rsInterface.spellName = stream.readString();
				rsInterface.spellUsableOn = stream.readUnsignedWord();
			}
			if (rsInterface.type == 8) {
				rsInterface.message = stream.readString();
			}
			if (rsInterface.atActionType == 1 || rsInterface.atActionType == 4
					|| rsInterface.atActionType == 5
					|| rsInterface.atActionType == 6) {
				rsInterface.tooltip = stream.readString();
				if (rsInterface.tooltip.length() == 0) {
					if (rsInterface.atActionType == 1) {
						rsInterface.tooltip = "Ok";
					}
					if (rsInterface.atActionType == 4) {
						rsInterface.tooltip = "Select";
					}
					if (rsInterface.atActionType == 5) {
						rsInterface.tooltip = "Select";
					}
					if (rsInterface.atActionType == 6) {
						rsInterface.tooltip = "Continue";
					}
				}
			}
		} while (true);
		aMRUNodes_238 = null;
	}

	public static void unpackCustom(StreamLoader streamLoader,
			TextDrawingArea[] textDrawingAreas) {
		aMRUNodes_238 = new MRUNodes(65000);
		aClass44 = streamLoader;
		// /~~~~~~~~~~~~~~~~~~Monsterrays
		// Interfaces~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		cardTable(textDrawingAreas);
		BeretChange(textDrawingAreas);
		robinChange(textDrawingAreas);

		Curses(textDrawingAreas);
		prayerMenu(textDrawingAreas);
		emoteTab();
		Bank();
		optionTab(textDrawingAreas);
		NewSkillLamp(textDrawingAreas);
		SquealOfFortuneScreen(textDrawingAreas);
		SquealOfFortuneScreenSpinning(textDrawingAreas);
		clanChatTab(textDrawingAreas);
		questTab(textDrawingAreas);
		pkingTab(textDrawingAreas);
		dungTab(textDrawingAreas);
		Shop(textDrawingAreas);
		SummonTab(textDrawingAreas);
		vote(textDrawingAreas);
		SolChange(textDrawingAreas);
		Classes(textDrawingAreas);
		GodWars(textDrawingAreas);
		bobInterface(textDrawingAreas);
		Trade(textDrawingAreas);
		Sidebar0(textDrawingAreas);
		friendsTab(textDrawingAreas);
		ignoreTab(textDrawingAreas);
		Pestpanel(textDrawingAreas);
		Pestpanel2(textDrawingAreas);
		equipmentScreen(textDrawingAreas);
		EquipmentTab(textDrawingAreas);
		magicTab(textDrawingAreas);
		ancientMagicTab(textDrawingAreas);
		configureLunar(textDrawingAreas);
		constructLunar();
		quickPrayers(textDrawingAreas);
		Construction(textDrawingAreas);
		itemsOnDeath(textDrawingAreas);
		itemsOnDeathDATA(textDrawingAreas);
		quickCurses(textDrawingAreas);
		newLamp(textDrawingAreas);
		extraEquipment(textDrawingAreas);
		staffTab(textDrawingAreas);
		LodestoneNetwork(textDrawingAreas);
		SquealOfFortune(textDrawingAreas);
		passwordChanger(textDrawingAreas);
		summoningLevelUp(textDrawingAreas);
		// skillInterface(textDrawingAreas);
		scrollCreation(textDrawingAreas);
		summoning(textDrawingAreas);
		pouchCreation(textDrawingAreas);
		settingsInterface(textDrawingAreas);
		teleport(textDrawingAreas);
		wilderness(textDrawingAreas);
		boss(textDrawingAreas);
		minigame(textDrawingAreas);
		RSInterface miasmic = interfaceCache[13095];
		miasmic.spellName = "Miasmic Barrage";
		miasmic.spellUsableOn = 10;
		miasmic.atActionType = 2;
		miasmic.tooltip = "Cast @gre@Miasmic Barrage";
		miasmic.selectedActionName = "Cast On";
		aMRUNodes_238 = null;
	}

	public static void vote(TextDrawingArea[] TDA) {
		RSInterface tab = addTabInterface(19050);
		addSprite(19051, 4, "Vote/CUSTOM");
		addHoverButton(19052, "Vote/CUSTOM", 0, 63, 44, "@red@Misc reward", 0,
				19053, 1);
		addHoveredButton(19053, "Vote/CUSTOM", 1, 63, 44, 19054);
		addHoverButton(19055, "Vote/CUSTOM", 2, 39, 45, "@red@Cash reward", 0,
				19056, 1);
		addHoveredButton(19056, "Vote/CUSTOM", 3, 39, 45, 19057);
		tab.totalChildren(5);
		tab.child(0, 19051, 80, 95);
		tab.child(1, 19052, 300, 155);
		tab.child(2, 19053, 300, 155);
		tab.child(3, 19055, 150, 155);
		tab.child(4, 19056, 150, 155);
	}

	public static final void wilderness(TextDrawingArea[] TDA) {
		RSInterface rsinterface = addTabInterface(45600);
		addText(45601, "P'King Teleport", 0xff9b00, false, true, 52, TDA, 2);
		addHoverButton(45602, "Interfaces/Minigame/Hover", 0, 172, 24,
				"Mage Bank", -1, 45603, 1);
		addHoveredButton(45603, "Interfaces/Minigame/Hover", 2, 172, 24, 45604);
		addHoverButton(45618, "Interfaces/Minigame/Hover", 0, 172, 24,
				"Varrock PK (Multi)", -1, 45619, 1);
		addHoveredButton(45619, "Interfaces/Minigame/Hover", 2, 172, 24, 45620);
		addHoverButton(45621, "Interfaces/Minigame/Hover", 0, 172, 24,
				"GraveYard (Lvl 19)", -1, 45622, 1);
		addHoveredButton(45622, "Interfaces/Minigame/Hover", 2, 172, 24, 45623);
		addHoverButton(45624, "Interfaces/Minigame/Hover", 0, 172, 24,
				"Edgeville", -1, 45625, 1);
		addHoveredButton(45625, "Interfaces/Minigame/Hover", 2, 172, 24, 45626);
		addHoverButton(45627, "Interfaces/Minigame/Hover", 0, 172, 24,
				"Green Dragons", -1, 45628, 1);
		addHoveredButton(45628, "Interfaces/Minigame/Hover", 2, 172, 24, 45629);
		addHoverButton(45633, "Interfaces/Minigame/Back", 0, 16, 16, "Back",
				-1, 45634, 1);
		addHoveredButton(45634, "Interfaces/Minigame/Back", 1, 16, 16, 45635);
		addSprite(45605, 1, "Interfaces/Minigame/Pk");
		addSprite(45606, 1, "Interfaces/Minigame/Pk");
		addSprite(45607, 1, "Interfaces/Minigame/Pk");
		addSprite(45608, 1, "Interfaces/Minigame/Pk");
		addSprite(45609, 1, "Interfaces/Minigame/Pk");
		addSprite(45611, 1, "Interfaces/Minigame/Background");
		addText(45612, "Mage Bank", 0xd67b29, true, true, 52, TDA, 2);
		addText(45613, "Varrock PK (Multi)", 0xd67b29, true, true, 52, TDA, 2);
		addText(45614, "GraveYard", 0xd67b29, true, true, 52, TDA, 2);
		addText(45615, "Edgeville", 0xd67b29, true, true, 52, TDA, 2);
		addText(45616, "Green Dragons", 0xd67b29, true, true, 52, TDA, 2);
		byte childAmount = 24;
		int indexChild = 0;
		setChildren(childAmount, rsinterface);
		setBounds(45611, -1, 26, indexChild, rsinterface);
		indexChild++;
		setBounds(45601, 33, 7, indexChild, rsinterface);
		indexChild++;
		setBounds(45602, 8, 35, indexChild, rsinterface);
		indexChild++;
		setBounds(45603, 8, 35, indexChild, rsinterface);
		indexChild++;
		setBounds(45612, 80, 39, indexChild, rsinterface);
		indexChild++;
		setBounds(45618, 8, 72, indexChild, rsinterface);
		indexChild++;
		setBounds(45619, 8, 72, indexChild, rsinterface);
		indexChild++;
		setBounds(45613, 80, 76, indexChild, rsinterface);
		indexChild++;
		setBounds(45621, 8, 109, indexChild, rsinterface);
		indexChild++;
		setBounds(45622, 8, 109, indexChild, rsinterface);
		indexChild++;
		setBounds(45614, 80, 113, indexChild, rsinterface);
		indexChild++;
		setBounds(45624, 8, 146, indexChild, rsinterface);
		indexChild++;
		setBounds(45625, 8, 146, indexChild, rsinterface);
		indexChild++;
		setBounds(45615, 80, 150, indexChild, rsinterface);
		indexChild++;
		setBounds(45627, 8, 183, indexChild, rsinterface);
		indexChild++;
		setBounds(45628, 8, 183, indexChild, rsinterface);
		indexChild++;
		setBounds(45616, 80, 187, indexChild, rsinterface);
		indexChild++;
		setBounds(45605, 148, 34, indexChild, rsinterface);
		indexChild++;
		setBounds(45606, 148, 71, indexChild, rsinterface);
		indexChild++;
		setBounds(45607, 148, 108, indexChild, rsinterface);
		indexChild++;
		setBounds(45608, 148, 146, indexChild, rsinterface);
		indexChild++;
		setBounds(45609, 148, 183, indexChild, rsinterface);
		indexChild++;
		setBounds(45633, 10, 6, indexChild, rsinterface);
		indexChild++;
		setBounds(45634, 10, 6, indexChild, rsinterface);
		indexChild++;
	}

	public RSInterface() {
		itemSpriteId1 = -1;
		itemSpriteId2 = -1;
		itemSpriteZoom1 = -1;
		itemSpriteZoom2 = -1;
		itemSpriteIndex = 0;
	}

	public void child(int id, int interID, int x, int y) {
		children[id] = interID;
		childX[id] = x;
		childY[id] = y;
	}

	private Model method206(int i, int j) {
		Model model = (Model) aMRUNodes_264.insertFromCache((i << 16) + j);
		if (model != null) {
			return model;
		}
		if (i == 1) {
			model = Model.method462(j);
		}
		if (i == 2) {
			model = EntityDef.forID(j).method160();
		}
		if (i == 3) {
			model = Client.myPlayer.method453();
		}
		if (i == 4) {
			model = ItemDef.forID(j).method202(50);
		}
		if (i == 5) {
			model = null;
		}
		if (model != null) {
			aMRUNodes_264.removeFromCache(model, (i << 16) + j);
		}
		return model;
	}

	public Model method209(int j, int k, boolean flag) {
		Model model;
		if (flag) {
			model = method206(anInt255, anInt256);
		} else {
			model = method206(anInt233, mediaID);
		}
		if (model == null) {
			return null;
		}
		if (k == -1 && j == -1 && model.anIntArray1640 == null) {
			return model;
		}
		Model model_1 = new Model(true, Class36.method532(k)
				& Class36.method532(j), false, model);
		if (k != -1 || j != -1) {
			model_1.method469();
		}
		if (k != -1) {
			model_1.method470(k);
		}
		if (j != -1) {
			model_1.method470(j);
		}
		model_1.method479(64, 768, -50, -10, -50, true);
		return model_1;
	}

	public void specialBar(int id) {
		addActionButton(id - 12, 7587, -1, 150, 26, "Use @gre@Special Attack");
		for (int i = id - 11; i < id; i++) {
			removeSomething(i);
		}
		RSInterface rsi = interfaceCache[id - 12];
		rsi.width = 150;
		rsi.height = 26;
		rsi = interfaceCache[id];
		rsi.width = 150;
		rsi.height = 26;
		rsi.child(0, id - 12, 0, 0);
		rsi.child(12, id + 1, 3, 7);
		rsi.child(23, id + 12, 16, 8);
		for (int i = 13; i < 23; i++) {
			rsi.childY[i]--;
		}
		rsi = interfaceCache[id + 1];
		rsi.type = 5;
		rsi.sprite1 = CustomSpriteLoader(7600, "");
		for (int i = id + 2; i < id + 12; i++) {
			rsi = interfaceCache[i];
			rsi.type = 5;
		}
		sprite1(id + 2, 7601);
		sprite1(id + 3, 7602);
		sprite1(id + 4, 7603);
		sprite1(id + 5, 7604);
		sprite1(id + 6, 7605);
		sprite1(id + 7, 7606);
		sprite1(id + 8, 7607);
		sprite1(id + 9, 7608);
		sprite1(id + 10, 7609);
		sprite1(id + 11, 7610);
	}

	public void swapInventoryItems(int i, int j) {
		int k = inv[i];
		inv[i] = inv[j];
		inv[j] = k;
		k = invStackSizes[i];
		invStackSizes[i] = invStackSizes[j];
		invStackSizes[j] = k;
	}

	public void totalChildren(int t) {
		children = new int[t];
		childX = new int[t];
		childY = new int[t];
	}

	public void totalChildren(int id, int x, int y) {
		children = new int[id];
		childX = new int[x];
		childY = new int[y];
	}

}