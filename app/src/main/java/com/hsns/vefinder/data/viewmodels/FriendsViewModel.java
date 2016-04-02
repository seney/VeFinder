package com.hsns.vefinder.data.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;

import com.hsns.vefinder.BR;
import com.hsns.vefinder.R;
import com.hsns.vefinder.data.binders.FriendBinder;

import net.droidlabs.mvvm.recyclerview.adapter.binder.CompositeItemBinder;
import net.droidlabs.mvvm.recyclerview.adapter.binder.ItemBinder;

/**
 * Created by seneyhsns on 4/2/16.
 */
public class FriendsViewModel extends BaseObservable {
    @Bindable
    public ObservableArrayList<FriendViewModel> items;

    public FriendsViewModel() {
        items = new ObservableArrayList<>();
    }

    public void addItem(FriendViewModel item) {
        this.items.add(item);
    }

    public void removeItem(FriendViewModel item) {
        this.items.remove(item);
    }

    public int size() {
        return this.items.size();
    }

    public ItemBinder<FriendViewModel> itemViewBinder(){
        return new CompositeItemBinder<>(new FriendBinder(BR.item, R.layout.item_friend));
    }
}
