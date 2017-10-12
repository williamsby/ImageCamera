package com.example.willi.imagecamera;

import java.io.Serializable;

/**
 * Created by willi on 10/11/2017.
 */

public class FotoModel implements Serializable{
    private String _id;
    private String nama;
    private String path;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
