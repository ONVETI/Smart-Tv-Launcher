//package uz.onveti.itv.launcher.tv
//
//import android.os.Bundle
//import androidx.fragment.app.FragmentActivity
//
///**
// * Loads [MainFragment].
// */
//class MainActivity : FragmentActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main2)
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                .replace(R.id.main_browse_fragment, MainFragment())
//                .commitNow()
//        }
//    }
//}