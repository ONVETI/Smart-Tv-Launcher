package uz.onveti.itv.launcher.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.leanback.widget.Presenter
import uz.onveti.itv.launcher.databinding.AppItemLayoutBinding
import uz.onveti.itv.launcher.data.model.AppModel

class AppPresenter : Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val binding = AppItemLayoutBinding.inflate(inflater, parent, false)
        return AppViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any?) {
        val appInfo = item as AppModel
        (viewHolder as AppViewHolder).bind(appInfo)
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {}

    class AppViewHolder(
        private val binding: AppItemLayoutBinding,
    ) : ViewHolder(binding.root) {
        fun bind(model: AppModel) {
            binding.apply {
                titleText.text = model.label
                imageView.setImageDrawable(model.icon)
            }
        }
    }
}
