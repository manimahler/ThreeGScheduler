package com.manimahler.android.scheduler3g;

import android.content.SharedPreferences;

public class SchedulerSettings {
	// TODO: duplicated keys
	private static final String VIBRATE = "pref_key_warn_vibrate";
	private static final String PLAY_SOUND = "pref_key_warn_sound";
	private static final String WARN_DEACTIVATION_ONLY_SCREEN_ON = "pref_key_warn_only_screen_on";
	private static final String DELAY = "pref_key_delay_min";
	private static final String AUTO_DELAY = "pref_key_notify_no_switchoff_unlocked";
	private static final String WARN_DEACTIVATION = "pref_key_warn_switchoff";
	private static final String NOTIFY_ALL_ACTIONS = "pref_key_notify_each_action";
	
	private static final String INTERVAL_CONNECT_WIFI = "pref_key_interval_connect_wifi";
	private static final String INTERVAL_CONNECT_WIFI_KEEP = "pref_key_interval_connect_wifi_keep_connected";
	private static final String INTERVAL_CONNECT_MOBILEDATA = "pref_key_interval_connect_mobiledata";
	private static final String CONNECT_INTERVAL = "pref_key_connect_interval";
	
	
	
	private boolean _vibrate;
	private boolean _playSound;
	private boolean _warnOnlyWhenScreenOn;
	
	private int _delay;
	private boolean _autoDelay; 
	
	private boolean _warnOnDeactivation;
	private boolean _notifyEachAction;
	
	private boolean _intervalConnectWifi;
	private boolean _intervalConnectMobileData;
	
	private boolean _keepWifiConnected;
	
//	private boolean _alwaysConnectWifiWhenScreenOn;
//	private boolean _alwaysConnectMobileDataWhenSceenOn;
	
	private int _connectInterval;
	
	public SchedulerSettings(SharedPreferences preferences)
	{
		_vibrate = preferences.getBoolean(VIBRATE, true);
		_playSound = preferences.getBoolean(PLAY_SOUND, true);
		
		_delay = Integer.parseInt(preferences.getString(DELAY, "60"));
		_autoDelay = preferences.getBoolean(AUTO_DELAY, false);
		
		_warnOnDeactivation = preferences.getBoolean(WARN_DEACTIVATION, true);
		_warnOnlyWhenScreenOn = preferences.getBoolean(WARN_DEACTIVATION_ONLY_SCREEN_ON, true);
		
		_notifyEachAction = preferences.getBoolean(NOTIFY_ALL_ACTIONS, false);
		
		_intervalConnectWifi = preferences.getBoolean(INTERVAL_CONNECT_WIFI, false);
		_intervalConnectMobileData = preferences.getBoolean(INTERVAL_CONNECT_MOBILEDATA, false);
		_connectInterval = Integer.parseInt(preferences.getString(CONNECT_INTERVAL, "15"));
		
		_keepWifiConnected = preferences.getBoolean(INTERVAL_CONNECT_WIFI_KEEP, false);
	}
	
	public boolean is_warnOnlyWhenScreenOn() {
		return _warnOnlyWhenScreenOn;
	}
	
	public void set_warnOnlyWhenScreenOn(boolean _warnOnlyWhenScreenOn) {
		this._warnOnlyWhenScreenOn = _warnOnlyWhenScreenOn;
	}
	
	public boolean is_vibrate() {
		return _vibrate;
	}

	public void set_vibrate(boolean _vibrate) {
		this._vibrate = _vibrate;
	}

	public boolean is_playSound() {
		return _playSound;
	}

	public void set_playSound(boolean _playSound) {
		this._playSound = _playSound;
	}

	
	public int get_delay() {
		return _delay;
	}

	public void set_delay(int _delay) {
		this._delay = _delay;
	}

	public boolean is_autoDelay() {
		return _autoDelay;
	}

	public void set_autoDelay(boolean _autoDelay) {
		this._autoDelay = _autoDelay;
	}

	public boolean is_warnOnDeactivation() {
		return _warnOnDeactivation;
	}

	public void set_warnOnDeactivation(boolean _warnOnDeactivation) {
		this._warnOnDeactivation = _warnOnDeactivation;
	}

	public boolean is_notifyEachAction() {
		return _notifyEachAction;
	}

	public void set_notifyEachAction(boolean _notifyEachAction) {
		this._notifyEachAction = _notifyEachAction;
	}

	public boolean is_intervalConnectWifi() {
		return _intervalConnectWifi;
	}

	public void set_intervalConnectWifi(boolean _intervalConnectWifi) {
		this._intervalConnectWifi = _intervalConnectWifi;
	}

	public boolean is_intervalConnectMobileData() {
		return _intervalConnectMobileData;
	}

	public void set_intervalConnectMobileData(boolean _intervalConnectMobileData) {
		this._intervalConnectMobileData = _intervalConnectMobileData;
	}

	public boolean is_keepWifiConnected() {
		return _keepWifiConnected;
	}

	public void set_keepWifiConnected(boolean _keepWifiConnected) {
		this._keepWifiConnected = _keepWifiConnected;
	}

	public int get_connectInterval() {
		return _connectInterval;
	}

	public void set_connectInterval(int _connectInterval) {
		this._connectInterval = _connectInterval;
	}
}
