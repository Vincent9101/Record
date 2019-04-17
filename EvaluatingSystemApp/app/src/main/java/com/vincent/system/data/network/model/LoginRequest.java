package com.vincent.system.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    private LoginRequest() {
        // This class is not publicly instantiable
    }


    public static class ServerLoginRequest {

        @Expose
        @SerializedName("account")
        private String account;

        @Expose
        @SerializedName("password")
        private String password;

        public ServerLoginRequest(String account, String password) {
            this.account = account;
            this.password = password;
        }

        @Override
        public String toString() {
            return "ServerLoginRequest{" +
                    "account='" + account + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ServerLoginRequest that = (ServerLoginRequest) o;

            if (account != null ? !account.equals(that.account) : that.account != null) return false;
            return password != null ? password.equals(that.password) : that.password == null;
        }

        @Override
        public int hashCode() {
            int result = account != null ? account.hashCode() : 0;
            result = 31 * result + (password != null ? password.hashCode() : 0);
            return result;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }


}
