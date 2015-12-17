
package org.borsoi.game.lib.object.object;

import java.util.List;
import java.util.Map;

import org.borsoi.game.lib.object.enumeric.ResourceType;
import org.borsoi.game.lib.object.object.job.Modification;
import org.borsoi.game.lib.object.object.job.Resource;

public class UserContext
{
    private List<Resource> resourceList;

    private	Map<ResourceType, Double> totalModificationMap;

    private List<Modification> modificationList;


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

	/**
	 * @return the totalModificationMap
	 */
	public Map<ResourceType, Double> getTotalModificationMap() {
		return totalModificationMap;
	}

	/**
	 * @param totalModificationMap the totalModificationMap to set
	 */
	public void setTotalModificationMap(Map<ResourceType, Double> totalModificationMap) {
		this.totalModificationMap = totalModificationMap;
	}

	/**
	 * @return the resourceList
	 */
	public List<Resource> getResourceList() {
		return resourceList;
	}

	/**
	 * @param resourceList the resourceList to set
	 */
	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}

}
