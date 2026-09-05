package com.research.fakegps;

import android.content.Context;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Mock response handler for forensic demo
 * Simulates backend validation response from tiket.git app
 */
public class MockResponseHandler {
    private static final boolean FORENSIC_MODE_ENABLED = true;

    public interface MockCallback {
        void onMockResponse(JSONObject response);
    }

    public static void simulateFraudAppResponse(Context context, MockCallback callback) {
        if (!FORENSIC_MODE_ENABLED) {
            return;
        }

        Toast.makeText(context, "[FORENSIC DEMO] Mock response enabled", Toast.LENGTH_SHORT).show();

        try {
            // Simulate what tiket.git app receives from backend
            JSONObject mockResponse = new JSONObject();

            // Mock fraud driver data
            JSONArray fraudDrivers = new JSONArray();

            JSONObject driver1 = new JSONObject();
            driver1.put("Nama", "PNS FRAUD #1 - Using Gofood");
            driver1.put("Tikor", "-6.123456,106.789012");  // Jakarta
            fraudDrivers.put(driver1);

            JSONObject driver2 = new JSONObject();
            driver2.put("Nama", "PNS FRAUD #2 - Using Grabcar");
            driver2.put("Tikor", "-6.234567,106.890123");  // Jakarta Selatan
            fraudDrivers.put(driver2);

            JSONObject driver3 = new JSONObject();
            driver3.put("Nama", "PNS FRAUD #3 - Using Goride");
            driver3.put("Tikor", "-6.345678,107.001234");  // Bogor
            fraudDrivers.put(driver3);

            mockResponse.put("drivers", fraudDrivers);
            mockResponse.put("status", "success");
            mockResponse.put("device_id", "FORENSIC_DEMO_MOCK");

            // Return mock response
            if (callback != null) {
                callback.onMockResponse(mockResponse);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
