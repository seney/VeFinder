package com.hsns.vefinder.data.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.hsns.vefinder.BR;
import com.hsns.vefinder.data.models.Friend;

/**
 * Created by seneyhsns on 4/2/16.
 */
public class FriendViewModel extends BaseObservable {
    private Friend model;

    @Bindable
    public Friend getModel(){
        return model;
    }

    public void setModel(Friend model){
        this.model = model;
        notifyPropertyChanged(BR.model);
    }
    @Bindable
    public String getFirstName(){
        return this.model.getFirstName();
    }

    public void setFirstName(String firstName){
        this.model.setFirstName(firstName);
        notifyPropertyChanged(BR.firstName);
    }
    @Bindable
    public String getLastName(){
        return this.model.getLastName();
    }

    public void  setLastName(String lastName){
        this.model.setLastName(lastName);
        notifyPropertyChanged(BR.lastName);
    }
    @Bindable
    public String getDisplayName(){
        return this.model.getDisplayName();
    }

    public void setDisplayName(String displayName){
        this.model.setDisplayName(displayName);
        notifyPropertyChanged(BR.displayName);
    }
}
