package com.readthefuckingmanual.fuckukk.ui.fragments.cashier.history

import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebHistoryItem
import androidx.recyclerview.widget.RecyclerView
import com.readthefuckingmanual.fuckukk.data.model.transaksi.TransaksiModel
import com.readthefuckingmanual.fuckukk.databinding.ItemCashierHistoryBinding

class ListHistoryAdapter : RecyclerView.Adapter<ListHistoryAdapter.ListMenuViewHolder>() {

    private var historyList: ArrayList<TransaksiModel> = arrayListOf()

    fun setData(data: List<TransaksiModel>){
        historyList.apply {
            clear()
            addAll(data)
            notifyDataSetChanged()
        }
    }



    inner class ListMenuViewHolder(private val binding: ItemCashierHistoryBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(historyItem: TransaksiModel){

            binding.apply {
                tvHistoryIdPesanan.text = historyItem.id_transaksi.toString()
                tvHistoryTanggalPesanan.text = historyItem.tgl_transaksi
                tvHistoryStatusPembayaran.text = historyItem.status
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListHistoryAdapter.ListMenuViewHolder {
        val viewBinding =
            ItemCashierHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListMenuViewHolder((viewBinding))
    }

    override fun onBindViewHolder(holder: ListHistoryAdapter.ListMenuViewHolder, position: Int) {
        val item = historyList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return historyList.size
    }


}