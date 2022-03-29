package kelas.b.activity2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MenuActivity extends AppCompatActivity {
    //deklarasi variabel dengan tipe data edittext
    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtrepass;

    //deklarasi variabel dengan tipe data floating action button
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView((R.layout.activity_menu));

        edtNama = findViewById(R.id.edNama);
        edtAlamat = findViewById(R.id.edAlamat);
        edtEmail = findViewById(R.id.edEmail);
        edtPassword = findViewById(R.id.edPass);
        edtrepass = findViewById(R.id.edrepass);

        fab = findViewById(R.id.fabsimpan);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNama.getText().toString().isEmpty() ||
                        edtAlamat.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty() ||
                        edtrepass.getText().toString().isEmpty())
                {
                    //menampilkan notif wajib isi data
                    Snackbar.make(view, "Wajib Di isi seluruh data!!", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    //membuat kondisi jika pass dan repass sama atau tidak
                    if (edtPassword.getText().toString().equals(edtrepass.getText().toString()))
                    {
                        //notif berhasil
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil...",
                                Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        //notif pw dan repass tidak sama
                        Snackbar.make(view, "Password dan Repassword harus sama",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}

