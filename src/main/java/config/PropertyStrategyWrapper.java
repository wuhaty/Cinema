package config;

import net.sf.json.JSONException;
import net.sf.json.util.PropertySetStrategy;

/**
 * Created by gump on 2018/4/23.
 */
public class PropertyStrategyWrapper extends PropertySetStrategy {
    private PropertySetStrategy original;

    public PropertyStrategyWrapper(PropertySetStrategy original) {
        this.original = original;
    }

    @Override
    public void setProperty(Object o, String string, Object o1) throws JSONException {
        try {
            original.setProperty(o, string, o1);

        } catch (Exception ex) {
        }

    }
}