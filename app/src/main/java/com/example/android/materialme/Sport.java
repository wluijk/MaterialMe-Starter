/*
 * Copyright (C) 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.materialme;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Data model for each row of the RecyclerView.
 */
class Sport implements Parcelable {

    private final int imageResource;

    //Member variables representing the title and information about the sport
    private String title;
    private String info;

    /**
     * Constructor for the Sport data model
     * @param title The name if the sport.
     * @param info Information about the sport.
     * @param imageResource Information about the sport.
     */
    Sport(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    /**
     * Gets the title of the sport
     * @return The title of the sport.
     */
    String getTitle() {
        return title;
    }

    /**
     * Gets the info about the sport
     * @return The info about the sport.
     */
    String getInfo() {
        return info;
    }

    int getImageResource() {
        return imageResource;
    }

    protected Sport(Parcel in) {
        this.imageResource = in.readInt();
        this.title = in.readString();
        this.info = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //
        dest.writeInt(this.imageResource);

        //
        dest.writeString(this.title);

        //
        dest.writeString(this.info);
    }

    public static final Creator<Sport> CREATOR = new Creator<Sport>() {
        public Sport createFromParcel(Parcel source) {
            return new Sport(source);
        }
        public Sport[] newArray(int size) {
            return new Sport[size];
        }
    };
}
