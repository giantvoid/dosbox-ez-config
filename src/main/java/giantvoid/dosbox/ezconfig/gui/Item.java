package giantvoid.dosbox.ezconfig.gui;

import lombok.Data;
import lombok.ToString;

@Data
public class Item {
    private final String label;
    private final String value;

    @Override
    public String toString() {
        return label;
    }
}
