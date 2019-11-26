package com.journaldev.barcodevisionapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnScanBarcode;
    TextView txtScannedCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btnScanBarcode = findViewById(R.id.btnScanBarcode);
        btnScanBarcode.setOnClickListener(this);

        txtScannedCode = findViewById(R.id.txtScannedCode);

        if (getIntent().getStringExtra("scanned_code") != null) {
            txtScannedCode.setText("Scanned Code: " + getIntent().getStringExtra("scanned_code"));
        } else {
            txtScannedCode.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnScanBarcode:
                startActivity(new Intent(MainActivity.this, ScannedBarcodeActivity.class));
                break;
        }

    }
}
