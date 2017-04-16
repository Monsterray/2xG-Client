/**
 * Has all of the stuff for all of the Entitys in the game.\n Like all of the
 * NPCs in the game, you can also add new NPCs in here.
 */
public final class EntityDef {

	public static int NPCAMOUNT = 11599;

	public static int anInt56;

	public static int streamIndices[];

	public static EntityDef forID(int i) {
		for (int j = 0; j < 20; j++) {
			if (cache[j].type == i) {
				return cache[j];
			}
		}
		anInt56 = (anInt56 + 1) % 20;
		EntityDef entityDef = cache[anInt56] = new EntityDef();
		stream.currentOffset = streamIndices[i];
		entityDef.type = i;
		entityDef.readValues(stream);
		if (i == 4677) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[1] = "Attack";
			entityDef.name = "Elvarg";
			entityDef.combatLevel = 150;
		}
		int myass = 4247;
		if (i == myass) {
			entityDef.name = "Construction Manager";
			entityDef.description = "2xG Official Construction Seller!"
					.getBytes();
			entityDef.itemActions[2] = "Visit House";
			entityDef.itemActions[3] = "Buy Skillcape";
		}
		if (i == 10040) {
			entityDef.itemActions[1] = "Attack";
			entityDef.combatLevel = 521;
		}
		if (i == 251) {
			entityDef.name = "King Milestone";
			entityDef.itemActions[2] = "Milestone";
			entityDef.description = "2xG Official MilestoneCape Seller"
					.getBytes();
		}
		if (i == 9713) {
			entityDef.itemActions[2] = "Buy Skillcape";
		}
		if (i == 666) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[0] = "Pick-up";
			entityDef.itemActions[2] = "Talk";
			entityDef.itemActions[3] = "Interact-with";
			entityDef.anIntArray94 = new int[1];
			entityDef.anIntArray94[0] = 44751;
			entityDef.name = "Tzrek-jad";
			entityDef.description = "A fearsome obsidian beast... Aww, so cute."
					.getBytes();
		}
		if (i == 2221) {
			stream.currentOffset = streamIndices[630];
			entityDef.aByte68 = 1;
			entityDef.readValues(stream);
			entityDef.itemActions = new String[5];
			entityDef.itemActions[0] = "Drive";
			entityDef.anIntArray94 = new int[1];
			entityDef.anIntArray94[0] = 52041;
			entityDef.name = "Car";
			entityDef.description = "Monsterrays`s Pink Car LikeaBoss"
					.getBytes();
		}
		if (i == 2586) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[1] = "Attack";
			entityDef.anIntArray94 = new int[2];
			entityDef.anIntArray94[0] = 62747;
			entityDef.anIntArray94[1] = 62734;
			entityDef.aByte68 = 1;
			entityDef.anInt91 = 130;
			entityDef.anInt86 = 130;
			entityDef.standAnim = 808;// stand animation
			entityDef.walkAnim = 819;// walk animation
			entityDef.name = "Glacies";
			entityDef.combatLevel = 285;
		}
		if (i == 5001) {
			entityDef.anIntArray94 = new int[1];
			entityDef.anIntArray94[0] = 62717;
			entityDef.name = "Nex";
			entityDef.aByte68 = 3;
			entityDef.standAnim = 6320;
			entityDef.walkAnim = 6319;
			entityDef.itemActions = new String[5];
			entityDef.itemActions[1] = "Attack";
			entityDef.combatLevel = 1001;
			// entityDef.headicon = 19;
		}
		if (i == 2587) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[1] = "Attack";
			entityDef.anIntArray94 = new int[2];
			entityDef.anIntArray94[0] = 62747;
			entityDef.anIntArray94[1] = 62734;
			entityDef.anIntArray70 = new int[10];
			entityDef.anIntArray76 = new int[10];
			entityDef.anIntArray76[0] = 33893;
			entityDef.anIntArray70[0] = 828;
			entityDef.anIntArray76[1] = 34853;
			entityDef.anIntArray70[1] = 795;
			entityDef.anIntArray76[2] = 35214;
			entityDef.anIntArray70[2] = 780;
			entityDef.anIntArray76[3] = 32882;
			entityDef.anIntArray70[3] = 828;
			entityDef.anIntArray76[4] = 32832;
			entityDef.anIntArray70[4] = 828;
			entityDef.anIntArray76[5] = 35461;
			entityDef.anIntArray70[5] = 774;
			entityDef.anIntArray76[6] = 35216;
			entityDef.anIntArray70[6] = 782;
			entityDef.anIntArray76[7] = 30885;
			entityDef.anIntArray70[7] = 794;
			entityDef.anIntArray76[8] = 34568;
			entityDef.anIntArray70[8] = 780;
			entityDef.anIntArray76[9] = 34454;
			entityDef.anIntArray70[9] = 794;
			entityDef.aByte68 = 1;
			entityDef.anInt91 = 130;
			entityDef.anInt86 = 130;
			entityDef.standAnim = 808;// stand animation
			entityDef.walkAnim = 819;// walk animation
			entityDef.name = "Cruor";
			entityDef.combatLevel = 285;
		}
		if (i == 2588) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[1] = "Attack";
			entityDef.anIntArray94 = new int[2];
			entityDef.anIntArray94[0] = 62747;
			entityDef.anIntArray94[1] = 62734;
			entityDef.anIntArray70 = new int[10];
			entityDef.anIntArray76 = new int[10];
			entityDef.anIntArray76[0] = 33893;
			entityDef.anIntArray70[0] = 80;
			entityDef.anIntArray76[1] = 34853;
			entityDef.anIntArray70[1] = 45;
			entityDef.anIntArray76[2] = 35214;
			entityDef.anIntArray70[2] = 25;
			entityDef.anIntArray76[3] = 32882;
			entityDef.anIntArray70[3] = 68;
			entityDef.anIntArray76[4] = 32832;
			entityDef.anIntArray70[4] = 68;
			entityDef.anIntArray76[5] = 35461;
			entityDef.anIntArray70[5] = 20;
			entityDef.anIntArray76[6] = 35216;
			entityDef.anIntArray70[6] = 30;
			entityDef.anIntArray76[7] = 30885;
			entityDef.anIntArray70[7] = 45;
			entityDef.anIntArray76[8] = 34568;
			entityDef.anIntArray70[8] = 30;
			entityDef.anIntArray76[9] = 34454;
			entityDef.anIntArray70[9] = 45;
			entityDef.aByte68 = 1;
			entityDef.anInt91 = 130;
			entityDef.anInt86 = 130;
			entityDef.standAnim = 808;// stand animation
			entityDef.walkAnim = 819;// walk animation
			entityDef.name = "Fumus";
			entityDef.combatLevel = 285;
		}
		if (i == 2589) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[1] = "Attack";
			entityDef.anIntArray94 = new int[2];
			entityDef.anIntArray94[0] = 62747;
			entityDef.anIntArray94[1] = 62734;
			entityDef.anIntArray70 = new int[10];
			entityDef.anIntArray76 = new int[10];
			entityDef.anIntArray76[0] = 33893;
			entityDef.anIntArray70[0] = 50360;
			entityDef.anIntArray76[1] = 34853;
			entityDef.anIntArray70[1] = 48550;
			entityDef.anIntArray76[2] = 35214;
			entityDef.anIntArray70[2] = 15;
			entityDef.anIntArray76[3] = 32882;
			entityDef.anIntArray70[3] = 48540;
			entityDef.anIntArray76[4] = 32832;
			entityDef.anIntArray70[4] = 48540;
			entityDef.anIntArray76[5] = 35461;
			entityDef.anIntArray70[5] = 10;
			entityDef.anIntArray76[6] = 35216;
			entityDef.anIntArray70[6] = 4506;
			entityDef.anIntArray76[7] = 30885;
			entityDef.anIntArray70[7] = 48550;
			entityDef.anIntArray76[8] = 34568;
			entityDef.anIntArray70[8] = 50074;
			entityDef.anIntArray76[9] = 34454;
			entityDef.anIntArray70[9] = 48550;
			entityDef.aByte68 = 1;
			entityDef.anInt91 = 130;
			entityDef.anInt86 = 130;
			entityDef.standAnim = 808;// stand animation
			entityDef.walkAnim = 819;// walk animation
			entityDef.name = "Umbra";
			entityDef.combatLevel = 285;
		}
		if (i == 2636) {
			entityDef.anIntArray94 = new int[1];
			entityDef.anIntArray94[0] = 62717;
			entityDef.name = "Nex";
			entityDef.aByte68 = 3;
			entityDef.itemActions = new String[5];
			entityDef.itemActions[1] = "Attack";
			entityDef.aBoolean87 = true;
			entityDef.combatLevel = 1001;
			entityDef.aBoolean93 = true;
			entityDef.anInt85 = 10;
			entityDef.anInt92 = 50;
			entityDef.anInt75 = 15;
			entityDef.anInt79 = 32;
			entityDef.aBoolean84 = true;
		}
		if (i == 1167) {
			entityDef.itemActions[2] = "Trade";
			entityDef.itemActions[3] = "Buy Skillcape";
		}
		if (i == 553) {
			entityDef.itemActions[2] = "Trade";
			entityDef.itemActions[3] = "Buy Skillcape";
		}
		if (i == 7143) {
			entityDef.name = "FireMaker";
			entityDef.itemActions[2] = "Trade";
			entityDef.itemActions[3] = "Buy Skillcape";
		}
		if (i == 794) {
			entityDef.itemActions[2] = "Trade";
			entityDef.itemActions[3] = "Buy Skillcape";
		}
		if (i == 219) {
			entityDef.itemActions[2] = "Trade";
			entityDef.itemActions[3] = "Buy Skillcape";
		}
		if (i == 3920) {
			entityDef.name = "Fletcher";
			entityDef.itemActions[3] = "Buy Skillcape";
		}
		if (i == 1911) {
			entityDef.name = "Phoenix";
			entityDef.itemActions[1] = "Interact";
		}
		if (i == 4295) {
			entityDef.name = "Thief";
			entityDef.itemActions[2] = "Trade";
			entityDef.itemActions[3] = "Buy Skillcape";
		}
		if (i == 455) {
			entityDef.itemActions[2] = "Trade";
			entityDef.itemActions[3] = "Buy Skillcape";
		}
		if (i == 9085) {
			entityDef.itemActions[3] = "FrostDrags";
		}
		if (i == 3299) {
			entityDef.name = "Farmer";
			entityDef.itemActions[2] = "Trade";
			entityDef.itemActions[3] = "Buy Skillcape";
		}
		if (i == 4906) {
			entityDef.name = "Woodcutter";
			entityDef.itemActions[2] = "Trade";
			entityDef.itemActions[3] = "Buy Skillcape";
		}
		if (i == 569) {
			entityDef.name = "Crafter";
			entityDef.itemActions[3] = "Buy Skillcape";
		}
		if (i == 33) {
			entityDef.name = "Bank server";
			entityDef.combatLevel = 9000;
		}
		if (i == 1225) {
			entityDef.name = "Bryan the Vampire";
			entityDef.combatLevel = 341;
		}
		if (i == 3109) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[1] = "Attack";
			entityDef.name = "I don't remember my name";
			entityDef.combatLevel = 389;
		}
		if (i == 4477) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[1] = "Attack";
			entityDef.name = "Barebones";
			entityDef.combatLevel = 941;
		}
		if (i == 879) {
			entityDef.name = "Pim the Delrith";
			entityDef.combatLevel = 341;
		}
		if (i == 2134) {
			entityDef.name = "Terrance the Rage";
			entityDef.combatLevel = 119;
		}
		if (i == 2579) {
			entityDef.name = "Mandrith";
			entityDef.aByte68 = 1;
			entityDef.standAnim = 2715;
			entityDef.walkAnim = 2715;
			entityDef.itemActions = new String[5];
			entityDef.itemActions[0] = "Sell Artifacts";
			entityDef.combatLevel = 0;
			entityDef.anInt91 = 130;
			entityDef.anInt86 = 130;
			entityDef.anIntArray94 = new int[1];
			entityDef.anIntArray94[0] = 30182;
		}
		if (i == 2577) {
			entityDef.name = "Harry";
			entityDef.aByte68 = 1;
			entityDef.combatLevel = 0;
			entityDef.anInt91 = 130;
			entityDef.walkAnim = 819;
			entityDef.anInt86 = 180;
			entityDef.standAnim = 2715;
			entityDef.walkAnim = 2715;
			entityDef.anIntArray94 = new int[1];
			entityDef.anIntArray94[0] = 29909;
		}
		if (i == 2578) {
			entityDef.name = "Nastroth";
			entityDef.aByte68 = 1;
			entityDef.combatLevel = 0;
			entityDef.anInt91 = 130;
			entityDef.anInt86 = 130;
			entityDef.standAnim = 2715;
			entityDef.walkAnim = 2715;
			entityDef.itemActions = new String[5];
			entityDef.itemActions[0] = "Open SSP Shop";
			entityDef.anIntArray94 = new int[1];
			entityDef.anIntArray94[0] = 40058;
		}
		if (i == 2580) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[1] = "Attack";
			entityDef.name = "Lucien";
			entityDef.aByte68 = 4;
			entityDef.combatLevel = 0;
			entityDef.anInt91 = 130;
			entityDef.anInt86 = 130;
			entityDef.walkAnim = 10764;
			entityDef.standAnim = 10763;
			entityDef.anIntArray94 = new int[1];
			entityDef.anIntArray94[0] = 44701;
		}
		if (i == 5247) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[1] = "Attack";
			entityDef.anIntArray94 = new int[1];
			entityDef.anIntArray94[0] = 40955;
			entityDef.standAnim = 10056;
			entityDef.walkAnim = 10055;
			entityDef.name = "Corporeal Beast";
			entityDef.combatLevel = 785;
			entityDef.description = "A vision of supernatural horror."
					.getBytes();
		}
		if (i == 3592) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[2] = "Special Move";
			entityDef.aBoolean87 = false;
			entityDef.anIntArray94 = new int[1];
			entityDef.anIntArray94[0] = 31101;
			entityDef.standAnim = 6374;
			entityDef.walkAnim = 6373;
			entityDef.name = "Unicorn Stallion";
			entityDef.combatLevel = 70;
			entityDef.description = "A summoning monster.".getBytes();
		}
		if (i == 1282) {
			entityDef.name = "Summoning Master";
			entityDef.itemActions[2] = "Refill-BoB";
			entityDef.itemActions[3] = "Open Pouch Shop";
		}
		if (i == 243) {
			entityDef.name = "Dungeoneering Master";
			entityDef.itemActions[2] = "Start Dungeoneering";
			entityDef.itemActions[3] = "Open Token Shop";
		}
		if (i == 3591) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[2] = "Special Move";
			entityDef.aBoolean87 = false;
			entityDef.anIntArray94 = new int[1];
			entityDef.anIntArray94[0] = 30469;
			entityDef.standAnim = 8186;
			entityDef.walkAnim = 8189;
			entityDef.name = "Steel Titan";
			entityDef.combatLevel = 175;
			entityDef.description = "A summoning monster.".getBytes();
		}
		if (i == 3587) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[1] = "Take BoB";
			entityDef.itemActions[2] = "Store";
			entityDef.aBoolean87 = false;
			entityDef.anIntArray94 = new int[1];
			entityDef.anIntArray94[0] = 30460;
			entityDef.standAnim = 8284;
			entityDef.walkAnim = 8281;
			entityDef.name = "War tortoise";
			entityDef.anInt91 = 129;
			entityDef.anInt86 = 129;
			entityDef.combatLevel = 86;
			entityDef.description = "A summoning monster.".getBytes();
		}
		if (i == 3588) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[2] = "Teleport";
			entityDef.aBoolean87 = false;
			entityDef.anIntArray94 = new int[1];
			entityDef.anIntArray94[0] = 31132;
			entityDef.standAnim = 5225;
			entityDef.walkAnim = 5226;
			entityDef.name = "Spirit Ghraak";
			entityDef.anInt91 = 129;
			entityDef.anInt86 = 129;
			entityDef.combatLevel = 51;
			entityDef.description = "A summoning monster.".getBytes();
		}
		if (i == 3593) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[2] = "Special move";
			entityDef.anInt91 = 129;
			entityDef.anInt86 = 129;
			entityDef.anIntArray94 = new int[1];
			entityDef.anIntArray94[0] = 30475;
			entityDef.standAnim = 8301;
			entityDef.walkAnim = 8302;
			entityDef.aBoolean87 = false;
			entityDef.name = "Wolpertinger";
			entityDef.combatLevel = 51;
			entityDef.description = "A summoning monster.".getBytes();
		}
		if (i == 3590) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[2] = "Take-Supplies";
			entityDef.aBoolean87 = false;
			entityDef.anIntArray94 = new int[1];
			entityDef.anIntArray94[0] = 30460;
			entityDef.standAnim = 8284;
			entityDef.walkAnim = 8281;
			entityDef.name = "War tortoise";
			entityDef.anInt91 = 129;
			entityDef.anInt86 = 129;
			entityDef.combatLevel = 86;
			entityDef.description = "A summoning monster.".getBytes();
		}
		if (i == 3586) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[1] = "Take BoB";
			entityDef.itemActions[2] = "Store";
			entityDef.aBoolean87 = false;
			entityDef.anIntArray94 = new int[1];
			entityDef.anIntArray94[0] = 31096;
			entityDef.standAnim = 1008;
			entityDef.walkAnim = 1007;
			entityDef.anInt91 = 129;
			entityDef.anInt86 = 129;
			entityDef.name = "Spirit terrorbird";
			entityDef.combatLevel = 62;
			entityDef.description = "A Bank That Follows You.".getBytes();
		}
		if (i == 3596) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[2] = "Take-Supplies";
			entityDef.aBoolean87 = false;
			entityDef.anIntArray94 = new int[1];
			entityDef.anIntArray94[0] = 31096;
			entityDef.standAnim = 1008;
			entityDef.walkAnim = 1007;
			entityDef.anInt91 = 129;
			entityDef.anInt86 = 129;
			entityDef.name = "Spirit terrorbird";
			entityDef.combatLevel = 62;
			entityDef.description = "A Bank That Follows You.".getBytes();
		}
		if (i == 3594) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[2] = "Take-Supplies";
			entityDef.aBoolean87 = false;
			entityDef.anIntArray94 = new int[1];
			entityDef.anIntArray94[0] = 23892;
			entityDef.standAnim = 5785;
			entityDef.walkAnim = 5781;
			entityDef.name = "Pack-yak";
			entityDef.combatLevel = 175;
			entityDef.description = "Summoning Bank.".getBytes();
		}
		if (i == 3595) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[1] = "Take BoB";
			entityDef.itemActions[2] = "Store";
			entityDef.aBoolean87 = false;
			entityDef.anIntArray94 = new int[1];
			entityDef.anIntArray94[0] = 23892;
			entityDef.standAnim = 5785;
			entityDef.walkAnim = 5781;
			entityDef.name = "Pack-yak";
			entityDef.combatLevel = 175;
			entityDef.description = "Summoning Bank.".getBytes();
		}
		if (i == 1155) {
			entityDef.itemActions = new String[5];
			entityDef.itemActions[1] = "Attack";
			entityDef.name = "Tormented Demon";
			entityDef.combatLevel = 450;
			entityDef.anIntArray94 = new int[1];
			entityDef.standAnim = 10921;
			entityDef.walkAnim = 10920;
			entityDef.anIntArray94[0] = 44733;
			entityDef.description = "Dangerous shit bro...".getBytes();
		}
		return entityDef;
	}

	/*
	 * private static int getCorrectColours(int i){ String s =
	 * Integer.toHexString(i).toUpperCase(); String str; if(s.length() > 4) str
	 * = s.substring(4); else str = s; int i2 = Integer.parseInt(str, 16);
	 * return i2; }
	 */

	public static void nullLoader() {
		mruNodes = null;
		streamIndices = null;
		cache = null;
		stream = null;
	}

	public static void unpackConfig(StreamLoader streamLoader) {
		stream = new Stream(streamLoader.getDataForName("npc.dat"));
		Stream stream2 = new Stream(streamLoader.getDataForName("npc.idx"));
		int totalNPCs = stream2.readUnsignedWord();
		System.out.println((new StringBuilder()).append("602 NPC Amount: ")
				.append(totalNPCs).toString());
		streamIndices = new int[totalNPCs];
		int i = 2;
		for (int j = 0; j < totalNPCs; j++) {
			streamIndices[j] = i;
			i += stream2.readUnsignedWord();
		}
		cache = new EntityDef[20];
		for (int k = 0; k < 20; k++) {
			cache[k] = new EntityDef();
		}
	}

	public int anInt55;

	public int anInt57;

	public int anInt58;
	public int anInt59;
	public static Stream stream;
	public int combatLevel;
	public final int anInt64 = 1834;
	public String name;
	public String itemActions[];
	public int walkAnim;
	public byte aByte68;
	public int anIntArray70[];
	public int anIntArray73[];
	public int anInt75;
	public int anIntArray76[];
	public int standAnim;
	public long type;
	public int anInt79;
	public static EntityDef cache[];
	public static client clientInstance;
	public int anInt83;
	public boolean aBoolean84;
	public int anInt85;
	public int anInt86;
	public boolean aBoolean87;
	public int childrenIDs[];
	public byte description[];
	public int anInt91;
	public int anInt92;
	public boolean aBoolean93;
	public int anIntArray94[];
	public static MRUNodes mruNodes = new MRUNodes(30);

	public EntityDef() {
		anInt55 = -1;
		anInt57 = -1;
		anInt58 = -1;
		anInt59 = -1;
		combatLevel = -1;
		walkAnim = -1;
		aByte68 = 1;
		anInt75 = -1;
		standAnim = -1;
		type = -1L;
		anInt79 = 32;
		anInt83 = -1;
		aBoolean84 = true;
		anInt86 = 128;
		aBoolean87 = true;
		anInt91 = 128;
		aBoolean93 = false;
	}

	public Model method160() {
		if (childrenIDs != null) {
			EntityDef entityDef = method161();
			if (entityDef == null) {
				return null;
			} else {
				return entityDef.method160();
			}
		}
		if (anIntArray73 == null) {
			return null;
		}
		boolean flag1 = false;
		for (int i = 0; i < anIntArray73.length; i++) {
			if (!Model.method463(anIntArray73[i])) {
				flag1 = true;
			}
		}

		if (flag1) {
			return null;
		}
		Model aclass30_sub2_sub4_sub6s[] = new Model[anIntArray73.length];
		for (int j = 0; j < anIntArray73.length; j++) {
			aclass30_sub2_sub4_sub6s[j] = Model.method462(anIntArray73[j]);
		}
		Model model;
		if (aclass30_sub2_sub4_sub6s.length == 1) {
			model = aclass30_sub2_sub4_sub6s[0];
		} else {
			model = new Model(aclass30_sub2_sub4_sub6s.length,
					aclass30_sub2_sub4_sub6s);
		}
		if (anIntArray76 != null) {
			for (int k = 0; k < anIntArray76.length; k++) {
				model.method476(anIntArray76[k], anIntArray70[k]);
			}
		}
		return model;
	}

	public EntityDef method161() {
		int j;
		try {
			j = -1;
			if (anInt57 != -1) {
				VarBit varBit = VarBit.cache[anInt57];
				int k = varBit.anInt648;
				int l = varBit.anInt649;
				int i1 = varBit.anInt650;
				int j1 = client.anIntArray1232[i1 - l];
				j = clientInstance.variousSettings[k] >> l & j1;
			} else if (anInt59 != -1) {
				j = clientInstance.variousSettings[anInt59];
			}
			if (j < 0 || j >= childrenIDs.length || childrenIDs[j] == -1) {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
		return forID(childrenIDs[j]);
	}

	public Model method164(int j, int k, int ai[]) {
		if (childrenIDs != null) {
			EntityDef entityDef = method161();
			if (entityDef == null) {
				return null;
			} else {
				return entityDef.method164(j, k, ai);
			}
		}
		Model model = (Model) mruNodes.insertFromCache(type);
		if (model == null) {
			boolean flag = false;
			for (int i1 = 0; i1 < anIntArray94.length; i1++) {
				if (!Model.method463(anIntArray94[i1])) {
					flag = true;
				}
			}

			if (flag) {
				return null;
			}
			Model aclass30_sub2_sub4_sub6s[] = new Model[anIntArray94.length];
			for (int j1 = 0; j1 < anIntArray94.length; j1++) {
				aclass30_sub2_sub4_sub6s[j1] = Model
						.method462(anIntArray94[j1]);
			}

			if (aclass30_sub2_sub4_sub6s.length == 1) {
				model = aclass30_sub2_sub4_sub6s[0];
			} else {
				model = new Model(aclass30_sub2_sub4_sub6s.length,
						aclass30_sub2_sub4_sub6s);
			}
			if (anIntArray76 != null) {
				for (int k1 = 0; k1 < anIntArray76.length; k1++) {
					model.method476(anIntArray76[k1], anIntArray70[k1]);
				}
			}
			model.method469();
			model.method479(64 + anInt85, 850 + anInt92, -30, -50, -30, true);
			mruNodes.removeFromCache(model, type);
		}
		Model model_1 = Model.aModel_1621;
		model_1.method464(model, Class36.method532(k) & Class36.method532(j));
		if (k != -1 && j != -1) {
			model_1.method471(ai, j, k);
		} else if (k != -1) {
			model_1.method470(k);
		}
		if (anInt91 != 128 || anInt86 != 128) {
			model_1.method478(anInt91, anInt91, anInt86);
		}
		model_1.method466();
		model_1.anIntArrayArray1658 = null;
		model_1.anIntArrayArray1657 = null;
		if (aByte68 == 1) {
			model_1.aBoolean1659 = true;
		}
		return model_1;
	}

	public void readValues(Stream stream) {
		do {
			int i = stream.readUnsignedByte();
			if (i == 0) {
				return;
			}
			if (i == 1) {
				int j = stream.readUnsignedByte();
				anIntArray94 = new int[j];
				int j1 = 0;
				while (j1 < j) {
					anIntArray94[j1] = stream.readUnsignedWord();
					if (type == 55L) {
						System.out.println(anIntArray94[j1]);
					}
					j1++;
				}
			} else if (i == 2) {
				name = stream.readString();
			} else if (i == 3) {
				description = stream.readBytes();
			} else if (i == 12) {
				aByte68 = stream.readSignedByte();
			} else if (i == 13) {
				standAnim = stream.readUnsignedWord();
			} else if (i == 14) {
				walkAnim = stream.readUnsignedWord();
			} else if (i == 17) {
				walkAnim = stream.readUnsignedWord();
				anInt58 = stream.readUnsignedWord();
				anInt83 = stream.readUnsignedWord();
				anInt55 = stream.readUnsignedWord();
				if (walkAnim == 65535) {
					walkAnim = -1;
				}
				if (anInt58 == 65535) {
					anInt58 = -1;
				}
				if (anInt83 == 65535) {
					anInt83 = -1;
				}
				if (anInt55 == 65535) {
					anInt55 = -1;
				}
			} else if (i >= 30 && i < 40) {
				if (itemActions == null) {
					itemActions = new String[5];
				}
				itemActions[i - 30] = stream.readString();
				if (itemActions[i - 30].equalsIgnoreCase("hidden")) {
					itemActions[i - 30] = null;
				}
			} else if (i == 40) {
				int k = stream.readUnsignedByte();
				anIntArray70 = new int[k];
				anIntArray76 = new int[k];
				int k1 = 0;
				while (k1 < k) {
					anIntArray76[k1] = stream.readUnsignedWord();
					anIntArray70[k1] = stream.readUnsignedWord();
					k1++;
				}
			} else if (i == 60) {
				int l = stream.readUnsignedByte();
				anIntArray73 = new int[l];
				int l1 = 0;
				while (l1 < l) {
					anIntArray73[l1] = stream.readUnsignedWord();
					l1++;
				}
			} else if (i == 90) {
				stream.readUnsignedWord();
			} else if (i == 91) {
				stream.readUnsignedWord();
			} else if (i == 92) {
				stream.readUnsignedWord();
			} else if (i == 93) {
				aBoolean87 = false;
			} else if (i == 95) {
				combatLevel = stream.readUnsignedWord();
			} else if (i == 97) {
				anInt91 = stream.readUnsignedWord();
			} else if (i == 98) {
				anInt86 = stream.readUnsignedWord();
			} else if (i == 99) {
				aBoolean93 = true;
			} else if (i == 100) {
				anInt85 = stream.readSignedByte();
			} else if (i == 101) {
				anInt92 = stream.readSignedByte() * 5;
			} else if (i == 102) {
				anInt75 = stream.readUnsignedWord();
			} else if (i == 103) {
				anInt79 = stream.readUnsignedWord();
			} else if (i == 106) {
				anInt57 = stream.readUnsignedWord();
				if (anInt57 == 65535) {
					anInt57 = -1;
				}
				anInt59 = stream.readUnsignedWord();
				if (anInt59 == 65535) {
					anInt59 = -1;
				}
				int i1 = stream.readUnsignedByte();
				childrenIDs = new int[i1 + 1];
				int i2 = 0;
				while (i2 <= i1) {
					childrenIDs[i2] = stream.readUnsignedWord();
					if (childrenIDs[i2] == 65535) {
						childrenIDs[i2] = -1;
					}
					i2++;
				}
			} else if (i == 107) {
				aBoolean84 = false;
			}
		} while (true);
	}

}
