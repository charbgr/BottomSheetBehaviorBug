package com.github.charbgr.bottomsheetbehaviorbug;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

  private BottomSheetBehavior bottomSheetBehavior;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final FrameLayout bottomSheet = findViewById(R.id.bottomsheet);
    bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

    View peekButton = findViewById(R.id.peek_me);
    peekButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        bottomSheetBehavior.setPeekHeight(360);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
      }
    });
  }

  @Override
  public void onBackPressed() {
    if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
      bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    } else {
      super.onBackPressed();
    }
  }
}
