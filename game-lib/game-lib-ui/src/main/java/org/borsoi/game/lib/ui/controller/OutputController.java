package org.borsoi.game.lib.ui.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.borsoi.game.lib.business.controller.MainController;
import org.borsoi.game.lib.object.enumeric.JobType;
import org.borsoi.game.lib.object.enumeric.ResourceType;
import org.borsoi.game.lib.object.object.UserContext;
import org.borsoi.game.lib.object.object.human.Human;
import org.borsoi.game.lib.object.object.job.Resource;

public class OutputController {

	public static void showMainScreen(MainController pMainController) {

		cleanConsole();
		drawMap(pMainController.getUserContext());
		drawALine();
		showResources(pMainController.getUserContext());
		drawALine();
		showJob(pMainController.getHumanList());
		drawALine();
		showMenu();
		drawALine();
		
	}

private static void drawMap(UserContext userContext) {
		if (userContext != null) {
			
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
