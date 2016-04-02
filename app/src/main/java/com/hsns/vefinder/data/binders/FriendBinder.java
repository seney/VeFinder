package com.hsns.vefinder.data.binders;

import com.hsns.vefinder.data.viewmodels.FriendViewModel;

import net.droidlabs.mvvm.recyclerview.adapter.binder.CompositeItemBinder;
import net.droidlabs.mvvm.recyclerview.adapter.binder.ConditionalDataBinder;

/**
 * Created by seneyhsns on 4/2/16.
 */
public class FriendBinder extends ConditionalDataBinder<FriendViewModel> {
    public FriendBinder(int bindingVariable, int layoutId) {
        super(bindingVariable, layoutId);
    }

    @Override
    public boolean canHandle(FriendViewModel model) {
        return true;
    }
}
