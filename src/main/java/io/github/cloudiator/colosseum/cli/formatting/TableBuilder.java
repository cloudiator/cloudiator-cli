package io.github.cloudiator.colosseum.cli.formatting;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by daniel on 31.05.16.
 */
public class TableBuilder implements ColumnBuilder, RowBuilder {

    private List<String> columns;
    private List<List<String>> rows;

    public TableBuilder() {
        columns = new ArrayList<>();
        rows = new ArrayList<>();
    }

    @Override public ColumnBuilder addColumn(String header) {
        this.columns.add(header);
        return this;
    }

    @Override public RowBuilder rows() {
        return this;
    }

    @Override public RowBuilder addRow(String... strings) {
        if (strings.length != columns.size()) {
            throw new IllegalArgumentException(String
                .format("size of rows (%s) != size of columns (%s)", strings.length,
                    columns.size()));
        }
        rows.add(Arrays.asList(strings));
        return this;
    }

    @Override public void print() {
        System.out.print(toString());
    }

    private int[] colWidths() {
        int cols = columns.size();
        int[] widths = new int[cols];
        for (List<String> row : rows) {
            for (int colNum = 0; colNum < row.size(); colNum++) {
                int rowLength = Math.max(StringUtils.length(columns.get(colNum)),
                    StringUtils.length(row.get(colNum)));
                widths[colNum] = Math.max(widths[colNum], rowLength);
            }
        }
        return widths;
    }

    private String line(int lenght) {
        String line = "";
        for (int i = 0; i < lenght; i++) {
            line += "-";
        }
        return line;
    }

    @Override public String toString() {
        StringBuilder buf = new StringBuilder();

        int[] colWidths = colWidths();

        for (int colNum = 0; colNum < colWidths.length; colNum++) {
            buf.append(StringUtils
                .rightPad(StringUtils.defaultString(columns.get(colNum)), colWidths[colNum]));
            buf.append(' ');

        }
        buf.append('\n');
        for (int colNum = 0; colNum < colWidths.length; colNum++) {
            buf.append(StringUtils
                .rightPad(StringUtils.defaultString(line(colWidths[colNum])), colWidths[colNum]));
            buf.append(' ');
        }
        buf.append('\n');

        for (List<String> row : rows) {
            for (int colNum = 0; colNum < row.size(); colNum++) {
                buf.append(StringUtils
                    .rightPad(StringUtils.defaultString(row.get(colNum)), colWidths[colNum]));
                buf.append(' ');
            }

            buf.append('\n');
        }

        return buf.toString();
    }
}
