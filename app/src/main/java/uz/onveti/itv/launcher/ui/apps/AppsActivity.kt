package uz.onveti.itv.launcher.ui.apps

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import uz.onveti.itv.launcher.R
import uz.onveti.itv.launcher.databinding.ActivityAppsBinding

class AppsActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityAppsBinding.inflate(layoutInflater)
    }

//    private val adapter by lazy {
//        AppRecyclerView(onClickListener = {
//            openSelectApp(it.packageName)
//        })
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.app_activity_container, AppsFragment())
            .commit()

    }
}