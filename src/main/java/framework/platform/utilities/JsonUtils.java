package framework.platform.utilities;

import framework.Logger;
import framework.adapters.WebDriverManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;

import static org.testng.Assert.fail;

public class JsonUtils {

	private static String stringJson = "";

	public static void setStringJson(String stringJson) {
		JsonUtils.stringJson = stringJson;
	}

	public static String getJsonObjectValue(String objectName) {
		Logger.info("Getting " + objectName + " from json body");
		JSONObject obj = getJSONObject(0);
		try {
			return obj.getString(objectName);
		} catch (JSONException e) {
			e.printStackTrace();
			fail("Object " + objectName + " not found");
		}
		return "";
	}

	public static String getJsonObjectValue(String objectName, String valueName) {
		JSONObject obj = getJSONObject(0);
		try {
			return obj.getJSONObject(objectName).getString(valueName);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String getJsonArrayObjectAttributeValue(String object, String array, int elementNumber, String objectInElement, String attributeName) {
		JSONObject obj = getJSONObject(0);
		try {
			JSONArray obj1 = obj.getJSONObject(object).getJSONArray(array);
			return obj1.getJSONObject(elementNumber).getJSONObject(objectInElement).getString(attributeName);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static boolean isJsonObjectAttributePresentInJSONResponse(String rootObject, String arrayItem, int elementNumber, String objectInElement, String attributeName) {
		JSONObject obj = getJSONObject(0);
		try {
			return obj.getJSONObject(rootObject).getJSONArray(arrayItem).getJSONObject(elementNumber)
					.getJSONObject(objectInElement).has(attributeName);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static int getJsonArraySize(String object, String array) {
		JSONObject obj = getJSONObject(0);
		try {
			return obj.getJSONObject(object).getJSONArray(array).length();

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static String getJsonObjectValue(String objectName, int objectNumber) {
		JSONObject obj = getJSONObject(objectNumber);
		try {
			return obj.getString(objectName);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * {"tracker":{
	 * "name":"Dr. Johnathan T Smith",
	 * "profession":"PHYSICIAN",
	 * "email":"testusermain@mailinator.com",
	 * "userID":"970067",
	 * "year":{"id":"2016",
	 * "sum":0.25},
	 * "item":[{"tbid":"59491","tbType":"teachingBrief","title":"Fish Oil May Improve Post-MI Recovery","credit":"0.25","accreditor":"Projects In Knowledge","completion_date":"09\/01\/16"}]}}
	 * <p>
	 * example:
	 * getJsonObjectValueFromJSONObject("tracker","year","id")
	 * will return "2016" from object "year", which is part of "tracker" object
	 */

	public static String getJsonObjectValueFromJSONObject(String... objects) {
		JSONObject obj = getJSONObject(0);
		int objectCount = objects.length;
		int depthCount = 0;
		while (depthCount <= objectCount - 1) {
			try {
				if (depthCount == objectCount - 1) { //this will get needed String from last JSON object
					return obj.getString(objects[objectCount - 1]);
				}
				JSONObject objFromObject = obj.getJSONObject(objects[depthCount]);
				depthCount++;
				obj = objFromObject;
			} catch (JSONException e) {
				e.printStackTrace();
				fail("Object '" + objects[depthCount] + "' not found in JSON response");
			}
		}
		return "";
	}

	/**
	 * {"tracker":{
	 * "name":"Dr. Johnathan T Smith",
	 * "profession":"PHYSICIAN",
	 * "email":"testusermain@mailinator.com",
	 * "userID":"970067",
	 * "year":{"id":"2016",
	 * "sum":0.25},
	 * "item":[{"tbid":"59491","tbType":"teachingBrief","title":"Fish Oil May Improve Post-MI Recovery","credit":"0.25","accreditor":"Projects In Knowledge","completion_date":"09\/01\/16"}]}}
	 * <p>
	 * example:
	 * getJsonObjectValueFromJsonArrayFromObject("tracker","item","tbType")
	 * will return "teachingBrief" from array "item", which is part of "tracker" object
	 */

	public static String getJsonObjectValueFromJsonArrayFromObject(String object, String arrayFromObject, String objectFromArray) {
		JSONObject obj = getJSONObject(0);
		try {
			JSONObject obj2 = obj.getJSONObject(object);
			JSONArray arr = obj2.getJSONArray(arrayFromObject);
			JSONObject obj1 = (JSONObject) arr.get(0);
			return obj1.getString(objectFromArray);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String getJsonObjectValueFromJsonArray(String object, String objectFromArray) {
		JSONObject obj = getJSONObject(0);
		try {
			JSONArray arr = obj.getJSONArray(object);
			JSONObject obj1 = (JSONObject) arr.get(0);
			return obj1.getString(objectFromArray);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String getJsonObjectFromArray(String object, String subObject, int objectNumber) {
		JSONObject obj = getJSONObject(0);
		try {
			JSONArray obj1 = obj.getJSONArray(object);
			obj = (JSONObject) obj1.get(objectNumber);
			return obj.getString(subObject);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String getJsonObjectNumberFromArrayNumber(String object, String subObject, int objectNumber, int subObjectNumber) {
		JSONObject obj = getJSONObject(objectNumber);
		try {
			JSONArray obj1 = obj.getJSONArray(object);
			obj = (JSONObject) obj1.get(subObjectNumber);
			return obj.getString(subObject);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String getJsonObjectFromArray(String object, int itemInArray, String subObject, String objectName) {
		JSONObject obj = getJSONObject(0);
		try {
			JSONArray obj1 = obj.getJSONArray(object);
			obj = (JSONObject) obj1.get(itemInArray);
			obj = (JSONObject) obj.get(subObject);
			return obj.getString(objectName);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static int getJsonArrayLength(String array) {
		JSONObject obj = getJSONObject(0);
		try {
			JSONArray array1 = obj.getJSONArray(array);
			return array1.length();
		} catch (JSONException e) {
			e.printStackTrace();
			fail("Array '" + array + "' not found in JSON response");
		}
		return 0;
	}

	public static int getJsonArrayNumberLength(String array, int number) {
		JSONObject obj = getJSONObject(number);
		try {
			return obj.getJSONArray(array).length();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int getJsonArrayLength(String object, String array) {
		JSONObject obj = getJSONObject(0);
		try {
			return obj.getJSONObject(object).getJSONArray(array).length();
		} catch (JSONException e) {
			e.printStackTrace();
			fail("Array '" + array + "' not found in JSON response");
		}
		return 0;
	}

	private static JSONObject getJSONObject(int objectNumber) {
		String json = (stringJson.isEmpty()) ? WebDriverManager.getDriver().findElement(By.xpath("//body")).getText() : stringJson;
		JSONArray message;
		try {
			if (!json.startsWith("[")) {
				message = new JSONArray("[" + json + "]");
			} else {
				message = new JSONArray(json);
			}
			JSONObject obj = (JSONObject) message.get(objectNumber);
			return obj;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int getNumberOfObjectsInJSONResponse() {
		String json = WebDriverManager.getDriver().findElement(By.xpath("//body")).getText();
		JSONArray message;
		try {
			if (!json.startsWith("[")) {
				message = new JSONArray("[" + json + "]");
			} else {
				message = new JSONArray(json);
			}
			return message.length();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static boolean isJsonObjectPresentinJSONResponse(String objectName) {
		return getJSONObject(0).has(objectName);
	}

	public static boolean isJsonObjectAttributePresentInJSONResponse(String objectName, String attributeName) {
		try {
			return getJSONObject(0).getJSONObject(objectName).has(attributeName);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static int getJsonObjectArrayLength(String object) {
		JSONObject obj = getJSONObject(0);
		try {
			return obj.getJSONArray(object).length();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int getJsonSubObjectArrayLength(String object, String arrayName) {
		JSONObject obj = getJSONObject(0);
		try {
			return obj.getJSONObject(object).getJSONArray(arrayName).length();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static String getJsonSubObjectArrayValueInJsonResponse(String object, String arrayName, int itemInArray, String attributeName) {
		JSONObject obj = getJSONObject(0);
		try {
			return obj.getJSONObject(object).getJSONArray(arrayName).getJSONObject(itemInArray).getString(attributeName);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		//return "";
		return "";
	}

	public static String getJsonObjectValue(String objectName, String valueName, int objectNumber) {
		JSONObject obj = getJSONObject(objectNumber);
		try {
			return obj.getJSONObject(objectName).getString(valueName);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "";
	}
}
