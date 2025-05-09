// Generated by view binder compiler. Do not edit!
package uz.onveti.itv.launcher.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import uz.onveti.itv.launcher.R;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button buttonAllApps;

  @NonNull
  public final Button buttonSetup;

  @NonNull
  public final Button buttonVideo;

  @NonNull
  public final FrameLayout fragmentContainer;

  @NonNull
  public final LinearLayout mainBrowseFragment;

  private ActivityMainBinding(@NonNull LinearLayout rootView, @NonNull Button buttonAllApps,
      @NonNull Button buttonSetup, @NonNull Button buttonVideo,
      @NonNull FrameLayout fragmentContainer, @NonNull LinearLayout mainBrowseFragment) {
    this.rootView = rootView;
    this.buttonAllApps = buttonAllApps;
    this.buttonSetup = buttonSetup;
    this.buttonVideo = buttonVideo;
    this.fragmentContainer = fragmentContainer;
    this.mainBrowseFragment = mainBrowseFragment;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonAllApps;
      Button buttonAllApps = ViewBindings.findChildViewById(rootView, id);
      if (buttonAllApps == null) {
        break missingId;
      }

      id = R.id.buttonSetup;
      Button buttonSetup = ViewBindings.findChildViewById(rootView, id);
      if (buttonSetup == null) {
        break missingId;
      }

      id = R.id.buttonVideo;
      Button buttonVideo = ViewBindings.findChildViewById(rootView, id);
      if (buttonVideo == null) {
        break missingId;
      }

      id = R.id.fragment_container;
      FrameLayout fragmentContainer = ViewBindings.findChildViewById(rootView, id);
      if (fragmentContainer == null) {
        break missingId;
      }

      LinearLayout mainBrowseFragment = (LinearLayout) rootView;

      return new ActivityMainBinding((LinearLayout) rootView, buttonAllApps, buttonSetup,
          buttonVideo, fragmentContainer, mainBrowseFragment);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
