package org.borsoi.game.lib.object.object.job;

import org.borsoi.game.lib.object.enumeric.ResourceType;

public class Modification
{

    private ResourceType modificationType;

    private double value;

    /**
     * Return modificationType
     * @return modificationType
     */
    public ResourceType getModificationType()
    {
        return modificationType;
    }

    /**
     * Set modificationType
     * @param pModificationType modificationType
     */
    public void setModificationType(ResourceType pModificationType)
    {
        modificationType = pModificationType;
    }

    /**
     * Return value
     * @return value
     */
    public double getValue()
    {
        return value;
    }

    /**
     * Set value
     * @param pValue value
     */
    public void setValue(double pValue)
    {
        value = pValue;
    }
}
