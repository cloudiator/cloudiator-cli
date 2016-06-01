package io.github.cloudiator.colosseum.cli.formatting;

/**
 * Created by daniel on 31.05.16.
 */
public interface RowBuilder {

    RowBuilder addRow(String... strings);

    void print();

    String toString();

}
