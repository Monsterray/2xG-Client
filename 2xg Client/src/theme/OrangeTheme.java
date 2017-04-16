package theme;

import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.OceanTheme;

public class OrangeTheme extends OceanTheme {
	private final ColorUIResource primary1 = new ColorUIResource(153, 102, 51);
	private final ColorUIResource primary2 = new ColorUIResource(255, 204, 153);
	private final ColorUIResource primary3 = new ColorUIResource(255, 204, 153);
	private final ColorUIResource secondary1 = new ColorUIResource(255, 191,
			128);
	private final ColorUIResource secondary2 = new ColorUIResource(235, 195,
			140);
	private final ColorUIResource secondary3 = new ColorUIResource(255, 245,
			225);
	private final ColorUIResource black = new ColorUIResource(0, 0, 0);
	private final ColorUIResource white = new ColorUIResource(255, 255, 255);

	@Override
	protected ColorUIResource getBlack() {
		return this.black;
	}

	@Override
	public String getName() {
		return "Orange";
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