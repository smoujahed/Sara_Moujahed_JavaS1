package com.company;

public interface SecureStorable extends Storable {

        public void encryptData();

        public void decryptData();
}
