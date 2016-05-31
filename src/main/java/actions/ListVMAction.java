package actions;

import de.uniulm.omi.cloudiator.colosseum.client.Client;
import de.uniulm.omi.cloudiator.colosseum.client.entities.VirtualMachine;
import internal.Action;
import internal.Argument;
import internal.ClientProvider;
import internal.ArgumentValue;

import java.util.Collections;
import java.util.Set;

/**
 * Created by daniel on 31.05.16.
 */
public class ListVMAction implements Action {

    private final Client client;

    public ListVMAction() {
        this.client = ClientProvider.get();
    }

    @Override public String name() {
        return "listVMs";
    }

    @Override public Set<Argument> arguments() {
        return Collections.emptySet();
    }

    @Override public void run(Set<ArgumentValue> values) {
        client.controller(VirtualMachine.class).getList().forEach(System.out::println);
    }
}
