package dangnhap_dangki;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.foody.MainActivity;
import com.example.foody.R;

import DataBase.DBuser;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button btnlogin, btndk;
    DBuser DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.eUser);
        password = (EditText) findViewById(R.id.ePass);
        btnlogin = (Button) findViewById(R.id.btnsignin);
        btndk = (Button) findViewById(R.id.btndangki);
        DB = new DBuser(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Bạn chưa nhập dữ liệu", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if (checkuserpass == true) {
                        Toast.makeText(LoginActivity.this, "Đăng Nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Tên Đăng Nhập hoặc Mật Khẩu không hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btndk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DangkiActivity.class);
                startActivity(intent);
            }
        });
    }
}

