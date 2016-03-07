package org.borsoi.game.lib.business.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.borsoi.game.lib.business.utils.MapUtility;
import org.borsoi.game.lib.object.enumeric.ResourceType;
import org.borsoi.game.lib.object.object.Humanoide;
import org.borsoi.game.lib.object.object.UserContext;
import org.borsoi.game.lib.object.object.human.Human;
import org.borsoi.game.lib.object.object.job.Modification;
import org.borsoi.game.lib.object.object.job.Resource;
import org.borsoi.game.lib.object.object.map.Tile;
import org.borsoi.game.lib.object.object.map.tile.CityCase;

public class MainController {

	private List<Human> humanList = new ArrayList<Human>();

	private boolean isFinish = false;

	private UserContext userContext;

	public MainController() {
		userContext = new UserContext();

		// TODO move to init of userContext with read xml file
		userContext.setResourceMap(new HashMap<ResourceType, Resource>());
		Resource resource = new Resource();
		resource.setResourceType(ResourceType.FOOD);
		resource.setValue(200);
		userContext.getResourceMap().put(ResourceType.FOOD, resource);
		userContext.setModificationList(new ArrayList<Modification>());
		userContext
				.setTotalModificationMap(new HashMap<ResourceType, Double>());

		userContext.setGameMap(MapUtility.generateMap());
		userContext.setHumanCityList(new ArrayList<Tile>());
		userContext.getHumanCityList().add(
				userContext.getGameMap().getTitle(25, 25));
	}

	public void generateMap() {
		userContext.setGameMap(MapUtility.generateMap());
		userContext.setHumanCityList(new ArrayList<Tile>());
		userContext.getHumanCityList().add(
				userContext.getGameMap().getTitle(25, 25));
	}

	public void addNewHuman() {
		for (Tile tile : userContext.getHumanCityList()) {
			Human human = new Human();
			if (tile.getHumanoideList() == null) {
				tile.setHumanoideList(new ArrayList<Humanoide>());
			}
			tile.getHumanoideList().add(human);
			getHumanList().add(human);
		}
		updateModifcation();
	}

	public void updateModifcation() {

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
					totalMap.put(modification.getModificationType(),
							modification.getValue());
				}
			}

		}
		userContext.setTotalModificationMap(totalMap);
	}

	public boolean updateUserContext() {

		if (userContext != null
				&& userContext.getTotalModificationMap() != null) {
			Map<ResourceType, Resource> resourceMap = userContext
					.getResourceMap();
			for (ResourceType resourceType : userContext
					.getTotalModificationMap().keySet()) {
				if (resourceMap.containsKey(resourceType)) {
					resourceMap.get(resourceType).setValue(
							resourceMap.get(resourceType).getValue()
									+ userContext.getTotalModificationMap()
											.get(resourceType));
				} else {
					Resource resource = new Resource();
					resource.setResourceType(resourceType);
					resource.setValue(userContext.getTotalModificationMap()
							.get(resourceType));
					resourceMap.put(resourceType, resource);
				}
			}

		}

		return true;
	}

	/**
     * 
     */
	public boolean expandCity(Tile tileOrigin , int x, int y) {

		// test if we can had a city here

		CityCase cityCase = new CityCase();
		userContext.getGameMap().putTitle(x, y, cityCase);

		for (int i = 0; i < 4; i++) {
			if (userContext.getGameMap().getTitle(x, y).getHumanoideList() == null) {
				userContext.getGameMap().getTitle(x, y)
						.setHumanoideList(new ArrayList<Humanoide>());
			}
			userContext.getGameMap().getTitle(x, y).getHumanoideList()
					.add(tileOrigin.getHumanoideList().remove(i));
		}

		return true;
	}

	/**
	 * test if a city exist around this tile
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean canHadCity(int x, int y) {
		for (Tile tile : userContext.getHumanCityList()) {
			if ((tile.getX() == x - 1 || tile.getX() == x + 1)
					&& (tile.getY() == y - 1 || tile.getY() == y + 1)) {
				return true;
			}
		}
		return false;
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
