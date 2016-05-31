import internal.Action;
import internal.Actions;

import java.util.Collections;

/**
 * Created by daniel on 31.05.16.
 */
public class App {

    public static void main(String[] args) {

        if (args.length == 0) {
            throw new IllegalArgumentException("No action name supplied.");
        }
        final String actionName = args[0];
        Action action = Actions.loadAction(actionName);
        action.run(Collections.emptySet());

    }

}
