package com.nstosic.gimmelayouts;

/**
 * Created by nstosic on 9/8/16.
 */
public class WidgetProperties {
    private String resourceId;
    private String propertyName;
    private boolean nullable;
    private LayoutType type;

    public WidgetProperties(String resourceId, String propertyName, LayoutType type) {
        this(resourceId, propertyName, true, type);
    }

    public WidgetProperties(String resourceId, String propertyName, boolean nullable, LayoutType type) {
        this.resourceId = resourceId;
        this.propertyName = propertyName;
        this.nullable = nullable;
        this.type = type;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public LayoutType getType() {
        return type;
    }

    public void setType(LayoutType type) {
        this.type = type;
    }
}
