package com.kitkat.todo.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kitkat.todo.R
import com.kitkat.todo.model.TaskModel
import kotlinx.android.synthetic.main.layout_item.view.*

class CompletedAdapter(
    private val mValues: ArrayList<TaskModel>,
    private val mContext: Context
) : RecyclerView.Adapter<CompletedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]

        holder.task_name.setTextColor(mContext.resources.getColor(R.color.green))
        holder.task_name.text = item.task_name.toString()
        holder.task_date.text = item.task_date.toString()

    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val task_name: TextView = mView.task_name
        val task_date: TextView = mView.task_date


        override fun toString(): String {
            return super.toString() + " wallet "
        }
    }

}