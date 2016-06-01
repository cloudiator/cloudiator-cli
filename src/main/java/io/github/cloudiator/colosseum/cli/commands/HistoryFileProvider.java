package io.github.cloudiator.colosseum.cli.commands;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultHistoryFileNameProvider;
import org.springframework.stereotype.Component;

/**
 * Created by daniel on 01.06.16.
 */
@Component @Order(Ordered.HIGHEST_PRECEDENCE) public class HistoryFileProvider
    extends DefaultHistoryFileNameProvider {

    public String getHistoryFileName() {
        return "colosseum-cli.log";
    }

    @Override public String getProviderName() {
        return "History file name provider";
    }

}

