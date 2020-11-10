package io.openschema.mma.example;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import io.openschema.mma.MobileMetricsAgent;

public class MainActivity extends AppCompatActivity {

    private static final String CONTROLLER_ADDRESS = "controller.openschema.magma.etagecom.io";
    private static final int CONTROLLER_PORT = 443;
    private static final String BOOTSTRAPPER_CONTROLLER_ADDRESS = "bootstrapper-" + CONTROLLER_ADDRESS;
    private static final String METRICS_AUTHORITY_HEADER = "metricsd-" + CONTROLLER_ADDRESS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileMetricsAgent mma = new MobileMetricsAgent.Builder()
                .setAppContext(getApplicationContext())
                .setAuthorityHeader(METRICS_AUTHORITY_HEADER)
                .setControllerAddress(CONTROLLER_ADDRESS)
                .setBootStrapperAddress(BOOTSTRAPPER_CONTROLLER_ADDRESS)
                .setControllerPort(CONTROLLER_PORT)
                .build();

        try {
            mma.init();
            mma.bootstrap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}