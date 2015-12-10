package org.borsoi.game.lib.object.object;

import java.util.List;

import org.borsoi.game.lib.object.object.job.Modification;

public class UserContext
{
    private int food = 0;

    private double totalFoodModification;

    private List<Modification> modificationList;

    /**
     * Return food
     * @return food
     */
    public int getFood()
    {
        return food;
    }

    /**
     * Set food
     * @param pFood food
     */
    public void setFood(int pFood)
    {
        food = pFood;
    }

    /**
     * Return totalFoodModification
     * @return totalFoodModification
     */
    public double getTotalFoodModification()
    {
        return totalFoodModification;
    }

    /**
     * Set totalFoodModification
     * @param pTotalFoodModification totalFoodModification
     */
    public void setTotalFoodModification(double pTotalFoodModification)
    {
        totalFoodModification = pTotalFoodModification;
    }

    /**
     * Return modificationList
     * @return modificationList
     */
    public List<Modification> getModificationList()
    {
        return modificationList;
    }

    /**
     * Set modificationList
     * @param pModificationList modificationList
     */
    public void setModificationList(List<Modification> pModificationList)
    {
        modificationList = pModificationList;
    }

}
