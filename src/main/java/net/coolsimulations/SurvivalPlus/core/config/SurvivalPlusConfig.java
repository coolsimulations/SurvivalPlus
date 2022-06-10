package net.coolsimulations.SurvivalPlus.core.config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.coolsimulations.SurvivalPlus.api.SPConfig;

public class SurvivalPlusConfig {
	
	static File file;
	static JsonObject object;
	
	public static void init(File fileSrc) {

		SPConfig.disableTinOreGen = false;
		SPConfig.disableTitaniumOreGen = false;
		SPConfig.disableRubyGen = false;
		SPConfig.disableTopazGen = false;
		SPConfig.disableSapphireGen = false;
		SPConfig.disablePearlGen = false;
		SPConfig.disableSpinelGen = false;
		SPConfig.opWak = 0;
		SPConfig.disableUpdateCheck = false;
		SPConfig.disableClientAudio = false;
		SPConfig.disableThanks = false;

		JsonObject jsonObject = setJsonObject(new JsonObject());

		if(!fileSrc.exists() || fileSrc.length() <= 2) {
			save(fileSrc, jsonObject);
		} else {
			load(fileSrc);
		}
		
		file = fileSrc;
		object = jsonObject;

	}
	
	public static void save(File fileSrc, JsonObject object) {
		try {
			FileWriter file = new FileWriter(fileSrc);
			setJsonObject(object);
			file.write(new GsonBuilder().setPrettyPrinting().create().toJson(object));
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void load(File fileSrc) {
		try {
			Object obj = JsonParser.parseReader(new FileReader(fileSrc));
			JsonObject jsonObjectRead = (JsonObject) obj;
			if(jsonObjectRead.get("disableCopperOreGen") != null) {
				jsonObjectRead.remove("disableCopperOreGen");
				save(fileSrc, jsonObjectRead);
			}
			SPConfig.disableTinOreGen = jsonObjectRead.get("disableTinOreGen").getAsBoolean();
			SPConfig.disableTitaniumOreGen = jsonObjectRead.get("disableTitaniumOreGen").getAsBoolean();
			if(jsonObjectRead.get("disableAmethystGen") != null) {
				jsonObjectRead.remove("disableAmethystGen");
				save(fileSrc, jsonObjectRead);
			}
			SPConfig.disableRubyGen = jsonObjectRead.get("disableRubyGen").getAsBoolean();
			SPConfig.disableTopazGen = jsonObjectRead.get("disableTopazGen").getAsBoolean();
			SPConfig.disableSapphireGen = jsonObjectRead.get("disableSapphireGen").getAsBoolean();
			SPConfig.disablePearlGen = jsonObjectRead.get("disablePearlGen").getAsBoolean();
			SPConfig.disableSpinelGen = jsonObjectRead.get("disableSpinelGen").getAsBoolean();
			SPConfig.opWak = jsonObjectRead.get("opWak").getAsInt();
			SPConfig.disableUpdateCheck = jsonObjectRead.get("disableUpdateCheck").getAsBoolean();
			SPConfig.disableClientAudio = jsonObjectRead.get("disableClientAudio").getAsBoolean();
			SPConfig.disableThanks = jsonObjectRead.get("disableThanks").getAsBoolean();
			
			if(SPConfig.opWak < 0) {
				SPConfig.opWak = 0;
			} else if(SPConfig.opWak > 4) {
				SPConfig.opWak = 4;
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public static JsonObject setJsonObject(JsonObject jsonObject) {
		
		jsonObject.addProperty("disableTinOreGen", SPConfig.disableTinOreGen);
		jsonObject.addProperty("disableTitaniumOreGen", SPConfig.disableTitaniumOreGen);
		jsonObject.addProperty("disableRubyGen", SPConfig.disableRubyGen);
		jsonObject.addProperty("disableTopazGen", SPConfig.disableTopazGen);
		jsonObject.addProperty("disableSapphireGen", SPConfig.disableSapphireGen);
		jsonObject.addProperty("disablePearlGen", SPConfig.disablePearlGen);
		jsonObject.addProperty("disableSpinelGen", SPConfig.disableSpinelGen);
		jsonObject.addProperty("opWak", SPConfig.opWak);
		jsonObject.addProperty("disableUpdateCheck", SPConfig.disableUpdateCheck);
		jsonObject.addProperty("disableClientAudio", SPConfig.disableClientAudio);
		jsonObject.addProperty("disableThanks", SPConfig.disableThanks);
		
		return jsonObject;
	}
	
	public static File getFile() {
		return file;
	}
	
	public static JsonObject getObject() {
		return object;
	}

}
