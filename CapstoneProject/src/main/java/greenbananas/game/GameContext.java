package greenbananas.game;

import greenbananas.networking.Session;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

import java.io.File;

/**
 * Represents the current state of the game
 */
public class GameContext {
    private boolean isConnected;
    private int deviceOrientation;
    private String qrcode;
    private Session gameSession;
    private static GameContext instance;

    private GameContext() {}

    public static GameContext getInstance() {
        if(instance == null) {
            instance = new GameContext();
        }
        return instance;
    }

    /**
     * Returns true if the client has connected to the current session
     * @return If the client has connected to the current session
     */
    public boolean isConnected() {
        return isConnected;
    }

    /**
     * Returns the most recent device orientation data
     * @return The most recent device orientation data
     */
    public int getDeviceOrientation() {
        return deviceOrientation;
    }

    /**
     * Sets the current client connection state
     * @param isConnected The current client connection state
     */
    public void setIsConnected(boolean isConnected) {
        this.isConnected = isConnected;
    }

    /**
     * Updates the orientation with new data
     * @param orientation The new data
     */
    public void updateOrientation(int orientation) {
        deviceOrientation = orientation;
    }

    /**
     * Sets the current game session. This also generates a QRCode to the session url
     * @param session The current game session
     */
    public void setSession(Session session) {
        gameSession = session;
        File qrcodeFile = QRCode.from(getConnectionURL()).to(ImageType.PNG).withSize(500,500).file("qrcode");
        qrcode =  qrcodeFile.getAbsolutePath();
    }

    /**
     * Returns the URL the client should use to connect to the current session
     * @return The URL the client should use to connect to the current session
     */
    public String getConnectionURL() {
        return String.format("https://bit.aksads.tech/?session=%s", gameSession.getSessionId());
	// return String.format("https://10.0.0.129:3000/?session=%s", gameSession.getSessionId());
    }

    /**
     * Returns the QR code the client should use to connect to the current session
     * @return The QR code the client should use to connect to the current session
     */
    public String getQrcode() {
        return qrcode;
    }

    /**
     * Returns the current game session
     * @return The current game session
     */
    public Session getSession() {
        return gameSession;
    }
}
