package internal;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by daniel on 31.05.16.
 */
public class Actions {

    private static Map<String, Action> actions;

    private Actions() {
        throw new AssertionError("intentionally left empty.");
    }

    static {
        Reflections reflections = new Reflections();
        final Set<Class<? extends Action>> subTypesOf = reflections.getSubTypesOf(Action.class);
        actions = new HashMap<>(subTypesOf.size());
        for (Class<? extends Action> clazz : subTypesOf) {
            try {
                Action instance = clazz.newInstance();
                actions.put(instance.name(), instance);
            } catch (InstantiationException | IllegalAccessException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public static Action loadAction(String name) {
        if (!actions.containsKey(name)) {
            // todo replace with better exception
            throw new IllegalArgumentException("Action does not exist");
        }
        return actions.get(name);
    }


}
