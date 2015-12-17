
package org.borsoi.game.lib.business.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.borsoi.game.lib.object.enumeric.ResourceType;
import org.borsoi.game.lib.object.object.UserContext;
import org.borsoi.game.lib.object.object.human.Human;
import org.borsoi.game.lib.object.object.job.Modification;
import org.borsoi.game.lib.object.object.job.Resource;

public class MainController {

	private List<Human> humanList = new ArrayList<Human>();

	private boolean isFinish = false;

	private UserContext userContext;

	public MainController() {
		userContext = new UserContext();

		// TODO move to init of userContext with read xml file
		userContext.setResourceList(new ArrayList<Resource>());
		Resource resource = new Resource();
		resource.setResourceType(ResourceType.FOOD);
		resource.setValue(200);
		userContext.getResourceList().add(resource);
		userContext.setModificationList(new ArrayList<Modification>());
		userContext
				.setTotalModificationMap(new HashMap<ResourceType, Double>());

	}

	public void addNewHuman() {
		getHumanList().add(new Human());
		updateModifcation();
	}

	private void updateModifcation() {

		List<Modification> modificationList = new ArrayList<Modification>();
		for (Human human : humanList) {
			if (human.getJob() != null
					&& human.getJob().getModificationList() != null) {
				modificationList.addAll(human.getJob().getModificationList());

			}
		}
		userContext.setModificationList(modificationList);
		HashMap<ResourceType, Double> totalMap = new HashMap<ResourceType, Double>();
		if (!modificationList.isEmpty()) {
			for (Modification modification : modificationList) {
				if (totalMap.containsKey(modification.getModificationType())) {
					totalMap.put(modification.getModificationType(),
							totalMap.get(modification.getModificationType())
									+ modification.getValue());
				} else {
					totalMap.put(modification.getModificationType(), modification.getValue());
				}
			}

		}
		userContext.setTotalModificationMap(totalMap);
	}

	public boolean updateUserContext() {

		return true;
	}

	public synchronized List<Human> getHumanList() {
		return humanList;
	}

	public synchronized void setHumanList(List<Human> humanList) {
		this.humanList = humanList;
	}

	public boolean isFinish() {
		return isFinish;
	}

	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}

	/**
	 * Return userContext
	 * 
	 * @return userContext
	 */
	public UserContext getUserContext() {
		return userContext;
	}

	/**
	 * Set userContext
	 * 
	 * @param pUserContext
	 *            userContext
	 */
	public void setUserContext(UserContext pUserContext) {
		userContext = pUserContext;
	}

}
