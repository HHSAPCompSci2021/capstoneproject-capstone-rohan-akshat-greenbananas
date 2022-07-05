package greenbananas.networking;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import greenbananas.game.GameContext;

/**
 * Listens to the current session and updates the {@link GameContext} with new data
 */
public class GameSessionListener implements ValueEventListener {

    private final GameContext context;

    /**
     * Constructs a new GameSessionListener object
     */
    public GameSessionListener() {
        context = GameContext.getInstance();
    }

    @Override
    public void onDataChange(DataSnapshot snapshot) {
        SessionSnapshot s =  snapshot.getValue(SessionSnapshot.class);

        context.setIsConnected(s.isClientConnected);
        context.updateOrientation(s.orientation);
    }

    @Override
    public void onCancelled(DatabaseError error) {
        context.setIsConnected(false);
        context.getSession().closeSession();
    }
}
