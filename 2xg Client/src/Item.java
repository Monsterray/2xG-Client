// Decompiler options: packimports(3) 
// Source File Name:   Item.java

final class Item extends Animable {

	public int ID;

	public int x;

	public int y;
	public int anInt1559;

	public Item() {
	}

	@Override
	public final Model getRotatedModel() {
		ItemDef itemDef = ItemDef.forID(ID);
		return itemDef.method201(anInt1559);
	}
}
