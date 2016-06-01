package io.github.cloudiator.colosseum.cli.commands;

import de.uniulm.omi.cloudiator.colosseum.client.entities.IpAddress;
import de.uniulm.omi.cloudiator.colosseum.client.entities.VirtualMachine;
import io.github.cloudiator.colosseum.cli.formatting.ColumnBuilder;
import io.github.cloudiator.colosseum.cli.formatting.RowBuilder;
import io.github.cloudiator.colosseum.cli.formatting.TableBuilder;
import io.github.cloudiator.colosseum.cli.internal.ClientProvider;
import org.apache.commons.lang3.StringUtils;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by daniel on 01.06.16.
 */
@Component public class VirtualMachineCommands implements CommandMarker {

    @CliCommand(value = "vm list", help = "Lists all available virtual machines.")
    public String list() {

        final List<VirtualMachine> vms =
            ClientProvider.get().controller(VirtualMachine.class).getList();
        final List<IpAddress> publicIps = ClientProvider.get().controller(IpAddress.class)
            .getList(ip -> "PUBLIC".equals(ip.getIpType()));

        ColumnBuilder columnBuilder = new TableBuilder();
        final RowBuilder rows =
            columnBuilder.addColumn("id").addColumn("name").addColumn("provider id")
                .addColumn("public ips").rows();
        for (VirtualMachine virtualMachine : vms) {
            rows.addRow(String.valueOf(virtualMachine.getId()), virtualMachine.getName(),
                virtualMachine.getProviderId(), StringUtils.join(publicIps.stream().filter(
                    ipAddress -> ipAddress.getVirtualMachine().equals(virtualMachine.getId()))
                    .map(IpAddress::getIp).collect(Collectors.toList()), ","));
        }
        return rows.toString();
    }

    @CliCommand(value = "vm show", help = "Displays a specific virtual machine.")
    public String show(
        @CliOption(key = {"id"}, mandatory = true, help = "The id of the virtual machine.")
        final String id) {

        return id;
    }

}
