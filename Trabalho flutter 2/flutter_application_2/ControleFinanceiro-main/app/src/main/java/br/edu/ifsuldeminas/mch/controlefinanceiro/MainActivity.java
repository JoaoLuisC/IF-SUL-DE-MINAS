package br.edu.ifsuldeminas.mch.controlefinanceiro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private EditText usernameInput;
    private EditText passwordInput;
    private CheckBox rememberMeCheckBox;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        boolean isRemembered = preferences.getBoolean("isRemembered", false);

        if (isRemembered) {
            Toast.makeText(MainActivity.this, "Bem-vindo de volta !", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        setContentView(R.layout.login_page);

        TextInputLayout usernameLayout = findViewById(R.id.loginMenuInputName);
        TextInputLayout passwordLayout = findViewById(R.id.loginMenuInputPassword);
        usernameInput = usernameLayout.getEditText();
        passwordInput = passwordLayout.getEditText();
        rememberMeCheckBox = findViewById(R.id.loginCheckBoxRememberMe);

        Button loginButton = findViewById(R.id.loginMenuButtonEnter);
        loginButton.setOnClickListener(v -> {
            String username = usernameInput.getText().toString();
            String password = passwordInput.getText().toString();

            if (username.equals("admin") && password.equals("admin")) {
                if (rememberMeCheckBox.isChecked()) {
                    // Salva a preferência "Mantenha-me conectado" e o nome do usuário
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("isRemembered", true);
                    editor.putString("rememberedUsername", username);
                    editor.apply();
                }

                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                intent.putExtra("USERNAME", username);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(MainActivity.this, "Login ou senha inválidos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
