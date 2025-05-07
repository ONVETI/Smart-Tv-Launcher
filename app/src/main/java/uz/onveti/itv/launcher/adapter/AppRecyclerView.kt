package uz.onveti.itv.launcher.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.onveti.itv.launcher.databinding.AppItemLayoutBinding
import uz.onveti.itv.launcher.data.model.AppModel

class AppRecyclerView(
    private val onClickListener: (AppModel) -> (Unit),
) : RecyclerView.Adapter<AppRecyclerView.AppViewHolder>() {

    var data = emptyList<AppModel>()
        set(value) {
            field = value
            notifyItemRangeChanged(0, value.size)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AppItemLayoutBinding.inflate(inflater, parent, false)
        val holder = AppViewHolder(binding)

        binding.root.setOnClickListener {
            val position = holder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                data.getOrNull(position)?.let(onClickListener)
            }
        }

        return holder
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        data.getOrNull(position)?.let(holder::onBind)
    }

    class AppViewHolder(
        private val binding: AppItemLayoutBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: AppModel) {
            binding.imageView.setImageDrawable(model.icon)
            binding.titleText.text = model.label
        }
    }
}