package uz.onveti.itv.launcher

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentActivity
import uz.onveti.itv.launcher.databinding.ActivityMainBinding
import uz.onveti.itv.launcher.ui.apps.AppsActivity

class MainActivity : FragmentActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonSetup.setOnClickListener {
//            val intent = Intent(this, SetupActivity::class.java)
//            startActivity(intent)
            val packageManager = packageManager
            val leanbackLauncherIntent =
                packageManager.getLeanbackLaunchIntentForPackage(packageName)

            if (leanbackLauncherIntent == null) {
                val intent = Intent(Intent.ACTION_MAIN)
                intent.addCategory(Intent.CATEGORY_HOME)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            } else {
                val componentName = leanbackLauncherIntent.component
                val intent = Intent(Intent.ACTION_MAIN)
                intent.addCategory(Intent.CATEGORY_LEANBACK_LAUNCHER)
                intent.setComponent(componentName)
                startActivity(intent)
            }
        }

        binding.buttonAllApps.setOnClickListener {
            val intent = Intent(this, AppsActivity::class.java)
            startActivity(intent)
        }

        binding.buttonVideo.setOnClickListener {
            Toast.makeText(this, "No content yet", Toast.LENGTH_SHORT).show()
        }


    }

}