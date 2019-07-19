package com.discovery.Utility;

import java.util.MissingResourceException;
import java.util.ResourceBundle;


public class PropertyReader {
	private static String BUNDLE_NAME;
	private static ResourceBundle bundle;
	public static String getLocatorValue(String key,String propertyFile) {
		BUNDLE_NAME="Resources."+propertyFile;
		bundle=ResourceBundle.getBundle(BUNDLE_NAME);
		try {
			return bundle.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	
	public static String getLocatorValue(String key) {
		BUNDLE_NAME="Resources.DiscoverElements";
		bundle=ResourceBundle.getBundle(BUNDLE_NAME);
		try {
			return bundle.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}


}
