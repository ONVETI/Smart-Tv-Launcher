package uz.onveti.itv.launcher.ui.apps

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import uz.onveti.itv.launcher.adapter.AppPresenter
import uz.onveti.itv.launcher.data.model.AppModel

class AppsFragment : BrowseSupportFragment() {

    private val pm by lazy { requireActivity().packageManager }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title = "ITV"
        headersState = HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true
        prepareRows()
        setupClickListener()
    }

    private fun prepareRows() {
        val apps = getInstalledApps()
        val cardPresenter = AppPresenter()
        val adapter = ArrayObjectAdapter(cardPresenter)
        apps.forEach(adapter::add)

        val categories = listOf("All apps", "Videos", "Music", "TV", "Tools", "Other")

        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        categories.forEachIndexed { index, title ->
            val header = HeaderItem(index.toLong(), title)
            rowsAdapter.add(ListRow(header, adapter))
        }

        this.adapter = rowsAdapter
    }

    private fun getInstalledApps(): List<AppModel> {
        val intent = Intent(Intent.ACTION_MAIN, null).apply {
            addCategory(Intent.CATEGORY_LAUNCHER)
        }

        return pm.queryIntentActivities(intent, 0).map {
            AppModel(
                label = it.loadLabel(pm).toString(),
                icon = it.loadIcon(pm),
                packageName = it.activityInfo.packageName
            )
        }
    }

    private fun setupClickListener() {
        setOnItemViewClickedListener { _, item, _, _ ->
            val app = item as? AppModel ?: return@setOnItemViewClickedListener
            val launchIntent = pm.getLaunchIntentForPackage(app.packageName)
            launchIntent?.let { startActivity(it) }
        }
    }
}
