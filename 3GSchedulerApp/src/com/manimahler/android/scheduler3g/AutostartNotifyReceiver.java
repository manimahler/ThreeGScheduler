package com.manimahler.android.scheduler3g;

import java.util.ArrayList;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

public class AutostartNotifyReceiver extends BroadcastReceiver {

	private final String BOOT_COMPLETED_ACTION = "android.intent.action.BOOT_COMPLETED";
	
	@Override
	public void onReceive(Context context, Intent intent) {

		try {
			if (intent.getAction().equals(BOOT_COMPLETED_ACTION)) {

				RestartAlarmAfterBoot(context);

				Log.i("Autostart", "**********started************");
			}
		} catch (Exception e) {
			Log.e(BOOT_COMPLETED_ACTION, "Error starting 3G scheduler", e);
		}
	}
	
	public void RestartAlarmAfterBoot(Context context)
	{
		NetworkScheduler alarmHandler = new NetworkScheduler();
		
		SharedPreferences prefs = alarmHandler.GetPreferences(context);
		
		ArrayList<EnabledPeriod> enabledPeriods = 
			PersistenceUtils.readFromPreferences(prefs);
		
		for (EnabledPeriod enabledPeriod : enabledPeriods) {
			alarmHandler.setAlarm(context, enabledPeriod);
		}
		
//		ScheduleSettings settings = new ScheduleSettings(prefs);
//		
//		alarmHandler.setAlarm(context, settings);
	}
}