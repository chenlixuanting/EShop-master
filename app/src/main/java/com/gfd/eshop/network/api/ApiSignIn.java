package com.gfd.eshop.network.api;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.gfd.eshop.network.core.ApiPath;
import com.gfd.eshop.network.core.ApiInterface;
import com.gfd.eshop.network.core.RequestParam;
import com.gfd.eshop.network.core.ResponseEntity;
import com.gfd.eshop.network.entity.Session;
import com.gfd.eshop.network.entity.User;
import com.google.gson.annotations.SerializedName;


/**
 * 服务器接口: 用户登录.
 */
public class ApiSignIn implements ApiInterface {

    private final Req mReq;

    public ApiSignIn(@NonNull String name,
                     @NonNull String password) {
        mReq = new Req();
        mReq.mName = name;
        mReq.mPassword = password;
    }

    @NonNull
    @Override
    public String getPath() {
        return ApiPath.USER_SIGNIN;
    }

    @Nullable
    @Override
    public RequestParam getRequestParam() {
        return mReq;
    }

    @NonNull
    @Override
    public Class<? extends ResponseEntity> getResponseType() {
        return Rsp.class;
    }

    public static class Req extends RequestParam {
        @SerializedName("name")
        private String mName;
        @SerializedName("password")
        private String mPassword;

        @Override
        protected int sessionUsage() {
            return SESSION_NO_NEED;
        }
    }

    public static class Rsp extends ResponseEntity {

        @SerializedName("data")
        Data mData;

        public Data getData() {
            return mData;
        }

        public static class Data {
            @SerializedName("session")
            private Session mSession;
            @SerializedName("user")
            private User mUser;

            public Session getSession() {
                return mSession;
            }

            public User getUser() {
                return mUser;
            }
        }
    }
}
