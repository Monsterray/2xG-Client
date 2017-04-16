final class MouseDetection implements Runnable {

	private client clientInstance;

	public final Object syncObject = new Object();

	public final int coordsY[] = new int[500];
	public boolean running;
	public final int coordsX[] = new int[500];
	public int coordsIndex;

	public MouseDetection(client client1) {
		running = true;
		clientInstance = client1;
	}

	@Override
	public void run() {
		while (running) {
			synchronized (syncObject) {
				if (coordsIndex < 500) {
					coordsX[coordsIndex] = clientInstance.mouseX;
					coordsY[coordsIndex] = clientInstance.mouseY;
					coordsIndex++;
				}
			}
			try {
				Thread.sleep(50L);
			} catch (Exception e) {

			}
		}
	}
}
