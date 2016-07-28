package com.carlosmuvi.carrental.rentalcarsearchform;

import org.joda.time.DateTime;

/**
 * Created by carlosmuvi on 28/07/16.
 */
public class DateTimeWrapper {
    DateTime dateTime = new DateTime();
    boolean alreadyPicked = false;

    public boolean isAlreadyPicked() {
        return alreadyPicked;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setAlreadyPicked(boolean alreadyPicked) {
        this.alreadyPicked = alreadyPicked;
    }

    public DateTime getDateTime() {
        return dateTime;
    }
}
