package com.kitkat.todo

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.kitkat.todo.adapters.CompletedAdapter
import com.kitkat.todo.adapters.InProgressAdapter
import com.kitkat.todo.model.AuthModel
import com.kitkat.todo.model.TaskModel
import com.kitkat.todo.utilities.SwipeHelper

class CustomPagerAdapter(private val mContext: Context) : PagerAdapter() {

    private val TAG = this::class.java.simpleName

    lateinit var rv_in_progress : RecyclerView
    lateinit var rv_completed : RecyclerView

    val arrayList1 = ArrayList<TaskModel>()
    val arrayList2 = ArrayList<TaskModel>()


    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val modelObject = AuthModel.values()[position]
        val inflater = LayoutInflater.from(mContext)
        val layout = inflater.inflate(modelObject.layoutResId, collection, false) as ViewGroup

        val inProgressAdapter = InProgressAdapter(arrayList1, mContext)

        if (position == 0)
        {

            for (i in 0 until 4) {
                val itemModel = TaskModel()
                itemModel.task_name = "Task " + i
                itemModel.task_date = "18-Aug-2020"

                arrayList1.add(itemModel)
            }

            rv_in_progress = layout.findViewById(R.id.rv_in_progress)
            rv_in_progress.setLayoutManager(LinearLayoutManager(mContext))
            rv_in_progress.adapter = inProgressAdapter

            object : SwipeHelper(mContext, rv_in_progress) {

                override fun instantiateUnderlayButton(
                    viewHolder: RecyclerView.ViewHolder,
                    list: MutableList<UnderlayButton>
                ) {
                    list.add(
                        UnderlayButton(mContext.resources.getString(R.string.done), 0, Color.parseColor("#8ae08d"),
                            object : UnderlayButtonClickListener {
                                override fun onClick(pos: Int) {

                                    arrayList2.add(arrayList1[pos])
                                    arrayList1.removeAt(pos)

                                    inProgressAdapter.notifyDataSetChanged()

                                    val completedAdapter = CompletedAdapter(arrayList2, mContext)
                                    rv_completed.adapter = completedAdapter

                                }
                            })
                    )
                }
            }.attachSwipe()

        } else if (position == 1) {

            rv_completed = layout.findViewById(R.id.rv_completed)
            rv_completed.setLayoutManager(LinearLayoutManager(mContext))

        }

        collection.addView(layout)
        return layout
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int {
        return AuthModel.values().size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getPageTitle(position: Int): CharSequence {
        val customPagerEnum = AuthModel.values()[position]
        return mContext.getString(customPagerEnum.titleResId)
    }

}