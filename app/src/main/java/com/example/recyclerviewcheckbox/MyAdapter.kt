package com.example.recyclerviewcheckbox

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*

class MyAdapter(context: MainActivity, arrayList: ArrayList<ModelClass>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private val context: Context
    private val arrayList: ArrayList<ModelClass>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modelClass = arrayList[position]
        holder.itemView.textView.text = modelClass.name
        holder.itemView.checkBox.isChecked = modelClass.isSelected
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.checkBox.setOnClickListener { v ->
                val isChecked = (v as CheckBox).isChecked
                arrayList[adapterPosition].isSelected = isChecked

                notifyDataSetChanged()

                for (i in arrayList.indices) {
                    Log.d("TAG", arrayList.toString())
                }
            }

            itemView.rowitem.setOnClickListener {
                Toast.makeText(
                    context, arrayList[adapterPosition].toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    init {
        this.context = context
        this.arrayList = arrayList
    }
}