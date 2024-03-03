package tr.com.nuritiras.sirasizdesayfa214;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextNumara,editTextAdSoyad;
    Button buttonEkle;
    ListView listViewListe;
    ArrayList<String> ogrenciArrayList= new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ogrenciArrayList);
        editTextNumara=findViewById(R.id.editTextNumara);
        editTextAdSoyad=findViewById(R.id.editTextAdSoyad);
        buttonEkle=findViewById(R.id.buttonEkle);
        listViewListe=findViewById(R.id.listViewListe);
        listViewListe.setAdapter(adapter);
        buttonEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ogrenci ogrenci=new Ogrenci();
                ogrenci.setNumara(Integer.parseInt(editTextNumara.getText().toString()));
                ogrenci.setAdSoyad(editTextAdSoyad.getText().toString());
                ogrenciArrayList.add(ogrenci.getNumara()+" "+ogrenci.getAdSoyad());
                adapter.notifyDataSetChanged();
            }
        });
        listViewListe.setOnItemClickListener((adapterView, view, i, l) -> {
            ogrenciArrayList.remove(i);
            adapter.notifyDataSetChanged();
        });
    }
}