package org.borsoi.game.lib.ui.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.borsoi.game.lib.business.controller.MainController;
import org.borsoi.game.lib.object.enumeric.Carateritics;
import org.borsoi.game.lib.object.enumeric.JobType;
import org.borsoi.game.lib.object.enumeric.ResourceType;
import org.borsoi.game.lib.object.object.UserContext;
import org.borsoi.game.lib.object.object.human.Human;
import org.borsoi.game.lib.object.object.job.Resource;
import org.borsoi.game.lib.object.object.map.Tile;

public class OutputController {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static void showMainScreen(MainController pMainController) {

		cleanConsole();
		drawStats(pMainController.getMainUser());
		// drawMap(pMainController.getUserContext());
		drawALine();
		showResources(pMainController.getUserContext());
		drawALine();
		showJob(pMainController.getHumanList());
		drawALine();
		showMenu();
		drawALine();

	}

	private static void drawStats(Human human) {
		System.out.println("Max liffe : " + human.getMaxLife());
		if (human.getCarateritics() != null) {
			for (Entry<Carateritics, Long> entry : human.getCarateritics()
					.entrySet()) {

				System.out.println(entry.getKey().name() + " : "
						+ entry.getValue());
			}
		}
	}

	private static void drawMap(UserContext userContext) {
		if (userContext != null) {
			for (Integer i : userContext.getGameMap().getMap().keySet()) {
				for (Integer j : userContext.getGameMap().getMap().get(i)
						.keySet()) {

					Tile tile = userContext.getGameMap().getTitle(i, j);

					System.out.print(getColor(tile.getType()) + "[    ]"
							+ getColor(tile.getType()));
				}
				System.out.println();
			}
		}

	}

	private static String getColor(float type) {

		if (0 < type && type < 0.3) {
			return ANSI_BLACK;

		} else if (0.3 <= type && type < 0.5) {
			return ANSI_GREEN;

		} else if (0.5 <= type && type < 0.6) {
			return ANSI_YELLOW;

		} else {
			return ANSI_BLUE;
		}
	}

	private static void showResources(UserContext userContext) {
		if (userContext != null) {
			System.out.println("Resources    : ");
			if (userContext.getResourceList() != null) {
				for (Resource resource : userContext.getResourceList()) {
					System.out.println(resource.getResourceType().toString()
							+ "          " + resource.getValue());
				}

			}

			System.out.println("Modification : ");
			if (userContext.getTotalModificationMap() != null) {
				for (ResourceType resourceType : userContext
						.getTotalModificationMap().keySet()) {

					double value = userContext.getTotalModificationMap().get(
							resourceType);
					System.out.println(resourceType.toString() + "          "
							+ (value >= 0 ? "+" : "-") + value);

				}

			}
		}

	}

	private static void showJob(List<Human> humanList) {
		if (humanList != null && !humanList.isEmpty()) {
			System.out.println("You have " + humanList.size() + " humans");
			Map<JobType, Integer> temporaryMap = new HashMap<JobType, Integer>();
			for (Human human : humanList) {

				if (human.getJob() == null
						|| human.getJob().getJobType() == null) {
					if (temporaryMap.containsKey(JobType.NONE)) {
						temporaryMap.put(JobType.NONE,
								temporaryMap.get(JobType.NONE) + 1);
					} else {
						temporaryMap.put(JobType.NONE, 1);

					}
				} else {
					if (temporaryMap.containsKey(human.getJob().getJobType())) {
						temporaryMap
								.put(human.getJob().getJobType(), temporaryMap
										.get(human.getJob().getJobType()) + 1);
					} else {
						temporaryMap.put(human.getJob().getJobType(), 1);
					}

				}
			}

			if (!temporaryMap.isEmpty()) {
				for (JobType key : temporaryMap.keySet()) {
					System.out.println("You have " + temporaryMap.get(key)
							+ " " + getLabel(key));
				}
			}
		}

	}

	private static String getLabel(JobType key) {
		switch (key) {
		case NONE:
			return "no job";
		case FARMER:
			return "farmer";
		default:
			break;
		}
		return key.toString();
	}

	private static void showMenu() {
		System.out.println("Menu choose :");
		System.out.println("-- F create a farmer");
		System.out.println("-- E for exist");
	}

	private static void cleanConsole() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

	private static void drawALine() {
		System.out
				.println("------------------------------------------------------------------");

	}

}
