package com.studiographene.lawyerly.basecode.common;

import android.os.Handler;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.content.ContentValues.TAG;

public abstract class BaseDiffAdapter<I> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    protected List<I> list = new ArrayList<I>();
    protected List<String> itemsPendingRemovalId = new ArrayList<>();
    protected List<Integer> pendingIndexes = new ArrayList<>();

    private static final int PENDING_REMOVAL_TIMEOUT = 3000;

    HashMap<String, Runnable> pendingRunnables = new HashMap<>();
    private Handler handler = new Handler(); // hanlder for running delayed runnables


    public interface SwipeLiseners<I> {

        void onItemSwiped(I item, int type);

    }


    protected DiffUtil.Callback callback;


    private View emptyView;

    SwipeLiseners<I> swipeLiseners;

    public SwipeLiseners<I> getSwipeLiseners() {
        return swipeLiseners;
    }

    public void setSwipeLiseners(SwipeLiseners<I> swipeLiseners) {
        this.swipeLiseners = swipeLiseners;
    }

    protected void checkItems(){
        if(emptyView != null){

            if(list.size() == 0){
                emptyView.setVisibility(View.VISIBLE);
            }else{
                emptyView.setVisibility(View.GONE);
            }

        }

    }


    public void swapItems(List<I> actors) {
        final DiffUtil.Callback diffCallback = getCallback(actors);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);


        itemsPendingRemovalId.clear();

        checkPendingRemains();

        this.list.clear();

        pendingIndexes.clear();

        this.list.addAll(actors);
        diffResult.dispatchUpdatesTo(this);
        checkItems();
    }


    void checkPendingRemains(){


        for(int i = 0 ; i < pendingIndexes.size();i++){
            int pendingIndexindex = pendingIndexes.get(i);
            //itemsPendingRemovalId.remove(i);
            notifyItemChanged(pendingIndexindex);

        }
    }





//    public void addPending(int index){
//
//        String primaryId = getPrimaryId(list.get(index));
//        if(primaryId != null && !itemsPendingRemovalId.contains(primaryId)){
//            itemsPendingRemovalId.add(primaryId);
//            pendingIndexes.add(index);
//
//
//            notifyItemChanged(index);
//
//            checkItems();
//
//
//        }
//
//        if(itemsPendingRemovalId.contains(primaryId)){
//            // there is already undo showing
//            notifyItemChanged(index);
//
//        }
//
//        // let's create, store and post a runnable to remove the item
//        Runnable pendingRemovalRunnable = new Runnable() {
//            @Override
//            public void run() {
//                remove(primaryId);
//            }
//        };
//        handler.postDelayed(pendingRemovalRunnable, PENDING_REMOVAL_TIMEOUT);
//        pendingRunnables.put(primaryId, pendingRemovalRunnable);
//
//
////
//
////
//
//    }


    public void remove(String primaryId) {



        if(itemsPendingRemovalId.contains(primaryId)){
            int index = currentIndexOfPrimaryId(primaryId);
            if(index > -1){

                if(swipeLiseners != null){
                    swipeLiseners.onItemSwiped(list.get(index) , 0);
                }
                list.remove(index);
                notifyItemRemoved(index);
                int index_ = itemsPendingRemovalId.indexOf(primaryId);
                itemsPendingRemovalId.remove(index_);
                pendingIndexes.remove(index_);
                checkItems();

            }

        }

    }


    int currentIndexOfPrimaryId(String primaryId){

        int i = -1;
        for(I item : list){
            i++;

            if(getPrimaryId(item).equals(primaryId)){
                return i;
            }
        }

        return -1;

    }

    public void undoItem(String primaryId ){

        Log.d(TAG, "undoItem: "+primaryId);


        Runnable pendingRemovalRunnable = pendingRunnables.get(primaryId);
        pendingRunnables.remove(primaryId);
        if (pendingRemovalRunnable != null) handler.removeCallbacks(pendingRemovalRunnable);

        print();
        if(itemsPendingRemovalId.contains(primaryId)){
            int index = itemsPendingRemovalId.indexOf(primaryId);
            int pendingIndexindex = pendingIndexes.get(index);
            itemsPendingRemovalId.remove(index);
            pendingIndexes.remove(index);
            notifyItemChanged(pendingIndexindex);
            Log.d(TAG, "undoItem: "+primaryId +" , "+ index+" , "+pendingIndexindex);

        }



    }


    void print(){
        for (int i : pendingIndexes){
            Log.d(TAG, "print: "+i);
        }
        for (String i : itemsPendingRemovalId){
            Log.d(TAG, "print: "+i);
        }
    }







    protected abstract String getPrimaryId(I item);

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    protected abstract DiffUtil.Callback getCallback(List<I> actors);


    public View getEmptyView() {
        return emptyView;
    }

    public void setEmptyView(View emptyView) {
        this.emptyView = emptyView;
    }


}
