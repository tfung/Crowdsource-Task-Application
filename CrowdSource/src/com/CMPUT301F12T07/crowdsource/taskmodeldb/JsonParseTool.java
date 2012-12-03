package com.CMPUT301F12T07.crowdsource.taskmodeldb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonParseTool {

	public static String parseRandomWid ( String jsonStringVersion) {

		JsonElement jsonElement = new JsonParser().parse(jsonStringVersion);
		JsonArray array = jsonElement.getAsJsonArray();
		ArrayList<String> widList = new ArrayList<String>();

		// set widList
		String wid;
		Iterator iterator = array.iterator();
		while(iterator.hasNext()){
			JsonObject jsonObject = (JsonObject) iterator.next();

			// get wid
			JsonElement widElement = jsonObject.get("id");
			wid = widElement.getAsString();
			widList.add(wid);
		}

		// get random wid
		int max = widList.size();
		Random generator = new Random(); 
		int randomIndex = generator.nextInt(max);
		wid = widList.get(randomIndex);

		return "wid";
	}

	// parse task list for HomeScreen
	public static List<Task> parseTaskList (String jsonStringVersion) {
		List<Task> taskList = new ArrayList<Task>(); 
		// TODO: Convert to a Regular Expression to remove "{ }" and \" \":
		jsonStringVersion = jsonStringVersion.replace("\"{", "{");
		jsonStringVersion = jsonStringVersion.replace("}\"", "}");
		jsonStringVersion = jsonStringVersion.replace("\\", "");
		JsonElement jsonElement = new JsonParser().parse(jsonStringVersion);
		JsonArray array = jsonElement.getAsJsonArray();

		String wid;
		String title;
		String dateDue;
		int quantity;
		int qty_filled;
		String type;

		Iterator iterator = array.iterator();
		while(iterator.hasNext()){
			JsonObject jsonObject = (JsonObject) iterator.next();

			// get wid
			JsonElement widElement = jsonObject.get("id");
			wid = widElement.getAsString();

			// get summary
			JsonObject summaryObject = jsonObject.getAsJsonObject("summary");
			title = summaryObject.get("_title").getAsString();
			dateDue = summaryObject.get("_dateDue").getAsString();
			quantity = summaryObject.get("_quantity").getAsInt();
			qty_filled = summaryObject.get("_qty_filled").getAsInt();
			type = summaryObject.get("_type").getAsString();

			Task task = new Task(wid, title, dateDue, quantity, qty_filled, type);
			taskList.add(task);
		}
		return taskList;
	}


	/*
	// Parse a single RemoteTask
	public static RemoteTask parseRemoteTask (String jsonStringVersion) {

		long tid; 
		String uid;
		String title;
		String description; 
		String dateCreate; 
		String dateDue;
		String type;
		int visibility; // 1 or 0
		int quantity;
		int qty_filled;
		int followed; // 1 or 0
		int num_followed;
		String user_email;
		String wid;

		JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonStringVersion);

		JsonElement tidElement = jsonObject.get("tid");
		tid = tidElement.getAsLong();

		JsonElement uidElement = jsonObject.get("uid");
		uid = uidElement.getAsString();

		JsonElement titleElement = jsonObject.get("title");
		title = titleElement.getAsString();

		JsonElement descriptionElement = jsonObject.get("description");
		description = descriptionElement.getAsString();

		JsonElement dateCreateElement = jsonObject.get("dateCreate");
		dateCreate = dateCreateElement.getAsString();

		JsonElement dateDueElement = jsonObject.get("dateDue");
		dateDue = dateDueElement.getAsString();

		JsonElement typeElement = jsonObject.get("type");
		type = typeElement.getAsString();

		JsonElement visibilityElement = jsonObject.get("visibility");
		visibility = visibilityElement.getAsInt();

		JsonElement quantityElement = jsonObject.get("quantity");
		quantity = quantityElement.getAsInt();

		JsonElement qtyfilledElement = jsonObject.get("qty_filled");
		qty_filled = qtyfilledElement.getAsInt();

		JsonElement followedElement = jsonObject.get("followed");
		followed = followedElement.getAsInt();

		JsonElement numfollowedElement = jsonObject.get("num_followed");
		num_followed = numfollowedElement.getAsInt();

		JsonElement useremailElement = jsonObject.get("user_email");
		user_email = useremailElement.getAsString();

		JsonElement widElement = jsonObject.get("wid");
		wid = widElement.getAsString();

		// Create task object
		Task task = new Task(tid, uid, title, description, dateCreate, dateDue,
				type, visibility, quantity, qty_filled, followed, num_followed, user_email);

		// Create RemoteTask object
		RemoteTask remoteTask = new RemoteTask(task, wid);
		return remoteTask;
	}
	 */
}


