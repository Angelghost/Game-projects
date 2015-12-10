package org.borsoi.game.lib.object.object.job;

import org.borsoi.game.lib.object.enumeric.ModificationType;

public class Modification
{

    private ModificationType modificationType;

    private double value;

    /**
     * Return modificationType
     * @return modificationType
     */
    public ModificationType getModificationType()
    {
        return modificationType;
    }

    /**
     * Set modificationType
     * @param pModificationType modificationType
     */
    public void setModificationType(ModificationType pModificationType)
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
