package internal;

import de.uniulm.omi.cloudiator.colosseum.client.Client;
import de.uniulm.omi.cloudiator.colosseum.client.ClientBuilder;

/**
 * Created by daniel on 31.05.16.
 */
public class ClientProvider {

    public static Client get() {
        return ClientBuilder.getNew().url("http://localhost:9000/api")
            .credentials("john.doe@example.com", "admin", "admin").build();
    }

}
