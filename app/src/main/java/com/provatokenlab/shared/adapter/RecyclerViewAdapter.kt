package com.provatokenlab.shared.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

abstract class RecyclerViewAdapter<T : RecyclerView.ViewHolder, O> protected constructor(private var mObjectList: List<O>) : RecyclerView.Adapter<T>() {

    private var mDisposableView = CompositeDisposable()
    private var mOnItemClickListener: OnItemClickListener<O>? = null

    override fun getItemCount(): Int {
        return mObjectList.size
    }

    fun getItem(position: Int): O {
        return mObjectList[position]
    }

    fun createItemClick(view: View, holder: T): T {

        mDisposableView.add(
            RxView.clicks(view)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe {
                    onItemClick(holder)
                }
        )
        return holder
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener<O>) {
        this.mOnItemClickListener = onItemClickListener
    }

    fun onItemClick(holder: T) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener!!.onItemClick(mObjectList[holder.adapterPosition], holder.adapterPosition)
        }
    }

    interface OnItemClickListener<O> {
        fun onItemClick(item: O, position: Int)
    }

    fun clear() {
        mDisposableView.clear()
    }

}