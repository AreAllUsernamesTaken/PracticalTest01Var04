package ro.pub.cs.systems.eim.practicaltest01var04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends Activity {

    private EditText leftEditText = null;
    private EditText rightEditText = null;
    private Button topleftButton = null;
    private Button toprightButton = null;
    private Button botleftButton = null;
    private Button botrightButton = null;
    private Button centerButton = null;
    private int nr =0;
    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
    private Button navigateToSecondaryActivityButton = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        leftEditText = (EditText)findViewById(R.id.left_edit_text);
      //  rightEditText = (EditText)findViewById(R.id.right_edit_text);
        leftEditText.setText(String.valueOf(""));
      //  rightEditText.setText(String.valueOf(0));

        topleftButton = (Button)findViewById(R.id.left_button);
        toprightButton = (Button)findViewById(R.id.right_button);
        botleftButton = (Button)findViewById(R.id.bottom_left_button);
        botrightButton = (Button)findViewById(R.id.bottom_right_button);
        centerButton = (Button)findViewById(R.id.center);

        //  rightButton = (Button)findViewById(R.id.right_button);
        topleftButton.setOnClickListener(buttonClickListener);
        toprightButton.setOnClickListener(buttonClickListener);
        botleftButton.setOnClickListener(buttonClickListener);
        botrightButton.setOnClickListener(buttonClickListener);
        centerButton.setOnClickListener(buttonClickListener);

        navigateToSecondaryActivityButton = (Button)findViewById(R.id.navigate_to_secondary_activity_button);
        navigateToSecondaryActivityButton.setOnClickListener(buttonClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      //  getMenuInflater().inflate(R.menu.practical_test01, menu);
        return true;
    }



    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.left_button:
                    leftEditText.setText(String.valueOf(leftEditText.getText().toString()+",TopLeft"));
                    nr++;
                    break;
                case R.id.right_button:
                    nr++;
                    leftEditText.setText(String.valueOf(leftEditText.getText().toString()+",TopRight"));

                case R.id.bottom_left_button:
                    nr++;
                    leftEditText.setText(String.valueOf(leftEditText.getText().toString()+",BotLeft"));

                    break;
                case R.id.bottom_right_button:
                    nr++;
                    leftEditText.setText(String.valueOf(leftEditText.getText().toString()+",BotRight"));

                    break;
                case R.id.center:
                    nr++;
                    leftEditText.setText(String.valueOf(leftEditText.getText().toString()+",Center"));

                    break;
                case R.id.navigate_to_secondary_activity_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04SecondaryActivity.class);
                    intent.putExtra(String.valueOf(leftEditText.getText().toString()),1);
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    leftEditText.setText("");
                    nr=0;
                    break;
            }
        }
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
     //   if (id == R.id.action_settings) {
     //       return true;
     //   }
        return super.onOptionsItemSelected(item);
    }
}