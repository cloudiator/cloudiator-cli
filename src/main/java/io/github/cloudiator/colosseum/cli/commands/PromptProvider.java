package io.github.cloudiator.colosseum.cli.commands;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultPromptProvider;
import org.springframework.stereotype.Component;

/**
 * Created by daniel on 01.06.16.
 */
@Component @Order(Ordered.HIGHEST_PRECEDENCE) public class PromptProvider
    extends DefaultPromptProvider {

    @Override public String getPrompt() {
        return "colosseum-cli>";
    }


    @Override public String getProviderName() {
        return "Colosseum CLI Prompt Provider";
    }

}
