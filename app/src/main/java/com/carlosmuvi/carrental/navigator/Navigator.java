package com.carlosmuvi.carrental.navigator;

import android.app.Activity;
import android.content.Intent;
import com.carlosmuvi.carrental.constants.BundleConstants;
import com.carlosmuvi.carrental.rentalcarlist.RentalCarListActivity;
import javax.inject.Inject;
import org.joda.time.DateTime;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public class Navigator {

    private Activity activity;

    @Inject public Navigator(Activity activity) {
        this.activity = activity;
    }

    public void navigateToCarRentalList(DateTime pickup, DateTime dropoff, String location) {
        Intent intent = new Intent(activity, RentalCarListActivity.class);
        intent.putExtra(BundleConstants.PICKUP_DATETIME, pickup);
        intent.putExtra(BundleConstants.DROPOFF_DATETIME, dropoff);
        intent.putExtra(BundleConstants.LOCATION, location);
        activity.startActivity(intent);
    }
}
