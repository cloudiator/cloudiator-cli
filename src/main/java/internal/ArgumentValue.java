package internal;

import java.util.Optional;

/**
 * Created by daniel on 15.03.16.
 */
public interface ArgumentValue {

    Argument argument();

    Optional<String> value();

}
