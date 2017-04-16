package theme;

import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.OceanTheme;

public class BlackWTheme extends OceanTheme {
	private final ColorUIResource primary1 = new ColorUIResource(33, 33, 33);
	private final ColorUIResource primary2 = new ColorUIResource(160, 160, 160);
	private final ColorUIResource primary3 = new ColorUIResource(77, 77, 77);
	private final ColorUIResource secondary1 = new ColorUIResource(0, 0, 0);
	private final ColorUIResource secondary2 = new ColorUIResource(0, 0, 0);
	private final ColorUIResource secondary3 = new ColorUIResource(100, 100,
			100);
	private final ColorUIResource black = new ColorUIResource(20, 20, 20);
	private final ColorUIResource white = new ColorUIResource(0, 0, 0);

	@Override
	protected ColorUIResource getBlack() {
		return this.black;
	}

	@Override
	public String getName() {
		return "Black";
	}

	@Override
	protected ColorUIResource getPrimary1() {
		return this.primary1;
	}

	@Override
	protected ColorUIResource getPrimary2() {
		return this.primary2;
	}

	@Override
	protected ColorUIResource getPrimary3() {
		return this.primary3;
	}

	@Override
	protected ColorUIResource getSecondary1() {
		return this.secondary1;
	}

	@Override
	protected ColorUIResource getSecondary2() {
		return this.secondary2;
	}

	@Override
	protected ColorUIResource getSecondary3() {
		return this.secondary3;
	}

	@Override
	protected ColorUIResource getWhite() {
		return this.white;
	}

}