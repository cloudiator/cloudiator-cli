package internal;

import java.util.Set;

/**
 * Created by daniel on 15.03.16.
 */
public interface Action {

    String name();

    Set<Argument> arguments();

    void run(Set<ArgumentValue> values);

}
