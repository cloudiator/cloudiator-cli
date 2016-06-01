package io.github.cloudiator.colosseum.cli.commands;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultBannerProvider;
import org.springframework.shell.support.util.OsUtils;
import org.springframework.stereotype.Component;

/**
 * Created by daniel on 01.06.16.
 */
@Component @Order(Ordered.HIGHEST_PRECEDENCE) public class BannerProvider
    extends DefaultBannerProvider {

    public String getBanner() {
        StringBuffer buf = new StringBuffer();
        buf.append("=======================================" + OsUtils.LINE_SEPARATOR);
        buf.append("*                                     *" + OsUtils.LINE_SEPARATOR);
        buf.append("*            HelloWorld               *" + OsUtils.LINE_SEPARATOR);
        buf.append("*                                     *" + OsUtils.LINE_SEPARATOR);
        buf.append("=======================================" + OsUtils.LINE_SEPARATOR);
        buf.append("Version:" + this.getVersion());
        return buf.toString();
    }

    public String getVersion() {
        return "0.1.0";
    }

    public String getWelcomeMessage() {
        return "Welcome to Colosseum CLI";
    }

    @Override public String getProviderName() {
        return "Colosseum CLI Banner";
    }
}
