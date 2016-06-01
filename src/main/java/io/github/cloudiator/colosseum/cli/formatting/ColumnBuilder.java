package io.github.cloudiator.colosseum.cli.formatting;

/**
 * Created by daniel on 31.05.16.
 */
public interface ColumnBuilder {

    ColumnBuilder addColumn(String header);

    RowBuilder rows();
}
