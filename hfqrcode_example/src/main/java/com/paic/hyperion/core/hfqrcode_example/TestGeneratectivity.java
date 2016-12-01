package com.paic.hyperion.core.hfqrcode_example;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.paic.hyperion.core.hfqrcode.HFQRCode;

public class TestGeneratectivity extends Activity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_generate);
        imageView = (ImageView) findViewById(R.id.iv_qrcode);
        // 耗时操作，需线程处理
        Bitmap bitmap = HFQRCode.syncEncodeQRCode("paic", dp2px(TestGeneratectivity.this, 150));
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            Toast.makeText(TestGeneratectivity.this, "生成二维码失败", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.decode_qrcode:
                imageView.setDrawingCacheEnabled(true);
                Bitmap bitmap = imageView.getDrawingCache();
                // 耗时操作，需线程处理
                String result = HFQRCode.syncDecodeQRCode(bitmap);
                Toast.makeText(TestGeneratectivity.this, result, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    public static int dp2px(Context context, float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, context.getResources().getDisplayMetrics());
    }
}