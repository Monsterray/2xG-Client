import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

final class RSImageProducer implements ImageProducer, ImageObserver {

	public final int imageArea[];

	private final int thisWidth;

	private final int thisHeight;

	private final ColorModel aColorModel318 = new DirectColorModel(32,
			0xff0000, 65280, 255);

	private ImageConsumer anImageConsumer319;

	private final Image thisComponent;

	public RSImageProducer(int Width, int Height, Component component) {
		// System.out.println("Creating a RSImageProducer");
		thisWidth = Width;
		thisHeight = Height;
		imageArea = new int[Width * Height];
		thisComponent = component.createImage(this);
		method239();
		component.prepareImage(thisComponent, this);
		initDrawingArea();
	}

	@Override
	public synchronized void addConsumer(ImageConsumer imageconsumer) {
		anImageConsumer319 = imageconsumer;
		imageconsumer.setDimensions(thisWidth, thisHeight);
		imageconsumer.setProperties(null);
		imageconsumer.setColorModel(aColorModel318);
		imageconsumer.setHints(14);
	}

	public void drawGraphics(int i, Graphics g, int k) {
		method239();
		g.drawImage(thisComponent, k, i, this);
	}

	@Override
	public boolean imageUpdate(Image image, int i, int j, int j1, int k1, int l1) {
		return true;
	}

	public void initDrawingArea() {
		DrawingArea.initDrawingArea(thisHeight, thisWidth, imageArea);
	}

	@Override
	public synchronized boolean isConsumer(ImageConsumer imageconsumer) {
		return anImageConsumer319 == imageconsumer;
	}

	private synchronized void method239() {
		if (anImageConsumer319 != null) {
			anImageConsumer319.setPixels(0, 0, thisWidth, thisHeight,
					aColorModel318, imageArea, 0, thisWidth);
			anImageConsumer319.imageComplete(2);
		}
	}

	@Override
	public synchronized void removeConsumer(ImageConsumer imageconsumer) {
		if (anImageConsumer319 == imageconsumer) {
			anImageConsumer319 = null;
		}
	}

	@Override
	public void requestTopDownLeftRightResend(ImageConsumer imageconsumer) {
		System.out.println("TDLR");
	}

	@Override
	public void startProduction(ImageConsumer imageconsumer) {
		addConsumer(imageconsumer);
	}
}
