package greenbananas.networking;

/**
 * Represents a snapshot of data passed between the client and the app
 */
public class SessionSnapshot {
    /**
     * Orientation data
     */
    public int orientation;
//    public int alpha, beta, gamma;
    /**
     * Is the client connected?
     */
    public boolean isClientConnected;

    /**
     * Returns a string interpretation of the SessionSnapshot
     * @return A string interpretation of the SessionSnapshot
     */
    public String toString() {
        return String.format("{Alpha: %d, isClientConnected: %s}", orientation, isClientConnected);
    }

    /**
     * Returns a 'null' snapshot used to initialize the connection between the client and app
     * @return A'null' snapshot used to initialize the connection between the client and app
     */
    public static SessionSnapshot getEmptySnapshot() {
        SessionSnapshot snapshot = new SessionSnapshot();
//        snapshot.alpha = -1;
//        snapshot.beta = -1;
//        snapshot.gamma = -1;
        snapshot.orientation = -1;
        snapshot.isClientConnected = false;
        return snapshot;
    }
}
