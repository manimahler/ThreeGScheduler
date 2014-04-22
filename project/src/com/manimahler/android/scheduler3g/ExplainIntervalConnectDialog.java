package com.manimahler.android.scheduler3g;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExplainIntervalConnectDialog extends DialogFragment {

	private static final String RADIO = "RADIO";
	private static final String INTERVAL = "CONNECT_INTERVAL";
	private static final String DURATION = "CONNECT_DURATION";

	private String _radio;
	private int _connectInterval;
	private int _connectDuration;

	// Factory method
	public static ExplainIntervalConnectDialog newInstance(String radio,
			int connectInterval, int connectDuration) {

		ExplainIntervalConnectDialog f = new ExplainIntervalConnectDialog();

		// Supply input as argument.
		Bundle args = new Bundle();

		saveToBundle(args, radio, connectInterval, connectDuration);

		f.setArguments(args);

		return f;
	}

	public ExplainIntervalConnectDialog() {
		// Empty constructor required for DialogFragment
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		Bundle savedData;
		if (savedInstanceState != null) {
			savedData = savedInstanceState;
		} else {
			savedData = getArguments();
		}

		// read from bundle
		_radio = savedData.getString(RADIO);
		_connectInterval = savedData.getInt(INTERVAL);
		_connectDuration = savedData.getInt(DURATION);

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		LayoutInflater inflator = getActivity().getLayoutInflater();
		View view = inflator.inflate(R.layout.alert_dialog, null);

		TextView messageView = (TextView) view.findViewById(R.id.message);

		String explainTextFormat = getActivity().getResources().getString(
				R.string.explain_interval_connection_text);

		messageView.setText(String.format(explainTextFormat, _radio,
				_connectInterval, _connectDuration));

		builder.setView(view);

		builder.setNegativeButton(R.string.close_dialog,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

					}
				});

		// Create the AlertDialog object and return it
		AlertDialog dialog = builder.create();

		dialog.setCanceledOnTouchOutside(true);

		return dialog;
	}

	@Override
	public void onStart() {
		super.onStart();

		AlertDialog dialog = (AlertDialog) getDialog();

		Button cancelButton = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);

		if (cancelButton != null) {
			cancelButton.setBackgroundResource(R.drawable.dialog_button);
		}
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		// Save UI state changes to the savedInstanceState.
		// This bundle will be passed to onCreate if the process is
		// killed and restarted.

		saveToBundle(savedInstanceState, _radio, _connectInterval,
				_connectDuration);
	}

	private static void saveToBundle(Bundle args, String radio,
			int connectInterval, int connectDuration) {
		args.putString(RADIO, radio);
		args.putInt(INTERVAL, connectInterval);
		args.putInt(DURATION, connectDuration);
	}
}