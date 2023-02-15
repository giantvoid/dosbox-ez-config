package giantvoid.dosbox.ezconfig.base;

import giantvoid.dosbox.ezconfig.gui.Item;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.*;
import java.util.List;

public class Props {
    // Some flashy ridiculous defaults which should never be returned
    private static final String UNDEFINED_STRING_VALUE = "!!!UNDEFINED!!!";
    private static final int UNDEFINED_INT_VALUE = -111;
    private static final ImageIcon UNDEFINED_IMAGE = new ImageIcon(Objects.requireNonNull(Props.class.getResource("/images/undefined.png")));

    private static final Map<String, Properties> sections = new LinkedHashMap<>();

    // The section-based parsing implementation is based on: https://stackoverflow.com/a/41084504/14716574
    public static void load(Reader reader) throws IOException {
        new Properties() {
            private Properties sectionProperties = new Properties();

            @Override
            public synchronized Object put(Object key, Object value) {
                String keyString = (((String) key).trim() + ' ' + value).trim();
                if (keyString.startsWith("[") && keyString.endsWith("]")) {
                    String newSectionName = keyString.substring(1, keyString.length() - 1).trim();
                    sectionProperties = new Properties();
                    return sections.put(newSectionName, sectionProperties);
                } else {
                    return sectionProperties.put(key, value);
                }
            }
        }.load(reader);
    }

    public static String get(String section, String propertyName) {
        if (!sections.containsKey(section)) {
            return UNDEFINED_STRING_VALUE;
        }
        String value = sections.get(section).getProperty(propertyName);
        return value != null ? value : UNDEFINED_STRING_VALUE;
    }

    public static int getInt(String section, String propertyName) {
        String stringValue = get(section, propertyName);
        return UNDEFINED_STRING_VALUE.equals(stringValue) ? UNDEFINED_INT_VALUE : Integer.parseInt(stringValue);
    }

    public static Set<String> getSectionNames() {
        return sections.keySet();
    }

    public static ImageIcon getImageIcon(String propertyName) {
        return getImageIcon("images", propertyName);
    }

    public static ImageIcon getImageIcon(String section, String propertyName) {
        String imageResourcePath = get(section, propertyName);
        if (UNDEFINED_STRING_VALUE.equals(imageResourcePath)) {
            return UNDEFINED_IMAGE;
        }
        URL resourceUrl = Props.class.getResource("/images/" + imageResourcePath);
        if (resourceUrl == null) {
            return UNDEFINED_IMAGE;
        }
        return new ImageIcon(resourceUrl);
    }

    public static List<Item> getItems(String listName) {
        return null;
        // TODO
    }
}
