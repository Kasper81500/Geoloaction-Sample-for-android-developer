package pf.paranoidfan.com.paranoidfan.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by KasperStar on 8/30/2016.
 */
public class GroupMessageResponse {
    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("data")
    @Expose
    public GroupMessageModel[] data;
}