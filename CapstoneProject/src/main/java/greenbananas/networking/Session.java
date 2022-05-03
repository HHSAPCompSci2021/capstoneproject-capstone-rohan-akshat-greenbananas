package greenbananas.networking;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import greenbananas.game.GameContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * Represents a game session between the computer and the client.
 * Firebase Realtime Database is used for synchronization.
 * Each session has a unique sessionId, and an entry in Firebase Realtime Database (RTDB)
 */
public class Session {

    private final FirebaseDatabase db;
    private String sessionId;
    private boolean sessionIsCreated;
    private boolean isSessionClosed = false;

    /**
     * Initializes Firebase with credentials in assets/firebase.json
     * @throws IOException if credential file is not found and/or cannot be opened
     */
    private void initFirebase() throws IOException {
        FileInputStream credentials = new FileInputStream("assets/firebase.json");
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(credentials))
                .setDatabaseUrl("https://balance-it-hhs-default-rtdb.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
    }

    /**
     * Generates and opens a new session. A {@link GameSessionListener} is also attached to the session.
     *
     * @throws IOException if firebase cannot be initialized
     */
    private Session() throws IOException {
        initFirebase();
        db = FirebaseDatabase.getInstance();
        generateSession();
    }

    public static void createSession() throws IOException {
        Session s = new Session();
        GameContext.getInstance().setSession(s);
    }

    /**
     * Creates a new session.
     */
    private void generateSession() {
        sessionId = UUID.randomUUID().toString().replace("-", "");
        DatabaseReference sessionRef = db.getReference("/sessions/" + sessionId);
        sessionRef.setValue(SessionSnapshot.getEmptySnapshot(), ((error, ref) -> {
            sessionIsCreated = true;
            ref.addValueEventListener(new GameSessionListener());
        }));
    }

    /**
     * Closes the currentSession and deletes the entry in the RTDB
     */
    public void closeSession() {
        DatabaseReference sessionRef = db.getReference("/sessions/" + sessionId);
        sessionRef.removeValue((error, ref) -> {
        	isSessionClosed = true;
            System.out.println("deleted session");
        }
        );
    }

    /**
     * Returns the id of the current session
     * @return The id of the current session
     */
    public String getSessionId() {
        return sessionId;
    }
    
    public boolean hasSessionClosed() {
    	return isSessionClosed;
    }

}
