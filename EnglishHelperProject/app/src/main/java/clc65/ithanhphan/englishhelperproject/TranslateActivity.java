package clc65.ithanhphan.englishhelperproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class TranslateActivity extends AppCompatActivity {

    EditText inputText;
    TextView outputText;
    Button translateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        inputText = findViewById(R.id.input_text);
        outputText = findViewById(R.id.output_text);
        translateBtn = findViewById(R.id.translate_btn);

        translateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = inputText.getText().toString().trim();
                if (!text.isEmpty()) {
                    translateText(text);
                }
            }
        });
    }

    private void translateText(String text) {
        try {
            String encodedText = URLEncoder.encode(text, "UTF-8");

            String url =
                    "https://clients5.google.com/translate_a/t?client=dict-chrome-ex&sl=en&tl=vi&q="
                            + encodedText;

            RequestQueue queue = Volley.newRequestQueue(this);

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    response -> {
                        try {
                            JSONArray arr = new JSONArray(response);
                            String translated = arr.getString(0);

                            outputText.setText(translated);

                        } catch (Exception e) {
                            outputText.setText("Lỗi parse JSON!");
                        }
                    },
                    error -> outputText.setText("Lỗi kết nối API!")
            ) {
                @Override
                public Map<String, String> getHeaders() {
                    Map<String, String> headers = new HashMap<>();
                    headers.put("User-Agent", "Mozilla/5.0");
                    return headers;
                }
            };

            queue.add(stringRequest);

        } catch (Exception e) {
            outputText.setText("Lỗi encode URL!");
        }
    }

}
