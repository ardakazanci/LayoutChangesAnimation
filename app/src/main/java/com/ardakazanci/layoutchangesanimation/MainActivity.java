package com.ardakazanci.layoutchangesanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	EditText textIn;
	Button btnAdd;
	LinearLayout container;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textIn = findViewById(R.id.textin);
		btnAdd = findViewById(R.id.add);
		container = findViewById(R.id.container);


		btnAdd.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Özel görünümü şişirme işlemi için kullanacağız.
				LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				final View addView = layoutInflater.inflate(R.layout.row, null);
				TextView textOut = addView.findViewById(R.id.textout);
				textOut.setText(textIn.getText().toString());
				Button btnRemove = addView.findViewById(R.id.remove);
				btnRemove.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {

						((LinearLayout) addView.getParent()).removeView(addView);


					}
				});

				container.addView(addView);
				textIn.setText("");

			}
		});


		LayoutTransition layoutTransition = new LayoutTransition();
		container.setLayoutTransition(layoutTransition);

	}
}
