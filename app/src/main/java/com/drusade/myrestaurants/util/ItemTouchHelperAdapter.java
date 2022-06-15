package com.drusade.myrestaurants.util;

public interface ItemTouchHelperAdapter {

    //move item by dragging
    boolean onItemMove(int fromPosition, int toPosition);

    //dismiss with swipe motion
    void onItemDismiss(int position);
}

