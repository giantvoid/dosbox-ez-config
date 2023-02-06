package giantvoid.dosbox.ezconfig.base;

import java.io.IOException;
import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class Props {
    // Some flashy ridiculous defaults which should never be returned
    private static final String UNDEFINED_STRING_VALUE = "!!!UNDEFINED!!!";
    private static final int UNDEFINED_INT_VALUE = -111;


    private static final Map<String, Properties> sections = new LinkedHashMap<>();

    // The section-based parsing implementation is based on: https://stackoverflow.com/a/41084504/14716574
    public static void load(Reader reader) throws IOException {
        sections.clear();
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
        return sections.containsKey(section) ? sections.get(section).getProperty(propertyName) : UNDEFINED_STRING_VALUE;
    }

    public static int getInt(String section, String propertyName) {
        String stringValue = get(section, propertyName);
        return UNDEFINED_STRING_VALUE.equals(stringValue) ? UNDEFINED_INT_VALUE : Integer.parseInt(stringValue);
    }
}
