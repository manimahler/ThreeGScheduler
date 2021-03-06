package com.manimahler.android.scheduler3g;

import android.content.Context;
import android.content.SharedPreferences;

public class SchedulerSettings {
	// TODO: duplicated keys, handle in the same way as unlock-policy (accessing the keys in the strings)
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
	private static final String INTERVAL_CONNECT_SUSPEND_WHEN_CHARGING = "pref_key_interval_connect_suspend_when_charging";
	
	private static final String CONNECT_INTERVAL = "pref_key_connect_interval";
	private static final String CONNECT_DURATION = "pref_key_connect_duration";
	
	private static final String LOGGING_ON = "pref_key_logging_enable";
	
	private static final String GLOBAL_ON = "pref_key_global_on";
	
	public static final String BLUETOOTH_IN_USE = "pref_key_bluetooth_in_use";
	
	private boolean _globalOn;
	
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
	private boolean _suspendIntervalConnectWhenCharging;
	
	private int _connectInterval;
	private double _connectDuration;
	
	private boolean _loggingEnabled;
	
	private int _unlockPolicyWifi;
	private int _unlockPolicyMobi;
	
	private boolean _bluetoothInUse;
	
	public SchedulerSettings(SharedPreferences preferences, Context context)
	{
		_globalOn = preferences.getBoolean(GLOBAL_ON, true);
		
		_vibrate = preferences.getBoolean(VIBRATE, true);
		_playSound = preferences.getBoolean(PLAY_SOUND, true);
		
		_delay = tryReadIntLarger0(preferences, DELAY, 60);
		_autoDelay = preferences.getBoolean(AUTO_DELAY, false);
		
		_warnOnDeactivation = preferences.getBoolean(WARN_DEACTIVATION, true);
		_warnOnlyWhenScreenOn = preferences.getBoolean(WARN_DEACTIVATION_ONLY_SCREEN_ON, true);
		
		_notifyEachAction = preferences.getBoolean(NOTIFY_ALL_ACTIONS, false);
		
		_intervalConnectWifi = preferences.getBoolean(INTERVAL_CONNECT_WIFI, false);
		_intervalConnectMobileData = preferences.getBoolean(INTERVAL_CONNECT_MOBILEDATA, false);

		_connectInterval = tryReadIntLarger0(preferences, CONNECT_INTERVAL, 20);
		_connectDuration = tryReadDoubleLarger0(preferences, CONNECT_DURATION, 0.25);
		
		_keepWifiConnected = preferences.getBoolean(INTERVAL_CONNECT_WIFI_KEEP, false);
		_suspendIntervalConnectWhenCharging = preferences.getBoolean(INTERVAL_CONNECT_SUSPEND_WHEN_CHARGING, false);
		
		_loggingEnabled = preferences.getBoolean(LOGGING_ON, false);
		
		_unlockPolicyWifi = tryReadIntLarger0(preferences, context.getString(R.string.pref_key_unlock_policy_wifi), 2);
		_unlockPolicyMobi = tryReadIntLarger0(preferences, context.getString(R.string.pref_key_unlock_policy_mob), 2);
		
		_bluetoothInUse = preferences.getBoolean(BLUETOOTH_IN_USE, false);
	}
	
	private int tryReadIntLarger0(SharedPreferences preferences, String name, int defValue) {
		
		String defValueString = "default";
		String stringValue = preferences.getString(name, defValueString);
		
		int result = defValue;
		if (! stringValue.equals(defValueString)) {
			try {
				result = Integer.parseInt(stringValue);
				
				// safety net, we don't want 0
				if (result == 0)
				{
					result = 1;
				}
			}
			catch (Exception ex) {
				// caught intentionally, the stored value is no integer
			}
		}
		
		return result;
	}
	

	private double tryReadDoubleLarger0(SharedPreferences preferences, String name, double defValue) {
		
		String defValueString = "default";
		String stringValue = preferences.getString(name, defValueString);
		
		double result = defValue;
		if (! stringValue.equals(defValueString)) {
			try {
				result = Double.parseDouble(stringValue);
				
				// safety net, we don't want 0
				if (result == 0)
				{
					result = 1;
				}
			}
			catch (Exception ex) {
				// caught intentionally, the stored value is no double
			}
		}
		
		return result;
	}
	
	public boolean is_globalOn() {
		return _globalOn;
	}
	
	public void set_globalOn(boolean _globalOn) {
		this._globalOn = _globalOn;
	}
	
	public boolean is_warnOnlyWhenInUse() {
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
	
	public boolean is_suspendIntervalConnectWhenCharging() {
		return _suspendIntervalConnectWhenCharging;
	}

	public void set_suspendIntervalConnectWhenCharging(
			boolean _suspendIntervalConnectWhenCharging) {
		this._suspendIntervalConnectWhenCharging = _suspendIntervalConnectWhenCharging;
	}

	public int get_connectInterval() {
		return _connectInterval;
	}

	public void set_connectInterval(int _connectInterval) {
		this._connectInterval = _connectInterval;
	}

	public double get_connectDuration() {
		return _connectDuration;
	}

	public void set_connectDuration(double _connectDuration) {
		this._connectDuration = _connectDuration;
	}

	public boolean is_loggingEnabled() {
		return _loggingEnabled;
	}

	public void set_loggingEnabled(boolean _loggingEnabled) {
		this._loggingEnabled = _loggingEnabled;
	}

	public int get_unlockPolicyWifi() {
		return _unlockPolicyWifi;
	}

	public void set_unlockPolicyWifi(int _unlockPolicyWifi) {
		this._unlockPolicyWifi = _unlockPolicyWifi;
	}

	public int get_unlockPolicyMobi() {
		return _unlockPolicyMobi;
	}

	public void set_unlockPolicyMobi(int _unlockPolicyMobi) {
		this._unlockPolicyMobi = _unlockPolicyMobi;
	}

	public boolean is_bluetoothInUse() {
		return _bluetoothInUse;
	}

	public void set_bluetoothInUse(boolean _bluetoothInUse) {
		this._bluetoothInUse = _bluetoothInUse;
	}
	
	
}
