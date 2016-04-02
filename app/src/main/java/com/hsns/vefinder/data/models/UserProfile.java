package com.hsns.vefinder.data.models;

import com.facebook.AccessToken;
import com.facebook.Profile;

/**
 * Created by SENEY SEAN on 3/30/16.
 */
public class UserProfile {

    public static String getAvatar() {
        if (Profile.getCurrentProfile() == null) return "";
        return (Profile.getCurrentProfile() == null) ? "" : Profile.getCurrentProfile().getProfilePictureUri(75, 75).toString();
    }

    public static String getUserId() {
        return (AccessToken.getCurrentAccessToken() == null) ? "" : AccessToken.getCurrentAccessToken().getUserId();
    }

    public static String getDisplayName() {
        return (Profile.getCurrentProfile() == null) ? "" : Profile.getCurrentProfile().getName();
    }

    public static String getFirstName() {
        return (Profile.getCurrentProfile() == null) ? "" : Profile.getCurrentProfile().getFirstName();
    }

    public static String getLastName() {
        return (Profile.getCurrentProfile() == null) ? "" : Profile.getCurrentProfile().getLastName();
    }

}
