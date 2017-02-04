package d3s.team_four.our.league.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import d3s.team_four.our.league.R;

public class LoginActivity extends AppCompatActivity {

    private Map<String, String> idpwInfo = new HashMap<String, String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Button loginButton = (Button) findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getStringFromEditText(view);

                // 서버로 id, pw보내주고 처리하기 난나나나난나ㅏ

            }
        });



    }

    private void getStringFromEditText(View v){

        EditText editId = (EditText) v.findViewById(R.id.id);
        EditText editPw = (EditText) v.findViewById(R.id.pw);

        String id = editId.getText().toString();
        String pw = editPw.getText().toString();

        idpwInfo.put("ID", id);
        idpwInfo.put("Password", pw);
    }



}
