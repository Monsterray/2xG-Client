package theme;

import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.OceanTheme;

public class GreenTheme extends OceanTheme {
	private final ColorUIResource primary1 = new ColorUIResource(51, 102, 51);
	private final ColorUIResource primary2 = new ColorUIResource(102, 153, 102);
	private final ColorUIResource primary3 = new ColorUIResource(153, 204, 153);
	private final ColorUIResource secondary1 = new ColorUIResource(30, 190, 30);
	private final ColorUIResource secondary2 = new ColorUIResource(120, 120,
			120);
	private final ColorUIResource secondary3 = new ColorUIResource(238, 255,
			238);

	@Override
	public String getName() {
		return "Green";
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

}